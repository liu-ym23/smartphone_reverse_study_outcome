package C4;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class t extends E {

    /* renamed from: c, reason: collision with root package name */
    private static final y f945c = y.b("application/x-www-form-urlencoded");

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f946a;

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f947b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f948a;

        /* renamed from: b, reason: collision with root package name */
        private final List<String> f949b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final Charset f950c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f948a.add(w.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f950c));
            this.f949b.add(w.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f950c));
            return this;
        }

        public a b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f948a.add(w.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f950c));
            this.f949b.add(w.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f950c));
            return this;
        }

        public t c() {
            return new t(this.f948a, this.f949b);
        }

        public a(@Nullable Charset charset) {
            this.f948a = new ArrayList();
            this.f949b = new ArrayList();
            this.f950c = charset;
        }
    }

    t(List<String> list, List<String> list2) {
        this.f946a = D4.e.t(list);
        this.f947b = D4.e.t(list2);
    }

    private long i(@Nullable L4.f fVar, boolean z5) throws EOFException {
        L4.e eVar = z5 ? new L4.e() : fVar.i();
        int size = this.f946a.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 > 0) {
                eVar.writeByte(38);
            }
            eVar.H(this.f946a.get(i5));
            eVar.writeByte(61);
            eVar.H(this.f947b.get(i5));
        }
        if (!z5) {
            return 0L;
        }
        long size2 = eVar.size();
        eVar.u();
        return size2;
    }

    @Override // C4.E
    public long a() {
        return i(null, true);
    }

    @Override // C4.E
    public y b() {
        return f945c;
    }

    @Override // C4.E
    public void h(L4.f fVar) throws EOFException {
        i(fVar, false);
    }
}
