package b43;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends com.bytedance.kmp.ec.yata.store.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e f17515a;

    public h(com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e r100) {
        this.f17515a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.core.a
    public final void b(com.bytedance.kmp.ec.yata.store.core.a.C3594a r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        Intrinsics.checkNotNullParameter(r100, "modifier");
        com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e r101 = this.f17515a;
        String r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        q33.a r103 = r101.k(r102, r100.d());
        if (r103.f164135a == false) goto L13;
        Map<String, Object> r104 = r103.f531497b;
        if (r104 == null) goto L15;
        Iterator<Map.Entry<String, Object>> r105 = r104.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L16;
        Map.Entry<String, Object> r106 = r105.next();
        r100.e(r106.getKey(), r106.getValue());
        goto L11
    L16:
        return;
    L15:
        return;
    }
}
