package b43;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements com.bytedance.kmp.ec.yata.event.ability.tracker.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e f17516a;

    public i(com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e r100) {
        this.f17516a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.ability.tracker.c
    public final com.bytedance.kmp.ec.yata.event.ability.tracker.b c(com.bytedance.kmp.ec.yata.event.ability.tracker.a r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        String r101 = r100.f251623b;
        Map<String, Object> r102 = r100.f251624c;
        com.bytedance.kmp.ec.yata.event.common.e r103 = r100.f251622a;
        q33.b r104 = this.f17516a.n(new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.b(r101, r102, r103));
        com.bytedance.kmp.ec.yata.chain.event.b r105 = null;
        if (r104.f164135a == false) goto L6;
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r105 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L6:
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(r104.f164135a, r105);
    }
}
