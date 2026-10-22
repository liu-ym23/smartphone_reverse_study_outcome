package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.livesdk.livecommerce.LiveUserDataCenterModule_ProvideFactory;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sg2.y;

/* JADX INFO: loaded from: classes10.dex */
public final class RoomContextController extends c0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f151593h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f151594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.utils.d f151595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f151596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n1 f151597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile LiveRoomRedirectInfo f151598g;

    public static final class a {
        @JvmStatic
        public static RoomContextController a() {
            RoomContextController r100 = ControllerCenter.c(null, null).f151422m;
            Objects.toString(r100);
            return r100;
        }

        @JvmStatic
        public static RoomContextController b(String r100, String r101) {
            RoomContextController r102 = ControllerCenter.c(r100, r101).f151422m;
            Objects.toString(r102);
            return r102;
        }
    }

    static {
    }

    @JvmStatic
    public static final RoomContextController H() {
        return a.a();
    }

    public final com.bytedance.android.livesdk.livecommerce.room.api.c J() {
        if (this.f151686b.l() == true) goto L7;
        return null;
    L7:
        return q();
    }

    public final String I() {
        long r100 = A().f151429t.f151472l;
        if (r100 <= 0) goto L5;
        Handler r101 = com.bytedance.android.livesdk.livecommerce.utils.k.f153092a;
        return String.valueOf(SystemClock.elapsedRealtime() - r100);
    L5:
        return "0";
    }

    public final Map<String, String> K() {
        if (w() == true) goto L7;
        return new HashMap();
    L7:
        return C().f42698m;
    }

    public final com.bytedance.android.ec.adapter.api.state.a L() {
        if (w() == true) goto L7;
        return null;
    L7:
        return C();
    }

    public final boolean M() {
        if (w() == true) goto L7;
        return false;
    L7:
        return C().a();
    }

    public final Context getContext() {
        if (u() == true) goto L7;
        return null;
    L7:
        return m();
    }

    public RoomContextController(RealRoomController$roomResources$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        super(r100);
        this.f151595d = new com.bytedance.android.livesdk.livecommerce.room.utils.d();
        this.f151596e = new LinkedHashMap();
        this.f151594c = LiveUserDataCenterModule_ProvideFactory.proxyProvide(hh2.a.a().f485148a);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.lifecycle.Observer, com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController$onLiveRoomParamsReady$2$observer$1] */
    public final Object N(Continuation<? super Boolean> r100) {
        final kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        final MutableLiveData r102 = this.f151686b.f();
        final ?? r103 = new RoomContextController$onLiveRoomParamsReady$2$observer$1(r101, r102);
        r102.observeForever(r103);
        r101.i(new RoomContextController$onLiveRoomParamsReady$2$1(r102, r103));
        Object r104 = r101.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r104;
    }
}
