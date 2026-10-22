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
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.p;
import androidx.core.os.BuildCompat;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f2734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2736c;

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
        public static final a f2737J = null;
        public static final a K = null;
        public static final a L = null;
        public static final a M = null;
        public static final a N = null;
        public static final a O = null;
        public static final a P = null;
        public static final a Q = null;
        public static final a R = null;
        public static final a S = null;
        public static final a T = null;
        public static final a U = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f2738e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f2739f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f2740g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f2741h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f2742i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f2743j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f2744k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f2745l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f2746m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f2747n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f2748o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f2749p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f2750q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f2751r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f2752s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f2753t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f2754u = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f2755v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f2756w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f2757x = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f2758y = null;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f2759z = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class f2762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AccessibilityViewCommand f2763d;

        static {
            AccessibilityNodeInfo.AccessibilityAction r10 = null;
            f2738e = new a(1, null);
            f2739f = new a(2, null);
            f2740g = new a(4, null);
            f2741h = new a(8, null);
            f2742i = new a(16, null);
            f2743j = new a(32, null);
            f2744k = new a(64, null);
            f2745l = new a(128, null);
            f2746m = new a(256, null, AccessibilityViewCommand.b.class);
            f2747n = new a(512, null, AccessibilityViewCommand.b.class);
            f2748o = new a(1024, null, AccessibilityViewCommand.c.class);
            f2749p = new a(2048, null, AccessibilityViewCommand.c.class);
            f2750q = new a(4096, null);
            f2751r = new a(8192, null);
            f2752s = new a(16384, null);
            f2753t = new a(UiType.FLAG_SETTINGS_CARD, null);
            f2754u = new a(65536, null);
            f2755v = new a(UiType.FLAG_PHONE_CARD, null, AccessibilityViewCommand.g.class);
            f2756w = new a(UiType.FLAG_TIMER_CARD, null);
            f2757x = new a(UiType.FLAG_WIFI_QRCODE_CARD, null);
            f2758y = new a(UiType.FLAG_APP_CHOOSER_CARD, null);
            f2759z = new a(UiType.FLAG_REMOTE_CARD, null, AccessibilityViewCommand.h.class);
            int r11 = Build.VERSION.SDK_INT;
            A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.e.class);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            G = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
            H = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
            I = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
            f2737J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
            K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.f.class);
            M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.d.class);
            N = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            O = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
            P = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);
            if (r11 < 32) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        L6:
            R = new a(r12, R.id.accessibilityActionDragStart, null, null, null);
            if (r11 < 32) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
        L10:
            S = new a(r13, R.id.accessibilityActionDragDrop, null, null, null);
            if (r11 < 32) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
        L14:
            T = new a(r14, R.id.accessibilityActionDragCancel, null, null, null);
            if (r11 < 33) goto L17;
            r10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        L17:
            U = new a(r10, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            return;
        L13:
            r14 = null;
            goto L14
        L9:
            r13 = null;
            goto L10
        L5:
            r12 = null;
            goto L6
        }

        public a(int r10, CharSequence r11) {
            this(null, r10, r11, null, null);
        }

        public a a(CharSequence r10, AccessibilityViewCommand r11) {
            return new a(null, this.f2761b, r10, r11, this.f2762c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f2760a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f2760a).getLabel();
        }

        public boolean d(View r10, Bundle r11) {
            if (this.f2763d == null) goto L17;
            Class r12 = this.f2762c;
            if (r12 == null) goto L16;
            p.a(r12.getDeclaredConstructor(null).newInstance(null));     // Catch: Exception -> L9
            throw null;     // Catch: Exception -> L9
        L9:
            e = move-exception;
            Class r13 = this.f2762c;
            if (r13 != null) goto L13;
            String r14 = "null";
        L14:
            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + r14, e);
            goto L16
        L13:
            r14 = r13.getName();
        L16:
            return this.f2763d.perform(r10, null);
        L17:
            return false;
        }

        public boolean equals(Object r10) {
            if (r10 != null) goto L6;
            return false;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            Object r12 = this.f2760a;
            if (r12 != null) goto L14;
            if (r11.f2760a == null) goto L16;
            return false;
        L16:
            return true;
        L14:
            if (r12.equals(r11.f2760a) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public int hashCode() {
            Object r10 = this.f2760a;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.hashCode();
        }

        public a(int r10, CharSequence r11, AccessibilityViewCommand r12) {
            this(null, r10, r11, r12, null);
        }

        public a(Object r10) {
            this(r10, 0, null, null, null);
        }

        public a(int r10, CharSequence r11, Class r12) {
            this(null, r10, r11, null, r12);
        }

        public a(Object r10, int r11, CharSequence r12, AccessibilityViewCommand r13, Class r14) {
            this.f2761b = r11;
            this.f2763d = r13;
            if (r10 != null) goto L5;
            this.f2760a = new AccessibilityNodeInfo.AccessibilityAction(r11, r12);
        L6:
            this.f2762c = r14;
            return;
        L5:
            this.f2760a = r10;
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2764a;

        public b(Object r10) {
            this.f2764a = r10;
        }

        public static b a(int r10, int r11, boolean r12) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(r10, r11, r12));
        }

        public static b b(int r10, int r11, boolean r12, int r13) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(r10, r11, r12, r13));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2765a;

        public c(Object r10) {
            this.f2765a = r10;
        }

        public static c a(int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(r10, r11, r12, r13, r14, r15));
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2766a;

        public d(Object r10) {
            this.f2766a = r10;
        }

        public static d a(int r10, float r11, float r12, float r13) {
            return new d(AccessibilityNodeInfo.RangeInfo.obtain(r10, r11, r12, r13));
        }
    }

    static {
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo r10) {
        this.f2735b = -1;
        this.f2736c = -1;
        this.f2734a = r10;
    }

    public static AccessibilityNodeInfoCompat B0(AccessibilityNodeInfo r10) {
        return new AccessibilityNodeInfoCompat(r10);
    }

    public static AccessibilityNodeInfoCompat J() {
        return B0(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat K(View r10) {
        return B0(AccessibilityNodeInfo.obtain(r10));
    }

    public static AccessibilityNodeInfoCompat L(AccessibilityNodeInfoCompat r10) {
        return B0(AccessibilityNodeInfo.obtain(r10.f2734a));
    }

    public static String h(int r10) {
        if (r10 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r10 == 2) goto L90;
        switch(r10) {
            case 4: goto L88;
            case 8: goto L86;
            case 16: goto L84;
            case 32: goto L82;
            case 64: goto L80;
            case 128: goto L78;
            case 256: goto L76;
            case 512: goto L74;
            case 1024: goto L72;
            case 2048: goto L70;
            case 4096: goto L68;
            case 8192: goto L66;
            case 16384: goto L64;
            case 32768: goto L62;
            case 65536: goto L60;
            case 131072: goto L58;
            case 262144: goto L56;
            case 524288: goto L54;
            case 2097152: goto L52;
            case 16908354: goto L50;
            default: goto L7;
        };
    L7:
        switch(r10) {
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
        switch(r10) {
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
        switch(r10) {
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
        return "ACTION_MOVE_WINDOW";
    L52:
        return "ACTION_SET_TEXT";
    L54:
        return "ACTION_COLLAPSE";
    L56:
        return "ACTION_EXPAND";
    L58:
        return "ACTION_SET_SELECTION";
    L60:
        return "ACTION_CUT";
    L62:
        return "ACTION_PASTE";
    L64:
        return "ACTION_COPY";
    L66:
        return "ACTION_SCROLL_BACKWARD";
    L68:
        return "ACTION_SCROLL_FORWARD";
    L70:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
    L72:
        return "ACTION_NEXT_HTML_ELEMENT";
    L74:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    L76:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    L78:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    L80:
        return "ACTION_ACCESSIBILITY_FOCUS";
    L82:
        return "ACTION_LONG_CLICK";
    L84:
        return "ACTION_CLICK";
    L86:
        return "ACTION_CLEAR_SELECTION";
    L88:
        return "ACTION_SELECT";
    L90:
        return "ACTION_CLEAR_FOCUS";
    }

    public static ClickableSpan[] n(CharSequence r10) {
        if ((r10 instanceof Spanned) == true) goto L5;
        return null;
    L5:
        return (ClickableSpan[]) ((Spanned) r10).getSpans(0, r10.length(), ClickableSpan.class);
    }

    public boolean A() {
        return this.f2734a.isEnabled();
    }

    public AccessibilityNodeInfo A0() {
        return this.f2734a;
    }

    public boolean B() {
        return this.f2734a.isFocusable();
    }

    public boolean C() {
        return this.f2734a.isFocused();
    }

    public boolean D() {
        return this.f2734a.isLongClickable();
    }

    public boolean E() {
        return this.f2734a.isPassword();
    }

    public boolean F() {
        return this.f2734a.isScrollable();
    }

    public boolean G() {
        return this.f2734a.isSelected();
    }

    public boolean H() {
        return this.f2734a.isShowingHintText();
    }

    public boolean I() {
        return this.f2734a.isVisibleToUser();
    }

    public boolean M(int r10, Bundle r11) {
        return this.f2734a.performAction(r10, r11);
    }

    public void N() {
        this.f2734a.recycle();
    }

    public boolean O(a r10) {
        return this.f2734a.removeAction((AccessibilityNodeInfo.AccessibilityAction) r10.f2760a);
    }

    public void P(boolean r10) {
        this.f2734a.setAccessibilityFocused(r10);
    }

    public void Q(Rect r10) {
        this.f2734a.setBoundsInParent(r10);
    }

    public void R(Rect r10) {
        this.f2734a.setBoundsInScreen(r10);
    }

    public void S(boolean r10) {
        this.f2734a.setCanOpenPopup(r10);
    }

    public void T(boolean r10) {
        this.f2734a.setCheckable(r10);
    }

    public void U(boolean r10) {
        this.f2734a.setChecked(r10);
    }

    public void V(CharSequence r10) {
        this.f2734a.setClassName(r10);
    }

    public void W(boolean r10) {
        this.f2734a.setClickable(r10);
    }

    public void X(Object r10) {
        AccessibilityNodeInfo r11 = this.f2734a;
        if (r10 != null) goto L5;
        AccessibilityNodeInfo.CollectionInfo r12 = null;
    L6:
        r11.setCollectionInfo(r12);
        return;
    L5:
        r12 = (AccessibilityNodeInfo.CollectionInfo) ((b) r10).f2764a;
        goto L6
    }

    public void Y(Object r10) {
        AccessibilityNodeInfo r11 = this.f2734a;
        if (r10 != null) goto L5;
        AccessibilityNodeInfo.CollectionItemInfo r12 = null;
    L6:
        r11.setCollectionItemInfo(r12);
        return;
    L5:
        r12 = (AccessibilityNodeInfo.CollectionItemInfo) ((c) r10).f2765a;
        goto L6
    }

    public void Z(CharSequence r10) {
        this.f2734a.setContentDescription(r10);
    }

    public void a(int r10) {
        this.f2734a.addAction(r10);
    }

    public void a0(boolean r10) {
        this.f2734a.setDismissable(r10);
    }

    public void b(a r10) {
        this.f2734a.addAction((AccessibilityNodeInfo.AccessibilityAction) r10.f2760a);
    }

    public void b0(boolean r10) {
        this.f2734a.setEnabled(r10);
    }

    public void c(View r10) {
        this.f2734a.addChild(r10);
    }

    public void c0(CharSequence r10) {
        this.f2734a.setError(r10);
    }

    public void d(View r10, int r11) {
        this.f2734a.addChild(r10, r11);
    }

    public void d0(boolean r10) {
        this.f2734a.setFocusable(r10);
    }

    public void e(CharSequence r10, View r11) {
    }

    public void e0(boolean r10) {
        this.f2734a.setFocused(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((r10 instanceof AccessibilityNodeInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityNodeInfoCompat r11 = (AccessibilityNodeInfoCompat) r10;
        AccessibilityNodeInfo r12 = this.f2734a;
        if (r12 != null) goto L17;
        if (r11.f2734a == null) goto L20;
        return false;
    L20:
        if (this.f2736c == r11.f2736c) goto L23;
        return false;
    L23:
        if (this.f2735b == r11.f2735b) goto L25;
        return false;
    L25:
        return true;
    L17:
        if (r12.equals(r11.f2734a) == true) goto L20;
        return false;
    }

    public final List f(String r10) {
        ArrayList<Integer> r11 = this.f2734a.getExtras().getIntegerArrayList(r10);
        if (r11 != null) goto L6;
        ArrayList<Integer> r12 = new ArrayList();
        this.f2734a.getExtras().putIntegerArrayList(r10, r12);
        return r12;
    L6:
        return r11;
    }

    public void f0(boolean r10) {
        this.f2734a.setHeading(r10);
    }

    public List g() {
        List<AccessibilityNodeInfo.AccessibilityAction> r10 = this.f2734a.getActionList();
        if (r10 == null) goto L9;
        ArrayList r11 = new ArrayList();
        int r12 = r10.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r11.add(new a(r10.get(r13)));
        r13 = r13 + 1;
        goto L5
    L7:
        return r11;
    L9:
        return Collections.emptyList();
    }

    public void g0(CharSequence r10) {
        this.f2734a.setHintText(r10);
    }

    public void h0(boolean r10) {
        this.f2734a.setLongClickable(r10);
    }

    public int hashCode() {
        AccessibilityNodeInfo r10 = this.f2734a;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public int i() {
        return this.f2734a.getActions();
    }

    public void i0(int r10) {
        this.f2734a.setMaxTextLength(r10);
    }

    public void j(Rect r10) {
        this.f2734a.getBoundsInParent(r10);
    }

    public void j0(int r10) {
        this.f2734a.setMovementGranularities(r10);
    }

    public void k(Rect r10) {
        this.f2734a.getBoundsInScreen(r10);
    }

    public void k0(CharSequence r10) {
        this.f2734a.setPackageName(r10);
    }

    public int l() {
        return this.f2734a.getChildCount();
    }

    public void l0(CharSequence r10) {
        this.f2734a.setPaneTitle(r10);
    }

    public CharSequence m() {
        return this.f2734a.getClassName();
    }

    public void m0(View r10) {
        this.f2735b = -1;
        this.f2734a.setParent(r10);
    }

    public void n0(View r10, int r11) {
        this.f2735b = r11;
        this.f2734a.setParent(r10, r11);
    }

    public CharSequence o() {
        return this.f2734a.getContentDescription();
    }

    public void o0(d r10) {
        this.f2734a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) r10.f2766a);
    }

    public Bundle p() {
        return this.f2734a.getExtras();
    }

    public void p0(CharSequence r10) {
        this.f2734a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", r10);
    }

    public int q() {
        return this.f2734a.getMovementGranularities();
    }

    public void q0(boolean r10) {
        this.f2734a.setScreenReaderFocusable(r10);
    }

    public CharSequence r() {
        return this.f2734a.getPackageName();
    }

    public void r0(boolean r10) {
        this.f2734a.setScrollable(r10);
    }

    public CharSequence s() {
        if (v() == false) goto L10;
        List r10 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List r11 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List r12 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List r13 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        int r14 = 0;
        SpannableString r15 = new SpannableString(TextUtils.substring(this.f2734a.getText(), 0, this.f2734a.getText().length()));
    L6:
        if (r14 >= r10.size()) goto L8;
        r15.setSpan(new r.a(((Integer) r13.get(r14)).intValue(), this, p().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) r10.get(r14)).intValue(), ((Integer) r11.get(r14)).intValue(), ((Integer) r12.get(r14)).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        return r15;
    L10:
        return this.f2734a.getText();
    }

    public void s0(boolean r10) {
        this.f2734a.setSelected(r10);
    }

    public String t() {
        if (BuildCompat.c() == false) goto L7;
        return this.f2734a.getUniqueId();
    L7:
        return this.f2734a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void t0(boolean r10) {
        this.f2734a.setShowingHintText(r10);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(super.toString());
        Rect r11 = new Rect();
        j(r11);
        r10.append("; boundsInParent: " + r11);
        k(r11);
        r10.append("; boundsInScreen: " + r11);
        r10.append("; packageName: ");
        r10.append(r());
        r10.append("; className: ");
        r10.append(m());
        r10.append("; text: ");
        r10.append(s());
        r10.append("; contentDescription: ");
        r10.append(o());
        r10.append("; viewId: ");
        r10.append(u());
        r10.append("; uniqueId: ");
        r10.append(t());
        r10.append("; checkable: ");
        r10.append(x());
        r10.append("; checked: ");
        r10.append(y());
        r10.append("; focusable: ");
        r10.append(B());
        r10.append("; focused: ");
        r10.append(C());
        r10.append("; selected: ");
        r10.append(G());
        r10.append("; clickable: ");
        r10.append(z());
        r10.append("; longClickable: ");
        r10.append(D());
        r10.append("; enabled: ");
        r10.append(A());
        r10.append("; password: ");
        r10.append(E());
        r10.append("; scrollable: " + F());
        r10.append("; [");
        List r12 = g();
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L14;
        a r14 = (a) r12.get(r13);
        String r15 = h(r14.b());
        if (r15.equals("ACTION_UNKNOWN") == true) goto L8;
    L10:
        r10.append(r15);
        if (r13 == (r12.size() - 1)) goto L13;
        r10.append(", ");
    L13:
        r13 = r13 + 1;
        goto L4
    L8:
        if (r14.c() == null) goto L10;
        r15 = r14.c().toString();
        goto L10
    L14:
        r10.append("]");
        return r10.toString();
    }

    public String u() {
        return this.f2734a.getViewIdResourceName();
    }

    public void u0(View r10) {
        this.f2736c = -1;
        this.f2734a.setSource(r10);
    }

    public final boolean v() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void v0(View r10, int r11) {
        this.f2736c = r11;
        this.f2734a.setSource(r10, r11);
    }

    public boolean w() {
        return this.f2734a.isAccessibilityFocused();
    }

    public void w0(CharSequence r10) {
        if (BuildCompat.b() == false) goto L5;
        this.f2734a.setStateDescription(r10);
        return;
    L5:
        this.f2734a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", r10);
    }

    public boolean x() {
        return this.f2734a.isCheckable();
    }

    public void x0(CharSequence r10) {
        this.f2734a.setText(r10);
    }

    public boolean y() {
        return this.f2734a.isChecked();
    }

    public void y0(View r10) {
        this.f2734a.setTraversalAfter(r10);
    }

    public boolean z() {
        return this.f2734a.isClickable();
    }

    public void z0(boolean r10) {
        this.f2734a.setVisibleToUser(r10);
    }
}
