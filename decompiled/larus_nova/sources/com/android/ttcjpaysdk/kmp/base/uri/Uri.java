package com.android.ttcjpaysdk.kmp.base.uri;

import com.android.ttcjpaysdk.kmp.base.uri.parts.Part;
import com.android.ttcjpaysdk.kmp.base.uri.parts.PathPart;
import com.android.ttcjpaysdk.kmp.base.uri.uris.HierarchicalUri;
import com.android.ttcjpaysdk.kmp.base.uri.uris.OpaqueUri;
import com.android.ttcjpaysdk.kmp.base.uri.uris.StringUri;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002>?J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\t01H\u0016J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\t0+2\u0006\u00103\u001a\u00020\tH\u0016J\u0012\u00104\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u00020\tH\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u00103\u001a\u00020\t2\u0006\u00106\u001a\u00020\u0003H\u0016J\u0014\u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t08H\u0016J\b\u00109\u001a\u00020\u0000H\u0016J\u0011\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0000H\u0096\u0002J\b\u0010<\u001a\u00020=H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000bR\u0014\u0010 \u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u0014\u0010&\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000b¨\u0006@"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/Uri;", "", "isHierarchical", "", "()Z", "isOpaque", "isRelative", "isAbsolute", "scheme", "", "getScheme", "()Ljava/lang/String;", "schemeSpecificPart", "getSchemeSpecificPart", "encodedSchemeSpecificPart", "getEncodedSchemeSpecificPart", "authority", "getAuthority", "encodedAuthority", "getEncodedAuthority", "userInfo", "getUserInfo", "encodedUserInfo", "getEncodedUserInfo", "host", "getHost", "port", "", "getPort", "()I", "path", "getPath", "encodedPath", "getEncodedPath", "query", "getQuery", "encodedQuery", "getEncodedQuery", WidgetService.PARAM_FRAGMENT, "getFragment", "encodedFragment", "getEncodedFragment", "pathSegments", "", "getPathSegments", "()Ljava/util/List;", "lastPathSegment", "getLastPathSegment", "getQueryParameterNames", "", "getQueryParameters", "key", "getQueryParameter", "getBooleanQueryParameter", "defaultValue", "getQueryNamesAndParametersMap", "", "normalizeScheme", "compareTo", "other", "buildUpon", "Lcom/android/ttcjpaysdk/kmp/base/uri/Builder;", "Builder", "Companion", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Uri extends Comparable<Uri> {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0011J\u0012\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0012J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0014J\u0012\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0017\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u001bJ\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0017\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u001dJ\u0012\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001e\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/Uri$Builder;", "Lcom/android/ttcjpaysdk/kmp/base/uri/Builder;", "<init>", "()V", "scheme", "", "opaquePart", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;", "authority", "path", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/PathPart;", "query", WidgetService.PARAM_FRAGMENT, "isSchemeSet", "", "isSchemeSet$cj_base_release", "isAuthoritySet", "isAuthoritySet$cj_base_release", "opaquePart$cj_base_release", "encodedOpaquePart", "authority$cj_base_release", "encodedAuthority", "path$cj_base_release", "encodedPath", "appendPath", "newSegment", "appendEncodedPath", "query$cj_base_release", "encodedQuery", "fragment$cj_base_release", "encodedFragment", "appendQueryParameter", "key", "value", "clearQuery", "build", "Lcom/android/ttcjpaysdk/kmp/base/uri/Uri;", "hasSchemeOrAuthority", "toString", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder implements com.android.ttcjpaysdk.kmp.base.uri.Builder {
        public static final int $stable = 8;
        private Part authority;
        private Part fragment;
        private Part opaquePart;
        private PathPart path;
        private Part query;
        private String scheme;

        public Builder() {
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder clearQuery() {
            return query$cj_base_release(null);
        }

        private final boolean hasSchemeOrAuthority() {
            if (this.scheme != null) goto L10;
            Part r100 = this.authority;
            if (r100 != null) goto L7;
        L9:
            return false;
        L7:
            if (r100 == Part.Companion.getNULL()) goto L9;
        L10:
            return true;
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Uri build() {
            Part r100 = this.opaquePart;
            if (r100 != null) goto L14;
            PathPart r101 = this.path;
            if (r101 == null) goto L12;
            PathPart.Companion r102 = PathPart.Companion;
            if (Intrinsics.areEqual(r101, r102.getNULL()) == true) goto L12;
            if (hasSchemeOrAuthority() == false) goto L13;
            r101 = r102.makeAbsolute(r101);
        L13:
            String r103 = this.scheme;
            Part r104 = this.authority;
            return new HierarchicalUri(r103, r104, r101, this.query, this.fragment);
        L12:
            r101 = PathPart.Companion.getEMPTY();
            goto L13
        L14:
            String r105 = this.scheme;
            if (r105 == null) goto L19;
            return new OpaqueUri(r105, r100, this.fragment);
        L19:
            throw new UnsupportedOperationException("An opaque URI must have a scheme.");
        }

        public final boolean isAuthoritySet$cj_base_release() {
            if (this.authority == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isSchemeSet$cj_base_release() {
            if (this.scheme == null) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return build().toString();
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder clearQuery() {
            return clearQuery();
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder appendEncodedPath(String r100) {
            Intrinsics.checkNotNullParameter(r100, "newSegment");
            return path$cj_base_release(PathPart.Companion.appendEncodedSegment(this.path, r100));
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder appendPath(String r100) {
            Intrinsics.checkNotNullParameter(r100, "newSegment");
            return path$cj_base_release(PathPart.Companion.appendDecodedSegment(this.path, r100));
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder authority(String r100) {
            return authority$cj_base_release(Part.Companion.fromDecoded(r100));
        }

        public final Builder authority$cj_base_release(Part r100) {
            this.opaquePart = null;
            this.authority = r100;
            return this;
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder encodedAuthority(String r100) {
            return authority$cj_base_release(Part.Companion.fromEncoded(r100));
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder encodedFragment(String r100) {
            return fragment$cj_base_release(Part.Companion.fromEncoded(r100));
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder encodedOpaquePart(String r100) {
            return opaquePart$cj_base_release(Part.Companion.fromEncoded(r100));
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder encodedPath(String r100) {
            return path$cj_base_release(PathPart.Companion.fromEncoded(r100));
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder encodedQuery(String r100) {
            return query$cj_base_release(Part.Companion.fromEncoded(r100));
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder fragment(String r100) {
            return fragment$cj_base_release(Part.Companion.fromDecoded(r100));
        }

        public final Builder fragment$cj_base_release(Part r100) {
            this.fragment = r100;
            return this;
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder opaquePart(String r100) {
            return opaquePart$cj_base_release(Part.Companion.fromDecoded(r100));
        }

        public final Builder opaquePart$cj_base_release(Part r100) {
            this.opaquePart = r100;
            return this;
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder path(String r100) {
            return path$cj_base_release(PathPart.Companion.fromDecoded(r100));
        }

        public final Builder path$cj_base_release(PathPart r100) {
            this.opaquePart = null;
            this.path = r100;
            return this;
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder query(String r100) {
            return query$cj_base_release(Part.Companion.fromDecoded(r100));
        }

        public final Builder query$cj_base_release(Part r100) {
            this.opaquePart = null;
            this.query = r100;
            return this;
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder scheme(String r100) {
            return scheme(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder appendEncodedPath(String r100) {
            return appendEncodedPath(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder appendPath(String r100) {
            return appendPath(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder authority(String r100) {
            return authority(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder encodedAuthority(String r100) {
            return encodedAuthority(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder encodedFragment(String r100) {
            return encodedFragment(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder encodedOpaquePart(String r100) {
            return encodedOpaquePart(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder encodedPath(String r100) {
            return encodedPath(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder encodedQuery(String r100) {
            return encodedQuery(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder fragment(String r100) {
            return fragment(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder opaquePart(String r100) {
            return opaquePart(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder path(String r100) {
            return path(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder query(String r100) {
            return query(r100);
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder scheme(String r100) {
            this.scheme = r100;
            return this;
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public Builder appendQueryParameter(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.opaquePart = null;
            UriCodec r102 = UriCodec.INSTANCE;
            String r103 = r102.encode(r100, null) + com.alipay.sdk.m.n.a.f25612h + r102.encodeOrNull(r101, null);
            Part r104 = this.query;
            if (r104 != null) goto L6;
            this.query = Part.Companion.fromEncoded(r103);
            return this;
        L6:
            Intrinsics.checkNotNull(r104);
            String r105 = r104.getEncoded();
            if (r105 != null) goto L9;
        L15:
            Part r106 = Part.Companion.fromEncoded(r103);
        L16:
            this.query = r106;
            return this;
        L9:
            if (r105.length() != 0) goto L11;
            boolean r107 = true;
        L12:
            if (r107 == true) goto L15;
            r106 = Part.Companion.fromEncoded(r105 + Typography.amp + r103);
            goto L16
        L11:
            r107 = false;
            goto L12
        }

        @Override // com.android.ttcjpaysdk.kmp.base.uri.Builder
        public /* bridge */ /* synthetic */ com.android.ttcjpaysdk.kmp.base.uri.Builder appendQueryParameter(String r100, String r101) {
            return appendQueryParameter(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005J$\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/Uri$Companion;", "", "<init>", "()V", "NOT_HIERARCHICAL", "", "EMPTY", "Lcom/android/ttcjpaysdk/kmp/base/uri/Uri;", "getEMPTY", "()Lcom/android/ttcjpaysdk/kmp/base/uri/Uri;", "parse", "uriString", "parseOrNull", "fromParts", "scheme", "ssp", WidgetService.PARAM_FRAGMENT, "encode", "s", "allow", "HEX_DIGITS", "", "DEFAULT_ENCODING", "isAllowed", "", "c", "", "NOT_FOUND", "", "NOT_CALCULATED", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final String DEFAULT_ENCODING = "UTF-8";
        private static final Uri EMPTY = null;
        private static final char[] HEX_DIGITS = null;
        private static final int NOT_CALCULATED = -2;
        private static final int NOT_FOUND = -1;
        private static final String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            Part.Companion r100 = Part.Companion;
            EMPTY = new HierarchicalUri(null, r100.getNULL(), PathPart.Companion.getEMPTY(), r100.getNULL(), r100.getNULL());
            HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        }

        public final Uri getEMPTY() {
            return EMPTY;
        }

        public final Uri parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uriString");
            return new StringUri(r100);
        }

        public final Uri parseOrNull(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uriString");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            Object r102 = Result.m9449constructorimpl(new StringUri(r100));     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r102) == false) goto L11;
            r102 = null;
        L11:
            return (Uri) r102;
        L5:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        private final boolean isAllowed(char r100, String r110) {
            if (Intrinsics.compare(r100, 65) < 0) goto L7;
            if (Intrinsics.compare(r100, 90) > 0) goto L7;
        L21:
            return true;
        L7:
            if (Intrinsics.compare(r100, 97) < 0) goto L11;
            if (Intrinsics.compare(r100, 122) <= 0) goto L21;
        L11:
            if (Intrinsics.compare(r100, 48) < 0) goto L15;
            if (Intrinsics.compare(r100, 57) <= 0) goto L21;
        L15:
            if (StringsKt.indexOf$default("_-!.~'()*", r100, 0, false, 6, null) != (-1)) goto L21;
            if (r110 != null) goto L18;
        L20:
            return false;
        L18:
            if (StringsKt.indexOf$default(r110, r100, 0, false, 6, null) == (-1)) goto L20;
            goto L20
        }

        public final String encode(String r110, String r111) {
            StringBuilder r100 = null;
            if (r110 != null) goto L5;
            return null;
        L5:
            int r101 = r110.length();
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L36;
            int r103 = r102;
        L8:
            if (r103 >= r101) goto L12;
            if (isAllowed(r110.charAt(r103), r111) == false) goto L12;
            r103 = r103 + 1;
        L12:
            if (r103 == r101) goto L13;
            if (r100 != null) goto L21;
            r100 = new StringBuilder();
        L21:
            if (r103 <= r102) goto L23;
            r100.append(r110, r102, r103);
        L23:
            r102 = r103 + 1;
        L24:
            if (r102 >= r101) goto L40;
            if (isAllowed(r110.charAt(r102), r111) == true) goto L40;
            r102 = r102 + 1;
        L40:
            byte[] r104 = StringsKt.encodeToByteArray(r110.substring(r103, r102));     // Catch: Exception -> L33
            int r105 = r104.length;     // Catch: Exception -> L33
            int r106 = 0;
        L30:
            if (r106 >= r105) goto L6;
            r100.append('%');     // Catch: Exception -> L33
            char[] r107 = HEX_DIGITS;     // Catch: Exception -> L33
            r100.append(r107[(r104[r106] & 240) >> 4]);     // Catch: Exception -> L33
            r100.append(r107[r104[r106] & 15]);     // Catch: Exception -> L33
            r106 = r106 + 1;
        L33:
            e = move-exception;
            throw new AssertionError(e);
        L13:
            if (r102 != 0) goto L15;
            return r110;
        L15:
            if (r100 == null) goto L18;
            r100.append(r110, r102, r101);
        L18:
            return String.valueOf(r100);
        L36:
            if (r100 != null) goto L39;
            return r110;
        L39:
            return r100.toString();
        }

        public final Uri fromParts(String r100, String r101, String r102) {
            if (r100 == null) goto L9;
            if (r101 == null) goto L7;
            Part.Companion r103 = Part.Companion;
            return new OpaqueUri(r100, r103.fromDecoded(r101), r103.fromDecoded(r102));
        L7:
            throw new IllegalArgumentException("ssp".toString());
        L9:
            throw new IllegalArgumentException("scheme".toString());
        }

        public static /* synthetic */ String encode$default(Companion r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            return r100.encode(r101, r102);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Map<String, String> getQueryNamesAndParametersMap(Uri r100) {
            Set<String> r101 = r100.getQueryParameterNames();
            if (r101.isEmpty() == true) goto L5;
            HashMap r102 = new HashMap();
            Iterator<T> r103 = r101.iterator();
        L8:
            if (r103.hasNext() == false) goto L13;
            String r104 = (String) r103.next();
            String r105 = r100.getQueryParameter(r104);
            if (r105 != null) goto L12;
            r105 = "";
        L12:
            r102.put(r104, r105);
            goto L8
        L13:
            return r102;
        L5:
            return MapsKt.emptyMap();
        }

        public static Set<String> getQueryParameterNames(Uri r110) {
            if (r110.isOpaque() == true) goto L20;
            String r100 = r110.getEncodedQuery();
            if (r100 == null) goto L7;
            LinkedHashSet r101 = new LinkedHashSet();
            int r102 = 0;
        L9:
            int r103 = StringsKt.indexOf$default(r100, Typography.amp, r102, false, 4, null);
            if (r103 != (-1)) goto L12;
            r103 = r100.length();
        L12:
            int r111 = r103;
            int r104 = StringsKt.indexOf$default(r100, com.alipay.sdk.m.n.a.f25612h, r102, false, 4, null);
            if (r104 > r111) goto L15;
            if (r104 == (-1)) goto L15;
        L16:
            String r112 = r100.substring(r102, r104);
            r101.add(UriCodec.decode$default(UriCodec.INSTANCE, r112, false, false, 6, null));
            r102 = r111 + 1;
            if (r102 < r100.length()) goto L9;
            return r101;
        L15:
            r104 = r111;
            goto L16
        L7:
            return SetsKt.emptySet();
        L20:
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        }

        public static boolean isAbsolute(Uri r100) {
            return !r100.isRelative();
        }

        public static boolean isOpaque(Uri r100) {
            return !r100.isHierarchical();
        }

        public static Uri normalizeScheme(Uri r100) {
            String r101 = r100.getScheme();
            if (r101 != null) goto L5;
            return r100;
        L5:
            String r102 = r101.toLowerCase(Locale.ROOT);
            if (Intrinsics.areEqual(r101, r102) == false) goto L9;
            return r100;
        L9:
            return r100.buildUpon().scheme(r102).build();
        }

        public static int compareTo(Uri r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r101, "other");
            return r100.toString().compareTo(r101.toString());
        }

        public static String getQueryParameter(Uri r110, String r111) {
            Intrinsics.checkNotNullParameter(r111, "key");
            String r100 = r110.getEncodedQuery();
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r110.isOpaque() == true) goto L31;
            String r101 = UriCodec.INSTANCE.encode(r111, null);
            int r112 = r100.length();
            int r102 = 0;
        L8:
            int r113 = StringsKt.indexOf$default(r100, Typography.amp, r102, false, 4, null);
            if (r113 == (-1)) goto L11;
            int r114 = r113;
        L12:
            int r103 = StringsKt.indexOf$default(r100, com.alipay.sdk.m.n.a.f25612h, r102, false, 4, null);
            if (r103 > r114) goto L17;
            if (r103 == (-1)) goto L17;
            int r104 = r103;
        L19:
            if ((r104 - r102) != r101.length()) goto L26;
            int r105 = r102;
            int r115 = r104;
            if (StringsKt.regionMatches$default(r100, r105, r101, 0, r101.length(), false, 16, null) == false) goto L26;
            if (r115 != r114) goto L24;
            return "";
        L24:
            String r106 = r100.substring(r115 + 1, r114);
            return UriCodec.INSTANCE.decode(r106, true, false);
        L26:
            if (r113 == (-1)) goto L28;
            r102 = r113 + 1;
            goto L8
        L28:
            return null;
        L17:
            r104 = r114;
            goto L19
        L11:
            r114 = r112;
            goto L12
        L31:
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        }

        public static List<String> getQueryParameters(Uri r110, String r111) {
            Intrinsics.checkNotNullParameter(r111, "key");
            if (r110.isOpaque() == true) goto L34;
            String r112 = r110.getEncodedQuery();
            if (r112 == null) goto L7;
            String r113 = UriCodec.INSTANCE.encode(r111);     // Catch: Exception -> L30
            ArrayList r100 = new ArrayList();
            int r101 = 0;
        L10:
            int r102 = StringsKt.indexOf$default(r112, Typography.amp, r101, false, 4, null);
            if (r102 == (-1)) goto L13;
            int r114 = r102;
        L14:
            int r103 = StringsKt.indexOf$default(r112, com.alipay.sdk.m.n.a.f25612h, r101, false, 4, null);
            if (r103 > r114) goto L19;
            if (r103 == (-1)) goto L19;
            int r115 = r103;
        L21:
            if ((r115 - r101) != r113.length()) goto L27;
            int r104 = r101;
            if (StringsKt.regionMatches$default(r112, r104, r113, 0, r113.length(), false, 16, null) == false) goto L27;
            if (r115 != r114) goto L26;
            r100.add("");
            goto L27
        L26:
            r100.add(UriCodec.decode$default(UriCodec.INSTANCE, r112.substring(r115 + 1, r114), false, false, 6, null));
        L27:
            if (r102 == (-1)) goto L29;
            r101 = r102 + 1;
            goto L10
        L29:
            return r100;
        L19:
            r115 = r114;
            goto L21
        L13:
            r114 = r112.length();
        L30:
            e = move-exception;
            throw new AssertionError(e);
        L7:
            return CollectionsKt.emptyList();
        L34:
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        }

        public static boolean getBooleanQueryParameter(Uri r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            String r103 = r100.getQueryParameter(r101);
            if (r103 != null) goto L5;
            return r102;
        L5:
            String r104 = r103.toLowerCase(Locale.ROOT);
            if (Intrinsics.areEqual("false", r104) == false) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual("0", r104) == true) goto L10;
            return true;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    com.android.ttcjpaysdk.kmp.base.uri.Builder buildUpon();

    int compareTo(Uri r100);

    String getAuthority();

    boolean getBooleanQueryParameter(String r100, boolean r101);

    String getEncodedAuthority();

    String getEncodedFragment();

    String getEncodedPath();

    String getEncodedQuery();

    String getEncodedSchemeSpecificPart();

    String getEncodedUserInfo();

    String getFragment();

    String getHost();

    String getLastPathSegment();

    String getPath();

    List<String> getPathSegments();

    int getPort();

    String getQuery();

    Map<String, String> getQueryNamesAndParametersMap();

    String getQueryParameter(String r100);

    Set<String> getQueryParameterNames();

    List<String> getQueryParameters(String r100);

    String getScheme();

    String getSchemeSpecificPart();

    String getUserInfo();

    boolean isAbsolute();

    boolean isHierarchical();

    boolean isOpaque();

    boolean isRelative();

    Uri normalizeScheme();
}
