package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Observer f143496a;

    public m(TuningPanelDialog.c r100) {
        this.f143496a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f143496a.onChanged(Boolean.valueOf(!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)));
    }
}
