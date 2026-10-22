package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class ControllerCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application.ActivityLifecycleCallbacks f151390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, b0> f151391b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f151392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f151393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f151394e = null;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Class<? super Object> r101 = r100.getClass().getSuperclass();
            if (r101 == null) goto L7;
            Class<? super Object> r102 = r101.getSuperclass();
            if (r102 == null) goto L7;
            String r103 = r102.getSimpleName();
        L9:
            if (TextUtils.equals(r103, "GenerateProxyAppCompatActivity") == false) goto L11;
        L40:
            Object r104 = com.bytedance.android.livesdk.livecommerce.room.utils.b.a(r100);     // Catch: Exception -> L21
            if (r104 == null) goto L20;
        L18:
            r100 = (Activity) r104;     // Catch: Exception -> L21
            goto L22
        L20:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L21
        L22:
            int r105 = r100.hashCode();
            Map<Integer, b0> r106 = ControllerCenter.f151391b;
            b0 r107 = (b0) ((LinkedHashMap) r106).get(Integer.valueOf(r105));
            if (r107 == null) goto L29;
            if (ControllerCenter.a() == true) goto L27;
            c r108 = new c();
            r108.n("clear controller cache of " + r100);
            r108.k();
        L27:
            Lazy r109 = LiveRoomProvider.f151373a;
            LiveRoomProvider.c(r107.f151452a, r107.f151453b, true);
            b0 r110 = r106.remove(Integer.valueOf(r105));
        L29:
            if (r106.isEmpty() == false) goto L41;
            LiveRoomProvider.f151375c.clear();
            LiveRoomProvider.c(null, null, true);
            Context r111 = r100.getApplicationContext();
            if ((r111 instanceof Application) == true) goto L33;
            r111 = null;
        L33:
            Application r112 = (Application) r111;
            if (r112 == null) goto L36;
            r112.unregisterActivityLifecycleCallbacks(ControllerCenter.f151390a);
        L36:
            ControllerCenter.f151390a = null;
            return;
        L41:
            return;
        L11:
            if (TextUtils.equals(r103, "GenerateProxyActivity") == false) goto L22;
        L7:
            r103 = null;
            goto L9
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = r100.hashCode();
            Map<Integer, b0> r102 = ControllerCenter.f151391b;
            LinkedHashMap r103 = (LinkedHashMap) r102;
            b0 r104 = (b0) r103.get(Integer.valueOf(r101));
            if (r104 == null) goto L6;
            String r105 = r104.f151452a;
            Lazy r106 = LiveRoomProvider.f151373a;
            LiveRoomProvider.c(r105, r104.f151453b, false);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = r100.hashCode();
            b0 r102 = (b0) ((LinkedHashMap) ControllerCenter.f151391b).get(Integer.valueOf(r101));
            if (r102 == null) goto L18;
            Object r103 = r102.f151454c.get();
            if (r103 != null) goto L7;
            return;
        L7:
            if ((r103 instanceof ILiveRoomController) == false) goto L12;
            Lazy r104 = LiveRoomProvider.f151373a;
            String r105 = r102.f151452a;
            String r106 = r102.f151453b;
            ILiveRoomController r107 = (ILiveRoomController) r103;
            Intrinsics.checkNotNullParameter(r105, "roomId");
            Intrinsics.checkNotNullParameter(r106, "uniqueKey");
            Intrinsics.checkNotNullParameter(r107, "controller");
            if ((!StringsKt.isBlank(r105)) == false) goto L20;
            LiveRoomProvider.f151377e.put(r105, r107);
            return;
        L20:
            return;
        L12:
            if ((r103 instanceof rd.a) == false) goto L17;
            Lazy r108 = LiveRoomProvider.f151373a;
            String r109 = r102.f151452a;
            String r110 = r102.f151453b;
            rd.a r111 = (rd.a) r103;
            Intrinsics.checkNotNullParameter(r109, "roomId");
            Intrinsics.checkNotNullParameter(r110, "uniqueKey");
            Intrinsics.checkNotNullParameter(r111, "controller");
            if ((!StringsKt.isBlank(r109)) == false) goto L22;
            LiveRoomProvider.f151377e.put(r109, r111);
            return;
        L22:
            return;
        L17:
            throw new IllegalStateException("unknown controller type");
        }
    }

    public static boolean a() {
        return ((Boolean) f151394e.getValue()).booleanValue();
    }

    static {
        f151391b = new LinkedHashMap();
        f151392c = "";
        f151393d = "";
        f151394e = LazyKt.lazy(ControllerCenter$enterRoomMethodOpt$2.INSTANCE);
    }

    public static w b(RoomContextController r100) {
        if (r100 != null) goto L4;
    L6:
        int r101 = RoomContextController.f151593h;
        Context r102 = RoomContextController.a.a().getContext();
    L7:
        if (r102 == null) goto L15;
        Map<Integer, b0> r103 = f151391b;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        b0 r105 = (b0) r104.get(Integer.valueOf(r102.hashCode()));
        if (r105 == null) goto L13;
        w r106 = r105.f151455d;
        if (r106 == null) goto L13;
        return r106;
    L13:
        return new w();
    L15:
        return new w();
    L4:
        if (r100.v() != true) goto L6;
        r102 = r100.getContext();
        goto L7
    }

    @JvmStatic
    public static final RealRoomController c(String r100, String r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = f151392c;
    L12:
        com.bytedance.android.livesdk.livecommerce.room.api.b r105 = null;
        if (cg4.a.a(r100) == false) goto L20;
        if (r101 != null) goto L16;
    L17:
        r102 = true;
    L18:
        if (r102 == false) goto L20;
        r101 = null;
    L22:
        Lazy r106 = LiveRoomProvider.f151373a;
        if (r104 != null) goto L25;
        String r107 = "";
    L26:
        if (r101 != null) goto L28;
        r101 = "";
    L28:
        com.bytedance.android.livesdk.livecommerce.room.api.b r108 = LiveRoomProvider.g(r107, r101);
        if ((r108 instanceof RealRoomController) == false) goto L32;
        r105 = r108;
    L32:
        RealRoomController r109 = (RealRoomController) r105;
        if (r109 == null) goto L36;
        return r109;
    L36:
        if (a() == true) goto L43;
        Log.getStackTraceString(new Throwable());
        c r110 = new c();
        r110.n("controller of " + r104 + " not in cache");
        if (r104 != null) goto L40;
        String r111 = "null";
    L41:
        Intrinsics.checkNotNullParameter(r111, "roomId");
        r110.f("c_invoke_room_id", r111);
        r110.k();
        goto L43
    L40:
        r111 = r104;
    L43:
        if (r104 != null) goto L46;
        r104 = "";
    L46:
        return new RealRoomController(r104, "", LiveRoomProvider.ECProviderSource.DEFAULT, true);
    L25:
        r107 = r104;
        goto L26
    L16:
        if (StringsKt.isBlank(r101) == false) goto L18;
    L20:
        if (r101 != null) goto L22;
        r101 = f151393d;
        goto L22
    L11:
        r104 = r100;
        goto L12
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static void d(Context r100, WeakReference r101, String r102, String r103) {
        if ((r100.getApplicationContext() instanceof Application) == true) goto L5;
        return;
    L5:
        int r104 = r100.hashCode();
        Map<Integer, b0> r105 = f151391b;
        if (r105.containsKey(Integer.valueOf(r104)) == false) goto L11;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        b0 r107 = (b0) r106.get(Integer.valueOf(r104));
        if (r107 == null) goto L19;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r107.f151452a = r102;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r107.f151454c = r101;
        return;
    L19:
        return;
    L11:
        r105.put(Integer.valueOf(r104), new b0(r102, r103, r101));
        if (f151390a != null) goto L18;
        a r108 = new a();
        Context r109 = r100.getApplicationContext();
        if (r109 == null) goto L17;
        ((Application) r109).registerActivityLifecycleCallbacks(r108);
        f151390a = r108;
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }
}
