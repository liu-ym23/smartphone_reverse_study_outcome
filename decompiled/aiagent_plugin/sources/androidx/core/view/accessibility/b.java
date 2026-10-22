package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f1433d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AccessibilityNodeInfo f1435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1436c;

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {
        public static final a A = null;
        public static final a B = null;
        public static final a C = null;
        public static final a D = null;
        public static final a E = null;
        public static final a F = null;
        public static final a G = null;
        public static final a H = null;
        public static final a I = null;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final a f1437J = null;
        public static final a K = null;
        public static final a L = null;
        public static final a M = null;
        public static final a N = null;
        public static final a O = null;
        public static final a P = null;
        public static final a Q = null;
        public static final a R = null;
        private static final String TAG = "A11yActionCompat";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1438a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1439b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f1440c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f1441d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f1442e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        public static final a k = null;
        public static final a l = null;
        public static final a m = null;
        public static final a n = null;
        public static final a o = null;
        public static final a p = null;
        public static final a q = null;
        public static final a r = null;
        public static final a s = null;
        public static final a t = null;
        public static final a u = null;
        public static final a v = null;
        public static final a w = null;
        public static final a x = null;
        public static final a y = null;
        public static final a z = null;
        final Object S;
        protected final androidx.core.view.accessibility.d T;
        private final int U;
        private final Class<? extends androidx.core.view.accessibility.d.a> V;

        static {
            AccessibilityNodeInfo.AccessibilityAction r2 = null;
            f1438a = new a(1, null);
            f1439b = new a(2, null);
            f1440c = new a(4, null);
            f1441d = new a(8, null);
            f1442e = new a(16, null);
            f = new a(32, null);
            g = new a(64, null);
            h = new a(128, null);
            i = new a(256, null, androidx.core.view.accessibility.d.b.class);
            j = new a(512, null, androidx.core.view.accessibility.d.b.class);
            k = new a(1024, null, androidx.core.view.accessibility.d.c.class);
            l = new a(2048, null, androidx.core.view.accessibility.d.c.class);
            m = new a(4096, null);
            n = new a(8192, null);
            o = new a(16384, null);
            p = new a(32768, null);
            q = new a(65536, null);
            r = new a(UiType.FLAG_PHONE_CARD, null, androidx.core.view.accessibility.d.g.class);
            s = new a(262144, null);
            t = new a(UiType.FLAG_WIFI_QRCODE_CARD, null);
            u = new a(1048576, null);
            v = new a(UiType.FLAG_REMOTE_CARD, null, androidx.core.view.accessibility.d.h.class);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        L6:
            w = new a(r6, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        L10:
            x = new a(r12, R.id.accessibilityActionScrollToPosition, null, null, androidx.core.view.accessibility.d.e.class);
            if (Build.VERSION.SDK_INT < 23) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        L14:
            y = new a(r7, R.id.accessibilityActionScrollUp, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L17;
            AccessibilityNodeInfo.AccessibilityAction r13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        L18:
            z = new a(r13, R.id.accessibilityActionScrollLeft, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L21;
            AccessibilityNodeInfo.AccessibilityAction r8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        L22:
            A = new a(r8, R.id.accessibilityActionScrollDown, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L25;
            AccessibilityNodeInfo.AccessibilityAction r14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        L26:
            B = new a(r14, R.id.accessibilityActionScrollRight, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L29;
            AccessibilityNodeInfo.AccessibilityAction r9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        L30:
            C = new a(r9, R.id.accessibilityActionPageUp, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L33;
            AccessibilityNodeInfo.AccessibilityAction r15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
        L34:
            D = new a(r15, R.id.accessibilityActionPageDown, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L37;
            AccessibilityNodeInfo.AccessibilityAction r10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        L38:
            E = new a(r10, R.id.accessibilityActionPageLeft, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L41;
            AccessibilityNodeInfo.AccessibilityAction r16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
        L42:
            F = new a(r16, R.id.accessibilityActionPageRight, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L45;
            AccessibilityNodeInfo.AccessibilityAction r11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        L46:
            G = new a(r11, R.id.accessibilityActionContextClick, null, null, null);
            if (Build.VERSION.SDK_INT < 24) goto L49;
            AccessibilityNodeInfo.AccessibilityAction r17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        L50:
            H = new a(r17, R.id.accessibilityActionSetProgress, null, null, androidx.core.view.accessibility.d.f.class);
            if (Build.VERSION.SDK_INT < 26) goto L53;
            AccessibilityNodeInfo.AccessibilityAction r4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        L54:
            I = new a(r4, R.id.accessibilityActionMoveWindow, null, null, androidx.core.view.accessibility.d.C0038d.class);
            if (Build.VERSION.SDK_INT < 28) goto L57;
            AccessibilityNodeInfo.AccessibilityAction r18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        L58:
            f1437J = new a(r18, R.id.accessibilityActionShowTooltip, null, null, null);
            if (Build.VERSION.SDK_INT < 28) goto L61;
            AccessibilityNodeInfo.AccessibilityAction r19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        L62:
            K = new a(r19, R.id.accessibilityActionHideTooltip, null, null, null);
            if (Build.VERSION.SDK_INT < 30) goto L65;
            AccessibilityNodeInfo.AccessibilityAction r5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
        L66:
            L = new a(r5, R.id.accessibilityActionPressAndHold, null, null, null);
            if (Build.VERSION.SDK_INT < 30) goto L69;
            AccessibilityNodeInfo.AccessibilityAction r110 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
        L70:
            M = new a(r110, R.id.accessibilityActionImeEnter, null, null, null);
            if (Build.VERSION.SDK_INT < 32) goto L73;
            AccessibilityNodeInfo.AccessibilityAction r20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        L74:
            N = new a(r20, R.id.accessibilityActionDragStart, null, null, null);
            if (Build.VERSION.SDK_INT < 32) goto L77;
            AccessibilityNodeInfo.AccessibilityAction r111 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
        L78:
            O = new a(r111, R.id.accessibilityActionDragDrop, null, null, null);
            if (Build.VERSION.SDK_INT < 32) goto L81;
            AccessibilityNodeInfo.AccessibilityAction r21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
        L82:
            P = new a(r21, R.id.accessibilityActionDragCancel, null, null, null);
            if (Build.VERSION.SDK_INT < 33) goto L85;
            AccessibilityNodeInfo.AccessibilityAction r112 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        L86:
            Q = new a(r112, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            if (Build.VERSION.SDK_INT < 34) goto L89;
            r2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        L89:
            R = new a(r2, R.id.accessibilityActionScrollInDirection, null, null, null);
            return;
        L85:
            r112 = null;
            goto L86
        L81:
            r21 = null;
            goto L82
        L77:
            r111 = null;
            goto L78
        L73:
            r20 = null;
            goto L74
        L69:
            r110 = null;
            goto L70
        L65:
            r5 = null;
            goto L66
        L61:
            r19 = null;
            goto L62
        L57:
            r18 = null;
            goto L58
        L53:
            r4 = null;
            goto L54
        L49:
            r17 = null;
            goto L50
        L45:
            r11 = null;
            goto L46
        L41:
            r16 = null;
            goto L42
        L37:
            r10 = null;
            goto L38
        L33:
            r15 = null;
            goto L34
        L29:
            r9 = null;
            goto L30
        L25:
            r14 = null;
            goto L26
        L21:
            r8 = null;
            goto L22
        L17:
            r13 = null;
            goto L18
        L13:
            r7 = null;
            goto L14
        L9:
            r12 = null;
            goto L10
        L5:
            r6 = null;
            goto L6
        }

        public a(int r7, CharSequence r8) {
            this(null, r7, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin"), null, null);
        }

        public a(int r9, CharSequence r10, androidx.core.view.accessibility.d r11) {
            this(null, r9, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin"), (androidx.core.view.accessibility.d) ZeusTransformUtils.wrapperContextForParams(r11, androidx.core.view.accessibility.d.class, "com.obric.aiagent.plugin"), null);
        }

        a(Object r7) {
            this(r7, 0, null, null, null);
        }

        private a(int r7, CharSequence r8, Class<? extends androidx.core.view.accessibility.d.a> r9) {
            this(null, r7, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin"), null, r9);
        }

        a(Object r3, int r4, CharSequence r5, androidx.core.view.accessibility.d r6, Class<? extends androidx.core.view.accessibility.d.a> r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            androidx.core.view.accessibility.d r9 = (androidx.core.view.accessibility.d) ZeusTransformUtils.wrapperContextForParams(r6, androidx.core.view.accessibility.d.class, "com.obric.aiagent.plugin");
            this.U = r4;
            this.T = r9;
            if (Build.VERSION.SDK_INT < 21) goto L6;
            if (r3 != null) goto L6;
            this.S = new AccessibilityNodeInfo.AccessibilityAction(r4, r8);
        L7:
            this.V = r7;
            return;
        L6:
            this.S = r3;
            goto L7
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(this.S, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.aiagent.plugin")).getId();
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return null;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(this.S, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.aiagent.plugin")).getLabel();
        }

        public boolean a(View r5, Bundle r6) {
            if (this.T == null) goto L19;
            androidx.core.view.accessibility.d.a r0 = null;
            Class<? extends androidx.core.view.accessibility.d.a> r2 = this.V;
            if (r2 == null) goto L18;
            androidx.core.view.accessibility.d.a r1 = (androidx.core.view.accessibility.d.a) ZeusTransformUtils.preCheckCast(r2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), androidx.core.view.accessibility.d.a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
            r1.a(r6);     // Catch: Exception -> L9
            r0 = r1;
        L9:
            e = e;
            r0 = r1;
        L12:
            Class<? extends androidx.core.view.accessibility.d.a> r3 = this.V;
            if (r3 != null) goto L15;
            String r4 = "null";
        L16:
            a(TAG, "Failed to execute command with argument class ViewCommandArgument: " + r4, e);
            goto L18
        L15:
            r4 = r3.getName();
        L11:
            e = e;
        L18:
            return this.T.a(r5, r0);
        L19:
            return false;
        }

        public a a(CharSequence r9, androidx.core.view.accessibility.d r10) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
            androidx.core.view.accessibility.d r6 = (androidx.core.view.accessibility.d) ZeusTransformUtils.wrapperContextForParams(r10, androidx.core.view.accessibility.d.class, "com.obric.aiagent.plugin");
            return new a(null, this.U, r5, r6, this.V);
        }

        public int hashCode() {
            Object r0 = this.S;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public boolean equals(Object r4) {
            if (r4 != null) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L8;
            return false;
        L8:
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
            Object r3 = this.S;
            if (r3 != null) goto L14;
            if (r5.S == null) goto L16;
            return false;
        L16:
            return true;
        L14:
            if (r3.equals(r5.S) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("AccessibilityActionCompat: ");
            String r1 = b.d(this.U);
            if (r1.equals("ACTION_UNKNOWN") == true) goto L5;
        L7:
            r0.append(r1);
            return r0.toString();
        L5:
            if (b() == null) goto L7;
            r1 = b().toString();
            goto L7
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.accessibility.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    private static class C0037b {
        public static Bundle a(AccessibilityNodeInfo r0) {
            return r0.getExtras();
        }

        public static Object a(int r0, float r1, float r2, float r3) {
            return AccessibilityNodeInfo.RangeInfo.obtain(r0, r1, r2, r3);
        }

        public static g a(int r1, int r2, int r3, int r4, boolean r5) {
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(r1, r2, r3, r4, r5));
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    private static class c {
        public static void a(AccessibilityNodeInfo r2, CharSequence r3) {
            r2.setStateDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        public static CharSequence a(AccessibilityNodeInfo r0) {
            return r0.getStateDescription();
        }

        public static Object a(int r1, float r2, float r3, float r4) {
            return new AccessibilityNodeInfo.RangeInfo(r1, r2, r3, r4);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    private static class d {
        public static AccessibilityNodeInfo.ExtraRenderingInfo a(AccessibilityNodeInfo r0) {
            return r0.getExtraRenderingInfo();
        }

        public static boolean b(AccessibilityNodeInfo r0) {
            return r0.isTextSelectable();
        }

        public static void a(AccessibilityNodeInfo r0, boolean r1) {
            r0.setTextSelectable(r1);
        }

        public static g a(boolean r2, int r3, int r4, int r5, int r6, boolean r7, String r8, String r9) {
            return new g(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(r2).setColumnIndex(r3).setRowIndex(r4).setColumnSpan(r5).setRowSpan(r6).setSelected(r7).setRowTitle(r8).setColumnTitle(r9).build());
        }

        public static b a(AccessibilityNodeInfo r0, int r1, int r2) {
            return b.a(r0.getChild(r1, r2));
        }

        public static b a(AccessibilityNodeInfo r0, int r1) {
            return b.a(r0.getParent(r1));
        }

        public static String c(AccessibilityNodeInfo r0) {
            return r0.getUniqueId();
        }

        public static void a(AccessibilityNodeInfo r0, String r1) {
            r0.setUniqueId(r1);
        }

        public static String a(Object r2) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(r2, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.aiagent.plugin")).getRowTitle();
        }

        public static String b(Object r2) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(r2, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.aiagent.plugin")).getColumnTitle();
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    private static class e {
        public static boolean a(AccessibilityNodeInfo r0) {
            return r0.isAccessibilityDataSensitive();
        }

        public static void a(AccessibilityNodeInfo r0, boolean r1) {
            r0.setAccessibilityDataSensitive(r1);
        }

        public static CharSequence b(AccessibilityNodeInfo r0) {
            return r0.getContainerTitle();
        }

        public static void a(AccessibilityNodeInfo r2, CharSequence r3) {
            r2.setContainerTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        public static void a(AccessibilityNodeInfo r0, Rect r1) {
            r0.getBoundsInWindow(r1);
        }

        public static void b(AccessibilityNodeInfo r0, Rect r1) {
            r0.setBoundsInWindow(r1);
        }

        public static boolean c(AccessibilityNodeInfo r0) {
            return r0.hasRequestInitialAccessibilityFocus();
        }

        public static void b(AccessibilityNodeInfo r0, boolean r1) {
            r0.setRequestInitialAccessibilityFocus(r1);
        }

        public static long d(AccessibilityNodeInfo r2) {
            return r2.getMinDurationBetweenContentChanges().toMillis();
        }

        public static void a(AccessibilityNodeInfo r0, long r1) {
            r0.setMinDurationBetweenContentChanges(Duration.ofMillis(r1));
        }

        public static void a(AccessibilityNodeInfo r0, View r1, boolean r2) {
            r0.setQueryFromAppProcessEnabled(r1, r2);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f1443a;

        public static f a(int r2, int r3, boolean r4, int r5) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return new f(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4, r5));
        L7:
            if (Build.VERSION.SDK_INT < 19) goto L11;
            return new f(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4));
        L11:
            return new f(null);
        }

        public static f a(int r2, int r3, boolean r4) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new f(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4));
        L7:
            return new f(null);
        }

        f(Object r1) {
            this.f1443a = r1;
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f1444a;

        public static g a(int r2, int r3, int r4, int r5, boolean r6, boolean r7) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6, r7));
        L7:
            if (Build.VERSION.SDK_INT < 19) goto L11;
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6));
        L11:
            return new g(null);
        }

        g(Object r1) {
            this.f1444a = r1;
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f1445a;

        public static h a(int r2, float r3, float r4, float r5) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new h(AccessibilityNodeInfo.RangeInfo.obtain(r2, r3, r4, r5));
        L7:
            return new h(null);
        }

        h(Object r1) {
            this.f1445a = r1;
        }

        public int getType() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) ZeusTransformUtils.preCheckCast(this.f1445a, AccessibilityNodeInfo.RangeInfo.class, "com.obric.aiagent.plugin")).getType();
        }
    }

    static {
    }

    static String d(int r1) {
        if (r1 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r1 == 2) goto L92;
        switch(r1) {
            case 4: goto L90;
            case 8: goto L88;
            case 16: goto L86;
            case 32: goto L84;
            case 64: goto L82;
            case 128: goto L80;
            case 256: goto L78;
            case 512: goto L76;
            case 1024: goto L74;
            case 2048: goto L72;
            case 4096: goto L70;
            case 8192: goto L68;
            case 16384: goto L66;
            case 32768: goto L64;
            case 65536: goto L62;
            case 131072: goto L60;
            case 262144: goto L58;
            case 524288: goto L56;
            case 2097152: goto L54;
            case 16908354: goto L52;
            case 16908382: goto L50;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 16908342: goto L48;
            case 16908343: goto L46;
            case 16908344: goto L44;
            case 16908345: goto L42;
            case 16908346: goto L40;
            case 16908347: goto L38;
            case 16908348: goto L36;
            case 16908349: goto L34;
            default: goto L8;
        };
    L8:
        switch(r1) {
            case 16908356: goto L32;
            case 16908357: goto L30;
            case 16908358: goto L28;
            case 16908359: goto L26;
            case 16908360: goto L24;
            case 16908361: goto L22;
            case 16908362: goto L20;
            default: goto L9;
        };
    L9:
        switch(r1) {
            case 16908372: goto L18;
            case 16908373: goto L16;
            case 16908374: goto L14;
            case 16908375: goto L12;
            default: goto L10;
        };
    L10:
        return "ACTION_UNKNOWN";
    L12:
        return "ACTION_DRAG_CANCEL";
    L14:
        return "ACTION_DRAG_DROP";
    L16:
        return "ACTION_DRAG_START";
    L18:
        return "ACTION_IME_ENTER";
    L20:
        return "ACTION_PRESS_AND_HOLD";
    L22:
        return "ACTION_PAGE_RIGHT";
    L24:
        return "ACTION_PAGE_LEFT";
    L26:
        return "ACTION_PAGE_DOWN";
    L28:
        return "ACTION_PAGE_UP";
    L30:
        return "ACTION_HIDE_TOOLTIP";
    L32:
        return "ACTION_SHOW_TOOLTIP";
    L34:
        return "ACTION_SET_PROGRESS";
    L36:
        return "ACTION_CONTEXT_CLICK";
    L38:
        return "ACTION_SCROLL_RIGHT";
    L40:
        return "ACTION_SCROLL_DOWN";
    L42:
        return "ACTION_SCROLL_LEFT";
    L44:
        return "ACTION_SCROLL_UP";
    L46:
        return "ACTION_SCROLL_TO_POSITION";
    L48:
        return "ACTION_SHOW_ON_SCREEN";
    L50:
        return "ACTION_SCROLL_IN_DIRECTION";
    L52:
        return "ACTION_MOVE_WINDOW";
    L54:
        return "ACTION_SET_TEXT";
    L56:
        return "ACTION_COLLAPSE";
    L58:
        return "ACTION_EXPAND";
    L60:
        return "ACTION_SET_SELECTION";
    L62:
        return "ACTION_CUT";
    L64:
        return "ACTION_PASTE";
    L66:
        return "ACTION_COPY";
    L68:
        return "ACTION_SCROLL_BACKWARD";
    L70:
        return "ACTION_SCROLL_FORWARD";
    L72:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
    L74:
        return "ACTION_NEXT_HTML_ELEMENT";
    L76:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    L78:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    L80:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    L82:
        return "ACTION_ACCESSIBILITY_FOCUS";
    L84:
        return "ACTION_LONG_CLICK";
    L86:
        return "ACTION_CLICK";
    L88:
        return "ACTION_CLEAR_SELECTION";
    L90:
        return "ACTION_SELECT";
    L92:
        return "ACTION_CLEAR_FOCUS";
    }

    @Deprecated
    public void C() {
    }

    static b a(Object r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return new b(r1);
    }

    @Deprecated
    public b(Object r3) {
        this.f1434a = -1;
        this.f1436c = -1;
        this.f1435b = (AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r3, AccessibilityNodeInfo.class, "com.obric.aiagent.plugin");
    }

    private b(AccessibilityNodeInfo r2) {
        this.f1434a = -1;
        this.f1436c = -1;
        this.f1435b = r2;
    }

    public static b a(AccessibilityNodeInfo r1) {
        return new b(r1);
    }

    public AccessibilityNodeInfo a() {
        return this.f1435b;
    }

    public static b a(View r0) {
        return a(AccessibilityNodeInfo.obtain(r0));
    }

    public static b b() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public static b a(b r0) {
        return a(AccessibilityNodeInfo.obtain(r0.f1435b));
    }

    public void b(View r2) {
        this.f1436c = -1;
        this.f1435b.setSource(r2);
    }

    public void a(View r3, int r4) {
        this.f1436c = r4;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.f1435b.setSource(r3, r4);
        return;
    }

    public int c() {
        return this.f1435b.getChildCount();
    }

    public void c(View r1) {
        this.f1435b.addChild(r1);
    }

    public void b(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.f1435b.addChild(r3, r4);
        return;
    }

    @Deprecated
    public int d() {
        return this.f1435b.getActions();
    }

    public void a(int r1) {
        this.f1435b.addAction(r1);
    }

    private List<Integer> a(String r3) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        ArrayList<Integer> r0 = C0037b.a(this.f1435b).getIntegerArrayList(r3);
        if (r0 != null) goto L10;
        ArrayList<Integer> r1 = new ArrayList();
        C0037b.a(this.f1435b).putIntegerArrayList(r3, r1);
        return r1;
    L10:
        return r0;
    L5:
        return new ArrayList();
    }

    public void a(a r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.f1435b.addAction((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(r3.S, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.aiagent.plugin"));
        return;
    }

    public boolean b(a r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.f1435b.removeAction((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(r3.S, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.aiagent.plugin"));
    }

    public boolean a(int r3, Bundle r4) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.f1435b.performAction(r3, r4);
    }

    public void b(int r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.f1435b.setMovementGranularities(r3);
        return;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return this.f1435b.getMovementGranularities();
    }

    public void d(View r2) {
        this.f1434a = -1;
        this.f1435b.setParent(r2);
    }

    public void c(View r3, int r4) {
        this.f1434a = r4;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.f1435b.setParent(r3, r4);
        return;
    }

    @Deprecated
    public void a(Rect r1) {
        this.f1435b.getBoundsInParent(r1);
    }

    @Deprecated
    public void b(Rect r1) {
        this.f1435b.setBoundsInParent(r1);
    }

    public void c(Rect r1) {
        this.f1435b.getBoundsInScreen(r1);
    }

    public void d(Rect r1) {
        this.f1435b.setBoundsInScreen(r1);
    }

    public void e(Rect r4) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        e.a(this.f1435b, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L12;
        Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(C0037b.a(this.f1435b).getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY"), Rect.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L13;
        r4.set(r3.left, r3.top, r3.right, r3.bottom);
        return;
    L13:
        return;
    }

    public boolean f() {
        return this.f1435b.isCheckable();
    }

    public void a(boolean r1) {
        this.f1435b.setCheckable(r1);
    }

    public boolean g() {
        return this.f1435b.isChecked();
    }

    public void b(boolean r1) {
        this.f1435b.setChecked(r1);
    }

    public boolean h() {
        return this.f1435b.isFocusable();
    }

    public void c(boolean r1) {
        this.f1435b.setFocusable(r1);
    }

    public boolean i() {
        return this.f1435b.isFocused();
    }

    public void d(boolean r1) {
        this.f1435b.setFocused(r1);
    }

    public boolean j() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.f1435b.isVisibleToUser();
    }

    public void e(boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.f1435b.setVisibleToUser(r3);
        return;
    }

    public boolean k() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.f1435b.isAccessibilityFocused();
    }

    public void f(boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.f1435b.setAccessibilityFocused(r3);
        return;
    }

    public boolean l() {
        return this.f1435b.isSelected();
    }

    public void g(boolean r1) {
        this.f1435b.setSelected(r1);
    }

    public boolean m() {
        return this.f1435b.isClickable();
    }

    public void h(boolean r1) {
        this.f1435b.setClickable(r1);
    }

    public boolean n() {
        return this.f1435b.isLongClickable();
    }

    public void i(boolean r1) {
        this.f1435b.setLongClickable(r1);
    }

    public boolean o() {
        return this.f1435b.isEnabled();
    }

    public void j(boolean r1) {
        this.f1435b.setEnabled(r1);
    }

    public boolean p() {
        return this.f1435b.isPassword();
    }

    public boolean q() {
        return this.f1435b.isScrollable();
    }

    public void k(boolean r1) {
        this.f1435b.setScrollable(r1);
    }

    public boolean r() {
        return e(67108864);
    }

    public boolean s() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return d.b(this.f1435b);
    L7:
        return e(UiType.FLAG_APPLET_CARD);
    }

    public boolean t() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return this.f1435b.isImportantForAccessibility();
    }

    public boolean u() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return e.a(this.f1435b);
    L7:
        return e(64);
    }

    public CharSequence v() {
        return this.f1435b.getPackageName();
    }

    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f1435b.setPackageName(r4);
    }

    public CharSequence w() {
        return this.f1435b.getClassName();
    }

    public void b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f1435b.setClassName(r4);
    }

    public CharSequence x() {
        if (L() == false) goto L10;
        List<Integer> r0 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> r1 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> r2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> r3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        int r7 = 0;
        SpannableString r4 = new SpannableString(TextUtils.substring(this.f1435b.getText(), 0, this.f1435b.getText().length()));
    L6:
        if (r7 >= r0.size()) goto L8;
        r4.setSpan(new AccessibilityClickableSpanCompat(((Integer) ZeusTransformUtils.preCheckCast(r3.get(r7), Integer.class, "com.obric.aiagent.plugin")).intValue(), this, H().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r7), Integer.class, "com.obric.aiagent.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(r1.get(r7), Integer.class, "com.obric.aiagent.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(r2.get(r7), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r7 = r7 + 1;
        goto L6
    L8:
        return r4;
    L10:
        return this.f1435b.getText();
    }

    public void c(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f1435b.setText(r4);
    }

    public void a(CharSequence r7, View r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L18;
        M();
        i(r8);
        ClickableSpan[] r0 = d(r9);
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.length <= 0) goto L20;
        H().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.accessibility_action_clickable_span, DbHelper.COL_ID, "accessibility_action_clickable_span"));
        SparseArray<WeakReference<ClickableSpan>> r10 = g(r8);
        int r2 = 0;
    L11:
        if (r0 == null) goto L21;
        if (r2 >= r0.length) goto L22;
        int r3 = a(r0[r2], r10);
        r10.put(r3, new WeakReference(r0[r2]));
        a(r0[r2], (Spanned) ZeusTransformUtils.preCheckCast(r9, Spanned.class, "com.obric.aiagent.plugin"), r3);
        r2 = r2 + 1;
        goto L11
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    private SparseArray<WeakReference<ClickableSpan>> g(View r4) {
        SparseArray<WeakReference<ClickableSpan>> r3 = h(r4);
        if (r3 != null) goto L6;
        SparseArray<WeakReference<ClickableSpan>> r5 = new SparseArray();
        r4.setTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tag_accessibility_clickable_spans, DbHelper.COL_ID, "tag_accessibility_clickable_spans"), r5);
        return r5;
    L6:
        return r3;
    }

    private SparseArray<WeakReference<ClickableSpan>> h(View r3) {
        return (SparseArray) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tag_accessibility_clickable_spans, DbHelper.COL_ID, "tag_accessibility_clickable_spans")), SparseArray.class, "com.obric.aiagent.plugin");
    }

    public static ClickableSpan[] d(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == true) goto L5;
        return null;
    L5:
        return (ClickableSpan[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.aiagent.plugin")).getSpans(0, r5.length(), ClickableSpan.class), ClickableSpan[].class, "com.obric.aiagent.plugin");
    }

    private int a(ClickableSpan r4, SparseArray<WeakReference<ClickableSpan>> r5) {
        if (r5 == null) goto L11;
        int r3 = 0;
    L5:
        if (r3 >= r5.size()) goto L11;
        if (r4.equals((ClickableSpan) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r5.valueAt(r3), WeakReference.class, "com.obric.aiagent.plugin")).get(), ClickableSpan.class, "com.obric.aiagent.plugin")) == true) goto L9;
        r3 = r3 + 1;
        goto L5
    L9:
        return r5.keyAt(r3);
    L11:
        int r6 = f1433d;
        f1433d = r6 + 1;
        return r6;
    }

    private boolean L() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void M() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        C0037b.a(this.f1435b).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        C0037b.a(this.f1435b).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        C0037b.a(this.f1435b).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        C0037b.a(this.f1435b).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        return;
    }

    private void a(ClickableSpan r3, Spanned r4, int r5) {
        Spanned r6 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.aiagent.plugin");
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(r6.getSpanStart(r3)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(r6.getSpanEnd(r3)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(r6.getSpanFlags(r3)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(r5));
    }

    private void i(View r6) {
        SparseArray<WeakReference<ClickableSpan>> r5 = h(r6);
        if (r5 == null) goto L14;
        ArrayList r7 = new ArrayList();
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r1 >= r5.size()) goto L12;
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r5.valueAt(r1), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L10;
        r7.add(Integer.valueOf(r1));
    L10:
        r1 = r1 + 1;
    L12:
        if (r0 >= r7.size()) goto L19;
        r5.remove(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L12
    L19:
        return;
    }

    public CharSequence y() {
        return this.f1435b.getContentDescription();
    }

    public CharSequence z() {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return c.a(this.f1435b);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return C0037b.a(this.f1435b).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void e(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f1435b.setContentDescription(r4);
    }

    public void f(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        c.a(this.f1435b, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        C0037b.a(this.f1435b).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", r4);
        return;
    }

    public String A() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return d.c(this.f1435b);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return C0037b.a(this.f1435b).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public CharSequence B() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return e.b(this.f1435b);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return C0037b.a(this.f1435b).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public String D() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return null;
    L5:
        return this.f1435b.getViewIdResourceName();
    }

    public void b(Object r3) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r2 = this.f1435b;
        if (r3 != null) goto L7;
        AccessibilityNodeInfo.CollectionInfo r4 = null;
    L8:
        r2.setCollectionInfo(r4);
        return;
    L7:
        r4 = (AccessibilityNodeInfo.CollectionInfo) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin")).f1443a, AccessibilityNodeInfo.CollectionInfo.class, "com.obric.aiagent.plugin");
        goto L8
    }

    public void c(Object r3) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r2 = this.f1435b;
        if (r3 != null) goto L7;
        AccessibilityNodeInfo.CollectionItemInfo r4 = null;
    L8:
        r2.setCollectionItemInfo(r4);
        return;
    L7:
        r4 = (AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).f1444a, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.aiagent.plugin");
        goto L8
    }

    public void a(h r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.f1435b.setRangeInfo((AccessibilityNodeInfo.RangeInfo) ZeusTransformUtils.preCheckCast(r3.f1445a, AccessibilityNodeInfo.RangeInfo.class, "com.obric.aiagent.plugin"));
        return;
    }

    public List<a> E() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        List<AccessibilityNodeInfo.AccessibilityAction> r5 = this.f1435b.getActionList();
    L6:
        if (r5 == null) goto L12;
        ArrayList r0 = new ArrayList();
        int r1 = r5.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L10;
        r0.add(new a(r5.get(r2)));
        r2 = r2 + 1;
        goto L8
    L10:
        return r0;
    L12:
        return Collections.emptyList();
    L5:
        r5 = null;
        goto L6
    }

    public boolean F() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return this.f1435b.isContextClickable();
    }

    public void g(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.f1435b.setHintText(r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        C0037b.a(this.f1435b).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", r4);
        return;
    }

    public void h(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.f1435b.setError(r4);
        return;
    }

    public CharSequence G() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return this.f1435b.getError();
    }

    public void e(View r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.f1435b.setLabelFor(r3);
        return;
    }

    public void l(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.f1435b.setCanOpenPopup(r3);
        return;
    }

    public Bundle H() {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return C0037b.a(this.f1435b);
    L7:
        return new Bundle();
    }

    public void c(int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.f1435b.setMaxTextLength(r3);
        return;
    }

    public int I() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return this.f1435b.getMaxTextLength();
    }

    public void f(View r3) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.f1435b.setTraversalAfter(r3);
        return;
    }

    public void m(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.f1435b.setDismissable(r3);
        return;
    }

    public CharSequence J() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.f1435b.getTooltipText();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return C0037b.a(this.f1435b).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void i(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.f1435b.setPaneTitle(r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        C0037b.a(this.f1435b).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", r4);
        return;
    }

    public void n(boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.f1435b.setScreenReaderFocusable(r3);
        return;
    L5:
        a(1, r3);
    }

    public boolean K() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.f1435b.isShowingHintText();
    L7:
        return e(4);
    }

    public void o(boolean r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.f1435b.setShowingHintText(r3);
        return;
    L5:
        a(4, r3);
    }

    public void p(boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.f1435b.setHeading(r3);
        return;
    L5:
        a(2, r3);
    }

    public void j(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L6;
        C0037b.a(this.f1435b).putCharSequence("AccessibilityNodeInfo.roleDescription", r4);
        return;
    }

    public int hashCode() {
        AccessibilityNodeInfo r0 = this.f1435b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L11;
        return false;
    L11:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        AccessibilityNodeInfo r0 = this.f1435b;
        if (r0 != null) goto L17;
        if (r6.f1435b == null) goto L20;
        return false;
    L20:
        if (this.f1436c == r6.f1436c) goto L23;
        return false;
    L23:
        if (this.f1434a == r6.f1434a) goto L25;
        return false;
    L25:
        return true;
    L17:
        if (r0.equals(r6.f1435b) == true) goto L20;
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        Rect r1 = new Rect();
        a(r1);
        r0.append("; boundsInParent: " + r1);
        c(r1);
        r0.append("; boundsInScreen: " + r1);
        e(r1);
        r0.append("; boundsInWindow: " + r1);
        r0.append("; packageName: ").append(v());
        r0.append("; className: ").append(w());
        r0.append("; text: ").append(x());
        r0.append("; error: ").append(G());
        r0.append("; maxTextLength: ").append(I());
        r0.append("; stateDescription: ").append(z());
        r0.append("; contentDescription: ").append(y());
        r0.append("; tooltipText: ").append(J());
        r0.append("; viewIdResName: ").append(D());
        r0.append("; uniqueId: ").append(A());
        r0.append("; checkable: ").append(f());
        r0.append("; checked: ").append(g());
        r0.append("; focusable: ").append(h());
        r0.append("; focused: ").append(i());
        r0.append("; selected: ").append(l());
        r0.append("; clickable: ").append(m());
        r0.append("; longClickable: ").append(n());
        r0.append("; contextClickable: ").append(F());
        r0.append("; enabled: ").append(o());
        r0.append("; password: ").append(p());
        r0.append("; scrollable: " + q());
        r0.append("; containerTitle: ").append(B());
        r0.append("; granularScrollingSupported: ").append(r());
        r0.append("; importantForAccessibility: ").append(t());
        r0.append("; visible: ").append(j());
        r0.append("; isTextSelectable: ").append(s());
        r0.append("; accessibilityDataSensitive: ").append(u());
        r0.append("; [");
        if (Build.VERSION.SDK_INT < 21) goto L16;
        List<a> r7 = E();
        int r2 = 0;
    L6:
        if (r2 >= r7.size()) goto L21;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r7.get(r2), a.class, "com.obric.aiagent.plugin");
        String r5 = d(r4.a());
        if (r5.equals("ACTION_UNKNOWN") == true) goto L10;
    L12:
        r0.append(r5);
        if (r2 == (r7.size() - 1)) goto L15;
        r0.append(", ");
    L15:
        r2 = r2 + 1;
        goto L6
    L10:
        if (r4.b() == null) goto L12;
        r5 = r4.b().toString();
    L21:
        r0.append("]");
        return r0.toString();
    L16:
        int r8 = d();
    L17:
        if (r8 == 0) goto L21;
        int r3 = 1 << Integer.numberOfTrailingZeros(r8);
        r8 = r8 & (~r3);
        r0.append(d(r3));
        if (r8 == 0) goto L17;
        r0.append(", ");
        goto L17
    }

    private void a(int r5, boolean r6) {
        Bundle r4 = H();
        if (r4 == null) goto L10;
        int r2 = r4.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~r5);
        if (r6 == true) goto L8;
        r5 = 0;
    L8:
        r4.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", r5 | r2);
        return;
    }

    private boolean e(int r3) {
        Bundle r2 = H();
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((r2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & r3) != r3) goto L9;
        return true;
    L9:
        return false;
    }
}
