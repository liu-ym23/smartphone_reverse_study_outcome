package com.bytedance.android.livesdk.utils;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f159075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f159076b;

    public m(FragmentActivity r100, String r101) {
        this.f159075a = r100;
        this.f159076b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveRealStartEvent r101 = (LiveRealStartEvent) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isVerified() != true) goto L9;
        int r102 = k.f159000a;
        k.a(this.f159075a, this.f159076b);
        return;
    }
}
