package ya;

import Z8.C1173v;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import ra.InterfaceC5238k;
import za.InterfaceC6465k;

/* renamed from: ya.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5989d extends AbstractC5990d0 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f44068e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC6465k f44069b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f44070c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5238k f44071d;

    /* renamed from: ya.d$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public AbstractC5989d(InterfaceC6465k originalTypeVariable, boolean z10) {
        kotlin.jvm.internal.p.i(originalTypeVariable, "originalTypeVariable");
        this.f44069b = originalTypeVariable;
        this.f44070c = z10;
        this.f44071d = Aa.i.b(ErrorScopeKind.STUB_TYPE_SCOPE, originalTypeVariable.toString());
    }

    @Override // ya.S
    public List<B0> F0() {
        return C1173v.m();
    }

    @Override // ya.S
    public s0 G0() {
        return s0.f44124b.k();
    }

    @Override // ya.S
    public boolean I0() {
        return this.f44070c;
    }

    @Override // ya.K0
    /* renamed from: O0 */
    public AbstractC5990d0 L0(boolean z10) {
        return z10 == I0() ? this : R0(z10);
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return this;
    }

    public final InterfaceC6465k Q0() {
        return this.f44069b;
    }

    public abstract AbstractC5989d R0(boolean z10);

    @Override // ya.K0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public AbstractC5989d R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // ya.S
    public InterfaceC5238k m() {
        return this.f44071d;
    }
}
