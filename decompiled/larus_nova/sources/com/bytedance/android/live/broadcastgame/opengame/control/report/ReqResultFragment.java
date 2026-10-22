package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/control/report/ReqResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReqResultFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super Integer, ? super Intent, Unit> f59949d;

    public ReqResultFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Function2<? super Integer, ? super Intent, Unit> r103 = this.f59949d;
        if (r103 == null) goto L6;
        Unit r104 = r103.invoke(Integer.valueOf(r101), r102);
        return;
    }
}
