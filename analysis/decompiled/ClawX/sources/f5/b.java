package f5;

import a6.y;
import com.stepos.stepclaw.SecurePrefs;
import java.io.Serializable;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements h, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final h f2623a;

    /* renamed from: b, reason: collision with root package name */
    public final f f2624b;

    public b(f element, h left) {
        p.e(left, "left");
        p.e(element, "element");
        this.f2623a = left;
        this.f2624b = element;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int i8 = 2;
            b bVar2 = bVar;
            int i9 = 2;
            while (true) {
                h hVar = bVar2.f2623a;
                bVar2 = hVar instanceof b ? (b) hVar : null;
                if (bVar2 == null) {
                    break;
                }
                i9++;
            }
            b bVar3 = this;
            while (true) {
                h hVar2 = bVar3.f2623a;
                bVar3 = hVar2 instanceof b ? (b) hVar2 : null;
                if (bVar3 == null) {
                    break;
                }
                i8++;
            }
            if (i9 == i8) {
                while (true) {
                    f fVar = this.f2624b;
                    if (!p.a(bVar.o(fVar.getKey()), fVar)) {
                        zA = false;
                        break;
                    }
                    h hVar3 = this.f2623a;
                    if (!(hVar3 instanceof b)) {
                        p.c(hVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        f fVar2 = (f) hVar3;
                        zA = p.a(bVar.o(fVar2.getKey()), fVar2);
                        break;
                    }
                    this = (b) hVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2624b.hashCode() + this.f2623a.hashCode();
    }

    @Override // f5.h
    public final f o(g key) {
        p.e(key, "key");
        while (true) {
            f fVarO = this.f2624b.o(key);
            if (fVarO != null) {
                return fVarO;
            }
            h hVar = this.f2623a;
            if (!(hVar instanceof b)) {
                return hVar.o(key);
            }
            this = (b) hVar;
        }
    }

    @Override // f5.h
    public final h s(g key) {
        p.e(key, "key");
        f fVar = this.f2624b;
        f fVarO = fVar.o(key);
        h hVar = this.f2623a;
        if (fVarO != null) {
            return hVar;
        }
        h hVarS = hVar.s(key);
        return hVarS == hVar ? this : hVarS == i.f2626a ? fVar : new b(fVar, hVarS);
    }

    @Override // f5.h
    public final h t(h context) {
        p.e(context, "context");
        return context == i.f2626a ? this : (h) context.z(this, new y(7));
    }

    public final String toString() {
        return "[" + ((String) z(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, new y(6))) + AbstractJsonLexerKt.END_LIST;
    }

    @Override // f5.h
    public final Object z(Object obj, p5.p pVar) {
        return pVar.invoke(this.f2623a.z(obj, pVar), this.f2624b);
    }
}
