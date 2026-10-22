package A8;

import A8.b;
import Yb.u;
import Zb.d;
import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableCell;
import u8.AbstractC5589a;
import u8.m;
import u8.v;

/* loaded from: classes4.dex */
public class a extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final e f1239a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1240b;

    /* renamed from: A8.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0001a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1241a;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            f1241a = iArr;
            try {
                iArr[TableCell.Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1241a[TableCell.Alignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final A8.e f1242a;

        /* renamed from: b, reason: collision with root package name */
        public List<b.d> f1243b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1244c;

        /* renamed from: d, reason: collision with root package name */
        public int f1245d;

        /* renamed from: A8.a$b$a, reason: collision with other inner class name */
        public class C0002a implements m.c<TableCell> {
            public C0002a() {
            }

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(m mVar, TableCell tableCell) {
                int length = mVar.length();
                mVar.g(tableCell);
                if (b.this.f1243b == null) {
                    b.this.f1243b = new ArrayList(2);
                }
                b.this.f1243b.add(new b.d(b.i(tableCell.m()), mVar.builder().i(length)));
                b.this.f1244c = tableCell.n();
            }
        }

        /* renamed from: A8.a$b$b, reason: collision with other inner class name */
        public class C0003b implements m.c<Rb.c> {
            public C0003b() {
            }

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(m mVar, Rb.c cVar) {
                b.this.j(mVar, cVar);
            }
        }

        public class c implements m.c<Rb.d> {
            public c() {
            }

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(m mVar, Rb.d dVar) {
                b.this.j(mVar, dVar);
            }
        }

        public class d implements m.c<Rb.b> {
            public d() {
            }

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(m mVar, Rb.b bVar) {
                mVar.g(bVar);
                b.this.f1245d = 0;
            }
        }

        public class e implements m.c<Rb.a> {
            public e() {
            }

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(m mVar, Rb.a aVar) {
                mVar.q(aVar);
                int length = mVar.length();
                mVar.g(aVar);
                mVar.d(length, new A8.d());
                mVar.v(aVar);
            }
        }

        public b(A8.e eVar) {
            this.f1242a = eVar;
        }

        public static int i(TableCell.Alignment alignment) {
            if (alignment == null) {
                return 0;
            }
            int i10 = C0001a.f1241a[alignment.ordinal()];
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 != 2) {
                    return 0;
                }
            }
            return i11;
        }

        public void g() {
            this.f1243b = null;
            this.f1244c = false;
            this.f1245d = 0;
        }

        public void h(m.b bVar) {
            bVar.a(Rb.a.class, new e()).a(Rb.b.class, new d()).a(Rb.d.class, new c()).a(Rb.c.class, new C0003b()).a(TableCell.class, new C0002a());
        }

        public final void j(m mVar, u uVar) {
            int length = mVar.length();
            mVar.g(uVar);
            if (this.f1243b != null) {
                v vVarBuilder = mVar.builder();
                int length2 = vVarBuilder.length();
                boolean z10 = length2 > 0 && '\n' != vVarBuilder.charAt(length2 - 1);
                if (z10) {
                    mVar.B();
                }
                vVarBuilder.append((char) 160);
                A8.b bVar = new A8.b(this.f1242a, this.f1243b, this.f1244c, this.f1245d % 2 == 1);
                this.f1245d = this.f1244c ? 0 : this.f1245d + 1;
                if (z10) {
                    length++;
                }
                mVar.d(length, bVar);
                this.f1243b = null;
            }
        }
    }

    public a(e eVar) {
        this.f1239a = eVar;
        this.f1240b = new b(eVar);
    }

    public static a l(Context context) {
        return new a(e.g(context));
    }

    @Override // u8.AbstractC5589a, u8.i
    public void c(m.b bVar) {
        this.f1240b.h(bVar);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void d(u uVar) {
        this.f1240b.g();
    }

    @Override // u8.AbstractC5589a, u8.i
    public void e(TextView textView) {
        c.b(textView);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void h(d.b bVar) {
        bVar.i(Collections.singleton(Rb.e.c()));
    }

    @Override // u8.AbstractC5589a, u8.i
    public void j(TextView textView, Spanned spanned) {
        c.c(textView);
    }
}
