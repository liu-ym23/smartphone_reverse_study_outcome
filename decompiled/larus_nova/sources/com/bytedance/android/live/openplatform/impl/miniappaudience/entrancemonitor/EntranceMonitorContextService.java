package com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.m;
import com.larus.platform.model.upload.ResourceUploadError;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/entrancemonitor/EntranceMonitorContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceMonitorContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f84787c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<EntranceType, ShowEntranceTask> f84788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f84789b;

    public static final class a {
    }

    public static final class b implements ShowEntranceTask.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EntranceMonitorContextService f84790a;

        public b(EntranceMonitorContextService r100) {
            this.f84790a = r100;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void c(String r100, EntranceType r110, EntranceSource r111) {
            Intrinsics.checkNotNullParameter(r100, "mpId");
            Intrinsics.checkNotNullParameter(r110, "entranceType");
            Intrinsics.checkNotNullParameter(r111, "entranceSource");
            EntranceMonitorContextService.h(this.f84790a, r100, r110, r111, ShowEntranceTask.Stage.Begin, 0);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void b(String r100, EntranceType r110, EntranceSource r111, long r112) {
            Intrinsics.checkNotNullParameter(r100, "mpId");
            Intrinsics.checkNotNullParameter(r110, "entranceType");
            Intrinsics.checkNotNullParameter(r111, "entranceSource");
            EntranceMonitorContextService.h(this.f84790a, r100, r110, r111, ShowEntranceTask.Stage.Success, r112);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void d(String r100, EntranceType r110, EntranceSource r111, long r112, String r113) {
            Intrinsics.checkNotNullParameter(r100, "mpId");
            Intrinsics.checkNotNullParameter(r110, "entranceType");
            Intrinsics.checkNotNullParameter(r111, "entranceSource");
            Intrinsics.checkNotNullParameter(r113, "stageDesc");
            EntranceMonitorContextService r101 = this.f84790a;
            ShowEntranceTask.Stage r102 = ShowEntranceTask.Stage.Running;
            int r103 = EntranceMonitorContextService.f84787c;
            r101.getClass();
            EntranceMonitorContextService.g(r100, r110, r111, r102, r112, r113, null);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void a(String r110, EntranceType r111, EntranceSource r112, long r113, String r114, JSONObject r115) {
            Intrinsics.checkNotNullParameter(r110, "mpId");
            Intrinsics.checkNotNullParameter(r111, "entranceType");
            Intrinsics.checkNotNullParameter(r112, "entranceSource");
            Intrinsics.checkNotNullParameter(r114, "stageDesc");
            EntranceMonitorContextService r100 = this.f84790a;
            ShowEntranceTask.Stage r101 = ShowEntranceTask.Stage.Fail;
            int r102 = EntranceMonitorContextService.f84787c;
            r100.getClass();
            EntranceMonitorContextService.g(r110, r111, r112, r101, r113, r114, r115);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        Iterator r100 = ((LinkedHashMap) this.f84788a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        ShowEntranceTask r101 = (ShowEntranceTask) ((Map.Entry) r100.next()).getValue();
        ShowEntranceTask.d r102 = r101.f84796d.b();
        if (Intrinsics.areEqual(r102, ShowEntranceTask.d.a.f84811a) == false) goto L9;
        r101.a(ResourceUploadError.CANCELED, null);
    L11:
        StateMachine<ShowEntranceTask.d, ShowEntranceTask.a, ShowEntranceTask.c> r103 = r101.f84796d;
        ShowEntranceTask.a.c r104 = ShowEntranceTask.a.c.f84803a;
        StateMachine.a r105 = StateMachine.f66079c;
        r103.d(r104, null);
        goto L4
    L9:
        if (Intrinsics.areEqual(r102, ShowEntranceTask.d.C1292d.f84814a) == false) goto L11;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r101.a(String.format("request %s canceled", Arrays.copyOf(new Object[]{"shelf/info"}, 1)), null);
        goto L11
    L12:
        ((LinkedHashMap) this.f84788a).clear();
    }

    public EntranceMonitorContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f84788a = new LinkedHashMap();
        this.f84789b = new b(this);
    }

    public final ShowEntranceTask f(EntranceType r100) {
        Intrinsics.checkNotNullParameter(r100, "entranceType");
        LinkedHashMap r101 = (LinkedHashMap) this.f84788a;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new ShowEntranceTask(r100, this.f84789b);
        r101.put(r100, r102);
    L6:
        return (ShowEntranceTask) r102;
    }

    public static /* synthetic */ void h(EntranceMonitorContextService r100, String r101, EntranceType r110, EntranceSource r111, ShowEntranceTask.Stage r112, long r113) {
        r100.getClass();
        g(r101, r110, r111, r112, r113, "", null);
    }

    public static void g(String r100, EntranceType r101, EntranceSource r102, ShowEntranceTask.Stage r103, long r104, String r105, JSONObject r110) {
        g r106 = u.l();
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put(BdpAppEventConstant.PARAMS_MP_ID, r100);
        r107.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r101.getValue());
        r107.put("entrance_source", r102.getValue());
        r107.put("stage", r103.getValue());
        r107.put("duration", String.valueOf(r104));
        r107.put("stage_desc", r105);
        String r108 = "";
        if (r110 == null) goto L6;
        String r109 = r110.toString();
        if (r109 == null) goto L6;
    L7:
        r107.put("stage_extra", r109);
        RoomContext r111 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r111 == null) goto L17;
        m<Room> r112 = r111.getRoom();
        if (r112 == null) goto L17;
        Room r113 = r112.getValue();
        if (r113 == null) goto L17;
        String r114 = String.valueOf(r113.appId);
        if (r114 == null) goto L17;
        r108 = r114;
    L17:
        r107.put("anchor_app_id", r108);
        Unit r115 = Unit.INSTANCE;
        r106.sendLog("livesdk_microapp_entrance_monitor", r107, new Object[]{Room.class});
        return;
    L6:
        r109 = "";
        goto L7
    }
}
