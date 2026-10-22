package com.bytedance.android.live.ktv.common.view.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.message.model.ag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/OfficialMvListVh;", "Lcom/bytedance/android/live/ktv/common/view/adapter/SoloMvListVh;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OfficialMvListVh extends SoloMvListVh {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f70772j;

    public OfficialMvListVh(View r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "adapterClickCb");
        super(r100, r101);
        TextView r102 = new TextView(r100.getContext());
        r102.setTextColor(-1);
        r102.setTextSize(2, 13.0f);
        Unit r103 = Unit.INSTANCE;
        this.f70772j = r102;
        ViewGroup r104 = (ViewGroup) r100;
        FrameLayout r105 = this.f70792d;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-1, SoloMvListVh.f70786g);
        r106.gravity = 1;
        r104.addView(r105, r106);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.gravity = 1;
        r107.topMargin = SoloMvListVh.f70787h;
        r104.addView(r102, r107);
    }

    @Override // com.bytedance.android.live.ktv.common.view.adapter.SoloMvListVh
    public final void T3(c r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.T3(r100, r101, r102);
        TextView r103 = this.f70772j;
        ag r104 = r100.f70803a.a();
        if (r104 == null) goto L9;
        String r105 = r104.c();
        if (r105 == null) goto L9;
        if ((!TextUtils.isEmpty(r105)) == false) goto L9;
    L10:
        r103.setText(r105);
        return;
    L9:
        r105 = null;
        goto L10
    }
}
