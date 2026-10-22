package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
public final /* synthetic */ class c0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5908a;
    public final /* synthetic */ Class b;

    public /* synthetic */ c0() {
        this.f5908a = 0;
        this.b = InnerProducer.class;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5908a;
        Class cls = this.b;
        switch (i) {
            case 0:
                return (InnerProducer) cls.cast((Scannable) obj);
            default:
                return cls.cast(obj);
        }
    }

    public /* synthetic */ c0(Class cls) {
        this.f5908a = 1;
        this.b = cls;
    }
}
