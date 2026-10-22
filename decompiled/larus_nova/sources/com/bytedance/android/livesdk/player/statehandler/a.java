package com.bytedance.android.livesdk.player.statehandler;

import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayingStateHandler f156080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveRequest f156081b;

    public a(PlayingStateHandler r100, LiveRequest r101) {
        this.f156080a = r100;
        this.f156081b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L6;
        r101.booleanValue();
        this.f156080a.b(this.f156081b);
        return;
    }
}
