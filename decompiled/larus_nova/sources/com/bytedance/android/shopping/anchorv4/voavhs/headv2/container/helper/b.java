package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.e;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.i;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.j;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.k;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.r;
import com.bytedance.android.shopping.utils.d0;
import com.bytedance.android.shopping.utils.x;
import com.bytedance.android.shopping.utils.y;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f169180k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f169181l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f169182m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Integer f169183n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f169184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.c f169185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f169186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f169187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f169188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f169189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f169190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f169191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f169192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s f169193j;

    public static final class a {
        public a() {
        }

        public static int c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Integer r101 = b.f169183n;
            if (r101 != null) goto L5;
            int r102 = th.a.f(r100).getDimensionPixelOffset(R.dimen.commerce_anchor_v3_top_area_height);
            b.f169183n = Integer.valueOf(r102);
            return r102;
        L5:
            return r101.intValue();
        }

        public static final int a(Context r100, boolean r101) {
            int r102 = b.f169180k;
            int r103 = y.f187160a;
            return (((int) ((y.d(r100, Boolean.valueOf(r101)) - com.bytedance.android.shopping.extensions.b.a(44)) / 3.0f)) * 2) + com.bytedance.android.shopping.extensions.b.a(6);
        }

        public static int b(Context r100, float r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Float r103 = Float.valueOf(r101);
            if (r103.floatValue() == 0.0f) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L9;
            r103 = null;
        L9:
            if (r103 == null) goto L11;
            float r105 = r103.floatValue();
        L12:
            int r106 = y.f187160a;
            return (int) (y.d(r100, Boolean.valueOf(r102)) * r105);
        L11:
            r105 = 0.6666667f;
            goto L12
        L5:
            r104 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b$b, reason: collision with other inner class name */
    public static final class RunnableC2551b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f169194a;

        public RunnableC2551b(RecyclerView r100) {
            this.f169194a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f169194a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f169195a;

        public c(b r100) {
            this.f169195a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            b r101 = this.f169195a;
            Object r102 = r100.getAnimatedValue();
            Integer r103 = null;
            if ((r102 instanceof Number) == true) goto L5;
            r102 = null;
        L5:
            Number r104 = (Number) r102;
            if (r104 == null) goto L8;
            r103 = Integer.valueOf(r104.intValue());
        L8:
            r101.f169186c = r103;
            this.f169195a.p();
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f169196a;

        public d(b r100) {
            this.f169196a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f169196a.p();
        }
    }

    static {
        new a();
        f169180k = com.bytedance.android.shopping.extensions.b.a(16);
        f169181l = com.bytedance.android.shopping.extensions.b.a(6);
        f169182m = com.bytedance.android.shopping.extensions.b.a(4);
    }

    public final int c() {
        return this.f169193j.W4();
    }

    public final int m() {
        RecyclerView r100 = this.f169193j.getRecyclerView();
        if (r100 == null) goto L14;
        Integer r101 = Integer.valueOf(r100.getWidth());
        if (r101.intValue() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L14;
        return r101.intValue();
    L7:
        r102 = false;
    L14:
        return n();
    }

    public final int n() {
        int r100 = y.f187160a;
        return y.d(this.f169192i, Boolean.valueOf(this.f169193j.rR().d()));
    }

    public final boolean o() {
        if (this.f169184a == true) goto L5;
        return false;
    L5:
        if (this.f169193j.n0() == true) goto L19;
        Integer r100 = this.f169193j.Lz();
        if (r100 != null) goto L10;
        return false;
    L10:
        if (r100.intValue() == 0) goto L12;
        return false;
    L12:
        if (this.f169193j.W4() <= 0) goto L14;
        boolean r101 = true;
    L15:
        if (r101 == true) goto L21;
        return true;
    L21:
        return false;
    L14:
        r101 = false;
        goto L15
    L19:
        return false;
    }

    public final void p() {
        RecyclerView r100 = this.f169193j.getRecyclerView();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isInLayout() == false) goto L7;
        r100.post(new RunnableC2551b(r100));
        return;
    L7:
        r100.requestLayout();
    }

    public final Context getContext() {
        return this.f169192i;
    }

    public final float b(int r100) {
        AnchorV4HeadV2VO r101 = this.f169193j.K10();
        if (r101 == null) goto L9;
        i r102 = r101.getCellStyle(r100);
        if (r102 == null) goto L9;
        Float r103 = r102.a();
        if (r103 == null) goto L9;
        return r103.floatValue();
    L9:
        return 1.0f;
    }

    public b(Context r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        this.f169192i = r100;
        this.f169193j = r101;
        this.f169184a = com.bytedance.android.shopping.anchorv3.detail.utils.a.a();
        this.f169187d = r101.getCurrentPosition();
    }

    public final int e(boolean r100, int r101) {
        if (s.a.b(this.f169193j, Integer.valueOf(r101), 2) == false) goto L7;
        return (int) (b(r101) * n());
    L7:
        if (h.a() == false) goto L10;
    L14:
        return -1;
    L10:
        if (this.f169184a == false) goto L14;
        if (r100 == false) goto L17;
        return a.a(this.f169192i, this.f169193j.rR().d());
    L17:
        return n();
    }

    public final int g(boolean r100, int r101) {
        AnchorV4HeadV2VO r102 = this.f169193j.K10();
        if (r102 == null) goto L9;
        List<HeaderContentModel> r103 = r102.getCells();
        if (r103 == null) goto L9;
        HeaderContentModel r104 = (HeaderContentModel) CollectionsKt.lastOrNull(r103);
        if (r104 == null) goto L9;
        HeaderMediaModel r105 = r104.getMedia();
    L10:
        boolean r106 = true;
        if (r105 != null) goto L13;
        boolean r107 = true;
    L14:
        AnchorV4HeadV2VO r108 = this.f169193j.K10();
        if (r108 == null) goto L21;
        List<HeaderContentModel> r109 = r108.getCells();
        if (r109 == null) goto L21;
        if (r101 != (r109.size() - 1)) goto L21;
    L23:
        if (this.f169193j.Mm() == false) goto L33;
        if (this.f169193j.Gv() == false) goto L33;
        if (r100 == false) goto L33;
        if (r101 == 0) goto L48;
        if (r107 == false) goto L49;
        if (r106 == false) goto L49;
        return 0;
    L49:
        return f169182m;
    L48:
        return 0;
    L33:
        if (this.f169193j.wZ() == false) goto L37;
        if (r101 == 0) goto L37;
        int r110 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        return com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(ECSettingKeys.A0().f()));
    L37:
        if (s.a.b(this.f169193j, Integer.valueOf(r101), 2) == false) goto L41;
        if (r101 != 0) goto L52;
        return com.bytedance.android.shopping.extensions.b.a(12);
    L52:
        return com.bytedance.android.shopping.extensions.b.a(6);
    L41:
        if (r100 == true) goto L43;
        return 0;
    L43:
        if (o() == false) goto L54;
        if (r101 != 0) goto L47;
        return f169180k;
    L47:
        return f169181l;
    L54:
        return 0;
    L21:
        r106 = false;
        goto L23
    L13:
        r107 = false;
    L9:
        r105 = null;
        goto L10
    }

    public final int h(boolean r100, int r101) {
        AnchorV4HeadV2VO r102 = this.f169193j.K10();
        if (r102 == null) goto L9;
        List<HeaderContentModel> r103 = r102.getCells();
        if (r103 == null) goto L9;
        boolean r104 = true;
        if (r101 != (r103.size() - 1)) goto L9;
    L11:
        if (s.a.b(this.f169193j, Integer.valueOf(r101), 2) == false) goto L17;
        AnchorV4HeadV2VO r105 = this.f169193j.K10();
        if (r105 != null) goto L15;
        return 0;
    L15:
        if (r105.getLastScaleIndex() == r101) goto L25;
        return 0;
    L25:
        return com.bytedance.android.shopping.extensions.b.a(12);
    L17:
        if (r100 == true) goto L19;
        return 0;
    L19:
        if (o() == false) goto L27;
        if (r104 == true) goto L22;
        return 0;
    L22:
        return f169180k;
    L27:
        return 0;
    L9:
        r104 = false;
        goto L11
    }

    public final int i(boolean r100, int r101) {
        if (s.a.b(this.f169193j, Integer.valueOf(r101), 2) == true) goto L11;
        if (r100 == true) goto L7;
    L9:
        return 0;
    L7:
        if (o() == false) goto L9;
        return com.bytedance.android.shopping.extensions.b.a(8);
    L11:
        return com.bytedance.android.shopping.extensions.b.a(12);
    }

    public final int l(boolean r100, int r101) {
        if (this.f169193j.W4() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L23;
        if (r100 == false) goto L35;
        Integer r103 = Integer.valueOf(r101);
        if (r103 == null) goto L14;
        if (r103.intValue() < this.f169193j.W4()) goto L14;
        return n();
    L14:
        if (this.f169193j.W4() != 1) goto L34;
        if (r103 == null) goto L34;
        if (r103.intValue() != 0) goto L34;
        return n();
    L34:
        return a.b(this.f169192i, this.f169193j.s00(), this.f169193j.rR().d());
    L35:
        return n();
    L23:
        if (s.a.b(this.f169193j, Integer.valueOf(r101), 2) == false) goto L26;
        return (int) (b(r101) * n());
    L26:
        if (o() == false) goto L30;
        if (r100 == false) goto L38;
        return a.a(this.f169192i, this.f169193j.rR().d());
    L38:
        return n();
    L30:
        return -1;
    L5:
        r102 = false;
        goto L6
    }

    public final int a(int r110, float r111, Integer r112) {
        RecyclerView r100 = null;
        boolean r101 = false;
        if (this.f169193j.isExpanded() == false) goto L5;
    L33:
        float r102 = k(this, r110, r112, null, null, 12);
    L34:
        r110 = r110 - 1;
        if (r110 <= 0) goto L39;
        if (this.f169193j.aN(r110) == true) goto L34;
    L39:
        float r113 = k(this, RangesKt.coerceAtLeast(r110, 0), r112, null, null, 12);
        RecyclerView r103 = this.f169193j.getRecyclerView();
        if ((r103 instanceof HeadRecyclerView) == false) goto L43;
        r100 = r103;
    L43:
        HeadRecyclerView r104 = (HeadRecyclerView) r100;
        if (r104 != null) goto L46;
    L48:
        if (r101 == true) goto L59;
        if (r112 == null) goto L52;
        int r114 = r112.intValue();
    L54:
        return (int) (r102 + ((r111 / r114) * (r113 - r102)));
    L52:
        r114 = m();
        goto L54
    L59:
        return (int) r113;
    L46:
        if (r104.t(false) != true) goto L48;
        r101 = true;
        goto L48
    L5:
        if (c() == 1) goto L33;
        if (r110 != (c() - 1)) goto L9;
    L10:
        RecyclerView r105 = this.f169193j.getRecyclerView();
        if ((r105 instanceof HeadRecyclerView) == false) goto L14;
        r100 = r105;
    L14:
        HeadRecyclerView r106 = (HeadRecyclerView) r100;
        if (r106 != null) goto L17;
    L19:
        if (r101 == false) goto L21;
        float r115 = k(this, r110 - 1, r112, null, null, 12);
    L58:
        return (int) r115;
    L21:
        float r107 = k(this, r110, r112, null, null, 12);
        int r108 = a.b(this.f169192i, this.f169193j.s00(), this.f169193j.rR().d());
        if (r110 != (c() - 1)) goto L28;
        float r109 = (r108 + h(this.f169193j.isExpanded(), r110)) / 2.0f;
        if (r111 >= (-r109)) goto L32;
        float r116 = (Math.abs(r111) - r109) / r109;
        float r117 = k(this, r110 + 1, r112, null, null, 12);
        int r118 = x.f187159a;
        r107 = r107 + ((r117 - r107) * r116);
    L32:
        return (int) r107;
    L28:
        if (r110 != c()) goto L32;
        float r119 = r108;
        float r120 = k(this, r110 - 1, r112, null, null, 12);
        int r121 = x.f187159a;
        r115 = r120 + ((r107 - r120) * ((r119 - r111) / r119));
        goto L58
    L17:
        if (r106.t(false) != true) goto L19;
        r101 = true;
        goto L19
    L9:
        if (r110 != c()) goto L33;
        goto L10
    }

    public final int d(boolean r100, int r101, Boolean r102) {
        if (this.f169193j.qV(Integer.valueOf(r101), r102) == false) goto L7;
        if (r100 == false) goto L14;
        return com.bytedance.android.shopping.extensions.b.a(12);
    L14:
        return com.bytedance.android.shopping.extensions.b.a(48);
    L7:
        if (r100 == true) goto L9;
    L11:
        return 0;
    L9:
        if (o() == false) goto L11;
        return f169180k;
    }

    public final float f(int r100, Integer r101, boolean r102) {
        AnchorV4HeadV2VO r103 = this.f169193j.K10();
        Float r104 = null;
        if (r103 == null) goto L7;
        List<HeaderContentModel> r105 = r103.getCells();
        if (r105 == null) goto L7;
        HeaderContentModel r106 = (HeaderContentModel) CollectionsKt.getOrNull(r105, r100);
    L8:
        if (r106 == null) goto L16;
        r r107 = r106.getMultiPreview();
        if (r107 == null) goto L16;
        List<k> r108 = r107.a();
        if (r108 == null) goto L16;
        k r109 = (k) CollectionsKt.getOrNull(r108, 0);
        if (r109 == null) goto L16;
        HeaderContentModel r110 = r109.a();
    L17:
        if (r110 == null) goto L22;
        Float r111 = r110.getWHScale(r102);
        if (r111 == null) goto L22;
        r104 = r111;
    L24:
        if (r104 == null) goto L26;
        float r112 = r104.floatValue();
    L27:
        if (r101 == null) goto L29;
        int r113 = r101.intValue();
    L31:
        return r113 / r112;
    L29:
        r113 = m();
        goto L31
    L26:
        r112 = 1.0f;
    L22:
        if (r106 == null) goto L24;
        r104 = r106.getWHScale(r102);
    L16:
        r110 = null;
    L7:
        r106 = null;
        goto L8
    }

    public final int j(boolean r100, int r101, Boolean r102) {
        AnchorV4HeadV2VO r103 = this.f169193j.K10();
        int r104 = 0;
        if (r103 == null) goto L21;
        List<HeaderContentModel> r105 = r103.getCells();
        if (r105 == null) goto L21;
        HeaderContentModel r106 = (HeaderContentModel) CollectionsKt.getOrNull(r105, r101);
        if (r106 == null) goto L21;
        if (r106.getLynx() == null) goto L11;
        boolean r107 = this.f169193j.Pg().b(r106.getLynx());
    L13:
        if (r106.getNeedStatusBarPlace() == true) goto L19;
        if (r107 == false) goto L21;
        j r108 = r106.getLynx();
        if (r108 == null) goto L21;
        if (r108.d() != true) goto L21;
    L19:
        return 0;
    L11:
        r107 = false;
    L21:
        if (this.f169193j.qV(Integer.valueOf(r101), r102) == false) goto L25;
        if (r100 == false) goto L63;
        return com.bytedance.android.shopping.extensions.b.a(12);
    L63:
        return com.bytedance.android.shopping.extensions.b.a(44);
    L25:
        if (r100 == false) goto L30;
        if (o() == false) goto L30;
        return f169180k;
    L30:
        if (h.a() == false) goto L65;
        AnchorV4HeadV2VO r109 = this.f169193j.K10();
        if (r109 == null) goto L36;
        List<HeaderContentModel> r110 = r109.getCells();
        if (r110 == null) goto L36;
        HeaderContentModel r111 = (HeaderContentModel) CollectionsKt.getOrNull(r110, r101);
    L37:
        if (r100 == true) goto L57;
        if (r111 == null) goto L42;
        Float r112 = r111.getTopPadding();
        if (r112 == null) goto L42;
        int r113 = com.bytedance.android.shopping.extensions.b.a(r112);
    L43:
        if (r111 == null) goto L66;
        if (r111.getNeedShowBar() != true) goto L66;
        if (this.f169193j.Pg().b(r111.getLynx()) == false) goto L53;
        j r114 = r111.getLynx();
        if (r114 == null) goto L53;
        if (r114.d() == true) goto L66;
    L53:
        if (e.f169209c == false) goto L55;
        r104 = a.c(this.f169192i) - d0.a();
        goto L66
    L55:
        r104 = a.c(this.f169192i);
    L66:
        return r104 + r113;
    L42:
        r113 = 0;
        goto L43
    L57:
        if (r111 == null) goto L67;
        Float r115 = r111.getTopPaddingHalf();
        if (r115 != null) goto L61;
        return 0;
    L61:
        return com.bytedance.android.shopping.extensions.b.a(r115);
    L67:
        return 0;
    L36:
        r111 = null;
        goto L37
    L65:
        return 0;
    }

    public final void q(int r110, View r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (h.a() == true) goto L5;
        return;
    L5:
        if (r110 >= 0) goto L7;
        return;
    L7:
        if (r111.getX() < 0) goto L36;
        ValueAnimator r100 = this.f169190g;
        if (r100 == null) goto L12;
        r100.cancel();
    L12:
        this.f169190g = null;
        if (this.f169186c != null) goto L15;
    L27:
        int r113 = a(r110, r111.getX(), null);
        Integer r101 = this.f169186c;
        if (r101 != null) goto L31;
    L32:
        this.f169186c = Integer.valueOf(r113);
        p();
    L33:
        this.f169187d = r110;
        this.f169188e = r111.getX();
        this.f169189f = r111;
        return;
    L31:
        if (r101.intValue() == r113) goto L33;
    L15:
        if (this.f169187d == r110) goto L27;
        if (this.f169188e == 0.0f) goto L19;
    L20:
        if (r112 == null) goto L27;
        if (r112.intValue() != 0) goto L27;
    L24:
        float r102 = k(this, this.f169187d, null, null, null, 14);
        float r114 = k(this, r110, null, null, null, 14);
        if (r102 == r114) goto L33;
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{r102, r114});
        r115.setDuration(350);
        r115.addUpdateListener(new c(this));
        r115.addListener(new d(this));
        r115.start();
        Unit r103 = Unit.INSTANCE;
        this.f169190g = r115;
        goto L33
    L19:
        if (r111.getX() == 0.0f) goto L24;
    }

    public static float k(b r100, int r101, Integer r102, Boolean r103, Boolean r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = null;
    L11:
        if (r103 == null) goto L13;
        r100.getClass();
        boolean r106 = r103.booleanValue();
    L14:
        boolean r107 = true;
        boolean r108 = !r106;
        AnchorV4HeadV2VO r109 = r100.f169193j.K10();
        if (r109 == null) goto L31;
        List<HeaderContentModel> r110 = r109.getCells();
        if (r110 == null) goto L31;
        HeaderContentModel r111 = (HeaderContentModel) CollectionsKt.getOrNull(r110, r101);
        if (r111 == null) goto L31;
        if (r111.getFixedHeight() == null) goto L31;
        if (r111.getLynx() == null) goto L25;
        boolean r112 = r100.f169193j.Pg().b(r111.getLynx());
    L26:
        if (r112 == false) goto L28;
    L29:
        int r113 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        float r114 = com.bytedance.android.ec.hybrid.list.util.c.d(Float.valueOf(r111.getFixedHeight().intValue() * (r100.n() / q.a(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS))))) - com.bytedance.android.ec.hybrid.list.util.c.d(20);
    L56:
        return (r114 + r100.j(r108, r101, r104)) + r100.d(r108, r101, r104);
    L28:
        if (r111.getLynx() != null) goto L31;
    L25:
        r112 = false;
    L31:
        if (r100.f169193j.qV(Integer.valueOf(r101), r104) == false) goto L34;
        r114 = r100.b(r101) * r100.n();
        goto L56
    L34:
        if (r108 == false) goto L51;
        if (s.a.a(r100.f169193j, Integer.valueOf(r101), 2) == false) goto L39;
        int r115 = k83.a.f502092a;
        int r116 = k83.a.b(false, k83.a.a(r100.f169193j.XU(), 0), r100.n());
    L53:
        r114 = r116;
        goto L56
    L39:
        if (r100.f169193j.W4() > 0) goto L42;
        r107 = false;
    L42:
        if (r107 == false) goto L48;
        if (r101 >= r100.f169193j.W4()) goto L46;
        r116 = a.b(r100.f169192i, r100.f169193j.s00(), r100.f169193j.rR().d());
        goto L53
    L46:
        r114 = r100.f(r101, r102, r108);
        goto L56
    L48:
        if (r100.o() == false) goto L54;
        r116 = a.a(r100.f169192i, r100.f169193j.rR().d());
    L54:
        r114 = r100.f(r101, r102, r108);
        goto L56
    L51:
        if (s.a.a(r100.f169193j, Integer.valueOf(r101), 2) == false) goto L54;
        int r117 = k83.a.f502092a;
        r116 = k83.a.b(true, k83.a.a(r100.f169193j.XU(), 0), r100.n());
        goto L53
    L13:
        r106 = r100.f169193j.isExpanded();
        goto L14
    }
}
