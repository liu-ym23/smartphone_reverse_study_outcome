package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f1833f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f1838e;

    static {
    }

    public c() {
        int r10 = f1833f;
        this.f1834a = r10;
        this.f1835b = r10;
        this.f1836c = null;
    }

    public abstract void a(HashMap r10);

    public abstract c b();

    public c c(c r10) {
        this.f1834a = r10.f1834a;
        this.f1835b = r10.f1835b;
        this.f1836c = r10.f1836c;
        this.f1837d = r10.f1837d;
        this.f1838e = r10.f1838e;
        return this;
    }

    public abstract void d(HashSet r10);

    public abstract void e(Context r10, AttributeSet r11);

    public boolean f(String r10) {
        String r11 = this.f1836c;
        if (r11 == null) goto L8;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.matches(r11);
    L8:
        return false;
    }

    public void g(int r10) {
        this.f1834a = r10;
    }

    public void h(HashMap r10) {
    }

    public c i(int r10) {
        this.f1835b = r10;
        return this;
    }

    public boolean j(Object r10) {
        if ((r10 instanceof Boolean) == false) goto L6;
        return ((Boolean) r10).booleanValue();
    L6:
        return Boolean.parseBoolean(r10.toString());
    }

    public float k(Object r10) {
        if ((r10 instanceof Float) == false) goto L6;
        return ((Float) r10).floatValue();
    L6:
        return Float.parseFloat(r10.toString());
    }

    public int l(Object r10) {
        if ((r10 instanceof Integer) == false) goto L6;
        return ((Integer) r10).intValue();
    L6:
        return Integer.parseInt(r10.toString());
    }
}
