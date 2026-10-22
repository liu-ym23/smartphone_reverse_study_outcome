package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class u<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f83766a = null;

    static {
        f83766a = new u();
    }

    public u() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        com.bytedance.android.live.liveinteract.plantform.base.g r102 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r102.Lp(!r101.booleanValue());
        return;
    }
}
