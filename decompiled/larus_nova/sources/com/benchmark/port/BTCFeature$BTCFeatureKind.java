package com.benchmark.port;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum BTCFeature$BTCFeatureKind extends Enum<BTCFeature$BTCFeatureKind> {
    public static final BTCFeature$BTCFeatureKind BOOLEAN = null;
    public static final BTCFeature$BTCFeatureKind FLOAT = null;
    public static final BTCFeature$BTCFeatureKind INT = null;
    public static final BTCFeature$BTCFeatureKind STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BTCFeature$BTCFeatureKind[] f33661a = null;

    static {
        BTCFeature$BTCFeatureKind r100 = new BTCFeature$BTCFeatureKind("INT", 0);
        INT = r100;
        BTCFeature$BTCFeatureKind r101 = new BTCFeature$BTCFeatureKind("FLOAT", 1);
        FLOAT = r101;
        BTCFeature$BTCFeatureKind r102 = new BTCFeature$BTCFeatureKind("BOOLEAN", 2);
        BOOLEAN = r102;
        BTCFeature$BTCFeatureKind r103 = new BTCFeature$BTCFeatureKind("STRING", 3);
        STRING = r103;
        f33661a = new BTCFeature$BTCFeatureKind[]{r100, r101, r102, r103};
    }

    public static BTCFeature$BTCFeatureKind[] values() {
        return (BTCFeature$BTCFeatureKind[]) f33661a.clone();
    }

    public static BTCFeature$BTCFeatureKind valueOf(String r100) {
        return (BTCFeature$BTCFeatureKind) a.a(BTCFeature$BTCFeatureKind.class, r100);
    }

    public BTCFeature$BTCFeatureKind(String r100, int r101) {
        super(r100, r101);
    }
}
