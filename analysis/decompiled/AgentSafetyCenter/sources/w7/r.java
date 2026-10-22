package w7;

import java.util.Arrays;
import java.util.EnumSet;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'g' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: f, reason: collision with root package name */
    public static final r f15358f;

    /* renamed from: g, reason: collision with root package name */
    public static final r f15359g;

    /* renamed from: h, reason: collision with root package name */
    public static final r f15360h;
    public static final r i;

    /* renamed from: j, reason: collision with root package name */
    public static final r f15361j;

    /* renamed from: k, reason: collision with root package name */
    public static final r f15362k;

    /* renamed from: l, reason: collision with root package name */
    public static final r f15363l;

    /* renamed from: m, reason: collision with root package name */
    public static final r f15364m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ r[] f15365n;

    /* renamed from: c, reason: collision with root package name */
    public final EnumSet f15366c;

    static {
        r rVar = new r("NONE", 0, new q[0]);
        f15358f = rVar;
        q qVar = q.DRAFT_4;
        q qVar2 = q.DRAFT_6;
        q qVar3 = q.DRAFT_7;
        q qVar4 = q.DRAFT_2019_09;
        q qVar5 = q.DRAFT_2020_12;
        r rVar2 = new r("ALL_VERSIONS", 1, new q[]{qVar, qVar2, qVar3, qVar4, qVar5});
        f15359g = rVar2;
        r rVar3 = new r("MIN_DRAFT_6", 2, new q[]{qVar2, qVar3, qVar4, qVar5});
        f15360h = rVar3;
        r rVar4 = new r("DRAFT_6_TO_DRAFT_7", 3, new q[]{qVar2, qVar3});
        i = rVar4;
        r rVar5 = new r("MIN_DRAFT_7", 4, new q[]{qVar3, qVar4, qVar5});
        r rVar6 = new r("MAX_DRAFT_7", 5, new q[]{qVar, qVar2, qVar3});
        f15361j = rVar6;
        r rVar7 = new r("MAX_DRAFT_2019_09", 6, new q[]{qVar, qVar2, qVar3, qVar4});
        r rVar8 = new r("MIN_DRAFT_2019_09", 7, new q[]{qVar4, qVar5});
        f15362k = rVar8;
        r rVar9 = new r("MIN_DRAFT_2020_12", 8, new q[]{qVar5});
        f15363l = rVar9;
        r rVar10 = new r("DRAFT_2019_09", 9, new q[]{qVar4});
        r rVar11 = new r("DRAFT_7", 10, new q[]{qVar3});
        f15364m = rVar11;
        f15365n = new r[]{rVar, rVar2, rVar3, rVar4, rVar5, rVar6, rVar7, rVar8, rVar9, rVar10, rVar11};
    }

    public r(String str, int i3, q[] qVarArr) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(q.class);
        this.f15366c = enumSetNoneOf;
        enumSetNoneOf.addAll(Arrays.asList(qVarArr));
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f15365n.clone();
    }
}
