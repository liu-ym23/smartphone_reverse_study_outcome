package com.bytedance.android.shopping.anchorv4.helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.containers.ProductDetailActivity;
import com.bytedance.android.shopping.prepurchase.business.pdp.ProductDetailV2Activity;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f166933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<Activity> f166934b = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.helper.a$a, reason: collision with other inner class name */
    public static final class C2521a implements Application.ActivityLifecycleCallbacks {
        public C2521a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
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
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r101 = a.f166933a;
            if ((r100 instanceof ProductDetailActivity) == false) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L12;
            a.f166934b.remove(r100);
            return;
        L12:
            return;
        L5:
            if ((r100 instanceof ProductDetailV2Activity) == true) goto L8;
            r102 = false;
            goto L9
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r102 = a.f166933a;
            if ((r100 instanceof ProductDetailActivity) == false) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            a.a();
            a.f166934b.offer(r100);
            return;
        L12:
            return;
        L5:
            if ((r100 instanceof ProductDetailV2Activity) == true) goto L8;
            r103 = false;
            goto L9
        }
    }

    public a() {
    }

    static {
        f166934b = new LinkedList();
    }

    public static final void a() {
        Iterator<Activity> r100 = f166934b.iterator();
    L4:
        if (f166934b.size() <= 3) goto L18;
        if (r100.hasNext() == false) goto L25;
        Activity r101 = r100.next();
        if ((r101 instanceof LifecycleOwner) == true) goto L10;
        Object r102 = null;
    L11:
        LifecycleOwner r103 = (LifecycleOwner) r102;
        if (r103 != null) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L4;
        r100.remove();
        r101.finish();
        goto L4
    L14:
        r104 = r103.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        goto L15
    L10:
        r102 = r101;
        goto L11
    L25:
        return;
    }

    public static void b() {
        Lazy r100 = ECSettingKeys.f43616a;
        int r101 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r102 = Boolean.TRUE;
        Context r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L170
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L170
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L170
        r105.getClass();     // Catch: Throwable -> L58
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_pdp_activity_limit");     // Catch: Throwable -> L58
        if (r106 != null) goto L10;
    L55:
        Object r107 = null;
    L56:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L58
    L60:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L170
        if (r109 == null) goto L64;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L170
    L64:
        if (Result.m9455isFailureimpl(r108) == false) goto L67;
        r108 = null;
    L67:
        if ((r108 instanceof Boolean) == true) goto L69;
        r108 = null;
    L69:
        Object r110 = (Boolean) r108;     // Catch: Throwable -> L170
        if (r110 != null) goto L76;
        r105.getClass();     // Catch: Throwable -> L170
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_pdp_activity_limit");     // Catch: Throwable -> L170
        if ((r111 instanceof Boolean) == true) goto L75;
        r111 = null;
    L75:
        r110 = (Boolean) r111;     // Catch: Throwable -> L170
    L76:
        if (r110 != null) goto L180;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L170
    L157:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L170
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L160:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L197;
    L167:
        r110 = r114;
    L168:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L170
        SDKSettingsCacheManager.e("ec_pdp_activity_limit", r110);     // Catch: Throwable -> L170
        goto L180
    L197:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_activity_limit", Boolean.class, r102);     // Catch: Throwable -> L164
    L165:
        if (r114 != null) goto L167;
        r110 = r102;
    L164:
        r114 = r102;
        goto L165
    L205:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L132
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_pdp_activity_limit");     // Catch: Throwable -> L132
        if (r115 != null) goto L84;
    L129:
        Object r116 = null;
    L130:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L132
    L134:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L138;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L138:
        if (Result.m9455isFailureimpl(r117) == false) goto L141;
        r117 = null;
    L141:
        if ((r117 instanceof Boolean) == true) goto L143;
        r117 = null;
    L143:
        r114 = (Boolean) r117;     // Catch: Throwable -> L157
        if (r114 != null) goto L167;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L157
        Object r120 = jj4.a.a("ec_pdp_activity_limit", Boolean.class, r102, false);     // Catch: Throwable -> L157
        if (r120 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L157
    L150:
        if ((r120 instanceof Boolean) == true) goto L152;
        r120 = null;
    L152:
        Object r121 = (Boolean) r120;     // Catch: Throwable -> L157
        if (r121 != null) goto L155;
        r121 = r102;
    L155:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L157
    L84:
        if ((r115 instanceof Boolean) == true) goto L86;
        Object r122 = null;
    L87:
        r116 = (Boolean) r122;     // Catch: Throwable -> L132
        if (r116 != null) goto L130;
        if ((r115 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L132
        if ((r123 instanceof Boolean) == true) goto L97;
        r123 = null;
    L97:
        r116 = (Boolean) r123;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L132
        if ((r124 instanceof Boolean) == true) goto L103;
        r124 = null;
    L103:
        r116 = (Boolean) r124;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L132
        if ((r125 instanceof Boolean) == true) goto L109;
        r125 = null;
    L109:
        r116 = (Boolean) r125;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L132
        if ((r126 instanceof Boolean) == true) goto L115;
        r126 = null;
    L115:
        r116 = (Boolean) r126;     // Catch: Throwable -> L132
    L117:
        if ((r115 instanceof JSONObject) == false) goto L119;
    L201:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L125
        if ((r127 instanceof Boolean) == true) goto L123;
        r127 = null;
    L123:
        Object r128 = Result.m9449constructorimpl((Boolean) r127);     // Catch: Throwable -> L125
    L127:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L132
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r115 instanceof JSONArray) == false) goto L129;
    L86:
        r122 = r115;
    L132:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L180:
        if (((Boolean) r110).booleanValue() == true) goto L183;
        return;
    L183:
        if (f166933a == false) goto L185;
        return;
    L185:
        f166933a = true;
        Context r131 = ECAppInfoService.f48114e.getApplicationContext();
        if (r131 == null) goto L188;
        Context r132 = r131.getApplicationContext();
    L190:
        if ((r132 instanceof Application) == false) goto L193;
        r103 = r132;
    L193:
        Application r133 = (Application) r103;
        if (r133 == null) goto L211;
        r133.registerActivityLifecycleCallbacks(new C2521a());
        return;
    L211:
        return;
    L188:
        r132 = null;
        goto L190
    L10:
        if ((r106 instanceof Boolean) == true) goto L12;
        Object r134 = null;
    L13:
        r107 = (Boolean) r134;     // Catch: Throwable -> L58
        if (r107 != null) goto L56;
        if ((r106 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r135 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L58
        if ((r135 instanceof Boolean) == true) goto L23;
        r135 = null;
    L23:
        r107 = (Boolean) r135;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r136 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L58
        if ((r136 instanceof Boolean) == true) goto L29;
        r136 = null;
    L29:
        r107 = (Boolean) r136;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r137 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L58
        if ((r137 instanceof Boolean) == true) goto L35;
        r137 = null;
    L35:
        r107 = (Boolean) r137;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r138 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L58
        if ((r138 instanceof Boolean) == true) goto L41;
        r138 = null;
    L41:
        r107 = (Boolean) r138;     // Catch: Throwable -> L58
    L43:
        if ((r106 instanceof JSONObject) == false) goto L45;
    L203:
        Object r139 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Boolean.class);     // Catch: Throwable -> L51
        if ((r139 instanceof Boolean) == true) goto L49;
        r139 = null;
    L49:
        Object r140 = Result.m9449constructorimpl((Boolean) r139);     // Catch: Throwable -> L51
    L53:
        r107 = r140;
        if (Result.m9455isFailureimpl(r107) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L58
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r106 instanceof JSONArray) == false) goto L55;
    L12:
        r134 = r106;
    L58:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L170
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Object r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r145 = Result.m9452exceptionOrNullimpl(r144);
        if (r145 == null) goto L175;
        EnsureManager.ensureNotReachHere(r145);
    L175:
        if (Result.m9455isFailureimpl(r144) == true) goto L178;
        r102 = r144;
    L178:
        r110 = r102;
        goto L180
    }
}
