package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b1 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10764a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Class f10765b;

    public /* synthetic */ b1(int i) {
        this.f10764a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10764a;
        Class cls = this.f10765b;
        switch (i) {
            case 0:
                return (InnerProducer) cls.cast((Scannable) obj);
            default:
                return cls.cast(obj);
        }
    }
}
