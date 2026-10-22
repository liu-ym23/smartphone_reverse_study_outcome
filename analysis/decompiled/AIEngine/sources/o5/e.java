package o5;

import com.scp.moderation.keyword.model.MatchType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import mb.y;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f10767b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final b f10768a = f10767b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final vd.a f10769a;

        public a() {
            vd.a aVar = new vd.a();
            yc.a aVar2 = yc.a.f14203b;
            this.f10769a = aVar;
            aVar.f13523b = aVar2;
            aVar.f13524c = yc.a.f14204c;
            aVar.f13522a = yc.b.f14207b;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @FunctionalInterface
    public interface b {
    }

    public final String a(MatchType matchType, String str) {
        String[] strArrA;
        int iOrdinal = matchType.ordinal();
        if (iOrdinal == 0) {
            androidx.coordinatorlayout.widget.a aVar = j4.a.f9695a;
            y yVar = (y) aVar.f1476d;
            vd.a aVar2 = (vd.a) aVar.f1473a;
            yVar.getClass();
            d4.a aVar3 = (d4.a) aVar2.f13523b;
            return y.s(str, aVar2, aVar3.b(), aVar3.a());
        }
        if (iOrdinal == 1) {
            androidx.coordinatorlayout.widget.a aVar4 = j4.a.f9695a;
            y yVar2 = (y) aVar4.f1476d;
            vd.a aVar5 = (vd.a) aVar4.f1473a;
            yVar2.getClass();
            d4.a aVar6 = (d4.a) aVar5.f13523b;
            return y.s(str, aVar5, aVar6.d(), aVar6.c());
        }
        if (iOrdinal != 2) {
            throw new IllegalStateException("unknown matchType: " + matchType);
        }
        a aVar7 = (a) this.f10768a;
        aVar7.getClass();
        StringBuilder sb2 = new StringBuilder(str.length() * 2);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            try {
                strArrA = xc.b.a(cCharAt, aVar7.f10769a);
            } catch (BadHanyuPinyinOutputFormatCombination unused) {
                strArrA = null;
            }
            if (strArrA == null || strArrA.length == 0) {
                sb2.append(cCharAt);
            } else {
                sb2.append(strArrA[0]);
            }
        }
        return sb2.toString();
    }

    public final ArrayList b(q5.b bVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(3);
        Iterator<MatchType> it = bVar.f11627f.iterator();
        while (it.hasNext()) {
            String strA = a(it.next(), bVar.f11622a);
            if (!strA.isEmpty()) {
                linkedHashSet.add(strA);
            }
        }
        return new ArrayList(linkedHashSet);
    }
}
