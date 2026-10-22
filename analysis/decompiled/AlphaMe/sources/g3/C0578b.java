package g3;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: g3.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0578b extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12661a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0580d f12662b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0579c f12663c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0578b(C0580d c0580d, C0579c c0579c, int i4) {
        super(1);
        this.f12661a = i4;
        this.f12662b = c0580d;
        this.f12663c = c0579c;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0579c c0579c = this.f12663c;
        C0580d c0580d = this.f12662b;
        int i4 = this.f12661a;
        switch (i4) {
            case 0:
                switch (i4) {
                    case 0:
                        c0580d.e(c0579c.f12665b);
                        break;
                    default:
                        C0580d.f12667h.set(c0580d, c0579c.f12665b);
                        c0580d.e(c0579c.f12665b);
                        break;
                }
                break;
            default:
                switch (i4) {
                    case 0:
                        c0580d.e(c0579c.f12665b);
                        break;
                    default:
                        C0580d.f12667h.set(c0580d, c0579c.f12665b);
                        c0580d.e(c0579c.f12665b);
                        break;
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
