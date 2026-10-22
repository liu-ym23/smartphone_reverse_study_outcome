package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import am2.x;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.g3;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f117468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f117469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f117470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f117471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f117472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f117473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f117474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d f117475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f117476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f117477j;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void Y6() {
        this.f117476i.put("more_pane_watch_later_show_log_send", Boolean.FALSE);
    }

    public final Map<String, String> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("from_panel", "more_function_panel");
        Integer r101 = this.f117468a;
        int r102 = this.f117473f;
        if (r101 != null) goto L6;
    L8:
        int r103 = this.f117474g;
        if (r101 != null) goto L12;
    L14:
        String r104 = "";
    L15:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ICON_STATUS, r104);
        r100.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        return r100;
    L12:
        if (r101.intValue() != r103) goto L14;
        r104 = "cancel_watch_later";
        goto L15
    L6:
        if (r101.intValue() != r102) goto L8;
        r104 = "watch_later";
        goto L15
    }

    public final Context getContext() {
        return this.f117477j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        u.l().sendLog("livesdk_watch_later_icon_click", b(), new Object[]{Room.class, x.class});
        Integer r111 = this.f117468a;
        int r100 = this.f117473f;
        if (r111 != null) goto L6;
    L8:
        int r101 = this.f117474g;
        if (r111 != null) goto L12;
        return;
    L12:
        if (r111.intValue() != r101) goto L16;
        this.f117468a = Integer.valueOf(this.f117473f);
        long r102 = z.o(this.f117476i).getRoomId();
        String r103 = this.f117471d;
        g.b(new n(r102, "room", new WatchLaterBehavior$requestCancelWatchLater$1(this), this.f117472e, r103));
        return;
    L16:
        return;
    L6:
        if (r111.intValue() != r100) goto L8;
        long r104 = z.o(this.f117476i).getRoomId();
        String r105 = this.f117471d;
        g.a(new n(r104, "room", new WatchLaterBehavior$requestAddWatchLater$1(this), this.f117472e, r105));
    }

    public static final void a(k r100, IWatchLaterData r101) {
        TextView r102 = r100.f117469b;
        if (r102 == null) goto L5;
        r102.setText(r101.getDisplayText());
    L5:
        ImageModel r103 = r101.getIcon();
        if (r103 == null) goto L11;
        List<String> r104 = r103.getUrls();
        if (r104 == null) goto L11;
        String r105 = (String) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L11;
    L12:
        RxUtilKt.c(g3.a(r105).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(new i(r100)).onErrorComplete().subscribe(new j(r100)), r100.f117472e);
        String r106 = r101.getDrawerButtonText();
        r100.f117476i.put("action_click_panel_watch_later", r106);
        return;
    L11:
        r105 = "";
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117472e.dispose();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117470c = r100.findViewById(R.id.icon);
        this.f117469b = (TextView) r100.findViewById(R.id.name);
        Boolean r102 = (Boolean) this.f117476i.get("more_pane_watch_later_show_log_send", Boolean.FALSE);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d r103 = this.f117475h;
        if (r103 == null) goto L5;
        boolean r104 = r103.isRequesting();
    L7:
        if (r102.booleanValue() == true) goto L11;
        if (r104 == true) goto L12;
        this.f117476i.put("more_pane_watch_later_show_log_send", Boolean.TRUE);
        u.l().sendLog("livesdk_watch_later_icon_show", b(), new Object[]{Room.class, x.class});
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r104 = true;
        goto L7
    }

    public k(s r100, DataCenter r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f117476i = r101;
        this.f117477j = r102;
        String r103 = r100.f116205o;
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(s2.a(r103).optInt("status"));
    L6:
        this.f117468a = r104;
        this.f117471d = "WatchLaterBehavior";
        this.f117472e = new CompositeDisposable();
        this.f117473f = 1;
        this.f117474g = 2;
        MorePanelDynamicControllerViewModel.Companion.getClass();
        this.f117475h = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d) MorePanelDynamicControllerViewModel.Companion.a(r101);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
