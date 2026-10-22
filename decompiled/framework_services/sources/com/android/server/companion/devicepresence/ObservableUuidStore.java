package com.android.server.companion.devicepresence;

import android.os.ParcelUuid;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.companion.utils.DataStoreUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class ObservableUuidStore {
    private static final String FILE_NAME = "observing_uuids_presence.xml";
    private static final int READ_FROM_DISK_TIMEOUT = 5;
    private static final String TAG = "CDM_ObservableUuidStore";
    private static final String XML_ATTR_PACKAGE = "package_name";
    private static final String XML_ATTR_TIME_APPROVED = "time_approved";
    private static final String XML_ATTR_USER_ID = "user_id";
    private static final String XML_ATTR_UUID = "uuid";
    private static final String XML_TAG_UUID = "uuid";
    private static final String XML_TAG_UUIDS = "uuids";
    private final SparseArray<List<ObservableUuid>> mCachedPerUser;
    private final ExecutorService mExecutor;
    private final Object mLock;
    private final ConcurrentMap<Integer, AtomicFile> mUserIdToStorageFile;

    /* JADX INFO: renamed from: $r8$lambda$19pmv1qe7glm4vF-NbNUjxdJIDQ, reason: not valid java name */
    public static /* synthetic */ AtomicFile m2965$r8$lambda$19pmv1qe7glm4vFNbNUjxdJIDQ(int r0, Integer r1) {
        return lambda$getStorageFileForUser$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$DVc2thXL5gZgZ_PVQ1-LOjleU7s, reason: not valid java name */
    public static /* synthetic */ boolean m2966$r8$lambda$DVc2thXL5gZgZ_PVQ1LOjleU7s(String r0, ParcelUuid r1, ObservableUuid r2) {
        return lambda$removeObservableUuid$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$JKNU0nOf42AlvLeZKjEhitNkVo4(ObservableUuidStore r0, int r1, List r2) {
        r0.lambda$removeObservableUuid$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$NGtLz9-dcgx8IrEYfAwGcR2eiTg, reason: not valid java name */
    public static /* synthetic */ void m2967$r8$lambda$NGtLz9dcgx8IrEYfAwGcR2eiTg(ObservableUuidStore r0, int r1, List r2) {
        r0.lambda$writeObservableUuid$3(r1, r2);
    }

    public static /* synthetic */ List $r8$lambda$NdC96mPJG9b5JcWBTiBEd0kWk_Q(ObservableUuidStore r0, int r1) {
        return r0.lambda$readObservableUuidsFromCache$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ry-m7_0LwMjl0rHjfebkLTv8fHY, reason: not valid java name */
    public static /* synthetic */ void m2968$r8$lambda$Rym7_0LwMjl0rHjfebkLTv8fHY(ObservableUuidStore r0, List r1, FileOutputStream r2) {
        r0.lambda$writeObservableUuidToStore$4(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$W2JVjeckgUqBHF3J4bnKnhW96gI(ObservableUuid r0, ObservableUuid r1) {
        return lambda$writeObservableUuid$2(r0, r1);
    }

    public ObservableUuidStore() {
        this.mUserIdToStorageFile = new ConcurrentHashMap();
        this.mLock = new Object();
        this.mCachedPerUser = new SparseArray();
        this.mExecutor = Executors.newSingleThreadExecutor();
    }

    public void removeObservableUuid(final int userId, final ParcelUuid uuid, final String packageName) {
        Slog.i(TAG, "Removing uuid=[" + uuid.getUuid() + "] from store...");
        Object r0 = this.mLock;
        monitor-enter(r0);
        final List<ObservableUuid> cachedObservableUuids = readObservableUuidsFromCache(userId);     // Catch: Throwable -> L8
        cachedObservableUuids.removeIf(new ObservableUuidStore$$ExternalSyntheticLambda4(packageName, uuid));     // Catch: Throwable -> L8
        this.mCachedPerUser.set(userId, cachedObservableUuids);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mExecutor.execute(new ObservableUuidStore$$ExternalSyntheticLambda5(this, userId, cachedObservableUuids));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeObservableUuid$0(String packageName, ParcelUuid uuid, ObservableUuid uuid1) {
        if (uuid1.getPackageName().equals(packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (uuid1.getUuid().equals(uuid) == false) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$removeObservableUuid$1(int userId, List cachedObservableUuids) {
        writeObservableUuidToStore(userId, cachedObservableUuids);
    }

    public void writeObservableUuid(final int userId, final ObservableUuid uuid) {
        Slog.i(TAG, "Writing uuid=[" + uuid.getUuid() + "] to store...");
        Object r0 = this.mLock;
        monitor-enter(r0);
        final List<ObservableUuid> cachedObservableUuids = readObservableUuidsFromCache(userId);     // Catch: Throwable -> L8
        cachedObservableUuids.removeIf(new ObservableUuidStore$$ExternalSyntheticLambda1(uuid));     // Catch: Throwable -> L8
        cachedObservableUuids.add(uuid);     // Catch: Throwable -> L8
        this.mCachedPerUser.set(userId, cachedObservableUuids);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mExecutor.execute(new ObservableUuidStore$$ExternalSyntheticLambda2(this, userId, cachedObservableUuids));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$writeObservableUuid$2(ObservableUuid uuid, ObservableUuid uuid1) {
        if (uuid1.getUuid().equals(uuid.getUuid()) == true) goto L5;
    L7:
        return false;
    L5:
        if (uuid1.getPackageName().equals(uuid.getPackageName()) == false) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$writeObservableUuid$3(int userId, List cachedObservableUuids) {
        writeObservableUuidToStore(userId, cachedObservableUuids);
    }

    private void writeObservableUuidToStore(int userId, final List<ObservableUuid> cachedObservableUuids) {
        AtomicFile file = getStorageFileForUser(userId);
        Slog.i(TAG, "Writing ObservableUuid for user " + userId + " to file=" + file.getBaseFile().getPath());
        monitor-enter(file);
        DataStoreUtils.writeToFileSafely(file, new ObservableUuidStore$$ExternalSyntheticLambda3(this, cachedObservableUuids));     // Catch: Throwable -> L7
        monitor-exit(file);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$writeObservableUuidToStore$4(List cachedObservableUuids, FileOutputStream out) throws Exception {
        TypedXmlSerializer serializer = Xml.resolveSerializer(out);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        serializer.startDocument(null, true);
        writeObservableUuidToXml(serializer, cachedObservableUuids);
        serializer.endDocument();
    }

    private void writeObservableUuidToXml(TypedXmlSerializer serializer, Collection<ObservableUuid> uuids) throws IOException {
        serializer.startTag(null, XML_TAG_UUIDS);
        Iterator<ObservableUuid> r2 = uuids.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ObservableUuid uuid = r2.next();
        writeUuidToXml(serializer, uuid);
        goto L4
    L6:
        serializer.endTag(null, XML_TAG_UUIDS);
    }

    private void writeUuidToXml(TypedXmlSerializer serializer, ObservableUuid uuid) throws IOException {
        serializer.startTag(null, "uuid");
        XmlUtils.writeIntAttribute(serializer, XML_ATTR_USER_ID, uuid.getUserId());
        XmlUtils.writeStringAttribute(serializer, "uuid", uuid.getUuid().toString());
        XmlUtils.writeStringAttribute(serializer, XML_ATTR_PACKAGE, uuid.getPackageName());
        XmlUtils.writeLongAttribute(serializer, XML_ATTR_TIME_APPROVED, uuid.getTimeApprovedMs());
        serializer.endTag(null, "uuid");
    }

    private List<ObservableUuid> readObservableUuidsFromCache(final int userId) {
        List<ObservableUuid> cachedObservableUuids = this.mCachedPerUser.get(userId);
        if (cachedObservableUuids != null) goto L18;
        Future<List<ObservableUuid>> future = this.mExecutor.submit(new ObservableUuidStore$$ExternalSyntheticLambda0(this, userId));
        cachedObservableUuids = future.get(5, TimeUnit.SECONDS);     // Catch: TimeoutException -> L8 ExecutionException -> L10 InterruptedException -> L12
    L17:
        this.mCachedPerUser.set(userId, cachedObservableUuids);
        goto L18
    L16:
        Slog.e(TAG, "Thread reading ObservableUuid from disk is interrupted.");
    L15:
        Slog.e(TAG, "Error occurred while reading ObservableUuid from disk.");
    L14:
        Slog.e(TAG, "Reading ObservableUuid from disk timed out.");
    L18:
        if (cachedObservableUuids != null) goto L21;
        return new ArrayList();
    L21:
        return cachedObservableUuids;
    }

    private /* synthetic */ List lambda$readObservableUuidsFromCache$5(int userId) throws Exception {
        return readObservableUuidFromStore(userId);
    }

    public List<ObservableUuid> readObservableUuidFromStore(int userId) {
        AtomicFile file = getStorageFileForUser(userId);
        Slog.i(TAG, "Reading ObservableUuid for user " + userId + " from file=" + file.getBaseFile().getPath());
        monitor-enter(file);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (file.getBaseFile().exists() == true) goto L39;
        Slog.d(TAG, "File does not exist -> Abort");     // Catch: Throwable -> L9
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L9
        monitor-exit(file);     // Catch: Throwable -> L9
        return r1;
    L39:
        FileInputStream in = file.openRead();     // Catch: Throwable -> L9 Throwable -> L16
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L20
        XmlUtils.beginDocument(parser, XML_TAG_UUIDS);     // Catch: Throwable -> L20
        List<ObservableUuid> r3 = readObservableUuidFromXml(parser);     // Catch: Throwable -> L20
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
        Slog.e(TAG, "Error while reading requests file", e);     // Catch: Throwable -> L9
        return new ArrayList();
    }

    private List<ObservableUuid> readObservableUuidFromXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_UUIDS) == false) goto L12;
        List<ObservableUuid> observableUuids = new ArrayList();
    L5:
        parser.nextTag();
        if (DataStoreUtils.isEndOfTag(parser, XML_TAG_UUIDS) == true) goto L7;
        if (DataStoreUtils.isStartOfTag(parser, "uuid") == false) goto L5;
        observableUuids.add(readUuidFromXml(parser));
        goto L5
    L7:
        return observableUuids;
    L12:
        throw new XmlPullParserException("The XML doesn't have start tag: uuids");
    }

    private ObservableUuid readUuidFromXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        if (DataStoreUtils.isStartOfTag(parser, "uuid") == false) goto L7;
        int userId = XmlUtils.readIntAttribute(parser, XML_ATTR_USER_ID);
        ParcelUuid uuid = ParcelUuid.fromString(XmlUtils.readStringAttribute(parser, "uuid"));
        String packageName = XmlUtils.readStringAttribute(parser, XML_ATTR_PACKAGE);
        Long timeApproved = Long.valueOf(XmlUtils.readLongAttribute(parser, XML_ATTR_TIME_APPROVED));
        return new ObservableUuid(userId, uuid, packageName, timeApproved);
    L7:
        throw new XmlPullParserException("XML doesn't have start tag: uuid");
    }

    private AtomicFile getStorageFileForUser(final int userId) {
        return this.mUserIdToStorageFile.computeIfAbsent(Integer.valueOf(userId), new ObservableUuidStore$$ExternalSyntheticLambda6(userId));
    }

    private static /* synthetic */ AtomicFile lambda$getStorageFileForUser$6(int userId, Integer u) {
        return DataStoreUtils.createStorageFileForUser(userId, FILE_NAME);
    }

    public List<ObservableUuid> getObservableUuidsForPackage(int userId, String packageName) {
        List<ObservableUuid> uuidsTobeObservedPerPackage = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        List<ObservableUuid> uuids = readObservableUuidsFromCache(userId);     // Catch: Throwable -> L10
        Iterator<ObservableUuid> r3 = uuids.iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L13;
        ObservableUuid uuid = r3.next();     // Catch: Throwable -> L10
        if (uuid.getPackageName().equals(packageName) == false) goto L6;
        uuidsTobeObservedPerPackage.add(uuid);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return uuidsTobeObservedPerPackage;
    L10:
        th = move-exception;
        throw th;
    }

    public List<ObservableUuid> getObservableUuidsForUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<ObservableUuid> r1 = readObservableUuidsFromCache(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isUuidBeingObserved(ParcelUuid uuid, int userId, String packageName) {
        List<ObservableUuid> uuidsBeingObserved = getObservableUuidsForPackage(userId, packageName);
        Iterator<ObservableUuid> r1 = uuidsBeingObserved.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        ObservableUuid observableUuid = r1.next();
        if (observableUuid.getUuid().equals(uuid) == false) goto L4;
        return true;
    L10:
        return false;
    }
}
