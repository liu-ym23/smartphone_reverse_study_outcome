package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f5066a = null;

    static {
        f5066a = new String[]{"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};
    }

    public f0() {
    }

    public static int d(s r10, int r11) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        int[] r12 = (int[]) r10.f5085a.get("android:visibilityPropagation:center");
        if (r12 != null) goto L9;
        return -1;
    L9:
        return r12[r11];
    }

    @Override // androidx.transition.q
    public void a(s r10) {
        View r11 = r10.f5086b;
        Integer r12 = (Integer) r10.f5085a.get("android:visibility:visibility");
        if (r12 != null) goto L5;
        r12 = Integer.valueOf(r11.getVisibility());
    L5:
        r10.f5085a.put("android:visibilityPropagation:visibility", r12);
        int[] r13 = {r3, 0};
        r11.getLocationOnScreen(r13);
        int r14 = r13[0] + Math.round(r11.getTranslationX());
        r13[0] = r14 + (r11.getWidth() / 2);
        int r15 = r13[1] + Math.round(r11.getTranslationY());
        r13[1] = r15;
        r13[1] = r15 + (r11.getHeight() / 2);
        r10.f5085a.put("android:visibilityPropagation:center", r13);
    }

    @Override // androidx.transition.q
    public String[] b() {
        return f5066a;
    }

    public int e(s r10) {
        if (r10 != null) goto L5;
        return 8;
    L5:
        Integer r11 = (Integer) r10.f5085a.get("android:visibilityPropagation:visibility");
        if (r11 != null) goto L9;
        return 8;
    L9:
        return r11.intValue();
    }

    public int f(s r10) {
        return d(r10, 0);
    }

    public int g(s r10) {
        return d(r10, 1);
    }
}
