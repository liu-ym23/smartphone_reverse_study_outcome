package C0;

import C0.f;
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
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f1625a;

    /* renamed from: b, reason: collision with root package name */
    public int f1626b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f1627c = -1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1672a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1673b;

        /* renamed from: c, reason: collision with root package name */
        public final Class<? extends f.a> f1674c;

        /* renamed from: d, reason: collision with root package name */
        public final C0.f f1675d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f1650e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f1651f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f1652g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f1653h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f1654i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f1655j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f1656k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f1657l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f1658m = new a(256, (CharSequence) null, (Class<? extends f.a>) f.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f1659n = new a(512, (CharSequence) null, (Class<? extends f.a>) f.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f1660o = new a(1024, (CharSequence) null, (Class<? extends f.a>) f.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f1661p = new a(2048, (CharSequence) null, (Class<? extends f.a>) f.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f1662q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f1663r = new a(com.stepos.agentframework.chatui.longtext.b.THRESHOLD, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f1664s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f1665t = new a(32768, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f1666u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f1667v = new a(SQLiteDatabase.OPEN_SHAREDCACHE, (CharSequence) null, (Class<? extends f.a>) f.g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f1668w = new a(SQLiteDatabase.OPEN_PRIVATECACHE, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f1669x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f1670y = new a(1048576, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f1671z = new a(2097152, (CharSequence) null, (Class<? extends f.a>) f.h.class);

        /* renamed from: A, reason: collision with root package name */
        public static final a f1628A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);

        /* renamed from: B, reason: collision with root package name */
        public static final a f1629B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, f.e.class);

        /* renamed from: C, reason: collision with root package name */
        public static final a f1630C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);

        /* renamed from: D, reason: collision with root package name */
        public static final a f1631D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);

        /* renamed from: E, reason: collision with root package name */
        public static final a f1632E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);

        /* renamed from: F, reason: collision with root package name */
        public static final a f1633F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);

        /* renamed from: G, reason: collision with root package name */
        public static final a f1634G = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);

        /* renamed from: H, reason: collision with root package name */
        public static final a f1635H = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);

        /* renamed from: I, reason: collision with root package name */
        public static final a f1636I = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);

        /* renamed from: J, reason: collision with root package name */
        public static final a f1637J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);

        /* renamed from: K, reason: collision with root package name */
        public static final a f1638K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);

        /* renamed from: L, reason: collision with root package name */
        public static final a f1639L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, f.C0016f.class);

        /* renamed from: M, reason: collision with root package name */
        public static final a f1640M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, f.d.class);

        /* renamed from: N, reason: collision with root package name */
        public static final a f1641N = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);

        /* renamed from: O, reason: collision with root package name */
        public static final a f1642O = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);

        /* renamed from: P, reason: collision with root package name */
        public static final a f1643P = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);

        /* renamed from: Q, reason: collision with root package name */
        public static final a f1644Q = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);

        /* renamed from: R, reason: collision with root package name */
        public static final a f1645R = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START, R.id.accessibilityActionDragStart, null, null, null);

        /* renamed from: S, reason: collision with root package name */
        public static final a f1646S = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP, R.id.accessibilityActionDragDrop, null, null, null);

        /* renamed from: T, reason: collision with root package name */
        public static final a f1647T = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL, R.id.accessibilityActionDragCancel, null, null, null);

        /* renamed from: U, reason: collision with root package name */
        public static final a f1648U = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS, R.id.accessibilityActionShowTextSuggestions, null, null, null);

        /* renamed from: V, reason: collision with root package name */
        public static final a f1649V = new a(d.a(), R.id.accessibilityActionScrollInDirection, null, null, null);

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public a a(CharSequence charSequence, C0.f fVar) {
            return new a(null, this.f1673b, charSequence, fVar, this.f1674c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1672a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1672a).getLabel();
        }

        public boolean d(View view, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            f.a aVarNewInstance;
            if (this.f1675d == null) {
                return false;
            }
            Class<? extends f.a> cls = this.f1674c;
            f.a aVar = null;
            if (cls != null) {
                try {
                    aVarNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                } catch (Exception e10) {
                    e = e10;
                }
                try {
                    aVarNewInstance.a(bundle);
                    aVar = aVarNewInstance;
                } catch (Exception e11) {
                    e = e11;
                    aVar = aVarNewInstance;
                    Class<? extends f.a> cls2 = this.f1674c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    return this.f1675d.a(view, aVar);
                }
            }
            return this.f1675d.a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f1672a;
            return obj2 == null ? aVar.f1672a == null : obj2.equals(aVar.f1672a);
        }

        public int hashCode() {
            Object obj = this.f1672a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AccessibilityActionCompat: ");
            String strH = c.h(this.f1673b);
            if (strH.equals("ACTION_UNKNOWN") && c() != null) {
                strH = c().toString();
            }
            sb2.append(strH);
            return sb2.toString();
        }

        public a(int i10, CharSequence charSequence, C0.f fVar) {
            this(null, i10, charSequence, fVar, null);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i10, CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i10, charSequence, null, cls);
        }

        public a(Object obj, int i10, CharSequence charSequence, C0.f fVar, Class<? extends f.a> cls) {
            this.f1673b = i10;
            this.f1675d = fVar;
            if (obj == null) {
                this.f1672a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f1672a = obj;
            }
            this.f1674c = cls;
        }
    }

    public static class b {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* renamed from: C0.c$c, reason: collision with other inner class name */
    public static class C0015c {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    public static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    public static class e {
        public static int b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getChecked();
        }

        public static int c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExpandedState();
        }

        public static CharSequence d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getSupplementalDescription();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isFieldRequired();
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1676a;

        public f(Object obj) {
            this.f1676a = obj;
        }

        public static f a(int i10, int i11, boolean z10) {
            return new f(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }

        public static f b(int i10, int i11, boolean z10, int i12) {
            return new f(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1677a;

        public g(Object obj) {
            this.f1677a = obj;
        }

        public static g a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }
    }

    public c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1625a = accessibilityNodeInfo;
    }

    public static c S0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c a0() {
        return S0(AccessibilityNodeInfo.obtain());
    }

    public static c b0(c cVar) {
        return S0(AccessibilityNodeInfo.obtain(cVar.f1625a));
    }

    public static c c0(View view) {
        return S0(AccessibilityNodeInfo.obtain(view));
    }

    public static String h(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
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
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case com.stepos.agentframework.chatui.longtext.b.THRESHOLD /* 8192 */:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case SQLiteDatabase.OPEN_SHAREDCACHE /* 131072 */:
                return "ACTION_SET_SELECTION";
            case SQLiteDatabase.OPEN_PRIVATECACHE /* 262144 */:
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
                switch (i10) {
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
                        switch (i10) {
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
                                switch (i10) {
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

    public static ClickableSpan[] r(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static String w(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "UNKNOWN" : "FULL" : "PARTIAL" : "COLLAPSED" : "UNDEFINED";
    }

    public CharSequence A() {
        return b.a(this.f1625a);
    }

    public void A0(View view) {
        this.f1625a.setLabelFor(view);
    }

    public CharSequence B() {
        return Build.VERSION.SDK_INT >= 36 ? e.d(this.f1625a) : this.f1625a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.SUPPLEMENTAL_DESCRIPTION_KEY");
    }

    public void B0(int i10) {
        this.f1625a.setMaxTextLength(i10);
    }

    public CharSequence C() {
        if (!G()) {
            return this.f1625a.getText();
        }
        List<Integer> listF = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listF2 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listF3 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listF4 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1625a.getText(), 0, this.f1625a.getText().length()));
        for (int i10 = 0; i10 < listF.size(); i10++) {
            spannableString.setSpan(new C0.a(listF4.get(i10).intValue(), this, x().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listF.get(i10).intValue(), listF2.get(i10).intValue(), listF3.get(i10).intValue());
        }
        return spannableString;
    }

    public void C0(CharSequence charSequence) {
        this.f1625a.setPackageName(charSequence);
    }

    public CharSequence D() {
        return this.f1625a.getTooltipText();
    }

    public void D0(CharSequence charSequence) {
        this.f1625a.setPaneTitle(charSequence);
    }

    public String E() {
        return C0015c.a(this.f1625a);
    }

    public void E0(View view) {
        this.f1626b = -1;
        this.f1625a.setParent(view);
    }

    public String F() {
        return this.f1625a.getViewIdResourceName();
    }

    public void F0(View view, int i10) {
        this.f1626b = i10;
        this.f1625a.setParent(view, i10);
    }

    public final boolean G() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void G0(CharSequence charSequence) {
        this.f1625a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public boolean H() {
        return d.d(this.f1625a);
    }

    public void H0(boolean z10) {
        this.f1625a.setScreenReaderFocusable(z10);
    }

    public boolean I() {
        return this.f1625a.isAccessibilityFocused();
    }

    public void I0(boolean z10) {
        this.f1625a.setScrollable(z10);
    }

    public boolean J() {
        return this.f1625a.isCheckable();
    }

    public void J0(boolean z10) {
        this.f1625a.setSelected(z10);
    }

    @Deprecated
    public boolean K() {
        return this.f1625a.isChecked();
    }

    public void K0(boolean z10) {
        this.f1625a.setShowingHintText(z10);
    }

    public boolean L() {
        return this.f1625a.isClickable();
    }

    public void L0(View view) {
        this.f1627c = -1;
        this.f1625a.setSource(view);
    }

    public boolean M() {
        return this.f1625a.isContextClickable();
    }

    public void M0(View view, int i10) {
        this.f1627c = i10;
        this.f1625a.setSource(view, i10);
    }

    public boolean N() {
        return this.f1625a.isEnabled();
    }

    public void N0(CharSequence charSequence) {
        b.b(this.f1625a, charSequence);
    }

    public boolean O() {
        return Build.VERSION.SDK_INT >= 36 ? e.e(this.f1625a) : this.f1625a.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY");
    }

    public void O0(CharSequence charSequence) {
        this.f1625a.setText(charSequence);
    }

    public boolean P() {
        return this.f1625a.isFocusable();
    }

    public void P0(View view) {
        this.f1625a.setTraversalAfter(view);
    }

    public boolean Q() {
        return this.f1625a.isFocused();
    }

    public void Q0(boolean z10) {
        this.f1625a.setVisibleToUser(z10);
    }

    public boolean R() {
        return j(67108864);
    }

    public AccessibilityNodeInfo R0() {
        return this.f1625a;
    }

    public boolean S() {
        return this.f1625a.isImportantForAccessibility();
    }

    public boolean T() {
        return this.f1625a.isLongClickable();
    }

    public boolean U() {
        return this.f1625a.isPassword();
    }

    public boolean V() {
        return this.f1625a.isScrollable();
    }

    public boolean W() {
        return this.f1625a.isSelected();
    }

    public boolean X() {
        return this.f1625a.isShowingHintText();
    }

    public boolean Y() {
        return C0015c.b(this.f1625a);
    }

    public boolean Z() {
        return this.f1625a.isVisibleToUser();
    }

    public void a(int i10) {
        this.f1625a.addAction(i10);
    }

    public void b(a aVar) {
        this.f1625a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1672a);
    }

    public void c(View view) {
        this.f1625a.addChild(view);
    }

    public void d(View view, int i10) {
        this.f1625a.addChild(view, i10);
    }

    public boolean d0(int i10, Bundle bundle) {
        return this.f1625a.performAction(i10, bundle);
    }

    public void e(CharSequence charSequence, View view) {
    }

    @Deprecated
    public void e0() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1625a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f1625a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f1625a)) {
            return false;
        }
        return this.f1627c == cVar.f1627c && this.f1626b == cVar.f1626b;
    }

    public final List<Integer> f(String str) {
        ArrayList<Integer> integerArrayList = this.f1625a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f1625a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public boolean f0(a aVar) {
        return this.f1625a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1672a);
    }

    public List<a> g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f1625a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void g0(boolean z10) {
        this.f1625a.setAccessibilityFocused(z10);
    }

    public final void h0(int i10, boolean z10) {
        Bundle bundleX = x();
        if (bundleX != null) {
            int i11 = bundleX.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            bundleX.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1625a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f1625a.getActions();
    }

    @Deprecated
    public void i0(Rect rect) {
        this.f1625a.setBoundsInParent(rect);
    }

    public final boolean j(int i10) {
        Bundle bundleX = x();
        return bundleX != null && (bundleX.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10;
    }

    public void j0(Rect rect) {
        this.f1625a.setBoundsInScreen(rect);
    }

    @Deprecated
    public void k(Rect rect) {
        this.f1625a.getBoundsInParent(rect);
    }

    public void k0(boolean z10) {
        this.f1625a.setCheckable(z10);
    }

    public void l(Rect rect) {
        this.f1625a.getBoundsInScreen(rect);
    }

    @Deprecated
    public void l0(boolean z10) {
        this.f1625a.setChecked(z10);
    }

    public void m(Rect rect) {
        d.b(this.f1625a, rect);
    }

    public void m0(CharSequence charSequence) {
        this.f1625a.setClassName(charSequence);
    }

    public int n() {
        return Build.VERSION.SDK_INT >= 36 ? e.b(this.f1625a) : this.f1625a.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.CHECKED_KEY", this.f1625a.isChecked() ? 1 : 0);
    }

    public void n0(boolean z10) {
        this.f1625a.setClickable(z10);
    }

    public final String o() {
        int iN = n();
        return iN == 1 ? "TRUE" : iN == 2 ? "PARTIAL" : "FALSE";
    }

    public void o0(Object obj) {
        this.f1625a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((f) obj).f1676a);
    }

    public int p() {
        return this.f1625a.getChildCount();
    }

    public void p0(Object obj) {
        this.f1625a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((g) obj).f1677a);
    }

    public CharSequence q() {
        return this.f1625a.getClassName();
    }

    public void q0(CharSequence charSequence) {
        this.f1625a.setContentDescription(charSequence);
    }

    public void r0(boolean z10) {
        this.f1625a.setContentInvalid(z10);
    }

    public CharSequence s() {
        return d.c(this.f1625a);
    }

    public void s0(boolean z10) {
        this.f1625a.setDismissable(z10);
    }

    public CharSequence t() {
        return this.f1625a.getContentDescription();
    }

    public void t0(boolean z10) {
        this.f1625a.setEnabled(z10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        k(rect);
        sb2.append("; boundsInParent: " + rect);
        l(rect);
        sb2.append("; boundsInScreen: " + rect);
        m(rect);
        sb2.append("; boundsInWindow: " + rect);
        sb2.append("; packageName: ");
        sb2.append(z());
        sb2.append("; className: ");
        sb2.append(q());
        sb2.append("; text: ");
        sb2.append(C());
        sb2.append("; error: ");
        sb2.append(u());
        sb2.append("; maxTextLength: ");
        sb2.append(y());
        sb2.append("; stateDescription: ");
        sb2.append(A());
        sb2.append("; contentDescription: ");
        sb2.append(t());
        sb2.append("; supplementalDescription: ");
        sb2.append(B());
        sb2.append("; tooltipText: ");
        sb2.append(D());
        sb2.append("; viewIdResName: ");
        sb2.append(F());
        sb2.append("; uniqueId: ");
        sb2.append(E());
        sb2.append("; checkable: ");
        sb2.append(J());
        sb2.append("; checked: ");
        sb2.append(o());
        sb2.append("; fieldRequired: ");
        sb2.append(O());
        sb2.append("; focusable: ");
        sb2.append(P());
        sb2.append("; focused: ");
        sb2.append(Q());
        sb2.append("; selected: ");
        sb2.append(W());
        sb2.append("; clickable: ");
        sb2.append(L());
        sb2.append("; longClickable: ");
        sb2.append(T());
        sb2.append("; contextClickable: ");
        sb2.append(M());
        sb2.append("; expandedState: ");
        sb2.append(w(v()));
        sb2.append("; enabled: ");
        sb2.append(N());
        sb2.append("; password: ");
        sb2.append(U());
        sb2.append("; scrollable: " + V());
        sb2.append("; containerTitle: ");
        sb2.append(s());
        sb2.append("; granularScrollingSupported: ");
        sb2.append(R());
        sb2.append("; importantForAccessibility: ");
        sb2.append(S());
        sb2.append("; visible: ");
        sb2.append(Z());
        sb2.append("; isTextSelectable: ");
        sb2.append(Y());
        sb2.append("; accessibilityDataSensitive: ");
        sb2.append(H());
        sb2.append("; [");
        List<a> listG = g();
        for (int i10 = 0; i10 < listG.size(); i10++) {
            a aVar = listG.get(i10);
            String strH = h(aVar.b());
            if (strH.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strH = aVar.c().toString();
            }
            sb2.append(strH);
            if (i10 != listG.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public CharSequence u() {
        return this.f1625a.getError();
    }

    public void u0(CharSequence charSequence) {
        this.f1625a.setError(charSequence);
    }

    public int v() {
        return Build.VERSION.SDK_INT >= 36 ? e.c(this.f1625a) : this.f1625a.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.EXPANDED_STATE_KEY", 0);
    }

    public void v0(boolean z10) {
        this.f1625a.setFocusable(z10);
    }

    public void w0(boolean z10) {
        this.f1625a.setFocused(z10);
    }

    public Bundle x() {
        return this.f1625a.getExtras();
    }

    public void x0(boolean z10) {
        h0(67108864, z10);
    }

    public int y() {
        return this.f1625a.getMaxTextLength();
    }

    public void y0(boolean z10) {
        this.f1625a.setHeading(z10);
    }

    public CharSequence z() {
        return this.f1625a.getPackageName();
    }

    public void z0(CharSequence charSequence) {
        this.f1625a.setHintText(charSequence);
    }
}
