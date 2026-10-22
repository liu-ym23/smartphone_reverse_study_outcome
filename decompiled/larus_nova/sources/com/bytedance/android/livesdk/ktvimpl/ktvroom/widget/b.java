package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.utils.StateMachine;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f145776a;

    public b(l r100) {
        this.f145776a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        l r101 = this.f145776a;
        r101.b((StateMachine.c.b) r100);
    }
}
