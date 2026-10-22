package org.apache.commons.compress.archivers.zip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PKWareExtraHeader implements ZipExtraField {
    private byte[] centralData;
    private final ZipShort headerId;
    private byte[] localData;

    public static final enum EncryptionAlgorithm extends Enum<EncryptionAlgorithm> {
        private static final /* synthetic */ EncryptionAlgorithm[] $VALUES = null;
        public static final EncryptionAlgorithm AES128 = null;
        public static final EncryptionAlgorithm AES192 = null;
        public static final EncryptionAlgorithm AES256 = null;
        public static final EncryptionAlgorithm DES = null;
        public static final EncryptionAlgorithm RC2 = null;
        public static final EncryptionAlgorithm RC2pre52 = null;
        public static final EncryptionAlgorithm RC4 = null;
        public static final EncryptionAlgorithm TripleDES168 = null;
        public static final EncryptionAlgorithm TripleDES192 = null;
        public static final EncryptionAlgorithm UNKNOWN = null;
        private static final Map<Integer, EncryptionAlgorithm> codeToEnum = null;
        private final int code;

        private static /* synthetic */ EncryptionAlgorithm[] $values() {
            return new EncryptionAlgorithm[]{DES, RC2pre52, TripleDES168, TripleDES192, AES128, AES192, AES256, RC2, RC4, UNKNOWN};
        }

        public static EncryptionAlgorithm valueOf(String name) {
            return (EncryptionAlgorithm) Enum.valueOf(EncryptionAlgorithm.class, name);
        }

        public static EncryptionAlgorithm[] values() {
            return (EncryptionAlgorithm[]) $VALUES.clone();
        }

        static {
            int r3 = 0;
            DES = new EncryptionAlgorithm("DES", 0, 26113);
            RC2pre52 = new EncryptionAlgorithm("RC2pre52", 1, 26114);
            TripleDES168 = new EncryptionAlgorithm("TripleDES168", 2, 26115);
            TripleDES192 = new EncryptionAlgorithm("TripleDES192", 3, 26121);
            AES128 = new EncryptionAlgorithm("AES128", 4, 26126);
            AES192 = new EncryptionAlgorithm("AES192", 5, 26127);
            AES256 = new EncryptionAlgorithm("AES256", 6, 26128);
            RC2 = new EncryptionAlgorithm("RC2", 7, 26370);
            RC4 = new EncryptionAlgorithm("RC4", 8, 26625);
            UNKNOWN = new EncryptionAlgorithm("UNKNOWN", 9, 65535);
            $VALUES = $values();
            Map<Integer, EncryptionAlgorithm> cte = new HashMap();
            EncryptionAlgorithm[] r1 = values();
            int r2 = r1.length;
        L3:
            if (r3 >= r2) goto L5;
            EncryptionAlgorithm method = r1[r3];
            cte.put(Integer.valueOf(method.getCode()), method);
            r3 = r3 + 1;
            goto L3
        L5:
            codeToEnum = Collections.unmodifiableMap(cte);
        }

        private EncryptionAlgorithm(String r1, int r2, int code) {
            super(r1, r2);
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int code) {
            return codeToEnum.get(Integer.valueOf(code));
        }
    }

    public static final enum HashAlgorithm extends Enum<HashAlgorithm> {
        private static final /* synthetic */ HashAlgorithm[] $VALUES = null;
        public static final HashAlgorithm CRC32 = null;
        public static final HashAlgorithm MD5 = null;
        public static final HashAlgorithm NONE = null;
        public static final HashAlgorithm RIPEND160 = null;
        public static final HashAlgorithm SHA1 = null;
        public static final HashAlgorithm SHA256 = null;
        public static final HashAlgorithm SHA384 = null;
        public static final HashAlgorithm SHA512 = null;
        private static final Map<Integer, HashAlgorithm> codeToEnum = null;
        private final int code;

        private static /* synthetic */ HashAlgorithm[] $values() {
            return new HashAlgorithm[]{NONE, CRC32, MD5, SHA1, RIPEND160, SHA256, SHA384, SHA512};
        }

        public static HashAlgorithm valueOf(String name) {
            return (HashAlgorithm) Enum.valueOf(HashAlgorithm.class, name);
        }

        public static HashAlgorithm[] values() {
            return (HashAlgorithm[]) $VALUES.clone();
        }

        static {
            int r2 = 0;
            NONE = new HashAlgorithm("NONE", 0, 0);
            CRC32 = new HashAlgorithm("CRC32", 1, 1);
            MD5 = new HashAlgorithm("MD5", 2, 32771);
            SHA1 = new HashAlgorithm("SHA1", 3, 32772);
            RIPEND160 = new HashAlgorithm("RIPEND160", 4, 32775);
            SHA256 = new HashAlgorithm("SHA256", 5, 32780);
            SHA384 = new HashAlgorithm("SHA384", 6, 32781);
            SHA512 = new HashAlgorithm("SHA512", 7, 32782);
            $VALUES = $values();
            Map<Integer, HashAlgorithm> cte = new HashMap();
            HashAlgorithm[] r1 = values();
            int r3 = r1.length;
        L3:
            if (r2 >= r3) goto L5;
            HashAlgorithm method = r1[r2];
            cte.put(Integer.valueOf(method.getCode()), method);
            r2 = r2 + 1;
            goto L3
        L5:
            codeToEnum = Collections.unmodifiableMap(cte);
        }

        private HashAlgorithm(String r1, int r2, int code) {
            super(r1, r2);
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public static HashAlgorithm getAlgorithmByCode(int code) {
            return codeToEnum.get(Integer.valueOf(code));
        }
    }

    protected PKWareExtraHeader(ZipShort headerId) {
        this.headerId = headerId;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return this.headerId;
    }

    public void setLocalFileDataData(byte[] data) {
        this.localData = ZipUtil.copy(data);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        if (this.localData == null) goto L5;
        int r1 = this.localData.length;
    L7:
        return new ZipShort(r1);
    L5:
        r1 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    public void setCentralDirectoryData(byte[] data) {
        this.centralData = ZipUtil.copy(data);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.centralData == null) goto L7;
        return new ZipShort(this.centralData.length);
    L7:
        return getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        if (this.centralData == null) goto L7;
        return ZipUtil.copy(this.centralData);
    L7:
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) {
        byte[] tmp = new byte[length];
        System.arraycopy(data, offset, tmp, 0, length);
        setLocalFileDataData(tmp);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] data, int offset, int length) {
        byte[] tmp = new byte[length];
        System.arraycopy(data, offset, tmp, 0, length);
        setCentralDirectoryData(tmp);
        if (this.localData != null) goto L6;
        setLocalFileDataData(tmp);
        return;
    }
}
