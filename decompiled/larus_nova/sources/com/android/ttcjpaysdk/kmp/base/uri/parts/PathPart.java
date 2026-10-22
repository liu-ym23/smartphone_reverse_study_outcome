package com.android.ttcjpaysdk.kmp.base.uri.parts;

import com.android.ttcjpaysdk.kmp.base.uri.NotCachedHolder;
import com.android.ttcjpaysdk.kmp.base.uri.PathSegments;
import com.android.ttcjpaysdk.kmp.base.uri.PathSegmentsBuilder;
import com.android.ttcjpaysdk.kmp.base.uri.UriCodec;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/parts/PathPart;", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/AbstractPart;", "encoded", "", "decoded", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "encode", "pathSegments", "Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegments;", "getPathSegments", "()Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegments;", "pathSegments$delegate", "Lkotlin/Lazy;", "Companion", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PathPart extends AbstractPart {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final PathPart EMPTY = null;
    private static final PathPart NULL = null;
    private final Lazy pathSegments$delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/parts/PathPart$Companion;", "", "<init>", "()V", "NULL", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/PathPart;", "getNULL", "()Lcom/android/ttcjpaysdk/kmp/base/uri/parts/PathPart;", "EMPTY", "getEMPTY", "appendEncodedSegment", "oldPart", "newSegment", "", "appendDecodedSegment", "decoded", "fromEncoded", "encoded", "fromDecoded", "from", "makeAbsolute", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final PathPart getEMPTY() {
            return PathPart.access$getEMPTY$cp();
        }

        public final PathPart getNULL() {
            return PathPart.access$getNULL$cp();
        }

        public final PathPart fromDecoded(String r100) {
            return from(NotCachedHolder.INSTANCE.getNotCached(), r100);
        }

        public final PathPart fromEncoded(String r100) {
            return from(r100, NotCachedHolder.INSTANCE.getNotCached());
        }

        public final PathPart makeAbsolute(PathPart r100) {
            Intrinsics.checkNotNullParameter(r100, "oldPart");
            if (r100.getWasEncodedCached$cj_base_release() == false) goto L5;
            String r101 = r100.getEncoded();
        L6:
            if (r101 != null) goto L8;
        L25:
            return r100;
        L8:
            if (r101.length() != 0) goto L10;
            boolean r102 = true;
        L11:
            if (r102 == true) goto L25;
            if (StringsKt.startsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == true) goto L25;
            if (r100.getWasEncodedCached$cj_base_release() == false) goto L18;
            String r103 = HTTP.URL_DEFAULT + r100.getEncoded();
        L20:
            if (r100.getWasDecodedCached$cj_base_release() == false) goto L22;
            String r104 = HTTP.URL_DEFAULT + r100.getDecoded();
        L24:
            return new PathPart(r103, r104);
        L22:
            r104 = NotCachedHolder.INSTANCE.getNotCached();
            goto L24
        L18:
            r103 = NotCachedHolder.INSTANCE.getNotCached();
            goto L20
        L10:
            r102 = false;
            goto L11
        L5:
            r101 = r100.getDecoded();
            goto L6
        }

        public final PathPart appendDecodedSegment(PathPart r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "decoded");
            return appendEncodedSegment(r100, UriCodec.INSTANCE.encode(r101));
        }

        public final PathPart appendEncodedSegment(PathPart r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "newSegment");
            if (r100 == null) goto L5;
            String r102 = r100.getEncoded();
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            int r103 = r102.length();
            if (r103 != 0) goto L13;
            String r104 = HTTP.URL_DEFAULT + r101;
        L17:
            return fromEncoded(r104);
        L13:
            if (r102.charAt(r103 - 1) != '/') goto L15;
            r104 = r102 + r101;
            goto L17
        L15:
            r104 = r102 + '/' + r101;
            goto L17
        L5:
            return fromEncoded(HTTP.URL_DEFAULT + r101);
        }

        public final PathPart from(String r100, String r101) {
            if (r100 != null) goto L6;
            return getNULL();
        L6:
            if (r100.length() != 0) goto L8;
            boolean r102 = true;
        L9:
            if (r102 == false) goto L12;
            return getEMPTY();
        L12:
            return new PathPart(r100, r101);
        L8:
            r102 = false;
            goto L9
        }
    }

    public static /* synthetic */ PathSegments c(String r100) {
        return pathSegments_delegate$lambda$1(r100);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        NULL = new PathPart(null, null);
        EMPTY = new PathPart("", "");
    }

    public final PathSegments getPathSegments() {
        return (PathSegments) this.pathSegments$delegate.getValue();
    }

    public static final /* synthetic */ PathPart access$getEMPTY$cp() {
        return EMPTY;
    }

    public static final /* synthetic */ PathPart access$getNULL$cp() {
        return NULL;
    }

    private static final PathSegments pathSegments_delegate$lambda$1(String r110) {
        if (r110 == null) goto L4;
        PathSegmentsBuilder r100 = new PathSegmentsBuilder();
        int r101 = 0;
    L6:
        int r102 = StringsKt.indexOf$default(r110, '/', r101, false, 4, null);
        if (r102 <= (-1)) goto L12;
        if (r101 >= r102) goto L10;
        r100.add(UriCodec.decode$default(UriCodec.INSTANCE, r110.substring(r101, r102), false, false, 6, null));
    L10:
        r101 = r102 + 1;
        goto L6
    L12:
        if (r101 >= r110.length()) goto L15;
        r100.add(UriCodec.decode$default(UriCodec.INSTANCE, r110.substring(r101), false, false, 6, null));
    L15:
        return r100.build();
    L4:
        return PathSegments.Companion.getEMPTY();
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.parts.AbstractPart
    public String encode(String r100) {
        return UriCodec.INSTANCE.encodeOrNull(r100, HTTP.URL_DEFAULT);
    }

    public PathPart(final String r100, String r101) {
        super(r100, r101);
        this.pathSegments$delegate = LazyKt.lazy(new c(r100));
    }
}
