package com.bytedance.android.livesdk.chatroom.replay.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast.ReplayCastScreenConnectWidgetForByteCast;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayCastScreenTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Luq1/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayCastScreenTetris extends LiveTetris<uq1.b> implements Observer<KVData> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f108347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CompositeDisposable f108348p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f108349q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataCenter f108350r;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        this.f108348p = new CompositeDisposable();
        uq1.b r100 = (uq1.b) K();
        if (r100 == null) goto L5;
        DataCenter r101 = r100.f551201e;
    L6:
        this.f108350r = r101;
        if (r101 == null) goto L9;
        r101.observe("action_show_device", this);
    L9:
        V();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void V() {
        if (this.f108349q == false) goto L5;
        return;
    L5:
        ViewGroup r100 = this.f108347o;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("castScreenVideoConnectContainer");
    L8:
        LiveTetris.Q(this, ReplayCastScreenConnectWidgetForByteCast.class, r100, false, null, 24);
        this.f108349q = true;
    }

    public ReplayCastScreenTetris() {
        this.f108348p = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.f108348p.dispose();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_replay_tetris_cast_screen);
        this.f108347o = (ViewGroup) r101.findViewById(R.id.cast_screen_connect);
        return r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == 171414863) goto L12;
        return;
    L12:
        if (r102.equals("action_show_device") == true) goto L14;
        return;
    L14:
        if (this.f108349q == true) goto L18;
        V();
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().n(this.f108350r, r101);
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
