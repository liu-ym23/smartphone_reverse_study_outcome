package a6;

import com.stepos.stepclaw.openclaw.memory.MemoryTools;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import kotlinx.serialization.json.Json;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements p5.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f227a;

    public /* synthetic */ y(int i8) {
        this.f227a = i8;
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        f5.b bVar;
        Object obj3;
        switch (this.f227a) {
            case 0:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                obj3 = bool;
                break;
            case 1:
                return ((f5.h) obj).t((f5.f) obj2);
            case 2:
                return ((f5.h) obj).t((f5.f) obj2);
            case 3:
                return MemoryTools.search$lambda$1((Map) obj, (Json) obj2);
            case 4:
                return MemoryTools.get$lambda$1((Map) obj, (Json) obj2);
            case 5:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 6:
                String acc = (String) obj;
                f5.f element = (f5.f) obj2;
                kotlin.jvm.internal.p.e(acc, "acc");
                kotlin.jvm.internal.p.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 7:
                f5.h acc2 = (f5.h) obj;
                f5.f element2 = (f5.f) obj2;
                kotlin.jvm.internal.p.e(acc2, "acc");
                kotlin.jvm.internal.p.e(element2, "element");
                f5.h hVarS = acc2.s(element2.getKey());
                f5.i iVar = f5.i.f2626a;
                if (hVarS == iVar) {
                    return element2;
                }
                f5.d dVar = f5.d.f2625a;
                f5.e eVar = (f5.e) hVarS.o(dVar);
                if (eVar == null) {
                    bVar = new f5.b(element2, hVarS);
                } else {
                    f5.h hVarS2 = hVarS.s(dVar);
                    if (hVarS2 == iVar) {
                        return new f5.b(eVar, element2);
                    }
                    bVar = new f5.b(eVar, new f5.b(element2, hVarS2));
                }
                return bVar;
            case 8:
                f5.f fVar = (f5.f) obj2;
                if (!(fVar instanceof y1)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? fVar : Integer.valueOf(iIntValue + 1);
            case 9:
                y1 y1Var = (y1) obj;
                f5.f fVar2 = (f5.f) obj2;
                if (y1Var != null) {
                    return y1Var;
                }
                if (fVar2 instanceof y1) {
                    return (y1) fVar2;
                }
                return null;
            case 10:
                obj3 = (f6.u) obj;
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                CharSequence s8 = (CharSequence) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                kotlin.jvm.internal.p.e(s8, "s");
                return Character.valueOf(s8.charAt(iIntValue2));
            case 12:
                k4.w m3 = (k4.w) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                kotlin.jvm.internal.p.e(m3, "m");
                return Character.valueOf(m3.f3640a.charAt(iIntValue3));
            default:
                IOException exception = (IOException) obj2;
                kotlin.jvm.internal.p.e((File) obj, "<unused var>");
                kotlin.jvm.internal.p.e(exception, "exception");
                throw exception;
        }
        return obj3;
    }
}
