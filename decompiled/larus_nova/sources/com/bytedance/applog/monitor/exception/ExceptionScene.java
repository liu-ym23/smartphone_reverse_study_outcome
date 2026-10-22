package com.bytedance.applog.monitor.exception;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum ExceptionScene extends Enum<ExceptionScene> {
    public static final ExceptionScene Common = null;
    public static final ExceptionScene DataCollection = null;
    public static final ExceptionScene DataPackaging = null;
    public static final ExceptionScene DataUpload = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExceptionScene[] f192493a = null;

    static {
        ExceptionScene r100 = new ExceptionScene("Common", 0);
        Common = r100;
        ExceptionScene r101 = new ExceptionScene("DataCollection", 1);
        DataCollection = r101;
        ExceptionScene r102 = new ExceptionScene("DataPackaging", 2);
        DataPackaging = r102;
        ExceptionScene r103 = new ExceptionScene("DataUpload", 3);
        DataUpload = r103;
        f192493a = new ExceptionScene[]{r100, r101, r102, r103};
    }

    public static ExceptionScene[] values() {
        return (ExceptionScene[]) f192493a.clone();
    }

    public static ExceptionScene valueOf(String r100) {
        return (ExceptionScene) a.a(ExceptionScene.class, r100);
    }

    public ExceptionScene(String r100, int r101) {
        super(r100, r101);
    }
}
