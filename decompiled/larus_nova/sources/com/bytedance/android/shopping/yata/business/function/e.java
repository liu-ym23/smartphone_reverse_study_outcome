package com.bytedance.android.shopping.yata.business.function;

import com.bytedance.android.shopping.yata.business.function.common.RegexCheck;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kl3.a f187582a;

    public static final class a {
    }

    static {
    }

    public e(com.bytedance.android.shopping.buynow.yata.abilities.a r100) {
        Intrinsics.checkNotNullParameter(r100, "abilities");
        this.f187582a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        Map<String, Object> r101 = this.f187582a.c().a(r110);
        if (r101 == null) goto L5;
        Object r102 = r101.get("filter_key");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        r100.element = (String) r102;
        if (this.f187582a.d().b((String) r100.element) == false) goto L12;
        r100.element = "__validate_conf__";
    L12:
        List r103 = CollectionsKt.sortedWith(this.f187582a.c().d(new SelfMultiRegexCheckFunction$onExecuteSync$matchedNodes$1(r100)), new f(this, r100));
        if (r103 == null) goto L21;
        Iterator r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L21;
        com.bytedance.kmp.ec.yata.store.node.c r105 = (com.bytedance.kmp.ec.yata.store.node.c) r104.next();
        String r106 = r105.getKey();
        this.f187582a.c().getClass();
        Intrinsics.checkNotNullParameter(r105, "renderObject");
        Map<String, ? extends Object> r107 = r105.e();
        List r108 = (List) this.f187582a.d().a(r107, ((String) r100.element) + ".validate_rules", CollectionsKt.emptyList());
        int r109 = RegexCheck.f187578a;
        if (this.f187582a.d().b(Boolean.valueOf(RegexCheck.a("selfMultiRegexCheck", this.f187582a, r108, r107, r110, r106))) == false) goto L16;
        int r111 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "no match", null, null, 57);
    L21:
        int r112 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        r102 = null;
        goto L7
    }
}
