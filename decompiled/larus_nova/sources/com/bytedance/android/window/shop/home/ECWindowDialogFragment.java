package com.bytedance.android.window.shop.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import zq3.l;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/home/ECWindowDialogFragment;", "Lcom/bytedance/android/window/shop/home/ECBaseDialogFragment;", "Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel;", "", "<init>", "()V", "Companion", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowDialogFragment extends ECBaseDialogFragment<ECWindowViewModel> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f188173k = 0;

    public static final class Companion {
        public static ECWindowDialogFragment a(ECWindowParam r100, Uri r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "shopParam");
            ECWindowDialogFragment r103 = new ECWindowDialogFragment();
            Bundle r104 = new Bundle();
            r104.putSerializable("shop_param", r100);
            r104.putSerializable(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, String.valueOf(r102));
            Unit r105 = Unit.INSTANCE;
            r103.setArguments(r104);
            r103.f188161g = r101;
            if (r100.isCroppedStyle() == false) goto L5;
            r103.getLifecycle().addObserver(new ECWindowDialogFragment$Companion$newInstance$1$2());
        L5:
            return r103;
        }
    }

    static {
        Lazy r100 = BtmSDKWrapper.f41960a;
        BtmSDKWrapper.c(ECWindowDialogFragment.class, "a1.b7635");
    }

    public ECWindowDialogFragment() {
        super(Reflection.getOrCreateKotlinClass(ECWindowViewModel.class));
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        if (T90().isSplitStyle() == true) goto L6;
        U90(this);
        return;
    L6:
        nj.d r100 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r100 == null) goto L10;
        getActivity();
        new AnonymousClass1(this);
        r100.n();
        return;
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r100 = com.bytedance.android.window.shop.lifecycle.c.f189233a;
        com.bytedance.android.window.shop.lifecycle.c.c(T90().getShopParam().getLifecycleMonitorId());
    }

    public static void U90(ECBaseDialogFragment r100) {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Lazy r101 = BtmSDKWrapper.f41960a;
        Uri r102 = this.f188161g;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = UriProtector.getQueryParameter(r102, PhotoEnterModel.SOURCE_BTM_TOKEN);
    L6:
        BtmSDKWrapper.b(this, "a1.b7635", r104);
        Bundle r105 = getArguments();
        if (r105 == null) goto L9;
        Serializable r106 = r105.getSerializable("shop_param");
    L11:
        if ((r106 instanceof ECWindowParam) == true) goto L13;
        r106 = null;
    L13:
        ECWindowParam r107 = (ECWindowParam) r106;
        if (r107 != null) goto L16;
        return;
    L16:
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r108 = com.bytedance.android.window.shop.lifecycle.c.f189233a;
        com.bytedance.android.window.shop.lifecycle.f r109 = com.bytedance.android.window.shop.lifecycle.c.a(r107.getLifecycleMonitorId());
        if (r109 == null) goto L19;
        r109.o(getContext(), r107);
    L19:
        ECWindowViewModel r110 = T90();
        Uri r111 = this.f188161g;
        FragmentActivity r112 = getActivity();
        if (r112 == null) goto L22;
        r103 = xn.c.d(r112);
    L22:
        r110.init(r107, r111, r103);
        T90().appendEventParams(new Pair[]{TuplesKt.to("icon_page", "101")});
        T90().getShopParam().setBtmPageId(BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        T90().loadHeaderInfo();
        return;
    L9:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment
    public final QUIModule S90(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.ec_activity_window, null, false);
        ViewGroup r103 = (ViewGroup) r102.findViewById(R.id.ec_shop_top_bar_container);
        if (l.b() == false) goto L5;
        th.a.c(th.a.e(r103.getContext(), true), R.layout.ec_window_layout_top_info_bar_enhance_search, r103, true);
    L7:
        return new com.bytedance.android.window.shop.home.module.h(r102, T90().isCroppedStyle(), T90().isVideoTrailerOrSplitOpt(), new ECWindowDialogFragment$createRootModule$1(this));
    L5:
        th.a.c(th.a.e(r103.getContext(), true), R.layout.ec_window_layout_top_info_bar, r103, true);
        goto L7
    }
}
