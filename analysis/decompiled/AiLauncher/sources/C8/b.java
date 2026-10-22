package C8;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: C8.b$b, reason: collision with other inner class name */
    public static class C0019b extends b {

        /* renamed from: C8.b$b$a */
        public static class a implements Iterable<c> {

            /* renamed from: a, reason: collision with root package name */
            public final String f1729a;

            /* renamed from: C8.b$b$a$a, reason: collision with other inner class name */
            public class C0020a implements Iterator<c> {

                /* renamed from: a, reason: collision with root package name */
                public final c f1730a;

                /* renamed from: b, reason: collision with root package name */
                public final StringBuilder f1731b;

                /* renamed from: c, reason: collision with root package name */
                public final int f1732c;

                /* renamed from: d, reason: collision with root package name */
                public int f1733d;

                public C0020a() {
                    this.f1730a = new c();
                    this.f1731b = new StringBuilder();
                    this.f1732c = a.this.f1729a.length();
                }

                public final boolean a() {
                    return b(this.f1730a.a(), this.f1730a.c());
                }

                public final boolean b(String str, String str2) {
                    return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
                }

                @Override // java.util.Iterator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public c next() {
                    if (a()) {
                        return this.f1730a;
                    }
                    throw new NoSuchElementException();
                }

                public final void d() {
                    this.f1730a.b("", "");
                    this.f1731b.setLength(0);
                    String strTrim = null;
                    boolean z10 = false;
                    String strTrim2 = null;
                    for (int i10 = this.f1733d; i10 < this.f1732c; i10++) {
                        char cCharAt = a.this.f1729a.charAt(i10);
                        if (strTrim == null) {
                            if (':' == cCharAt) {
                                if (this.f1731b.length() > 0) {
                                    strTrim = this.f1731b.toString().trim();
                                }
                                this.f1731b.setLength(0);
                            } else if (';' == cCharAt) {
                                this.f1731b.setLength(0);
                            } else if (Character.isWhitespace(cCharAt)) {
                                if (this.f1731b.length() > 0) {
                                    z10 = true;
                                }
                            } else if (z10) {
                                this.f1731b.setLength(0);
                                this.f1731b.append(cCharAt);
                                z10 = false;
                            } else {
                                this.f1731b.append(cCharAt);
                            }
                        } else if (strTrim2 != null) {
                            continue;
                        } else if (Character.isWhitespace(cCharAt)) {
                            if (this.f1731b.length() > 0) {
                                this.f1731b.append(cCharAt);
                            }
                        } else if (';' == cCharAt) {
                            strTrim2 = this.f1731b.toString().trim();
                            this.f1731b.setLength(0);
                            if (b(strTrim, strTrim2)) {
                                this.f1733d = i10 + 1;
                                this.f1730a.b(strTrim, strTrim2);
                                return;
                            }
                        } else {
                            this.f1731b.append(cCharAt);
                        }
                    }
                    if (strTrim == null || this.f1731b.length() <= 0) {
                        return;
                    }
                    this.f1730a.b(strTrim, this.f1731b.toString().trim());
                    this.f1733d = this.f1732c;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    d();
                    return a();
                }
            }

            public a(String str) {
                this.f1729a = str;
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return new C0020a();
            }
        }

        @Override // C8.b
        public Iterable<c> b(String str) {
            return new a(str);
        }
    }

    public static b a() {
        return new C0019b();
    }

    public abstract Iterable<c> b(String str);
}
