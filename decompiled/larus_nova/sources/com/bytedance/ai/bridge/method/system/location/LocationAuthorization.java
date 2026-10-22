package com.bytedance.ai.bridge.method.system.location;

import android.app.Activity;
import android.os.Looper;
import com.bytedance.ai.applet.permission.Scope;
import com.google.gson.JsonObject;
import d3.a0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes43.dex */
public final class LocationAuthorization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f35985a = 0;

    static {
    }

    public LocationAuthorization() {
    }

    public static void c(Function1 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        MainCoroutineDispatcher r101 = Dispatchers.getMain().getImmediate();
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r101), null, null, new LocationAuthorization$launchOnMainThread$1(r100, null), 3, null);
        return;
    L5:
        r101 = Dispatchers.getMain();
        goto L6
    }

    public static JsonObject b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        JsonObject r102 = new JsonObject();
        r102.addProperty("errCode", Integer.valueOf(r101));
        r102.addProperty("errMsg", r100);
        return r102;
    }

    public static void a(e3.d r110, f3.h r111, Scope r112, String r113, Function1 r114) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "scope");
        Intrinsics.checkNotNullParameter(r113, "permissionCheckDetail");
        Intrinsics.checkNotNullParameter(r114, "onSuccess");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L8;
        r100 = f2.k.b();
        if (r100 != null) goto L8;
        f3.h.a.a(r111, "context is null", f3.a.f475265f, null, 10);
        return;
    L8:
        Activity r101 = r100;
        a0 r102 = r110.getContainerContext();
        if (r102 == null) goto L15;
        String r103 = r102.getAppletId();
        if (r103 == null) goto L15;
        c(new LocationAuthorization$authorize$1(r103, r111, r110, r113, r112, r114, r101, null));
        return;
    L15:
        f3.h.a.a(r111, "appId is null", f3.a.f475265f, null, 10);
    }
}
