package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusFeedBackView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusFeedBackView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f146316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f146317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f146318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f146319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f146320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f146321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HSImageView f146322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f146323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f146324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f146325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f146326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f146327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f146328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f146329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f146330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f146331p;

    public RealTimeChorusFeedBackView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RealTimeChorusFeedBackView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public RealTimeChorusFeedBackView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_real_time_chorus_feed_back_view, this);
        this.f146316a = (HSImageView) findViewById(R.id.feed_back_first);
        this.f146317b = (HSImageView) findViewById(R.id.feed_back_second);
        this.f146318c = (HSImageView) findViewById(R.id.feed_back_third);
        this.f146319d = (HSImageView) findViewById(R.id.feed_back_four);
        this.f146320e = (HSImageView) findViewById(R.id.feed_back_five);
        this.f146321f = (HSImageView) findViewById(R.id.feed_back_six);
        this.f146322g = (HSImageView) findViewById(R.id.feed_back_seven);
        this.f146326k = (TextView) findViewById(R.id.feed_back_first_score);
        this.f146327l = (TextView) findViewById(R.id.feed_back_second_score);
        this.f146328m = (TextView) findViewById(R.id.feed_back_third_score);
        this.f146329n = (TextView) findViewById(R.id.feed_back_song_score);
        this.f146330o = (TextView) findViewById(R.id.feed_back_song_name);
        this.f146331p = (TextView) findViewById(R.id.feed_back_singer_number);
        this.f146323h = (ImageView) findViewById(R.id.chorus_first_crown);
        this.f146324i = (ImageView) findViewById(R.id.chorus_second_crown);
        this.f146325j = (ImageView) findViewById(R.id.chorus_third_crown);
    }

    public /* synthetic */ RealTimeChorusFeedBackView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
