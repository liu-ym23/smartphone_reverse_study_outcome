package cn.com.infosec.mobile.isec;

import java.io.ByteArrayOutputStream;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class IsecHash extends IsecBase {

    public static final enum HashAlgEnum extends Enum<HashAlgEnum> {
        private static final /* synthetic */ HashAlgEnum[] $VALUES = null;
        public static final HashAlgEnum HASH_ALG_NONE = null;
        public static final HashAlgEnum HASH_ALG_SM3 = null;

        private static /* synthetic */ HashAlgEnum[] $values() {
            return new HashAlgEnum[]{HASH_ALG_NONE, HASH_ALG_SM3};
        }

        static {
            HASH_ALG_NONE = new HashAlgEnum("HASH_ALG_NONE", 0);
            HASH_ALG_SM3 = new HashAlgEnum("HASH_ALG_SM3", 1);
            $VALUES = $values();
        }

        public static HashAlgEnum[] values() {
            return (HashAlgEnum[]) $VALUES.clone();
        }

        public static HashAlgEnum valueOf(String r100) {
            return (HashAlgEnum) a.a(HashAlgEnum.class, r100);
        }

        private HashAlgEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    private static native int HashNative(HashAlgEnum r100, byte[] r101, ByteArrayOutputStream r102);

    public IsecHash() {
    }

    public static int Hash(HashAlgEnum r100, byte[] r101, ByteArrayOutputStream r102) {
        return HashNative(r100, r101, r102);
    }
}
