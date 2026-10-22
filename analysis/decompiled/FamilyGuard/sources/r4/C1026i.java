package r4;

import W3.AbstractC0391b;
import W3.AbstractC0392c;
import W3.C0403n;
import i4.InterfaceC0772l;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import org.libpag.BuildConfig;
import r4.C1026i;

/* renamed from: r4.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1026i implements InterfaceC1025h {

    /* renamed from: a, reason: collision with root package name */
    private final Matcher f20107a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f20108b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC1024g f20109c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f20110d;

    /* renamed from: r4.i$a */
    public static final class a extends AbstractC0392c<String> {
        a() {
        }

        @Override // W3.AbstractC0391b
        public int c() {
            return C1026i.this.d().groupCount() + 1;
        }

        @Override // W3.AbstractC0391b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return h((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean h(String str) {
            return super.contains(str);
        }

        @Override // W3.AbstractC0392c, java.util.List
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public String get(int i5) {
            String strGroup = C1026i.this.d().group(i5);
            return strGroup == null ? BuildConfig.FLAVOR : strGroup;
        }

        @Override // W3.AbstractC0392c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return m((String) obj);
            }
            return -1;
        }

        @Override // W3.AbstractC0392c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return n((String) obj);
            }
            return -1;
        }

        public /* bridge */ int m(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int n(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* renamed from: r4.i$b */
    public static final class b extends AbstractC0391b<C1023f> implements InterfaceC1024g {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C1023f n(b bVar, int i5) {
            return bVar.m(i5);
        }

        @Override // W3.AbstractC0391b
        public int c() {
            return C1026i.this.d().groupCount() + 1;
        }

        @Override // W3.AbstractC0391b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof C1023f) {
                return i((C1023f) obj);
            }
            return false;
        }

        public /* bridge */ boolean i(C1023f c1023f) {
            return super.contains(c1023f);
        }

        @Override // W3.AbstractC0391b, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<C1023f> iterator() {
            return q4.e.f(C0403n.w(C0403n.i(this)), new InterfaceC0772l() { // from class: r4.j
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return C1026i.b.n(this.f20113a, ((Integer) obj).intValue());
                }
            }).iterator();
        }

        public C1023f m(int i5) {
            kotlin.ranges.h hVarF = C1029l.f(C1026i.this.d(), i5);
            if (hVarF.n().intValue() < 0) {
                return null;
            }
            String strGroup = C1026i.this.d().group(i5);
            j4.k.f(strGroup, "group(...)");
            return new C1023f(strGroup, hVarF);
        }
    }

    public C1026i(Matcher matcher, CharSequence charSequence) {
        j4.k.g(matcher, "matcher");
        j4.k.g(charSequence, "input");
        this.f20107a = matcher;
        this.f20108b = charSequence;
        this.f20109c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult d() {
        return this.f20107a;
    }

    @Override // r4.InterfaceC1025h
    public List<String> a() {
        if (this.f20110d == null) {
            this.f20110d = new a();
        }
        List<String> list = this.f20110d;
        j4.k.d(list);
        return list;
    }

    @Override // r4.InterfaceC1025h
    public kotlin.ranges.h b() {
        return C1029l.e(d());
    }

    @Override // r4.InterfaceC1025h
    public String getValue() {
        String strGroup = d().group();
        j4.k.f(strGroup, "group(...)");
        return strGroup;
    }

    @Override // r4.InterfaceC1025h
    public InterfaceC1025h next() {
        int iEnd = d().end() + (d().end() == d().start() ? 1 : 0);
        if (iEnd > this.f20108b.length()) {
            return null;
        }
        Matcher matcher = this.f20107a.pattern().matcher(this.f20108b);
        j4.k.f(matcher, "matcher(...)");
        return C1029l.d(matcher, iEnd, this.f20108b);
    }
}
