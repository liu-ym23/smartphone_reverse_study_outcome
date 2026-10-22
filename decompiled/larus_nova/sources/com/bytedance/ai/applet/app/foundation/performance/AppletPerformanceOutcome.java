package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "CANCELLED", "TIMEOUT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceOutcome extends Enum<AppletPerformanceOutcome> {
    public static final AppletPerformanceOutcome CANCELLED = null;
    public static final AppletPerformanceOutcome FAILED = null;
    public static final AppletPerformanceOutcome SUCCESS = null;
    public static final AppletPerformanceOutcome TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletPerformanceOutcome[] f34239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34240b = null;

    public static EnumEntries<AppletPerformanceOutcome> getEntries() {
        return f34240b;
    }

    static {
        AppletPerformanceOutcome r100 = new AppletPerformanceOutcome("SUCCESS", 0);
        SUCCESS = r100;
        AppletPerformanceOutcome r101 = new AppletPerformanceOutcome("FAILED", 1);
        FAILED = r101;
        AppletPerformanceOutcome r102 = new AppletPerformanceOutcome("CANCELLED", 2);
        CANCELLED = r102;
        AppletPerformanceOutcome r103 = new AppletPerformanceOutcome("TIMEOUT", 3);
        TIMEOUT = r103;
        AppletPerformanceOutcome[] r104 = {r100, r101, r102, r103};
        f34239a = r104;
        f34240b = EnumEntriesKt.enumEntries(r104);
    }

    public static AppletPerformanceOutcome[] values() {
        return (AppletPerformanceOutcome[]) f34239a.clone();
    }

    public static AppletPerformanceOutcome valueOf(String r100) {
        return (AppletPerformanceOutcome) r27.a.a(AppletPerformanceOutcome.class, r100);
    }

    public AppletPerformanceOutcome(String r100, int r101) {
        super(r100, r101);
    }
}
