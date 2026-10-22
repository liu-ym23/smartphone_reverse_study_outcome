package com.bytedance.android.shopping.orderlist.list.cache;

import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.kmp.ec.yata.common.protocol.utils.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderCacheManager f180113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f180114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f180115c;

    @Override // com.bytedance.kmp.ec.yata.common.protocol.utils.a
    public final p a(String r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        if (Intrinsics.areEqual(this.f180114b, this.f180113a.f180105b) == false) goto L8;
        if (r101 == null) goto L7;
        r101.i();
        return r101;
    L7:
        return null;
    L8:
        return null;
    }

    public a(OrderCacheManager r100, String r101, Ref.IntRef r102) {
        this.f180113a = r100;
        this.f180114b = r101;
        this.f180115c = r102;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.utils.a
    public final com.bytedance.kmp.ec.yata.common.protocol.utils.a.C3587a b(String r100, String r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        boolean r103 = false;
        if (Intrinsics.areEqual(this.f180114b, this.f180113a.f180105b) == false) goto L25;
        boolean r104 = CollectionsKt.contains(this.f180113a.f180104a.getNodeBlackList(), r101);
        Object r105 = null;
        if (r102 == null) goto L12;
        Object r106 = q.b(r102, Reflection.getOrCreateKotlinClass(Boolean.class), "y_card_tail");
        if ((r106 instanceof Boolean) == false) goto L10;
        r105 = r106;
    L10:
        r105 = (Boolean) r105;
    L12:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L15;
        this.f180115c.element++;
    L15:
        if (this.f180115c.element < this.f180113a.f180104a.getCacheOrderCount()) goto L17;
        boolean r107 = true;
    L19:
        if (r104 == true) goto L23;
        if (r107 == true) goto L23;
        r103 = true;
    L23:
        return new com.bytedance.kmp.ec.yata.common.protocol.utils.a.C3587a(r103, r107);
    L17:
        r107 = false;
        goto L19
    L25:
        return new com.bytedance.kmp.ec.yata.common.protocol.utils.a.C3587a(false, false);
    }
}
