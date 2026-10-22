package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.entity.StoreUITheme;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.home.view.SearchHotWordFlipperAdapter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopTopBarSearchPresenterV2 extends ECShopBasePresenter implements View.OnClickListener {
    public static final int N = 0;
    public static final int O = 0;
    public boolean A;
    public Pair<Integer, Integer> B;
    public Integer C;
    public Integer D;
    public Pair<Integer, Integer> E;
    public Pair<Integer, Integer> F;
    public Pair<Integer, Integer> G;
    public int[] H;
    public int[] I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int[] f184048J;
    public final Function2<Integer, Integer, Unit> K;
    public final Lazy L;
    public Integer M;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ECStoreCollapsibleTextView f184049u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayout f184050v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f184051w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ECViewFlipper f184052x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f184053y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SearchHotWordFlipperAdapter f184054z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 f184055a;

        public b(ECShopTopBarSearchPresenterV2 r100) {
            this.f184055a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ImageView r101 = (ImageView) this.f184055a.y().findViewById(R.id.ec_store_fold_close_btn_image);
            if (((Boolean) r100).booleanValue() == false) goto L5;
            r101.setImageResource(R.drawable.shopping_ic_store_compat_close_white);
            return;
        L5:
            r101.setImageResource(R.drawable.shopping_ic_store_sheet_close_black);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 f184056a;

        public c(ECShopTopBarSearchPresenterV2 r100) {
            this.f184056a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Lazy r101 = ECStoreFoldPhoneHelper.f183487a;
            ECStoreFoldPhoneHelper.c(this.f184056a.f183834h);
        }
    }

    public static final class d implements ECStoreCollapsibleTextView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 f184057a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TextView f184058a;

            public a(TextView r100) {
                this.f184058a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Lazy r100 = TransitionAnimationHelper.f47620a;     // Catch: Throwable -> L4
                TextView r101 = this.f184058a;     // Catch: Throwable -> L4
                TransitionAnimationHelper.e(r101, r101.getHeight() / 2, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements ECViewFlipper.IOnPositionChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f184059a;

            public b(d r100) {
                this.f184059a = r100;
            }

            @Override // com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper.IOnPositionChangeListener
            public final void onPositionChange(int r100, int r101) {
                ECViewFlipper r102 = this.f184059a.f184057a.f184052x;
                if (r102 == null) goto L5;
                int r103 = r102.getCurrentPos();
            L6:
                if (r103 != (-1)) goto L8;
                return;
            L8:
                SearchSuggestWord r104 = this.f184059a.f184057a.f184054z.y2(r103);
                if (r104 != null) goto L11;
                return;
            L11:
                this.f184059a.f184057a.v0(r104);
                return;
            L5:
                r103 = -1;
                goto L6
            }
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final Drawable b() {
            return ECShopTopBarSearchPresenterV2.q0(this.f184057a);
        }

        public d(ECShopTopBarSearchPresenterV2 r100) {
            this.f184057a = r100;
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final TextView c(ECStoreCollapsibleTextView r100) {
            Intrinsics.checkNotNullParameter(r100, "parentView");
            TextView r101 = new TextView(r100.getContext());
            if (this.f184057a.u0() == false) goto L5;
        L8:
            LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);
            r102.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
        L9:
            r101.setLayoutParams(r102);
            if (this.f184057a.u0() == false) goto L12;
            r101.setPadding(com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3));
        L13:
            r101.post(new a(r101));
            return r101;
        L12:
            r101.setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(4));
            goto L13
        L5:
            if (ECShopABSettings.getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() != 0) goto L8;
            r102 = new LinearLayout.LayoutParams(-2, -2);
            r102.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
            goto L9
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final View d(ECStoreCollapsibleTextView r110) {
            Intrinsics.checkNotNullParameter(r110, "parentView");
            if (ECShopABSettings.getEC_SHOP_SEARCH_HOT_WORD_SCROLL() == 0) goto L8;
            LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(0), -1);
            r100.weight = 1.0f;
            FrameLayout r101 = new FrameLayout(r110.getContext());
            r101.setLayoutParams(r100);
            ECViewFlipper r102 = new ECViewFlipper(r110.getContext(), null, 0, 6, null);
            this.f184057a.f184052x = r102;
            r102.setPositionChangeListener(new b(this));
            r102.setScrollSpeed(800);
            r102.setInterval(3000);
            r102.setViewFlipperAdapter(this.f184057a.f184054z);
            Unit r103 = Unit.INSTANCE;
            r101.addView(r102);
            if (this.f184057a.T().needShowServiceEntryInNavigationBar() == true) goto L7;
            ECShopTopBarSearchPresenterV2 r104 = this.f184057a;
            View r105 = new View(r110.getContext());
            FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(14), -1);
            r111.topMargin = com.bytedance.android.shopping.extensions.b.b(2);
            r111.bottomMargin = com.bytedance.android.shopping.extensions.b.b(2);
            r111.gravity = GravityCompat.END;
            r105.setBackground(new com.bytedance.android.shopping.store.home.view.t(new int[]{0, -1}));
            r101.addView(r105, r111);
            r104.f184053y = r105;
        L7:
            return r101;
        L8:
            TextView r106 = new TextView(r110.getContext());
            r106.setTextSize(2, 13.0f);
            LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(0), -2);
            r112.weight = 1.0f;
            r106.setMaxLines(1);
            r106.setEllipsize(null);
            r106.setLayoutParams(r112);
            return r106;
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final void a(ECStoreCollapsibleTextView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Drawable r102 = r100.getBackground();
            if ((r102 instanceof com.bytedance.android.shopping.store.home.view.a) == true) goto L5;
            Drawable r103 = null;
        L6:
            com.bytedance.android.shopping.store.home.view.a r104 = (com.bytedance.android.shopping.store.home.view.a) r103;
            if (r104 == null) goto L10;
            r104.f184696h = r101 / 2.0f;
            r104.invalidateSelf();
        L10:
            if ((r102 instanceof GradientDrawable) == true) goto L12;
            r102 = null;
        L12:
            GradientDrawable r105 = (GradientDrawable) r102;
            if (r105 == null) goto L16;
            r105.setCornerRadius(r101 / 2.0f);
            return;
        L16:
            return;
        L5:
            r103 = r102;
            goto L6
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 f184060a;

        public e(ECShopTopBarSearchPresenterV2 r100) {
            this.f184060a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            com.bytedance.android.shopping.store.home.entity.n r100 = (com.bytedance.android.shopping.store.home.entity.n) r210;
            if (r100 == null) goto L191;
            ViewParent r101 = null;
            this.f184060a.M = null;
            if (r100.c() == false) goto L16;
            ECStoreCollapsibleTextView r102 = this.f184060a.f184049u;
            if (r102 == null) goto L10;
            r102.setVisibility(8);
        L10:
            LinearLayout r103 = this.f184060a.f184050v;
            if (r103 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
        L13:
            if (r103 == null) goto L16;
            r103.setVisibility(8);
        L16:
            if (r100.d() == false) goto L25;
            ECStoreCollapsibleTextView r104 = this.f184060a.f184049u;
            if (r104 == null) goto L20;
            r104.setVisibility(8);
        L20:
            LinearLayout r105 = this.f184060a.f184050v;
            if (r105 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
        L23:
            if (r105 == null) goto L185;
            r105.setVisibility(8);
            return;
        L185:
            return;
        L25:
            ECShopTopBarSearchPresenterV2 r106 = this.f184060a;
            com.bytedance.android.shopping.store.home.entity.g r107 = r100.f183751e;
            boolean r108 = true;
            if (r107 != null) goto L28;
        L30:
            boolean r109 = false;
        L31:
            r106.getClass();
            if (r109 == true) goto L40;
            ECStoreCollapsibleTextView r110 = r106.f184049u;
            if (r110 == null) goto L36;
            r110.setVisibility(8);
        L36:
            LinearLayout r111 = this.f184060a.f184050v;
            if (r111 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
        L39:
            r111.setVisibility(8);
            return;
        L40:
            ECStoreCollapsibleTextView r112 = r106.f184049u;
            if (r112 == null) goto L75;
            r112.g(0.0f);
            Lazy r113 = ECAppInfoService.f48110a;
            if (we.a.f559330a == false) goto L45;
        L52:
            r112.c(th.a.e(r106.u().c(), true).getResources().getString(R.string.commerce_store_v3_search), false);
            if (r106.u0() == false) goto L74;
            SimpleDraweeView r114 = r112.f184559c;
            if (r114 == null) goto L64;
            ViewGroup.LayoutParams r115 = r114.getLayoutParams();
            if ((r115 instanceof LinearLayout.LayoutParams) == true) goto L59;
            r115 = null;
        L59:
            LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) r115;
            if (r116 == null) goto L62;
            int r117 = com.bytedance.android.shopping.extensions.b.b(8);
            int r118 = ECStoreCollapsibleTextView.f184553q;
            r116.setMargins(r117, r118, com.bytedance.android.shopping.extensions.b.b(2), r118);
            Unit r119 = Unit.INSTANCE;
        L63:
            r114.setLayoutParams(r116);
            goto L64
        L62:
            r116 = null;
        L64:
            TextView r120 = r112.f184563g;
            if (r120 == null) goto L74;
            r120.setPadding(com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3));
            ViewGroup.LayoutParams r121 = r120.getLayoutParams();
            if ((r121 instanceof LinearLayout.LayoutParams) == true) goto L69;
            r121 = null;
        L69:
            LinearLayout.LayoutParams r122 = (LinearLayout.LayoutParams) r121;
            if (r122 == null) goto L72;
            r122.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
            Unit r123 = Unit.INSTANCE;
        L73:
            r120.setLayoutParams(r122);
            goto L74
        L72:
            r122 = null;
        L74:
            r112.setSearchTextViewListener(new e3(r106));
            goto L75
        L45:
            if (r106.u0() == true) goto L52;
            r112.b(R.drawable.search_camera_img, null);
            r112.a(null);
            if (r106.F() == false) goto L49;
        L51:
            r112.setSearchCameraClickListener(new d3(r106));
            goto L52
        L49:
            if (r106.A == true) goto L51;
            r106.T().doAnyEventActionWithBtm("a1.b6269.c5887.d51683", PageFinder.via(r106.y()), "photo_search_icon_show", MapsKt.mapOf(TuplesKt.to("current_page", "shop_search_page")), new Pair[0]);
            r106.A = true;
        L75:
            r106.T().doEventAction("show_search", new Pair[]{TuplesKt.to("enter_from", "search_store")});
            r106.T().doEventAction("shop_search_entrance_show", new Pair[]{TuplesKt.to("enter_from", "search_store"), TuplesKt.to("type", "bar")});
            ECStoreCollapsibleTextView r124 = r106.f184049u;
            if (r124 == null) goto L164;
            int r125 = com.bytedance.android.ec.core.utils.s.f45717a;
            com.bytedance.android.shopping.store.home.entity.e r126 = r100.f183748b;
            if (r126 == null) goto L84;
            com.bytedance.android.shopping.store.home.entity.s r127 = r126.f183697l;
            if (r127 == null) goto L84;
            com.bytedance.android.shopping.store.home.entity.u r128 = r127.a();
            if (r128 == null) goto L84;
            String r129 = r128.b();
        L85:
            r106.C = com.bytedance.android.ec.core.utils.s.b(r129);
            com.bytedance.android.shopping.store.home.entity.e r130 = r100.f183748b;
            if (r130 == null) goto L92;
            com.bytedance.android.shopping.store.home.entity.s r131 = r130.f183697l;
            if (r131 == null) goto L92;
            com.bytedance.android.shopping.store.home.entity.u r132 = r131.a();
            if (r132 == null) goto L92;
            String r133 = r132.a();
        L93:
            r106.D = com.bytedance.android.ec.core.utils.s.b(r133);
            int[] r134 = new int[2];
            Integer r135 = r106.C;
            int r136 = 16664938;
            if (r135 == null) goto L96;
            int r137 = r135.intValue();
        L97:
            r134[0] = r137;
            Integer r138 = r106.C;
            if (r138 == null) goto L100;
            r136 = r138.intValue();
        L100:
            r134[1] = r136;
            r106.I = r134;
            int[] r139 = new int[2];
            Integer r140 = r106.C;
            int r141 = 3951489;
            if (r140 == null) goto L103;
            int r142 = r140.intValue();
        L104:
            r139[0] = r142;
            Integer r143 = r106.C;
            if (r143 == null) goto L107;
            r141 = r143.intValue();
        L107:
            r139[1] = r141;
            r106.H = r139;
            int r144 = (int) 3205896227L;
            boolean r145 = r106.p0();
            boolean r146 = r106.F();
            com.bytedance.android.shopping.store.home.entity.n r147 = r106.T().getHeaderArea().getValue();
            if (r147 == null) goto L112;
            com.bytedance.android.shopping.store.home.entity.p r148 = r147.f183754h;
            if (r148 == null) goto L112;
            String r149 = r148.g();
        L113:
            Integer r150 = com.bytedance.android.ec.core.utils.s.b(r149);
            int r151 = -15329245;
            if (r145 == false) goto L116;
            r106.B = new Pair(Integer.valueOf(r144), Integer.valueOf(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR));
            int r152 = (int) 3875536895L;
            r106.F = new Pair(Integer.valueOf(r152), Integer.valueOf(r152));
        L118:
            int r153 = -1073741825;
        L121:
            if (ECShopABSettings.getEC_SHOP_SEARCH_HOT_WORD_SCROLL() == 0) goto L124;
            r106.F = new Pair(-1, -1);
        L124:
            if (r150 == null) goto L126;
            r151 = r150.intValue();
        L126:
            r106.G = new Pair(Integer.valueOf(r151), Integer.valueOf(r153));
            Integer r154 = r106.T().getStoreParam().getStoreUITheme();
            int r155 = StoreUITheme.DefaultDark.ordinal();
            if (r154 == null) goto L141;
            if (r154.intValue() != r155) goto L141;
            Integer r156 = r106.D;
            if (r156 == null) goto L134;
            int r157 = r156.intValue();
        L135:
            Integer r158 = Integer.valueOf(r157);
            Integer r159 = r106.D;
            if (r159 == null) goto L138;
            int r160 = r159.intValue();
        L139:
            r106.E = new Pair(r158, Integer.valueOf(r160));
        L156:
            ECStoreCollapsibleTextView.b r161 = new ECStoreCollapsibleTextView.b(r106.F.getFirst().intValue(), r106.F.getSecond().intValue(), r106.B.getFirst().intValue(), r106.B.getSecond().intValue(), r106.E.getFirst(), r106.E.getSecond(), null, null);
            if (ECShopABSettings.getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() == 0) goto L163;
            r161.f184577g = null;
            Integer r162 = com.bytedance.android.ec.core.utils.s.b("#FFFF7075");
            Integer r163 = com.bytedance.android.ec.core.utils.s.b("#FFFF3344");
            if (r162 == null) goto L162;
            if (r163 == null) goto L162;
            r161.f184578h = new com.bytedance.android.shopping.store.home.view.t(new int[]{r162.intValue(), r163.intValue()});
        L162:
            r161.f184575e = com.bytedance.android.ec.core.utils.s.b("#FFFF3344");
            r161.f184576f = com.bytedance.android.ec.core.utils.s.b("#FFFFFFFF");
        L163:
            Unit r164 = Unit.INSTANCE;
            r124.setStyleConfig(r161);
            goto L164
        L138:
            r160 = (int) 4294916946L;
            goto L139
        L134:
            r157 = (int) 4294916946L;
        L141:
            if (Intrinsics.areEqual(r106.T().isFlagShip(), Boolean.TRUE) == false) goto L151;
            Integer r165 = r106.D;
            if (r165 == null) goto L145;
            int r166 = r165.intValue();
        L146:
            Integer r167 = Integer.valueOf(r166);
            Integer r168 = r106.D;
            if (r168 == null) goto L149;
            int r169 = r168.intValue();
        L150:
            r106.E = new Pair(r167, Integer.valueOf(r169));
            goto L156
        L149:
            r169 = (int) 4282141569L;
            goto L150
        L145:
            r166 = (int) 4282141569L;
            goto L146
        L151:
            Integer r170 = r106.D;
            if (r170 == null) goto L154;
            int r171 = r170.intValue();
        L155:
            r106.E = new Pair(Integer.valueOf(r171), Integer.valueOf(r144));
            goto L156
        L154:
            r171 = (int) 4294916946L;
            goto L155
        L116:
            if (r146 == false) goto L119;
            r106.B = new Pair(Integer.valueOf(r144), 1447971);
            r106.F = new Pair(-1, -1);
            goto L118
        L119:
            r106.B = new Pair(Integer.valueOf(r144), Integer.valueOf(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR));
            r106.F = new Pair(-1, -1);
            r153 = -15329245;
        L112:
            r149 = null;
            goto L113
        L103:
            r142 = 3951489;
            goto L104
        L96:
            r137 = 16664938;
        L92:
            r133 = null;
        L84:
            r129 = null;
        L164:
            ECStoreCollapsibleTextView r172 = r106.f184049u;
            if (r172 != null) goto L167;
        L173:
            r106.w0();
            r106.T().getTopSearchInfo().a(r106.W(), new g3(r106), false);
            r106.T().getSelectedTabLocation().a(r106.W(), new h3(r106), false);
            r106.T().getCollapseFactor().a(r106.W(), new i3(r106), false);
            r106.T().getLiveState().a(r106.W(), new j3(r106), false);
            r106.T().getHeaderArea().a(r106.W(), new k3(r106), false);
            if (r106.T().needShowServiceEntryInNavigationBar() == false) goto L188;
            View r173 = r106.f184053y;
            if (r173 == null) goto L189;
            ViewParent r174 = r173.getParent();
            if ((r174 instanceof ViewGroup) == false) goto L181;
            r101 = r174;
        L181:
            ViewGroup r175 = (ViewGroup) r101;
            if (r175 == null) goto L190;
            r175.removeView(r173);
            return;
        L190:
            return;
        L189:
            return;
        L188:
            return;
        L167:
            if (r106.G() == false) goto L169;
        L172:
            r172.setCollapseEnable(r108);
            goto L173
        L169:
            if (r106.T().couldVideoV2() == true) goto L172;
            r108 = false;
            goto L172
        L28:
            if (r107.f183712e != true) goto L30;
            r109 = true;
            goto L31
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 f184061a;

        public f(ECShopTopBarSearchPresenterV2 r100) {
            this.f184061a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            if (this.f184061a.T().needShopProfilePin2Top() == false) goto L86;
            this.f184061a.w().b(R.id.ec_store_top_bar_mini_info_wrapper).f().setVisibility(0);
            if (r101 == null) goto L8;
            float r102 = r101.floatValue();
        L9:
            float r103 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102, 0.0f), 1.0f);
            int r104 = this.f184061a.t0();
            int r105 = (int) ((((com.bytedance.android.shopping.extensions.b.b(102) + r104) - com.bytedance.android.shopping.extensions.b.b(48)) * r103) + com.bytedance.android.shopping.extensions.b.b(48));
            this.f184061a.x0(r103, r104);
            ECShopTopBarSearchPresenterV2.r0(this.f184061a, r103, r104);
            ECShopTopBarSearchPresenterV2 r106 = this.f184061a;
            if (r106.u0() == true) goto L14;
            ECStoreCollapsibleTextView r107 = r106.f184049u;
            if (r107 == null) goto L14;
            com.bytedance.android.ec.core.utils.d2.c(r107, r105);
        L14:
            boolean r108 = true;
            if (ECShopABSettings.getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() == 0) goto L63;
            float r109 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(1 - (2 * r103), 1.0f), 0.0f);
            ECStoreCollapsibleTextView r110 = this.f184061a.f184049u;
            if (r110 == null) goto L19;
            r110.h(r109);
        L19:
            ECStoreCollapsibleTextView r111 = this.f184061a.f184049u;
            if (r111 == null) goto L54;
            if (r103 <= 0.5f) goto L25;
            r108 = false;
        L25:
            float r112 = Math.abs(r109);
            ECStoreCollapsibleTextView.b r113 = r111.f184558b;
            Integer r114 = null;
            if (r113 == null) goto L34;
            if (r108 == false) goto L31;
            Drawable r115 = r113.f184577g;
            if (r115 != null) goto L35;
            r115 = new ColorDrawable(0);
        L35:
            if (r115 == null) goto L39;
            TextView r116 = r111.f184563g;
            if (r116 == null) goto L39;
            r116.setBackground(r115);
        L39:
            if (r108 == false) goto L43;
            ECStoreCollapsibleTextView.b r117 = r111.f184558b;
            if (r117 == null) goto L46;
            r114 = r117.f184575e;
        L46:
            if (r114 == null) goto L50;
            int r118 = r114.intValue();
            TextView r119 = r111.f184563g;
            if (r119 == null) goto L50;
            r119.setTextColor(r118);
        L50:
            TextView r120 = r111.f184563g;
            if (r120 == null) goto L54;
            r120.setAlpha(r112);
            goto L54
        L43:
            ECStoreCollapsibleTextView.b r121 = r111.f184558b;
            if (r121 == null) goto L46;
            r114 = r121.f184576f;
            goto L46
        L31:
            r115 = r113.f184578h;
            if (r115 != null) goto L35;
            r115 = new ColorDrawable(0);
            goto L35
        L34:
            r115 = null;
        L54:
            if (this.f184061a.u0() == false) goto L59;
            ECStoreCollapsibleTextView r122 = this.f184061a.f184049u;
            if (r122 == null) goto L77;
            r122.f(r103);
            return;
        L77:
            return;
        L59:
            if (this.f184061a.T().needShowServiceEntryInNavigationBar() == false) goto L79;
            ECShopTopBarSearchPresenterV2 r123 = this.f184061a;
            ECStoreCollapsibleTextView r124 = r123.f184049u;
            if (r124 == null) goto L80;
            r124.j(r109, r123.K);
            return;
        L80:
            return;
        L79:
            return;
        L63:
            float r125 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(1 - (3 * r103), 1.0f), 0.0f);
            ECStoreCollapsibleTextView r126 = this.f184061a.f184049u;
            if (r126 == null) goto L67;
            r126.h(r125);
        L67:
            if (this.f184061a.u0() == false) goto L72;
            ECStoreCollapsibleTextView r127 = this.f184061a.f184049u;
            if (r127 == null) goto L82;
            r127.f(r103);
            return;
        L82:
            return;
        L72:
            if (this.f184061a.T().needShowServiceEntryInNavigationBar() == false) goto L84;
            ECShopTopBarSearchPresenterV2 r128 = this.f184061a;
            ECStoreCollapsibleTextView r129 = r128.f184049u;
            if (r129 == null) goto L85;
            r129.j(r125, r128.K);
            return;
        L85:
            return;
        L84:
            return;
        L8:
            r102 = 0.0f;
            goto L9
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 f184062a;

        public g(ECShopTopBarSearchPresenterV2 r100) {
            this.f184062a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if (this.f184062a.T().needShopProfilePin2Top() == false) goto L32;
            Float r102 = this.f184062a.T().getUpglideFactor().getValue();
            if (r102 == null) goto L8;
            float r103 = r102.floatValue();
        L9:
            float r104 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r103, 0.0f), 1.0f);
            int r105 = this.f184062a.t0();
            int r106 = (int) ((((com.bytedance.android.shopping.extensions.b.b(102) + r105) - com.bytedance.android.shopping.extensions.b.b(48)) * r104) + com.bytedance.android.shopping.extensions.b.b(48));
            float r107 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(1 - (3 * r104), 1.0f), 0.0f);
            this.f184062a.x0(r104, r105);
            ECShopTopBarSearchPresenterV2.r0(this.f184062a, r104, r105);
            ECShopTopBarSearchPresenterV2 r108 = this.f184062a;
            if (r108.u0() == true) goto L14;
            ECStoreCollapsibleTextView r109 = r108.f184049u;
            if (r109 == null) goto L14;
            com.bytedance.android.ec.core.utils.d2.c(r109, r106);
        L14:
            ECStoreCollapsibleTextView r110 = this.f184062a.f184049u;
            if (r110 == null) goto L18;
            r110.h(r107);
        L18:
            if (this.f184062a.u0() == false) goto L23;
            ECStoreCollapsibleTextView r111 = this.f184062a.f184049u;
            if (r111 == null) goto L28;
            r111.f(r104);
            return;
        L28:
            return;
        L23:
            if (this.f184062a.T().needShowServiceEntryInNavigationBar() == false) goto L30;
            ECShopTopBarSearchPresenterV2 r112 = this.f184062a;
            ECStoreCollapsibleTextView r113 = r112.f184049u;
            if (r113 == null) goto L31;
            r113.j(r107, r112.K);
            return;
        L31:
            return;
        L30:
            return;
        L8:
            r103 = 0.0f;
            goto L9
        }
    }

    public final boolean u0() {
        return ((Boolean) this.L.getValue()).booleanValue();
    }

    static {
        N = com.bytedance.android.shopping.extensions.b.b(72);
        O = com.bytedance.android.shopping.extensions.b.b(114);
    }

    public final int t0() {
        com.bytedance.android.shopping.store.viewmodel.i r100 = T().getViewTransitShipment().f187022a.get(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.g.class));
        Integer r101 = null;
        if ((r100 instanceof com.bytedance.android.shopping.store.viewmodel.g) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.shopping.store.viewmodel.g r102 = (com.bytedance.android.shopping.store.viewmodel.g) r100;
        if (u0() == false) goto L35;
        Integer r103 = this.M;
        if (r103 != null) goto L10;
        if (r102 == null) goto L15;
        ECShopMarqueeTextView r104 = r102.getView();
        if (r104 == null) goto L15;
        CharSequence r105 = r104.getText();
    L16:
        if (r105 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == true) goto L24;
        if (r102 == null) goto L29;
        View r107 = r102.getContainerView();
        if (r107 == null) goto L29;
        r101 = Integer.valueOf(ArraysKt.first(com.bytedance.android.shopping.store.utils.d.a(r107)));
    L29:
        int r108 = com.bytedance.android.shopping.extensions.k.g(r101, 0);
        if (r108 <= 0) goto L34;
        int r109 = RangesKt.coerceAtMost(r108, O);
        this.M = Integer.valueOf(r109);
        return r109;
    L34:
        return O;
    L24:
        return O;
    L18:
        if (StringsKt.isBlank(r105) == true) goto L21;
        r106 = false;
    L15:
        r105 = null;
        goto L16
    L10:
        return r103.intValue();
    L35:
        if (r102 == null) goto L39;
        ECShopMarqueeTextView r110 = r102.getView();
        if (r110 == null) goto L39;
        Integer r111 = Integer.valueOf(ArraysKt.first(com.bytedance.android.shopping.store.utils.d.a(r110)));
    L40:
        int r112 = com.bytedance.android.shopping.extensions.k.g(r111, 0);
        if (r102 == null) goto L46;
        ECTagListView r113 = r102.b();
        if (r113 == null) goto L46;
        r101 = Integer.valueOf(r113.getMeasuredWidth());
    L46:
        return Math.max(r112, com.bytedance.android.shopping.extensions.k.g(r101, 0));
    L39:
        r111 = null;
        goto L40
    }

    public final void w0() {
        Integer r100 = T().getStoreParam().getStoreUITheme();
        int r101 = StoreUITheme.DefaultDark.ordinal();
        if (r100 == null) goto L11;
        if (r100.intValue() != r101) goto L11;
        ECStoreCollapsibleTextView r102 = this.f184049u;
        if (r102 == null) goto L19;
        r102.setStrokeColor(this.f184048J);
        return;
    L19:
        return;
    L11:
        if (Intrinsics.areEqual(T().isFlagShip(), Boolean.TRUE) == false) goto L15;
        ECStoreCollapsibleTextView r103 = this.f184049u;
        if (r103 == null) goto L21;
        r103.setStrokeColor(this.H);
        return;
    L21:
        return;
    L15:
        ECStoreCollapsibleTextView r104 = this.f184049u;
        if (r104 == null) goto L23;
        r104.setStrokeColor(this.I);
        return;
    }

    public ECShopTopBarSearchPresenterV2(Fragment r100) {
        super(r100);
        this.f184054z = new SearchHotWordFlipperAdapter();
        this.B = new Pair(Integer.valueOf((int) 2568362019L), 1447971);
        this.E = new Pair(Integer.valueOf((int) 4294916946L), 16726866);
        int r101 = (int) BodyPartID.bodyIdMax;
        this.F = new Pair(Integer.valueOf(r101), Integer.valueOf(r101));
        this.G = new Pair(-15329245, -1073741825);
        int r102 = (int) 4282141569L;
        this.H = new int[]{r102, r102};
        int r103 = (int) 4294855018L;
        this.I = new int[]{r103, r103};
        this.f184048J = new int[]{16777215, 16777215};
        this.K = new ECShopTopBarSearchPresenterV2$reportSearchTextShow$1(this);
        this.L = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECShopTopBarSearchPresenterV2$isAppletTopBarMode$2.INSTANCE);
    }

    public static final com.bytedance.android.shopping.store.home.view.a q0(ECShopTopBarSearchPresenterV2 r100) {
        com.bytedance.android.shopping.store.home.entity.n r101 = r100.T().getHeaderArea().getValue();
        com.bytedance.android.shopping.store.home.view.a r102 = null;
        if (r101 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.e r103 = r101.f183748b;
        if (r103 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.s r104 = r103.f183697l;
        if (r104 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.u r105 = r104.a();
        if (r105 == null) goto L11;
        Integer r106 = r105.c();
    L13:
        if (r106 == null) goto L19;
        if (r106.intValue() != 1) goto L19;
        int r107 = (int) 4294930546L;
        r102 = new com.bytedance.android.shopping.store.home.view.a(new int[]{r107, (int) 4294948713L, (int) 4294938805L, (int) 4294938768L, r107}, com.bytedance.android.shopping.extensions.b.b(1), -1);
    L19:
        if ((r102 instanceof com.bytedance.android.shopping.store.home.view.a) == false) goto L27;
        ECStoreCollapsibleTextView r108 = r100.f184049u;
        if (r108 == null) goto L23;
        float r109 = r108.getHeight() / 2;
    L25:
        if (r109 <= 0) goto L27;
        r102.f184696h = r109;
        r102.invalidateSelf();
        goto L27
    L23:
        r109 = 0.0f;
    L27:
        return r102;
    L11:
        r106 = null;
        goto L13
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        ECStoreCollapsibleTextView r101 = (ECStoreCollapsibleTextView) w().b(R.id.ec_store_top_bar_search).f();
        this.f184049u = r101;
        r101.setComponentCreator(new d(this));
        this.f184050v = (LinearLayout) y().findViewById(R.id.ec_store_top_bar_search_area);
        this.f184051w = (ImageView) y().findViewById(R.id.ec_store_top_bar_search_icon);
        if (T().getStoreParam().isSplitMode() == false) goto L5;
        View r102 = y().findViewById(R.id.ec_store_fold_close_btn);
        T().isBrandShop().a(W(), new b(this), false);
        r102.setVisibility(0);
        r102.setOnClickListener(new c(this));
        com.bytedance.android.ec.core.utils.d2.d(y().findViewById(R.id.ec_store_top_bar_search), com.bytedance.android.shopping.extensions.b.b(44), 0, 0, 0);
    L6:
        ECStoreCollapsibleTextView r103 = this.f184049u;
        if (r103 == null) goto L9;
        r103.setOnClickListener(this);
    L9:
        ImageView r104 = this.f184051w;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallIconView");
    L12:
        r104.setOnClickListener(this);
        Lazy r105 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L18;
        ImageView r106 = this.f184051w;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallIconView");
    L17:
        r106.setImageResource(R.drawable.ec_store_search_icon_black);
    L18:
        T().getHeaderArea().a(W(), new e(this), false);
        T().getUpglideFactor().a(W(), new f(this), false);
        T().getSelectedTabLocation().a(W(), new g(this), false);
        return;
    L5:
        y().findViewById(R.id.ec_store_fold_close_btn).setVisibility(8);
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        int r100 = kn.a.f504133a;
        if (kn.a.a(r110.getId()) == false) goto L5;
        return;
    L5:
        if (V() == true) goto L8;
        return;
    L8:
        if (T().getStoreParam().isPreview() == false) goto L11;
        return;
    L11:
        if (ECShopABSettings.getEC_SHOP_SEARCH_HOT_WORD_SCROLL() == 0) goto L13;
        boolean r101 = true;
    L14:
        String r111 = null;
        String r112 = "";
        if (r101 == false) goto L34;
        SearchHotWordFlipperAdapter r102 = this.f184054z;
        ECViewFlipper r103 = this.f184052x;
        if (r103 == null) goto L27;
        Integer r104 = Integer.valueOf(r103.getCurrentPos());
        if (r104.intValue() < 0) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == true) goto L25;
        r104 = null;
    L25:
        if (r104 == null) goto L27;
        int r106 = r104.intValue();
    L28:
        SearchSuggestWord r107 = r102.y2(r106);
        if (r107 == null) goto L34;
        String r108 = r107.getWord();
        if (r108 == null) goto L34;
        String r109 = r108;
    L35:
        ECShopBasePresenter.l0(this, "", r109, Integer.valueOf(r110.getId()), null, null, 24);
        ECViewFlipper r113 = this.f184052x;
        if (r113 == null) goto L38;
        int r114 = r113.getCurrentPos();
    L39:
        if (r114 >= 0) goto L41;
    L43:
        SearchSuggestWord r115 = null;
    L44:
        if (r115 == null) goto L46;
        ECUrlModel r116 = r115.getIcon();
    L47:
        if (r116 == null) goto L49;
        boolean r117 = true;
    L50:
        ECStoreViewModel r118 = T();
        Pair<String, String>[] r119 = new Pair[4];
        r119[0] = TuplesKt.to("enter_from", "search_store");
        r119[1] = TuplesKt.to("type", "text");
        if (r115 == null) goto L53;
        r111 = r115.getWord();
    L53:
        if (r111 == null) goto L56;
        r112 = r111;
    L56:
        r119[2] = TuplesKt.to("hint", r112);
        if (r117 == false) goto L59;
        String r120 = "1";
    L60:
        r119[3] = TuplesKt.to("hot_icon_type", r120);
        r118.doEventAction("shop_search_entrance_click", r119);
        return;
    L59:
        r120 = "0";
        goto L60
    L49:
        r117 = false;
        goto L50
    L46:
        r116 = null;
        goto L47
    L41:
        if (r114 >= this.f184054z.getItemCount()) goto L43;
        r115 = this.f184054z.y2(r114);
        goto L44
    L38:
        r114 = -1;
        goto L39
    L21:
        r105 = false;
    L27:
        r106 = 0;
    L34:
        r109 = "";
        goto L35
    L13:
        r101 = false;
        goto L14
    }

    public final void v0(SearchSuggestWord r100) {
        ECStoreViewModel r101 = T();
        PageFinder r102 = PageFinder.via(this.f184049u);
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("module_name", "top_title_bar_search_hint_word");
        r103[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, T().getStoreParam().getShopId());
        String r104 = r100.getWord();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103[2] = TuplesKt.to("words_content", r104);
        r101.doAnyEventActionWithBtm("a1.b6269.c5887.d2396", r102, "show_ecom_component", MapsKt.mapOf(r103), new Pair[0]);
    }

    public static final void s0(ECShopTopBarSearchPresenterV2 r100, float r110) {
        if (r110 >= 0.0f) goto L5;
        r100.getClass();
        return;
    L5:
        float r101 = 1.0f - r100.a0(0.5f);
        if (r101 == 1.0f) goto L8;
    L35:
        r100.w0();
    L37:
        if (r110 != 0.0f) goto L39;
    L44:
        View r111 = r100.f184053y;
        if (r111 == null) goto L47;
        r111.setVisibility(0);
    L47:
        ECStoreCollapsibleTextView r112 = r100.f184049u;
        if (r112 == null) goto L50;
        r112.e(r101);
    L50:
        int r113 = ColorUtils.blendARGB(r100.G.getFirst().intValue(), r100.G.getSecond().intValue(), r101);
        ImageView r102 = r100.f184051w;
        if (r102 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallIconView");
    L53:
        r102.setColorFilter(r113);
        if (r101 == 0.0f) goto L56;
        return;
    L56:
        if (r100.A == true) goto L66;
        Map<String, Object> r114 = BtmSDK.INSTANCE.createReportParams("a1.b6269.c5887.d51683", PageFinder.via(r100.y()));
        ArrayList r103 = new ArrayList(r114.size());
        Iterator<Map.Entry<String, Object>> r115 = r114.entrySet().iterator();
    L59:
        if (r115.hasNext() == false) goto L61;
        Map.Entry<String, Object> r104 = r115.next();
        r103.add(TuplesKt.to(r104.getKey(), String.valueOf(r104.getValue())));
        goto L59
    L61:
        r100.T().doEventAction("photo_search_icon_show", MapsKt.toMap(r103), new Pair[]{TuplesKt.to("current_page", "shop_search_page")});
        r100.A = true;
        return;
    L66:
        return;
    L39:
        if (r110 == 1.0f) goto L44;
        View r116 = r100.f184053y;
        if (r116 == null) goto L47;
        r116.setVisibility(8);
        goto L47
    L8:
        if (r100.T().isCroppedStyle() == true) goto L35;
        ECStoreCollapsibleTextView r105 = r100.f184049u;
        if (r105 == null) goto L12;
        r105.setStrokeColor(r100.f184048J);
    L12:
        ECStoreCollapsibleTextView r106 = r100.f184049u;
        Integer r107 = null;
        if (r106 == null) goto L15;
        Drawable r108 = r106.getBackground();
    L16:
        com.bytedance.android.shopping.store.home.entity.n r109 = r100.T().getHeaderArea().getValue();
        if (r109 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.e r117 = r109.f183748b;
        if (r117 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.s r118 = r117.f183697l;
        if (r118 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.u r119 = r118.a();
        if (r119 == null) goto L25;
        r107 = r119.c();
    L25:
        if (r107 == null) goto L37;
        if (r107.intValue() != 1) goto L37;
        if ((r108 instanceof com.bytedance.android.shopping.store.home.view.a) == false) goto L37;
        com.bytedance.android.shopping.store.home.view.a r120 = (com.bytedance.android.shopping.store.home.view.a) r108;
        int[] r121 = r100.f184048J;
        r120.getClass();
        Intrinsics.checkNotNullParameter(r121, "colors");
        if (r121.length < 2) goto L37;
        r120.f184695g = r121;
        r120.a();
        r120.invalidateSelf();
        goto L37
    L15:
        r108 = null;
        goto L16
    }

    public final void x0(float r100, int r101) {
        if (u0() == true) goto L5;
        return;
    L5:
        View r102 = y().findViewById(R.id.ec_store_top_bar_mini_info_wrapper);
        int r103 = RangesKt.coerceAtLeast((int) (r101 * r100), 0);
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if (r104 != null) goto L9;
        return;
    L9:
        if (r104.width != r103) goto L11;
        return;
    L11:
        r104.width = r103;
        r102.setLayoutParams(r104);
    }

    public static final void r0(ECShopTopBarSearchPresenterV2 r100, float r101, int r102) {
        if (r100.u0() == false) goto L21;
        ECStoreCollapsibleTextView r103 = r100.f184049u;
        if (r103 == null) goto L22;
        int r104 = N + ((int) (r102 * RangesKt.coerceIn(r101, 0.0f, 1.0f)));
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r105 = null;
    L11:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 != null) goto L15;
        return;
    L15:
        if (r106.leftMargin == r104) goto L17;
    L19:
        r106.leftMargin = r104;
        r106.setMarginStart(r104);
        r103.setLayoutParams(r106);
        return;
    L17:
        if (r106.getMarginStart() != r104) goto L19;
        return;
    L22:
        return;
    }
}
