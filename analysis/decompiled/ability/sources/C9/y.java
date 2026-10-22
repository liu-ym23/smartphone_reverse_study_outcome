package C9;

import B9.G;
import B9.h0;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class y implements z9.g {
    public static final y b = new y();
    public static final String c = "kotlinx.serialization.json.JsonObject";

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G f336a;

    public y() {
        h0 h0Var = h0.f242a;
        n nVar = n.f330a;
        z9.g keyDesc = h0Var.getDescriptor();
        z9.g valueDesc = nVar.getDescriptor();
        kotlin.jvm.internal.k.f(keyDesc, "keyDesc");
        kotlin.jvm.internal.k.f(valueDesc, "valueDesc");
        this.f336a = new G("kotlin.collections.LinkedHashMap", keyDesc, valueDesc);
    }

    @Override // z9.g
    public final boolean b() {
        this.f336a.getClass();
        return false;
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.f336a.c(name);
    }

    @Override // z9.g
    public final int d() {
        this.f336a.getClass();
        return 2;
    }

    @Override // z9.g
    public final String e(int i) {
        this.f336a.getClass();
        return String.valueOf(i);
    }

    @Override // z9.g
    public final List f(int i) {
        return this.f336a.f(i);
    }

    @Override // z9.g
    public final z9.g g(int i) {
        return this.f336a.g(i);
    }

    @Override // z9.g
    public final List getAnnotations() {
        this.f336a.getClass();
        return EmptyList.f4893a;
    }

    @Override // z9.g
    public final H4.o getKind() {
        this.f336a.getClass();
        return z9.k.e;
    }

    @Override // z9.g
    public final String h() {
        return c;
    }

    @Override // z9.g
    public final boolean i(int i) {
        this.f336a.i(i);
        return false;
    }

    @Override // z9.g
    public final boolean isInline() {
        this.f336a.getClass();
        return false;
    }
}
