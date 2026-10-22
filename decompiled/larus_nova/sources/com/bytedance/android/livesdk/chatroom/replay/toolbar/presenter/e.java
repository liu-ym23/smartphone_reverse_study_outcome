package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f110161a;

    public e(a r100) {
        this.f110161a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 != null) goto L5;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (((Number) r101.getSecond()).intValue() != 1) goto L16;
    L9:
        ALogger.d("VS_TOOLBAR", "receive IVSDynamicIconBehavior[" + ((Number) r101.getFirst()).intValue() + "] state change to " + r101);
        NextLiveData<Integer> r102 = this.f110161a.f110152f;
        Integer r103 = r102.getValue();
        if (r103 == null) goto L12;
        Integer r104 = Integer.valueOf(r103.intValue() - 1);
    L13:
        r102.setValue(r104);
        return;
    L12:
        r104 = null;
        goto L13
    L16:
        return;
    L5:
        if (((Number) r101.getSecond()).intValue() == 0) goto L9;
        goto L6
    }
}
