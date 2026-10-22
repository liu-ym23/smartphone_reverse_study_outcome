package com.android.ttcjpaysdk.kmp.base.uri;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegmentsBuilder;", "", "<init>", "()V", DBDefinition.SEGMENT_TABLE_NAME, "", "", "[Ljava/lang/String;", "size", "", "add", "", MonitorConstants.SEGMENT, "build", "Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegments;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PathSegmentsBuilder {
    public static final int $stable = 8;
    private String[] segments;
    private int size;

    public PathSegmentsBuilder() {
    }

    public final PathSegments build() {
        if (this.segments == null) goto L9;
        String[] r100 = this.segments;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException(DBDefinition.SEGMENT_TABLE_NAME);
        r100 = null;
    L10:
        return new PathSegments(r100, this.size);
    L9:
        return PathSegments.Companion.getEMPTY();
    }

    public final void add(String r110) {
        Intrinsics.checkNotNullParameter(r110, MonitorConstants.SEGMENT);
        String[] r100 = this.segments;
        int r101 = 0;
        String[] r102 = null;
        if (r100 == null) goto L20;
        int r103 = this.size + 1;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(DBDefinition.SEGMENT_TABLE_NAME);
        r100 = null;
    L8:
        if (r103 != r100.length) goto L24;
        String[] r104 = this.segments;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(DBDefinition.SEGMENT_TABLE_NAME);
        r104 = null;
    L12:
        int r105 = r104.length * 2;
        String[] r111 = new String[r105];
    L13:
        if (r101 >= r105) goto L15;
        r111[r101] = "";
        r101 = r101 + 1;
        goto L13
    L15:
        String[] r106 = this.segments;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException(DBDefinition.SEGMENT_TABLE_NAME);
        String[] r107 = null;
    L19:
        ArraysKt.copyInto$default(r107, r111, 0, 0, 0, 14, null);
        this.segments = r111;
        goto L24
    L18:
        r107 = r106;
    L24:
        String[] r108 = this.segments;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException(DBDefinition.SEGMENT_TABLE_NAME);
    L28:
        int r109 = this.size;
        this.size = r109 + 1;
        r102[r109] = r110;
        return;
    L27:
        r102 = r108;
        goto L28
    L20:
        String[] r112 = new String[4];
    L21:
        if (r101 >= 4) goto L23;
        r112[r101] = "";
        r101 = r101 + 1;
        goto L21
    L23:
        this.segments = r112;
        goto L24
    }
}
