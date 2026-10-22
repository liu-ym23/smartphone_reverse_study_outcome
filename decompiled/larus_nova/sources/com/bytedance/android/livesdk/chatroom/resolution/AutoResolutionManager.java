package com.bytedance.android.livesdk.chatroom.resolution;

import am2.x;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.chatroom.resolution.newresolution.processor.InnerResolutionProcessor;
import com.bytedance.android.livesdk.chatroom.resolution.smoothswitch.ISmoothResolutionService;
import com.bytedance.android.livesdk.chatroom.ui.l5;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/resolution/AutoResolutionManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoResolutionManager implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<DataCenter> f110456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f110457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f110458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveCoreSDKData.Quality f110459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f110460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f110461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f110462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f110463h;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoResolutionManager f110464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IRoomEventHub f110465b;

        public b(AutoResolutionManager r100, IRoomEventHub r101) {
            this.f110464a = r100;
            this.f110465b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            ALogger.d("AutoResolutionManager", "smoothSwitchResolutionError=" + r101);
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.intValue() >= 0) goto L10;
            AutoResolutionManager.a(this.f110464a, r101.intValue());
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoResolutionManager f110466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IRoomEventHub f110467b;

        public c(AutoResolutionManager r100, IRoomEventHub r101) {
            this.f110466a = r100;
            this.f110467b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            ALogger.d("AutoResolutionManager", "abrSwitch=" + r101);
            if (r101 == null) goto L7;
            AutoResolutionManager.a(this.f110466a, r101.intValue());
            return;
        }
    }

    static {
    }

    public static Map c() {
        IStrategyService r100 = (IStrategyService) k.f(IStrategyService.class);
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        LiveData r103 = IStrategyService.a.a(r100, "oritation_video_resolution", MapsKt.emptyMap(), false, 12);     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        Map r104 = (Map) r103.getValue();     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == true) goto L18;
        r101 = r105;
    L18:
        return (Map) r101;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static int d() {
        boolean r100 = true;
        if (AudienceVideoResolutionManager.f110432v == 1) goto L5;
    L8:
        if (r100 == false) goto L13;
        ILivePlayerClient r101 = LivePlatformPlayerManager.f();
        if (r101 != null) goto L12;
        return 0;
    L12:
        return r101.getAutoResolutionState();
    L13:
        return 0;
    L5:
        if (AudienceVideoResolutionManager.f110412b.size() > 1) goto L8;
        r100 = false;
        goto L8
    }

    public static boolean e() {
        IStrategyService r100 = (IStrategyService) k.f(IStrategyService.class);
        if (r100 == null) goto L9;
        LiveData r101 = IStrategyService.a.a(r100, "resolution_menu_auto_show", 0, false, 12);
        if (r101 == null) goto L9;
        Integer r102 = (Integer) r101.getValue();
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        if (r103 > 0) goto L16;
        Map r104 = c();
        if (r104 == null) goto L14;
        int r105 = r104.size();
    L15:
        if (r105 > 0) goto L16;
        return false;
    L14:
        r105 = 0;
    L16:
        return true;
    L9:
        r103 = 0;
        goto L10
    }

    public final Boolean g() {
        WeakReference<DataCenter> r100 = this.f110456a;
        Room r101 = null;
        if (r100 == null) goto L5;
        DataCenter r102 = r100.get();
    L6:
        if (r102 == null) goto L8;
        r101 = (Room) r102.get("data_room", null);
    L8:
        if (r101 == null) goto L14;
        boolean r103 = true;
        if (r101.isCompoundScene() != true) goto L14;
        if (r101.getCompoundSceneType() != 2) goto L14;
    L16:
        return Boolean.valueOf(r103);
    L14:
        r103 = false;
        goto L16
    L5:
        r102 = null;
        goto L6
    }

    public final void h() {
        WeakReference<DataCenter> r100 = this.f110456a;
        LifecycleOwner r101 = null;
        if (r100 == null) goto L5;
        DataCenter r102 = r100.get();
    L6:
        if (r102 == null) goto L8;
        r102.observe("cmd_screen_orientation_change", this);
    L8:
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        if (r103 == null) goto L11;
        IRoomEventHub r104 = r103.getEventHub();
    L12:
        ILivePlayerClient r105 = LivePlatformPlayerManager.f();
        if (r105 == null) goto L15;
        r101 = r105.getLifecycleOwner();
    L15:
        if (r101 == null) goto L25;
        if (r104 == null) goto L20;
        MutableLiveData<Integer> r106 = r104.getSmoothSwitchResolutionError();
        if (r106 == null) goto L20;
        r106.observe(r101, new b(this, r104));
    L20:
        if (r104 == null) goto L26;
        MutableLiveData<Integer> r107 = r104.getAbrSwitch();
        if (r107 == null) goto L27;
        r107.observe(r101, new c(this, r104));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public AutoResolutionManager() {
        this.f110457b = 1;
        this.f110458c = LazyKt.lazy(AutoResolutionManager$lastPlayResolutionKey$2.INSTANCE);
        LiveCoreSDKData.Quality r100 = new LiveCoreSDKData.Quality();
        r100.setName(PlayerResolution.NAME.AUTO);
        r100.sdkKey = "liveAuto";
        r100.disable = 0;
        r100.setLevel(98);
        this.f110459d = r100;
        this.f110460e = MapsKt.mapOf(new Pair[]{TuplesKt.to(PlayerResolution.SDKKEY.LD, PlayerResolution.NAME.LD), TuplesKt.to(PlayerResolution.SDKKEY.SD, PlayerResolution.NAME.SD), TuplesKt.to(PlayerResolution.SDKKEY.HD, PlayerResolution.NAME.HD), TuplesKt.to(PlayerResolution.SDKKEY.UHD, PlayerResolution.NAME.UHD)});
        this.f110462g = "";
        this.f110463h = "";
    }

    public static String f() {
        ILivePlayerClient r100 = LivePlatformPlayerManager.f();
        if (r100 == null) goto L5;
        String r101 = r100.getCurrentResolution();
    L6:
        ALogger.i("AutoResolutionManager", "CurrAutoResolution is " + r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public static void l(List r100) {
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L31;
        l5 r103 = (l5) r102.next();
        if (Intrinsics.areEqual(r103.f113656b, PlayerResolution.NAME.AUTO) == false) goto L8;
    L13:
        LiveCoreSDKData.Quality r104 = null;
        if (v.a() == false) goto L20;
        StringBuilder r105 = new StringBuilder("(");
        ILivePlayerClient r106 = LivePlatformPlayerManager.f();
        if (r106 == null) goto L18;
        String r107 = r106.getCurrentResolution();
    L19:
        r105.append(r107);
        r105.append(')');
        String r108 = r105.toString();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r103.f113657c = r108;
        goto L20
    L18:
        r107 = null;
    L20:
        Iterator<LiveCoreSDKData.Quality> r109 = AudienceVideoResolutionManager.f110412b.iterator();
    L22:
        if (r109.hasNext() == false) goto L26;
        LiveCoreSDKData.Quality r110 = r109.next();
        if (Intrinsics.areEqual(r110.sdkKey, f()) == false) goto L22;
        r104 = r110;
    L26:
        LiveCoreSDKData.Quality r111 = r104;
        if (r111 == null) goto L29;
        String r112 = r111.getName();
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r103.f113665k = r112;
    L29:
        ALogger.i("AutoResolutionManager", "CurrAutoResolution when selectAutoInResolutionList() is " + f());
        Intrinsics.checkNotNullParameter("selected", "<set-?>");
        r103.f113659e = "selected";
    L30:
        r101.add(Unit.INSTANCE);
        goto L4
    L8:
        if (Intrinsics.areEqual(r103.f113661g, "auto") == true) goto L13;
        if (Intrinsics.areEqual(r103.f113659e, "selected") == false) goto L30;
        Intrinsics.checkNotNullParameter("unselected", "<set-?>");
        r103.f113659e = "unselected";
        goto L30
    }

    public final void k(int r100) {
        if (Intrinsics.areEqual(g(), Boolean.TRUE) == false) goto L7;
        Map r101 = c();
        if (r101 == null) goto L17;
        b(j(r101, "default"), j(r101, "translate"), r100);
    L17:
        ALogger.d("AutoResolutionManager", "getAutoConfig=" + c());
        return;
    L7:
        int r102 = this.f110457b;
        if (r102 != 1) goto L13;
        Map r103 = c();
        if (r103 == null) goto L17;
        b(j(r103, "portrait"), j(r103, "translate"), r100);
        goto L17
    L13:
        if (r102 != 2) goto L17;
        Map r104 = c();
        if (r104 == null) goto L17;
        b(j(r104, "horizontal"), j(r104, "translate"), r100);
        goto L17
    }

    public final void n(int r110) {
        if (e() == true) goto L7;
        ALogger.d("AutoResolutionManager", "switchAutoMode,auto not on");
        return;
    L7:
        if (r110 == 0) goto L26;
        WeakReference<DataCenter> r100 = this.f110456a;
        if (r100 == null) goto L12;
        DataCenter r101 = r100.get();
    L13:
        if (r101 == null) goto L15;
        Room r102 = (Room) r101.get("data_room", null);
    L16:
        if (r102 == null) goto L20;
        StreamUrl r103 = r102.getStreamUrl();
        if (r103 == null) goto L20;
        Boolean r104 = Boolean.valueOf(r103.getVPassDefault());
    L22:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L24;
        int r105 = 2;
    L27:
        int r106 = d();
        if (r106 == r105) goto L30;
        boolean r107 = true;
    L31:
        ALogger.d("AutoResolutionManager", "switchAutoMode, old auto mode is " + r106 + ", new auto mode is " + r105 + ", so auto mode changed: " + r107);
        ILivePlayerClient r108 = LivePlatformPlayerManager.f();
        if (r108 == null) goto L34;
        r108.setAutoResolutionState(r105);
    L34:
        if (r110 <= 0) goto L44;
        WeakReference<DataCenter> r109 = this.f110456a;
        if (r109 == null) goto L38;
        DataCenter r111 = r109.get();
    L39:
        if (r111 == null) goto L41;
        r111.put("cmd_switch_resolution_success", 0);
    L41:
        ((Property) InnerResolutionProcessor.f110486a.getValue()).setValue(null);
        ((Property) InnerResolutionProcessor.f110488c.getValue()).setValue(null);
        ((Property) InnerResolutionProcessor.f110489d.getValue()).setValue(null);
        ((Property) InnerResolutionProcessor.f110490e.getValue()).setValue(null);
        ((Property) InnerResolutionProcessor.f110491f.getValue()).setValue(null);
        k(1);
        if (r107 == false) goto L44;
        f2.c("成功切换至自动", 0);
        goto L44
    L38:
        r111 = null;
    L44:
        ALogger.d("AutoResolutionManager", "switchAutoMode=" + r110);
        return;
    L30:
        r107 = false;
        goto L31
    L24:
        if (r110 != 1) goto L26;
        r105 = 1;
    L20:
        r104 = null;
        goto L22
    L15:
        r102 = null;
        goto L16
    L12:
        r101 = null;
    L26:
        r105 = 0;
        goto L27
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L23;
        String r102 = r101.getKey();
        if (r102.hashCode() == 1815334125) goto L11;
        return;
    L11:
        if (r102.equals("cmd_screen_orientation_change") == false) goto L22;
        Integer r103 = (Integer) r101.getData();
        if (r103 != null) goto L15;
        r103 = 0;
    L15:
        int r104 = r103.intValue();
        ALogger.d("AutoResolutionManager", "CMD_SCREEN_ORIENTTION_CHANGE_PHONE=" + r104);
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L19;
        return;
    L19:
        this.f110457b = r104;
        k(2);
        return;
    L22:
        return;
    }

    public static final void a(AutoResolutionManager r100, int r101) {
        if (r100.f110461f == false) goto L7;
        r100.f110461f = false;
        HashMap r102 = new HashMap();
        r102.put("errorcode", String.valueOf(r101));
        r102.put("oritation", "horizontal");
        r102.put("is_auto", "1");
        r102.put("auto_type", "1");
        r102.put("before_resolution", r100.f110462g);
        r102.put("current_resolution", r100.f110463h);
        u.l().f("livesdk_live_switch_resolution_cost", r102, new Object[]{Room.class, x.class});
        return;
    }

    public static void i(Long r100, int r101) {
        if (r100 == null) goto L15;
        r100.longValue();
        if (e() == true) goto L7;
        ALogger.d("AutoResolutionManager", "auto not enable in room=" + r100);
        return;
    L7:
        ILivePlayerClient r102 = LivePlatformPlayerManager.a(r100.longValue(), false);
        if (r102 != null) goto L10;
        r102 = (ILivePlayerClient) CollectionsKt.getOrNull(is0.c.c().getPreviewClientListWithIdentifier(String.valueOf(r100.longValue())), 0);
    L10:
        if (r102 != null) goto L12;
        ALogger.e("AutoResolutionManager", "initSelectAutoResolution, playerClient=null");
    L12:
        if (r102 == null) goto L16;
        r102.setAutoResolutionState(r101);
        return;
    L16:
        return;
    }

    public static String j(Map r100, String r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.containsKey(r101) == false) goto L14;
        Object r102 = r100.get(r101);
        if ((r102 instanceof String) == true) goto L10;
        r102 = null;
    L10:
        String r103 = (String) r102;
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L14:
        return "";
    }

    public static void m(Long r100, PlayerResolution.PickResult r101) {
        if (r101 != null) goto L6;
        boolean r102 = false;
    L16:
        if (r102 == false) goto L18;
        i(r100, 1);
        return;
    L18:
        i(r100, 0);
        return;
    L6:
        if (Intrinsics.areEqual(r101.getPickStrategy(), "1") == false) goto L9;
    L14:
        r102 = false;
    L15:
        ALogger.d("AutoResolutionManager", "checkInitSelectAuto=" + r102);
        goto L16
    L9:
        if (Intrinsics.areEqual(r101.getPickStrategy(), "2") == true) goto L14;
        if (e() == false) goto L14;
        ALogger.d("AutoResolutionManager", "getAutoConfig=" + c());
        r102 = true;
        goto L15
    }

    public final void b(String r110, String r111, int r112) {
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return;
    L9:
        if (d() > 0) goto L11;
        return;
    L11:
        WeakReference<DataCenter> r101 = this.f110456a;
        Object r102 = null;
        if (r101 == null) goto L14;
        DataCenter r103 = r101.get();
    L15:
        if (r103 == null) goto L17;
        Room r104 = (Room) r103.get("data_room", null);
    L18:
        if (r104 == null) goto L22;
        StreamUrl r105 = r104.getStreamUrl();
        if (r105 == null) goto L22;
        List<IQuality> r106 = r105.getQualityList();
    L23:
        if (r106 == null) goto L32;
        Iterator<T> r107 = r106.iterator();
    L26:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((IQuality) r108).getSdkKey(), r110) == false) goto L26;
    L31:
        IQuality r109 = (IQuality) r108;
    L33:
        if (r109 == null) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == true) goto L56;
        if (Intrinsics.areEqual(r111, "1") == false) goto L78;
        if (r106 == null) goto L56;
        if (this.f110460e.containsKey(r110) == false) goto L56;
        String r114 = this.f110460e.get(r110);
        Iterator<T> r115 = r106.iterator();
    L47:
        if (r115.hasNext() == false) goto L51;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((IQuality) r116).getName(), r114) == false) goto L47;
        r102 = r116;
    L51:
        IQuality r117 = (IQuality) r102;
        if (r117 == null) goto L56;
        r110 = r117.getSdkKey();
        goto L56
    L78:
        return;
    L56:
        if (Intrinsics.areEqual(f(), r110) == false) goto L59;
        ALogger.d("AutoResolutionManager", "curr=target=" + r110);
    L59:
        if (j(c(), "use_resolution_service").length() <= 0) goto L61;
        boolean r118 = true;
    L62:
        if (r118 == false) goto L64;
        ISmoothResolutionService.CC.smoothSwitchResolution$default((ISmoothResolutionService) k.n(ISmoothResolutionService.class), r110, 2, 5000, "orientation", null, 16, null);
    L67:
        ALogger.d("AutoResolutionManager", "doSwitchResolution=" + r110);
        this.f110461f = true;
        String r119 = f();
        if (r119 != null) goto L70;
        r119 = "";
    L70:
        this.f110462g = r119;
        this.f110463h = r110;
        return;
    L64:
        ILivePlayerClient r120 = LivePlatformPlayerManager.f();
        if (r120 == null) goto L67;
        r120.smoothSwitchResolution(r110, r112, false);
        goto L67
    L61:
        r118 = false;
        goto L62
    L35:
        r113 = false;
        goto L36
    L30:
        r108 = null;
        goto L31
    L32:
        r109 = null;
    L22:
        r106 = null;
        goto L23
    L17:
        r104 = null;
        goto L18
    L14:
        r103 = null;
        goto L15
    L5:
        r100 = false;
        goto L6
    }
}
