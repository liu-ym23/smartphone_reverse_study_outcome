package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.Point;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.extensions.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/view/FloatingTagLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatingTagLayout extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f165184d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o63.a f165185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f165186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function1<Float, Unit>> f165187c;

    public static final class a extends com.bytedance.android.ec.core.widget.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ FloatingTagLayout f165188g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ o63.a f165189h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ CombinationVO f165190i;

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            o63.a r101 = this.f165189h;
            if (r101 == null) goto L5;
            r101.a();
        L5:
            int r102 = ECSdk.f48106a;
            IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r103 == null) goto L10;
            j r104 = r103.getLiveWindowService();
            if (r104 == null) goto L10;
            r104.stopShowFloatInNextLifecycle();
        L10:
            Map<String, String> r105 = t63.a.f544661a;
            Context r106 = this.f165188g.getContext();
            p63.d r107 = this.f165190i.getInstructBoard();
            if (r107 == null) goto L13;
            String r108 = r107.f527887a;
        L14:
            t63.a.a(r106, r108);
            return;
        L13:
            r108 = null;
            goto L14
        }

        public a(FloatingTagLayout r100, o63.a r101, CombinationVO r102) {
            this.f165188g = r100;
            this.f165189h = r101;
            this.f165190i = r102;
            super(null, null, 3);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingTagLayout f165191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CombinationVO f165192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.base.d f165193c;

        public b(FloatingTagLayout r100, CombinationVO r101, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r102) {
            this.f165191a = r100;
            this.f165192b = r101;
            this.f165193c = r102;
        }

        public final void a() {
            final FloatingTagLayout r110 = this.f165191a;
            List<p63.c> r100 = this.f165192b.getTags();
            List<Point> r111 = this.f165192b.getPositions();
            Integer r101 = Integer.valueOf(this.f165192b.getHeadImageHeight());
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r112 = this.f165193c;
            int r102 = FloatingTagLayout.f165184d;
            if (r101 == null) goto L5;
            float r113 = r110.getWidth() / com.bytedance.android.shopping.extensions.b.b(r101);
        L6:
            Iterator<T> r114 = r100.iterator();
            int r115 = 0;
            int r103 = 0;
        L8:
            if (r114.hasNext() == false) goto L53;
            p63.c r104 = (p63.c) r114.next();
            if (r103 >= r111.size()) goto L59;
            ViewGroup.LayoutParams r105 = null;
            final GuideTagView r106 = new GuideTagView(r110.getContext(), null, 6, r115);
            Intrinsics.checkNotNullParameter(r104, "info");
            if (r104.f527881a == null) goto L15;
            r106.f165200e.setVisibility(r115);
            y.a(r106.f165200e, r104.f527881a);
        L16:
            r106.f165201f.setText(r104.f527882b);
            r106.f165202g.setText(r104.f527883c);
            if (r104.f527884d.length() != 0) goto L19;
            boolean r107 = true;
        L20:
            if (r107 == false) goto L22;
            r106.f165203h.setVisibility(8);
        L23:
            int r108 = r104.f527886f;
            if (r108 == 0) goto L46;
            if (r108 != 1) goto L27;
            r106.f165198c.setVisibility(r115);
            View r109 = r106.f165204i;
            ViewGroup.LayoutParams r116 = r109.getLayoutParams();
            if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
            r105 = r116;
        L43:
            ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r105;
            if (r117 == null) goto L47;
            r117.leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
            r109.setLayoutParams(r117);
        L47:
            r106.setVisibility(4);
            r106.setOnClickListener(new com.bytedance.android.shopping.anchorv3.matchpurchase.view.a(r106, r110, r104));
            r110.addView(r106, new FrameLayout.LayoutParams(-2, -2));
            Ref.FloatRef r118 = new Ref.FloatRef();
            r118.element = 0.0f;
            final Ref.FloatRef r119 = new Ref.FloatRef();
            r119.element = 0.0f;
            List<Point> r120 = r111;
            int r121 = r103;
            r106.post(new com.bytedance.android.shopping.anchorv3.matchpurchase.view.b(r110, r111, r103, r113, r104, r118, r106, r119, r112));
            if (r112 == null) goto L52;
            if (r112.i() != true) goto L52;
            ((ArrayList) r110.f165187c).add(new FloatingTagLayout$bindFloatingTags$2(r110, r106, r119));
        L52:
            r103 = r121 + 1;
            r111 = r120;
            r115 = 0;
            goto L8
        L27:
            if (r108 != 2) goto L29;
            r106.f165197b.setVisibility(r115);
            goto L47
        L29:
            if (r108 != 3) goto L47;
            r106.f165196a.setVisibility(r115);
            View r122 = r106.f165204i;
            ViewGroup.LayoutParams r123 = r122.getLayoutParams();
            if ((r123 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
            r105 = r123;
        L35:
            ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r105;
            if (r124 == null) goto L47;
            r124.topMargin = com.bytedance.android.shopping.extensions.b.b(8);
            r122.setLayoutParams(r124);
            goto L47
        L46:
            r106.f165199d.setVisibility(r115);
            goto L47
        L22:
            r106.f165203h.setVisibility(r115);
            r106.f165203h.setOnClickListener(new d(r106, r104));
            goto L23
        L19:
            r107 = false;
            goto L20
        L15:
            r106.f165200e.setVisibility(8);
            goto L16
        L59:
            return;
        L53:
            return;
        L5:
            r110.getClass();
            r113 = 1.0f;
            goto L6
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

    public FloatingTagLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FloatingTagLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public FloatingTagLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        boolean r103 = com.bytedance.android.ec.core.utils.a.c();
        this.f165186b = r103;
        this.f165187c = new ArrayList();
        if (r103 == false) goto L6;
        th.a.c(r100, R.layout.ec_commerce_anchor_v4_ar_layer_layout, this, true);
        return;
    }

    public /* synthetic */ FloatingTagLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(CombinationVO r100, String r101, o63.a r102, boolean r103, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r104) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        if (this.f165186b == false) goto L7;
        ((FrameLayout) findViewById(R.id.root_container)).setOnClickListener(new a(this, r102, r100));
        if (r101 == null) goto L7;
        ((FrameLayout) findViewById(R.id.root_container)).setContentDescription(r101);
    L7:
        this.f165185a = r102;
        p63.d r105 = r100.getInstructBoard();
        boolean r106 = r100.getV4Head();
        if (r105 == null) goto L25;
        LayoutInflater r107 = LayoutInflater.from(getContext());
        if (r106 == false) goto L13;
        int r108 = R.layout.shopping_layout_match_purchase_instruct_board_v4;
    L14:
        View r109 = r107.inflate(r108, this, false);
        if (k.c(r105.f527888b) == false) goto L25;
        if (k.c(r105.f527887a) == false) goto L25;
        ((TextView) r109.findViewById(R.id.tv_guide_board)).setText(r105.f527888b);
        r109.setOnClickListener(new c(this, r105));
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(24));
        r110.gravity = 85;
        if (r73.b.b() == false) goto L21;
        int r111 = 60;
    L24:
        r110.bottomMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111));
        Unit r112 = Unit.INSTANCE;
        addView(r109, r110);
        goto L25
    L21:
        if (r106 == false) goto L23;
        r111 = 47;
        goto L24
    L23:
        r111 = 12;
        goto L24
    L13:
        r108 = R.layout.shopping_layout_match_purchase_instruct_board;
    L25:
        if (r103 == false) goto L28;
        post(new b(this, r100, r104));
        return;
    }
}
