package com.bytedance.android.shopping.anchorv3.kolbuyershow;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.anchorv3.dualstream.AnchorV3DualStreamFragment;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.material.tabs.TabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m63.b;
import org.json.JSONArray;
import v19.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/kolbuyershow/KolBuyerShowActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KolBuyerShowActivity extends AbsActivity {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f165119q = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPager f165120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TabLayout f165121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f165122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f165123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f165124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f165125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImmersionBar f165126p;

    public static final class a {
    }

    static {
        BtmSDK.INSTANCE.registerPageClass(KolBuyerShowActivity.class, "a1.b183244.c0.d0", true);
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(KolBuyerShowActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar r100 = this.f165126p;
        if (r100 == null) goto L9;
        r100.destroy();
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(KolBuyerShowActivity.class.getName()));
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
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public final void y1() {
        super.y1();
        if (OSUtils.isEMUI3_0() == false) goto L5;
        return;
    L5:
        if (OSUtils.isEMUI3_1() == true) goto L16;
        int r100 = b0.f165303a;
        b0.a(getWindow());
        ImmersionBar r101 = ImmersionBar.with(this);
        this.f165126p = r101;
        if (r101 == null) goto L14;
        ImmersionBar r102 = r101.statusBarDarkFont(true);
        if (r102 == null) goto L15;
        r102.init();
        return;
    L15:
        return;
    L14:
        return;
    }

    public KolBuyerShowActivity() {
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        overridePendingTransition(com.larus.nova.R.anim.ec_commerce_activity_in, com.larus.nova.R.anim.ec_commerce_pre_out);
        setContentView(com.larus.nova.R.layout.ec_commerce_kol_buyer_show_activity);
        Serializable r101 = null;
        if (r100 == null) goto L13;
        Serializable r102 = r100.getSerializable("param_key");
    L15:
        if ((r102 instanceof KolBuyerShowParams) == true) goto L17;
        r102 = null;
    L17:
        KolBuyerShowParams r103 = (KolBuyerShowParams) r102;
        if (r103 != null) goto L24;
        Serializable r104 = getIntent().getSerializableExtra("param_key");
        if ((r104 instanceof KolBuyerShowParams) == false) goto L23;
        r101 = r104;
    L23:
        r103 = (KolBuyerShowParams) r101;
    L24:
        if (r103 == null) goto L26;
        this.f165123m = r103.getTitleList();
        this.f165124n = r103.getProductId();
        r103.getEnterFrom();
        r103.getTrackParams();
        this.f165125o = r103.getLynxUrl();
    L26:
        this.f165120j = (ViewPager) findViewById(com.larus.nova.R.id.view_pager);
        this.f165121k = (TabLayout) findViewById(com.larus.nova.R.id.tab_layout);
        this.f165122l = (ImageView) findViewById(com.larus.nova.R.id.iv_back);
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        JSONArray r107 = z1.e(this.f165123m);
        if (r107 != null) goto L93;
    L46:
        ViewPager r108 = this.f165120j;
        if (r108 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L49:
        r108.setOffscreenPageLimit(0);
        ViewPager r109 = this.f165120j;
        if (r109 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L52:
        r109.setAdapter(new KolBuyerShowAdapter(getSupportFragmentManager(), r106));
        TabLayout r110 = this.f165121k;
        if (r110 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L55:
        ViewPager r111 = this.f165120j;
        if (r111 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L58:
        r110.setupWithViewPager(r111);
        Iterator r112 = r105.iterator();
        int r113 = 0;
    L60:
        if (r112.hasNext() == false) goto L71;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L64;
        CollectionsKt.throwIndexOverflow();
    L64:
        String r116 = (String) r114;
        TabLayout r117 = this.f165121k;
        if (r117 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L67:
        TabLayout.Tab r118 = r117.getTabAt(r113);
        if (r118 == null) goto L70;
        r118.setText(r116);
    L70:
        r113 = r115;
        goto L60
    L71:
        ImageView r119 = this.f165122l;
        if (r119 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("backIv");
    L74:
        r119.setOnClickListener(new m63.a(this));
        int r120 = r105.size();
        int r121 = 0;
    L75:
        if (r121 >= r120) goto L86;
        TabLayout r122 = this.f165121k;
        if (r122 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L79:
        TabLayout.Tab r123 = r122.getTabAt(r121);
        if (r123 == null) goto L85;
        if (r123.isSelected() == false) goto L84;
        z1(r123, 1);
        goto L85
    L84:
        z1(r123, 0);
    L85:
        r121 = r121 + 1;
        goto L75
    L86:
        TabLayout r124 = this.f165121k;
        if (r124 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L89:
        r124.addOnTabSelectedListener(new b(this, r106));
        return;
    L93:
        int r125 = r107.length();     // Catch: Throwable -> L45
        int r126 = 0;
    L29:
        if (r126 >= r125) goto L46;
        String r127 = r107.optString(r126, "");     // Catch: Throwable -> L45
        if (r127 == null) goto L44;
        int r128 = r127.hashCode();     // Catch: Throwable -> L45
        if (r128 == 106376) goto L42;
        if (r128 != 127969801) goto L44;
        if (r127.equals("buyer_show") == false) goto L44;
        r105.add("买家秀");     // Catch: Throwable -> L45
        int r129 = AnchorV3DualStreamFragment.f165032u;     // Catch: Throwable -> L45
        String r130 = this.f165124n;     // Catch: Throwable -> L45
        AnchorV3DualStreamFragment r131 = new AnchorV3DualStreamFragment();     // Catch: Throwable -> L45
        r131.f165041l = r130;     // Catch: Throwable -> L45
        r106.add(r131);     // Catch: Throwable -> L45
        goto L44
    L42:
        if (r127.equals("kol") == false) goto L44;
        r105.add("达人秀");     // Catch: Throwable -> L45
        int r132 = KolFragment.f165128g;     // Catch: Throwable -> L45
        String r133 = this.f165125o;     // Catch: Throwable -> L45
        KolFragment r134 = new KolFragment();     // Catch: Throwable -> L45
        r134.f165131f = r133;     // Catch: Throwable -> L45
        r106.add(r134);     // Catch: Throwable -> L45
    L44:
        r126 = r126 + 1;
        goto L29
    L13:
        r102 = null;
        goto L15
    }

    public static void z1(TabLayout.Tab r100, int r101) {
        CharSequence r102 = r100.getText();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        String r104 = String.valueOf(r100.getText());
        SpannableString r105 = new SpannableString(r104);
        r105.setSpan(new StyleSpan(r101), 0, r104.length(), 17);
        r100.setText(r105);
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
