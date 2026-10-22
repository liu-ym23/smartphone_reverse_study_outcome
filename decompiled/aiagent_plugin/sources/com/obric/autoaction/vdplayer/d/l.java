package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f25507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f25508b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f25509c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f25510d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f25511e = null;
    public static final l f = null;
    public static final l g = null;
    private static final /* synthetic */ l[] h = null;
    private static final /* synthetic */ d.d.a i = null;

    private static final /* synthetic */ l[] a() {
        return new l[]{f25507a, f25508b, f25509c, f25510d, f25511e, f, g};
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25507a = new l("Running", 0);
        f25508b = new l("Success", 1);
        f25509c = new l("Failure", 2);
        f25510d = new l("UserTerm", 3);
        f25511e = new l("EnterCallUser", 4);
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
