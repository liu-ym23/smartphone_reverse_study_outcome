package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f144477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f144478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f144479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f144480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f144481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f144482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f144483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f144484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f144485i;

    public final void c() {
        ConstraintLayout r100 = this.f144480d;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    public i0() {
        this.f144484h = ArraysKt.toFloatArray(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.3f), Float.valueOf(0.7f)});
        this.f144485i = ArraysKt.toIntArray(new Integer[]{Integer.valueOf(ColorProtector.parseColor("#fff6fd")), Integer.valueOf(ColorProtector.parseColor("#ffe9d5")), Integer.valueOf(ColorProtector.parseColor("#f9c19a"))});
    }

    public final void b(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f144480d = r100;
        this.f144477a = (ImageView) r100.findViewById(R.id.ttlive_ktv_component_feedback_watermark_iv);
        this.f144478b = (TextView) r100.findViewById(R.id.ktv_component_feed_back_music_name);
        this.f144479c = (TextView) r100.findViewById(R.id.ktv_component_feed_back_tips);
        this.f144481e = (TextView) r100.findViewById(R.id.ktv_component_feed_back_score_number);
        this.f144482f = (TextView) r100.findViewById(R.id.ktv_component_feed_back_score);
        this.f144483g = (ImageView) r100.findViewById(R.id.ktv_component_feed_back_high_score_achievement);
    }

    public static final void a(i0 r110, TextView r111, float r112, float r113) {
        r110.getClass();
        if (Build.VERSION.SDK_INT < 29) goto L5;
        LinearGradient r100 = new LinearGradient(0.0f, 0.0f, r112, r113, r110.f144485i, r110.f144484h, Shader.TileMode.CLAMP);
        r111.getPaint().setShader(r100);
        return;
    L5:
        r111.setTextColor(ColorProtector.parseColor("#F9C19A"));
    }
}
