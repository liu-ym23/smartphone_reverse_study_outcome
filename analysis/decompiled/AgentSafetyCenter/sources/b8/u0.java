package b8;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class u0 implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2027c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f2028f;

    public /* synthetic */ u0(int i) {
        this.f2027c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f2027c;
        String str = this.f2028f;
        switch (i) {
            case 0:
                return str.equals(((x7.a) obj).f15584a);
            case 1:
                return str.equals(((x7.a) obj).f15584a);
            default:
                return McpSchema.CreateMessageResult.StopReason.lambda$of$0(str, (McpSchema.CreateMessageResult.StopReason) obj);
        }
    }
}
