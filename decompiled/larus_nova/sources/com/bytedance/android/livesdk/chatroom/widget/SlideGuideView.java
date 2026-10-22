package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.uikit.rtl.AutoRTLTextView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$GuideType;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.t3;
import com.larus.nova.R;
import com.ss.ttm.utils.AVLogger;

/* JADX INFO: loaded from: classes8.dex */
public class SlideGuideView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f118691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f118692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AutoRTLTextView f118693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f118694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f118695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f118696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animation f118697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animation f118698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animation f118699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Animation f118700j;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlideGuideView f118701a;

        public a(SlideGuideView r100) {
            this.f118701a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = this.f118701a.f118695e;
            if (r101 == null) goto L6;
            r101.onClick();
            return;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlideGuideView f118702a;

        public b(SlideGuideView r100) {
            this.f118702a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f118702a.f118695e.onClick();
        }
    }

    public class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlideGuideView f118703a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public c(SlideGuideView r100) {
            this.f118703a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f118703a.f118694d.setVisibility(8);
            this.f118703a.f118692b.setVisibility(8);
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f118704a = null;

        static {
            int[] r100 = new int[ClearScreenConst$GuideType.values().length];
            f118704a = r100;
            r100[ClearScreenConst$GuideType.CLEAR_MODE_CHECK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f118704a[ClearScreenConst$GuideType.SHOW_CLEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface e {
        void onClick();
    }

    public final void b() {
        if (this.f118697g == null) goto L5;
    L6:
        this.f118694d.clearAnimation();
    L8:
        if (this.f118698h == null) goto L10;
    L11:
        this.f118692b.clearAnimation();
        return;
    L10:
        if (this.f118700j != null) goto L11;
        return;
    L5:
        if (this.f118699i == null) goto L8;
        goto L6
    }

    public final void e() {
        if (this.f118697g != null) goto L6;
        AlphaAnimation r100 = new AlphaAnimation(0.0f, 1.0f);
        this.f118697g = r100;
        r100.setDuration(160);
    L6:
        if (this.f118698h != null) goto L8;
        AlphaAnimation r101 = new AlphaAnimation(0.0f, 1.0f);
        this.f118698h = r101;
        r101.setDuration(320);
        this.f118698h.setStartOffset(160);
    L8:
        this.f118694d.clearAnimation();
        this.f118692b.clearAnimation();
        this.f118694d.startAnimation(this.f118697g);
        this.f118692b.startAnimation(this.f118698h);
    }

    public final void f() {
        if (this.f118699i != null) goto L6;
        AlphaAnimation r100 = new AlphaAnimation(1.0f, 0.0f);
        this.f118699i = r100;
        r100.setDuration(160);
        this.f118699i.setStartOffset(160);
        this.f118699i.setAnimationListener(new c(this));
    L6:
        if (this.f118700j != null) goto L8;
        AlphaAnimation r101 = new AlphaAnimation(1.0f, 0.0f);
        this.f118700j = r101;
        r101.setDuration(320);
    L8:
        this.f118694d.clearAnimation();
        this.f118692b.clearAnimation();
        this.f118694d.startAnimation(this.f118699i);
        this.f118692b.startAnimation(this.f118700j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r100 = this.f118694d;
        int r101 = r3.f156924a;
        if (r100 == null) goto L6;
        r100.postDelayed(new t3(r100), 100);
        return;
    }

    public SlideGuideView(Context r100) {
        super(r100);
        c(r100);
    }

    public final void a(ClearScreenConst$GuideType r100) {
        int r101 = d.f118704a[r100.ordinal()];
        if (r101 != 1) goto L5;
        int[] r102 = {0, AVLogger.LEVEL_LOG_FATAL, Integer.MIN_VALUE};
        GradientDrawable r103 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, r102);
        this.f118694d.setBackground(r103);
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) this.f118692b.getLayoutParams();
        r104.addRule(12);
        r104.bottomMargin = com.bytedance.android.live.core.utils.s1.f(122.0f);
        this.f118692b.setLayoutParams(r104);
        return;
    L5:
        if (r101 != 2) goto L11;
        this.f118694d.setBackground(getResources().getDrawable(R.color.ttlive_bg_clear_guide));
        return;
    }

    public final void c(Context r100) {
        RelativeLayout.inflate(getContext(), R.layout.ttlive_layout_pop_up_slide_guide, this);
        this.f118694d = findViewById(R.id.container_background);
        this.f118692b = findViewById(R.id.container_root);
        this.f118691a = (LottieAnimationView) findViewById(R.id.slide_guide_view);
        this.f118693c = (AutoRTLTextView) findViewById(R.id.tv_desc);
        if (RTLUtil.isAppRTL(r100) == false) goto L5;
        this.f118693c.setText(R.string.ttlive_slide_right_and_left_to_switch_filter);
    L6:
        r3.a(this.f118694d, this.f118693c.getText().toString());
        RelativeLayout.LayoutParams r101 = (RelativeLayout.LayoutParams) this.f118692b.getLayoutParams();
        r101.addRule(13);
        this.f118692b.setLayoutParams(r101);
        if (this.f118695e != null) goto L9;
        this.f118694d.setClickable(false);
        return;
    L9:
        this.f118694d.setOnClickListener(new a(this));
        return;
    L5:
        this.f118693c.setText(R.string.ttlive_slide_right_to_switch_full_screen);
        goto L6
    }

    public void setAnimResource(String r100) {
        if (this.f118691a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (r100.equals(this.f118696f) == false) goto L9;
        return;
    L9:
        this.f118696f = r100;
        this.f118691a.setAnimation(r100);
        this.f118691a.loop(true);
        this.f118691a.playAnimation();
    }

    public void setAnimResourceGecko(String r100) {
        if (this.f118691a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (r100.equals(this.f118696f) == false) goto L9;
        return;
    L9:
        this.f118696f = r100;
        String r101 = com.bytedance.android.livesdk.chatroom.utils.i2.f114501a;
        com.bytedance.android.livesdk.chatroom.utils.i2.g(this.f118691a, "/guideview/".concat(r100));
    }

    public void setClickListener(e r100) {
        this.f118694d.setClickable(true);
        this.f118695e = r100;
        this.f118694d.setOnClickListener(new b(this));
    }

    public void setDestText(String r100) {
        AutoRTLTextView r101 = this.f118693c;
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        r3.a(this.f118694d, r100);
    }

    public void setDestTextSize(int r100) {
        AutoRTLTextView r101 = this.f118693c;
        if (r101 == null) goto L6;
        r101.setTextSize(1, r100);
        return;
    }

    public SlideGuideView(Context r100, AttributeSet r101) {
        super(r100, r101);
        c(r100);
    }

    public void d(String r100, String r101) {
        if (this.f118691a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        if (r100.equals(this.f118696f) == false) goto L11;
        return;
    L11:
        this.f118696f = r100;
        this.f118691a.setAnimation(r100);
        this.f118691a.setImageAssetsFolder(r101);
        this.f118691a.loop(true);
        this.f118691a.playAnimation();
    }

    public SlideGuideView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        c(r100);
    }
}
