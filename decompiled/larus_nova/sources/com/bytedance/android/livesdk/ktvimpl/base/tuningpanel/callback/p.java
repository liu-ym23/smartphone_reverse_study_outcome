package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback f143510a;

    public p(KSongViceSingerTuningButtonOuterCallback r100) {
        this.f143510a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        KSongViceSingerTuningButtonOuterCallback r102 = this.f143510a;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = r102.f();
        if (r103 == null) goto L5;
        Boolean r104 = r103.I();
    L6:
        Boolean r105 = Boolean.valueOf(Intrinsics.areEqual(r104, Boolean.TRUE));
        if (r102.g() == false) goto L12;
        bc0.c r106 = r102.f143481b;
        if (r106 == null) goto L13;
        r106.m2(new KSongViceSingerTuningButtonOuterCallback$checkEchoMode$1(r102, r105), TuningButtonType.ECHO_ITEM, false);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
