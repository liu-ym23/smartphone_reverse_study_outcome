package com.android.ttcjpaysdk.kmp.base.extension;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"nullBeFalse", "", "getNullBeFalse", "(Ljava/lang/Boolean;)Z", "nullBeTrue", "getNullBeTrue", "cj_base_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CJKtExtensionKt {
    public static final boolean getNullBeFalse(Boolean r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.booleanValue();
    }

    public static final boolean getNullBeTrue(Boolean r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        return r100.booleanValue();
    }
}
