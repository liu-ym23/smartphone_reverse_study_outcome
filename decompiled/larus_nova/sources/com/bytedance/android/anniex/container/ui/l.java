package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import bolts.Task;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y36.r;

/* JADX INFO: loaded from: classes43.dex */
public final class l extends com.bytedance.android.anniex.base.service.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f40595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f40596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f40597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f40598e;

    public static final class a {
    }

    static {
    }

    public l() {
        this.f40594a = true;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void b(int r100) {
        FrameLayout r101 = this.f40595b;
        if (r101 == null) goto L6;
        r101.setBackgroundColor(r100);
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        TextView r101 = this.f40597d;
        if (r101 == null) goto L7;
        SpannableString r102 = new SpannableString(r100);
        r102.setSpan(new StyleSpan(1), 0, r102.length(), 33);
        r101.setText(r102);
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void d(int r100) {
        TextView r101 = this.f40597d;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void e(boolean r100) {
        FrameLayout r101 = this.f40595b;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void f(boolean r100) {
        AppCompatImageView r101 = this.f40596c;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 4;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int h(ia.c r100) {
        if (this.f40594a == true) goto L12;
        t36.d r101 = r100.getSchemaData();
        if (r101 == null) goto L11;
        Integer r102 = (Integer) new r(r101, "title_color").f565862b;
        if (r102 == null) goto L11;
        return r102.intValue();
    L11:
        return ((Number) AnnieXRuntime.a().f40281c.getValue()).intValue();
    L12:
        return ((Number) AnnieXRuntime.a().f40281c.getValue()).intValue();
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final View a(Context r110, ia.c r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, KtvSubElement.CONTAINER);
        LinearLayout r100 = new LinearLayout(r110);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, KtvSubElement.CONTAINER);
        String r101 = r111.getContainerId();
        AppCompatImageView r102 = g(r110, h(r111), R.drawable.title_bar_back_btn);
        r102.setOnClickListener(new m(r111, this, r101));
        r100.addView(r102);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, KtvSubElement.CONTAINER);
        String r103 = r111.getContainerId();
        AppCompatImageView r104 = g(r110, h(r111), R.drawable.title_bar_close_btn);
        r104.setOnClickListener(new n(r111, this, r103));
        r104.setVisibility(4);
        this.f40596c = r104;
        r100.addView(r104);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2, GravityCompat.START);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, KtvSubElement.CONTAINER);
        TextView r106 = new TextView(r110);
        r106.setTextSize(2, 17.0f);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.gravity = 17;
        r106.setLayoutParams(r107);
        r106.setGravity(17);
        r106.setMaxEms(9);
        r106.setMaxLines(1);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        r106.setTextColor(h(r111));
        this.f40597d = r106;
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2, 17);
        LinearLayout r109 = new LinearLayout(r110);
        if (this.f40594a == false) goto L5;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, KtvSubElement.CONTAINER);
        String r112 = r111.getContainerId();
        AppCompatImageView r113 = g(r110, h(r111), R.drawable.title_bar_search_btn);
        r113.setOnClickListener(new p(r111, this, r112));
        r109.addView(r113);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, KtvSubElement.CONTAINER);
        String r114 = r111.getContainerId();
        AppCompatImageView r115 = g(r110, h(r111), R.drawable.title_bar_more_btn);
        r115.setOnClickListener(new o(r111, r114, this));
        r109.addView(r115);
    L5:
        this.f40598e = r109;
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(-2, -2, GravityCompat.END);
        if (this.f40594a == false) goto L11;
        MonitorCenter r117 = MonitorCenter.f40289c;
        String r118 = r111.getContainerId();
        List r119 = CollectionsKt.listOf(new String[]{"back", "close", "search_amplifier", "more"});
        r117.getClass();
        Intrinsics.checkNotNullParameter(r119, "buttons");
        if (r118 == null) goto L11;
        Task.callInBackground(new com.bytedance.android.anniex.base.monitor.e(r117, r118, r119));
    L11:
        FrameLayout r120 = new FrameLayout(r110);
        r120.addView(r100, r105);
        TextView r121 = this.f40597d;
        if (r121 == null) goto L14;
        r120.addView(r121, r108);
    L14:
        r120.addView(this.f40598e, r116);
        this.f40595b = r120;
        return r120;
    }

    public static AppCompatImageView g(Context r100, int r101, int r102) {
        int r103 = i16.c.f(8, r100);
        AppCompatImageView r104 = new AppCompatImageView(r100);
        r104.setPadding(r103, r103, r103, r103);
        VectorDrawableCompat r105 = VectorDrawableCompat.create(r100.getResources(), r102, r100.getTheme());
        if (r105 == null) goto L5;
        r105.setTint(r101);
    L5:
        r104.setImageDrawable(r105);
        return r104;
    }
}
