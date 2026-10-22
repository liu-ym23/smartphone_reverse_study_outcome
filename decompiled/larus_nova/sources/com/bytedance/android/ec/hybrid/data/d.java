package com.bytedance.android.ec.hybrid.data;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkDTO;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements com.bytedance.android.ec.hybrid.data.gecko.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECHybridDataEngine f46662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.hybrid.data.gecko.c f46663b;

    public d(ECHybridDataEngine r100, com.bytedance.android.ec.hybrid.data.gecko.c r101) {
        this.f46662a = r100;
        this.f46663b = r101;
    }

    @Override // com.bytedance.android.ec.hybrid.data.gecko.c
    public final void b(Long r100, Map<String, ECHybridNetworkDTO> r101) {
        Intrinsics.checkNotNullParameter(r101, "apiConfigDTOMap");
        ECHybridDataEngine r102 = this.f46662a;
        r102.f46637k = CollectionsKt.toList(r101.keySet());
        this.f46662a.f46642p.k(r101);
        com.bytedance.android.ec.hybrid.data.gecko.c r103 = this.f46663b;
        if (r103 == null) goto L6;
        r103.b(r100, r101);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.data.gecko.c
    public final void a(Throwable r100, String r101, Long r102) {
        this.f46662a.getClass();
        com.bytedance.android.ec.hybrid.data.gecko.c r103 = this.f46663b;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.data.gecko.c
    public final void c(String r100, Long r101, ECHybridConfigDTO r102, Map<String, ? extends Object> r103) {
        this.f46662a.s(r102, r103);
        com.bytedance.android.ec.hybrid.data.gecko.c r104 = this.f46663b;
        if (r104 == null) goto L6;
        r104.c(r100, r101, r102, null);
        return;
    }
}
