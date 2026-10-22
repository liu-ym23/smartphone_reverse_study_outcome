package l3;

import com.google.firebase.encoders.EncodingException;
import j3.InterfaceC4763a;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import j3.InterfaceC4768f;
import j3.g;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import k3.InterfaceC4812a;

/* loaded from: classes2.dex */
public final class d implements k3.b<d> {

    /* renamed from: e, reason: collision with root package name */
    public static final InterfaceC4766d<Object> f36946e = C4870a.b();

    /* renamed from: f, reason: collision with root package name */
    public static final InterfaceC4768f<String> f36947f = l3.b.b();

    /* renamed from: g, reason: collision with root package name */
    public static final InterfaceC4768f<Boolean> f36948g = c.b();

    /* renamed from: h, reason: collision with root package name */
    public static final b f36949h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, InterfaceC4766d<?>> f36950a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, InterfaceC4768f<?>> f36951b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC4766d<Object> f36952c = f36946e;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36953d = false;

    public class a implements InterfaceC4763a {
        public a() {
        }

        @Override // j3.InterfaceC4763a
        public void a(Object obj, Writer writer) throws IOException {
            e eVar = new e(writer, d.this.f36950a, d.this.f36951b, d.this.f36952c, d.this.f36953d);
            eVar.f(obj, false);
            eVar.m();
        }

        @Override // j3.InterfaceC4763a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    public static final class b implements InterfaceC4768f<Date> {

        /* renamed from: a, reason: collision with root package name */
        public static final DateFormat f36955a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f36955a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        @Override // j3.InterfaceC4764b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, g gVar) throws IOException {
            gVar.c(f36955a.format(date));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f36947f);
        m(Boolean.class, f36948g);
        m(Date.class, f36949h);
    }

    public static /* synthetic */ void i(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public InterfaceC4763a f() {
        return new a();
    }

    public d g(InterfaceC4812a interfaceC4812a) {
        interfaceC4812a.a(this);
        return this;
    }

    public d h(boolean z10) {
        this.f36953d = z10;
        return this;
    }

    @Override // k3.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public <T> d a(Class<T> cls, InterfaceC4766d<? super T> interfaceC4766d) {
        this.f36950a.put(cls, interfaceC4766d);
        this.f36951b.remove(cls);
        return this;
    }

    public <T> d m(Class<T> cls, InterfaceC4768f<? super T> interfaceC4768f) {
        this.f36951b.put(cls, interfaceC4768f);
        this.f36950a.remove(cls);
        return this;
    }
}
