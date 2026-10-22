package com.android.ttcjpaysdk.base.ktextension;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isNotNullOrEmpty", "", "", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJStringExtensionKt {
    public static final boolean isNotNullOrEmpty(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }
}
