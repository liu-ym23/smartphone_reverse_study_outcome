package c90;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.widget.bubble.LiveBubbleLayout;
import com.bytedance.android.live.core.widget.f;
import com.bytedance.android.live.core.widget.h;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c90.a f22818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveBubbleLayout f22819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f22820c;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f22821a;

        public a(b r100) {
            this.f22821a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            b r101 = this.f22821a;
            if (r101.f22820c == true) goto L9;
            r101.f22819b.setVisibility(8);
            c90.a.c r102 = this.f22821a.f22818a.D;
            if (r102 == null) goto L7;
            r102.bubbleDismiss();
        L7:
            this.f22821a.f22818a.g();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            b r101 = this.f22821a;
            if (r101.f22820c == false) goto L9;
            c90.a.d r102 = r101.f22818a.C;
            if (r102 == null) goto L7;
            r102.bubbleShow();
        L7:
            this.f22821a.f22819b.setVisibility(0);
            return;
        }
    }

    public b(c90.a r100, LiveBubbleLayout r101, boolean r102) {
        this.f22818a = r100;
        this.f22819b = r101;
        this.f22820c = r102;
    }

    public final void a() {
        c90.a r100 = this.f22818a;
        if (r100.f22791z != null) goto L5;
        return;
    L5:
        int r101 = r100.f22772g;
        if (r101 == 3) goto L23;
        if (r101 == 5) goto L19;
        if (r101 == 48) goto L15;
        if (r101 == 80) goto L11;
        int r102 = 0;
        int r103 = 0;
    L30:
        this.f22819b.setPivotY(r103);
        this.f22819b.setPivotX(r102);
        LiveBubbleLayout r104 = this.f22819b;
        float[] r105 = new float[2];
        boolean r106 = this.f22820c;
        float r110 = 1.0f;
        if (r106 == false) goto L33;
        float r111 = 0.0f;
    L34:
        r105[0] = r111;
        if (r106 == false) goto L37;
        float r107 = 1.0f;
    L38:
        r105[1] = r107;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.SCALE_X, r105);
        long r109 = 200;
        r108.setDuration(200);
        LiveBubbleLayout r112 = this.f22819b;
        float[] r113 = new float[2];
        boolean r114 = this.f22820c;
        if (r114 == false) goto L41;
        float r115 = 0.0f;
    L42:
        r113[0] = r115;
        if (r114 == true) goto L46;
        r110 = 0.0f;
    L46:
        r113[1] = r110;
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_Y, r113);
        r116.setDuration(200);
        ObjectAnimator r117 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        if (this.f22820c == false) goto L49;
        r109 = 500;
    L49:
        r117.setDuration(r109);
        ObjectAnimator r118 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        if (this.f22820c == false) goto L52;
        long r119 = 500;
    L53:
        r118.setDuration(r119);
        ObjectAnimator r120 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.f22820c == false) goto L56;
        long r121 = 500;
    L57:
        r120.setDuration(r121);
        ObjectAnimator r122 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.f22820c == false) goto L60;
        long r123 = 500;
    L61:
        r122.setDuration(r123);
        ObjectAnimator r124 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, 10.0f});
        if (this.f22820c == false) goto L64;
        long r125 = 200;
    L65:
        r124.setDuration(r125);
        ObjectAnimator r126 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -10.0f});
        if (this.f22820c == false) goto L68;
        long r127 = 200;
    L69:
        r126.setDuration(r127);
        ObjectAnimator r128 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -10.0f});
        if (this.f22820c == false) goto L72;
        long r129 = 200;
    L73:
        r128.setDuration(r129);
        ObjectAnimator r130 = ObjectAnimator.ofFloat(this.f22819b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, 10.0f});
        if (this.f22820c == false) goto L76;
        long r131 = 200;
    L77:
        r130.setDuration(r131);
        this.f22819b.setVisibility(0);
        if (this.f22820c == false) goto L152;
        int r132 = this.f22818a.f22772g;
        if (r132 != 3) goto L82;
        r128.setInterpolator(new h());
        r122.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r133 = this.f22818a;
        if (r133.f22777l == false) goto L147;
        AnimatorSet r134 = r133.f22791z;
        if (r134 == null) goto L225;
        AnimatorSet.Builder r135 = r134.play(r108);
        if (r135 == null) goto L225;
        AnimatorSet.Builder r136 = r135.with(r116);
        if (r136 == null) goto L225;
        AnimatorSet.Builder r137 = r136.with(r128);
        if (r137 == null) goto L225;
        r137.before(r122);
    L225:
        AnimatorSet r138 = this.f22818a.f22791z;
        if (r138 == null) goto L228;
        r138.addListener(new a(this));
    L228:
        this.f22818a.getClass();
        AnimatorSet r139 = this.f22818a.f22791z;
        if (r139 == null) goto L232;
        r139.start();
        return;
    L232:
        return;
    L147:
        AnimatorSet r140 = r133.f22791z;
        if (r140 == null) goto L225;
        AnimatorSet.Builder r141 = r140.play(r108);
        if (r141 == null) goto L225;
        r141.with(r116);
        goto L225
    L82:
        if (r132 != 5) goto L84;
        r130.setInterpolator(new h());
        r120.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r142 = this.f22818a;
        if (r142.f22777l == false) goto L131;
        AnimatorSet r143 = r142.f22791z;
        if (r143 == null) goto L225;
        AnimatorSet.Builder r144 = r143.play(r108);
        if (r144 == null) goto L225;
        AnimatorSet.Builder r145 = r144.with(r116);
        if (r145 == null) goto L225;
        AnimatorSet.Builder r146 = r145.with(r130);
        if (r146 == null) goto L225;
        r146.before(r120);
        goto L225
    L131:
        AnimatorSet r147 = r142.f22791z;
        if (r147 == null) goto L225;
        AnimatorSet.Builder r148 = r147.play(r108);
        if (r148 == null) goto L225;
        r148.with(r116);
        goto L225
    L84:
        if (r132 != 48) goto L86;
        r126.setInterpolator(new h());
        r117.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r149 = this.f22818a;
        if (r149.f22777l == false) goto L115;
        AnimatorSet r150 = r149.f22791z;
        if (r150 == null) goto L225;
        AnimatorSet.Builder r151 = r150.play(r108);
        if (r151 == null) goto L225;
        AnimatorSet.Builder r152 = r151.with(r116);
        if (r152 == null) goto L225;
        AnimatorSet.Builder r153 = r152.with(r126);
        if (r153 == null) goto L225;
        r153.before(r117);
        goto L225
    L115:
        AnimatorSet r154 = r149.f22791z;
        if (r154 == null) goto L225;
        AnimatorSet.Builder r155 = r154.play(r108);
        if (r155 == null) goto L225;
        r155.with(r116);
        goto L225
    L86:
        if (r132 != 80) goto L225;
        r124.setInterpolator(new h());
        r118.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r156 = this.f22818a;
        if (r156.f22777l == false) goto L99;
        AnimatorSet r157 = r156.f22791z;
        if (r157 == null) goto L225;
        AnimatorSet.Builder r158 = r157.play(r108);
        if (r158 == null) goto L225;
        AnimatorSet.Builder r159 = r158.with(r116);
        if (r159 == null) goto L225;
        AnimatorSet.Builder r160 = r159.with(r124);
        if (r160 == null) goto L225;
        r160.before(r118);
        goto L225
    L99:
        AnimatorSet r161 = r156.f22791z;
        if (r161 == null) goto L225;
        AnimatorSet.Builder r162 = r161.play(r108);
        if (r162 == null) goto L225;
        r162.with(r116);
        goto L225
    L152:
        int r163 = this.f22818a.f22772g;
        if (r163 != 3) goto L155;
        r122.setInterpolator(new f());
        r128.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r164 = this.f22818a;
        if (r164.f22777l == false) goto L220;
        AnimatorSet r165 = r164.f22791z;
        if (r165 == null) goto L225;
        AnimatorSet.Builder r166 = r165.play(r108);
        if (r166 == null) goto L225;
        AnimatorSet.Builder r167 = r166.with(r116);
        if (r167 == null) goto L225;
        AnimatorSet.Builder r168 = r167.with(r122);
        if (r168 == null) goto L225;
        r168.after(r128);
        goto L225
    L220:
        AnimatorSet r169 = r164.f22791z;
        if (r169 == null) goto L225;
        AnimatorSet.Builder r170 = r169.play(r108);
        if (r170 == null) goto L225;
        r170.with(r116);
        goto L225
    L155:
        if (r163 != 5) goto L157;
        r120.setInterpolator(new f());
        r130.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r171 = this.f22818a;
        if (r171.f22777l == false) goto L204;
        AnimatorSet r172 = r171.f22791z;
        if (r172 == null) goto L225;
        AnimatorSet.Builder r173 = r172.play(r108);
        if (r173 == null) goto L225;
        AnimatorSet.Builder r174 = r173.with(r116);
        if (r174 == null) goto L225;
        AnimatorSet.Builder r175 = r174.with(r120);
        if (r175 == null) goto L225;
        r175.after(r130);
        goto L225
    L204:
        AnimatorSet r176 = r171.f22791z;
        if (r176 == null) goto L225;
        AnimatorSet.Builder r177 = r176.play(r108);
        if (r177 == null) goto L225;
        r177.with(r116);
        goto L225
    L157:
        if (r163 != 48) goto L159;
        r117.setInterpolator(new f());
        r126.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r178 = this.f22818a;
        if (r178.f22777l == false) goto L188;
        AnimatorSet r179 = r178.f22791z;
        if (r179 == null) goto L225;
        AnimatorSet.Builder r180 = r179.play(r108);
        if (r180 == null) goto L225;
        AnimatorSet.Builder r181 = r180.with(r116);
        if (r181 == null) goto L225;
        AnimatorSet.Builder r182 = r181.with(r117);
        if (r182 == null) goto L225;
        r182.after(r126);
        goto L225
    L188:
        AnimatorSet r183 = r178.f22791z;
        if (r183 == null) goto L225;
        AnimatorSet.Builder r184 = r183.play(r108);
        if (r184 == null) goto L225;
        r184.with(r116);
        goto L225
    L159:
        if (r163 != 80) goto L225;
        r118.setInterpolator(new f());
        r124.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r185 = this.f22818a;
        if (r185.f22777l == false) goto L172;
        AnimatorSet r186 = r185.f22791z;
        if (r186 == null) goto L225;
        AnimatorSet.Builder r187 = r186.play(r108);
        if (r187 == null) goto L225;
        AnimatorSet.Builder r188 = r187.with(r116);
        if (r188 == null) goto L225;
        AnimatorSet.Builder r189 = r188.with(r118);
        if (r189 == null) goto L225;
        r189.after(r124);
        goto L225
    L172:
        AnimatorSet r190 = r185.f22791z;
        if (r190 == null) goto L225;
        AnimatorSet.Builder r191 = r190.play(r108);
        if (r191 == null) goto L225;
        r191.with(r116);
        goto L225
    L76:
        r131 = 150;
        goto L77
    L72:
        r129 = 150;
        goto L73
    L68:
        r127 = 150;
        goto L69
    L64:
        r125 = 150;
        goto L65
    L60:
        r123 = 200;
        goto L61
    L56:
        r121 = 200;
        goto L57
    L52:
        r119 = 200;
        goto L53
    L41:
        r115 = 1.0f;
        goto L42
    L37:
        r107 = 0.0f;
        goto L38
    L33:
        r111 = 1.0f;
        goto L34
    L11:
        float r192 = this.f22819b.getX();
        LiveBubbleLayout r193 = this.f22818a.f22787v;
        if (r193 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L14:
        r102 = (int) (r192 + r193.getBubbleOffset());
        float r194 = this.f22819b.getY();
    L29:
        r103 = (int) r194;
        goto L30
    L15:
        float r195 = this.f22819b.getX();
        LiveBubbleLayout r196 = this.f22818a.f22787v;
        if (r196 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L18:
        r102 = (int) (r195 + r196.getBubbleOffset());
        float r197 = this.f22819b.getY();
        float r198 = this.f22819b.getMeasuredHeight();
    L28:
        r194 = r197 + r198;
        goto L29
    L19:
        r102 = (int) this.f22819b.getX();
        float r199 = this.f22819b.getY();
        LiveBubbleLayout r200 = this.f22818a.f22787v;
        if (r200 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L22:
        float r201 = r200.getBubbleOffset();
    L27:
        float r1100 = r199;
        r198 = r201;
        r197 = r1100;
        goto L28
    L23:
        r102 = (int) (this.f22819b.getX() + this.f22819b.getMeasuredWidth());
        r199 = this.f22819b.getY();
        LiveBubbleLayout r202 = this.f22818a.f22787v;
        if (r202 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L26:
        r201 = r202.getBubbleOffset();
        goto L27
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
