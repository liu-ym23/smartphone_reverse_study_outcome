package f0;

import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f2531e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f2532f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f2533g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f2534h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f2535i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f2536j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f2537k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f2538l;

    /* renamed from: a, reason: collision with root package name */
    public final Object f2539a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2540b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f2541c;
    public final p d;

    /* JADX WARN: Removed duplicated region for block: B:30:0x01ee  */
    static {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.c.<clinit>():void");
    }

    public c(int i8) {
        this(null, i8, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f2539a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        Object obj2 = ((c) obj).f2539a;
        Object obj3 = this.f2539a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f2539a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strD = g.d(this.f2540b);
        if (strD.equals("ACTION_UNKNOWN")) {
            Object obj = this.f2539a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strD);
        return sb.toString();
    }

    public c(Class cls, int i8) {
        this(null, i8, null, null, cls);
    }

    public c(Object obj, int i8, String str, p pVar, Class cls) {
        this.f2540b = i8;
        this.d = pVar;
        if (obj == null) {
            this.f2539a = new AccessibilityNodeInfo.AccessibilityAction(i8, str);
        } else {
            this.f2539a = obj;
        }
        this.f2541c = cls;
    }
}
