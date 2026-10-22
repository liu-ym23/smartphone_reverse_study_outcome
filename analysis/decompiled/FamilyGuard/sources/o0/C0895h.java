package o0;

import java.lang.reflect.Type;

/* renamed from: o0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0895h {

    /* renamed from: a, reason: collision with root package name */
    public Object f19017a;

    /* renamed from: b, reason: collision with root package name */
    public final C0895h f19018b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19019c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19020d;

    /* renamed from: e, reason: collision with root package name */
    public Type f19021e;

    /* renamed from: f, reason: collision with root package name */
    private transient String f19022f;

    public C0895h(C0895h c0895h, Object obj, Object obj2) {
        this.f19018b = c0895h;
        this.f19017a = obj;
        this.f19019c = obj2;
        this.f19020d = c0895h == null ? 0 : c0895h.f19020d + 1;
    }

    public String toString() {
        if (this.f19022f == null) {
            if (this.f19018b == null) {
                this.f19022f = "$";
            } else if (this.f19019c instanceof Integer) {
                this.f19022f = this.f19018b.toString() + "[" + this.f19019c + "]";
            } else {
                this.f19022f = this.f19018b.toString() + "." + this.f19019c;
            }
        }
        return this.f19022f;
    }
}
