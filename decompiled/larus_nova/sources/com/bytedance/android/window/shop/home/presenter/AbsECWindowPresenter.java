package com.bytedance.android.window.shop.home.presenter;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbsECWindowPresenter extends QPresenter {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f188241l = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f188242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f188243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f188244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f188245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f188246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f188247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f188248k;

    public static final class a {
    }

    static {
    }

    public final int G() {
        return ((Number) this.f188244g.getValue()).intValue();
    }

    public final ECWindowDialogFragment I() {
        return (ECWindowDialogFragment) this.f188245h.getValue();
    }

    public final int K() {
        return ((Number) this.f188248k.getValue()).intValue();
    }

    public final int N() {
        return ((Number) this.f188246i.getValue()).intValue();
    }

    public final ECWindowViewModel O() {
        return (ECWindowViewModel) this.f188242e.getValue();
    }

    public AbsECWindowPresenter() {
        this.f188242e = LazyKt.lazy(new AbsECWindowPresenter$viewModel$2(this));
        this.f188243f = LazyKt.lazy(new AbsECWindowPresenter$screenHeight$2(this));
        this.f188244g = LazyKt.lazy(new AbsECWindowPresenter$croppedHeight$2(this));
        this.f188245h = LazyKt.lazy(new AbsECWindowPresenter$dialogFragment$2(this));
        this.f188246i = LazyKt.lazy(new AbsECWindowPresenter$topBarHeight$2(this));
        this.f188247j = LazyKt.lazy(new AbsECWindowPresenter$tabBarHeight$2(this));
        this.f188248k = LazyKt.lazy(new AbsECWindowPresenter$liveHeight$2(this));
    }

    public final void D() {
        FragmentActivity r100 = null;
        if (O().isSplitStyle() == false) goto L13;
        nj.d r101 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r101 == null) goto L13;
        QContext r102 = u();
        FragmentActivity r103 = com.bytedance.android.ec.core.utils.l0.c(r102.c());
        if ((r103 instanceof FragmentActivity) == true) goto L9;
        r103 = null;
    L9:
        if (r103 != null) goto L11;
        r102.a();
    L11:
        r101.g();
    L13:
        if (O().getShopParam().isCroppedStyle() == false) goto L22;
        ECWindowDialogFragment r104 = I();
        if (r104 == null) goto L32;
        r104.dismissAllowingStateLoss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L33;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L33:
        return;
    L32:
        return;
    L22:
        QContext r106 = u();
        FragmentActivity r107 = com.bytedance.android.ec.core.utils.l0.c(r106.c());
        if ((r107 instanceof FragmentActivity) == false) goto L26;
        r100 = r107;
    L26:
        if (r100 != null) goto L28;
        r100 = r106.a();
    L28:
        r100.finish();
    }

    public float E() {
        if (F() == true) goto L5;
        return 1.0f;
    L5:
        Pair<Integer, Integer> r100 = O().getOffsetState().getValue();
        if (r100 != null) goto L10;
        return 0.0f;
    L10:
        return RangesKt.coerceAtMost(Math.abs(r100.getFirst().intValue()) / W(), 1.0f);
    }

    public final boolean F() {
        return O().couldLive();
    }

    public final boolean Q() {
        ECWindowDialogFragment r100 = I();
        if (r100 != null) goto L12;
        Activity r101 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        if (r101 != null) goto L8;
    L10:
        return false;
    L8:
        if (r101.isFinishing() != true) goto L10;
        return true;
    L12:
        return r100.isRemoving();
    }

    public final boolean T() {
        if (O().isCroppedStyle() == true) goto L5;
        return true;
    L5:
        Integer r100 = O().getCroppedState().getValue();
        if (r100 != null) goto L9;
    L13:
        return false;
    L9:
        if (r100.intValue() != 2) goto L13;
        if (E() <= 0.75f) goto L13;
        return true;
    }

    public final LifecycleOwner U() {
        ECWindowDialogFragment r100 = I();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public final void V() {
        Function1<hp3.b, Boolean> r100 = O().getEventDeliverer();
        if (r100 != null) goto L5;
    L7:
        ECWindowParam r101 = O().getShopParam();
        JSONObject r102 = new JSONObject();
        if (r101.isEcShare() == false) goto L10;
        r102.put("is_ec_shopping", 1);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r101.getShareContent());
        r102.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, r101.getShareObject());
    L11:
        String r103 = r102.toString();
        com.bytedance.android.ec.core.utils.m0 r104 = new com.bytedance.android.ec.core.utils.m0("sslocal://goods/shop/search");
        r104.a("uid", r101.getAuthorId());
        r104.a("sec_uid", r101.getSecAuthorId());
        r104.a("enter_from", r101.getEnterFrom());
        r104.a("enter_method", r101.getEnterMethod());
        r104.a(com.bytedance.android.ec.core.event.a.KEY_WHICH_ACCOUNT, r101.getWhichAccount());
        r104.a("share_params", r103);
        r104.a("search_hint", u().c().getString(R.string.commerce_store_v2_search_here));
        r104.a(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r101.getStoreSourcePage());
        r104.a(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r101.getStoreSourceMethod());
        r104.a(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r101.getStoreGroupType());
        r104.a("search_params", r101.getSearchParams());
        r104.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r101.getEntranceLocation());
        r104.a("tmp_id", r101.getTempId());
        r104.a(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API, (String) r101.getPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API));
        Map<String, Object> r105 = O().getMetaInfoWithoutKolId();
        r105.put("author_id", O().getShopParam().getAuthorId());
        Unit r106 = Unit.INSTANCE;
        r104.a("metaInfo", com.bytedance.android.ec.hybrid.list.util.k.d(r105));
        BtmSDK r107 = BtmSDK.INSTANCE;
        r104.a(PhotoEnterModel.SOURCE_BTM_TOKEN, BtmSDK.createJumpSourceBtmToken$default(r107, "a1.b7635.c2240.d1027", PageFinder.via(y()), null, 4, null));
        com.bytedance.android.ec.sdk.helper.p r108 = com.bytedance.android.ec.sdk.helper.p.f48130a;
        String r109 = r104.c();
        QContext r110 = u();
        FragmentActivity r111 = com.bytedance.android.ec.core.utils.l0.c(r110.c());
        if ((r111 instanceof FragmentActivity) == true) goto L14;
        r111 = null;
    L14:
        if (r111 != null) goto L16;
        r111 = r110.a();
    L16:
        r108.d(r109, r111);
        String r112 = r107.createBtmId(new BtmItemBuilder("a1.b7635.c2240.d1027", Boolean.TRUE).withView(y()).build());
        O().doEventAction("enter_search", new Pair[]{TuplesKt.to("enter_from", "search_window"), TuplesKt.to("author_id", O().getShopParam().getAuthorId()), TuplesKt.to("btm_id", r112)});
        boolean r113 = com.bytedance.android.ec.window.base.shop.j.f49648a;
        com.bytedance.android.ec.window.base.shop.j.b("window_search_in_window", PostActionType.DO);
        return;
    L10:
        r102.put("is_ec_shopping", 0);
        goto L11
    L5:
        if (r100.invoke(lp3.c.f510215b).booleanValue() != true) goto L7;
    }

    public final int W() {
        return K() - N();
    }

    public final View X() {
        View r100 = y();
    L4:
        if (r100.getId() == 16908290) goto L12;
        if ((r100.getParent() instanceof View) == false) goto L12;
        Object r101 = r100.getParent();
        if (r101 == null) goto L11;
        r100 = (View) r101;
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L12:
        return r100;
    }

    public float Y(int r100) {
        Pair<Integer, Integer> r101 = O().getOffsetState().getValue();
        if (r101 == null) goto L12;
        int r102 = Math.abs(r101.getFirst().intValue());
        if (F() == false) goto L14;
        if (r102 <= W()) goto L10;
        r102 = r102 - W();
        goto L14
    L10:
        r102 = 0;
    L14:
        return RangesKt.coerceAtMost(r102 / r100, 1.0f);
    L12:
        return 0.0f;
    }

    public static boolean S(float r100, float r101) {
        if (Math.abs(Math.abs(r100) - Math.abs(r101)) >= 1.0E-6f) goto L5;
        return true;
    L5:
        return false;
    }
}
