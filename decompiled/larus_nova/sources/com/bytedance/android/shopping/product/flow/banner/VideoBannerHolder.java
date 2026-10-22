package com.bytedance.android.shopping.product.flow.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "d", "VolumeView", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoBannerHolder extends BannerHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECVideoPlayer f182346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f182347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VolumeView f182348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public yg3.b f182349d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$VolumeView;", "Landroid/widget/FrameLayout;", "", "value", "b", "Z", "isMute", "()Z", "setMute", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VolumeView extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f182350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f182351b;

        public VolumeView(Context r100) {
            AttributeSet r101 = null;
            this(r100, r101, 6, 0);
        }

        public VolumeView(Context r100, AttributeSet r101) {
            this(r100, r101, 4, 0);
        }

        public final void setMute(boolean r100) {
            if (r100 == false) goto L5;
            ViewGroup.LayoutParams r101 = this.f182350a.getLayoutParams();
            float r102 = 16;
            Resources r103 = Resources.getSystem();
            r101.width = MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
            ViewGroup.LayoutParams r104 = this.f182350a.getLayoutParams();
            Resources r105 = Resources.getSystem();
            r104.height = MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
            this.f182350a.setImageResource(R.drawable.commerce_volume_mute);
        L6:
            this.f182351b = r100;
            return;
        L5:
            ViewGroup.LayoutParams r106 = this.f182350a.getLayoutParams();
            Resources r107 = Resources.getSystem();
            r106.width = MathKt.roundToInt(TypedValue.applyDimension(1, 14, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
            ViewGroup.LayoutParams r108 = this.f182350a.getLayoutParams();
            Resources r109 = Resources.getSystem();
            r108.height = MathKt.roundToInt(TypedValue.applyDimension(1, 11, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())));
            this.f182350a.setImageResource(R.drawable.commerce_volume_unmute);
            goto L6
        }

        public VolumeView(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101, r102);
            LayoutInflater.from(r100).inflate(R.layout.shopping_inflow_feed_volume_view, this);
            this.f182350a = (ImageView) findViewById(R.id.volume_iv);
        }

        public /* synthetic */ VolumeView(Context r100, AttributeSet r101, int r102, int r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, 0);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoBannerHolder f182352a;

        public a(VideoBannerHolder r100) {
            this.f182352a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f182352a.getClass();
        }
    }

    public static final class b implements com.bytedance.android.shopping.widget.ecvideoplayer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoBannerHolder f182353a;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void E() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void g() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void h(int r100, int r101) {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onError(Error r100) {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onIdle() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onPaused() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onPlaying() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onRelease() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onVideoSizeChanged(int r100, int r101) {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void w() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onRenderStart() {
            this.f182353a.f182347b.setVisibility(8);
        }

        public b(VideoBannerHolder r100) {
            this.f182353a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoBannerHolder f182354a;

        public c(VideoBannerHolder r100) {
            this.f182354a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VolumeView r101 = this.f182354a.f182348c;
            r101.setMute(!r101.f182351b);
            ECVideoPlayer r102 = this.f182354a.f182346a;
            if (r102 == null) goto L6;
            r102.o(!r102.f187346j);
            return;
        }
    }

    public interface d {
    }

    public VideoBannerHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f182347b = (SimpleDraweeView) r100.findViewById(R.id.video_cover);
        VolumeView r101 = (VolumeView) r100.findViewById(R.id.volume_view);
        this.f182348c = r101;
        ECVideoView r102 = new ECVideoView(r100.getContext(), null, 6, 0);
        ViewGroup r103 = (ViewGroup) r100;
        r103.addView(r102, 0, new ViewGroup.LayoutParams(-1, -1));
        ECVideoPlayer r104 = new ECVideoPlayer(r103.getContext());
        r102.setPlayer(r104);
        Unit r105 = Unit.INSTANCE;
        this.f182346a = r104;
        View r106 = r100.findViewById(R.id.volume_container);
        if (r106 == null) goto L5;
        r106.setOnClickListener(new a(this));
    L5:
        r104.a(new b(this));
        r101.setOnClickListener(new c(this));
    }
}
