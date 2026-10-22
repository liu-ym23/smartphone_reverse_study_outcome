package com.android.server.devicepolicy;

import android.content.ComponentName;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.Preconditions;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class TransferOwnershipMetadataManager {
    static final String ADMIN_TYPE_DEVICE_OWNER = "device-owner";
    static final String ADMIN_TYPE_PROFILE_OWNER = "profile-owner";
    public static final String OWNER_TRANSFER_METADATA_XML = "owner-transfer-metadata.xml";
    private static final String TAG = null;
    static final String TAG_ADMIN_TYPE = "admin-type";
    static final String TAG_SOURCE_COMPONENT = "source-component";
    static final String TAG_TARGET_COMPONENT = "target-component";
    static final String TAG_USER_ID = "user-id";
    private final Injector mInjector;

    static class Injector {
        Injector() {
        }

        public File getOwnerTransferMetadataDir() {
            return Environment.getDataSystemDirectory();
        }
    }

    static class Metadata {
        final String adminType;
        final ComponentName sourceComponent;
        final ComponentName targetComponent;
        final int userId;

        Metadata(ComponentName sourceComponent, ComponentName targetComponent, int userId, String adminType) {
            this.sourceComponent = sourceComponent;
            this.targetComponent = targetComponent;
            sourceComponent.getClass();
            targetComponent.getClass();
            Preconditions.checkStringNotEmpty(adminType);
            this.userId = userId;
            this.adminType = adminType;
        }

        Metadata(String flatSourceComponent, String flatTargetComponent, int userId, String adminType) {
            this(unflattenComponentUnchecked(flatSourceComponent), unflattenComponentUnchecked(flatTargetComponent), userId, adminType);
        }

        private static ComponentName unflattenComponentUnchecked(String flatComponent) {
            flatComponent.getClass();
            return ComponentName.unflattenFromString(flatComponent);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Metadata) == true) goto L5;
            return false;
        L5:
            Metadata params = (Metadata) obj;
            if (this.userId == params.userId) goto L8;
            return false;
        L8:
            if (this.sourceComponent.equals(params.sourceComponent) == true) goto L10;
            return false;
        L10:
            if (this.targetComponent.equals(params.targetComponent) == true) goto L12;
            return false;
        L12:
            if (TextUtils.equals(this.adminType, params.adminType) == false) goto L19;
            return true;
        L19:
            return false;
        }

        public int hashCode() {
            int hashCode = (1 * 31) + this.userId;
            return (((((hashCode * 31) + this.sourceComponent.hashCode()) * 31) + this.targetComponent.hashCode()) * 31) + this.adminType.hashCode();
        }
    }

    static {
        TAG = TransferOwnershipMetadataManager.class.getName();
    }

    TransferOwnershipMetadataManager() {
        this(new Injector());
    }

    TransferOwnershipMetadataManager(Injector injector) {
        this.mInjector = injector;
    }

    boolean saveMetadataFile(Metadata params) {
        File transferOwnershipMetadataFile = new File(this.mInjector.getOwnerTransferMetadataDir(), OWNER_TRANSFER_METADATA_XML);
        AtomicFile atomicFile = new AtomicFile(transferOwnershipMetadataFile);
        FileOutputStream stream = null;
        stream = atomicFile.startWrite();     // Catch: IOException -> L5
        TypedXmlSerializer serializer = Xml.resolveSerializer(stream);     // Catch: IOException -> L5
        serializer.startDocument(null, true);     // Catch: IOException -> L5
        insertSimpleTag(serializer, TAG_USER_ID, Integer.toString(params.userId));     // Catch: IOException -> L5
        insertSimpleTag(serializer, TAG_SOURCE_COMPONENT, params.sourceComponent.flattenToString());     // Catch: IOException -> L5
        insertSimpleTag(serializer, TAG_TARGET_COMPONENT, params.targetComponent.flattenToString());     // Catch: IOException -> L5
        insertSimpleTag(serializer, TAG_ADMIN_TYPE, params.adminType);     // Catch: IOException -> L5
        serializer.endDocument();     // Catch: IOException -> L5
        atomicFile.finishWrite(stream);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        Slog.e(TAG, "Caught exception while trying to save Owner Transfer Params to file " + transferOwnershipMetadataFile, e);
        transferOwnershipMetadataFile.delete();
        atomicFile.failWrite(stream);
        return false;
    }

    private void insertSimpleTag(TypedXmlSerializer serializer, String tagName, String value) throws IOException {
        serializer.startTag(null, tagName);
        serializer.text(value);
        serializer.endTag(null, tagName);
    }

    Metadata loadMetadataFile() {
        File transferOwnershipMetadataFile = new File(this.mInjector.getOwnerTransferMetadataDir(), OWNER_TRANSFER_METADATA_XML);
        if (transferOwnershipMetadataFile.exists() == true) goto L5;
        return null;
    L5:
        Slog.d(TAG, "Loading TransferOwnershipMetadataManager from " + transferOwnershipMetadataFile);
        FileInputStream stream = new FileInputStream(transferOwnershipMetadataFile);     // Catch: Throwable -> L10
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L12
        Metadata r4 = parseMetadataFile(parser);     // Catch: Throwable -> L12
        stream.close();     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
        return r4;
    L12:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "Caught exception while trying to load the owner transfer params from file " + transferOwnershipMetadataFile, e);
        return null;
    }

    private Metadata parseMetadataFile(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        int userId = 0;
        String adminComponent = null;
        String targetComponent = null;
        String adminType = null;
    L3:
        int type = parser.next();
        byte r7 = 1;
        if (type == 1) goto L38;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String r8 = parser.getName();
        switch(r8.hashCode()) {
            case -337219647: goto L27;
            case -147180963: goto L24;
            case 281362891: goto L21;
            case 641951480: goto L18;
            default: goto L29;
        };
    L29:
        r7 = -1;
    L30:
        switch(r7) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            default: goto L3;
        };
    L32:
        parser.next();
        adminType = parser.getText();
        goto L3
    L33:
        parser.next();
        adminComponent = parser.getText();
        goto L3
    L34:
        parser.next();
        targetComponent = parser.getText();
        goto L3
    L35:
        parser.next();
        userId = Integer.parseInt(parser.getText());
        goto L3
    L18:
        if (r8.equals(TAG_ADMIN_TYPE) == false) goto L29;
        r7 = 3;
        goto L30
    L21:
        if (r8.equals(TAG_SOURCE_COMPONENT) == false) goto L29;
        r7 = 2;
        goto L30
    L24:
        if (r8.equals(TAG_USER_ID) == false) goto L29;
        r7 = 0;
        goto L30
    L27:
        if (r8.equals(TAG_TARGET_COMPONENT) == false) goto L29;
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L38:
        return new Metadata(adminComponent, targetComponent, userId, adminType);
    }

    void deleteMetadataFile() {
        new File(this.mInjector.getOwnerTransferMetadataDir(), OWNER_TRANSFER_METADATA_XML).delete();
    }

    boolean metadataFileExists() {
        return new File(this.mInjector.getOwnerTransferMetadataDir(), OWNER_TRANSFER_METADATA_XML).exists();
    }
}
