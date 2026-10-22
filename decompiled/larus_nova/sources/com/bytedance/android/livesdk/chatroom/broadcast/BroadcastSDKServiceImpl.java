package com.bytedance.android.livesdk.chatroom.broadcast;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import cg1.m1;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.NewLiveBroadcastShellFragment;
import com.bytedance.android.livesdk.chatroom.broadcast.widget.AnchorRoomManageWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.widget.LiveStartZoomWidget;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.RoomIntroMediaHelpDialog;
import com.bytedance.android.livesdk.config.ak0;
import com.bytedance.android.livesdk.config.ki;
import com.bytedance.android.livesdk.config.vh;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBroadcastCallback;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Random;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/broadcast/BroadcastSDKServiceImpl;", "Lcom/bytedance/android/livesdkapi/service/ILiveBroadcastSDKService;", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveBroadcastCallback;", "callback", "Landroid/os/Bundle;", "bundle", "Landroidx/fragment/app/Fragment;", "createLiveBroadcastFragment", "createLiveSubBroadcastFragment", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveBgBroadcastFragment;", "createBgBroadcastFragment", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "showMediaIntroDialog", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getStartZoomWidget", "getAnchorRoomManageWidget", "Lr70/b;", "Lh70/b;", "getBroadcastMediaElementFilter", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BroadcastSDKServiceImpl implements ILiveBroadcastSDKService {
    public static final String BG_FRAGMENT_TYPE = "ttlive_bg_fragment_type";
    public static final String BG_FRAGMENT_TYPE_BROADCAST_QR_CODE = "LiveBroadcastGameQRCodeActivity";
    public static final String BG_FRAGMENT_TYPE_BROWSE = "browse";
    public static final String BG_FRAGMENT_TYPE_MIRROR = "mirror";
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService
    public r70.b<? extends h70.b> getBroadcastMediaElementFilter() {
        return new m1();
    }

    public BroadcastSDKServiceImpl() {
        k.l(ILiveBroadcastSDKService.class, this);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService
    public Class<? extends Widget> getAnchorRoomManageWidget() {
        return AnchorRoomManageWidget.class;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService
    public Class<? extends Widget> getStartZoomWidget() {
        return LiveStartZoomWidget.class;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_chatroom_broadcast_BroadcastSDKServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(RoomIntroMediaHelpDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService
    public ILiveBgBroadcastFragment createBgBroadcastFragment(Bundle r100) {
        if (r100 != null) goto L5;
    L8:
        if (r100 == null) goto L10;
        String r101 = r100.getString(BG_FRAGMENT_TYPE);
    L12:
        if (Intrinsics.areEqual(r101, BG_FRAGMENT_TYPE_BROADCAST_QR_CODE) == true) goto L14;
        if (r100 != null) goto L17;
    L20:
        boolean r102 = LiveBgBroadcastShellFragment.f105243o;
        Bundle r103 = new Bundle();
        r103.putBundle("extra", r100);
        LiveBgBroadcastShellFragment r104 = new LiveBgBroadcastShellFragment();
        r104.setArguments(r103);
        if (r100 != null) goto L23;
    L25:
        return r104;
    L23:
        if (r100.getBoolean("extra_start_live_multi_process_restart") != true) goto L25;
        Room r105 = ((IBroadcastService) k.n(IBroadcastService.class)).getRestartContinueRoom();
        IRoomService r106 = (IRoomService) k.n(IRoomService.class);
        r106.setCurrentRoom(r105);
        r106.setStreamerRoom(r105);
        goto L25
    L17:
        if (Intrinsics.areEqual(r100.getString(BG_FRAGMENT_TYPE), BG_FRAGMENT_TYPE_BROWSE) == false) goto L20;
        return ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).createBgBrowseFragment(r100);
    L14:
        return ((IQRCodeService) k.n(IQRCodeService.class)).createQRCodeFragment(r100);
    L10:
        r101 = null;
        goto L12
    L5:
        if (Intrinsics.areEqual(r100.getString(BG_FRAGMENT_TYPE), BG_FRAGMENT_TYPE_MIRROR) == false) goto L8;
        return ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).createBgMirrorFragment(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService
    public void showMediaIntroDialog(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_chatroom_broadcast_BroadcastSDKServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new RoomIntroMediaHelpDialog(r100));
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService
    public Fragment createLiveBroadcastFragment(ILiveBroadcastCallback r110, Bundle r111) {
        boolean r100 = NewLiveBroadcastShellFragment.f105401g;
        Bundle r101 = new Bundle();
        r101.putBundle("extra", r111);
        boolean r102 = true;
        if (ak0.f119800a.getValue().booleanValue() == true) goto L5;
    L18:
        NewLiveBroadcastShellFragment r103 = new NewLiveBroadcastShellFragment();
        r103.setArguments(r101);
        r103.f105403e = r110;
        if (r111 != null) goto L21;
    L25:
        if (r111 != null) goto L27;
    L31:
        if (r111 != null) goto L33;
    L102:
        return r103;
    L33:
        if (r111.getBoolean("extra_start_live_rebuild") != true) goto L102;
        if (NewBroadcastMonitor.f64918c.length() == 0) goto L38;
        r102 = false;
    L38:
        String r112 = "";
        if (r102 == true) goto L41;
    L84:
        NewBroadcastMonitor.a r113 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_REBUILD, null, null, 14);
        ki r104 = ki.f120604a;
        String r105 = "1";
        if (r104.getValue().booleanValue() == false) goto L87;
        Object r106 = "1";
    L88:
        r113.i("real_build", r106);
        r113.a().report();
        LinkedHashMap r114 = new LinkedHashMap();
        if (r104.getValue().booleanValue() == true) goto L92;
        r105 = "0";
    L92:
        r114.put("real_rebuild", r105);
        if (r104.getValue().booleanValue() == false) goto L101;
        Room r107 = ((IBroadcastService) k.n(IBroadcastService.class)).getRestartContinueRoom();
        if (r107 == null) goto L100;
        String r108 = String.valueOf(r107.f162599id);
        if (r108 == null) goto L100;
        r112 = r108;
    L100:
        r114.put("room_id", r112);
        r114.putAll(((IBroadcastService) k.n(IBroadcastService.class)).getRestartContinueLogExtra());
    L101:
        u.l().sendLog("livesdk_anchor_activity_rebuild", r114, new Object[0]);
        goto L102
    L87:
        r106 = "0";
        goto L88
    L41:
        if (NewBroadcastMonitor.f64921f.isEmpty() == false) goto L54;
        Field[] r115 = NewBroadcastMonitor.SERVICE.class.getDeclaredFields();
        int r109 = r115.length;
        int r116 = 0;
    L43:
        if (r116 >= r109) goto L54;
        Field r117 = r115[r116];
        NewBroadcastMonitor.BUSINESSTYPE r118 = (NewBroadcastMonitor.BUSINESSTYPE) r117.getAnnotation(NewBroadcastMonitor.BUSINESSTYPE.class);
        if (r118 == null) goto L52;
        Object r119 = r117.get(NewBroadcastMonitor.SERVICE.Companion);
        if ((r119 instanceof String) == true) goto L49;
        r119 = null;
    L49:
        String r120 = (String) r119;
        if (r120 == null) goto L52;
        NewBroadcastMonitor.f64921f.put(r120, r118.type());
    L52:
        r116 = r116 + 1;
    L54:
        if (NewBroadcastMonitor.f64920e.isEmpty() == false) goto L67;
        Field[] r121 = NewBroadcastMonitor.SERVICE.class.getDeclaredFields();
        int r122 = r121.length;
        int r123 = 0;
    L56:
        if (r123 >= r122) goto L67;
        Field r124 = r121[r123];
        NewBroadcastMonitor.STAGE r125 = (NewBroadcastMonitor.STAGE) r124.getAnnotation(NewBroadcastMonitor.STAGE.class);
        if (r125 == null) goto L65;
        Object r126 = r124.get(NewBroadcastMonitor.SERVICE.Companion);
        if ((r126 instanceof String) == true) goto L62;
        r126 = null;
    L62:
        String r127 = (String) r126;
        if (r127 == null) goto L65;
        NewBroadcastMonitor.f64920e.put(r127, r125.stage());
    L65:
        r123 = r123 + 1;
    L67:
        if (NewBroadcastMonitor.f64925j.isEmpty() == false) goto L79;
        Field[] r128 = NewBroadcastMonitor.SERVICE.class.getDeclaredFields();
        int r129 = r128.length;
        int r130 = 0;
    L69:
        if (r130 >= r129) goto L79;
        Field r131 = r128[r130];
        NewBroadcastMonitor.GROUP r132 = (NewBroadcastMonitor.GROUP) r131.getAnnotation(NewBroadcastMonitor.GROUP.class);
        if (r132 == null) goto L78;
        Object r133 = r131.get(NewBroadcastMonitor.SERVICE.Companion);
        if ((r133 instanceof String) == true) goto L75;
        r133 = null;
    L75:
        String r134 = (String) r133;
        if (r134 == null) goto L78;
        NewBroadcastMonitor.f64925j.put(r134, r132.group());
    L78:
        r130 = r130 + 1;
    L79:
        String r135 = new SimpleDateFormat("SSSssmmHHddMMyyyy", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(null) == false) goto L82;
        String r136 = r135 + ((int) (new Random().nextDouble() * ((double) 1000000000)));
    L83:
        NewBroadcastMonitor.f64918c = r136;
        NewBroadcastMonitor.f(NewBroadcastMonitor.SERVICE.SERVICE_START_TRACE);
        goto L84
    L82:
        r136 = r135 + "";
        goto L83
    L27:
        if (r111.getBoolean("extra_start_live_multi_process_restart") != true) goto L31;
        if (vh.f121449a.getValue().booleanValue() == false) goto L31;
        Room r137 = ((IBroadcastService) k.n(IBroadcastService.class)).getRestartContinueRoom();
        IRoomService r138 = (IRoomService) k.n(IRoomService.class);
        r138.setCurrentRoom(r137);
        r138.setStreamerRoom(r137);
        goto L31
    L21:
        if (r111.getBoolean("extra_start_live_restart") != true) goto L25;
        if (vh.f121449a.getValue().booleanValue() == false) goto L25;
        Room r139 = ((IBroadcastService) k.n(IBroadcastService.class)).getRestartContinueRoom();
        IRoomService r140 = (IRoomService) k.n(IRoomService.class);
        r140.setCurrentRoom(r139);
        r140.setStreamerRoom(r139);
        goto L25
    L5:
        if (r111 == null) goto L15;
        Long r141 = Long.valueOf(r111.getLong("duration"));
        if (r141.longValue() <= 0) goto L9;
        boolean r142 = true;
    L10:
        if (r142 == true) goto L13;
        r141 = null;
    L13:
        if (r141 == null) goto L15;
        long r143 = r141.longValue();
    L16:
        if (r111 == null) goto L18;
        r111.putLong("duration", r143);
        goto L18
    L9:
        r142 = false;
    L15:
        r143 = System.currentTimeMillis();
        goto L16
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService
    public Fragment createLiveSubBroadcastFragment(ILiveBroadcastCallback r100, Bundle r101) {
        int r102 = LiveSubBroadcastShellFragment.f105256t;
        Bundle r103 = new Bundle();
        r103.putBundle("extra", r101);
        LiveSubBroadcastShellFragment r104 = new LiveSubBroadcastShellFragment();
        r104.setArguments(r103);
        r104.f105259f = r100;
        return r104;
    }
}
