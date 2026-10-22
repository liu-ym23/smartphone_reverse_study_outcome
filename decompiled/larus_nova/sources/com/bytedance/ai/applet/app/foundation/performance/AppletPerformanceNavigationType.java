package com.bytedance.ai.applet.app.foundation.performance;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceNavigationType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NAVIGATE_TO", "REDIRECT_TO", "RE_LAUNCH", "OPEN_PAGE", "OPEN_PAGE_IN_CHAT", "SWITCH_TAB", "NAVIGATE_BACK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceNavigationType extends Enum<AppletPerformanceNavigationType> {
    public static final AppletPerformanceNavigationType NAVIGATE_BACK = null;
    public static final AppletPerformanceNavigationType NAVIGATE_TO = null;
    public static final AppletPerformanceNavigationType OPEN_PAGE = null;
    public static final AppletPerformanceNavigationType OPEN_PAGE_IN_CHAT = null;
    public static final AppletPerformanceNavigationType REDIRECT_TO = null;
    public static final AppletPerformanceNavigationType RE_LAUNCH = null;
    public static final AppletPerformanceNavigationType SWITCH_TAB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletPerformanceNavigationType[] f34237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34238b = null;
    private final String value;

    public static EnumEntries<AppletPerformanceNavigationType> getEntries() {
        return f34238b;
    }

    static {
        AppletPerformanceNavigationType r100 = new AppletPerformanceNavigationType("NAVIGATE_TO", 0, "navigateTo");
        NAVIGATE_TO = r100;
        AppletPerformanceNavigationType r101 = new AppletPerformanceNavigationType("REDIRECT_TO", 1, "redirectTo");
        REDIRECT_TO = r101;
        AppletPerformanceNavigationType r102 = new AppletPerformanceNavigationType("RE_LAUNCH", 2, "reLaunch");
        RE_LAUNCH = r102;
        AppletPerformanceNavigationType r103 = new AppletPerformanceNavigationType("OPEN_PAGE", 3, SendEventContainerMethodParamModel.EventKinds.openPage);
        OPEN_PAGE = r103;
        AppletPerformanceNavigationType r104 = new AppletPerformanceNavigationType("OPEN_PAGE_IN_CHAT", 4, "openPageInChat");
        OPEN_PAGE_IN_CHAT = r104;
        AppletPerformanceNavigationType r105 = new AppletPerformanceNavigationType("SWITCH_TAB", 5, "switchTab");
        SWITCH_TAB = r105;
        AppletPerformanceNavigationType r110 = new AppletPerformanceNavigationType("NAVIGATE_BACK", 6, "navigateBack");
        NAVIGATE_BACK = r110;
        AppletPerformanceNavigationType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f34237a = r111;
        f34238b = EnumEntriesKt.enumEntries(r111);
    }

    public static AppletPerformanceNavigationType[] values() {
        return (AppletPerformanceNavigationType[]) f34237a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceNavigationType valueOf(String r100) {
        return (AppletPerformanceNavigationType) r27.a.a(AppletPerformanceNavigationType.class, r100);
    }

    public AppletPerformanceNavigationType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
