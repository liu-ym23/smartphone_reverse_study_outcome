package com.bytedance.ai.monitor.timeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/OpenFrom;", "", "from", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "APPLET_MAIN_OPEN", "APPLET_VIEW_OPEN", "OLD_APPLET_MAIN_OPEN", "OLD_APPLET_VIEW_OPEN", "NATIVE", "DEBUG", "OLD_APPLET_MAIN_CREATE", "OLD_APPLET_VIEW_CREATE", "APPLET_APP", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFrom extends Enum<OpenFrom> {
    public static final OpenFrom APPLET_APP = null;
    public static final OpenFrom APPLET_MAIN_OPEN = null;
    public static final OpenFrom APPLET_VIEW_OPEN = null;
    public static final OpenFrom DEBUG = null;
    public static final OpenFrom NATIVE = null;
    public static final OpenFrom OLD_APPLET_MAIN_CREATE = null;
    public static final OpenFrom OLD_APPLET_MAIN_OPEN = null;
    public static final OpenFrom OLD_APPLET_VIEW_CREATE = null;
    public static final OpenFrom OLD_APPLET_VIEW_OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFrom[] f37207a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37208b = null;
    private final String from;

    public static EnumEntries<OpenFrom> getEntries() {
        return f37208b;
    }

    static {
        OpenFrom r100 = new OpenFrom("APPLET_MAIN_OPEN", 0, "applet_main_open");
        APPLET_MAIN_OPEN = r100;
        OpenFrom r101 = new OpenFrom("APPLET_VIEW_OPEN", 1, "applet_view_open");
        APPLET_VIEW_OPEN = r101;
        OpenFrom r102 = new OpenFrom("OLD_APPLET_MAIN_OPEN", 2, "old_applet_main_open");
        OLD_APPLET_MAIN_OPEN = r102;
        OpenFrom r103 = new OpenFrom("OLD_APPLET_VIEW_OPEN", 3, "old_applet_view_open");
        OLD_APPLET_VIEW_OPEN = r103;
        OpenFrom r104 = new OpenFrom("NATIVE", 4, "native");
        NATIVE = r104;
        OpenFrom r105 = new OpenFrom("DEBUG", 5, "debug");
        DEBUG = r105;
        OpenFrom r110 = new OpenFrom("OLD_APPLET_MAIN_CREATE", 6, "applet_main_create");
        OLD_APPLET_MAIN_CREATE = r110;
        OpenFrom r111 = new OpenFrom("OLD_APPLET_VIEW_CREATE", 7, "applet_main_create");
        OLD_APPLET_VIEW_CREATE = r111;
        OpenFrom r112 = new OpenFrom("APPLET_APP", 8, "applet_app");
        APPLET_APP = r112;
        OpenFrom[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f37207a = r113;
        f37208b = EnumEntriesKt.enumEntries(r113);
    }

    public static OpenFrom[] values() {
        return (OpenFrom[]) f37207a.clone();
    }

    public final String getFrom() {
        return this.from;
    }

    public static OpenFrom valueOf(String r100) {
        return (OpenFrom) a.a(OpenFrom.class, r100);
    }

    public OpenFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.from = r102;
    }
}
