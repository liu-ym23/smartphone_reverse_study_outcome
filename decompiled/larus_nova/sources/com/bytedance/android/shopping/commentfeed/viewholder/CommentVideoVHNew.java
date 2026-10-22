package com.bytedance.android.shopping.commentfeed.viewholder;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import bc3.e;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.core.widget.d;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.h;
import com.bytedance.android.shopping.commentfeed.widget.VideoPlaySeekBar;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentVideoVHNew;", "Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentBaseViewHolder;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentVideoVHNew extends CommentBaseViewHolder implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f172391o = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f172392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f172393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECVideoPlayerView f172394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f172395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f172396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VideoPlaySeekBar f172397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f172398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECStatusView f172399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PromotionVideoInfo f172400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f172401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f172402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f172403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f172404n;

    public static final class a implements h {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CommentVideoVHNew f172405g;

        public c(CommentVideoVHNew r100) {
            this.f172405g = r100;
            super(null, null, 3);
        }

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            if (this.f172405g.f172394d.h() == false) goto L5;
            CommentVideoVHNew r101 = this.f172405g;
            r101.f172394d.m();
            r101.f172396f.setVisibility(0);
            return;
        L5:
            this.f172405g.play();
        }
    }

    static {
        f172391o = com.bytedance.android.shopping.extensions.b.b(78);
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void T3() {
        com.bytedance.android.ec.sdk.helper.c.f48117a.b(this.f172392b, "attachToWindow");
        if (this.f172394d.h() == true) goto L6;
        W3();
        return;
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void U3() {
        com.bytedance.android.ec.sdk.helper.c.f48117a.b(this.f172392b, "detachFromWindow");
        this.f172394d.x();
        this.f172396f.setVisibility(0);
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void V3() {
        this.f172394d.x();
        this.f172396f.setVisibility(0);
        this.f172394d.s();
    }

    public final void W3() {
        if (NetworkUtils.isWifi(this.f172382a.getContext()) == false) goto L6;
        play();
        return;
    }

    public final void play() {
        if (this.f172394d.h() == true) goto L6;
        this.f172394d.n();
        this.f172396f.setVisibility(8);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        e r101 = this.f172404n;
        if (r101 == null) goto L6;
        r101.b();
    L6:
        if (this.f172401k == false) goto L16;
        this.f172398h.setVisibility(8);
        Drawable r102 = this.f172397g.getProgressDrawable();
        if (r102 == null) goto L15;
        LayerDrawable r103 = (LayerDrawable) r102;
        Drawable r104 = r103.findDrawableByLayerId(R.id.progress);
        Drawable r105 = r103.findDrawableByLayerId(R.id.background);
        this.f172397g.setThumbOffset(2);
        if (r104 == null) goto L12;
        r104.setColorFilter(th.a.f(this.f172382a.getContext()).getColor(com.larus.nova.R.color.commerce_color_FFFFFF), PorterDuff.Mode.SRC);
    L12:
        if (r105 == null) goto L17;
        r105.setColorFilter(th.a.f(this.f172382a.getContext()).getColor(com.larus.nova.R.color.shopping_color_33FFFFFF), PorterDuff.Mode.SRC);
        return;
    L17:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        e r101 = this.f172404n;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        ECVideoPlayerView r102 = this.f172394d;
        if (r102 == null) goto L11;
        if (r102.g() != true) goto L11;
        play();
    L11:
        if (this.f172401k == false) goto L21;
        this.f172398h.setVisibility(8);
        Drawable r103 = this.f172397g.getProgressDrawable();
        if (r103 == null) goto L20;
        LayerDrawable r104 = (LayerDrawable) r103;
        Drawable r105 = r104.findDrawableByLayerId(R.id.progress);
        Drawable r106 = r104.findDrawableByLayerId(R.id.background);
        this.f172397g.setThumbOffset(0);
        if (r105 == null) goto L17;
        r105.setColorFilter(th.a.f(this.f172382a.getContext()).getColor(com.larus.nova.R.color.commerce_color_4DFFFFFF), PorterDuff.Mode.SRC);
    L17:
        if (r106 == null) goto L21;
        r106.setColorFilter(th.a.f(this.f172382a.getContext()).getColor(com.larus.nova.R.color.shopping_color_14FFFFFF), PorterDuff.Mode.SRC);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L21:
        if (r100 != null) goto L32;
        return;
    L32:
        float r107 = (r100.getProgress() * 100) / r100.getMax();     // Catch: Exception -> L29
        if (this.f172400j == null) goto L34;
        ECVideoPlayerView r108 = this.f172394d;     // Catch: Exception -> L29
        if (r108 == null) goto L35;
        r108.v(r107);     // Catch: Exception -> L29
        return;
    L35:
        return;
    L34:
        return;
    L29:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    public CommentVideoVHNew(View r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f172404n = r101;
        this.f172392b = "CommentVideoVHNew[" + hashCode() + ']';
        View r102 = r100.findViewById(com.larus.nova.R.id.ec_comment_video_rootview);
        this.f172393c = r102;
        ECVideoPlayerView r103 = (ECVideoPlayerView) r100.findViewById(com.larus.nova.R.id.ec_comment_video_player_view);
        this.f172394d = r103;
        this.f172395e = (SimpleDraweeView) r100.findViewById(com.larus.nova.R.id.ec_comment_sv_video_cover);
        ImageView r104 = (ImageView) r100.findViewById(com.larus.nova.R.id.ec_comment_video_play_btn);
        this.f172396f = r104;
        VideoPlaySeekBar r105 = (VideoPlaySeekBar) r100.findViewById(com.larus.nova.R.id.ec_comment_video_seekbar);
        this.f172397g = r105;
        this.f172398h = (TextView) r100.findViewById(com.larus.nova.R.id.ec_comment_tv_video_play_duration);
        this.f172399i = (ECStatusView) r100.findViewById(com.larus.nova.R.id.ec_comment_video_load_status_icon);
        this.f172402l = -1;
        this.f172403m = true;
        c r106 = new c(this);
        r105.setOnSeekBarChangeListener(this);
        r103.r(new a());
        r102.setOnClickListener(r106);
        r104.setOnClickListener(r106);
    }

    public final void X3(String r110, ECUrlModel r210) {
        this.f172399i.b(this.f172382a.getContext(), null, null);
        if (r210 == null) goto L5;
        h0.d(this.f172395e, r210, null, null, null, null, null, 120);
        return;
    L5:
        if (r110 == null) goto L9;
        h0.e(this.f172395e, r110, null, null, null, 120);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        PromotionVideoInfo r103 = this.f172400j;
        if (r103 == null) goto L21;
        long r104 = (long) (((r101 * 1.0f) / 100) * r103.getDuration());
        if (r102 == true) goto L7;
        return;
    L7:
        if (this.f172401k == true) goto L9;
        this.f172398h.setVisibility(8);
        return;
    L9:
        this.f172398h.setVisibility(0);
        PromotionVideoInfo r105 = this.f172400j;
        if (r105 == null) goto L24;
        Long r106 = Long.valueOf(r105.getDuration());
        if (r106.longValue() <= 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L18;
        r106 = null;
    L18:
        if (r106 == null) goto L25;
        long r108 = r106.longValue();
        SpannableStringBuilder r109 = new SpannableStringBuilder();
        int r110 = com.bytedance.android.shopping.anchorv3.utils.h.f165310a;
        SpannableString r111 = new SpannableString(Intrinsics.stringPlus(com.bytedance.android.shopping.anchorv3.utils.h.a(this.f172382a.getContext(), r104), " / "));
        r111.setSpan(new ForegroundColorSpan(th.a.f(this.f172382a.getContext()).getColor(com.larus.nova.R.color.shopping_color_FCFFFFFF)), 0, r111.length(), 17);
        r109.append(r111);
        SpannableString r112 = new SpannableString(com.bytedance.android.shopping.anchorv3.utils.h.a(this.f172382a.getContext(), r108));
        r112.setSpan(new ForegroundColorSpan(th.a.f(this.f172382a.getContext()).getColor(com.larus.nova.R.color.shopping_color_80FFFFFF)), 0, r112.length(), 17);
        r109.append(r112);
        this.f172398h.setText(r109);
        return;
    L25:
        return;
    L14:
        r107 = false;
        goto L15
    L24:
        return;
    }
}
