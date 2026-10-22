package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OptBoolean extends Enum<OptBoolean> {
    private static final /* synthetic */ OptBoolean[] $VALUES = null;
    public static final OptBoolean DEFAULT = null;
    public static final OptBoolean FALSE = null;
    public static final OptBoolean TRUE = null;

    private OptBoolean(String r1, int r2) {
        super(r1, r2);
    }

    public static OptBoolean valueOf(String r2) {
        return (OptBoolean) ZeusTransformUtils.preCheckCast(Enum.valueOf(OptBoolean.class, r2), OptBoolean.class, "com.obric.aiagent.plugin");
    }

    public static OptBoolean[] values() {
        return (OptBoolean[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OptBoolean[].class, "com.obric.aiagent.plugin");
    }

    static {
        OptBoolean r0 = new OptBoolean("TRUE", 0);
        TRUE = r0;
        OptBoolean r1 = new OptBoolean("FALSE", 1);
        FALSE = r1;
        OptBoolean r3 = new OptBoolean("DEFAULT", 2);
        DEFAULT = r3;
        $VALUES = new OptBoolean[]{r0, r1, r3};
    }

    public Boolean asBoolean() {
        if (this != DEFAULT) goto L7;
        return null;
    L7:
        if (this != TRUE) goto L10;
        return Boolean.TRUE;
    L10:
        return Boolean.FALSE;
    }

    public boolean asPrimitive() {
        if (this != TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public static OptBoolean fromBoolean(Boolean r0) {
        if (r0 != null) goto L6;
        return DEFAULT;
    L6:
        if (r0.booleanValue() == false) goto L9;
        return TRUE;
    L9:
        return FALSE;
    }

    public static boolean equals(Boolean r0, Boolean r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.equals(r1);
    }
}
