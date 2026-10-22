package L;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.alibaba.fastjson.util.UTF8Decoder;
import com.baidu.platform.comapi.bmsdk.BmLocated;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f1129e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f1130f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f1131g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f1132h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f1133i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f1134j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f1135k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f1136l;

    /* renamed from: a, reason: collision with root package name */
    public final Object f1137a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1138b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f1139c;

    /* renamed from: d, reason: collision with root package name */
    public final r f1140d;

    static {
        new b(1, (String) null);
        new b(2, (String) null);
        new b(4, (String) null);
        new b(8, (String) null);
        f1129e = new b(16, (String) null);
        new b(32, (String) null);
        new b(64, (String) null);
        new b(128, (String) null);
        new b(256, k.class);
        new b(512, k.class);
        new b(1024, l.class);
        new b(2048, l.class);
        f1130f = new b(4096, (String) null);
        f1131g = new b(8192, (String) null);
        new b(16384, (String) null);
        new b(32768, (String) null);
        new b(UTF8Decoder.Surrogate.UCS4_MIN, (String) null);
        new b(131072, p.class);
        f1132h = new b(262144, (String) null);
        f1133i = new b(524288, (String) null);
        f1134j = new b(BmLocated.ALIGN_TOP, (String) null);
        new b(BmLocated.ALIGN_BOTTOM, q.class);
        int i4 = Build.VERSION.SDK_INT;
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, n.class);
        f1135k = new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        f1136l = new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, o.class);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, m.class);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START, R.id.accessibilityActionDragStart, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP, R.id.accessibilityActionDragDrop, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL, R.id.accessibilityActionDragCancel, null, null, null);
        new b(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        new b(i4 >= 34 ? e.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public b(int i4, Class cls) {
        this(null, i4, null, null, cls);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f1137a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        Object obj2 = ((b) obj).f1137a;
        Object obj3 = this.f1137a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f1137a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strD = g.d(this.f1138b);
        if (strD.equals("ACTION_UNKNOWN")) {
            Object obj = this.f1137a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strD);
        return sb.toString();
    }

    public b(int i4, String str) {
        this(null, i4, str, null, null);
    }

    public b(Object obj, int i4, String str, r rVar, Class cls) {
        this.f1138b = i4;
        this.f1140d = rVar;
        if (obj == null) {
            this.f1137a = new AccessibilityNodeInfo.AccessibilityAction(i4, str);
        } else {
            this.f1137a = obj;
        }
        this.f1139c = cls;
    }
}
