package v0;

import A0.e;
import C0.t;
import C0.v;
import H0.n;
import H0.o;
import H0.p;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import z0.InterfaceC1338d;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final p f23264a;

    /* renamed from: b, reason: collision with root package name */
    private final S0.a f23265b;

    /* renamed from: c, reason: collision with root package name */
    private final S0.e f23266c;

    /* renamed from: d, reason: collision with root package name */
    private final S0.f f23267d;

    /* renamed from: e, reason: collision with root package name */
    private final A0.f f23268e;

    /* renamed from: f, reason: collision with root package name */
    private final P0.f f23269f;

    /* renamed from: g, reason: collision with root package name */
    private final S0.b f23270g;

    /* renamed from: h, reason: collision with root package name */
    private final S0.d f23271h = new S0.d();

    /* renamed from: i, reason: collision with root package name */
    private final S0.c f23272i = new S0.c();

    /* renamed from: j, reason: collision with root package name */
    private final D.e<List<Throwable>> f23273j;

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public h() {
        D.e<List<Throwable>> eVarE = Y0.a.e();
        this.f23273j = eVarE;
        this.f23264a = new p(eVarE);
        this.f23265b = new S0.a();
        this.f23266c = new S0.e();
        this.f23267d = new S0.f();
        this.f23268e = new A0.f();
        this.f23269f = new P0.f();
        this.f23270g = new S0.b();
        s(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<C0.i<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f23266c.d(cls, cls2)) {
            for (Class cls5 : this.f23269f.b(cls4, cls3)) {
                arrayList.add(new C0.i(cls, cls4, cls5, this.f23266c.b(cls, cls4), this.f23269f.a(cls4, cls5), this.f23273j));
            }
        }
        return arrayList;
    }

    public <Model, Data> h a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f23264a.a(cls, cls2, oVar);
        return this;
    }

    public <Data, TResource> h b(Class<Data> cls, Class<TResource> cls2, z0.i<Data, TResource> iVar) {
        e("legacy_append", cls, cls2, iVar);
        return this;
    }

    public <Data> h c(Class<Data> cls, InterfaceC1338d<Data> interfaceC1338d) {
        this.f23265b.a(cls, interfaceC1338d);
        return this;
    }

    public <TResource> h d(Class<TResource> cls, z0.j<TResource> jVar) {
        this.f23267d.a(cls, jVar);
        return this;
    }

    public <Data, TResource> h e(String str, Class<Data> cls, Class<TResource> cls2, z0.i<Data, TResource> iVar) {
        this.f23266c.a(str, iVar, cls, cls2);
        return this;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> listB = this.f23270g.b();
        if (listB.isEmpty()) {
            throw new b();
        }
        return listB;
    }

    public <Data, TResource, Transcode> t<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        Class<Data> cls4;
        Class<TResource> cls5;
        Class<Transcode> cls6;
        t<Data, TResource, Transcode> tVarA = this.f23272i.a(cls, cls2, cls3);
        t<Data, TResource, Transcode> tVar = null;
        if (this.f23272i.c(tVarA)) {
            return null;
        }
        if (tVarA != null) {
            return tVarA;
        }
        List<C0.i<Data, TResource, Transcode>> listF = f(cls, cls2, cls3);
        if (listF.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            tVar = new t<>(cls4, cls5, cls6, listF, this.f23273j);
        }
        this.f23272i.d(cls4, cls5, cls6, tVar);
        return tVar;
    }

    public <Model> List<n<Model, ?>> i(Model model) {
        List<n<Model, ?>> listD = this.f23264a.d(model);
        if (listD.isEmpty()) {
            throw new c(model);
        }
        return listD;
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listA = this.f23271h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.f23264a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f23266c.d(it.next(), cls2)) {
                    if (!this.f23269f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f23271h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public <X> z0.j<X> k(v<X> vVar) {
        z0.j<X> jVarB = this.f23267d.b(vVar.d());
        if (jVarB != null) {
            return jVarB;
        }
        throw new d(vVar.d());
    }

    public <X> A0.e<X> l(X x5) {
        return this.f23268e.a(x5);
    }

    public <X> InterfaceC1338d<X> m(X x5) {
        InterfaceC1338d<X> interfaceC1338dB = this.f23265b.b(x5.getClass());
        if (interfaceC1338dB != null) {
            return interfaceC1338dB;
        }
        throw new e(x5.getClass());
    }

    public boolean n(v<?> vVar) {
        return this.f23267d.b(vVar.d()) != null;
    }

    public h o(e.a<?> aVar) {
        this.f23268e.b(aVar);
        return this;
    }

    public h p(ImageHeaderParser imageHeaderParser) {
        this.f23270g.a(imageHeaderParser);
        return this;
    }

    public <TResource, Transcode> h q(Class<TResource> cls, Class<Transcode> cls2, P0.e<TResource, Transcode> eVar) {
        this.f23269f.c(cls, cls2, eVar);
        return this;
    }

    public <Model, Data> h r(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f23264a.f(cls, cls2, oVar);
        return this;
    }

    public final h s(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f23266c.e(arrayList);
        return this;
    }
}
