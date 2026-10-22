package p2;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f8383c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f8384d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f8385e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f8386f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f8387g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f8388h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f8389i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f8390j;

    /* renamed from: a, reason: collision with root package name */
    public final Object f8391a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8392b;

    /* JADX WARN: Removed duplicated region for block: B:30:0x01d0  */
    static {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.d.<clinit>():void");
    }

    public d(int i2, String str) {
        this(null, i2, str, null);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        Object obj2 = ((d) obj).f8391a;
        Object obj3 = this.f8391a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f8391a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AccessibilityActionCompat: ");
        String strC = h.c(this.f8392b);
        if (strC.equals("ACTION_UNKNOWN")) {
            Object obj = this.f8391a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strC = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb2.append(strC);
        return sb2.toString();
    }

    public d(Object obj, int i2, CharSequence charSequence, Class cls) {
        this.f8392b = i2;
        if (obj == null) {
            this.f8391a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
        } else {
            this.f8391a = obj;
        }
    }
}
