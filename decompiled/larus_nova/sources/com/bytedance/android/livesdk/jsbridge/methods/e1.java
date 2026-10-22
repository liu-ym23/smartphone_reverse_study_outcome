package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class e1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f142114a;

    public e1(d1 r100) {
        this.f142114a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = ((Number) r100).intValue();
        d1 r102 = this.f142114a;
        Context r103 = r102.f142064a.get();
        if (r103 == null) goto L13;
        String r104 = r103.getString(R.string.ttlive_replay_save_draft_processing);
        if (r102.f142068e != null) goto L8;
        km3.g r105 = km3.g.c(r103, r104);
        r105.f504060e = new h1(r102);
        r105.b();
        Unit r106 = Unit.INSTANCE;
        r102.f142068e = r105;
    L8:
        km3.g r107 = r102.f142068e;
        if (r107 == null) goto L12;
        r107.setProgress(r101);
        return;
    L12:
        return;
    }
}
