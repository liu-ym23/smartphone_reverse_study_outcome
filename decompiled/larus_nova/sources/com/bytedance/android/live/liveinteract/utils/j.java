package com.bytedance.android.live.liveinteract.utils;

import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static /* synthetic */ void a(int r100, String r101, int r102, String r103, Map r110, int r111) {
        ff0.d r104 = ff0.d.f476647a;
        if ((r111 & 4) == 0) goto L5;
        int r105 = 0;
    L7:
        if ((r111 & 8) == 0) goto L9;
        r103 = "";
    L9:
        String r106 = r103;
        if ((r111 & 16) == 0) goto L12;
        r110 = null;
    L12:
        r104.a(r100, r101, r105, r106, r110);
        return;
    L5:
        r105 = r102;
        goto L7
    }
}
