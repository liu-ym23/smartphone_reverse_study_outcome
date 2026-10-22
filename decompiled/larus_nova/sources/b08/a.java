package b08;

import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Class<? extends c>, Map<C0249a<?, ? extends View>, b<? extends View, ?>>> f16888d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<C0249a<?, ?>, b<? extends View, ?>> f16889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<C0249a<?, ?>, b<? extends View, ?>> f16890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<b, View> f16891c;

    /* JADX INFO: renamed from: b08.a$a, reason: collision with other inner class name */
    public static class C0249a<M, V extends View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<M> f16892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<V> f16893b;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f16892a, this.f16893b});
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (C0249a.class != r100.getClass()) goto L17;
            C0249a r101 = (C0249a) r100;
            if (Objects.equals(this.f16892a, r101.f16892a) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.f16893b, r101.f16893b) == false) goto L15;
            return true;
        }

        public C0249a(Class<M> r100, Class<V> r101) {
            this.f16892a = r100;
            this.f16893b = r101;
        }
    }

    static {
        f16888d = new HashMap();
    }

    public a() {
        this.f16889a = new LinkedHashMap();
        this.f16890b = new HashMap();
        this.f16891c = new HashMap();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static b c(Map r100, Class r101, Class r102) {
        b r103 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L36;
        Iterator r104 = r100.entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L37;
        Map.Entry r105 = (Map.Entry) r104.next();
        C0249a r106 = (C0249a) r105.getKey();
        boolean r107 = false;
        if (r106.f16892a == r101) goto L13;
    L15:
        boolean r108 = false;
    L16:
        if (r108 == true) goto L35;
        if (r106.f16892a.isAssignableFrom((Class<?>) r101) == true) goto L21;
    L23:
        if (r107 == false) goto L9;
        if (r103 != null) goto L9;
        r103 = (b) r105.getValue();
        goto L9
    L21:
        if (r106.f16893b.isAssignableFrom((Class<?>) r102) == false) goto L23;
        r107 = true;
        goto L23
    L35:
        return (b) r105.getValue();
    L13:
        if (r106.f16893b.isAssignableFrom((Class<?>) r102) == false) goto L15;
        r108 = true;
        goto L16
    L37:
        return r103;
    L36:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Class<? extends c> r100, View r101, Object r102) {
        Class<?> r103 = r102.getClass();
        b r104 = b(r100, r101.getClass(), r103);
        if (r104 == null) goto L6;
        r104.bind(r101, r102);
        ((HashMap) this.f16891c).put(r104, r101);
        return;
    }

    public final b b(Class<? extends c> r100, Class<? extends View> r101, Class<?> r102) {
        C0249a r103 = new C0249a(r102, r101);
        b r104 = (b) ((HashMap) this.f16890b).get(r103);
        if (r104 == null) goto L5;
        return r104;
    L5:
        b r105 = c(this.f16889a, r102, r101);
        if (r105 != null) goto L8;
        r105 = c((Map) ((HashMap) f16888d).get(r100), r102, r101);
    L8:
        if (r105 == null) goto L10;
        ((HashMap) this.f16890b).put(r103, r105);
    L10:
        return r105;
    }

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b<? super V, ? super M> r102) {
        this.f16889a.put(new C0249a(r100, r101), r102);
    }
}
