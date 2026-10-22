package com.bytedance.applog.monitor.exception;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum ExceptionLevel extends Enum<ExceptionLevel> {
    public static final ExceptionLevel Fatal = null;
    public static final ExceptionLevel Notice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExceptionLevel[] f192492a = null;

    static {
        ExceptionLevel r100 = new ExceptionLevel("Fatal", 0);
        Fatal = r100;
        ExceptionLevel r101 = new ExceptionLevel("Notice", 1);
        Notice = r101;
        f192492a = new ExceptionLevel[]{r100, r101};
    }

    public static ExceptionLevel[] values() {
        return (ExceptionLevel[]) f192492a.clone();
    }

    public static ExceptionLevel valueOf(String r100) {
        return (ExceptionLevel) a.a(ExceptionLevel.class, r100);
    }

    public ExceptionLevel(String r100, int r101) {
        super(r100, r101);
    }
}
