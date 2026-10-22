package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class ExtraFieldUtils {
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = null;

    public static final class UnparseableExtraField {
        public static final UnparseableExtraField READ = null;
        public static final int READ_KEY = 2;
        public static final UnparseableExtraField SKIP = null;
        public static final int SKIP_KEY = 1;
        public static final UnparseableExtraField THROW = null;
        public static final int THROW_KEY = 0;
        private final int key;

        static {
            THROW = new UnparseableExtraField(0);
            SKIP = new UnparseableExtraField(1);
            READ = new UnparseableExtraField(2);
        }

        private UnparseableExtraField(int k) {
            this.key = k;
        }

        public int getKey() {
            return this.key;
        }
    }

    public ExtraFieldUtils() {
    }

    static {
        implementations = new ConcurrentHashMap();
        register(AsiExtraField.class);
        register(X5455_ExtendedTimestamp.class);
        register(X7875_NewUnix.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
        register(X000A_NTFS.class);
        register(X0014_X509Certificates.class);
        register(X0015_CertificateIdForFile.class);
        register(X0016_CertificateIdForCentralDirectory.class);
        register(X0017_StrongEncryptionHeader.class);
        register(X0019_EncryptionRecipientCertificateList.class);
        register(ResourceAlignmentExtraField.class);
    }

    public static void register(Class<?> c) {
        ZipExtraField ze = (ZipExtraField) c.newInstance();     // Catch: IllegalAccessException -> L4 InstantiationException -> L6 ClassCastException -> L8
        implementations.put(ze.getHeaderId(), c);     // Catch: IllegalAccessException -> L4 InstantiationException -> L6 ClassCastException -> L8
        return;
    L15:
        throw new RuntimeException(c + " doesn't implement ZipExtraField");
    L11:
        throw new RuntimeException(c + "'s no-arg constructor is not public");
    L13:
        throw new RuntimeException(c + " is not a concrete class");
    }

    public static ZipExtraField createExtraField(ZipShort headerId) throws InstantiationException, IllegalAccessException {
        Class<?> c = implementations.get(headerId);
        if (c != null) goto L5;
        UnrecognizedExtraField u = new UnrecognizedExtraField();
        u.setHeaderId(headerId);
        return u;
    L5:
        return (ZipExtraField) c.newInstance();
    }

    public static ZipExtraField[] parse(byte[] data) throws ZipException {
        return parse(data, true, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] data, boolean local) throws ZipException {
        return parse(data, local, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] data, boolean local, UnparseableExtraField onUnparseableData) throws ZipException {
        List<ZipExtraField> v = new ArrayList();
        int start = 0;
    L4:
        if (start > (data.length - 4)) goto L34;
        ZipShort headerId = new ZipShort(data, start);
        int length = new ZipShort(data, start + 2).getValue();
        if (((start + 4) + length) > data.length) goto L8;
        ZipExtraField ze = createExtraField(headerId);     // Catch: Throwable -> L23
        if (local == true) goto L36;
        ze.parseFromCentralDirectoryData(data, start + 4, length);     // Catch: Throwable -> L23 Throwable -> L23 ArrayIndexOutOfBoundsException -> L25
    L29:
        v.add(ze);     // Catch: Throwable -> L23 Throwable -> L23
        start = start + (length + 4);     // Catch: Throwable -> L23 Throwable -> L23
        goto L4
    L36:
        ze.parseFromLocalFileData(data, start + 4, length);     // Catch: Throwable -> L23 Throwable -> L23 ArrayIndexOutOfBoundsException -> L25
    L25:
        aiobe = move-exception;
        throw ((ZipException) new ZipException("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(headerId.getValue())).initCause(aiobe));     // Catch: Throwable -> L23 Throwable -> L23
    L23:
        ie = move-exception;
        throw ((ZipException) new ZipException(ie.getMessage()).initCause(ie));
    L8:
        switch(onUnparseableData.getKey()) {
            case 0: goto L17;
            case 1: goto L34;
            case 2: goto L11;
            default: goto L10;
        };
    L11:
        UnparseableExtraFieldData field = new UnparseableExtraFieldData();
        if (local == false) goto L14;
        field.parseFromLocalFileData(data, start, data.length - start);
    L15:
        v.add(field);
        goto L34
    L14:
        field.parseFromCentralDirectoryData(data, start, data.length - start);
        goto L15
    L17:
        StringBuilder r5 = new StringBuilder();
        r5.append("bad extra field starting at ");
        r5.append(start);
        r5.append(".  Block length of ");
        r5.append(length);
        r5.append(" bytes exceeds remaining data of ");
        r5.append((data.length - start) - 4);
        r5.append(" bytes.");
        throw new ZipException(r5.toString());
    L10:
        throw new ZipException("unknown UnparseableExtraField key: " + onUnparseableData.getKey());
    L34:
        ZipExtraField[] result = new ZipExtraField[v.size()];
        return (ZipExtraField[]) v.toArray(result);
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] data) {
        if (data.length > 0) goto L5;
    L7:
        boolean lastIsUnparseableHolder = false;
    L8:
        int regularExtraFieldCount = data.length;
        if (lastIsUnparseableHolder == false) goto L11;
        regularExtraFieldCount = regularExtraFieldCount - 1;
    L11:
        int sum = regularExtraFieldCount * 4;
        int r5 = data.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        ZipExtraField element = data[r6];
        sum = sum + element.getLocalFileDataLength().getValue();
        r6 = r6 + 1;
        goto L12
    L14:
        byte[] result = new byte[sum];
        int start = 0;
        int i = 0;
    L15:
        if (i >= regularExtraFieldCount) goto L21;
        System.arraycopy(data[i].getHeaderId().getBytes(), 0, result, start, 2);
        System.arraycopy(data[i].getLocalFileDataLength().getBytes(), 0, result, start + 2, 2);
        start = start + 4;
        byte[] local = data[i].getLocalFileDataData();
        if (local == null) goto L19;
        System.arraycopy(local, 0, result, start, local.length);
        start = start + local.length;
    L19:
        i = i + 1;
        goto L15
    L21:
        if (lastIsUnparseableHolder == false) goto L25;
        byte[] local2 = data[data.length - 1].getLocalFileDataData();
        if (local2 == null) goto L25;
        System.arraycopy(local2, 0, result, start, local2.length);
    L25:
        return result;
    L5:
        if ((data[data.length - 1] instanceof UnparseableExtraFieldData) == false) goto L7;
        lastIsUnparseableHolder = true;
        goto L8
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] data) {
        if (data.length > 0) goto L5;
    L7:
        boolean lastIsUnparseableHolder = false;
    L8:
        int regularExtraFieldCount = data.length;
        if (lastIsUnparseableHolder == false) goto L11;
        regularExtraFieldCount = regularExtraFieldCount - 1;
    L11:
        int sum = regularExtraFieldCount * 4;
        int r5 = data.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        ZipExtraField element = data[r6];
        sum = sum + element.getCentralDirectoryLength().getValue();
        r6 = r6 + 1;
        goto L12
    L14:
        byte[] result = new byte[sum];
        int start = 0;
        int i = 0;
    L15:
        if (i >= regularExtraFieldCount) goto L21;
        System.arraycopy(data[i].getHeaderId().getBytes(), 0, result, start, 2);
        System.arraycopy(data[i].getCentralDirectoryLength().getBytes(), 0, result, start + 2, 2);
        start = start + 4;
        byte[] local = data[i].getCentralDirectoryData();
        if (local == null) goto L19;
        System.arraycopy(local, 0, result, start, local.length);
        start = start + local.length;
    L19:
        i = i + 1;
        goto L15
    L21:
        if (lastIsUnparseableHolder == false) goto L25;
        byte[] local2 = data[data.length - 1].getCentralDirectoryData();
        if (local2 == null) goto L25;
        System.arraycopy(local2, 0, result, start, local2.length);
    L25:
        return result;
    L5:
        if ((data[data.length - 1] instanceof UnparseableExtraFieldData) == false) goto L7;
        lastIsUnparseableHolder = true;
        goto L8
    }
}
