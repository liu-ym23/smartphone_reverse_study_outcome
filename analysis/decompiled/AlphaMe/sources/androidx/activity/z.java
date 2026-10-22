package androidx.activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes.dex */
public final /* synthetic */ class z extends FunctionReferenceImpl implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2455a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(int i4, A a4) {
        super(0, a4, A.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        this.f2455a = i4;
        if (i4 != 1) {
        } else {
            super(0, a4, A.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i4 = this.f2455a;
        switch (i4) {
            case 0:
                switch (i4) {
                    case 0:
                        ((A) this.receiver).c();
                        break;
                    default:
                        ((A) this.receiver).c();
                        break;
                }
                break;
            default:
                switch (i4) {
                    case 0:
                        ((A) this.receiver).c();
                        break;
                    default:
                        ((A) this.receiver).c();
                        break;
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
