package com.bytedance.android.livesdk.chatroom.room;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class SchemaStreamRequestManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f110628k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f110629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f110630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f110631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f110632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public State f110633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f110634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f110635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f110636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f110637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f110638j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/room/SchemaStreamRequestManager$State;", "", "InActive", "Fetching", "Done", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Done = null;
        public static final State Fetching = null;
        public static final State InActive = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f110639a = null;

        static {
            State r100 = new State("InActive", 0);
            InActive = r100;
            State r101 = new State("Fetching", 1);
            Fetching = r101;
            State r102 = new State("Done", 2);
            Done = r102;
            f110639a = new State[]{r100, r101, r102};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f110639a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void onSuccess(String r100, String r101);
    }

    public static final class b {
    }

    static {
        f110628k = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SchemaStreamRequestManager$Companion$INSTANCE$2.INSTANCE);
    }

    public final void d() {
        this.f110633e = State.InActive;
        Disposable r100 = this.f110629a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f110629a = null;
        this.f110631c = null;
        this.f110632d = null;
        this.f110630b = 0;
        this.f110634f = 0;
        this.f110636h = -1;
        this.f110635g = null;
    }

    public SchemaStreamRequestManager() {
        this.f110633e = State.InActive;
        this.f110636h = -1;
        this.f110637i = LazyKt.lazy(SchemaStreamRequestManager$enable$2.INSTANCE);
        this.f110638j = LazyKt.lazy(SchemaStreamRequestManager$enableOptV2$2.INSTANCE);
    }

    public static void a(String r100) {
        ALogger.i("SchemaStreamRequestManager", r100);
    }

    public final void c(long r100, Bundle r101, Room r102) {
        Intrinsics.checkNotNullParameter(r101, "bundle");
        d();
        if (((Boolean) this.f110637i.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r100 <= 0) goto L42;
        int r103 = r101.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        if (r103 != 15) goto L10;
        return;
    L10:
        if (r103 != 17) goto L12;
        return;
    L12:
        if (r103 != 16) goto L14;
        return;
    L14:
        if (r103 == 23) goto L43;
        this.f110630b = r100;
        a("start fetch, roomId = " + r100);
        this.f110634f = System.currentTimeMillis();
        Disposable r104 = null;
        if (((Boolean) this.f110638j.getValue()).booleanValue() == false) goto L25;
        if (r102 == null) goto L25;
        String r105 = r102.getCompoundStreamData();
        if (r105 != null) goto L22;
        r105 = null;
    L22:
        if (r105 == null) goto L25;
        b(this, r100, r101, r102);
        return;
    L25:
        this.f110633e = State.Fetching;
        com.bytedance.android.livesdk.service.l.d().getClass();
        com.bytedance.android.live.network.c r106 = com.bytedance.android.live.network.c.b();
        if (r106 == null) goto L36;
        RoomRetrofitApi r107 = (RoomRetrofitApi) r106.e(RoomRetrofitApi.class);
        if (r107 == null) goto L36;
        Observable<Response<Room>> r108 = r107.getRoomInfoByScene(r100, "vs_schema_preview");
        if (r108 == null) goto L36;
        Observable<Response<Room>> r109 = r108.subscribeOn(Schedulers.io());
        if (r109 == null) goto L36;
        Observable<Response<Room>> r110 = r109.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L36;
        r104 = r110.subscribe(new y0(this, r100, r101), new z0(this));
    L36:
        this.f110629a = r104;
        return;
    L43:
        return;
    }

    public static void b(SchemaStreamRequestManager r100, long r101, Bundle r110, Room r111) {
        r100.getClass();
        String r102 = r111.getCompoundStreamData();
        String r103 = ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r111, false, false, 6, null);
        if (r102 != null) goto L5;
        r100.d();
        return;
    L5:
        as0.a r104 = LivePlatformPlayerManager.b();
        if (r104 != null) goto L8;
    L20:
        IPullStreamService r105 = (IPullStreamService) jc1.k.f(IPullStreamService.class);
        if (r105 == null) goto L29;
        gl0.c r106 = r105.getLivePlayerOptimizer();
        if (r106 == null) goto L29;
        long r107 = r111.getRoomId();
        StreamUrl r108 = r111.getStreamUrl();
        if (r108 == null) goto L27;
        Intrinsics.checkNotNullParameter(r110, "$this$putPullOriginStreamUrl");
        Intrinsics.checkNotNullParameter(r108, "data");
        yt2.a.f(r110, r108);
    L27:
        r110.putString(ILiveRoomPlayFragmentConstant.EXTRA_PULL_SDK_PARAMS, r111.getSdkParams());
        Intrinsics.checkNotNullParameter(r110, "$this$putPullStreamData");
        Intrinsics.checkNotNullParameter(r102, "data");
        yt2.a.g(r110, ILiveRoomPlayFragmentConstant.EXTRA_PULL_STREAM_DATA, r102);
        r110.putString(ILiveRoomPlayFragmentConstant.EXTRA_PULL_DEFAULT_RESOLUTION, r103);
        Unit r109 = Unit.INSTANCE;
        ((com.bytedance.android.live.livepullstream.service.c) r106).c(r107, r110);
    L29:
        if (r110.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PRE_PULL_STREAM, false) == false) goto L34;
        r100.f110631c = r102;
        r100.f110632d = r103;
        r100.f110633e = State.Done;
        a("trigger pre pull cost = " + (System.currentTimeMillis() - r100.f110634f));
        a r112 = r100.f110635g;
        if (r112 == null) goto L33;
        r112.onSuccess(r102, r103);
    L33:
        a("call success done = " + (System.currentTimeMillis() - r100.f110634f));
        return;
    L34:
        r100.d();
        return;
    L8:
        if (r104.roomId() != r101) goto L20;
        ILivePlayerClient r113 = r104.player();
        if (r113 == null) goto L16;
        IRoomEventHub r114 = r113.getEventHub();
        if (r114 == null) goto L16;
        MutableLiveData<Boolean> r115 = r114.getStartPullStream();
        if (r115 == null) goto L16;
        Boolean r116 = r115.getValue();
    L18:
        if (Intrinsics.areEqual(r116, Boolean.TRUE) == false) goto L20;
        a("skip already pull");
        return;
    L16:
        r116 = null;
        goto L18
    }
}
