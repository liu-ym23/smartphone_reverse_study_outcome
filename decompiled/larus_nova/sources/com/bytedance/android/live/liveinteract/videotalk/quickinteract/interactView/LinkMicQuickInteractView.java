package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.live.liveinteract.utils.i1;
import com.bytedance.android.live.liveinteract.utils.q1;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020\t¢\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010)\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010/\u001a\u0004\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00104\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u00107\u001a\u0004\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b5\u0010,\u001a\u0004\b6\u0010.R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0017\u0010E\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR*\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR*\u0010N\u001a\u00020M2\u0006\u0010F\u001a\u00020M8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006["}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/LinkMicQuickInteractView;", "Landroid/widget/FrameLayout;", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "setContentDescription", "Landroid/view/ViewGroup;", "getMainContainer", "getExtraContainer", "", "resId", "setBackground", "color", "setTextColor", "setAnimationBackground", "backgroundColor", "setGiftFlashBackground", RemoteMessageConst.Notification.VISIBILITY, "setVisibility", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getStaticBg", "()Landroid/widget/ImageView;", "staticBg", "Landroid/view/View;", "e", "Landroid/view/View;", "getAnimationBg", "()Landroid/view/View;", "animationBg", "Lcom/bytedance/android/live/core/widget/HSImageView;", "f", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "icon", ce.f26391f, "Landroid/view/ViewGroup;", "getIconParent", "()Landroid/view/ViewGroup;", "iconParent", "Landroid/widget/TextView;", RXScreenCaptureService.KEY_INDEX, "Landroid/widget/TextView;", "getThankView", "()Landroid/widget/TextView;", "thankView", ce.f26395j, "Landroid/widget/FrameLayout;", "getSwitchContainer", "()Landroid/widget/FrameLayout;", "switchContainer", ce.f26396k, "getScoreView", "scoreView", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "l", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "getStarWishProgressView", "()Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "setStarWishProgressView", "(Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;)V", "starWishProgressView", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "getAnimationHelper", "()Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "animationHelper", "value", "state", "I", "getState", "()I", "setState", "(I)V", "", "disableBgAnim", "Z", "getDisableBgAnim", "()Z", "setDisableBgAnim", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMicQuickInteractView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f79520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f79521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f79522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f79523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f79524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HSImageView f79525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f79526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f79527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f79528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f79529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f79530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ProgressImageView f79531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextSwitcher f79532m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a f79533n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f79534o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f79535p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f79536q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f79537r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f79538s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f79539t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f79540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f79541v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f79542w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f79543x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function0<Unit> f79544y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function0<Unit> f79545z;

    public static final class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkMicQuickInteractView f79546a;

        public a(LinkMicQuickInteractView r100) {
            this.f79546a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
            LinkMicQuickInteractView r101 = this.f79546a;
            if (TextUtils.equals(r100, r101.f79543x) == true) goto L6;
            r101.e(r101.f79543x);
            return;
        }
    }

    public LinkMicQuickInteractView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LinkMicQuickInteractView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getDisableBgAnim() {
        return this.f79533n.f79586m;
    }

    public final int getState() {
        return this.f79533n.f79583j;
    }

    public static boolean d() {
        int r100 = je0.d.f();
        if (r100 != 8) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 12) goto L8;
        return false;
    }

    public final View getAnimationBg() {
        return this.f79524e;
    }

    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a getAnimationHelper() {
        return this.f79533n;
    }

    public final ViewGroup getExtraContainer() {
        return this.f79520a;
    }

    public final HSImageView getIcon() {
        return this.f79525f;
    }

    public final ViewGroup getIconParent() {
        return this.f79526g;
    }

    public final ViewGroup getMainContainer() {
        return this.f79521b;
    }

    public final TextView getScoreView() {
        return this.f79530k;
    }

    public final ProgressImageView getStarWishProgressView() {
        return this.f79531l;
    }

    public final ImageView getStaticBg() {
        return this.f79523d;
    }

    public final FrameLayout getSwitchContainer() {
        return this.f79529j;
    }

    public final TextView getThankView() {
        return this.f79528i;
    }

    private final void setContentDescription(String r100) {
        r3.a(this, getContext().getString(R.string.ttlive_anchor_gift_value) + r100);
    }

    public final void c(QuickInteractTask r110) {
        Intrinsics.checkNotNullParameter(r110, "task");
        gj0.i.a("LinkMicQuickInteractView", "consumeInteractTask " + r110.f79479b);
        String r100 = null;
        boolean r101 = false;
        if (r110.f79486i == false) goto L11;
        a(this, false, false, 3);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r102 = this.f79533n;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "task");
        QuickInteractTask r103 = r102.f79584k;
        if (r103 == null) goto L8;
        r100 = r103.f79481d;
    L8:
        if (Intrinsics.areEqual(r100, r110.f79481d) == false) goto L31;
        r102.b();
        return;
    L31:
        return;
    L11:
        String r104 = r110.f79479b;
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
    L27:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r106 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.a();
        if (r106 == null) goto L32;
        r106.k7(r110);
        return;
    L32:
        return;
    L20:
        if (TextUtils.equals(this.f79543x, r110.f79479b) == true) goto L27;
        this.f79543x = r110.f79479b;
        gj0.i.a("LinkMicQuickInteractView", "consumeInteractTask update score currentScore : " + this.f79543x);
        if (r110.f79481d.length() <= 0) goto L25;
        r101 = true;
    L25:
        k(r101);
        final Ref.ObjectRef r107 = new Ref.ObjectRef();
        r107.element = null;
        this.f79533n.a(r110, new LinkMicQuickInteractView$consumeInteractTask$1(this, r107), new LinkMicQuickInteractView$consumeInteractTask$2(this, r107), new LinkMicQuickInteractView$consumeInteractTask$3(this), new LinkMicQuickInteractView$consumeInteractTask$4(this));
        return;
    L14:
        if (r104.length() == 0) goto L17;
        r105 = false;
        goto L18
    }

    public final void e(String r100) {
        a(this, false, false, 3);
        this.f79543x = r100;
        gj0.i.a("LinkMicQuickInteractView", "doUpdateNormalScore " + r100);
        k(true);
        if (((Boolean) vm2.d.f555881k4.getValue(null, vm2.d.f555776a[268(0x10c, float:3.76E-43)])).booleanValue() == false) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r101 = this.f79533n;
        if (r101.f79583j != 0) goto L8;
        r101.g(r100, new LinkMicQuickInteractView$doUpdateNormalScore$1(this));
    L8:
        setContentDescription(r100);
        return;
    L7:
        this.f79533n.g(r100, AnimationHelper$updateScore$1.INSTANCE);
        goto L8
    }

    public final void f(ConstraintLayout r100) {
        ConstraintSet r101 = new ConstraintSet();
        r101.clone(r100);
        r101.connect(getId(), 6, 0, 6);
        r101.applyTo(r100);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = -2;
        setLayoutParams(r102);
        return;
    }

    public final void g(String r100) {
    L7:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "updateDynamicBackgroundColor error!", e);
        return;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L5;
        GradientDrawable r101 = new GradientDrawable();     // Catch: Exception -> L7
        r101.setColor(Color.parseColor(r100));     // Catch: Exception -> L7
        r101.setCornerRadius(UtilityKotlinExtentionsKt.i(30));     // Catch: Exception -> L7
        this.f79523d.setBackground(r101);     // Catch: Exception -> L7
    L10:
        return;
    L5:
        setBackground(this.f79534o);     // Catch: Exception -> L7
        goto L10
    }

    public final void h(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Integer r101 = je0.d.h();
        if (r101 != null) goto L8;
    L10:
        a1.o(this.f79525f, qy.a.a(r100), ImageView.ScaleType.FIT_CENTER);
        return;
    L8:
        if (r101.intValue() != 24) goto L10;
        ImageUtil.loadImage(this.f79525f, qy.a.a(r100), s1.f(20.0f), s1.f(20.0f), null);
        return;
    L11:
        int r102 = i1.f78784a;
        i1.a(this.f79525f);
    }

    public final void i(String r100) {
    L12:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "updateDynamicTextColor error!", e);
        return;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        TextView r101 = this.f79528i;     // Catch: Exception -> L12
        if (r101 == null) goto L7;
        r101.setTextColor(Color.parseColor(r100));     // Catch: Exception -> L12
    L7:
        TextView r102 = this.f79530k;     // Catch: Exception -> L12
        if (r102 == null) goto L16;
        r102.setTextColor(Color.parseColor(r100));     // Catch: Exception -> L12
        return;
    L16:
        return;
    L10:
        setTextColor(this.f79535p);     // Catch: Exception -> L12
    }

    public final void j(String r100) {
        gj0.i.a("LinkMicQuickInteractView", "updateNormalScore " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (TextUtils.equals(this.f79543x, r100) == true) goto L15;
        e(r100);
        return;
    L15:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void k(boolean r110) {
        if (this.f79536q == 2) goto L5;
        return;
    L5:
        long r100 = 0;
        if (this.f79538s != 0) goto L8;
        return;
    L8:
        String r101 = this.f79543x;
        Long r102 = null;
        if (r101 == null) goto L11;
        char[] r103 = r101.toCharArray();
    L13:
        if (r103 == null) goto L36;
        StringBuilder r104 = new StringBuilder();
        int r105 = r103.length;
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L27;
        char r107 = r103[r106];
        if (r107 != 19975) goto L21;
    L25:
        r104.append(r107);
    L26:
        r106 = r106 + 1;
        goto L17
    L21:
        if ('0' > r107) goto L26;
        if ('9' < r107) goto L26;
    L27:
        String r108 = r104.toString();
        if (r108 != null) goto L30;
    L32:
        if (r108 == null) goto L34;
        r102 = Long.valueOf(CastLongProtector.parseLong(r108));
    L34:
        long r109 = r102.longValue();
    L35:
        r100 = r109;
        goto L36
    L30:
        if (StringsKt.contains$default(r108, 19975, false, 2, null) != true) goto L32;
        r109 = (long) (CastFloatProtector.parseFloat(StringsKt.replace$default(r108, 19975, '0', false, 4, null)) * 1000);
    L36:
        this.f79540u = r100;
        gj0.i.a("LinkMicQuickInteractView", "curPlayerUid：" + this.f79537r + "--this:" + hashCode() + "--updateStarProgress " + this.f79540u + " / " + this.f79538s + "--updateWithAnim:" + r110);
        if (this.f79538s <= this.f79540u) goto L44;
        ProgressImageView r111 = this.f79531l;
        if (r111 == null) goto L41;
        r111.setVisibility(0);
    L41:
        ProgressImageView r112 = this.f79531l;
        if (r112 == null) goto L52;
        r112.b(this.f79540u / this.f79538s, this.f79539t, r110);
        return;
    L52:
        return;
    L44:
        ProgressImageView r113 = this.f79531l;
        if (r113 == null) goto L54;
        r113.b(1.0f, this.f79539t, r110);
        return;
    L54:
        return;
    L11:
        r103 = null;
        goto L13
    }

    public final void setAnimationBackground(String r100) {
        GradientDrawable r101 = new GradientDrawable();     // Catch: Exception -> L4
        r101.setColor(Color.parseColor(r100));     // Catch: Exception -> L4
        r101.setCornerRadius(UtilityKotlinExtentionsKt.i(30));     // Catch: Exception -> L4
        this.f79524e.setBackground(r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "setAnimationBackground error!", e);
    }

    public final void setBackground(int r100) {
        if (this.f79536q != 2) goto L5;
        return;
    L5:
        this.f79523d.setBackgroundResource(r100);
        this.f79534o = r100;
    }

    public final void setDisableBgAnim(boolean r100) {
        this.f79533n.f79586m = r100;
    }

    public final void setGiftFlashBackground(int r100) {
        this.f79522c.setBackgroundResource(r100);
    }

    public final void setStarWishProgressView(ProgressImageView r100) {
        this.f79531l = r100;
    }

    public final void setState(int r100) {
        this.f79533n.f79583j = r100;
    }

    public final void setTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        TextView r101 = this.f79528i;     // Catch: Exception -> L11
        if (r101 == null) goto L6;
        r101.setTextColor(Color.parseColor(r100));     // Catch: Exception -> L11
    L6:
        TextView r102 = this.f79530k;     // Catch: Exception -> L11
        if (r102 == null) goto L9;
        r102.setTextColor(Color.parseColor(r100));     // Catch: Exception -> L11
    L9:
        this.f79535p = r100;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "setTextColor error!", e);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (r100 != 0) goto L5;
        Log.getStackTraceString(new Exception("LinkMicQuickInteractView#Visible"));
    L5:
        super.setVisibility(r100);
    }

    public final void setAnimationBackground(int r100) {
        this.f79524e.setBackgroundResource(r100);
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r101, "playerId");
        this.f79537r = r101;
        this.f79543x = r100;
        a(this, Intrinsics.areEqual(r100, "0"), false, 2);
        k(false);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r102 = this.f79533n;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        r102.f();
        f r103 = r102.f79579f;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        r103.f79606a.setCurrentText(r100);
        r103.f79609d = r100;
    }

    public final void l(int r110, String r111) {
        gj0.i.a("LinkMicQuickInteractView", "updateStyleType " + r110);
        int r100 = this.f79536q;
        if (r100 != 4) goto L5;
        return;
    L5:
        boolean r101 = true;
        if (r100 == 2) goto L9;
        if (r110 != r100) goto L9;
        this.f79541v = getDisableBgAnim();
        setDisableBgAnim(true);
    L9:
        int r102 = this.f79536q;
        if (r102 != 2) goto L13;
        if (r110 == r102) goto L13;
        setDisableBgAnim(this.f79541v);
    L13:
        this.f79536q = r110;
        a(this, false, false, 3);
        ViewGroup.LayoutParams r103 = null;
        float r112 = 3.0f;
        if (r110 == 0) goto L118;
        float r113 = 5.0f;
        if (r110 == 1) goto L93;
        if (r110 == 2) goto L37;
        if (r110 == 3) goto L36;
        if (r110 != 4) goto L156;
        this.f79520a.setVisibility(0);
        if (this.f79526g.getVisibility() != 8) goto L24;
        this.f79526g.setVisibility(0);
    L24:
        com.bytedance.android.live.core.utils.a1.m(this.f79526g, s1.f(0.0f));
        this.f79521b.setPadding(s1.f(3.0f), 0, 0, 0);
        this.f79520a.setPadding(0, 0, s1.f(3.0f), 0);
        this.f79525f.setScaleX(0.8f);
        this.f79525f.setScaleY(0.8f);
        FrameLayout r104 = this.f79529j;
        if (r104 == null) goto L27;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L29:
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        r103 = r105;
    L32:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r103;
        if (r106 == null) goto L35;
        r106.rightMargin = 0;
    L35:
        this.f79521b.setMinimumWidth(0);
        return;
    L27:
        r105 = null;
        goto L29
    L156:
        return;
    L36:
        setDisableBgAnim(false);
        this.f79526g.setVisibility(8);
        return;
    L37:
        gj0.i.a("LinkMicQuickInteractView", "starWishStyleType " + this.f79538s + "  curScore：" + this.f79540u);
        setDisableBgAnim(true);
        if (r111 != null) goto L40;
    L43:
        boolean r107 = true;
    L44:
        if (r107 == true) goto L46;
        this.f79525f.setScaleX(2.0f);
        this.f79525f.setScaleY(2.0f);
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(5.0f));
    L51:
        if (d() == false) goto L66;
        if (r111 != null) goto L54;
    L57:
        if (r101 == false) goto L66;
        FrameLayout r108 = this.f79529j;
        if (r108 == null) goto L61;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L62:
        if (r109 == null) goto L65;
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r109;
        r114.rightToRight = -1;
        r114.endToEnd = -1;
        this.f79529j.setLayoutParams(r114);
    L72:
        ViewGroup.LayoutParams r115 = this.f79525f.getLayoutParams();
        com.bytedance.android.live.core.utils.a1.m(this.f79525f, s1.f(0.0f));
        com.bytedance.android.live.core.utils.a1.n(this.f79525f, s1.f(5.0f));
        this.f79525f.setLayoutParams(r115);
        if (this.f79538s <= 0) goto L77;
        ProgressImageView r116 = this.f79531l;
        if (r116 == null) goto L80;
        r116.setVisibility(0);
    L80:
        this.f79526g.setVisibility(0);
        FrameLayout r117 = this.f79529j;
        if (r117 == null) goto L83;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
    L85:
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L88;
        r103 = r118;
    L88:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r103;
        if (r119 == null) goto L151;
        r119.leftMargin = 0;
        return;
    L151:
        return;
    L83:
        r118 = null;
        goto L85
    L77:
        ProgressImageView r120 = this.f79531l;
        if (r120 == null) goto L80;
        r120.setVisibility(8);
        goto L80
    L65:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L61:
        r109 = null;
        goto L62
    L54:
        if (r111.length() == 0) goto L57;
        r101 = false;
    L66:
        FrameLayout r121 = this.f79529j;
        if (r121 == null) goto L69;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L70:
        if (r122 == null) goto L92;
        ConstraintLayout.LayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
        r123.rightToRight = R.id.interact_static_bg;
        r123.endToEnd = R.id.interact_static_bg;
        this.f79529j.setLayoutParams(r123);
        goto L72
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L69:
        r122 = null;
        goto L70
    L46:
        this.f79525f.setScaleX(1.0f);
        this.f79525f.setScaleY(1.0f);
        if (je0.d.B() == false) goto L49;
        r112 = 0.0f;
    L49:
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(r112));
        goto L51
    L40:
        if (r111.length() == 0) goto L43;
        r107 = false;
        goto L44
    L93:
        setDisableBgAnim(false);
        ViewGroup.LayoutParams r124 = this.f79525f.getLayoutParams();
        this.f79525f.setScaleX(1.83f);
        this.f79525f.setScaleY(1.83f);
        com.bytedance.android.live.core.utils.a1.m(this.f79525f, -s1.f(5.0f));
        com.bytedance.android.live.core.utils.a1.n(this.f79525f, s1.f(5.0f));
        if (je0.d.B() == true) goto L97;
        r113 = 8.0f;
    L97:
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(r113));
        if (d() == false) goto L107;
        FrameLayout r125 = this.f79529j;
        if (r125 == null) goto L102;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
    L103:
        if (r126 == null) goto L106;
        ConstraintLayout.LayoutParams r127 = (ConstraintLayout.LayoutParams) r126;
        r127.rightToRight = R.id.interact_static_bg;
        r127.endToEnd = R.id.interact_static_bg;
        this.f79529j.setLayoutParams(r127);
        goto L107
    L106:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L102:
        r126 = null;
    L107:
        this.f79525f.setLayoutParams(r124);
        this.f79526g.setVisibility(0);
        FrameLayout r128 = this.f79529j;
        if (r128 == null) goto L110;
        ViewGroup.LayoutParams r129 = r128.getLayoutParams();
    L112:
        if ((r129 instanceof ViewGroup.MarginLayoutParams) == false) goto L115;
        r103 = r129;
    L115:
        ViewGroup.MarginLayoutParams r130 = (ViewGroup.MarginLayoutParams) r103;
        if (r130 == null) goto L153;
        r130.leftMargin = 0;
        return;
    L153:
        return;
    L110:
        r129 = null;
        goto L112
    L118:
        setDisableBgAnim(false);
        ViewGroup.LayoutParams r131 = this.f79525f.getLayoutParams();
        this.f79525f.setScaleX(1.0f);
        this.f79525f.setScaleY(1.0f);
        com.bytedance.android.live.core.utils.a1.m(this.f79525f, s1.f(0.0f));
        com.bytedance.android.live.core.utils.a1.n(this.f79525f, s1.f(0.0f));
        if (je0.d.B() == false) goto L121;
        r112 = 0.0f;
    L121:
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(r112));
        this.f79525f.setLayoutParams(r131);
        if (d() == false) goto L131;
        FrameLayout r132 = this.f79529j;
        if (r132 == null) goto L126;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
    L127:
        if (r133 == null) goto L130;
        ConstraintLayout.LayoutParams r134 = (ConstraintLayout.LayoutParams) r133;
        r134.rightToRight = R.id.interact_static_bg;
        r134.endToEnd = R.id.interact_static_bg;
        this.f79529j.setLayoutParams(r134);
        goto L131
    L130:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L126:
        r133 = null;
    L131:
        ProgressImageView r135 = this.f79531l;
        if (r135 == null) goto L134;
        r135.f79552c = 0.0f;
        r135.f79550a = 0.0f;
        r135.invalidate();
    L134:
        ProgressImageView r136 = this.f79531l;
        if (r136 == null) goto L137;
        r136.setVisibility(8);
    L137:
        this.f79539t = null;
        this.f79526g.setVisibility(0);
        FrameLayout r137 = this.f79529j;
        if (r137 == null) goto L140;
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
    L142:
        if ((r138 instanceof ViewGroup.MarginLayoutParams) == false) goto L145;
        r103 = r138;
    L145:
        ViewGroup.MarginLayoutParams r139 = (ViewGroup.MarginLayoutParams) r103;
        if (r139 == null) goto L155;
        r139.leftMargin = 0;
        return;
    L155:
        return;
    L140:
        r138 = null;
        goto L142
    }

    public LinkMicQuickInteractView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_link_quick_interact_score_view, this, true);
        setClipChildren(false);
        this.f79520a = (ViewGroup) findViewById(R.id.extra_container_view);
        this.f79521b = (ViewGroup) findViewById(R.id.main_container_view);
        this.f79522c = findViewById(R.id.flash_shadow_mask);
        this.f79523d = (ImageView) findViewById(R.id.interact_static_bg);
        this.f79524e = findViewById(R.id.interact_animation_bg);
        HSImageView r103 = (HSImageView) findViewById(R.id.interact_icon);
        this.f79525f = r103;
        this.f79526g = (ViewGroup) findViewById(R.id.interact_icon_parent);
        HSImageView r104 = (HSImageView) findViewById(R.id.interact_avatar);
        TextView r105 = (TextView) findViewById(R.id.interact_content);
        this.f79527h = r105;
        this.f79528i = (TextView) findViewById(R.id.thanks_tv);
        this.f79529j = (FrameLayout) findViewById(R.id.interact_switcher_container);
        this.f79530k = (TextView) findViewById(R.id.score_tv);
        this.f79531l = (ProgressImageView) findViewById(R.id.star_wish_progress);
        this.f79532m = (TextSwitcher) findViewById(R.id.score_switcher);
        this.f79533n = new com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a(this, new a(this));
        this.f79534o = R.drawable.ttlive_quick_interact_fg;
        this.f79535p = CustomHeaderConfig.COLOR_LIGHT;
        this.f79537r = "";
        this.f79538s = 1000;
        this.f79543x = "0";
        r104.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r105.setOnClickListener(x0.a(new AnonymousClass2(this)));
        r103.getHierarchy().setPlaceholderImage(null);
        i1.a(r103);
        setContentDescription(this.f79543x);
    }

    public /* synthetic */ LinkMicQuickInteractView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void a(LinkMicQuickInteractView r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if (r100.f79536q != 4) goto L19;
        ViewGroup r104 = UtilityKotlinExtentionsKt.p(r100);
        if ((r104 instanceof ConstraintLayout) == true) goto L13;
        r104 = null;
    L13:
        ConstraintLayout r105 = (ConstraintLayout) r104;
        if (r105 == null) goto L20;
        if (r101 == false) goto L17;
        r100.f(r105);
        return;
    L17:
        r100.getViewTreeObserver().addOnGlobalLayoutListener(new e(r105, r100, r102));
        return;
    L20:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f79542w == true) goto L9;
        int r105 = o.a(((Number) vm2.d.f555901m4.getValue(null, vm2.d.f555776a[270(0x10e, float:3.78E-43)])).intValue());
        if (r105 <= 0) goto L7;
        q1.a(this, new int[]{r105, r105, r105, r105});
    L7:
        this.f79542w = true;
        return;
    }
}
