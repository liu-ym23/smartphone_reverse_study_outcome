package com.bytedance.android.shopping.collect.container;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sc3.g;
import v19.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/ECFavoriteActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFavoriteActivity extends AbsActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f172147m = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f172148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f172149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f172150l;

    public static final class a {
        public static void a(Context r100, Uri r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "uri");
            Intent r103 = new Intent(r100, ECFavoriteActivity.class);
            r103.setData(r101);
            int r104 = ECFavoriteActivity.f172147m;
            Bundle r105 = new Bundle();
            Iterator<T> r106 = UriProtector.getQueryParameterNames(r101).iterator();
        L4:
            if (r106.hasNext() == false) goto L9;
            String r107 = (String) r106.next();
            String r108 = UriProtector.getQueryParameter(r101, r107);
            if (r108 == null) goto L4;
            r105.putString(r107, r108);
            goto L4
        L9:
            if (r105.containsKey(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME) == true) goto L12;
            r105.putString(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "goods");
        L12:
            if (r105.containsKey("user_favorites_type_key") == true) goto L14;
            r105.putInt("user_favorites_type_key", 103);
        L14:
            r103.putExtras(r105);
            if ((r100 instanceof Application) == false) goto L17;
            r103.addFlags(268435456);
        L17:
            r100.startActivity(r103);
            if (r102 == true) goto L20;
            return;
        L20:
            if ((r100 instanceof Activity) == true) goto L22;
            r100 = null;
        L22:
            Activity r109 = (Activity) r100;
            if (r109 == null) goto L32;
            r109.finish();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.ec_favorite_slide_in_left, R.anim.ec_favorite_slide_out_right);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ECFavoriteActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.fragment.app.FragmentTransaction, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.fragment.app.FragmentTransaction] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final void init() {
        Object r100 = null;
        BtmSDK.INSTANCE.registerBtmPageOnCreate(this, "a1.b4649", null);
        FragmentManager r101 = getSupportFragmentManager();
        ?? r102 = r101.beginTransaction();
        Fragment r103 = r101.findFragmentByTag("user_favorites_type_fragment_tag");
        ?? r104 = r103;
        if (r103 != null) goto L78;
        int r105 = ECSdk.f48106a;
        IEShoppingService r106 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r106 == null) goto L77;
        g r107 = r106.getCollectService();
        if (r107 == null) goto L77;
        LinkedHashMap r108 = new LinkedHashMap();
        Intent r109 = getIntent();
        if (r109 == null) goto L30;
        Bundle r110 = r109.getExtras();
        if (r110 == null) goto L30;
        Set<String> r111 = r110.keySet();
        if (r111 == null) goto L30;
        Iterator r112 = r111.iterator();
    L16:
        if (r112.hasNext() == false) goto L30;
        String r113 = (String) r112.next();
        Intent r114 = getIntent();
        if (r114 == null) goto L22;
        Bundle r115 = r114.getExtras();
        if (r115 == null) goto L22;
        Object r116 = r115.get(r113);
    L24:
        if ((r116 instanceof String) == true) goto L26;
        r116 = null;
    L26:
        String r117 = (String) r116;
        if (r117 == null) goto L16;
        r108.put(r113, r117);
    L22:
        r116 = null;
    L30:
        if (r108.get("is_from_personal") != null) goto L33;
        r108.put("is_from_personal", "0");
    L33:
        if (r108.get("collect_experiment_value") != null) goto L35;
        r108.put("collect_experiment_value", "2");
    L35:
        CharSequence r118 = (CharSequence) r108.get("previous_page");
        boolean r119 = false;
        if (r118 != null) goto L38;
    L41:
        boolean r120 = true;
    L42:
        if (r120 == true) goto L44;
    L50:
        CharSequence r121 = (CharSequence) r108.get("ecom_scene_id");
        if (r121 != null) goto L53;
    L56:
        boolean r122 = true;
    L57:
        if (r122 == false) goto L76;
        String r123 = (String) r108.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r123 == null) goto L76;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L62
        Object r125 = Result.m9449constructorimpl(new JSONObject(r123).optString("ecom_scene_id"));     // Catch: Throwable -> L62
    L65:
        if (Result.m9455isFailureimpl(r125) == false) goto L67;
        r125 = null;
    L67:
        String r126 = (String) r125;
        if (r126 == null) goto L76;
        if (r126.length() <= 0) goto L72;
        r119 = true;
    L72:
        if (r119 == false) goto L74;
        r100 = r126;
    L74:
        if (r100 == null) goto L76;
        r108.put("ecom_scene_id", r100);
    L62:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L76:
        r100 = r107.a(this, r108);
        goto L77
    L53:
        if (r121.length() == 0) goto L56;
        r122 = false;
        goto L57
    L44:
        if (Intrinsics.areEqual((String) r108.get("enter_from"), "toolbar_a1.b8094") == false) goto L46;
        String r128 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L49:
        r108.put("previous_page", r128);
        goto L50
    L46:
        r128 = (String) r108.get("history_path");
        if (r128 != null) goto L49;
        r128 = "";
        goto L49
    L38:
        if (r118.length() == 0) goto L41;
        r120 = false;
    L77:
        r104 = r100;
    L78:
        if (r104 == 0) goto L92;
        boolean r129 = LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r104, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "user_favorites_type_fragment_tag", R.id.container);
        ?? r130 = r102;
        if (r129 == true) goto L83;
        r130 = r102.replace(R.id.container, r104, "user_favorites_type_fragment_tag");
    L83:
        r130.commit();
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECFavoriteActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    public ECFavoriteActivity() {
        this.f172148j = "h5";
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public final void y1() {
        ImmersionBar.with(this).statusBarColor(R.color.white).statusBarDarkFont(true).navigationBarColor(R.color.white).init();
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        overridePendingTransition(R.anim.ec_favorite_slide_in_right, R.anim.ec_favorite_slide_out_left);
        setContentView(R.layout.ec_favorite_activity);
        Intent r100 = getIntent();
        if (r100 == null) goto L52;
        String r101 = r100.getStringExtra("enter_from");
        if (r101 != null) goto L15;
        r101 = "h5";
    L15:
        this.f172148j = r101;
        String r102 = r100.getStringExtra("enter_method");
        if (r102 != null) goto L18;
        r102 = "click_h5";
    L18:
        this.f172149k = r102;
        this.f172150l = r100.getStringExtra(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
        JSONObject r103 = new JSONObject();
    L50:
        th = move-exception;
        th.printStackTrace();
        goto L52
    L20:
        if (TextUtils.isEmpty(this.f172148j) == true) goto L23;
        r103.put("enter_from", this.f172148j);     // Catch: Throwable -> L50
    L23:
        if (r100.hasExtra("scene_id") == false) goto L26;
        r103.put("scene_id", String.valueOf(z1(r100, "scene_id", 0)));     // Catch: Throwable -> L50
    L26:
        if (TextUtils.isEmpty(this.f172149k) == true) goto L29;
        String r104 = this.f172149k;     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L50
        r103.put("enter_method", r104);     // Catch: Throwable -> L50
    L29:
        if (TextUtils.isEmpty(this.f172150l) == true) goto L31;
        String r105 = this.f172150l;     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L50
        r103.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r105);     // Catch: Throwable -> L50
    L31:
        int r106 = z1(r100, "group_source", -1);     // Catch: Throwable -> L50
        if (r106 == (-1)) goto L34;
        r103.put("group_source", String.valueOf(r106));     // Catch: Throwable -> L50
    L34:
        String r107 = r100.getStringExtra("episode_type");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r107) == true) goto L37;
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L50
        r103.put("episode_type", r107);     // Catch: Throwable -> L50
    L37:
        String r108 = r100.getStringExtra("album_id");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r108) == true) goto L40;
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L50
        r103.put("album_id", r108);     // Catch: Throwable -> L50
    L40:
        String r109 = r100.getStringExtra("episode_id");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r109) == true) goto L43;
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L50
        r103.put("episode_id", r109);     // Catch: Throwable -> L50
    L43:
        String r111 = r100.getStringExtra("group_id");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r111) == true) goto L47;
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L50
        r103.put("group_id", r111);     // Catch: Throwable -> L50
    L47:
        if (TextUtils.isEmpty(this.f172150l) == true) goto L52;
        com.bytedance.android.ec.sdk.helper.g.f48122a.logV3("enter_personal_favourite", r103);     // Catch: Throwable -> L50
    L52:
        init();
    }

    public static int z1(Intent r100, String r101, int r102) {
        Bundle r103 = r100.getExtras();
        if (r103 == null) goto L5;
        Object r104 = r103.get(r101);
    L7:
        if ((r104 instanceof Number) == false) goto L10;
        return ((Number) r104).intValue();
    L10:
        if ((r104 instanceof String) == false) goto L16;
        Integer r105 = StringsKt.toIntOrNull((String) r104);
        if (r105 != null) goto L14;
        return r102;
    L14:
        return r105.intValue();
    L16:
        return r102;
    L5:
        r104 = null;
        goto L7
    }
}
