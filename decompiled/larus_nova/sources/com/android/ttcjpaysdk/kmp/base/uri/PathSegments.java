package com.android.ttcjpaysdk.kmp.base.uri;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0010B\u001f\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0096\u0002R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegments;", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", DBDefinition.SEGMENT_TABLE_NAME, "", "size", "", "<init>", "([Ljava/lang/String;I)V", "[Ljava/lang/String;", "getSize", "()I", MonitorConstants.CONNECT_TYPE_GET, "index", "Companion", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PathSegments extends AbstractList<String> implements RandomAccess {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final PathSegments EMPTY = null;
    private final String[] segments;
    private final int size;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegments$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegments;", "getEMPTY", "()Lcom/android/ttcjpaysdk/kmp/base/uri/PathSegments;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final PathSegments getEMPTY() {
            return PathSegments.access$getEMPTY$cp();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        EMPTY = new PathSegments(null, 0);
    }

    public static final /* synthetic */ PathSegments access$getEMPTY$cp() {
        return EMPTY;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return contains((String) r100);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public String get(int r100) {
        if (r100 >= size()) goto L11;
        String[] r101 = this.segments;
        if (r101 == null) goto L9;
        return r101[r100];
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        throw new IndexOutOfBoundsException("Index " + r100 + " should be less than " + size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return -1;
    L7:
        return indexOf((String) r100);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((String) r100);
    }

    public /* bridge */ boolean contains(String r100) {
        return super.contains(r100);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    public /* bridge */ int indexOf(String r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(String r100) {
        return super.lastIndexOf(r100);
    }

    public PathSegments(String[] r100, int r101) {
        this.segments = r100;
        this.size = r101;
    }
}
