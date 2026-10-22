package com.bytedance.android.live.soloktv.tuningpanel.callback;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvTuningButtonOuterCallback f101571a;

    public b(SoloKtvTuningButtonOuterCallback r100) {
        this.f101571a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        SoloKtvTuningButtonOuterCallback r102 = this.f101571a;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = r102.g();
        if (r103 == null) goto L5;
        Boolean r104 = r103.I();
    L6:
        SoloKtvTuningButtonOuterCallback.f(r102, Boolean.valueOf(Intrinsics.areEqual(r104, Boolean.TRUE)));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
