package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.depend.share.ICommonLiveSharePackage;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/LiveLinkShareToThirdDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLinkShareToThirdDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f115461n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ICommonLiveSharePackage f115462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f115463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f115464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f115465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f115466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopiedLinkToThirdAppAdapter f115467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f115468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f115469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f115470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f115471m;

    public static final class a {
    }

    static {
    }

    public LiveLinkShareToThirdDialogFragment() {
        this.f115467i = new CopiedLinkToThirdAppAdapter();
        ILiveShareService r100 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.canBeFoundByShare();
    L6:
        this.f115470l = r101;
        return;
    L5:
        r101 = true;
        goto L6
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void U90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        ILiveShareService r101 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        if (r101 != null) goto L5;
    L10:
        Disposable r102 = this.f115471m;
        if (r102 == null) goto L14;
        r102.dispose();
        return;
    L14:
        return;
    L5:
        if (r101.canBeFoundByShare() == this.f115470l) goto L10;
        ILiveShareService r103 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        if (r103 == null) goto L10;
        r103.changeCanBeFoundByShare(this.f115470l);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(r102, LiveEndPageData.TAG_WINDOW);
        r102.clearFlags(67108864);
        r102.addFlags(Integer.MIN_VALUE);
        int r103 = S90(r102).getSystemUiVisibility();
        S90(r102).setSystemUiVisibility(r103 | 1280);
        r102.setStatusBarColor(0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (isVertical() == false) goto L5;
        int r101 = R.style.ttlive_CommonBottomDialogFast;
    L6:
        setStyle(1, r101);
        return;
    L5:
        r101 = R.style.ttlivebase_ttlive_NewProfileRightDialog;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        U90(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final void T90(LiveLinkShareToThirdDialogFragment r100, String r101) {
        r100.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("element_name", r101);
        r102.put("enter_from", "more_function");
        r102.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        r102.put("module_name", "share_panel");
        u.l().sendLog("livesdk_share_panel_element_click", r102, new Object[]{x.class, Room.class});
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f115469k = r110.findViewById(R.id.root_view);
        r110.post(new j(this));
        View r112 = r110.findViewById(R.id.share_link_panel_close_btn);
        this.f115463e = r112;
        if (r112 == null) goto L5;
        r112.setOnClickListener(new k(this));
    L5:
        this.f115464f = (ImageView) r110.findViewById(R.id.share_link_panel_privacy_icon);
        View r113 = r110.findViewById(R.id.share_link_panel_privacy_container);
        this.f115465g = r113;
        if (r113 == null) goto L8;
        r113.setOnClickListener(new g(this));
    L8:
        ImageView r114 = this.f115464f;
        if (r114 == null) goto L11;
        r114.setSelected(this.f115470l);
    L11:
        RecyclerView r115 = (RecyclerView) r110.findViewById(R.id.share_link_panel_recycler_view);
        this.f115466h = r115;
        if (r115 == null) goto L14;
        r115.setLayoutManager(new LinearLayoutManager(r110.getContext(), 0, false));
    L14:
        RecyclerView r116 = this.f115466h;
        if (r116 == null) goto L17;
        r116.setAdapter(this.f115467i);
    L17:
        this.f115467i.f115457b = new LiveLinkShareToThirdDialogFragment$initRecyclerView$1(this);
        RecyclerView r117 = this.f115466h;
        if (r117 == null) goto L20;
        r117.addItemDecoration(new LiveLinkShareToThirdDialogFragment$initRecyclerView$2());
    L20:
        Context r118 = getContext();
        if (r118 != null) goto L24;
        r118 = jc1.a.b();
    L24:
        if (r118 != null) goto L26;
        List r119 = CollectionsKt.emptyList();
    L36:
        List r100 = r119;
        if ((!r100.isEmpty()) == false) goto L39;
        CopiedLinkToThirdAppAdapter r101 = this.f115467i;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r119, "list");
        r101.f115456a = new ArrayList(r100);
        this.f115467i.notifyDataSetChanged();
    L39:
        this.f115468j = (ViewGroup) r110.findViewById(R.id.share_link_panel_poster_container);
        FragmentActivity r102 = getActivity();
        ViewGroup r103 = this.f115468j;
        Dialog r120 = getDialog();
        if (r102 == null) goto L58;
        if (r103 == null) goto L58;
        if (r120 == null) goto L58;
        ILiveShareService r104 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        if (r104 == null) goto L46;
        Disposable r121 = r104.initVSPoster(r102, r103, r120, this, this.f115462d, new h(this));
    L47:
        if (r121 == null) goto L58;
        this.f115471m = r121;
        ViewGroup r122 = this.f115468j;
        if (r122 == null) goto L51;
        UtilityKotlinExtentionsKt.w(r122);
    L51:
        View r123 = this.f115469k;
        if (r123 == null) goto L54;
        a1.k(r123, -1);
    L54:
        View r124 = r120.findViewById(R.id.ttlive_design_bottom_sheet);
        if (r124 == null) goto L57;
        a1.k(r124, -1);
    L57:
        setBottomSheetSlideProcessor(i.f115498a);
        goto L58
    L46:
        r121 = null;
    L58:
        LinkedHashMap r125 = new LinkedHashMap();
        r125.put("enter_from", "more_function");
        r125.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        r125.put("module_name", "share_panel");
        u.l().sendLog("livesdk_share_panel_module_show", r125, new Object[]{x.class, Room.class});
        return;
    L26:
        List r105 = CollectionsKt.listOf(new l[]{new c(), new d(), new com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.a(), new b(), new e()});
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L28:
        if (r107.hasNext() == false) goto L32;
        Object r108 = r107.next();
        if (((l) r108).a(r118) == false) goto L28;
        r106.add(r108);
        goto L28
    L32:
        List r109 = CollectionsKt.toMutableList(r106);
        if (r109.isEmpty() == false) goto L35;
        f r126 = new f();
        Intrinsics.checkNotNullParameter(r118, PerfLog.PARAM_KEY_CONTEXT_ID);
        r109.add(r126);
    L35:
        r119 = r109;
        goto L36
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_share_link_sub_panel_layout, r101, false);
    }
}
