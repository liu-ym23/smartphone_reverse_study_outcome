package j;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f5051j = new HashMap();

    @Override // j.f
    public final c a(Object obj) {
        return (c) this.f5051j.get(obj);
    }

    @Override // j.f
    public final Object f(Object obj) {
        Object objF = super.f(obj);
        this.f5051j.remove(obj);
        return objF;
    }
}
