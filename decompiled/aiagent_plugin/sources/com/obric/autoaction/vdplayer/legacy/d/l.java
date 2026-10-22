package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f25914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f25915b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f25916c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f25917d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f25918e = null;
    public static final l f = null;
    public static final l g = null;
    private static final /* synthetic */ l[] h = null;
    private static final /* synthetic */ d.d.a i = null;

    private static final /* synthetic */ l[] a() {
        return new l[]{f25914a, f25915b, f25916c, f25917d, f25918e, f, g};
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25914a = new l("Running", 0);
        f25915b = new l("Success", 1);
        f25916c = new l("Failure", 2);
        f25917d = new l("UserTerm", 3);
        f25918e = new l("EnterCallUser", 4);
        f = new l("EnterClarify", 5);
        g = new l("Idle", 6);
        l[] r0 = a();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static l valueOf(String r2) {
        return (l) ZeusTransformUtils.preCheckCast(Enum.valueOf(l.class, r2), l.class, "com.obric.aiagent.plugin");
    }

    public static l[] values() {
        return (l[]) ZeusTransformUtils.preCheckCast(h.clone(), l[].class, "com.obric.aiagent.plugin");
    }
}
