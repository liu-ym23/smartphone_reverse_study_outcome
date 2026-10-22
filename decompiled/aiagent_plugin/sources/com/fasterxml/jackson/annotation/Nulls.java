package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum Nulls extends Enum<Nulls> {
    private static final /* synthetic */ Nulls[] $VALUES = null;
    public static final Nulls AS_EMPTY = null;
    public static final Nulls DEFAULT = null;
    public static final Nulls FAIL = null;
    public static final Nulls SET = null;
    public static final Nulls SKIP = null;

    private Nulls(String r1, int r2) {
        super(r1, r2);
    }

    public static Nulls valueOf(String r2) {
        return (Nulls) ZeusTransformUtils.preCheckCast(Enum.valueOf(Nulls.class, r2), Nulls.class, "com.obric.aiagent.plugin");
    }

    public static Nulls[] values() {
        return (Nulls[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Nulls[].class, "com.obric.aiagent.plugin");
    }

    static {
        Nulls r0 = new Nulls("SET", 0);
        SET = r0;
        Nulls r1 = new Nulls("SKIP", 1);
        SKIP = r1;
        Nulls r3 = new Nulls("FAIL", 2);
        FAIL = r3;
        Nulls r5 = new Nulls("AS_EMPTY", 3);
        AS_EMPTY = r5;
        Nulls r7 = new Nulls("DEFAULT", 4);
        DEFAULT = r7;
        $VALUES = new Nulls[]{r0, r1, r3, r5, r7};
    }
}
