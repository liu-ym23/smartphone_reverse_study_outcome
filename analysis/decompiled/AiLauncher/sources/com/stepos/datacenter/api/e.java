package com.stepos.datacenter.api;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.vector.CollectionDescriptor;
import com.stepos.datacenter.vector.CollectionHealthReport;
import e7.o;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/datacenter/api/e;", "", "Lcom/stepos/datacenter/api/DataCenter;", "dc", "<init>", "(Lcom/stepos/datacenter/api/DataCenter;)V", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "descriptor", "Lcom/stepos/datacenter/core/result/DataCenterResult;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/datacenter/vector/CollectionDescriptor;Le9/c;)Ljava/lang/Object;", "", "id", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "c", "(Le9/c;)Ljava/lang/Object;", "Le7/o;", Const.INTENT_KEY_UMID, "()Le7/o;", "Lcom/stepos/datacenter/vector/CollectionHealthReport;", "e", "Lcom/stepos/datacenter/api/DataCenter;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final DataCenter dc;

    public e(DataCenter dc2) {
        p.i(dc2, "dc");
        this.dc = dc2;
    }

    public final Object a(CollectionDescriptor collectionDescriptor, InterfaceC4014c<? super DataCenterResult<CollectionDescriptor>> interfaceC4014c) {
        return CollectionOps.f29809a.a(collectionDescriptor, interfaceC4014c);
    }

    public final Object b(String str, InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c) {
        return CollectionOps.f29809a.b(str, interfaceC4014c);
    }

    public final Object c(InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c) {
        return CollectionOps.f29809a.c(interfaceC4014c);
    }

    public final o d() {
        return DataCenter.INSTANCE.getVectorRegistry$sdk_release();
    }

    public final Object e(InterfaceC4014c<? super CollectionHealthReport> interfaceC4014c) {
        return DiagnosticsOps.f29827a.a(interfaceC4014c);
    }
}
