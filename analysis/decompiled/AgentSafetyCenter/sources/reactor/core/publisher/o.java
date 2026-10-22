package reactor.core.publisher;

import java.util.function.Function;
import reactor.util.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class o implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10828a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Logger f10829b;

    public /* synthetic */ o(int i) {
        this.f10828a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10828a;
        Logger logger = this.f10829b;
        String str = (String) obj;
        switch (i) {
            case 0:
                return Flux.lambda$log$24(logger, str);
            default:
                return Mono.lambda$log$25(logger, str);
        }
    }
}
