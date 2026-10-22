package o3;

import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f9135e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f9136f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f9137g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f9138h;
    public static final b i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f9139j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f9140k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f9141l;

    /* renamed from: m, reason: collision with root package name */
    public static final b f9142m;

    /* renamed from: n, reason: collision with root package name */
    public static final b f9143n;

    /* renamed from: o, reason: collision with root package name */
    public static final b f9144o;

    /* renamed from: a, reason: collision with root package name */
    public final Object f9145a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9146b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f9147c;

    /* renamed from: d, reason: collision with root package name */
    public final o f9148d;

    /* JADX WARN: Removed duplicated region for block: B:14:0x01d6  */
    static {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.b.<clinit>():void");
    }

    public b(Object obj, int i3, CharSequence charSequence, o oVar, Class cls) {
        this.f9146b = i3;
        this.f9148d = oVar;
        if (obj == null) {
            this.f9145a = new AccessibilityNodeInfo.AccessibilityAction(i3, charSequence);
        } else {
            this.f9145a = obj;
        }
        this.f9147c = cls;
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f9145a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        Object obj2 = ((b) obj).f9145a;
        Object obj3 = this.f9145a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f9145a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AccessibilityActionCompat: ");
        String strD = e.d(this.f9146b);
        if (strD.equals("ACTION_UNKNOWN")) {
            Object obj = this.f9145a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb2.append(strD);
        return sb2.toString();
    }

    public b(int i3, Class cls) {
        this(null, i3, null, null, cls);
    }

    public b(int i3, String str) {
        this(null, i3, str, null, null);
    }
}
