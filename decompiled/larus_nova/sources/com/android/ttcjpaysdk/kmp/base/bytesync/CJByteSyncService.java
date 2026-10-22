package com.android.ttcjpaysdk.kmp.base.bytesync;

import com.android.ttcjpaysdk.kmp.base.env.CJEnv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/bytesync/CJByteSyncService;", "", "<init>", "()V", "registerByteSyncService", "", "byteSyncAppID", "", "boeByteSyncAppID", "byteSyncEventListener", "Lcom/android/ttcjpaysdk/kmp/base/bytesync/IKmpByteSyncEventListener;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJByteSyncService {
    public static final int $stable = 0;
    public static final CJByteSyncService INSTANCE = null;

    static {
        INSTANCE = new CJByteSyncService();
    }

    private CJByteSyncService() {
    }

    public final void registerByteSyncService(int r100, int r101, IKmpByteSyncEventListener r102) {
        Intrinsics.checkNotNullParameter(r102, "byteSyncEventListener");
        if (CJEnv.INSTANCE.isBoeEnv() == false) goto L7;
        b r103 = c.f528682a;
        IKmpCJByteSyncService r104 = (IKmpCJByteSyncService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJByteSyncService.class));
        if (r104 == null) goto L11;
        r104.registerByteSyncService(r101, r102);
        return;
    L11:
        return;
    L7:
        b r105 = c.f528682a;
        IKmpCJByteSyncService r106 = (IKmpCJByteSyncService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJByteSyncService.class));
        if (r106 == null) goto L13;
        r106.registerByteSyncService(r100, r102);
        return;
    }
}
