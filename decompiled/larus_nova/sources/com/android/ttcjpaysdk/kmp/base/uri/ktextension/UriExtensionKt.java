package com.android.ttcjpaysdk.kmp.base.uri.ktextension;

import com.android.ttcjpaysdk.kmp.base.uri.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toUri", "Lcom/android/ttcjpaysdk/kmp/base/uri/Uri;", "", "cj_base_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UriExtensionKt {
    public static final Uri toUri(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Uri.Companion.parse(r100);
    }
}
