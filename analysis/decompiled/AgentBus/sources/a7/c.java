package a7;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f407a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f408b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f409c;

    public /* synthetic */ c(Object obj, boolean z4, int i2) {
        this.f407a = i2;
        this.f409c = obj;
        this.f408b = z4;
    }

    public void a() {
        this.f408b = false;
    }

    public void b(char c10) {
        d1.b bVar = (d1.b) this.f409c;
        bVar.f(bVar.f2767g, 1);
        char[] cArr = (char[]) bVar.f2768h;
        int i2 = bVar.f2767g;
        bVar.f2767g = i2 + 1;
        cArr[i2] = c10;
    }

    public void c() {
    }

    public void d() {
    }

    public String toString() {
        switch (this.f407a) {
            case 3:
                return this.f408b ? "FALL_THROUGH" : String.valueOf(this.f409c);
            default:
                return super.toString();
        }
    }

    public c(String str, b bVar) {
        this.f407a = 0;
        this.f409c = bVar;
        this.f408b = !TextUtils.isEmpty(str);
    }

    public c(d1.b bVar) {
        this.f407a = 4;
        this.f409c = bVar;
        this.f408b = true;
    }

    public c(boolean z4, String str) {
        this.f407a = 1;
        this.f408b = z4;
        this.f409c = str;
    }
}
