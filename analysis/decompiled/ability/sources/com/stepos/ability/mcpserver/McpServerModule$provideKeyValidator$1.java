package com.stepos.ability.mcpserver;

import k4.c;
import k4.d;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class McpServerModule$provideKeyValidator$1 extends FunctionReferenceImpl implements S7.a {
    @Override // S7.a
    public final Object invoke() {
        d dVar = (d) this.receiver;
        c cVar = dVar.b;
        if (cVar != null) {
            return cVar;
        }
        String packageName = dVar.f4798a.getPackageName();
        k.e(packageName, "getPackageName(...)");
        c cVarA = dVar.a(packageName);
        if (cVarA == null) {
            return null;
        }
        dVar.b = cVarA;
        return cVarA;
    }
}
