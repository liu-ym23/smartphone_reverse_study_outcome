package q0;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* renamed from: q0.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0977y implements U {

    /* renamed from: b, reason: collision with root package name */
    public static final C0977y f19879b = new C0977y();

    /* renamed from: a, reason: collision with root package name */
    private final Member f19880a;

    public C0977y() {
        this.f19880a = null;
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        Member member = this.f19880a;
        if (member == null) {
            c0946i.f19676k.C((Enum) obj);
            return;
        }
        try {
            c0946i.G(member instanceof Field ? ((Field) member).get(obj) : ((Method) member).invoke(obj, null));
        } catch (Exception e6) {
            throw new l0.d("getEnumValue error", e6);
        }
    }

    public C0977y(Member member) {
        this.f19880a = member;
    }
}
