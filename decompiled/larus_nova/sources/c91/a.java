package c91;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.j4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f22822l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f22823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f22824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f22825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f22826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f22827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f22828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f22829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f22830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f22831i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<j4> f22832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22833k;

    /* JADX INFO: renamed from: c91.a$a, reason: collision with other inner class name */
    public static final class C0417a {
    }

    static {
        f22822l = s1.f(17.0f);
    }

    public final void a(j4 r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        AnimatorSet r100 = this.f22830h;
        if (r100 != null) goto L5;
    L8:
        py.k r101 = null;
        o r102 = z51.a.h(null, 3);
        if (r102 == null) goto L17;
        com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
        if (r103 == null) goto L17;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L17;
        IBaseUser r105 = r104.getOwner();
        if (r105 == null) goto L17;
        r101 = r105.getAvatarThumbKt();
    L17:
        this.f22827e.setText(r110.P());
        this.f22823a.setAlpha(0.9f);
        this.f22828f.setText(sb2.a.h(r110.E(), "", false));
        if (this.f22824b.getWidth() >= s1.f(140.0f)) goto L20;
        int r106 = s1.f(140.0f);
    L21:
        int r107 = f22822l;
        this.f22833k = r106 - r107;
        ImageUtil.loadImage(this.f22829g, r110.H(), new m(this, r110));
        ImageUtil.loadRoundImage(this.f22826d, r101);
        UIUtils.updateLayoutMargin(this.f22829g, this.f22833k - s1.f(20.0f), s1.f(2.0f), 0, 0);
        this.f22823a.setOnClickListener(new n(r110));
        AnimatorSet r108 = this.f22830h;
        if (r108 != null) goto L24;
    L26:
        AnimatorSet r109 = new AnimatorSet();
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r111.setDuration(100);
        r111.addUpdateListener(new d(this));
        Unit r112 = Unit.INSTANCE;
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r113.setDuration(200);
        r113.addUpdateListener(new e(this));
        r113.addListener(new f(this));
        int r114 = this.f22833k;
        ValueAnimator r115 = ValueAnimator.ofInt(new int[]{r114, r114 + r107});
        r115.setDuration(100);
        r115.setStartDelay(100);
        r115.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r115.addUpdateListener(new g(this));
        ObjectAnimator r116 = ObjectAnimator.ofFloat(this.f22827e, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{s1.f(-128.0f), 0.0f});
        r116.setDuration(200);
        r116.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r116.addUpdateListener(new h(this));
        ObjectAnimator r117 = ObjectAnimator.ofFloat(this.f22828f, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{s1.f(-128.0f), 0.0f});
        r117.setDuration(200);
        r117.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r117.addUpdateListener(new i(this));
        ObjectAnimator r118 = ObjectAnimator.ofFloat(this.f22829g, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{s1.f(-128.0f), 0.0f});
        r118.setDuration(200);
        r118.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r119 = ObjectAnimator.ofFloat(this.f22831i, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{s1.f(-128.0f), 0.0f});
        r119.setDuration(200);
        r119.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r109.playTogether(new Animator[]{r111, r113, r115, r116, r117, r118, r119});
        AnimatorSet r120 = new AnimatorSet();
        ValueAnimator r121 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r121.setDuration(150);
        r121.addUpdateListener(new j(this));
        ValueAnimator r122 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r122.setDuration(150);
        r122.setStartDelay(50);
        r122.addUpdateListener(new k(this));
        r122.addListener(new l(this));
        int r123 = this.f22833k;
        ValueAnimator r124 = ValueAnimator.ofInt(new int[]{r107 + r123, r123});
        r124.setDuration(150);
        r124.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r124.addUpdateListener(new b(this));
        ObjectAnimator r125 = ObjectAnimator.ofFloat(this.f22827e, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, s1.f(-20.0f)});
        r125.setDuration(150);
        r125.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r126 = ObjectAnimator.ofFloat(this.f22828f, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, s1.f(-20.0f)});
        r126.setDuration(150);
        r126.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r127 = ObjectAnimator.ofFloat(this.f22831i, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, s1.f(-20.0f)});
        r127.setDuration(150);
        r127.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r128 = ObjectAnimator.ofFloat(this.f22829g, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, s1.f(-20.0f)});
        r128.setDuration(150);
        r128.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r120.playTogether(new Animator[]{r121, r122, r124, r125, r126, r127, r128});
        AnimatorSet r129 = new AnimatorSet();
        r120.setStartDelay(3000);
        r129.playSequentially(new Animator[]{r109, r120});
        r129.addListener(new c(this));
        r129.start();
        this.f22830h = r129;
        return;
    L24:
        if (r108.isRunning() != true) goto L26;
        return;
    L20:
        r106 = this.f22824b.getWidth();
        goto L21
    L5:
        if (r100.isRunning() != true) goto L8;
        ((ArrayList) this.f22832j).add(r110);
    }

    public a(FrameLayout r110, View r111) {
        Intrinsics.checkNotNullParameter(r110, "containerView");
        Intrinsics.checkNotNullParameter(r111, "contentView");
        this.f22823a = r110;
        this.f22824b = r111;
        this.f22832j = new ArrayList();
        ViewParent r100 = r110.getParent();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L8;
        r101.bringToFront();
    L8:
        r110.getLayoutParams().width = r111.getLayoutParams().width;
        r110.setVisibility(8);
        ImageView r102 = new ImageView(r110.getContext());
        r102.setBackgroundResource(R.drawable.ttlive_bg_gift_exhibition_lightening_text);
        Unit r103 = Unit.INSTANCE;
        r110.addView(r102, new FrameLayout.LayoutParams(-1, -1));
        this.f22825c = r102;
        TextView r104 = new TextView(r110.getContext());
        r104.setTextSize(1, 12.0f);
        r104.setTextColor(-1);
        r104.setAlpha(0.9f);
        r104.setMaxLines(1);
        r104.setSingleLine(true);
        r104.setGravity(GravityCompat.END);
        r104.setEllipsize(null);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.topMargin = s1.f(3.0f);
        r105.leftMargin = s1.f(38.0f);
        r110.addView(r104, r105);
        this.f22827e = r104;
        TextView r106 = new TextView(r110.getContext());
        r106.setTextSize(1, 10.0f);
        r106.setTextColor(-1);
        r106.setAlpha(0.7f);
        r106.setMaxLines(1);
        r106.setSingleLine(true);
        r106.setGravity(GravityCompat.END);
        r106.setEllipsize(null);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.topMargin = s1.f(18.0f);
        r107.leftMargin = s1.f(38.0f);
        r110.addView(r106, r107);
        this.f22828f = r106;
        ImageView r108 = new ImageView(r110.getContext());
        r108.setBackgroundResource(R.drawable.ttlive_bg_room_push_notify_message_arrow);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
        r109.topMargin = s1.f(6.0f);
        r109.leftMargin = s1.f(38.0f);
        r110.addView(r108, r109);
        this.f22831i = r108;
        HSImageView r112 = new HSImageView(r110.getContext());
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f));
        r113.topMargin = s1.f(1.0f);
        r113.leftMargin = r111.getWidth() - s1.f(20.0f);
        r110.addView(r112, r113);
        this.f22829g = r112;
        HSImageView r114 = new HSImageView(r110.getContext());
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f));
        r115.topMargin = s1.f(1.0f);
        r115.leftMargin = s1.f(2.0f);
        r110.addView(r114, r115);
        this.f22826d = r114;
    }
}
