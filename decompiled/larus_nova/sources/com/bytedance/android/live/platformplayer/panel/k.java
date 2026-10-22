package com.bytedance.android.live.platformplayer.panel;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.w1;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f85771a;

    public k(o r100) {
        this.f85771a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        w1 r101 = (w1) r100;
        if (r101.f571972b == false) goto L11;
        DialogFragment r102 = r101.f571971a.get();
        if (r102 == null) goto L13;
        Dialog r103 = r102.getDialog();
        if (r103 == null) goto L14;
        View r104 = r103.findViewById(R.id.ttlive_design_bottom_sheet);
        if (r104 == null) goto L15;
        r104.post(new j(this, r101));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L11:
        ds0.b r105 = new ds0.b();
        r105.a(LivePanelType.PERSONAL_PROFILE);
        Intrinsics.checkNotNullParameter("close", "<set-?>");
        r105.f469805b = "close";
        o.a(this.f85771a, r105);
    }
}
