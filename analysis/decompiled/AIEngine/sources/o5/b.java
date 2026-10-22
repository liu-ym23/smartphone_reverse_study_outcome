package o5;

import com.scp.moderation.keyword.model.MatchMode;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import p5.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final ud.a f10758b = ud.b.e(b.class);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10759a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10760a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10761b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10762c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10763d;

        /* renamed from: e, reason: collision with root package name */
        public final String f10764e;

        public a(String str, long j10, int i10, int i11, String str2) {
            this.f10760a = str;
            this.f10761b = j10;
            this.f10762c = i10;
            this.f10763d = i11;
            this.f10764e = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10761b == aVar.f10761b && this.f10762c == aVar.f10762c && this.f10763d == aVar.f10763d && this.f10760a.equals(aVar.f10760a) && this.f10764e.equals(aVar.f10764e);
        }

        public final int hashCode() {
            return Objects.hash(this.f10760a, Long.valueOf(this.f10761b), Integer.valueOf(this.f10762c), Integer.valueOf(this.f10763d), this.f10764e);
        }
    }

    public b(ArrayList arrayList) {
        e eVar = new e();
        EnumMap enumMap = new EnumMap(MatchMode.class);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            q5.b bVar = (q5.b) obj;
            ((List) enumMap.computeIfAbsent(bVar.f11623b, new o5.a(0))).add(bVar);
        }
        ArrayList arrayList2 = new ArrayList();
        MatchMode matchMode = MatchMode.f5549a;
        if (enumMap.containsKey(matchMode)) {
            arrayList2.add(new p5.c((List) enumMap.get(matchMode), eVar));
        }
        MatchMode matchMode2 = MatchMode.f5550b;
        if (enumMap.containsKey(matchMode2)) {
            arrayList2.add(new p5.d((List) enumMap.get(matchMode2), eVar));
        }
        MatchMode matchMode3 = MatchMode.f5551c;
        if (enumMap.containsKey(matchMode3)) {
            arrayList2.add(new f((List) enumMap.get(matchMode3)));
        }
        MatchMode matchMode4 = MatchMode.f5552d;
        if (enumMap.containsKey(matchMode4)) {
            arrayList2.add(new p5.b((List) enumMap.get(matchMode4), eVar));
        }
        this.f10759a = arrayList2;
    }

    public static void a(p5.e eVar, String str, String str2, ArrayList arrayList, int i10) {
        try {
            for (q5.a aVar : eVar.a(str, str2)) {
                if (i10 != 0) {
                    aVar = new q5.a(aVar.f11616a, aVar.f11617b + i10, aVar.f11618c + i10, aVar.f11619d, aVar.f11620e, aVar.f11621f);
                }
                arrayList.add(aVar);
            }
        } catch (Exception e10) {
            f10758b.b("matcher {} failed (skipped): {}", eVar.getClass().getSimpleName(), e10.getClass().getSimpleName());
        }
    }
}
