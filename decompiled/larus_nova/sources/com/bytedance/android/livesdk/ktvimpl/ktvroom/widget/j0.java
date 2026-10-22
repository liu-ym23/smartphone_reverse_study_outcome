package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvMidiWidget f145809a;

    public j0(KtvMvMidiWidget r100) {
        this.f145809a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KtvMvMidiWidget r101 = this.f145809a;
        r101.getClass();
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        r101.wq();
        return;
    }
}
