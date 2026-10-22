package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.wm0;
import com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService;
import com.bytedance.android.livesdkapi.business.OnLiveRenQiBaoDialogListener;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class q4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f117346e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f117347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f117348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f117349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f117350d;

    public static final class a {
        public static void b(DataCenter r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r100).i(ToolbarButton.REN_QI_BAO.extended());
            r100.put("data_ren_qi_bao_button_dismiss", Boolean.TRUE);
        }

        public static void a(int r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "entranceType");
            Intrinsics.checkNotNullParameter(r102, "errorStatus");
            Intrinsics.checkNotNullParameter(r103, "errorMessage");
            JSONObject r104 = new JSONObject();
            r104.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r101);     // Catch: Exception -> L7
            if (r100 != 0) goto L9;
            r104.put("error_status", r102);     // Catch: Exception -> L7
            r104.put("error_message", r103);     // Catch: Exception -> L7
        L9:
            ((ILiveRenQiBaoService) jc1.k.n(ILiveRenQiBaoService.class)).renQiBaoMonitor("renqibao_live_entry", r100, r104);
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }
    }

    public static final class b implements OnLiveRenQiBaoDialogListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q4 f117351a;

        @Override // com.bytedance.android.livesdkapi.business.OnLiveRenQiBaoDialogListener
        public final void onDismiss() {
            q4 r100 = this.f117351a;
            Disposable r101 = null;
            r100.f117347a = null;
            Disposable r102 = r100.f117348b;
            if (r102 != null) goto L5;
        L9:
            DataCenter r103 = this.f117351a.f117350d;
            if (r103 == null) goto L13;
            r103.put("data_ren_qi_bao_dialog_showing", Boolean.FALSE);
            return;
        L13:
            return;
        L5:
            if ((!r102.isDisposed()) == false) goto L7;
            r101 = r102;
        L7:
            if (r101 == null) goto L9;
            r101.dispose();
            goto L9
        }

        @Override // com.bytedance.android.livesdkapi.business.OnLiveRenQiBaoDialogListener
        public final void onShow() {
            q4 r100 = this.f117351a;
            r100.getClass();
            r100.f117348b = xs2.b.a().b(zg1.n2.class).subscribe(new r4(r100));
            DataCenter r101 = this.f117351a.f117350d;
            if (r101 == null) goto L6;
            r101.put("data_ren_qi_bao_dialog_showing", Boolean.TRUE);
            return;
        }

        public b(q4 r100) {
            this.f117351a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.n
    public final void onShow() {
        a("livesdk_show_popular_treasure");
        DataCenter r100 = this.f117350d;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        int r102 = com.bytedance.android.livesdk.config.setting.t.f121217a;
        if ((!r101) == false) goto L19;
        DataCenter r103 = this.f117350d;
        if (r103 == null) goto L12;
        Boolean r104 = (Boolean) r103.get("data_is_anchor", Boolean.FALSE);
    L14:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L16;
        String r105 = "tool_panel";
    L17:
        a.a(1, r105, "", "");
        return;
    L16:
        r105 = "share_panel";
        goto L17
    L12:
        r104 = null;
        goto L14
    L19:
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.e(r100, false) != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        String r100 = com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b());
        int r101 = com.bytedance.android.livesdk.utils.n5.f159086a;
        Intrinsics.checkNotNullParameter(r100, "key");
        return !((Boolean) new com.bytedance.android.livesdk.sharedpref.e("has_enter_ren_qi_bao_entry_" + r100, Boolean.FALSE).getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.f551006f;
    }

    public final void a(String r100) {
        com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
        HashMap r102 = new HashMap();
        if (com.bytedance.android.live.core.utils.z.e(this.f117350d, false) == false) goto L5;
        String r103 = "tool_panel";
    L6:
        r102.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r103);
        DataCenter r104 = this.f117350d;
        String r105 = "0";
        if (r104 == null) goto L12;
        Room r106 = com.bytedance.android.live.core.utils.z.o(r104);
        if (r106 == null) goto L12;
        String r107 = String.valueOf(r106.f162599id);
        if (r107 == null) goto L12;
    L13:
        r102.put("room_id", r107);
        DataCenter r108 = this.f117350d;
        if (r108 == null) goto L23;
        Room r109 = com.bytedance.android.live.core.utils.z.o(r108);
        if (r109 == null) goto L23;
        IUser r110 = r109.author();
        if (r110 == null) goto L23;
        String r111 = r110.getIdString();
        if (r111 == null) goto L23;
        r105 = r111;
    L23:
        r102.put("anchor_id", r105);
        if (com.bytedance.android.live.core.utils.z.e(this.f117350d, false) == false) goto L26;
        String r112 = "my_group";
    L27:
        r102.put("serving_type", r112);
        r102.put("enter_from", "live");
        r101.sendLog(r100, r102, new Object[0]);
        return;
    L26:
        r112 = "other_group";
    L12:
        r107 = "0";
        goto L13
    L5:
        r103 = "share_panel";
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        String r111 = com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b());
        int r100 = com.bytedance.android.livesdk.utils.n5.f159086a;
        Intrinsics.checkNotNullParameter(r111, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("has_enter_ren_qi_bao_entry_" + r111, Boolean.FALSE), Boolean.TRUE);
        DataCenter r112 = this.f117350d;
        if (r112 != null) goto L5;
        return;
    L5:
        Boolean r101 = null;
        Room r113 = (Room) r112.get("data_room", null);
        if (r113 != null) goto L8;
        return;
    L8:
        IUser r102 = ((IUserService) jc1.k.n(IUserService.class)).user().b();
        DataCenter r103 = this.f117350d;
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L15:
        if (r102.getSecret() != 1) goto L19;
        if (r104 == false) goto L19;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_can_not_ren_qi_bao, 0);
        return;
    L19:
        HashMap r105 = new HashMap();
        r105.put("is_live", "1");
        r105.put("scene", IPerformanceManager.SCENE_CLICK_DOU_PLUS);
        IUser r106 = r113.author();
        if (r106 == null) goto L23;
        Intrinsics.checkNotNullParameter(r106, "$this$secUidExt");
        String r107 = r106.getCastSecUid();
        if (r107 == null) goto L23;
    L24:
        r105.put("sec_anchor_id", r107);
        DataCenter r108 = this.f117350d;
        if (r108 == null) goto L27;
        LiveMode r109 = com.bytedance.android.live.core.utils.z.c(r108);
    L28:
        int r114 = com.bytedance.android.live.core.utils.h1.f66189a;
        r105.put("live_type", com.bytedance.android.live.core.utils.i1.a(r109));
        Uri.Builder r115 = UriProtector.parse(wm0.f121538a.getValue().d()).buildUpon();
        if (r104 == false) goto L31;
        String r116 = "tool_panel";
    L32:
        Uri.Builder r117 = r115.appendQueryParameter(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r116).appendQueryParameter("enter_from", "live");
        if (r104 == false) goto L35;
        String r118 = "my_group";
    L36:
        Uri.Builder r119 = r117.appendQueryParameter("serving_type", r118).appendQueryParameter("font_scale", String.valueOf(1.0d));
        IUser r120 = r113.author();
        if (r120 == null) goto L39;
        Intrinsics.checkNotNullParameter(r120, "$this$secUidExt");
        String r121 = r120.getCastSecUid();
    L40:
        Uri.Builder r122 = r119.appendQueryParameter("sec_anchor_id", r121).appendQueryParameter("room_id", r113.getIdStr());
        RoomAuthStatus r123 = r113.getRoomAuthStatus();
        if (r123 == null) goto L43;
        r101 = Boolean.valueOf(r123.getEnableUserCard());
    L43:
        r122.appendQueryParameter("encrypt_audience", String.valueOf(!r101.booleanValue()));
        this.f117347a = ((ILiveRenQiBaoService) jc1.k.n(ILiveRenQiBaoService.class)).showRenQiBaoDialog(this.f117349c, r105, r115.toString(), new b(this));
        a("livesdk_click_popular_treasure");
        return;
    L39:
        r121 = null;
        goto L40
    L35:
        r118 = "other_group";
        goto L36
    L31:
        r116 = "share_panel";
        goto L32
    L27:
        r109 = null;
    L23:
        r107 = "";
        goto L24
    L11:
        if (com.bytedance.android.live.core.utils.z.e(r103, false) != true) goto L13;
        r104 = true;
        goto L15
    }

    public q4(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f117349c = r100;
        this.f117350d = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        if (this.f117350d != null) goto L6;
        this.f117350d = r101;
        return;
    }
}
