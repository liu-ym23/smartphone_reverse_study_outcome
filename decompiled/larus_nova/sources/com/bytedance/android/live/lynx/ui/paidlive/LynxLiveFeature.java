package com.bytedance.android.live.lynx.ui.paidlive;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.live.api.RoomStatApi;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.paidlive.IPaidLivePresenter;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayerView;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.xelement.live.LynxLiveLight;
import com.bytedance.ies.xelement.live.impl.j;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/paidlive/LynxLiveFeature;", "Lcom/bytedance/ies/xelement/live/LynxLiveLight;", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "", "play", "stop", "", "roomJson", "setRoom", "", ITTVideoEngineEventSource.KEY_MUTE, "setVolume", "(Ljava/lang/Boolean;)V", "enable", "setEnableEnterRoom", "logParams", "setExtraLogParams", "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxLiveFeature extends LynxLiveLight {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f82749p = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IPaidLivePresenter f82750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Room f82751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f82752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, Object> f82753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f82754m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h f82755n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f82756o;

    public static final class a implements com.bytedance.ies.xelement.live.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxLiveFeature f82757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxContext f82758b;

        @Override // com.bytedance.ies.xelement.live.a
        public final void d() {
        }

        @Override // com.bytedance.ies.xelement.live.a
        public final void isShared() {
        }

        @Override // com.bytedance.ies.xelement.live.a
        public final void a(IXLivePlayerView r100) {
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r100, "player");
        }

        @Override // com.bytedance.ies.xelement.live.a
        public final void b(HashMap r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            String r100 = (String) r110.get("room_id");
            String r101 = (String) r110.get("enter_from_merge");
            String r111 = (String) r110.get("enter_method");
            Context r102 = null;
            if (r100 == null) goto L6;
            Long r103 = a36.b.f(r100);
            if (r103 == null) goto L6;
        L10:
            if (r103 == null) goto L12;
            long r104 = r103.longValue();
        L13:
            Room r105 = this.f82757a.f82751j;
            if (r105 == null) goto L16;
            String r106 = r105.getMultiStreamData();
        L17:
            this.f82757a.getClass();
            Bundle r107 = new Bundle();
            r107.putLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, System.currentTimeMillis());
            r107.putString("enter_from_merge", r101);
            r107.putString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, ILiveRoomPlayFragmentConstant.ENTER_ROOM_TYPE_WITH_NO_FEED_REQUEST);
            r107.putString("enter_method", r111);
            r107.putString("live.intent.extra.ENTER_TYPE", "click");
            r107.putString(ILiveRoomPlayFragmentConstant.EXTRA_PULL_STREAM_DATA, r106);
            Bundle r108 = new Bundle();
            r108.putString("enter_method", r111);
            r108.putString("enter_from_merge", r101);
            Unit r112 = Unit.INSTANCE;
            m0.e(r107, r108);
            IHostAction r113 = (IHostAction) k.n(IHostAction.class);
            LynxContext r109 = this.f82758b;
            if (r109 == null) goto L20;
            r102 = r109.getContext();
        L20:
            r113.startLive(r102, r104, r107);
            return;
        L16:
            r106 = null;
            goto L17
        L12:
            r104 = 0;
        L6:
            Room r114 = this.f82757a.f82751j;
            if (r114 == null) goto L9;
            r103 = Long.valueOf(r114.f162599id);
            goto L10
        L9:
            r103 = null;
            goto L10
        }

        public a(LynxLiveFeature r100, LynxContext r101) {
            this.f82757a = r100;
            this.f82758b = r101;
        }

        @Override // com.bytedance.ies.xelement.live.a
        public final void c(IXLivePlayerView r100, com.bytedance.ies.xelement.live.impl.i r101) {
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r101, "observer");
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r101, "observer");
        }

        @Override // com.bytedance.ies.xelement.live.a
        public final void e(IXLivePlayerView r100, Observer<ILivePlayerScene> r101) {
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r101, "observer");
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r101, "observer");
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxLiveFeature f82759a;

        public c(LynxLiveFeature r100) {
            this.f82759a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            List<T> r111 = ((ListResponse) r110).data;
            Long r100 = null;
            if (r111 == null) goto L19;
            Iterator<T> r112 = r111.iterator();
        L6:
            if (r112.hasNext() == false) goto L17;
            T r101 = r112.next();
            long r102 = ((ng2.f) r101).roomId;
            Room r103 = this.f82759a.f82751j;
            if (r103 == null) goto L10;
            long r104 = r103.f162599id;
        L12:
            if (r102 != r104) goto L14;
            boolean r105 = true;
        L15:
            if (r105 == false) goto L6;
        L18:
            ng2.f r106 = r101;
        L20:
            if (r106 != null) goto L22;
        L24:
            boolean r113 = false;
        L25:
            if (r113 == true) goto L36;
            LynxLiveFeature r114 = this.f82759a;
            Pair[] r107 = new Pair[1];
            Room r108 = r114.f82751j;
            if (r108 == null) goto L29;
            r100 = Long.valueOf(r108.f162599id);
        L29:
            r107[0] = TuplesKt.to("room_id", String.valueOf(r100));
            LynxLiveFeature.Q(r114, "liveEnd", MapsKt.mutableMapOf(r107));
            return;
        L36:
            return;
        L22:
            if (r106.alive != true) goto L24;
            r113 = true;
            goto L25
        L14:
            r105 = false;
            goto L15
        L10:
            r104 = 0;
            goto L12
        L17:
            r101 = (T) null;
            goto L18
        L19:
            r106 = null;
            goto L20
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f82760a = null;

        static {
            f82760a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Logger.e(((Throwable) r100).getMessage());
        }
    }

    public static final class e extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public e() {
        }
    }

    public static final class f<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxLiveFeature f82761a;

        public f(LynxLiveFeature r100) {
            this.f82761a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L10;
            StringBuilder r101 = new StringBuilder("first frame: room id=");
            Room r102 = this.f82761a.f82751j;
            if (r102 == null) goto L7;
            Long r103 = Long.valueOf(r102.f162599id);
        L8:
            r101.append(r103);
            ALogger.i("LynxLiveFeature", r101.toString());
            return;
        L7:
            r103 = null;
            goto L8
        }
    }

    public static final class g implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxLiveFeature f82762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callback f82763b;

        public g(LynxLiveFeature r100, Callback r101) {
            this.f82762a = r100;
            this.f82763b = r101;
        }

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object[] r100) {
            StringBuilder r101 = new StringBuilder("receive play callback, args[0]=");
            r101.append(r100[0]);
            r101.append(", roomId=");
            Room r102 = this.f82762a.f82751j;
            if (r102 == null) goto L5;
            Long r103 = Long.valueOf(r102.f162599id);
        L6:
            r101.append(r103);
            ALogger.i("LynxLiveFeature", r101.toString());
            if (Intrinsics.areEqual(r100[0], 0) == false) goto L26;
            LynxLiveFeature r104 = this.f82762a;
            com.bytedance.ies.xelement.live.c r105 = r104.f250113f;
            if (r105 == null) goto L11;
            IXLivePlayerView r106 = r105.b();
        L13:
            if ((r106 instanceof IXLivePlayerView) == true) goto L15;
            r106 = null;
        L15:
            if (r106 == null) goto L17;
            ILivePlayerClient r107 = r106.client();
        L18:
            ALogger.i("LynxLiveFeature", "startPlay: client=" + r107 + ", messageManager=null, isMute=" + r104.f82752k);
            if (r107 == null) goto L26;
            IRoomEventHub r108 = r107.getEventHub();
            r108.getPlayComplete().observeForever(r104.f82755n);
            r108.getFirstFrame().observeForever(r104.f82756o);
            IPaidLivePresenter r109 = r104.f82750i;
            if (r109 == null) goto L23;
            r109.autoChangeMuteStatus(!r104.f82752k);
        L23:
            IPaidLivePresenter r110 = r104.f82750i;
            if (r110 == null) goto L26;
            IPaidLivePresenter.DefaultImpls.onLiveStart$default(r110, r107, null, 2, null);
            goto L26
        L17:
            r107 = null;
            goto L18
        L11:
            r106 = null;
        L26:
            Callback r111 = this.f82763b;
            if (r111 == null) goto L30;
            r111.invoke(new Object[]{r100[0]});
            return;
        L30:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class h<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxLiveFeature f82764a;

        public h(LynxLiveFeature r100) {
            this.f82764a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            LynxLiveFeature r101 = this.f82764a;
            int r102 = LynxLiveFeature.f82749p;
            r101.R();
            return;
        }
    }

    public static final class i implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxLiveFeature f82765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callback f82766b;

        public i(LynxLiveFeature r100, Callback r101) {
            this.f82765a = r100;
            this.f82766b = r101;
        }

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object[] r100) {
            StringBuilder r101 = new StringBuilder("receive stop callback, args[0]=");
            r101.append(r100[0]);
            r101.append(", roomId=");
            Room r102 = this.f82765a.f82751j;
            if (r102 == null) goto L5;
            Long r103 = Long.valueOf(r102.f162599id);
        L6:
            r101.append(r103);
            ALogger.i("LynxLiveFeature", r101.toString());
            if (Intrinsics.areEqual(r100[0], 0) == false) goto L12;
            LynxLiveFeature r104 = this.f82765a;
            IPaidLivePresenter r105 = r104.f82750i;
            if (r105 == null) goto L11;
            r105.onStopPreview();
        L11:
            r104.S();
        L12:
            Callback r106 = this.f82766b;
            if (r106 == null) goto L16;
            r106.invoke(new Object[]{r100[0]});
            return;
        L16:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    public final void R() {
        if (this.f82751j != null) goto L5;
        return;
    L5:
        e r100 = new e();
        String r101 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(r100).second;
        RoomStatApi r102 = (RoomStatApi) com.bytedance.android.live.network.c.b().e(RoomStatApi.class);
        Room r103 = this.f82751j;
        if (r103 == null) goto L8;
        Long r104 = Long.valueOf(r103.f162599id);
    L9:
        r102.checkRoom(r101, String.valueOf(r104)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.f82760a);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final void S() {
        com.bytedance.ies.xelement.live.c r100 = this.f250113f;
        IRoomEventHub r101 = null;
        if (r100 == null) goto L5;
        IXLivePlayerView r102 = r100.b();
    L7:
        if ((r102 instanceof IXLivePlayerView) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        ILivePlayerClient r103 = r102.client();
    L12:
        if (r103 == null) goto L14;
        r101 = r103.getEventHub();
    L14:
        if (r101 == null) goto L18;
        MutableLiveData<Boolean> r104 = r101.getPlayComplete();
        if (r104 == null) goto L18;
        r104.removeObserver(this.f82755n);
    L18:
        if (r101 == null) goto L23;
        MutableLiveData<Boolean> r105 = r101.getFirstFrame();
        if (r105 == null) goto L24;
        r105.removeObserver(this.f82756o);
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r103 = null;
        goto L12
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.ies.xelement.live.LynxLiveLight, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        IPaidLivePresenter r100 = this.f82750i;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f82750i = null;
    }

    @Override // com.bytedance.ies.xelement.live.LynxLiveLight, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        IPaidLivePresenter r100 = this.f82750i;
        if (r100 == null) goto L5;
        r100.onStopPreview();
    L5:
        S();
    }

    public LynxLiveFeature(LynxContext r100) {
        super(r100, null);
        this.f82754m = true;
        this.f82755n = new h(this);
        this.f82756o = new f(this);
        a r101 = new a(this, r100);
        this.f250108a = r101;
        com.bytedance.ies.xelement.live.c r102 = this.f250113f;
        if (r102 == null) goto L9;
        ((j) r102).f250162f = r101;
        View r103 = getView();
        if (r103 == null) goto L10;
        r103.setOnClickListener(new ul0.a(this));
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xelement.live.impl.LynxLiveLightPlayerDefaultImpl");
    }

    @LynxProp(name = "enablelynxenterroom")
    public final void setEnableEnterRoom(Boolean r100) {
        this.f82754m = Intrinsics.areEqual(r100, Boolean.TRUE);
    }

    @LynxProp(name = "extralogparams")
    public final void setExtraLogParams(ReadableMap r100) {
        if (r100 == null) goto L4;
        HashMap<String, Object> r101 = r100.toHashMap();
    L5:
        this.f82753l = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    @LynxProp(name = "roomdata")
    public final void setRoom(String r100) {
        this.f82751j = (Room) GsonHelper.get().fromJson(r100, Room.class);     // Catch: Exception -> L4
    L6:
        Room r101 = this.f82751j;
        Long r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.getMultiStreamData();
    L10:
        super.setStreamData(r103);
        Room r104 = this.f82751j;
        if (r104 == null) goto L13;
        r102 = Long.valueOf(r104.f162599id);
    L13:
        super.setRoomId(String.valueOf(r102));
        HashMap r105 = new HashMap();
        List<com.ss.ugc.live.sdk.msg.dispatch.f> r106 = com.ss.ugc.live.sdk.platform.a.f458519a;
        Intrinsics.checkNotNullParameter(r105, "customParams");
        throw new RuntimeException("message platform has not init");
    L9:
        r103 = null;
    L4:
        e = move-exception;
        ALogger.e("LynxLiveFeature", "episode parse error: " + e.getMessage());
        goto L6
    }

    @Override // com.bytedance.ies.xelement.live.LynxLiveLight
    @LynxProp(name = ITTVideoEngineEventSource.KEY_MUTE)
    public void setVolume(Boolean r100) {
        super.setVolume(r100);
        ALogger.i("LynxLiveFeature", "set volume: mute=" + r100 + ", paidLivePresenter=" + this.f82750i);
        boolean r101 = Intrinsics.areEqual(r100, Boolean.TRUE);
        this.f82752k = r101;
        IPaidLivePresenter r102 = this.f82750i;
        if (r102 == null) goto L6;
        r102.autoChangeMuteStatus(!r101);
        return;
    }

    @Override // com.bytedance.ies.xelement.live.LynxLiveLight
    @LynxUIMethod
    public void play(ReadableMap r100, Callback r101) {
        R();
        super.play(r100, new g(this, r101));
    }

    @Override // com.bytedance.ies.xelement.live.LynxLiveLight
    @LynxUIMethod
    public void stop(ReadableMap r100, Callback r101) {
        super.stop(r100, new i(this, r101));
    }

    public static final void Q(LynxLiveFeature r100, String r101, Map r102) {
        EventEmitter r103 = r100.getLynxContext().getEventEmitter();
        m7a.a r104 = new m7a.a(r100.getSign(), r101);
        Iterator r105 = r102.keySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        String r106 = (String) r105.next();
        r104.a(r106, r102.get(r106));
        goto L4
    L6:
        Unit r107 = Unit.INSTANCE;
        r103.sendCustomEvent(r104);
    }
}
