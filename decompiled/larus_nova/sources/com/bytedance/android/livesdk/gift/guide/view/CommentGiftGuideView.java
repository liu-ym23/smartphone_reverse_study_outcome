package com.bytedance.android.livesdk.gift.guide.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.livesdk.gift.guide.viewmodel.CommentGiftGuideViewModel;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.n1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.e;
import cy0.j;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/guide/view/CommentGiftGuideView;", "Lcom/bytedance/android/live/gift/BaseCommentGiftGuideView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "enable", "", "setGuideEnable", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGiftGuideView extends BaseCommentGiftGuideView implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f126343i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f126344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleRegistry f126345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentGiftGuideViewModel f126346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator f126347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f126348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f126349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f126350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f126351h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGiftGuideView f126352a;

        public a(CommentGiftGuideView r100) {
            this.f126352a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CommentGiftGuideView r101 = this.f126352a;
            int r102 = CommentGiftGuideView.f126343i;
            r101.e("click");
            this.f126352a.f126346c.sendCommentGift();
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGiftGuideView f126353a;

        public c(CommentGiftGuideView r100) {
            this.f126353a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            zy1.a r101 = (zy1.a) r100;
            CommentGiftGuideView r102 = this.f126353a;
            int r103 = CommentGiftGuideView.f126343i;
            r102.getClass();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.f573907a == false) goto L32;
            Animator r104 = r102.f126347d;
            k r105 = null;
            if (r104 != null) goto L9;
        L14:
            ImageLoader.bindImage((HSImageView) r102.c(R.id.gift_icon_view), r101.f573910d);
            ((TextView) r102.c(R.id.gift_diamond)).setText(String.valueOf(r101.f573912f));
            ImageView r106 = (ImageView) r102.c(R.id.coin_icon);
            DiamondConfig r107 = r101.f573911e;
            if (r107 == null) goto L17;
            r105 = r107.f126568a;
        L17:
            ImageUtil.loadImage(r106, r105, 0);
            r102.setTranslationX(r102.getWidth());
            ConstraintLayout r108 = (ConstraintLayout) r102.c(R.id.comment_gift_guide_container);
            if (r108 == null) goto L21;
            r108.setVisibility(0);
        L21:
            if (TextUtils.isEmpty(r101.f573909c) == false) goto L25;
            HSImageView r109 = (HSImageView) r102.c(R.id.comment_gift_guide_animation_view);
            if (r109 == null) goto L31;
            r109.setVisibility(8);
        L31:
            ImageLoader.bindImage((HSImageView) r102.c(R.id.comment_gift_guide_background), r101.f573908b);
            r102.postDelayed(new az1.a(r102), 100);
            HashMap r110 = new HashMap();
            r110.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r101.f573913g));
            r110.put("gift_price", String.valueOf(r101.f573912f));
            n r111 = new n();
            Map<String, String> r112 = r111.f516447a;
            Intrinsics.checkNotNullParameter(r112, "map");
            Intrinsics.checkNotNullParameter(r110, "map");
            r112.putAll(r110);
            m r113 = new m();
            r113.b(LogCommon.ROOM);
            r113.b(LogCommon.PAGE_SOURCE_LOG);
            ((ArrayList) r111.f516448b).addAll(r113.f516446a);
            e.f465759a.getClass();
            j r114 = e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r115 = com.bytedance.android.scope.m.b(r114).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r115);
            ((i) ((f80.a) r115)).w3("gift_guide_show", r111.f516447a, r111.f516448b);
            return;
        L25:
            HSImageView r116 = (HSImageView) r102.c(R.id.comment_gift_guide_animation_view);
            if (r116 == null) goto L28;
            r116.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r101.f573909c)).setAutoPlayAnimations(true).build());
        L28:
            HSImageView r117 = (HSImageView) r102.c(R.id.comment_gift_guide_animation_view);
            if (r117 == null) goto L31;
            r117.setVisibility(0);
            goto L31
        L9:
            if (r104.isRunning() == true) goto L12;
            r104 = null;
        L12:
            if (r104 == null) goto L14;
            r104.removeAllListeners();
            r104.cancel();
            goto L14
        L32:
            r102.e("unmatched");
        }
    }

    public static final class d extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGiftGuideView f126354a;

        public d(CommentGiftGuideView r100) {
            this.f126354a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100, r101);
            ConstraintLayout r102 = (ConstraintLayout) this.f126354a.c(R.id.comment_gift_guide_container);
            if (r102 == null) goto L6;
            r102.setVisibility(4);
            return;
        }
    }

    static {
    }

    public CommentGiftGuideView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentGiftGuideView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f126345b.markState(Lifecycle.State.STARTED);
        this.f126346c.getCommentGiftGuideModel().observe(this, new c(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f126345b.markState(Lifecycle.State.DESTROYED);
        Disposable r100 = this.f126348e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        zy1.a r101 = this.f126346c.getCommentGiftGuideModel().getValue();
        if (r101 != null) goto L8;
    L10:
        this.f126346c.getCommentGiftGuideModel().removeObservers(this);
        return;
    L8:
        if (r101.f573907a != true) goto L10;
        e("user_pack_up");
        goto L10
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.f126345b;
    }

    @Override // com.bytedance.android.live.gift.BaseCommentGiftGuideView
    public final void a(String r100) {
        if (this.f126349f == true) goto L5;
        return;
    L5:
        this.f126346c.onCommentChanged(r100);
    }

    @Override // com.bytedance.android.live.gift.BaseCommentGiftGuideView
    public final void b(n1.a r100) {
        this.f126346c.setSendGiftListener(r100);
    }

    public final View c(int r100) {
        if (this.f126344a != null) goto L5;
        this.f126344a = new LinkedHashMap();
    L5:
        View r101 = this.f126344a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f126344a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void e(String r100) {
        if (this.f126351h == true) goto L5;
        return;
    L5:
        Disposable r101 = this.f126348e;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f126351h = false;
        Animator r102 = this.f126347d;
        if (r102 != null) goto L11;
    L16:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, getWidth()});
        this.f126347d = r103;
        if (r103 == null) goto L19;
        r103.setDuration(200);
        r103.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r103.addListener(new d(this));
        r103.start();
    L19:
        zy1.a r104 = this.f126346c.getCommentGiftGuideModel().getValue();
        if (r104 == null) goto L22;
        r104.f573907a = false;
    L22:
        HashMap r105 = new HashMap();
        zy1.a r106 = this.f126346c.getCommentGiftGuideModel().getValue();
        if (r106 == null) goto L25;
        long r107 = r106.f573913g;
    L26:
        r105.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r107));
        zy1.a r108 = this.f126346c.getCommentGiftGuideModel().getValue();
        if (r108 == null) goto L29;
        Number r109 = Integer.valueOf(r108.f573912f);
    L30:
        r105.put("gift_price", r109.toString());
        r105.put("duration", String.valueOf((System.currentTimeMillis() - this.f126350g) / 1000.0f));
        r105.put("end_type", r100);
        n r110 = new n();
        Map<String, String> r111 = r110.f516447a;
        Intrinsics.checkNotNullParameter(r111, "map");
        Intrinsics.checkNotNullParameter(r105, "map");
        r111.putAll(r105);
        m r112 = new m();
        r112.b(LogCommon.ROOM);
        r112.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r110.f516448b).addAll(r112.f516446a);
        e.f465759a.getClass();
        j r113 = e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r113).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r114);
        ((i) ((f80.a) r114)).w3("gift_guide_end", r110.f516447a, r110.f516448b);
        return;
    L29:
        r109 = 0L;
        goto L30
    L25:
        r107 = 0;
        goto L26
    L11:
        if (r102.isRunning() == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L16;
        r102.removeAllListeners();
        r102.cancel();
        goto L16
    }

    @Override // com.bytedance.android.live.gift.BaseCommentGiftGuideView
    public void setGuideEnable(boolean r100) {
        this.f126349f = r100;
        if (r100 == true) goto L9;
        Disposable r101 = this.f126348e;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        e("unmatched");
        return;
    }

    public CommentGiftGuideView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f126344a = new LinkedHashMap();
        this.f126346c = (CommentGiftGuideViewModel) ViewModelProviders.of((FragmentActivity) r100).get(CommentGiftGuideViewModel.class);
        this.f126349f = true;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_comment_gift_guide_view, this);
        LifecycleRegistry r103 = new LifecycleRegistry(this);
        this.f126345b = r103;
        r103.markState(Lifecycle.State.CREATED);
        View r104 = c(R.id.gift_info_bg);
        if (r104 == null) goto L6;
        r104.setOnClickListener(new a(this));
        return;
    }

    public /* synthetic */ CommentGiftGuideView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
