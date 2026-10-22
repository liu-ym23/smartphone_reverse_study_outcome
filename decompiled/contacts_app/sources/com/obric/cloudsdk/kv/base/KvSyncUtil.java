package com.obric.cloudsdk.kv.base;

import com.android.contacts.ContactSaveService;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KvSyncUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncUtil;", "", "()V", "generateSyncId", "", ContactSaveService.EXTRA_DATA_ID, "", "syncable", "", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvSyncUtil {
    public static final KvSyncUtil INSTANCE = null;

    static {
        INSTANCE = new KvSyncUtil();
    }

    private KvSyncUtil() {
    }

    public final String generateSyncId(long r3, boolean r5) {
        if (r5 == false) goto L5;
        String r2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "randomUUID().toString()");
        return r2;
    L5:
        return String.valueOf(r3 + 10000);
    }
}
