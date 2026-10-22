package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/FullInterceptTouchTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullInterceptTouchTetris extends LiveTetris<com.bytedance.android.livesdk.widgetdescriptor.e0> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f118508o;

    public FullInterceptTouchTetris() {
        this.f118508o = LazyKt.lazy(new FullInterceptTouchTetris$touchListener$2(this));
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        L().setOnTouchListener((View.OnTouchListener) this.f118508o.getValue());
        T(zg1.i1.class, new FullInterceptTouchTetris$onViewCreated$1(this));
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.a(View.class);
    }
}
