package com.android.server.companion.association;

import android.companion.AssociationInfo;
import android.companion.DeviceId;
import android.graphics.drawable.Icon;
import android.net.MacAddress;
import android.os.Environment;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.companion.utils.AssociationUtils;
import com.android.server.companion.utils.DataStoreUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public final class AssociationDiskStore {
    private static final int CURRENT_PERSISTENCE_VERSION = 1;
    private static final String FILE_NAME = "companion_device_manager.xml";
    private static final String FILE_NAME_LAST_REMOVED_ASSOCIATION = "last_removed_association.txt";
    private static final String FILE_NAME_LEGACY = "companion_device_manager_associations.xml";
    private static final String LEGACY_XML_ATTR_DEVICE = "device";
    private static final String TAG = "CDM_AssociationDiskStore";
    private static final String XML_ATTR_CUSTOM_DEVICE_ID = "custom_device_id";
    private static final String XML_ATTR_DEVICE_ICON = "device_icon";
    private static final String XML_ATTR_DISPLAY_NAME = "display_name";
    private static final String XML_ATTR_ID = "id";
    private static final String XML_ATTR_LAST_TIME_CONNECTED = "last_time_connected";
    private static final String XML_ATTR_MAC_ADDRESS = "mac_address";
    private static final String XML_ATTR_MAC_ADDRESS_DEVICE_ID = "mac_address_device_id";
    private static final String XML_ATTR_MAX_ID = "max-id";
    private static final String XML_ATTR_NOTIFY_DEVICE_NEARBY = "notify_device_nearby";
    private static final String XML_ATTR_PACKAGE = "package";
    private static final String XML_ATTR_PENDING = "pending";
    private static final String XML_ATTR_PERSISTENCE_VERSION = "persistence-version";
    private static final String XML_ATTR_PROFILE = "profile";
    private static final String XML_ATTR_REVOKED = "revoked";
    private static final String XML_ATTR_SELF_MANAGED = "self_managed";
    private static final String XML_ATTR_SYSTEM_DATA_SYNC_FLAGS = "system_data_sync_flags";
    private static final String XML_ATTR_TIME_APPROVED = "time_approved";
    private static final String XML_TAG_ASSOCIATION = "association";
    private static final String XML_TAG_ASSOCIATIONS = "associations";
    private static final String XML_TAG_DEVICE_ID = "device_id";
    private static final String XML_TAG_STATE = "state";
    private final ConcurrentMap<Integer, AtomicFile> mUserIdToStorageFile;

    public static /* synthetic */ AtomicFile $r8$lambda$0QKtIp2TLTUbzaZrI1CW9x255a4(int r0, Integer r1) {
        return lambda$getStorageFileForUser$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$TnrFtwENJfNpOrWI1q61kXcsqzI(Associations r0, FileOutputStream r1) {
        lambda$writeAssociationsToFile$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$pfoZln9Xdz-m2W4C7yoN47XzFzE, reason: not valid java name */
    public static /* synthetic */ void m2901$r8$lambda$pfoZln9Xdzm2W4C7yoN47XzFzE(String r0, AssociationInfo r1, FileOutputStream r2) {
        lambda$writeLastRemovedAssociation$0(r0, r1, r2);
    }

    public AssociationDiskStore() {
        this.mUserIdToStorageFile = new ConcurrentHashMap();
    }

    public Map<Integer, Associations> readAssociationsByUsers(List<Integer> userIds) {
        Map<Integer, Associations> userToAssociationsMap = new HashMap();
        Iterator<Integer> r1 = userIds.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        int userId = r1.next().intValue();
        userToAssociationsMap.put(Integer.valueOf(userId), readAssociationsByUser(userId));
        goto L4
    L6:
        return userToAssociationsMap;
    }

    private Associations readAssociationsByUser(int userId) {
        Slog.i(TAG, "Reading associations for user " + userId + " from disk.");
        AtomicFile file = getStorageFileForUser(userId);
        monitor-enter(file);
        File legacyBaseFile = null;
    L12:
        th = move-exception;
        throw th;
    L6:
        if (file.getBaseFile().exists() == true) goto L15;
        legacyBaseFile = getBaseLegacyStorageFileForUser(userId);     // Catch: Throwable -> L12
        if (legacyBaseFile.exists() == true) goto L14;
        Associations r2 = new Associations();     // Catch: Throwable -> L12
        monitor-exit(file);     // Catch: Throwable -> L12
        return r2;
    L14:
        AtomicFile readFrom = new AtomicFile(legacyBaseFile);     // Catch: Throwable -> L12
        String rootTag = XML_TAG_ASSOCIATIONS;
    L16:
        Associations associations = readAssociationsFromFile(userId, readFrom, rootTag);     // Catch: Throwable -> L12
        if (legacyBaseFile == null) goto L19;
    L20:
        writeAssociationsToFile(file, associations);     // Catch: Throwable -> L12
        if (legacyBaseFile == null) goto L23;
        legacyBaseFile.delete();     // Catch: Throwable -> L12
    L23:
        monitor-exit(file);     // Catch: Throwable -> L12
        return associations;
    L19:
        if (associations.getVersion() >= 1) goto L23;
    L15:
        readFrom = file;
        rootTag = "state";
        goto L16
    }

    public void writeAssociationsForUser(int userId, Associations associations) {
        Slog.i(TAG, "Writing associations for user " + userId + " to disk");
        AtomicFile file = getStorageFileForUser(userId);
        monitor-enter(file);
        writeAssociationsToFile(file, associations);     // Catch: Throwable -> L7
        monitor-exit(file);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String readLastRemovedAssociation(int userId) {
        AtomicFile file = DataStoreUtils.createStorageFileForUser(userId, FILE_NAME_LAST_REMOVED_ASSOCIATION);
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = file.openRead();     // Catch: IOException -> L12 FileNotFoundException -> L14
    L27:
        int c = fis.read();     // Catch: Throwable -> L7
        if (c == (-1)) goto L9;
        sb.append((char) c);     // Catch: Throwable -> L7
        goto L27
    L9:
        fis.close();     // Catch: Throwable -> L7
        String r6 = sb.toString();     // Catch: Throwable -> L7
        fis.close();     // Catch: IOException -> L12 FileNotFoundException -> L14
        return r6;
    L7:
        th = move-exception;
        if (fis != null) goto L29;
    L22:
        throw th;     // Catch: IOException -> L12 FileNotFoundException -> L14
    L29:
        fis.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12 FileNotFoundException -> L14
        goto L22
    L25:
        Slog.e(TAG, "File " + file + " for user=" + userId + " doesn't exist.");
        return null;
    L23:
        Slog.e(TAG, "Can't read file " + file + " for user=" + userId);
        return null;
    }

    public void writeLastRemovedAssociation(AssociationInfo association, final String reason) {
        Slog.i(TAG, "Writing last removed association=" + association.getId() + " to disk...");
        AssociationInfo.Builder builder = new AssociationInfo.Builder(association).setDeviceMacAddress(null);
        if (association.getDisplayName() != null) goto L5;
        builder.setDisplayName("");
    L5:
        final AssociationInfo redactedAssociation = builder.build();
        AtomicFile file = DataStoreUtils.createStorageFileForUser(redactedAssociation.getUserId(), FILE_NAME_LAST_REMOVED_ASSOCIATION);
        DataStoreUtils.writeToFileSafely(file, new AssociationDiskStore$$ExternalSyntheticLambda2(reason, redactedAssociation));
    }

    private static /* synthetic */ void lambda$writeLastRemovedAssociation$0(String reason, AssociationInfo redactedAssociation, FileOutputStream out) throws Exception {
        out.write(String.valueOf(System.currentTimeMillis()).getBytes());
        out.write(32);
        out.write(reason.getBytes());
        out.write(32);
        out.write(redactedAssociation.toString().getBytes());
    }

    private static Associations readAssociationsFromFile(int userId, AtomicFile file, String rootTag) {
        FileInputStream in = file.openRead();     // Catch: Throwable -> L7
        Associations r1 = readAssociationsFromInputStream(userId, in, rootTag);     // Catch: Throwable -> L10
        if (in == null) goto L9;
        in.close();     // Catch: Throwable -> L7 Throwable -> L7
    L9:
        return r1;
    L10:
        th = move-exception;
        if (in != null) goto L22;
    L17:
        throw th;     // Catch: Throwable -> L7 Throwable -> L7
    L22:
        in.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L7 Throwable -> L7
    L7:
        e = move-exception;
        Slog.e(TAG, "Error while reading associations file", e);
        return new Associations();
    }

    private static Associations readAssociationsFromInputStream(int userId, InputStream in, String rootTag) throws XmlPullParserException, IOException {
        TypedXmlPullParser parser = Xml.resolvePullParser(in);
        XmlUtils.beginDocument(parser, rootTag);
        int version = XmlUtils.readIntAttribute(parser, XML_ATTR_PERSISTENCE_VERSION, 0);
        Associations associations = new Associations();
        switch(version) {
            case 0: goto L12;
            case 1: goto L5;
            default: goto L19;
        };
    L5:
        parser.nextTag();
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_ASSOCIATIONS) == true) goto L7;
        if (DataStoreUtils.isEndOfTag(parser, rootTag) == false) goto L5;
        return associations;
    L7:
        associations = readAssociationsV1(parser, userId);
        goto L5
    L19:
        return associations;
    L12:
        return readAssociationsV0(parser, userId);
    }

    private void writeAssociationsToFile(AtomicFile file, final Associations associations) {
        DataStoreUtils.writeToFileSafely(file, new AssociationDiskStore$$ExternalSyntheticLambda0(associations));
    }

    private static /* synthetic */ void lambda$writeAssociationsToFile$1(Associations associations, FileOutputStream out) throws Exception {
        TypedXmlSerializer serializer = Xml.resolveSerializer(out);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        serializer.startDocument(null, true);
        serializer.startTag(null, "state");
        XmlUtils.writeIntAttribute(serializer, XML_ATTR_PERSISTENCE_VERSION, 1);
        writeAssociations(serializer, associations);
        serializer.endTag(null, "state");
        serializer.endDocument();
    }

    private AtomicFile getStorageFileForUser(final int userId) {
        return this.mUserIdToStorageFile.computeIfAbsent(Integer.valueOf(userId), new AssociationDiskStore$$ExternalSyntheticLambda1(userId));
    }

    private static /* synthetic */ AtomicFile lambda$getStorageFileForUser$2(int userId, Integer u) {
        return DataStoreUtils.createStorageFileForUser(userId, FILE_NAME);
    }

    public byte[] getBackupPayload(int userId) {
        Slog.i(TAG, "Fetching stored state data for user " + userId + " from disk");
        AtomicFile file = getStorageFileForUser(userId);
        monitor-enter(file);
        byte[] r1 = DataStoreUtils.fileToByteArray(file);     // Catch: Throwable -> L7
        monitor-exit(file);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Associations readAssociationsFromPayload(byte[] payload, int userId) {
        ByteArrayInputStream in = new ByteArrayInputStream(payload);     // Catch: Throwable -> L6
        Associations r1 = readAssociationsFromInputStream(userId, in, "state");     // Catch: Throwable -> L8
        in.close();     // Catch: Throwable -> L6 Throwable -> L6
        return r1;
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
        Slog.e(TAG, "Error while reading associations file", e);
        return new Associations();
    }

    private static File getBaseLegacyStorageFileForUser(int userId) {
        return new File(Environment.getUserSystemDirectory(userId), FILE_NAME_LEGACY);
    }

    private static Associations readAssociationsV0(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        requireStartOfTag(parser, XML_TAG_ASSOCIATIONS);
        int associationId = AssociationUtils.getFirstAssociationIdForUser(userId);
        Associations associations = new Associations();
        associations.setVersion(0);
    L3:
        parser.nextTag();
        if (DataStoreUtils.isEndOfTag(parser, XML_TAG_ASSOCIATIONS) == true) goto L5;
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_ASSOCIATION) == false) goto L3;
        associations.addAssociation(readAssociationV0(parser, userId, associationId));
        associationId = associationId + 1;
        goto L3
    L5:
        associations.setMaxId(associationId - 1);
        return associations;
    }

    private static AssociationInfo readAssociationV0(TypedXmlPullParser parser, int userId, int associationId) throws XmlPullParserException {
        requireStartOfTag(parser, XML_TAG_ASSOCIATION);
        String appPackage = XmlUtils.readStringAttribute(parser, "package");
        String deviceAddress = XmlUtils.readStringAttribute(parser, LEGACY_XML_ATTR_DEVICE);
        String profile = XmlUtils.readStringAttribute(parser, XML_ATTR_PROFILE);
        boolean notify = XmlUtils.readBooleanAttribute(parser, XML_ATTR_NOTIFY_DEVICE_NEARBY);
        long timeApproved = XmlUtils.readLongAttribute(parser, XML_ATTR_TIME_APPROVED, 0);
        return new AssociationInfo(associationId, userId, appPackage, MacAddress.fromString(deviceAddress), null, profile, null, false, notify, false, false, timeApproved, Long.MAX_VALUE, 0, null, null);
    }

    private static Associations readAssociationsV1(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        requireStartOfTag(parser, XML_TAG_ASSOCIATIONS);
        int maxId = XmlUtils.readIntAttribute(parser, XML_ATTR_MAX_ID, 0);
        Associations associations = new Associations();
        associations.setVersion(1);
    L3:
        parser.nextTag();
        if (DataStoreUtils.isEndOfTag(parser, XML_TAG_ASSOCIATIONS) == true) goto L5;
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_ASSOCIATION) == false) goto L3;
        AssociationInfo association = readAssociationV1(parser, userId);
        associations.addAssociation(association);
        maxId = Math.max(maxId, association.getId());
        goto L3
    L5:
        associations.setMaxId(maxId);
        return associations;
    }

    private static AssociationInfo readAssociationV1(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        requireStartOfTag(parser, XML_TAG_ASSOCIATION);
        int associationId = XmlUtils.readIntAttribute(parser, XML_ATTR_ID);
        String profile = XmlUtils.readStringAttribute(parser, XML_ATTR_PROFILE);
        String appPackage = XmlUtils.readStringAttribute(parser, "package");
        MacAddress macAddress = stringToMacAddress(XmlUtils.readStringAttribute(parser, XML_ATTR_MAC_ADDRESS));
        String displayName = XmlUtils.readStringAttribute(parser, XML_ATTR_DISPLAY_NAME);
        boolean selfManaged = XmlUtils.readBooleanAttribute(parser, XML_ATTR_SELF_MANAGED);
        boolean notify = XmlUtils.readBooleanAttribute(parser, XML_ATTR_NOTIFY_DEVICE_NEARBY);
        boolean revoked = XmlUtils.readBooleanAttribute(parser, "revoked", false);
        boolean pending = XmlUtils.readBooleanAttribute(parser, XML_ATTR_PENDING, false);
        long timeApproved = XmlUtils.readLongAttribute(parser, XML_ATTR_TIME_APPROVED, 0);
        long lastTimeConnected = XmlUtils.readLongAttribute(parser, XML_ATTR_LAST_TIME_CONNECTED, Long.MAX_VALUE);
        int systemDataSyncFlags = XmlUtils.readIntAttribute(parser, XML_ATTR_SYSTEM_DATA_SYNC_FLAGS, 0);
        Icon deviceIcon = byteArrayToIcon(XmlUtils.readByteArrayAttribute(parser, XML_ATTR_DEVICE_ICON));
        parser.nextTag();
        DeviceId deviceId = readDeviceId(parser);
        return new AssociationInfo(associationId, userId, appPackage, macAddress, displayName, profile, null, selfManaged, notify, revoked, pending, timeApproved, lastTimeConnected, systemDataSyncFlags, deviceIcon, deviceId);
    }

    private static DeviceId readDeviceId(TypedXmlPullParser parser) throws XmlPullParserException {
        if (DataStoreUtils.isStartOfTag(parser, XML_TAG_DEVICE_ID) == false) goto L6;
        String customDeviceId = XmlUtils.readStringAttribute(parser, XML_ATTR_CUSTOM_DEVICE_ID);
        MacAddress macAddress = stringToMacAddress(XmlUtils.readStringAttribute(parser, XML_ATTR_MAC_ADDRESS_DEVICE_ID));
        return new DeviceId(customDeviceId, macAddress);
    L6:
        return null;
    }

    private static void writeAssociations(XmlSerializer parent, Associations associations) throws IOException {
        XmlSerializer serializer = parent.startTag(null, XML_TAG_ASSOCIATIONS);
        XmlUtils.writeIntAttribute(serializer, XML_ATTR_MAX_ID, associations.getMaxId());
        Iterator<AssociationInfo> r3 = associations.getAssociations().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        AssociationInfo association = r3.next();
        writeAssociation(serializer, association);
        goto L4
    L6:
        serializer.endTag(null, XML_TAG_ASSOCIATIONS);
    }

    private static void writeAssociation(XmlSerializer parent, AssociationInfo a) throws IOException {
        XmlSerializer serializer = parent.startTag(null, XML_TAG_ASSOCIATION);
        XmlUtils.writeIntAttribute(serializer, XML_ATTR_ID, a.getId());
        XmlUtils.writeStringAttribute(serializer, XML_ATTR_PROFILE, a.getDeviceProfile());
        XmlUtils.writeStringAttribute(serializer, "package", a.getPackageName());
        XmlUtils.writeStringAttribute(serializer, XML_ATTR_MAC_ADDRESS, a.getDeviceMacAddressAsString());
        XmlUtils.writeStringAttribute(serializer, XML_ATTR_DISPLAY_NAME, a.getDisplayName());
        XmlUtils.writeBooleanAttribute(serializer, XML_ATTR_SELF_MANAGED, a.isSelfManaged());
        XmlUtils.writeBooleanAttribute(serializer, XML_ATTR_NOTIFY_DEVICE_NEARBY, a.isNotifyOnDeviceNearby());
        XmlUtils.writeBooleanAttribute(serializer, "revoked", a.isRevoked());
        XmlUtils.writeBooleanAttribute(serializer, XML_ATTR_PENDING, a.isPending());
        XmlUtils.writeLongAttribute(serializer, XML_ATTR_TIME_APPROVED, a.getTimeApprovedMs());
        XmlUtils.writeLongAttribute(serializer, XML_ATTR_LAST_TIME_CONNECTED, a.getLastTimeConnectedMs());
        XmlUtils.writeIntAttribute(serializer, XML_ATTR_SYSTEM_DATA_SYNC_FLAGS, a.getSystemDataSyncFlags());
        XmlUtils.writeByteArrayAttribute(serializer, XML_ATTR_DEVICE_ICON, iconToByteArray(a.getDeviceIcon()));
        writeDeviceId(serializer, a);
        serializer.endTag(null, XML_TAG_ASSOCIATION);
    }

    private static void writeDeviceId(XmlSerializer parent, AssociationInfo a) throws IOException {
        if (a.getDeviceId() == null) goto L6;
        XmlSerializer serializer = parent.startTag(null, XML_TAG_DEVICE_ID);
        XmlUtils.writeStringAttribute(serializer, XML_ATTR_CUSTOM_DEVICE_ID, a.getDeviceId().getCustomId());
        XmlUtils.writeStringAttribute(serializer, XML_ATTR_MAC_ADDRESS_DEVICE_ID, a.getDeviceId().getMacAddressAsString());
        serializer.endTag(null, XML_TAG_DEVICE_ID);
        return;
    }

    private static void requireStartOfTag(XmlPullParser parser, String tag) throws XmlPullParserException {
        if (DataStoreUtils.isStartOfTag(parser, tag) == false) goto L6;
        return;
    L6:
        throw new XmlPullParserException("Should be at the start of \"" + tag + "\" tag");
    }

    private static MacAddress stringToMacAddress(String address) {
        if (address != null) goto L6;
        return null;
    L6:
        return MacAddress.fromString(address);
    }

    private static byte[] iconToByteArray(Icon deviceIcon) throws IOException {
        if (deviceIcon != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        deviceIcon.writeToStream(byteStream);
        return byteStream.toByteArray();
    }

    private static Icon byteArrayToIcon(byte[] bytes) throws IOException {
        if (bytes != null) goto L5;
        return null;
    L5:
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        return Icon.createFromStream(byteStream);
    }
}
