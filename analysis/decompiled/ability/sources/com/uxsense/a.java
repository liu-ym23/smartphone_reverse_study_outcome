package com.uxsense;

import S7.k;
import java.io.Serializable;
import java.nio.file.Path;
import kotlin.jvm.internal.Ref$IntRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4193a;
    public final /* synthetic */ Serializable b;

    public /* synthetic */ a(Serializable serializable, int i) {
        this.f4193a = i;
        this.b = serializable;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f4193a;
        Serializable serializable = this.b;
        switch (i) {
            case 0:
                return ApexMetadataManager.getCacheFileCount$lambda$13$lambda$11((Ref$IntRef) serializable, (Path) obj);
            default:
                return ApexMetadataManager.clearAppCache$lambda$23$lambda$21((String) serializable, (Path) obj);
        }
    }
}
