package com.android.server.companion.datatransfer;

import android.companion.datatransfer.PermissionSyncRequest;
import android.companion.datatransfer.SystemDataTransferRequest;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.companion.utils.DataStoreUtils;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SystemDataTransferRequestStore {
    private static final String FILE_NAME = "companion_device_system_data_transfer_requests.xml";
    private static final String LOG_TAG = "CDM_SystemDataTransferRequestStore";
    private static final int READ_FROM_DISK_TIMEOUT = 5;
    private static final String XML_ATTR_ASSOCIATION_ID = "association_id";
    private static final String XML_ATTR_DATA_TYPE = "data_type";
    private static final String XML_ATTR_IS_USER_CONSENTED = "is_user_consented";
    private static final String XML_TAG_REQUEST = "request";
    private static final String XML_TAG_REQUESTS = "requests";
    private final SparseArray<ArrayList<SystemDataTransferRequest>> mCachedPerUser;
    private final ExecutorService mExecutor;
    private final Object mLock;
    private final ConcurrentMap<Integer, AtomicFile> mUserIdToStorageFile;

    public static /* synthetic */ boolean $r8$lambda$5taD8HtqQx_TdsBO1XvKJtRu3YM(SystemDataTransferRequest r0, SystemDataTransferRequest r1) {
        return lambda$writeRequest$0(r0, r1);
    }

    public static /* synthetic */ AtomicFile $r8$lambda$CRkESvFXCDHSZsMzCtczGUM7PMw(int r0, Integer r1) {
        return lambda$getStorageFileForUser$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$dhcwOYHvES4JdjQCRjCFzRfdBsg(SystemDataTransferRequestStore r0, int r1, ArrayList r2) {
        r0.lambda$removeRequestsByAssociationId$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$iWecMWNrVgfRpSSC_C8Ths2ai1Y(SystemDataTransferRequestStore r0, int r1, ArrayList r2) {
        r0.lambda$writeRequest$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$j7eLeRTTVdy1vREABg8b4iWB1Nc(SystemDataTransferRequestStore r0, List r1, FileOutputStream r2) {
        r0.lambda$writeRequestsToStore$5(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ktAFHwYJAMDBKTL8f-wTA3vqkHk, reason: not valid java name */
    public static /* synthetic */ ArrayList m2922$r8$lambda$ktAFHwYJAMDBKTL8fwTA3vqkHk(SystemDataTransferRequestStore r0, int r1) {
        return r0.lambda$readRequestsFromCache$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tG8_5sF4Tu-2lZgyk3TuZyKj63U, reason: not valid java name */
    public static /* synthetic */ boolean m2923$r8$lambda$tG8_5sF4Tu2lZgyk3TuZyKj63U(int r0, SystemDataTransferRequest r1) {
        return lambda$removeRequestsByAssociationId$2(r0, r1);
    }

    public SystemDataTransferRequestStore() {
        this.mUserIdToStorageFile = new ConcurrentHashMap();
        this.mLock = new Object();
        this.mCachedPerUser = new SparseArray();
        this.mExecutor = Executors.newSingleThreadExecutor();
    }

    public List<SystemDataTransferRequest> readRequestsByAssociationId(int userId, int associationId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<SystemDataTransferRequest> cachedRequests = readRequestsFromCache(userId);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        List<SystemDataTransferRequest> requestsByAssociationId = new ArrayList();
        Iterator<SystemDataTransferRequest> r2 = cachedRequests.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        SystemDataTransferRequest request = r2.next();
        if (request.getAssociationId() != associationId) goto L8;
        requestsByAssociationId.add(request);
        goto L8
    L13:
        return requestsByAssociationId;
    L14:
        th = move-exception;
        throw th;
    }

    public void writeRequest(final int userId, final SystemDataTransferRequest request) {
        Slog.i(LOG_TAG, "Writing request=" + request + " to store.");
        Object r0 = this.mLock;
        monitor-enter(r0);
        final ArrayList<SystemDataTransferRequest> cachedRequests = readRequestsFromCache(userId);     // Catch: Throwable -> L8
        cachedRequests.removeIf(new SystemDataTransferRequestStore$$ExternalSyntheticLambda5(request));     // Catch: Throwable -> L8
        cachedRequests.add(request);     // Catch: Throwable -> L8
        this.mCachedPerUser.set(userId, cachedRequests);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mExecutor.execute(new SystemDataTransferRequestStore$$ExternalSyntheticLambda6(this, userId, cachedRequests));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$writeRequest$0(SystemDataTransferRequest request, SystemDataTransferRequest request1) {
        if (request1.getAssociationId() != request.getAssociationId()) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$writeRequest$1(int userId, ArrayList cachedRequests) {
        writeRequestsToStore(userId, cachedRequests);
    }

    public void removeRequestsByAssociationId(final int userId, final int associationId) {
        Slog.i(LOG_TAG, "Removing system data transfer requests for userId=" + userId + ", associationId=" + associationId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        final ArrayList<SystemDataTransferRequest> cachedRequests = readRequestsFromCache(userId);     // Catch: Throwable -> L8
        cachedRequests.removeIf(new SystemDataTransferRequestStore$$ExternalSyntheticLambda0(associationId));     // Catch: Throwable -> L8
        this.mCachedPerUser.set(userId, cachedRequests);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mExecutor.execute(new SystemDataTransferRequestStore$$ExternalSyntheticLambda1(this, userId, cachedRequests));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeRequestsByAssociationId$2(int associationId, SystemDataTransferRequest request) {
        if (request.getAssociationId() != associationId) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$removeRequestsByAssociationId$3(int userId, ArrayList cachedRequests) {
        writeRequestsToStore(userId, cachedRequests);
    }

    public byte[] getBackupPayload(int userId) {
        AtomicFile file = getStorageFileForUser(userId);
        monitor-enter(file);
        byte[] r1 = DataStoreUtils.fileToByteArray(file);     // Catch: Throwable -> L7
        monitor-exit(file);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SystemDataTransferRequest> readRequestsFromPayload(byte[] payload, int userId) {
        ByteArrayInputStream in = new ByteArrayInputStream(payload);     // Catch: Throwable -> L6
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L8
        XmlUtils.beginDocument(parser, XML_TAG_REQUESTS);     // Catch: Throwable -> L8
        ArrayList<SystemDataTransferRequest> r2 = readRequestsFromXml(parser, userId);     // Catch: Throwable -> L8
        in.close();     // Catch: Throwable -> L6 Throwable -> L6
        return r2;
    L8:
        th = move-exception;
        in.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L6 Throwable -> L6
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6 Throwable -> L6
    L6:
        e = move-exception;
        Slog.e(LOG_TAG, "Error while reading requests file", e);
        return new ArrayList();
    }

    private ArrayList<SystemDataTransferRequest> readRequestsFromCache(final int userId) {
        ArrayList<SystemDataTransferRequest> cachedRequests = this.mCachedPerUser.get(userId);
        if (cachedRequests != null) goto L18;
        Future<ArrayList<SystemDataTransferRequest>> future = this.mExecutor.submit(new SystemDataTransferRequestStore$$ExternalSyntheticLambda2(this, userId));
        cachedRequests = future.get(5, TimeUnit.SECONDS);     // Catch: TimeoutException -> L8 ExecutionException -> L10 InterruptedException -> L12
    L17:
        this.mCachedPerUser.set(userId, cachedRequests);
        goto L18
    L16:
        Slog.e(LOG_TAG, "Thread reading SystemDataTransferRequest from disk is interrupted.");
    L15:
        Slog.e(LOG_TAG, "Error occurred while reading SystemDataTransferRequest from disk.");
    L14:
        Slog.e(LOG_TAG, "Reading SystemDataTransferRequest from disk timed out.");
    L18:
        return cachedRequests;
    }

    private /* synthetic */ ArrayList lambda$readRequestsFromCache$4(int userId) throws Exception {
        return readRequestsFromStore(userId);
    }

    private ArrayList<SystemDataTransferRequest> readRequestsFromStore(int userId) {
        AtomicFile file = getStorageFileForUser(userId);
        Slog.i(LOG_TAG, "Reading SystemDataTransferRequests for user " + userId + " from file=" + file.getBaseFile().getPath());
        monitor-enter(file);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (file.getBaseFile().exists() == true) goto L39;
        Slog.d(LOG_TAG, "File does not exist -> Abort");     // Catch: Throwable -> L9
        ArrayList<SystemDataTransferRequest> r1 = new ArrayList();     // Catch: Throwable -> L9
        monitor-exit(file);     // Catch: Throwable -> L9
        return r1;
    L39:
        FileInputStream in = file.openRead();     // Catch: Throwable -> L9 Throwable -> L16
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L20
        XmlUtils.beginDocument(parser, XML_TAG_REQUESTS);     // Catch: Throwable -> L20
        ArrayList<SystemDataTransferRequest> r3 = readRequestsFromXml(parser, userId);     // Catch: Throwable -> L20
        if (in == null) goto L18;
        in.close();     // Catch: Throwable -> L9 Throwable -> L16 Throwable -> L16
    L18:
        monitor-exit(file);     // Catch: Throwable -> L9
        return r3;
    L20:
        th = move-exception;
        if (in != null) goto L37;
    L27:
        throw th;     // Catch: Throwable -> L9 Throwable -> L16 Throwable -> L16
    L37:
        in.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 Throwable -> L16 Throwable -> L16
    L16:
        e = move-exception;
        Slog.e(LOG_TAG, "Error while reading requests file", e);     // Catch: Throwable -> L9
        return new ArrayList();
    }

    private ArrayList<SystemDataTransferRequest> readRequestsFromXml(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_REQUESTS) == false) goto L12;
        ArrayList<SystemDataTransferRequest> requests = new ArrayList();
    L5:
        parser.nextTag();
        if (DataStoreUtils.isEndOfTag(parser, XML_TAG_REQUESTS) == true) goto L7;
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_REQUEST) == false) goto L5;
        requests.add(readRequestFromXml(parser, userId));
        goto L5
    L7:
        return requests;
    L12:
        throw new XmlPullParserException("The XML doesn't have start tag: requests");
    }

    private SystemDataTransferRequest readRequestFromXml(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_REQUEST) == false) goto L11;
        int associationId = XmlUtils.readIntAttribute(parser, XML_ATTR_ASSOCIATION_ID);
        int dataType = XmlUtils.readIntAttribute(parser, XML_ATTR_DATA_TYPE);
        boolean isUserConsented = XmlUtils.readBooleanAttribute(parser, XML_ATTR_IS_USER_CONSENTED);
        switch(dataType) {
            case 1: goto L8;
            default: goto L6;
        };
    L6:
        return null;
    L8:
        PermissionSyncRequest request = new PermissionSyncRequest(associationId);
        request.setUserId(userId);
        request.setUserConsented(isUserConsented);
        return request;
    L11:
        throw new XmlPullParserException("XML doesn't have start tag: request");
    }

    void writeRequestsToStore(int userId, final List<SystemDataTransferRequest> requests) {
        AtomicFile file = getStorageFileForUser(userId);
        Slog.i(LOG_TAG, "Writing SystemDataTransferRequests for user " + userId + " to file=" + file.getBaseFile().getPath());
        monitor-enter(file);
        DataStoreUtils.writeToFileSafely(file, new SystemDataTransferRequestStore$$ExternalSyntheticLambda3(this, requests));     // Catch: Throwable -> L7
        monitor-exit(file);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$writeRequestsToStore$5(List requests, FileOutputStream out) throws Exception {
        TypedXmlSerializer serializer = Xml.resolveSerializer(out);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        serializer.startDocument(null, true);
        writeRequestsToXml(serializer, requests);
        serializer.endDocument();
    }

    public void dump(PrintWriter out) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        out.append("System Data Transfer Requests (Cached): ");     // Catch: Throwable -> L7
        if (this.mCachedPerUser.size() != 0) goto L9;
        out.append("<empty>\n");     // Catch: Throwable -> L7
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        out.append("\n");     // Catch: Throwable -> L7
        int i = 0;
    L11:
        if (i >= this.mCachedPerUser.size()) goto L17;
        int userId = this.mCachedPerUser.keyAt(i);     // Catch: Throwable -> L7
        Iterator<SystemDataTransferRequest> r3 = this.mCachedPerUser.get(userId).iterator();     // Catch: Throwable -> L7
    L14:
        if (r3.hasNext() == false) goto L16;
        SystemDataTransferRequest request = r3.next();     // Catch: Throwable -> L7
        out.append("  u").append(String.valueOf(userId)).append(" -> ").append(request.toString()).append('\n');     // Catch: Throwable -> L7
        goto L14
    L16:
        i = i + 1;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void writeRequestsToXml(TypedXmlSerializer serializer, Collection<SystemDataTransferRequest> requests) throws IOException {
        serializer.startTag(null, XML_TAG_REQUESTS);
        Iterator<SystemDataTransferRequest> r2 = requests.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        SystemDataTransferRequest request = r2.next();
        writeRequestToXml(serializer, request);
        goto L4
    L6:
        serializer.endTag(null, XML_TAG_REQUESTS);
    }

    private void writeRequestToXml(TypedXmlSerializer serializer, SystemDataTransferRequest request) throws IOException {
        serializer.startTag(null, XML_TAG_REQUEST);
        XmlUtils.writeIntAttribute(serializer, XML_ATTR_ASSOCIATION_ID, request.getAssociationId());
        XmlUtils.writeIntAttribute(serializer, XML_ATTR_DATA_TYPE, request.getDataType());
        XmlUtils.writeBooleanAttribute(serializer, XML_ATTR_IS_USER_CONSENTED, request.isUserConsented());
        serializer.endTag(null, XML_TAG_REQUEST);
    }

    private AtomicFile getStorageFileForUser(final int userId) {
        return this.mUserIdToStorageFile.computeIfAbsent(Integer.valueOf(userId), new SystemDataTransferRequestStore$$ExternalSyntheticLambda4(userId));
    }

    private static /* synthetic */ AtomicFile lambda$getStorageFileForUser$6(int userId, Integer u) {
        return DataStoreUtils.createStorageFileForUser(userId, FILE_NAME);
    }
}
