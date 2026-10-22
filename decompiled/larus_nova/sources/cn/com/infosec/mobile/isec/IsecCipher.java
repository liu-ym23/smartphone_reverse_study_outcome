package cn.com.infosec.mobile.isec;

import java.io.ByteArrayOutputStream;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class IsecCipher extends IsecBase {
    public int errCode;

    public static final enum CipherAlgEnum extends Enum<CipherAlgEnum> {
        private static final /* synthetic */ CipherAlgEnum[] $VALUES = null;
        public static final CipherAlgEnum CIPHER_ALG_NONE = null;
        public static final CipherAlgEnum CIPHER_ALG_SM4 = null;

        private static /* synthetic */ CipherAlgEnum[] $values() {
            return new CipherAlgEnum[]{CIPHER_ALG_NONE, CIPHER_ALG_SM4};
        }

        static {
            CIPHER_ALG_NONE = new CipherAlgEnum("CIPHER_ALG_NONE", 0);
            CIPHER_ALG_SM4 = new CipherAlgEnum("CIPHER_ALG_SM4", 1);
            $VALUES = $values();
        }

        public static CipherAlgEnum[] values() {
            return (CipherAlgEnum[]) $VALUES.clone();
        }

        public static CipherAlgEnum valueOf(String r100) {
            return (CipherAlgEnum) a.a(CipherAlgEnum.class, r100);
        }

        private CipherAlgEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CipherModeEnum extends Enum<CipherModeEnum> {
        private static final /* synthetic */ CipherModeEnum[] $VALUES = null;
        public static final CipherModeEnum CIPHER_MODE_CBC = null;
        public static final CipherModeEnum CIPHER_MODE_ECB = null;
        public static final CipherModeEnum CIPHER_MODE_NONE = null;

        private static /* synthetic */ CipherModeEnum[] $values() {
            return new CipherModeEnum[]{CIPHER_MODE_NONE, CIPHER_MODE_ECB, CIPHER_MODE_CBC};
        }

        static {
            CIPHER_MODE_NONE = new CipherModeEnum("CIPHER_MODE_NONE", 0);
            CIPHER_MODE_ECB = new CipherModeEnum("CIPHER_MODE_ECB", 1);
            CIPHER_MODE_CBC = new CipherModeEnum("CIPHER_MODE_CBC", 2);
            $VALUES = $values();
        }

        public static CipherModeEnum[] values() {
            return (CipherModeEnum[]) $VALUES.clone();
        }

        public static CipherModeEnum valueOf(String r100) {
            return (CipherModeEnum) a.a(CipherModeEnum.class, r100);
        }

        private CipherModeEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CipherPaddingEnum extends Enum<CipherPaddingEnum> {
        private static final /* synthetic */ CipherPaddingEnum[] $VALUES = null;
        public static final CipherPaddingEnum NO_PADDING = null;
        public static final CipherPaddingEnum PKCS7_PADDING = null;

        private static /* synthetic */ CipherPaddingEnum[] $values() {
            return new CipherPaddingEnum[]{NO_PADDING, PKCS7_PADDING};
        }

        static {
            NO_PADDING = new CipherPaddingEnum("NO_PADDING", 0);
            PKCS7_PADDING = new CipherPaddingEnum("PKCS7_PADDING", 1);
            $VALUES = $values();
        }

        public static CipherPaddingEnum[] values() {
            return (CipherPaddingEnum[]) $VALUES.clone();
        }

        public static CipherPaddingEnum valueOf(String r100) {
            return (CipherPaddingEnum) a.a(CipherPaddingEnum.class, r100);
        }

        private CipherPaddingEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    private static native int decryptNative(IsecCipherConfig r100, byte[] r101, int r102, ByteArrayOutputStream r103);

    private static native int encryptNative(IsecCipherConfig r100, byte[] r101, int r102, ByteArrayOutputStream r103);

    private static native int genKeyNative(ByteArrayOutputStream r100);

    public IsecCipher() {
    }

    public static int genKey(ByteArrayOutputStream r100) {
        return genKeyNative(r100);
    }

    public static int decrypt(IsecCipherConfig r100, byte[] r101, int r102, ByteArrayOutputStream r103) {
        return decryptNative(r100, r101, r102, r103);
    }

    public static int encrypt(IsecCipherConfig r100, byte[] r101, int r102, ByteArrayOutputStream r103) {
        return encryptNative(r100, r101, r102, r103);
    }
}
