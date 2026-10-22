package com.bytedance.android.live.effect.beauty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautifyTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "name", "", "setTabName", "", "resId", "", "visible", "setDotVisibility", "getSelectedStatus", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautifyTabItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f67019g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f67020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f67021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f67022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f67023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f67024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f67025f;

    public static final class a {
    }

    public BeautifyTabItemView(Context r100) {
        this(r100, false, false, 62);
    }

    static {
        f67019g = (int) (s1.t() * 0.032f);
    }

    public final boolean getSelectedStatus() {
        return this.f67023d;
    }

    public final void setDotVisibility(boolean r100) {
        View r101 = this.f67021b;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.A(r101, r100);
        return;
    }

    public final void setTabName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        TextView r101 = this.f67020a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTabName(int r100) {
        TextView r101 = this.f67020a;
        if (r101 == null) goto L6;
        r101.setText(s1.B(r100));
        return;
    }

    public BeautifyTabItemView(Context r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 16) == 0) goto L8;
        r102 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        if (r101 == true) goto L13;
        if (r102 == true) goto L13;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_effect_beautify_tab_item, this);
    L14:
        TextView r104 = (TextView) findViewById(R.id.tv_name);
        this.f67020a = r104;
        this.f67021b = findViewById(R.id.dot);
        this.f67022c = findViewById(R.id.indicator);
        View r105 = findViewById(R.id.bt_beauty);
        this.f67024e = r105;
        this.f67025f = findViewById(R.id.cl_tag);
        if (r102 == false) goto L25;
        if (r101 == true) goto L26;
        if (r105 == null) goto L19;
        a1.p(r105, 0);
    L19:
        int r106 = f67019g;
        if (r104 == null) goto L22;
        a1.m(r104, r106);
    L22:
        if (r104 == null) goto L27;
        a1.n(r104, r106);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L13:
        LayoutInflater.from(r100).inflate(R.layout.ttlive_effect_beautify_new_tab_item, this);
        goto L14
    }
}
