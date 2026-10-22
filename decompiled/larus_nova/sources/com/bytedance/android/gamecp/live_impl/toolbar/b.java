package com.bytedance.android.gamecp.live_impl.toolbar;

import android.content.DialogInterface;
import bw.s;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f57975a = null;

    public static final class a implements s {
        public a() {
        }
    }

    static {
        f57975a = new b();
    }

    public b() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        yr.b.b(4, "game-promote", "主播退出游戏推广页面，恢复直播");
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().R0(new a());
    }
}
