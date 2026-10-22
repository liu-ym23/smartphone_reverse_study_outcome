package b43;

import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements com.bytedance.kmp.ec.yata.event.common.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e f17517a;

    public j(com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e r100) {
        this.f17517a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.i
    public final com.bytedance.kmp.ec.yata.event.common.h e(EventTriggerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "eventTriggerInfo");
        com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e r101 = this.f17517a;
        Intrinsics.checkNotNullParameter(r100, "$this$convertToTriggerInfo");
        String r102 = r100.b();
        r100.a();
        return new com.bytedance.kmp.ec.yata.event.common.h(r101.o(new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.c(r102, ((com.bytedance.kmp.ec.yata.event.common.f) r100.f251649b.getValue()).f251665e)).f164135a);
    }
}
