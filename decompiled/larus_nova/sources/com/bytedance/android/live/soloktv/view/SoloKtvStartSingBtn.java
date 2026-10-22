package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/SoloKtvStartSingBtn;", "Landroid/widget/FrameLayout;", "", "c", "I", "getContainerWidth", "()I", "setContainerWidth", "(I)V", "containerWidth", "f", "getMinimumProgress", "minimumProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvStartSingBtn extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f101779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f101780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f101781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f101782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f101783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f101784f;

    public final int getContainerWidth() {
        return this.f101781c;
    }

    public final int getMinimumProgress() {
        return this.f101784f;
    }

    public final void setContainerWidth(int r100) {
        this.f101781c = r100;
    }

    public SoloKtvStartSingBtn(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Drawable r102 = getResources().getDrawable(R.drawable.ttlive_soloktv_startsing_btn_bg);
        Drawable r103 = getResources().getDrawable(R.drawable.ttlive_soloktv_startsing_btn_bg_loadding);
        this.f101779a = getResources().getString(R.string.ttlive_solo_ktv_song_loading);
        this.f101780b = getResources().getString(R.string.ttlive_solo_ktv_song_retry);
        View r104 = new View(r100);
        r104.setBackground(r102);
        addView(r104, new FrameLayout.LayoutParams(0, -1));
        Unit r105 = Unit.INSTANCE;
        this.f101782d = r104;
        TextView r106 = new TextView(r100);
        addView(r106, new FrameLayout.LayoutParams(-1, -1));
        r106.setTextColor(ColorProtector.parseColor("#ffffff"));
        r106.setGravity(17);
        r106.setText(R.string.ttlive_solo_ktv_start_sing);
        this.f101783e = r106;
        setBackground(r103);
        this.f101784f = 18;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f101781c = r100;
    }
}
