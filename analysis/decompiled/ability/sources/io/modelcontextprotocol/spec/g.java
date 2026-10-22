package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Predicate;
import v3.C2057a;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4745a;
    public final /* synthetic */ String b;

    public /* synthetic */ g(String str, int i) {
        this.f4745a = i;
        this.b = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4745a) {
            case 0:
                return McpSchema.CreateMessageResult.StopReason.lambda$of$0(this.b, (McpSchema.CreateMessageResult.StopReason) obj);
            case 1:
                return this.b.equals(((C2057a) obj).f6768a);
            default:
                return this.b.equals(((C2057a) obj).f6768a);
        }
    }
}
