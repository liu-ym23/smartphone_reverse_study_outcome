package com.obric.autoaction.presentation.doubao;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AssistWidgetAction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f24881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f24882b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f24883c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f24884d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f24885e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;
    public static final d k = null;
    private static final /* synthetic */ d[] m = null;
    private static final /* synthetic */ d.d.a n = null;
    private final String l;

    private static final /* synthetic */ d[] b() {
        return new d[]{f24881a, f24882b, f24883c, f24884d, f24885e, f, g, h, i, j, k};
    }

    private d(String r1, int r2, String r3) {
        super(r1, r2);
        this.l = r3;
    }

    public final String a() {
        return this.l;
    }

    static {
        f24881a = new d("STOP_TASK", 0, "STOP_TASK");
        f24882b = new d("DELETE_TIMER_TASK", 1, "DELETE_TIMER_TASK");
        f24883c = new d("SHARE_TASK", 2, "SHARE_TASK");
        f24884d = new d("REPORT_TASK", 3, "REPORT_TASK");
        f24885e = new d("GO_TO_PLAYER", 4, "GO_TO_PLAYER");
        f = new d("RERUN", 5, "RERUN");
        g = new d("OPEN_TARGETED_APP", 6, "OPEN_TARGETED_APP");
        h = new d("GO_TO_LAUNCHER_PAGE", 7, "GO_TO_LAUNCHER_PAGE");
        i = new d("TRY_RUN", 8, "TRY_RUN");
        j = new d("BLACKLIST_ACTION", 9, "BLACKLIST_ACTION");
        k = new d("SAVE_AS_SHORTCUT", 10, "SAVE_AS_SHORTCUT");
        d[] r0 = b();
        m = r0;
        n = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(m.clone(), d[].class, "com.obric.aiagent.plugin");
    }
}
