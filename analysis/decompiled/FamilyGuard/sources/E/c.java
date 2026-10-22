package E;

import E.f;
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
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f1221a;

    /* renamed from: b, reason: collision with root package name */
    public int f1222b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f1223c = -1;

    public static class a {

        /* renamed from: A, reason: collision with root package name */
        public static final a f1224A;

        /* renamed from: B, reason: collision with root package name */
        public static final a f1225B;

        /* renamed from: C, reason: collision with root package name */
        public static final a f1226C;

        /* renamed from: D, reason: collision with root package name */
        public static final a f1227D;

        /* renamed from: E, reason: collision with root package name */
        public static final a f1228E;

        /* renamed from: F, reason: collision with root package name */
        public static final a f1229F;

        /* renamed from: G, reason: collision with root package name */
        public static final a f1230G;

        /* renamed from: H, reason: collision with root package name */
        public static final a f1231H;

        /* renamed from: I, reason: collision with root package name */
        public static final a f1232I;

        /* renamed from: J, reason: collision with root package name */
        public static final a f1233J;

        /* renamed from: K, reason: collision with root package name */
        public static final a f1234K;

        /* renamed from: L, reason: collision with root package name */
        public static final a f1235L;

        /* renamed from: M, reason: collision with root package name */
        public static final a f1236M;

        /* renamed from: N, reason: collision with root package name */
        public static final a f1237N;

        /* renamed from: O, reason: collision with root package name */
        public static final a f1238O;

        /* renamed from: P, reason: collision with root package name */
        public static final a f1239P;

        /* renamed from: Q, reason: collision with root package name */
        public static final a f1240Q;

        /* renamed from: R, reason: collision with root package name */
        public static final a f1241R;

        /* renamed from: S, reason: collision with root package name */
        public static final a f1242S;

        /* renamed from: T, reason: collision with root package name */
        public static final a f1243T;

        /* renamed from: U, reason: collision with root package name */
        public static final a f1244U;

        /* renamed from: V, reason: collision with root package name */
        public static final a f1245V;

        /* renamed from: e, reason: collision with root package name */
        public static final a f1246e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f1247f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f1248g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f1249h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f1250i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f1251j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f1252k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f1253l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f1254m = new a(256, (CharSequence) null, (Class<? extends f.a>) f.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f1255n = new a(512, (CharSequence) null, (Class<? extends f.a>) f.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f1256o = new a(1024, (CharSequence) null, (Class<? extends f.a>) f.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f1257p = new a(RecyclerView.ItemAnimator.FLAG_MOVED, (CharSequence) null, (Class<? extends f.a>) f.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f1258q = new a(RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f1259r = new a(8192, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f1260s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f1261t = new a(32768, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f1262u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f1263v = new a(131072, (CharSequence) null, (Class<? extends f.a>) f.g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f1264w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f1265x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f1266y = new a(1048576, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f1267z = new a(2097152, (CharSequence) null, (Class<? extends f.a>) f.h.class);

        /* renamed from: a, reason: collision with root package name */
        final Object f1268a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1269b;

        /* renamed from: c, reason: collision with root package name */
        private final Class<? extends f.a> f1270c;

        /* renamed from: d, reason: collision with root package name */
        protected final E.f f1271d;

        static {
            int i5 = Build.VERSION.SDK_INT;
            f1224A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            f1225B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, f.e.class);
            f1226C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            f1227D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f1228E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            f1229F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            f1230G = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
            f1231H = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
            f1232I = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
            f1233J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
            f1234K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            f1235L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, f.C0019f.class);
            f1236M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, f.d.class);
            f1237N = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            f1238O = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
            f1239P = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);
            f1240Q = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);
            f1241R = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START, R.id.accessibilityActionDragStart, null, null, null);
            f1242S = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP, R.id.accessibilityActionDragDrop, null, null, null);
            f1243T = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL, R.id.accessibilityActionDragCancel, null, null, null);
            f1244U = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f1245V = new a(i5 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i5, CharSequence charSequence) {
            this(null, i5, charSequence, null, null);
        }

        public a a(CharSequence charSequence, E.f fVar) {
            return new a(null, this.f1269b, charSequence, fVar, this.f1270c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1268a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1268a).getLabel();
        }

        public boolean d(View view, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            f.a aVarNewInstance;
            if (this.f1271d == null) {
                return false;
            }
            Class<? extends f.a> cls = this.f1270c;
            f.a aVar = null;
            if (cls != null) {
                try {
                    aVarNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                } catch (Exception e6) {
                    e = e6;
                }
                try {
                    aVarNewInstance.a(bundle);
                    aVar = aVarNewInstance;
                } catch (Exception e7) {
                    e = e7;
                    aVar = aVarNewInstance;
                    Class<? extends f.a> cls2 = this.f1270c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    return this.f1271d.a(view, aVar);
                }
            }
            return this.f1271d.a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f1268a;
            return obj2 == null ? aVar.f1268a == null : obj2.equals(aVar.f1268a);
        }

        public int hashCode() {
            Object obj = this.f1268a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strG = c.g(this.f1269b);
            if (strG.equals("ACTION_UNKNOWN") && c() != null) {
                strG = c().toString();
            }
            sb.append(strG);
            return sb.toString();
        }

        public a(int i5, CharSequence charSequence, E.f fVar) {
            this(null, i5, charSequence, fVar, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i5, CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i5, charSequence, null, cls);
        }

        a(Object obj, int i5, CharSequence charSequence, E.f fVar, Class<? extends f.a> cls) {
            this.f1269b = i5;
            this.f1271d = fVar;
            if (obj == null) {
                this.f1268a = new AccessibilityNodeInfo.AccessibilityAction(i5, charSequence);
            } else {
                this.f1268a = obj;
            }
            this.f1270c = cls;
        }
    }

    private static class b {
        public static Object a(int i5, float f5, float f6, float f7) {
            return new AccessibilityNodeInfo.RangeInfo(i5, f5, f6, f7);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* renamed from: E.c$c, reason: collision with other inner class name */
    private static class C0018c {
        public static f a(boolean z5, int i5, int i6, int i7, int i8, boolean z6, String str, String str2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z5).setColumnIndex(i5).setRowIndex(i6).setColumnSpan(i7).setRowSpan(i8).setSelected(z6).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static c b(AccessibilityNodeInfo accessibilityNodeInfo, int i5, int i6) {
            return c.F0(accessibilityNodeInfo.getChild(i5, i6));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static c f(AccessibilityNodeInfo accessibilityNodeInfo, int i5) {
            return c.F0(accessibilityNodeInfo.getParent(i5));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z5) {
            accessibilityNodeInfo.setTextSelectable(z5);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    private static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z5) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z5);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j5) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j5));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z5) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z5);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z5) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z5);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final Object f1272a;

        e(Object obj) {
            this.f1272a = obj;
        }

        public static e a(int i5, int i6, boolean z5, int i7) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i5, i6, z5, i7));
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        final Object f1273a;

        f(Object obj) {
            this.f1273a = obj;
        }

        public static f a(int i5, int i6, int i7, int i8, boolean z5, boolean z6) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i5, i6, i7, i8, z5, z6));
        }
    }

    @Deprecated
    public c(Object obj) {
        this.f1221a = (AccessibilityNodeInfo) obj;
    }

    private boolean A() {
        return !e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public static c E0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    static c F0(Object obj) {
        if (obj != null) {
            return new c(obj);
        }
        return null;
    }

    public static c S() {
        return E0(AccessibilityNodeInfo.obtain());
    }

    public static c T(c cVar) {
        return E0(AccessibilityNodeInfo.obtain(cVar.f1221a));
    }

    public static c U(View view) {
        return E0(AccessibilityNodeInfo.obtain(view));
    }

    private List<Integer> e(String str) {
        ArrayList<Integer> integerArrayList = this.f1221a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f1221a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static String g(int i5) {
        if (i5 == 1) {
            return "ACTION_FOCUS";
        }
        if (i5 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i5) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case RecyclerView.ItemAnimator.FLAG_MOVED /* 2048 */:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /* 4096 */:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i5) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i5) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i5) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean i(int i5) {
        Bundle bundleS = s();
        return bundleS != null && (bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i5) == i5;
    }

    public static ClickableSpan[] o(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public void A0(CharSequence charSequence) {
        this.f1221a.setText(charSequence);
    }

    public boolean B() {
        return Build.VERSION.SDK_INT >= 34 ? d.f(this.f1221a) : i(64);
    }

    public void B0(View view) {
        this.f1221a.setTraversalAfter(view);
    }

    public boolean C() {
        return this.f1221a.isCheckable();
    }

    public void C0(boolean z5) {
        this.f1221a.setVisibleToUser(z5);
    }

    public boolean D() {
        return this.f1221a.isChecked();
    }

    public AccessibilityNodeInfo D0() {
        return this.f1221a;
    }

    public boolean E() {
        return this.f1221a.isClickable();
    }

    public boolean F() {
        return this.f1221a.isContextClickable();
    }

    public boolean G() {
        return this.f1221a.isEnabled();
    }

    public boolean H() {
        return this.f1221a.isFocusable();
    }

    public boolean I() {
        return this.f1221a.isFocused();
    }

    public boolean J() {
        return i(67108864);
    }

    public boolean K() {
        return this.f1221a.isImportantForAccessibility();
    }

    public boolean L() {
        return this.f1221a.isLongClickable();
    }

    public boolean M() {
        return this.f1221a.isPassword();
    }

    public boolean N() {
        return this.f1221a.isScrollable();
    }

    public boolean O() {
        return this.f1221a.isSelected();
    }

    public boolean P() {
        return this.f1221a.isShowingHintText();
    }

    public boolean Q() {
        return C0018c.h(this.f1221a);
    }

    public boolean R() {
        return this.f1221a.isVisibleToUser();
    }

    public boolean V(int i5, Bundle bundle) {
        return this.f1221a.performAction(i5, bundle);
    }

    @Deprecated
    public void W() {
    }

    public boolean X(a aVar) {
        return this.f1221a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1268a);
    }

    public void Y(boolean z5) {
        this.f1221a.setAccessibilityFocused(z5);
    }

    @Deprecated
    public void Z(Rect rect) {
        this.f1221a.setBoundsInParent(rect);
    }

    public void a(int i5) {
        this.f1221a.addAction(i5);
    }

    public void a0(Rect rect) {
        this.f1221a.setBoundsInScreen(rect);
    }

    public void b(a aVar) {
        this.f1221a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1268a);
    }

    public void b0(boolean z5) {
        this.f1221a.setCheckable(z5);
    }

    public void c(View view, int i5) {
        this.f1221a.addChild(view, i5);
    }

    public void c0(boolean z5) {
        this.f1221a.setChecked(z5);
    }

    public void d(CharSequence charSequence, View view) {
    }

    public void d0(CharSequence charSequence) {
        this.f1221a.setClassName(charSequence);
    }

    public void e0(boolean z5) {
        this.f1221a.setClickable(z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1221a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f1221a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f1221a)) {
            return false;
        }
        return this.f1223c == cVar.f1223c && this.f1222b == cVar.f1222b;
    }

    public List<a> f() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f1221a.getActionList();
        if (actionList == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(new a(actionList.get(i5)));
        }
        return arrayList;
    }

    public void f0(Object obj) {
        this.f1221a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f1272a);
    }

    public void g0(Object obj) {
        this.f1221a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).f1273a);
    }

    @Deprecated
    public int h() {
        return this.f1221a.getActions();
    }

    public void h0(CharSequence charSequence) {
        this.f1221a.setContentDescription(charSequence);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1221a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(boolean z5) {
        this.f1221a.setContentInvalid(z5);
    }

    @Deprecated
    public void j(Rect rect) {
        this.f1221a.getBoundsInParent(rect);
    }

    public void j0(boolean z5) {
        this.f1221a.setEnabled(z5);
    }

    public void k(Rect rect) {
        this.f1221a.getBoundsInScreen(rect);
    }

    public void k0(CharSequence charSequence) {
        this.f1221a.setError(charSequence);
    }

    public void l(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f1221a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f1221a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void l0(boolean z5) {
        this.f1221a.setFocusable(z5);
    }

    public int m() {
        return this.f1221a.getChildCount();
    }

    public void m0(boolean z5) {
        this.f1221a.setFocused(z5);
    }

    public CharSequence n() {
        return this.f1221a.getClassName();
    }

    public void n0(boolean z5) {
        this.f1221a.setHeading(z5);
    }

    public void o0(CharSequence charSequence) {
        this.f1221a.setHintText(charSequence);
    }

    public CharSequence p() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f1221a) : this.f1221a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void p0(View view) {
        this.f1221a.setLabelFor(view);
    }

    public CharSequence q() {
        return this.f1221a.getContentDescription();
    }

    public void q0(int i5) {
        this.f1221a.setMaxTextLength(i5);
    }

    public CharSequence r() {
        return this.f1221a.getError();
    }

    public void r0(CharSequence charSequence) {
        this.f1221a.setPackageName(charSequence);
    }

    public Bundle s() {
        return this.f1221a.getExtras();
    }

    public void s0(CharSequence charSequence) {
        this.f1221a.setPaneTitle(charSequence);
    }

    public int t() {
        return this.f1221a.getMaxTextLength();
    }

    public void t0(View view) {
        this.f1222b = -1;
        this.f1221a.setParent(view);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        j(rect);
        sb.append("; boundsInParent: " + rect);
        k(rect);
        sb.append("; boundsInScreen: " + rect);
        l(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(u());
        sb.append("; className: ");
        sb.append(n());
        sb.append("; text: ");
        sb.append(w());
        sb.append("; error: ");
        sb.append(r());
        sb.append("; maxTextLength: ");
        sb.append(t());
        sb.append("; stateDescription: ");
        sb.append(v());
        sb.append("; contentDescription: ");
        sb.append(q());
        sb.append("; tooltipText: ");
        sb.append(x());
        sb.append("; viewIdResName: ");
        sb.append(z());
        sb.append("; uniqueId: ");
        sb.append(y());
        sb.append("; checkable: ");
        sb.append(C());
        sb.append("; checked: ");
        sb.append(D());
        sb.append("; focusable: ");
        sb.append(H());
        sb.append("; focused: ");
        sb.append(I());
        sb.append("; selected: ");
        sb.append(O());
        sb.append("; clickable: ");
        sb.append(E());
        sb.append("; longClickable: ");
        sb.append(L());
        sb.append("; contextClickable: ");
        sb.append(F());
        sb.append("; enabled: ");
        sb.append(G());
        sb.append("; password: ");
        sb.append(M());
        sb.append("; scrollable: " + N());
        sb.append("; containerTitle: ");
        sb.append(p());
        sb.append("; granularScrollingSupported: ");
        sb.append(J());
        sb.append("; importantForAccessibility: ");
        sb.append(K());
        sb.append("; visible: ");
        sb.append(R());
        sb.append("; isTextSelectable: ");
        sb.append(Q());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(B());
        sb.append("; [");
        List<a> listF = f();
        for (int i5 = 0; i5 < listF.size(); i5++) {
            a aVar = listF.get(i5);
            String strG = g(aVar.b());
            if (strG.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strG = aVar.c().toString();
            }
            sb.append(strG);
            if (i5 != listF.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f1221a.getPackageName();
    }

    public void u0(View view, int i5) {
        this.f1222b = i5;
        this.f1221a.setParent(view, i5);
    }

    public CharSequence v() {
        return b.b(this.f1221a);
    }

    public void v0(boolean z5) {
        this.f1221a.setScreenReaderFocusable(z5);
    }

    public CharSequence w() {
        if (!A()) {
            return this.f1221a.getText();
        }
        List<Integer> listE = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listE2 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listE3 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listE4 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1221a.getText(), 0, this.f1221a.getText().length()));
        for (int i5 = 0; i5 < listE.size(); i5++) {
            spannableString.setSpan(new E.a(listE4.get(i5).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listE.get(i5).intValue(), listE2.get(i5).intValue(), listE3.get(i5).intValue());
        }
        return spannableString;
    }

    public void w0(boolean z5) {
        this.f1221a.setScrollable(z5);
    }

    public CharSequence x() {
        return this.f1221a.getTooltipText();
    }

    public void x0(boolean z5) {
        this.f1221a.setShowingHintText(z5);
    }

    public String y() {
        return C0018c.g(this.f1221a);
    }

    public void y0(View view, int i5) {
        this.f1223c = i5;
        this.f1221a.setSource(view, i5);
    }

    public String z() {
        return this.f1221a.getViewIdResourceName();
    }

    public void z0(CharSequence charSequence) {
        b.c(this.f1221a, charSequence);
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1221a = accessibilityNodeInfo;
    }
}
