package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShowTipsHelper f60687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f60688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f60689c;

    public l(ShowTipsHelper r100, String r101, Ref.ObjectRef r102) {
        this.f60687a = r100;
        this.f60688b = r101;
        this.f60689c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (((SharedPreferences) this.f60687a.f60661b.getValue()).contains(this.f60688b) == false) goto L5;
        this.f60689c.element = "user_pay";
        MainThreadPostUtils.c(this.f60687a.f60663d, 3000);
        return;
    L5:
        ((SharedPreferences) this.f60687a.f60661b.getValue()).edit().putBoolean(this.f60688b, true).apply();
    }
}
