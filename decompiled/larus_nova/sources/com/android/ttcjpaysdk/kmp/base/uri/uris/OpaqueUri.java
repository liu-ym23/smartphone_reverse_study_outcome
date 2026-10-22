package com.android.ttcjpaysdk.kmp.base.uri.uris;

import com.android.ttcjpaysdk.kmp.base.uri.Builder;
import com.android.ttcjpaysdk.kmp.base.uri.Uri;
import com.android.ttcjpaysdk.kmp.base.uri.parts.Part;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import x0.t;
import x0.u;
import x0.v;
import x0.w;
import x0.x;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B%\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010<\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010>H\u0096\u0002J\b\u0010?\u001a\u000206H\u0016J\b\u0010@\u001a\u00020\u0003H\u0016J\b\u0010A\u001a\u00020BH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\nR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0016\u0010!\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\nR\u001d\u0010#\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b$\u0010\nR\u001d\u0010&\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b'\u0010\nR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\nR\u0016\u0010/\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\nR\u0016\u00101\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\nR\u0016\u00103\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\nR\u0014\u00105\u001a\u000206X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001b\u00109\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b:\u0010\n¨\u0006C"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/uris/OpaqueUri;", "Lcom/android/ttcjpaysdk/kmp/base/uri/Uri;", "scheme", "", "ssp", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;", "_fragmentPart", "<init>", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;)V", "getScheme", "()Ljava/lang/String;", "fragmentPart", "isHierarchical", "", "()Z", "isRelative", "encodedSchemeSpecificPart", "getEncodedSchemeSpecificPart", "encodedSchemeSpecificPart$delegate", "Lkotlin/Lazy;", "schemeSpecificPart", "getSchemeSpecificPart", "schemeSpecificPart$delegate", "authority", "getAuthority", "encodedAuthority", "getEncodedAuthority", "path", "getPath", "encodedPath", "getEncodedPath", "query", "getQuery", "encodedQuery", "getEncodedQuery", WidgetService.PARAM_FRAGMENT, "getFragment", "fragment$delegate", "encodedFragment", "getEncodedFragment", "encodedFragment$delegate", "pathSegments", "", "getPathSegments", "()Ljava/util/List;", "lastPathSegment", "getLastPathSegment", "userInfo", "getUserInfo", "encodedUserInfo", "getEncodedUserInfo", "host", "getHost", "port", "", "getPort", "()I", "cachedString", "getCachedString", "cachedString$delegate", "equals", "other", "", "hashCode", "toString", "buildUpon", "Lcom/android/ttcjpaysdk/kmp/base/uri/Uri$Builder;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpaqueUri implements Uri {
    public static final int $stable = 8;
    private final String authority;
    private final Lazy cachedString$delegate;
    private final String encodedAuthority;
    private final Lazy encodedFragment$delegate;
    private final String encodedPath;
    private final String encodedQuery;
    private final Lazy encodedSchemeSpecificPart$delegate;
    private final String encodedUserInfo;
    private final Lazy fragment$delegate;
    private final Part fragmentPart;
    private final String host;
    private final boolean isHierarchical;
    private final boolean isRelative;
    private final String lastPathSegment;
    private final String path;
    private final List<String> pathSegments;
    private final int port;
    private final String query;
    private final String scheme;
    private final Lazy schemeSpecificPart$delegate;
    private final Part ssp;
    private final String userInfo;

    public static /* synthetic */ String a(OpaqueUri r100) {
        return encodedFragment_delegate$lambda$3(r100);
    }

    public static /* synthetic */ String b(OpaqueUri r100) {
        return fragment_delegate$lambda$2(r100);
    }

    public static /* synthetic */ String c(OpaqueUri r100) {
        return schemeSpecificPart_delegate$lambda$1(r100);
    }

    public static /* synthetic */ String d(OpaqueUri r100) {
        return encodedSchemeSpecificPart_delegate$lambda$0(r100);
    }

    public static /* synthetic */ String e(OpaqueUri r100) {
        return cachedString_delegate$lambda$5(r100);
    }

    private final String getCachedString() {
        return (String) this.cachedString$delegate.getValue();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public Uri.Builder buildUpon() {
        return new Uri.Builder().scheme(getScheme()).opaquePart$cj_base_release(this.ssp).fragment$cj_base_release(this.fragmentPart);
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getEncodedFragment() {
        return (String) this.encodedFragment$delegate.getValue();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getEncodedSchemeSpecificPart() {
        return (String) this.encodedSchemeSpecificPart$delegate.getValue();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getFragment() {
        return (String) this.fragment$delegate.getValue();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getSchemeSpecificPart() {
        return (String) this.schemeSpecificPart$delegate.getValue();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public Map<String, String> getQueryNamesAndParametersMap() {
        return Uri.DefaultImpls.getQueryNamesAndParametersMap(this);
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public Set<String> getQueryParameterNames() {
        return Uri.DefaultImpls.getQueryParameterNames(this);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public boolean isAbsolute() {
        return Uri.DefaultImpls.isAbsolute(this);
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public boolean isOpaque() {
        return Uri.DefaultImpls.isOpaque(this);
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public Uri normalizeScheme() {
        return Uri.DefaultImpls.normalizeScheme(this);
    }

    public String toString() {
        return getCachedString();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getAuthority() {
        return this.authority;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getEncodedAuthority() {
        return this.encodedAuthority;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getEncodedPath() {
        return this.encodedPath;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getEncodedQuery() {
        return this.encodedQuery;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getEncodedUserInfo() {
        return this.encodedUserInfo;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getHost() {
        return this.host;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getLastPathSegment() {
        return this.lastPathSegment;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getPath() {
        return this.path;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public List<String> getPathSegments() {
        return this.pathSegments;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public int getPort() {
        return this.port;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getQuery() {
        return this.query;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getScheme() {
        return this.scheme;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getUserInfo() {
        return this.userInfo;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public boolean isHierarchical() {
        return this.isHierarchical;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public boolean isRelative() {
        return this.isRelative;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public /* bridge */ /* synthetic */ Builder buildUpon() {
        return buildUpon();
    }

    private static final String cachedString_delegate$lambda$5(OpaqueUri r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getScheme());
        r101.append(':');
        r101.append(r100.getEncodedSchemeSpecificPart());
        if (r100.fragmentPart.isEmpty() == true) goto L6;
        r101.append('#');
        r101.append(r100.getEncodedFragment());
    L6:
        return r101.toString();
    }

    private static final String encodedFragment_delegate$lambda$3(OpaqueUri r100) {
        return r100.fragmentPart.getEncoded();
    }

    private static final String encodedSchemeSpecificPart_delegate$lambda$0(OpaqueUri r100) {
        return r100.ssp.getEncoded();
    }

    private static final String fragment_delegate$lambda$2(OpaqueUri r100) {
        return r100.fragmentPart.getDecoded();
    }

    private static final String schemeSpecificPart_delegate$lambda$1(OpaqueUri r100) {
        return r100.ssp.getDecoded();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Uri r100) {
        return compareTo(r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Uri) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(toString(), r100.toString()) == false) goto L7;
        return true;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public String getQueryParameter(String r100) {
        return Uri.DefaultImpls.getQueryParameter(this, r100);
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public List<String> getQueryParameters(String r100) {
        return Uri.DefaultImpls.getQueryParameters(this, r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public int compareTo(Uri r100) {
        return Uri.DefaultImpls.compareTo(this, r100);
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.Uri
    public boolean getBooleanQueryParameter(String r100, boolean r101) {
        return Uri.DefaultImpls.getBooleanQueryParameter(this, r100, r101);
    }

    public OpaqueUri(String r100, Part r101, Part r102) {
        Intrinsics.checkNotNullParameter(r101, "ssp");
        this.scheme = r100;
        this.ssp = r101;
        if (r102 != null) goto L5;
        r102 = Part.Companion.getNULL();
    L5:
        this.fragmentPart = r102;
        if (getScheme() != null) goto L8;
        boolean r103 = true;
    L9:
        this.isRelative = r103;
        this.encodedSchemeSpecificPart$delegate = LazyKt.lazy(new t(this));
        this.schemeSpecificPart$delegate = LazyKt.lazy(new u(this));
        this.fragment$delegate = LazyKt.lazy(new v(this));
        this.encodedFragment$delegate = LazyKt.lazy(new w(this));
        this.pathSegments = CollectionsKt.emptyList();
        this.port = -1;
        this.cachedString$delegate = LazyKt.lazy(new x(this));
        return;
    L8:
        r103 = false;
        goto L9
    }
}
