package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Observer f143494a;

    public k(TuningPanelDialog.c r100) {
        this.f143494a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f143494a.onChanged(Boolean.valueOf(((ae2.a) r100).f3075b));
    }
}
