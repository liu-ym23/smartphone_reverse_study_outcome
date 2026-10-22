package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import com.bytedance.android.live.core.utils.StateMachine;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TopPauseStartFunctionItem f144265a;

    public g(TopPauseStartFunctionItem r100) {
        this.f144265a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        StateMachine.c.b r101 = (StateMachine.c.b) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.f.a(r101) != true) goto L9;
        this.f144265a.a();
        return;
    }
}
