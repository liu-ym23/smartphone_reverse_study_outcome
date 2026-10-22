package com.autonavi.base.amap.mapcore.jbinding;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum JBinding2cType extends Enum<JBinding2cType> {
    private static final /* synthetic */ JBinding2cType[] $VALUES = null;
    public static final JBinding2cType EXCLUDE = null;
    public static final JBinding2cType INCLUDE = null;

    static {
        JBinding2cType r100 = new JBinding2cType("INCLUDE", 0);
        INCLUDE = r100;
        JBinding2cType r101 = new JBinding2cType("EXCLUDE", 1);
        EXCLUDE = r101;
        $VALUES = new JBinding2cType[]{r100, r101};
    }

    public static JBinding2cType[] values() {
        return (JBinding2cType[]) $VALUES.clone();
    }

    public static JBinding2cType valueOf(String r100) {
        return (JBinding2cType) a.a(JBinding2cType.class, r100);
    }

    private JBinding2cType(String r100, int r101) {
        super(r100, r101);
    }
}
