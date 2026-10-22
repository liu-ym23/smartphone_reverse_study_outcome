package o7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.DirSkillLoader$Builder;
import com.zyql.protobuf.agent.InlineSkill$Builder;
import com.zyql.protobuf.agent.Skill$Builder;
import com.zyql.protobuf.agent.Skill$SkillCase;

/* loaded from: classes2.dex */
public final class x extends GeneratedMessageLite implements Y1 {
    private static final x DEFAULT_INSTANCE;
    public static final int DIR_SKILL_LOADER_FIELD_NUMBER = 2;
    public static final int INLINE_SKILL_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private int skillCase_ = 0;
    private Object skill_;

    static {
        x xVar = new x();
        DEFAULT_INSTANCE = xVar;
        GeneratedMessageLite.C(x.class, xVar);
    }

    public static void D(x xVar) {
        if (xVar.skillCase_ == 2) {
            xVar.skillCase_ = 0;
            xVar.skill_ = null;
        }
    }

    public static void E(x xVar) {
        if (xVar.skillCase_ == 1) {
            xVar.skillCase_ = 0;
            xVar.skill_ = null;
        }
    }

    public static void F(x xVar) {
        xVar.skillCase_ = 0;
        xVar.skill_ = null;
    }

    public static void G(x xVar, C1771g c1771g) {
        xVar.getClass();
        c1771g.getClass();
        if (xVar.skillCase_ != 2 || xVar.skill_ == C1771g.J()) {
            xVar.skill_ = c1771g;
        } else {
            xVar.skill_ = ((DirSkillLoader$Builder) C1771g.O((C1771g) xVar.skill_).mergeFrom((GeneratedMessageLite) c1771g)).m();
        }
        xVar.skillCase_ = 2;
    }

    public static void H(x xVar, r rVar) {
        xVar.getClass();
        rVar.getClass();
        if (xVar.skillCase_ != 1 || xVar.skill_ == r.R()) {
            xVar.skill_ = rVar;
        } else {
            xVar.skill_ = ((InlineSkill$Builder) r.Z((r) xVar.skill_).mergeFrom((GeneratedMessageLite) rVar)).m();
        }
        xVar.skillCase_ = 1;
    }

    public static void I(x xVar, C1771g c1771g) {
        xVar.getClass();
        c1771g.getClass();
        xVar.skill_ = c1771g;
        xVar.skillCase_ = 2;
    }

    public static void J(x xVar, r rVar) {
        xVar.getClass();
        rVar.getClass();
        xVar.skill_ = rVar;
        xVar.skillCase_ = 1;
    }

    public final C1771g L() {
        return this.skillCase_ == 2 ? (C1771g) this.skill_ : C1771g.J();
    }

    public final r M() {
        return this.skillCase_ == 1 ? (r) this.skill_ : r.R();
    }

    public final Skill$SkillCase N() {
        int i = this.skillCase_;
        if (i == 0) {
            return Skill$SkillCase.c;
        }
        if (i == 1) {
            return Skill$SkillCase.f4255a;
        }
        if (i != 2) {
            return null;
        }
        return Skill$SkillCase.b;
    }

    public final boolean O() {
        return this.skillCase_ == 2;
    }

    public final boolean P() {
        return this.skillCase_ == 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object r(GeneratedMessageLite.MethodToInvoke methodToInvoke) {
        InterfaceC0955j2 c0922b1;
        switch (methodToInvoke.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"skill_", "skillCase_", r.class, C1771g.class});
            case 3:
                return new x();
            case 4:
                return new Skill$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (x.class) {
                    try {
                        c0922b1 = PARSER;
                        if (c0922b1 == null) {
                            c0922b1 = new C0922b1(DEFAULT_INSTANCE);
                            PARSER = c0922b1;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c0922b1;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
