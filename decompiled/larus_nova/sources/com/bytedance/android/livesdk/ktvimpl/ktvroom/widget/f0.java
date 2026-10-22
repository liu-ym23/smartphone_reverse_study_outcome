package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvMidiWidget f145793a;

    public f0(KtvMvMidiWidget r100) {
        this.f145793a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r102 = this.f145793a.f145636d;
        if (r102 == null) goto L6;
        r102.p0(Intrinsics.areEqual(r101, Boolean.TRUE));
        return;
    }
}
