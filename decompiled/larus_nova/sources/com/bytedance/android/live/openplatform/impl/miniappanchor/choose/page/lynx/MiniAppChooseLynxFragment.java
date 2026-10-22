package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.lynx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/lynx/MiniAppChooseLynxFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBasePagerFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/c;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseLynxFragment extends MiniAppChooseBasePagerFragment implements c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f84249j = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public lp0.a f84250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f84251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HybridCard f84252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f84253i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment
    public final void S90() {
        HashMap<String, f> r100 = g.f573094a;
        f r101 = h.b(PerformanceScene.CHOOSE_PAGE_LYNX);
        Function0<Unit> r102 = new MiniAppChooseLynxFragment$loadData$1(this);
        int r103 = f.f573090d;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter("list_request_data_begin", "beginEvent");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("list_request_data_end", "endEvent");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r102, "action");     // Catch: Throwable -> L7
        r101.l("list_request_data_begin", null);     // Catch: Throwable -> L7
        r102.invoke();     // Catch: Throwable -> L7
        r101.l("list_request_data_end", null);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public MiniAppChooseLynxFragment() {
        this.f84253i = "";
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        lp0.a r100 = this.f84250f;
        if (r100 == null) goto L7;
        b r101 = r100.getContainer();
        if (r101 == null) goto L7;
        r101.j30(this);
    L7:
        ViewGroup r102 = this.f84251g;
        if (r102 == null) goto L10;
        r102.removeAllViews();
    L10:
        HybridCard r103 = this.f84252h;
        if (r103 == null) goto L14;
        r103.release();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        HybridCard r100 = this.f84252h;
        if (r100 == null) goto L6;
        r100.sendJsEvent(SendEventContainerMethodParamModel.EventKinds.onShow, SliceInitService.DEFAULT_SWITCH);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c
    public final void MX(int r100) {
        if (r100 == 0) goto L7;
        HybridCard r101 = this.f84252h;
        if (r101 == null) goto L8;
        r101.sendJsEvent("onTalentTabChange", SliceInitService.DEFAULT_SWITCH);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r101 = AnchorMiniAppDataContext.a.a();
        if (r101 == null) goto L12;
        n<MiniAppEntrancePermissionResponse> r102 = r101.getEntranceInfo();
        if (r102 == null) goto L12;
        MiniAppEntrancePermissionResponse r103 = r102.getValue();
        if (r103 == null) goto L12;
        Map<String, String> r104 = r103.getUrl_list();
        if (r104 == null) goto L12;
        String r105 = r104.get("talent_h5_url");
        if (r105 == null) goto L12;
    L13:
        this.f84253i = r105;
        lp0.a r106 = this.f84250f;
        if (r106 == null) goto L18;
        b r107 = r106.getContainer();
        if (r107 == null) goto L18;
        r107.Iz(this);
    L18:
        if (r100 != null) goto L20;
        HashMap<String, f> r108 = g.f573094a;
        h.b(PerformanceScene.CHOOSE_PAGE_LYNX).o();
        return;
    L20:
        HashMap<String, f> r109 = g.f573094a;
        h.b(PerformanceScene.CHOOSE_PAGE_LYNX).n();
        return;
    L12:
        r105 = "";
        goto L13
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment, com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f84251g = (ViewGroup) r100.findViewById(R.id.lynx_view);
        super.onViewCreated(r100, r101);
        HashMap<String, f> r102 = g.f573094a;
        f r103 = h.b(PerformanceScene.CHOOSE_PAGE_LYNX);
        int r104 = f.f573090d;
        r103.l("view_created", null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_mini_app_choose_lynx_fragment, r101, false);
    }
}
