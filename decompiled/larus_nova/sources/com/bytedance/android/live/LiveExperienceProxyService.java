package com.bytedance.android.live;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import ca0.o;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.util.AudienceInflateUtil;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J*\u0010\u001d\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0002H\u0016JH\u0010/\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¨\u00062"}, d2 = {"Lcom/bytedance/android/live/LiveExperienceProxyService;", "Lcom/bytedance/android/live/room/api/ILiveExperienceProxyService;", "", "rankType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "", "showUserDialog", "", "pcu", "", "roomId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "anchor", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "Lcom/bytedance/android/live/core/tetris/task/a;", "widgetLoadTask", "Landroid/view/View;", "contentView", "scheduleP0WidgetLoadTask", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lw71/c;", "listener", "requestRankBackend", "", "", "data", "collectReportTask", "statusHeight", "repotTopSpaceHeight", "logTag", "resId", "nitaTag", "Landroid/app/Activity;", "activity", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "", LynxViewpagerItem.BIND_ON_ATTACH, "Landroid/view/LayoutInflater;", "fallbackInflater", "tryNitaInflate", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveExperienceProxyService implements ILiveExperienceProxyService {
    public LiveExperienceProxyService() {
    }

    @Override // com.bytedance.android.live.room.api.ILiveExperienceProxyService
    public void collectReportTask(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.DRESS_SHOW, r100, null);
    }

    @Override // com.bytedance.android.live.room.api.ILiveExperienceProxyService
    public void repotTopSpaceHeight(int r100) {
        ALogger.d("LiveTopSpaceHeightCheck", "statusHeight=" + r100);
        if (r100 != 0) goto L7;
        if (g81.j.f480377a.getValue().a() == false) goto L7;
    L8:
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("status_height", String.valueOf(r100));
        j0.l().f("livesdk_top_space_height", r101, new Object[]{IRoom.class, x.class});
        return;
    L7:
        if (g81.j.f480377a.getValue().b() == true) goto L8;
    }

    @Override // com.bytedance.android.live.room.api.ILiveExperienceProxyService
    public void scheduleP0WidgetLoadTask(DataContext r100, final com.bytedance.android.live.core.tetris.task.a r101, final View r102) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        Intrinsics.checkNotNullParameter(r101, "widgetLoadTask");
        Intrinsics.checkNotNullParameter(r102, "contentView");
        if ((r100 instanceof RoomContext) == true) goto L5;
        r100 = null;
    L5:
        RoomContext r103 = (RoomContext) r100;
        if (r103 == null) goto L11;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.widget.schedule.c> r104 = r103.getWidgetLoadTaskScheduler();
        if (r104 == null) goto L12;
        r104.c(new C98721(r101, r102));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.room.api.ILiveExperienceProxyService
    public void requestRankBackend(DataContext r110, final long r111, LifecycleOwner r210, final w71.c r211) {
        Intrinsics.checkNotNullParameter(r210, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r211, "listener");
        DataContext r100 = r110;
        Boolean r101 = null;
        if ((r100 instanceof RoomContext) == true) goto L5;
        r100 = null;
    L5:
        final RoomContext r112 = (RoomContext) r100;
        if (r112 == null) goto L33;
        n<Boolean> r102 = r112.getHasRankBackendRequest();
        if (r102 == null) goto L10;
        Boolean r103 = r102.getValue();
    L11:
        Boolean r113 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r103, r113)) == false) goto L29;
        n<Boolean> r104 = r112.getHasRankShown();
        if (r104 == null) goto L17;
        r101 = r104.getValue();
    L17:
        if ((!Intrinsics.areEqual(r101, r113)) == false) goto L29;
        ALogger.d("LiveExperienceProxyService", "requestRankBackend, roomId = " + r111);
        IRoomModuleService r105 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r105 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.room.backend.g r106 = r105.getLiveRoomBackendUtils();
        if (r106 == null) goto L29;
        Function3<lk, BackendGeneratedData, BackendItem, Unit> r107 = new AnonymousClass1(r111, r112, r211);
        Function0<Unit> r108 = new AnonymousClass2(r111);
        a50.a r109 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r109 != null) goto L25;
    L27:
        boolean r114 = false;
    L28:
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r106, r111, r112, lk.class, r108, null, r107, null, r210, null, r114, false, 3152);
        goto L29
    L25:
        if (r109.j() != true) goto L27;
        r114 = true;
    L29:
        n<Boolean> r115 = r112.getHasRankBackendRequest();
        if (r115 == null) goto L34;
        r115.setValue(r113);
        return;
    L34:
        return;
    L10:
        r103 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.room.api.ILiveExperienceProxyService
    public void showUserDialog(int r110, Context r111, DataCenter r112, IRoom r113) {
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "dataCenter");
        Intrinsics.checkNotNullParameter(r113, "room");
        long r100 = System.currentTimeMillis();
        IKtvService r101 = (IKtvService) k.f(IKtvService.class);
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.isInKtvState(8));
    L6:
        HashMap r103 = new HashMap();
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L9;
        r103.put("live_type", "voice_live");
        r103.put("function_type", "ktv");
    L9:
        b91.a.a(r103);
        IGiftServiceExternal r104 = (IGiftServiceExternal) k.f(IGiftServiceExternal.class);
        if (r104 == null) goto L14;
        o r105 = r104.getRevenueEventCenter();
        if (r105 == null) goto L14;
        r105.d();
    L14:
        int r106 = 0;
        Integer r114 = (Integer) r112.get("data_member_count", 0);
        if (r114 == null) goto L17;
        r106 = r114.intValue();
    L17:
        av0.a r107 = yt0.c.j();
        if (r107 == null) goto L21;
        av0.a.C0235a.a(r107, r111, r110, r113, String.valueOf(r106), r100, C98732.INSTANCE);
        return;
    L21:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.ILiveExperienceProxyService
    public void showUserDialog(int r100, Context r101, String r110, long r111, IBaseUser r112) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "pcu");
        Intrinsics.checkNotNullParameter(r112, "anchor");
        System.currentTimeMillis();
        int r102 = b91.a.f18244a;
        b91.a.a(new LinkedHashMap());
        av0.a r103 = yt0.c.j();
        if (r103 == null) goto L6;
        AnonymousClass3 r104 = AnonymousClass3.INSTANCE;
        r103.U5(r101, r111, r112, r110, null);
        return;
    }

    @Override // com.bytedance.android.live.room.api.ILiveExperienceProxyService
    public View tryNitaInflate(String r100, int r101, String r102, Activity r103, ViewGroup r104, boolean r105, LayoutInflater r106) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        Intrinsics.checkNotNullParameter(r102, "nitaTag");
        if (r103 != null) goto L7;
        return null;
    L7:
        return AudienceInflateUtil.b(r100, r101, r102, r103, r104, r105, r106);
    }
}
