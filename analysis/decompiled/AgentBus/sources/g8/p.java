package g8;

import d7.e0;
import d7.r;
import d7.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public enum p {
    CLASS(true),
    ANNOTATION_CLASS(true),
    TYPE_PARAMETER(false),
    PROPERTY(true),
    FIELD(true),
    LOCAL_VARIABLE(true),
    VALUE_PARAMETER(true),
    CONSTRUCTOR(true),
    FUNCTION(true),
    PROPERTY_GETTER(true),
    PROPERTY_SETTER(true),
    TYPE(false),
    /* JADX INFO: Fake field, exist only in values array */
    EXPRESSION(false),
    FILE(false),
    /* JADX INFO: Fake field, exist only in values array */
    TYPEALIAS(false),
    /* JADX INFO: Fake field, exist only in values array */
    PROPERTY_PARAMETER(false),
    /* JADX INFO: Fake field, exist only in values array */
    STAR_PROJECTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    PROPERTY_PARAMETER(false),
    CLASS_ONLY(false),
    OBJECT(false),
    STANDALONE_OBJECT(false),
    COMPANION_OBJECT(false),
    INTERFACE(false),
    ENUM_CLASS(false),
    ENUM_ENTRY(false),
    LOCAL_CLASS(false),
    /* JADX INFO: Fake field, exist only in values array */
    LOCAL_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY_WITH_BACKING_FIELD(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY_WITH_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY_WITH_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    BACKING_FIELD(true),
    /* JADX INFO: Fake field, exist only in values array */
    INITIALIZER(false),
    /* JADX INFO: Fake field, exist only in values array */
    DESTRUCTURING_DECLARATION(false),
    /* JADX INFO: Fake field, exist only in values array */
    LAMBDA_EXPRESSION(false),
    /* JADX INFO: Fake field, exist only in values array */
    ANONYMOUS_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    OBJECT_LITERAL(false);


    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f3902g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public static final List f3903h;

    /* renamed from: i, reason: collision with root package name */
    public static final List f3904i;

    /* renamed from: j, reason: collision with root package name */
    public static final List f3905j;

    /* renamed from: k, reason: collision with root package name */
    public static final List f3906k;

    /* renamed from: l, reason: collision with root package name */
    public static final List f3907l;

    /* renamed from: m, reason: collision with root package name */
    public static final List f3908m;

    /* renamed from: n, reason: collision with root package name */
    public static final List f3909n;

    /* renamed from: o, reason: collision with root package name */
    public static final List f3910o;

    /* renamed from: p, reason: collision with root package name */
    public static final List f3911p;

    /* renamed from: q, reason: collision with root package name */
    public static final List f3912q;

    /* renamed from: r, reason: collision with root package name */
    public static final List f3913r;

    /* renamed from: s, reason: collision with root package name */
    public static final List f3914s;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3922f;

    static {
        for (p pVar : values()) {
            f3902g.put(pVar.name(), pVar);
        }
        p[] pVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (p pVar2 : pVarArrValues) {
            if (pVar2.f3922f) {
                arrayList.add(pVar2);
            }
        }
        r.q1(arrayList);
        d7.n.x0(values());
        p pVar3 = ANNOTATION_CLASS;
        p pVar4 = CLASS;
        f3903h = s.u0(pVar3, pVar4);
        f3904i = s.u0(LOCAL_CLASS, pVar4);
        f3905j = s.u0(CLASS_ONLY, pVar4);
        p pVar5 = COMPANION_OBJECT;
        p pVar6 = OBJECT;
        f3906k = s.u0(pVar5, pVar6, pVar4);
        f3907l = s.u0(STANDALONE_OBJECT, pVar6, pVar4);
        f3908m = s.u0(INTERFACE, pVar4);
        f3909n = s.u0(ENUM_CLASS, pVar4);
        p pVar7 = ENUM_ENTRY;
        p pVar8 = PROPERTY;
        p pVar9 = FIELD;
        f3910o = s.u0(pVar7, pVar8, pVar9);
        p pVar10 = PROPERTY_SETTER;
        f3911p = a.a.S(pVar10);
        p pVar11 = PROPERTY_GETTER;
        f3912q = a.a.S(pVar11);
        f3913r = a.a.S(FUNCTION);
        p pVar12 = FILE;
        f3914s = a.a.S(pVar12);
        e eVar = e.CONSTRUCTOR_PARAMETER;
        p pVar13 = VALUE_PARAMETER;
        e0.U(new c7.j(eVar, pVar13), new c7.j(e.FIELD, pVar9), new c7.j(e.PROPERTY, pVar8), new c7.j(e.FILE, pVar12), new c7.j(e.PROPERTY_GETTER, pVar11), new c7.j(e.PROPERTY_SETTER, pVar10), new c7.j(e.RECEIVER, pVar13), new c7.j(e.SETTER_PARAMETER, pVar13), new c7.j(e.PROPERTY_DELEGATE_FIELD, pVar9));
    }

    p(boolean z4) {
        this.f3922f = z4;
    }
}
