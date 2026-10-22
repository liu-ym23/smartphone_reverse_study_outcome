package com.android.ttcjpaysdk.kmp.base.uri;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0014\u001a\u00020\u0000H&J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/Builder;", "", "scheme", "", "opaquePart", "encodedOpaquePart", "authority", "encodedAuthority", "path", "encodedPath", "appendPath", "newSegment", "appendEncodedPath", "query", "encodedQuery", WidgetService.PARAM_FRAGMENT, "encodedFragment", "appendQueryParameter", "key", "value", "clearQuery", "build", "Lcom/android/ttcjpaysdk/kmp/base/uri/Uri;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Builder {
    Builder appendEncodedPath(String r100);

    Builder appendPath(String r100);

    Builder appendQueryParameter(String r100, String r101);

    Builder authority(String r100);

    Uri build();

    Builder clearQuery();

    Builder encodedAuthority(String r100);

    Builder encodedFragment(String r100);

    Builder encodedOpaquePart(String r100);

    Builder encodedPath(String r100);

    Builder encodedQuery(String r100);

    Builder fragment(String r100);

    Builder opaquePart(String r100);

    Builder path(String r100);

    Builder query(String r100);

    Builder scheme(String r100);
}
