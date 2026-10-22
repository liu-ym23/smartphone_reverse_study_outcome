package com.bytedance.android.shopping.verify;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.verify.api.AuthApi;
import com.bytedance.android.shopping.verify.api.LawHintRequestListener;
import com.google.gson.Gson;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class AuthUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187163a = 0;

    public AuthUtils() {
    }

    static {
    }

    public static void b(long r100, CompositeDisposable r101, int r102) {
        Disposable r103 = null;
        if ((r102 & 2) == 0) goto L20;
        r101 = null;
    L20:
        HashMap r104 = g.c();     // Catch: Exception -> L7
        r104.put(g.b(r100), Boolean.FALSE);     // Catch: Exception -> L7
        int r105 = pi3.a.f529323a;     // Catch: Exception -> L7
        String r106 = new Gson().toJson(r104);     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r106, "newValue");     // Catch: Exception -> L7
        q.f48131a.putString("law_hint_map", r106);     // Catch: Exception -> L7
    L9:
        SourceType.Companion.getClass();
        if (SourceType.a.c(r100) == false) goto L12;
    L13:
        int r107 = bl3.e.f19427a;
        com.bytedance.android.ec.sdk.helper.d r108 = com.bytedance.android.ec.sdk.helper.d.f48119b;
        String r109 = r108.getIECHostUserService().getCurrentUserId();
        String r110 = r108.getIECHostAppInfo().getAppId();
        AuthApi.f187178a.getClass();
        AuthApi r111 = AuthApi.a.f187179a;
        if (r111 == null) goto L16;
        r103 = bg4.b.b(r111.authorizeSmallShop(r109, r110, 1L)).subscribe(new bl3.a(null), new bl3.b(null));
    L16:
        if (r103 == null) goto L23;
        if (r101 == null) goto L24;
        r101.add(r103);
        return;
    L24:
        return;
    L23:
        return;
    L12:
        if (SourceType.a.b(r100) == true) goto L13;
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.f(e, "LawPermissionPreHelper");
        goto L9
    }

    public static void a(final Context r110, final long r111, Boolean r112, final Function2 r113) {
        Intrinsics.checkNotNullParameter(r113, "callback");
        if (r112 == null) goto L6;
        r113.invoke(r112, Boolean.FALSE);
        return;
    L6:
        if (r110 != null) goto L9;
        r113.invoke(Boolean.TRUE, Boolean.FALSE);
        return;
    L9:
        final CompositeDisposable r114 = new CompositeDisposable();
        if (ih3.e.a() == false) goto L39;
        final Function1<Boolean, Unit> r100 = new AuthUtils$checkLawHint$1(r111, r110, r114, r113);
        Intrinsics.checkNotNullParameter(r114, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r100, "callBack");
        String r101 = g.b(r111);
        boolean r102 = false;
        if (Intrinsics.areEqual(r101, "unknown_type") == false) goto L14;
        boolean r103 = false;
    L18:
        final boolean r104 = !r103;
        SourceType.Companion.getClass();
        if (SourceType.a.c(r111) == false) goto L21;
    L24:
        String r105 = g.b(r111);
        if (Intrinsics.areEqual(r105, "unknown_type") == true) goto L31;
        Boolean r106 = (Boolean) g.a().get(r105);
        if (r106 != null) goto L30;
        r106 = Boolean.FALSE;
    L30:
        r102 = r106.booleanValue();
    L31:
        if (r102 == false) goto L33;
        r100.invoke(Boolean.FALSE);
    L41:
        if ((r110 instanceof FragmentActivity) == true) goto L43;
        r110 = null;
    L43:
        FragmentActivity r115 = (FragmentActivity) r110;
        if (r115 == null) goto L49;
        Lifecycle r116 = r115.getLifecycle();
        if (r116 == null) goto L50;
        r116.addObserver(new LawHintRequestListener(r114));
        return;
    L50:
        return;
    L49:
        return;
    L33:
        int r107 = bl3.e.f19427a;
        com.bytedance.android.ec.sdk.helper.d r108 = com.bytedance.android.ec.sdk.helper.d.f48119b;
        String r109 = r108.getIECHostUserService().getCurrentUserId();
        String r117 = r108.getIECHostAppInfo().getAppId();
        Function1<Boolean, Unit> r118 = new AuthUtils$needToShowLawHint$1(r100, r111, r104, r114);
        Intrinsics.checkNotNullParameter(r118, "callBack");
        AuthApi.f187178a.getClass();
        AuthApi r119 = AuthApi.a.f187179a;
        if (r119 == null) goto L36;
        Disposable r120 = bg4.b.b(r119.getAuthStatus(r109, r117)).subscribe(new bl3.c(r118), new bl3.d(r118));
    L37:
        if (r120 == null) goto L41;
        r114.add(r120);
        goto L41
    L36:
        r118.invoke(Boolean.FALSE);
        r120 = null;
        goto L37
    L21:
        if (SourceType.a.b(r111) == true) goto L24;
        r100.invoke(Boolean.valueOf(!r104));
        goto L41
    L14:
        Boolean r121 = (Boolean) g.c().get(r101);
        if (r121 != null) goto L17;
        r121 = Boolean.TRUE;
    L17:
        r103 = r121.booleanValue();
        goto L18
    L39:
        r113.invoke(Boolean.TRUE, Boolean.FALSE);
        goto L41
    }
}
