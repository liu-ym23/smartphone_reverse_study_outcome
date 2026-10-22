package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceResourceInitiatorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUDIO", "COVER_IMAGE", "IMAGE", "OPEN_DATA", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceResourceInitiatorType extends Enum<AppletPerformanceResourceInitiatorType> {
    public static final AppletPerformanceResourceInitiatorType AUDIO = null;
    public static final AppletPerformanceResourceInitiatorType COVER_IMAGE = null;
    public static final AppletPerformanceResourceInitiatorType IMAGE = null;
    public static final AppletPerformanceResourceInitiatorType OPEN_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletPerformanceResourceInitiatorType[] f34241a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34242b = null;
    private final String value;

    public static EnumEntries<AppletPerformanceResourceInitiatorType> getEntries() {
        return f34242b;
    }

    static {
        AppletPerformanceResourceInitiatorType r100 = new AppletPerformanceResourceInitiatorType("AUDIO", 0, "audio");
        AUDIO = r100;
        AppletPerformanceResourceInitiatorType r101 = new AppletPerformanceResourceInitiatorType("COVER_IMAGE", 1, "cover-image");
        COVER_IMAGE = r101;
        AppletPerformanceResourceInitiatorType r102 = new AppletPerformanceResourceInitiatorType("IMAGE", 2, "image");
        IMAGE = r102;
        AppletPerformanceResourceInitiatorType r103 = new AppletPerformanceResourceInitiatorType("OPEN_DATA", 3, "open-data");
        OPEN_DATA = r103;
        AppletPerformanceResourceInitiatorType[] r104 = {r100, r101, r102, r103};
        f34241a = r104;
        f34242b = EnumEntriesKt.enumEntries(r104);
    }

    public static AppletPerformanceResourceInitiatorType[] values() {
        return (AppletPerformanceResourceInitiatorType[]) f34241a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceResourceInitiatorType valueOf(String r100) {
        return (AppletPerformanceResourceInitiatorType) r27.a.a(AppletPerformanceResourceInitiatorType.class, r100);
    }

    public AppletPerformanceResourceInitiatorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
