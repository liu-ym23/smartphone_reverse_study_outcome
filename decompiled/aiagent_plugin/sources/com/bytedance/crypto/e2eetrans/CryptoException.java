package com.bytedance.crypto.e2eetrans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CryptoException extends Exception {
    public final Code code;

    public static final enum Code extends Enum<Code> {
        private static final /* synthetic */ Code[] $VALUES = null;
        public static final Code APPID_MISMATCH = null;
        public static final Code CERT_INVALID = null;
        public static final Code CHALLENGE_FAILED = null;
        public static final Code HANDSHAKE_FAILED = null;
        public static final Code INVALID_PARAMS = null;
        public static final Code SESSION_EXPIRED = null;
        public static final Code SESSION_NOT_READY = null;
        public static final Code TAMPERED = null;
        public static final Code UNWRAP_FAILED = null;

        static {
            Code r0 = new Code("CERT_INVALID", 0);
            CERT_INVALID = r0;
            Code r1 = new Code("APPID_MISMATCH", 1);
            APPID_MISMATCH = r1;
            Code r3 = new Code("CHALLENGE_FAILED", 2);
            CHALLENGE_FAILED = r3;
            Code r5 = new Code("HANDSHAKE_FAILED", 3);
            HANDSHAKE_FAILED = r5;
            Code r7 = new Code("TAMPERED", 4);
            TAMPERED = r7;
            Code r9 = new Code("UNWRAP_FAILED", 5);
            UNWRAP_FAILED = r9;
            Code r11 = new Code("SESSION_NOT_READY", 6);
            SESSION_NOT_READY = r11;
            Code r13 = new Code("SESSION_EXPIRED", 7);
            SESSION_EXPIRED = r13;
            Code r15 = new Code("INVALID_PARAMS", 8);
            INVALID_PARAMS = r15;
            $VALUES = new Code[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private Code(String r1, int r2) {
            super(r1, r2);
        }

        public static Code valueOf(String r2) {
            return (Code) ZeusTransformUtils.preCheckCast(Enum.valueOf(Code.class, r2), Code.class, "com.obric.aiagent.plugin");
        }

        public static Code[] values() {
            return (Code[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Code[].class, "com.obric.aiagent.plugin");
        }
    }

    public CryptoException(Code r1, String r2) {
        super(r2);
        this.code = r1;
    }

    public CryptoException(Code r1, String r2, Throwable r3) {
        super(r2, r3);
        this.code = r1;
    }
}
