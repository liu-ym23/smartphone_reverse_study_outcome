package com.bytedance.android.shopping.gallery2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.h;
import com.bytedance.android.shopping.api.video.i;
import com.bytedance.android.shopping.utils.g;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/ECVideoViewContainerVHNew;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lee3/d;", "Lcom/bytedance/android/shopping/api/video/h;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVideoViewContainerVHNew extends TransitionViewHolder implements ee3.d, h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f176121h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f176122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f176123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f176124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f176125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SeekBar f176126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f176127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f176128g;

    public static final class a implements TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECVideoViewContainerVHNew f176129a;

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
        public final void onTransitionChanged(int r100, float r101) {
        }

        public a(ECVideoViewContainerVHNew r100) {
            this.f176129a = r100;
        }

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
        public final void onTransitionBegin(int r100) {
            this.f176129a.f176126e.setVisibility(4);
            this.f176129a.f176127f.setVisibility(4);
            this.f176129a.f176125d.setVisibility(4);
            this.f176129a.f176124c.setVisibility(4);
        }

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
        public final void onTransitionEnd(int r100) {
            this.f176129a.f176126e.setVisibility(0);
            this.f176129a.f176127f.setVisibility(0);
            this.f176129a.f176125d.setVisibility(0);
            this.f176129a.f176124c.setVisibility(0);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECVideoViewContainerVHNew f176130a;

        public b(ECVideoViewContainerVHNew r100) {
            this.f176130a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            i r101 = this.f176130a.f176123b;
            boolean r102 = true;
            if (r101 == null) goto L5;
            ECVideoPlayerView r103 = (ECVideoPlayerView) r101;
            r103.k(!r103.f());
        L5:
            ECVideoViewContainerVHNew r104 = this.f176130a;
            ImageView r105 = r104.f176127f;
            i r106 = r104.f176123b;
            if (r106 != null) goto L8;
        L10:
            r102 = false;
        L11:
            r105.setSelected(r102);
            return;
        L8:
            if (((ECVideoPlayerView) r106).f() == true) goto L10;
            goto L10
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECVideoViewContainerVHNew f176131a;

        public c(ECVideoViewContainerVHNew r100) {
            this.f176131a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            this.f176131a.f176126e.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECVideoViewContainerVHNew f176132a;

        public d(ECVideoViewContainerVHNew r100) {
            this.f176132a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            i r101 = this.f176132a.f176123b;
            if (r101 != null) goto L5;
        L9:
            i r102 = this.f176132a.f176123b;
            if (r102 == null) goto L15;
            ((ECVideoPlayerView) r102).n();
            return;
        L15:
            return;
        L5:
            if (((ECVideoPlayerView) r101).h() != true) goto L9;
            i r103 = this.f176132a.f176123b;
            if (r103 == null) goto L13;
            ((ECVideoPlayerView) r103).m();
            return;
        }
    }

    public static final class e implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECVideoViewContainerVHNew f176133a;

        public e(ECVideoViewContainerVHNew r100) {
            this.f176133a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            ECVideoViewContainerVHNew r101 = this.f176133a;
            int r102 = ECVideoViewContainerVHNew.f176121h;
            r101.getClass();
            i r103 = this.f176133a.f176123b;
            if (r103 != null) goto L5;
            return;
        L5:
            if (((ECVideoPlayerView) r103).d() != true) goto L11;
            i r104 = this.f176133a.f176123b;
            if (r104 == null) goto L12;
            ((ECVideoPlayerView) r104).n();
            return;
        L12:
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            if (r100 != null) goto L12;
            return;
        L12:
            i r101 = this.f176133a.f176123b;     // Catch: Exception -> L8
            if (r101 == null) goto L10;
            ((ECVideoPlayerView) r101).v((r100.getProgress() * 100) / r100.getMax());     // Catch: Exception -> L8
        L10:
            this.f176133a.f176124c.setText(g.b(r100.getProgress() / 1000));
            this.f176133a.getClass();
            return;
        L8:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            goto L10
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L5;
            this.f176133a.f176126e.setProgress(r101);
            TextView r103 = this.f176133a.f176124c;
            int r104 = g.f187081a;
            r103.setText(g.b(r101 / 1000));
            return;
        }
    }

    @Override // ee3.d
    public final void J() {
        dm.a.b r100 = dm.a.f469202a;
        dm.a.a(this.f176122a).a("detachOldPlayer");
        i r101 = this.f176123b;
        if (r101 == null) goto L5;
        ((ECVideoPlayerView) r101).t(this);
    L5:
        this.f176123b = null;
    }

    @Override // ee3.d
    public final void onViewAttachedToWindow() {
        i r100 = this.f176123b;
        if (r100 == null) goto L6;
        ((ECVideoPlayerView) r100).n();
        return;
    }

    @Override // ee3.d
    public final void onViewDetachedFromWindow() {
        i r100 = this.f176123b;
        if (r100 == null) goto L6;
        ((ECVideoPlayerView) r100).m();
        return;
    }

    public ECVideoViewContainerVHNew(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f176122a = "ECVideoViewContainerVHNew" + hashCode();
        ECVideoPlayerView r101 = (ECVideoPlayerView) r100.findViewById(R.id.ec_video_view);
        this.f176124c = (TextView) r100.findViewById(R.id.tv_media_progress);
        this.f176125d = (TextView) r100.findViewById(R.id.tv_media_duration);
        SeekBar r102 = (SeekBar) r100.findViewById(R.id.pb_media_progress);
        this.f176126e = r102;
        ImageView r103 = (ImageView) r100.findViewById(R.id.iv_audio_status);
        this.f176127f = r103;
        ImageView r104 = (ImageView) r100.findViewById(R.id.ec_play_iv);
        View r105 = r100.findViewById(R.id.root_container);
        this.f176128g = r105;
        ECStatusView r106 = (ECStatusView) r100.findViewById(R.id.loading_status_view);
        e r107 = new e(this);
        r106.b(r100.getContext(), null, null);
        getTransitionLayout().addTransitionListener(new a(this));
        r103.setOnClickListener(new b(this));
        r102.setOnTouchListener(new c(this));
        r102.setOnSeekBarChangeListener(r107);
        r105.setOnClickListener(new d(this));
    }

    @Override // ee3.d
    public final void W(ee3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "galleryECVideoViewModel");
        J();
        dm.a.b r101 = dm.a.f469202a;
        dm.a.a(this.f176122a).a("attachPlayer");
        this.f176123b = null;
        ImageView r102 = this.f176127f;
        i r103 = this.f176123b;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        r102.setSelected(r104);
        return;
    L5:
        if (((ECVideoPlayerView) r103).f() == true) goto L7;
        r104 = true;
        goto L8
    }
}
