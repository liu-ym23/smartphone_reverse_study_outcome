package com.bytedance.android.live.broadcastgame.opengame;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBasePluginManager f60122a;

    public l(LiveBasePluginManager r100) {
        this.f60122a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((d10.a) r100).getClass();
        SharedPreferences.Editor r101 = this.f60122a.getContext().getSharedPreferences("com.tt.miniapp.shared_prefs_prefix_new_permission_null", 0).edit();
        r101.clear();
        r101.apply();
        f2.c("null 权限SP已清空", 0);
    }
}
