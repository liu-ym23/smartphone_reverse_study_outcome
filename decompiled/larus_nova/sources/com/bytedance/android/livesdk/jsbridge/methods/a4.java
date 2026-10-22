package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.SetAdminPermissionResultResultModel;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.roommanage.AnchorManageAdminDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import w20.e6;
import w20.le;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "set_admin_permission_result")
public final class a4 extends e6<le, SetAdminPermissionResultResultModel> {
    public a4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        le r102 = (le) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        DataContext r103 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(AnchorManageAdminDataContext.class));
        if ((r103 instanceof AnchorManageAdminDataContext) == true) goto L5;
        r103 = null;
    L5:
        AnchorManageAdminDataContext r104 = (AnchorManageAdminDataContext) r103;
        if (r104 == null) goto L34;
        td1.d r105 = r104.getAdminUserOperating().getValue();
        if (r105 == null) goto L33;
        Integer r106 = r102.b();
        if (r106 != null) goto L14;
    L15:
        List<Integer> r107 = r105.adminPrivileges;
        String r108 = r102.a();
        if (r108 == null) goto L18;
        int r109 = CastIntegerProtector.parseInt(r108);
    L19:
        r107.remove(Integer.valueOf(r109));
    L31:
        com.bytedance.live.datacontext.m<List<LiveRoomPermission>> r110 = r104.getAdminUserOperatingPermissions();
        LiveRoomPermission.Companion r111 = LiveRoomPermission.D;
        List<Integer> r112 = r105.adminPrivileges;
        r111.getClass();
        r110.setValue(LiveRoomPermission.Companion.b(r112, -1));
        return;
    L18:
        r109 = -1;
        goto L19
    L14:
        if (r106.intValue() != 1) goto L15;
        List<Integer> r113 = r105.adminPrivileges;
        String r114 = r102.a();
        if (r114 == null) goto L23;
        int r115 = CastIntegerProtector.parseInt(r114);
    L25:
        if (r113.contains(Integer.valueOf(r115)) == true) goto L31;
        List<Integer> r116 = r105.adminPrivileges;
        String r117 = r102.a();
        if (r117 == null) goto L29;
        int r118 = CastIntegerProtector.parseInt(r117);
    L30:
        r116.add(Integer.valueOf(r118));
        goto L31
    L29:
        r118 = -1;
        goto L30
    L23:
        r115 = -1;
        goto L25
    L33:
        return;
    }
}
