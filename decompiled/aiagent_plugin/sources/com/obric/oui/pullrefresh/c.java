package com.obric.oui.pullrefresh;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RefreshState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f36111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f36112b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f36113c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f36114d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f36115e = null;
    private static final /* synthetic */ c[] f = null;

    private static final /* synthetic */ c[] a() {
        return new c[]{f36111a, f36112b, f36113c, f36114d, f36115e};
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f36111a = new c("IDLE", 0);
        f36112b = new c("PULL_TO_REFRESH", 1);
        f36113c = new c("RELEASE_TO_REFRESH", 2);
        f36114d = new c("REFRESHING", 3);
        f36115e = new c("FINISH", 4);
        f = a();
    }
}
