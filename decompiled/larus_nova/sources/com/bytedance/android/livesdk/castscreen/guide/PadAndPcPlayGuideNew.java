package com.bytedance.android.livesdk.castscreen.guide;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes7.dex */
public final class PadAndPcPlayGuideNew implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f104462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f104463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f104464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f104465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f104466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f104467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f104468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f104469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f104470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f104471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f104472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f104473l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f104474m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f104475n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f104476o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f104477p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f104478q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DataCenter f104479r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.castscreen.padandpc.vm.a f104480s;

    public final boolean e() {
        return ((Boolean) this.f104476o.getValue()).booleanValue();
    }

    public final void d() {
        if (this.f104477p == true) goto L20;
        LinearLayout r100 = this.f104462a;
        if (r100 == null) goto L29;
        Sequence<View> r101 = UtilityKotlinExtentionsKt.g(r100);
        if (r101 == null) goto L30;
        Iterator<View> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L31;
        View r103 = r102.next();
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r104 = this.f104480s;
        if (r104 == null) goto L19;
        com.bytedance.android.live.core.arch.mvvm.d<Boolean> r105 = r104.getShowGuideInBottom();
        if (r105 == null) goto L19;
        if (r105.getValue().booleanValue() == true) goto L19;
        UtilityKotlinExtentionsKt.t(r103);
    L19:
        UtilityKotlinExtentionsKt.w(r103);
        goto L10
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.android.livesdk.castscreen.guide.d
    public final void release() {
        this.f104475n.clear();
    }

    @Override // com.bytedance.android.livesdk.castscreen.guide.d
    public final boolean canShowGuide() {
        return LivePadAndPcPlayUtil.h();
    }

    @Override // com.bytedance.android.livesdk.castscreen.guide.d
    public final void a(ViewGroup r100) {
        if (r100 == null) goto L34;
        r100.removeAllViews();
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_layout_pad_and_pc_play_guide_new, r100, true);
        if (r101 == null) goto L23;
        this.f104462a = (LinearLayout) r101.findViewById(R.id.llGuideContent);
        this.f104467f = r101.findViewById(R.id.llPcGuideContainer);
        this.f104468g = r101.findViewById(R.id.flPcTitle);
        this.f104469h = r101.findViewById(R.id.ivPcArrow);
        this.f104470i = r101.findViewById(R.id.dividerPc);
        this.f104471j = r101.findViewById(R.id.svPc);
        TextView r102 = (TextView) r101.findViewById(R.id.tvTitleDownloadClient);
        if (r102 == null) goto L8;
        r102.setText(s1.B(R.string.ttlive_pc_guide_step_title_aweme_client));
    L8:
        TextView r103 = (TextView) r101.findViewById(R.id.tvSubPcTitle);
        if (r103 == null) goto L11;
        LivePadAndPcPlayUtil.c(r103, e());
    L11:
        View r104 = this.f104467f;
        if (r104 == null) goto L14;
        LivePadAndPcPlayUtil.b(r104, e());
    L14:
        c(this.f104471j);
        this.f104463b = r101.findViewById(R.id.llPadGuideContainer);
        this.f104464c = r101.findViewById(R.id.flPadTitle);
        this.f104465d = r101.findViewById(R.id.ivPadArrow);
        this.f104466e = r101.findViewById(R.id.svPad);
        LivePadAndPcPlayUtil.a(this.f104463b, e());
        c(this.f104466e);
        LinearLayout r105 = this.f104462a;
        int r106 = c.f104485a;
        if (r105 != null) goto L17;
        Disposable r107 = Disposables.empty();
    L18:
        RxUtilKt.c(r107, this.f104475n);
        int r108 = c.f104485a;
        LinearLayout r109 = this.f104462a;
        if (r109 != null) goto L21;
        Disposable r110 = Disposables.empty();
    L22:
        RxUtilKt.c(r110, this.f104475n);
        goto L23
    L21:
        CompositeDisposable r111 = new CompositeDisposable();
        r109.post(new b(r109, r111));
        r110 = r111;
        goto L22
    L17:
        CompositeDisposable r112 = new CompositeDisposable();
        r105.post(new a(r105, r112));
        r107 = r112;
    L23:
        View r113 = this.f104464c;
        if (r113 == null) goto L26;
        r113.setOnClickListener(new k(this));
    L26:
        View r114 = this.f104468g;
        if (r114 == null) goto L29;
        r114.setOnClickListener(new l(this));
    L29:
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r115 = this.f104480s;
        if (r115 == null) goto L32;
        RxUtilKt.c(RxUtilKt.h(r115.getShowGuideInBottom()).subscribe(new i(this)), this.f104475n);
        RxUtilKt.c(RxUtilKt.h(r115.getExpendGuide()).subscribe(new j(this)), this.f104475n);
    L32:
        d();
        return;
    }

    public final void c(View r100) {
        if ((r100 instanceof TextView) == false) goto L12;
        TextView r101 = (TextView) r100;
        boolean r102 = e();
        int r103 = LivePadAndPcPlayUtil.f104718a;
        if (r102 == false) goto L7;
        int r104 = R.color.ttlive_color_161823;
    L8:
        int r105 = s1.h(r104);
        if (r101 == null) goto L29;
        r101.setTextColor(r105);
        return;
    L29:
        return;
    L7:
        r104 = R.color.ttlive_color_BF_FFFFFF;
        goto L8
    L12:
        if ((r100 instanceof RoundCornerImageView) == false) goto L24;
        ImageView r106 = (ImageView) r100;
        boolean r107 = e();
        int r108 = LivePadAndPcPlayUtil.f104718a;
        if (r106 == null) goto L32;
        if (r107 == false) goto L17;
        int r109 = R.color.ttlive_color_80_161823;
    L18:
        int r110 = s1.h(r109);
        Drawable r111 = r106.getBackground();
        if (r111 == null) goto L33;
        Drawable r112 = r111.mutate();
        if (r112 == null) goto L34;
        r112.setColorFilter(r110, PorterDuff.Mode.SRC_ATOP);
        return;
    L34:
        return;
    L33:
        return;
    L17:
        r109 = R.color.ttlive_color_80_FFFFFF;
        goto L18
    L32:
        return;
    L24:
        if ((r100 instanceof ViewGroup) == false) goto L36;
        Iterator<View> r113 = UtilityKotlinExtentionsKt.g((ViewGroup) r100).iterator();
    L27:
        if (r113.hasNext() == false) goto L37;
        c(r113.next());
        goto L27
    L37:
        return;
    }

    public PadAndPcPlayGuideNew(DataCenter r100, com.bytedance.android.livesdk.castscreen.padandpc.vm.a r101) {
        this.f104479r = r100;
        this.f104480s = r101;
        this.f104472k = UtilityKotlinExtentionsKt.i(8);
        this.f104473l = UtilityKotlinExtentionsKt.i(12);
        this.f104474m = UtilityKotlinExtentionsKt.i(21);
        PadAndPcPlayGuideNew$dismissDialogAction$1 r102 = PadAndPcPlayGuideNew$dismissDialogAction$1.INSTANCE;
        this.f104475n = new CompositeDisposable();
        this.f104476o = LazyKt.lazy(new PadAndPcPlayGuideNew$isPortrait$2(this));
        this.f104478q = PadAndPcPlayGuideNew$onGuideExpandListener$1.INSTANCE;
    }

    public static final void b(PadAndPcPlayGuideNew r110, View r111, View r112, View r113) {
        r110.getClass();
        if (r111 != null) goto L5;
        return;
    L5:
        if (r112 != null) goto L7;
    L10:
        boolean r100 = true;
    L11:
        r110.f104477p = r100;
        r110.f104478q.invoke(Boolean.valueOf(r100));
        LinearLayout r101 = r110.f104462a;
        if (r101 == null) goto L42;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof LinearLayout.LayoutParams) == true) goto L16;
        r102 = null;
    L16:
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        if (r103 == null) goto L22;
        if (r100 == false) goto L20;
        int r104 = 48;
    L21:
        r103.gravity = r104;
        goto L22
    L20:
        r104 = 80;
    L22:
        Iterator<View> r105 = UtilityKotlinExtentionsKt.g(r101).iterator();
        int r106 = 0;
    L24:
        if (r105.hasNext() == false) goto L42;
        View r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        View r109 = r107;
        if (r100 == true) goto L31;
        r109.setPadding(0, 0, 0, 0);
        if (r106 == 0) goto L41;
        int r114 = r110.f104473l;
        if (r106 != (r101.getChildCount() - 1)) goto L39;
        int r115 = r110.f104474m;
    L40:
        UIUtils.updateLayoutMargin(r109, -3, r114, -3, r115);
        goto L41
    L39:
        r115 = -3;
    L41:
        r106 = r108;
        goto L24
    L31:
        if (Intrinsics.areEqual(r109, r111) == false) goto L33;
        UtilityKotlinExtentionsKt.w(r109);
        UIUtils.updateLayoutMargin(r109, -3, 0, -3, 0);
        r109.setPadding(0, 0, 0, UtilityKotlinExtentionsKt.i(36));
        goto L41
    L33:
        UtilityKotlinExtentionsKt.t(r109);
    L42:
        if (r100 == false) goto L53;
        if (r112 == null) goto L45;
        UtilityKotlinExtentionsKt.w(r112);
    L45:
        boolean r116 = r111 instanceof qv2.a;
        Object r117 = r111;
        if (r116 == true) goto L48;
        r117 = null;
    L48:
        qv2.a r118 = (qv2.a) r117;
        if (r118 == null) goto L51;
        int r119 = r110.f104472k;
        r118.J(r119, 0, r119, 0);
    L51:
        if (r113 == null) goto L63;
        r113.setRotation(180.0f);
    L63:
        r110.d();
        return;
    L53:
        if (r112 == null) goto L55;
        UtilityKotlinExtentionsKt.t(r112);
    L55:
        boolean r120 = r111 instanceof qv2.a;
        Object r121 = r111;
        if (r120 == true) goto L58;
        r121 = null;
    L58:
        qv2.a r122 = (qv2.a) r121;
        if (r122 == null) goto L61;
        int r123 = r110.f104472k;
        r122.J(r123, r123, r123, r123);
    L61:
        if (r113 == null) goto L63;
        r113.setRotation(0.0f);
        goto L63
    L7:
        if (r112.getVisibility() != 0) goto L10;
        r100 = false;
        goto L11
    }
}
