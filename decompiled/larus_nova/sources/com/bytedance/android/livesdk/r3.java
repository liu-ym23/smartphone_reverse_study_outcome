package com.bytedance.android.livesdk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.larus.nova.R;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f156924a = 0;

    public static final class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f156925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function0<String> f156926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f156927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f156928d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f156929e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f156930f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f156931g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f156932h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final View f156933i;

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean dispatchPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            Intrinsics.checkNotNullParameter(r100, "host");
            Intrinsics.checkNotNullParameter(r101, "event");
            return false;
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f156933i = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "host");
            Intrinsics.checkNotNullParameter(r101, "info");
            super.onInitializeAccessibilityNodeInfo(r100, r101);     // Catch: Exception -> L41
            Function0<String> r102 = this.f156926b;     // Catch: Exception -> L41
            if (r102 == null) goto L7;
            String r103 = r102.invoke();     // Catch: Exception -> L41
            if (r103 == null) goto L7;
        L8:
            boolean r104 = false;
            if (r103 != null) goto L11;
        L16:
            String r105 = this.f156927c;     // Catch: Exception -> L41
            if (r105 != null) goto L19;
        L24:
            String r106 = this.f156928d;     // Catch: Exception -> L41
            if (r106 != null) goto L27;
        L31:
            String r107 = this.f156929e;     // Catch: Exception -> L41
            if (r107 == null) goto L35;
            r101.setClassName(r107);     // Catch: Exception -> L41
        L35:
            if (this.f156931g == false) goto L38;
            r101.setSelected(this.f156930f);     // Catch: Exception -> L41
        L38:
            if (this.f156932h == false) goto L46;
            r101.setHeading(true);     // Catch: Exception -> L41
            return;
        L46:
            return;
        L27:
            if (r106.length() <= 0) goto L29;
            r104 = true;
        L29:
            if (r104 != true) goto L31;
            r101.setHintText(this.f156928d);     // Catch: Exception -> L41
            goto L31
        L19:
            if (r105.length() <= 0) goto L21;
            boolean r108 = true;
        L22:
            if (r108 != true) goto L24;
            r101.setRoleDescription(this.f156927c);     // Catch: Exception -> L41
            goto L24
        L21:
            r108 = false;
            goto L22
        L11:
            if (r103.length() <= 0) goto L13;
            boolean r109 = true;
        L14:
            if (r109 != true) goto L16;
            r101.setContentDescription(r103);     // Catch: Exception -> L41
            goto L16
        L13:
            r109 = false;
        L7:
            r103 = this.f156925a;     // Catch: Exception -> L41
        L41:
            e = move-exception;
            int r110 = r3.f156924a;
            ALogger.e("AccessibilityError", "exception is " + e.toString());
            ALogger.e("AccessibilityError", "view is " + this.f156933i.getId() + ", content is " + this.f156925a + ", roleDesc is " + this.f156927c);
            SafetyGuard.a("AccessibilityError", e, "AccessibilityError");
        }
    }

    static {
    }

    public static void h(ViewGroup r100) {
        final StringBuilder r101 = new StringBuilder();
        new LiveAccessibilityHelper$combineAllChildDescription$1(r101).invoke2(r100);
        r100.setImportantForAccessibility(1);
        a(r100, r101.toString());
    }

    @JvmStatic
    public static final AccessibilityManager j(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = r100.getSystemService("accessibility");
        if (r101 == null) goto L10;
        return (AccessibilityManager) r101;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    }

    @JvmStatic
    public static final void k(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r100).setImportantForAccessibility(4);
        return;
    L7:
        r100.setImportantForAccessibility(2);
    }

    @JvmStatic
    public static final boolean l(Context r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getSystemService("accessibility");
    L7:
        if ((r102 instanceof AccessibilityManager) == false) goto L10;
        r101 = r102;
    L10:
        AccessibilityManager r103 = (AccessibilityManager) r101;
        if (r103 != null) goto L15;
        return false;
    L15:
        return r103.isTouchExplorationEnabled();
    L5:
        r102 = null;
        goto L7
    }

    @JvmStatic
    public static final void n(View r100) {
        if (r100 == null) goto L5;
        r100.setContentDescription("");
        ViewCompat.setImportantForAccessibility(r100, 2);
        return;
    }

    @JvmStatic
    public static final void p(View r100) {
        if (r100 == null) goto L5;
        r100.sendAccessibilityEvent(128);
        Unit r101 = Unit.INSTANCE;
        return;
    }

    @JvmStatic
    public static final void a(View r100, String r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        a r102 = new a(r100);
        r102.f156925a = r101;
        r102.f156927c = null;
        ViewCompat.setAccessibilityDelegate(r100, r102);
        return;
    L8:
        return;
    }

    @JvmStatic
    public static final void e(View r100, AccessibilityDelegateCompat r101) {
        if (r100 == null) goto L5;
        ViewCompat.setAccessibilityDelegate(r100, r101);
        return;
    }

    @JvmStatic
    public static final void f(Context r100, AccessibilityManagerCompat.TouchExplorationStateChangeListener r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        AccessibilityManager r102 = j(r100);
        if (r102 == null) goto L6;
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(r102, r101);
        return;
    }

    @JvmStatic
    public static final void g(View r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$announceForAccessibilityCompat");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r100.setAccessibilityPaneTitle(r101);
        return;
    L5:
        r100.announceForAccessibility(r101);
    }

    @JvmStatic
    public static final void i(View r100, ToolbarButton r101) {
        if (r100 == null) goto L49;
        if (r101 == null) goto L79;
        Resources r102 = r100.getContext().getResources();
        int r103 = s3.f157857a[r101.ordinal()];
        int r104 = R.string.ttlive_interact_play;
        int r105 = R.string.ttlive_interact_play_audience;
        switch(r103) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L43;
            case 6: goto L42;
            case 7: goto L42;
            case 8: goto L41;
            case 9: goto L38;
            case 10: goto L34;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L29;
            case 15: goto L28;
            case 16: goto L27;
            case 17: goto L26;
            case 18: goto L25;
            case 19: goto L24;
            case 20: goto L23;
            case 21: goto L22;
            case 22: goto L21;
            case 23: goto L20;
            case 24: goto L19;
            case 25: goto L18;
            case 26: goto L17;
            case 27: goto L16;
            case 28: goto L15;
            case 29: goto L11;
            case 30: goto L9;
            case 31: goto L8;
            default: goto L80;
        };
    L8:
        c(r100, r102.getString(R.string.ttlive_live_attack_and_defense), true);
        return;
    L9:
        c(r100, r102.getString(R.string.ttlive_exit_full_video), true);
        return;
    L15:
        c(r100, r102.getString(R.string.ttlive_mini_app), true);
        return;
    L16:
        c(r100, r102.getString(R.string.ttlive_a11y_game_cast_screen_btn), true);
        return;
    L17:
        c(r100, r102.getString(R.string.ttlive_a11y_barrage_setting_btn), true);
        return;
    L18:
        c(r100, r102.getString(R.string.ttlive_a11y_like_feedback_btn), true);
        return;
    L19:
        c(r100, r102.getString(R.string.ttlive_a11y_gift_consumer_toast_btn), true);
        return;
    L20:
        c(r100, r102.getString(R.string.ttlive_a11y_dislike_btn), true);
        return;
    L21:
        c(r100, r102.getString(R.string.ttlive_a11y_report_btn), true);
        return;
    L22:
        c(r100, r102.getString(R.string.ttlive_a11y_interactive_btn), true);
        return;
    L23:
        c(r100, r102.getString(R.string.ttlive_a11y_resolution_btn), true);
        return;
    L24:
        c(r100, r102.getString(R.string.ttlive_a11y_play_setting_btn), true);
        return;
    L25:
        c(r100, r102.getString(R.string.ttlive_a11y_clear_screen_btn), true);
        return;
    L26:
        c(r100, r102.getString(R.string.ttlive_a11y_gift_effect_btn), true);
        return;
    L27:
        c(r100, r102.getString(R.string.ttlive_a11y_dou_plus_promote_audience_btn), true);
        return;
    L28:
        c(r100, r102.getString(R.string.ttlive_a11y_toolbar_screen_shot), true);
        return;
    L29:
        c(r100, r102.getString(R.string.ttlive_a11y_toolbar_activity), true);
        return;
    L30:
        c(r100, r102.getString(R.string.ttlive_a11y_toolbar_share_btn), true);
        return;
    L31:
        c(r100, r102.getString(R.string.ttlive_vr_mode), true);
        return;
    L32:
        c(r100, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_interact_play_audience), true);
        return;
    L41:
        c(r100, r102.getString(R.string.ttlive_a11y_broadcast_interaction_game), true);
        return;
    L42:
        c(r100, r102.getString(R.string.ttlive_a11y_broadcast_interaction), true);
        return;
    L43:
        c(r100, r102.getString(R.string.ttlive_a11y_close_living), true);
        return;
    L44:
        c(r100, r102.getString(R.string.ttlive_a11y_broadcast_effect), true);
        return;
    L45:
        c(r100, r102.getString(R.string.ttlive_a11y_pk), true);
        return;
    L46:
        c(r100, r102.getString(R.string.ttlive_a11y_toolbar_gift), true);
        return;
    L47:
        a(r100, r102.getString(R.string.ttlive_a11y_toolbar_more_btn));
        return;
    L80:
        return;
    L11:
        if (LiveOpenFeatureChooseConfig.useV3() == true) goto L14;
        r105 = R.string.ttlive_mini_game;
    L14:
        c(r100, r102.getString(r105), true);
        return;
    L34:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L36;
        r104 = R.string.ttlive_interact_play_audience;
    L36:
        c(r100, com.bytedance.android.live.core.utils.s1.B(r104), true);
        return;
    L38:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L40;
        r104 = R.string.ttlive_interact_play_audience;
    L40:
        c(r100, com.bytedance.android.live.core.utils.s1.B(r104), true);
        return;
    L79:
        return;
    }

    @JvmStatic
    public static final void m(Map<String, String> r100, Context r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (l(r101) == false) goto L6;
        String r102 = "1";
    L7:
        r100.put("is_from_read", r102);
        return;
    L6:
        r102 = "0";
        goto L7
    }

    @JvmStatic
    public static final void o(Context r100, AccessibilityManagerCompat.TouchExplorationStateChangeListener r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        AccessibilityManager r102 = j(r100);
        if (r102 == null) goto L6;
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(r102, r101);
        return;
    }

    @Deprecated(message = "Android 16以后，对 TYPE_ANNOUNCEMENT 不再保障生效，新增场景不要再使用此方法，优先参考：https://bytedance.larkoffice.com/wiki/SGxLwaETuiDKVpkkS3AceBCtn6g「废弃干扰性无障碍功能播报」章节")
    @JvmStatic
    public static final void q(Context r100, String r101) {
        if (r100 == null) goto L21;
        if (r101 != null) goto L6;
        return;
    L6:
        if (l(r100) == true) goto L9;
        return;
    L9:
        if (n.f153991a.getValue().booleanValue() == false) goto L11;
        com.bytedance.android.live.core.utils.f2.c(r101, 0);
        return;
    L11:
        AccessibilityEvent r102 = AccessibilityEvent.obtain();
        if (r102 != null) goto L14;
        return;
    L14:
        r102.setEventType(16384);
        List<CharSequence> r103 = r102.getText();
        if (r103 == null) goto L17;
        r103.add(r101);
    L17:
        AccessibilityManager r104 = j(r100);
        if (r104 == null) goto L23;
        r104.sendAccessibilityEvent(r102);
        return;
    L23:
        return;
    }

    @JvmStatic
    public static final void b(View r100, String r101, Class<?> r102) {
        Intrinsics.checkNotNullParameter(r102, "overrideClass");
        if (r100 != null) goto L5;
        return;
    L5:
        a r103 = new a(r100);
        r103.f156925a = r101;
        r103.f156929e = r102.getName();
        ViewCompat.setAccessibilityDelegate(r100, r103);
    }

    @JvmStatic
    public static final void c(View r100, String r101, boolean r102) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        a r103 = new a(r100);
        r103.f156925a = r101;
        if (r102 == false) goto L8;
        r103.f156929e = Button.class.getName();
    L8:
        ViewCompat.setAccessibilityDelegate(r100, r103);
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void d(View r100, String r101, boolean r102, boolean r103) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        a r104 = new a(r100);
        r104.f156925a = r101;
        r104.f156930f = r102;
        r104.f156931g = true;
        if (r103 == false) goto L8;
        r104.f156929e = Button.class.getName();
    L8:
        ViewCompat.setAccessibilityDelegate(r100, r104);
        return;
    L11:
        return;
    }
}
