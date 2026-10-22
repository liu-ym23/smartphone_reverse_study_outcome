package com.bytedance.android.gamecp.common.download;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements com.bytedance.gamecenter.base.order.i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f56522a = null;

    static {
        f56522a = new c();
    }

    public c() {
    }

    @Override // com.bytedance.gamecenter.base.order.i.a
    public final String getCurUserId() {
        return com.bytedance.android.gamecp.host_api.a.b().getUserService().getCurUserId();
    }
}
