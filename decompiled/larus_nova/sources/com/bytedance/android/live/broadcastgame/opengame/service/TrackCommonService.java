package com.bytedance.android.live.broadcastgame.opengame.service;

import am2.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/TrackCommonService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TrackCommonService implements y10.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f60983d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f60984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PluginContext f60986c;

    public static final class a {
    }

    static {
    }

    @Override // y10.a
    public final void g() {
    }

    public final void c() {
        com.bytedance.android.livesdk.log.g r100 = u.l();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll((Map) this.f60985b.getValue());
        r101.put("duration", String.valueOf(System.currentTimeMillis() - this.f60984a));
        a(r101);
        Unit r102 = Unit.INSTANCE;
        r100.sendLog("livesdk_small_program_duration", r101, new Object[]{Room.class});
    }

    public final void d() {
        com.bytedance.android.livesdk.log.g r100 = u.l();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll((Map) this.f60985b.getValue());
        a(r101);
        Unit r102 = Unit.INSTANCE;
        r100.sendLog("livesdk_live_small_program_end", r101, new Object[]{Room.class});
    }

    public final void e() {
        com.bytedance.android.livesdk.log.g r100 = u.l();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll((Map) this.f60985b.getValue());
        a(r101);
        Unit r102 = Unit.INSTANCE;
        r100.sendLog("livesdk_live_small_program_start", r101, new Object[]{Room.class});
    }

    public PluginContext b() {
        return this.f60986c;
    }

    public TrackCommonService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        this.f60986c = r100;
        this.f60985b = LazyKt.lazy(new TrackCommonService$commonParams$2(this));
    }

    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (b().f60811o == false) goto L5;
        String r101 = "anchor";
    L6:
        r100.put("user_type", r101);
        String r102 = ((IUserService) k.n(IUserService.class)).user().b().getIdString();
        if (b().f60811o == false) goto L9;
        r100.put("anchor_id", r102);
        return;
    L9:
        r100.put("user_id", r102);
        String[] r103 = {"enter_from_merge", "enter_method"};
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r103, "keys");
        o r104 = u.l().c(x.class);
        if (r104 == null) goto L22;
        n0 r105 = (n0) r104;
        int r106 = 0;
    L13:
        if (r106 >= 2) goto L27;
        String r107 = r103[r106];
        if (r105.f153291b.containsKey(r107) == false) goto L19;
        String r108 = r105.f153291b.get(r107);
        if (r108 == null) goto L19;
        r100.put(r107, r108);
    L19:
        r106 = r106 + 1;
        goto L13
    L27:
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.log.filter.PageSourceFilter");
    L5:
        r101 = "user";
        goto L6
    }
}
