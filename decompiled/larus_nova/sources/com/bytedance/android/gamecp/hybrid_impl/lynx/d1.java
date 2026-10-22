package com.bytedance.android.gamecp.hybrid_impl.lynx;

import com.bytedance.android.gamecp.hybrid_impl.jsb.GameGetUserProfileMethod;

/* JADX INFO: loaded from: classes44.dex */
public final class d1 implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f57600a = null;

    static {
        f57600a = new d1();
    }

    public d1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new GameGetUserProfileMethod();
    }
}
