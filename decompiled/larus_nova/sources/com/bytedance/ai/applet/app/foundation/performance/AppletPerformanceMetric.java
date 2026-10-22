package com.bytedance.ai.applet.app.foundation.performance;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceMetric;", "", "value", "", "entryType", "Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;)V", "getValue", "()Ljava/lang/String;", "getEntryType", "()Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;", "APP_LAUNCH", "ROUTE", "FIRST_RENDER", "FIRST_PAINT", "FIRST_CONTENTFUL_PAINT", "EVALUATE_SCRIPT", "DOWNLOAD_PACKAGE", "RESOURCE_TIMING", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceMetric extends Enum<AppletPerformanceMetric> {
    public static final AppletPerformanceMetric APP_LAUNCH = null;
    public static final AppletPerformanceMetric DOWNLOAD_PACKAGE = null;
    public static final AppletPerformanceMetric EVALUATE_SCRIPT = null;
    public static final AppletPerformanceMetric FIRST_CONTENTFUL_PAINT = null;
    public static final AppletPerformanceMetric FIRST_PAINT = null;
    public static final AppletPerformanceMetric FIRST_RENDER = null;
    public static final AppletPerformanceMetric RESOURCE_TIMING = null;
    public static final AppletPerformanceMetric ROUTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletPerformanceMetric[] f34235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34236b = null;
    private final AppletPerformanceEntryType entryType;
    private final String value;

    public static EnumEntries<AppletPerformanceMetric> getEntries() {
        return f34236b;
    }

    static {
        AppletPerformanceEntryType r100 = AppletPerformanceEntryType.NAVIGATION;
        AppletPerformanceMetric r101 = new AppletPerformanceMetric("APP_LAUNCH", 0, "appLaunch", r100);
        APP_LAUNCH = r101;
        AppletPerformanceMetric r102 = new AppletPerformanceMetric("ROUTE", 1, CloudControlInf.ROUTE, r100);
        ROUTE = r102;
        AppletPerformanceEntryType r103 = AppletPerformanceEntryType.RENDER;
        AppletPerformanceMetric r104 = new AppletPerformanceMetric("FIRST_RENDER", 2, "firstRender", r103);
        FIRST_RENDER = r104;
        AppletPerformanceMetric r105 = new AppletPerformanceMetric("FIRST_PAINT", 3, "firstPaint", r103);
        FIRST_PAINT = r105;
        AppletPerformanceMetric r106 = new AppletPerformanceMetric("FIRST_CONTENTFUL_PAINT", 4, "firstContentfulPaint", r103);
        FIRST_CONTENTFUL_PAINT = r106;
        AppletPerformanceMetric r107 = new AppletPerformanceMetric("EVALUATE_SCRIPT", 5, "evaluateScript", AppletPerformanceEntryType.SCRIPT);
        EVALUATE_SCRIPT = r107;
        AppletPerformanceMetric r108 = new AppletPerformanceMetric("DOWNLOAD_PACKAGE", 6, "downloadPackage", AppletPerformanceEntryType.LOAD_PACKAGE);
        DOWNLOAD_PACKAGE = r108;
        AppletPerformanceMetric r110 = new AppletPerformanceMetric("RESOURCE_TIMING", 7, "resourceTiming", AppletPerformanceEntryType.RESOURCE);
        RESOURCE_TIMING = r110;
        AppletPerformanceMetric[] r111 = {r101, r102, r104, r105, r106, r107, r108, r110};
        f34235a = r111;
        f34236b = EnumEntriesKt.enumEntries(r111);
    }

    public static AppletPerformanceMetric[] values() {
        return (AppletPerformanceMetric[]) f34235a.clone();
    }

    public final AppletPerformanceEntryType getEntryType() {
        return this.entryType;
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceMetric valueOf(String r100) {
        return (AppletPerformanceMetric) r27.a.a(AppletPerformanceMetric.class, r100);
    }

    public AppletPerformanceMetric(String r100, int r101, String r102, AppletPerformanceEntryType r103) {
        super(r100, r101);
        this.value = r102;
        this.entryType = r103;
    }
}
