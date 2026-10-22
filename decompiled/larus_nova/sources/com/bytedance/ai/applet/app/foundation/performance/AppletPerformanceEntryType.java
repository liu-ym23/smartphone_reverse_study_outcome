package com.bytedance.ai.applet.app.foundation.performance;

import androidx.core.app.NotificationCompat;
import com.larus.media.MediaScene;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceEntryType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", MediaScene.NAVIGATION, "RENDER", "SCRIPT", "LOAD_PACKAGE", "RESOURCE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceEntryType extends Enum<AppletPerformanceEntryType> {
    public static final AppletPerformanceEntryType LOAD_PACKAGE = null;
    public static final AppletPerformanceEntryType NAVIGATION = null;
    public static final AppletPerformanceEntryType RENDER = null;
    public static final AppletPerformanceEntryType RESOURCE = null;
    public static final AppletPerformanceEntryType SCRIPT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletPerformanceEntryType[] f34231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34232b = null;
    private final String value;

    public static EnumEntries<AppletPerformanceEntryType> getEntries() {
        return f34232b;
    }

    static {
        AppletPerformanceEntryType r100 = new AppletPerformanceEntryType(MediaScene.NAVIGATION, 0, NotificationCompat.CATEGORY_NAVIGATION);
        NAVIGATION = r100;
        AppletPerformanceEntryType r101 = new AppletPerformanceEntryType("RENDER", 1, ChameleonOpenTracker.Stage.RENDER);
        RENDER = r101;
        AppletPerformanceEntryType r102 = new AppletPerformanceEntryType("SCRIPT", 2, "script");
        SCRIPT = r102;
        AppletPerformanceEntryType r103 = new AppletPerformanceEntryType("LOAD_PACKAGE", 3, "loadPackage");
        LOAD_PACKAGE = r103;
        AppletPerformanceEntryType r104 = new AppletPerformanceEntryType("RESOURCE", 4, "resource");
        RESOURCE = r104;
        AppletPerformanceEntryType[] r105 = {r100, r101, r102, r103, r104};
        f34231a = r105;
        f34232b = EnumEntriesKt.enumEntries(r105);
    }

    public static AppletPerformanceEntryType[] values() {
        return (AppletPerformanceEntryType[]) f34231a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceEntryType valueOf(String r100) {
        return (AppletPerformanceEntryType) r27.a.a(AppletPerformanceEntryType.class, r100);
    }

    public AppletPerformanceEntryType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
