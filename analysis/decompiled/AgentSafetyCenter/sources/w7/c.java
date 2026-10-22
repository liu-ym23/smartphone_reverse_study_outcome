package w7;

import b8.b0;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15288c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ d f15289f;

    public /* synthetic */ c(int i) {
        this.f15288c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f15288c;
        d dVar = this.f15289f;
        switch (i) {
            case 0:
                return new MessageFormat(dVar.f15296g).format(dVar.f15294e);
            default:
                dVar.f15297h.getClass();
                b.b bVar = dVar.f15297h;
                Object[] objArr = dVar.f15294e;
                int i3 = bVar.f1684c;
                Object obj = bVar.f1685f;
                switch (i3) {
                    case 9:
                        j jVar = (j) obj;
                        p5.i iVar = jVar.f15317j;
                        String str = jVar.i;
                        Locale locale = jVar.f15319l;
                        if (locale == null) {
                            locale = Locale.ROOT;
                        }
                        return iVar.v(str, locale, objArr);
                    default:
                        o oVar = (o) ((androidx.room.q) obj).f1601d;
                        oVar.f15349g.getClass();
                        p5.i iVar2 = a8.a.f231a;
                        String str2 = b0.f1936y.f1938c;
                        oVar.f15349g.getClass();
                        return iVar2.v(str2, Locale.getDefault(), objArr);
                }
        }
    }
}
