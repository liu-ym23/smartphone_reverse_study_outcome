package com.byted.mgl.merge.service.api.aweme;

import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public interface JoinConversationCallback {
    public static final int INTERNAL_ERROR = 0;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type APPLY_FAIL = null;
        public static final Type GROUP_FULL = null;
        public static final Type INTERNAL_ERROR = null;
        public static final Type JUMP_FAIL = null;
        public static final Type NOT_AUTHENTICATE = null;
        public static final Type REQUEST_FAIL = null;

        static {
            Type r100 = new Type("INTERNAL_ERROR", 0);
            INTERNAL_ERROR = r100;
            Type r101 = new Type("GROUP_FULL", 1);
            GROUP_FULL = r101;
            Type r102 = new Type("REQUEST_FAIL", 2);
            REQUEST_FAIL = r102;
            Type r103 = new Type("NOT_AUTHENTICATE", 3);
            NOT_AUTHENTICATE = r103;
            Type r104 = new Type("JUMP_FAIL", 4);
            JUMP_FAIL = r104;
            Type r105 = new Type("APPLY_FAIL", 5);
            APPLY_FAIL = r105;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onFail(JSONObject r100, Type r101);

    void onSuccess();
}
