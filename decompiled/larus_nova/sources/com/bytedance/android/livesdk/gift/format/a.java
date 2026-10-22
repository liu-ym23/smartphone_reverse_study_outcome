package com.bytedance.android.livesdk.gift.format;

import android.content.Context;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements tr.b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<GiftPlayerView> f126219a;

    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // tr.b
    public final GiftPlayerView j5(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GiftPlayerView r102 = new GiftPlayerView(r100, null, 6, 0);
        if (r101 == true) goto L5;
        this.f126219a = new WeakReference(r102);
    L5:
        return r102;
    }
}
