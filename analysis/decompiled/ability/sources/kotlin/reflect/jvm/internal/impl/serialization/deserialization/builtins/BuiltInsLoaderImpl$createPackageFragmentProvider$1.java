package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import S7.k;
import U8.c;
import Z7.f;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class BuiltInsLoaderImpl$createPackageFragmentProvider$1 extends FunctionReference implements k {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "loadResource";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(c.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        String p02 = (String) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        ((c) this.receiver).getClass();
        return c.a(p02);
    }
}
