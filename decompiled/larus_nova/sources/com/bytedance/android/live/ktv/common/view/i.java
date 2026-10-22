package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.viewmodel.OpusPreviewViewModel;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusPreviewDialog$previewListViewHolderProvider$1;
import com.bytedance.android.livesdk.message.model.od;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends g<od> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f70832h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f70833a;

        public a(i r100) {
            this.f70833a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f70833a.f70832h.invoke();
        }
    }

    @Override // com.bytedance.android.live.ktv.common.view.g
    public final View e() {
        FrameLayout r100 = this.f70822c;
        if (r100 != null) goto L7;
        FrameLayout r101 = new FrameLayout(getContext());
        this.f70822c = r101;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, -2);
        r102.topMargin = s1.f(10.0f);
        r102.bottomMargin = s1.f(10.0f);
        r102.leftMargin = s1.f(10.0f);
        r102.rightMargin = s1.f(10.0f);
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        TextView r104 = new TextView(r101.getContext());
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 19;
        r104.setLayoutParams(r105);
        r104.setText(R.string.ttlive_ktv_official_opus);
        r104.setTextColor(-16777216);
        r104.setTextSize(1, 14.0f);
        r101.addView(r104);
        TextView r106 = new TextView(r101.getContext());
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = 21;
        r106.setLayoutParams(r107);
        r106.setText(R.string.ttlive_ktv_change_opus);
        r106.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ttlive_ktv_change_mv, 0, 0, 0);
        r106.setCompoundDrawablePadding(s1.f(3.0f));
        r106.setTextColor(-16777216);
        r106.setOnClickListener(new a(this));
        r106.setTextSize(1, 15.0f);
        r101.addView(r106);
        return r101;
    L7:
        return r100;
    }

    public i(Context r100, OpusPreviewViewModel r101, OpusPreviewDialog$previewListViewHolderProvider$1 r102, com.bytedance.android.livesdk.ktvapi.model.mv.i r103, Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vm");
        Intrinsics.checkNotNullParameter(r102, "vhProvider");
        Intrinsics.checkNotNullParameter(r104, "changeMvCallback");
        super(r100, r102, r103);
        this.f70832h = r104;
    }
}
