package u3;

import com.networknt.schema.keyword.KeywordType;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public String f6696a;
    public A3.a b;
    public j c;
    public A3.a d;
    public Object[] e;
    public HashMap f;
    public String g;
    public B5.a h;
    public String i;

    public e a() {
        Supplier aVar;
        Supplier aVar2;
        String str;
        String str2 = this.i;
        String str3 = this.g;
        if (str3 == null || str3.trim().isEmpty()) {
            final int i = 1;
            aVar = new E3.a(new Supplier(this) { // from class: u3.c
                public final /* synthetic */ d b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i) {
                        case 0:
                            d dVar = this.b;
                            dVar.getClass();
                            return new MessageFormat(dVar.g).format(dVar.e);
                        default:
                            d dVar2 = this.b;
                            dVar2.h.getClass();
                            B5.a aVar3 = dVar2.h;
                            Object[] objArr = dVar2.e;
                            int i6 = aVar3.f193a;
                            Object obj = aVar3.b;
                            switch (i6) {
                                case 21:
                                    g gVar = (g) obj;
                                    u1.d dVar3 = gVar.f6700j;
                                    String str4 = gVar.i;
                                    Locale locale = gVar.k;
                                    if (locale == null) {
                                        locale = Locale.ROOT;
                                    }
                                    return dVar3.T(str4, locale, objArr);
                                default:
                                    k kVar = (k) ((G6.c) obj).d;
                                    kVar.g.getClass();
                                    u1.d dVar4 = y3.a.f6893a;
                                    String str5 = KeywordType.u.f3054a;
                                    kVar.g.getClass();
                                    return dVar4.T(str5, Locale.getDefault(), objArr);
                            }
                    }
                }
            });
        } else {
            str2 = this.g;
            if (!str2.contains("{")) {
                String str4 = this.g;
                Objects.requireNonNull(str4);
                str = str2;
                aVar2 = new com.fasterxml.jackson.core.util.a(str4, 4);
                return new e(this.f6696a, this.b, this.c, this.d, this.e, this.f, str, aVar2);
            }
            final int i6 = 0;
            aVar = new E3.a(new Supplier(this) { // from class: u3.c
                public final /* synthetic */ d b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i6) {
                        case 0:
                            d dVar = this.b;
                            dVar.getClass();
                            return new MessageFormat(dVar.g).format(dVar.e);
                        default:
                            d dVar2 = this.b;
                            dVar2.h.getClass();
                            B5.a aVar3 = dVar2.h;
                            Object[] objArr = dVar2.e;
                            int i62 = aVar3.f193a;
                            Object obj = aVar3.b;
                            switch (i62) {
                                case 21:
                                    g gVar = (g) obj;
                                    u1.d dVar3 = gVar.f6700j;
                                    String str42 = gVar.i;
                                    Locale locale = gVar.k;
                                    if (locale == null) {
                                        locale = Locale.ROOT;
                                    }
                                    return dVar3.T(str42, locale, objArr);
                                default:
                                    k kVar = (k) ((G6.c) obj).d;
                                    kVar.g.getClass();
                                    u1.d dVar4 = y3.a.f6893a;
                                    String str5 = KeywordType.u.f3054a;
                                    kVar.g.getClass();
                                    return dVar4.T(str5, Locale.getDefault(), objArr);
                            }
                    }
                }
            });
        }
        str = str2;
        aVar2 = aVar;
        return new e(this.f6696a, this.b, this.c, this.d, this.e, this.f, str, aVar2);
    }

    public final Object b(String str) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        this.f.put("property", str);
        return (g) this;
    }
}
