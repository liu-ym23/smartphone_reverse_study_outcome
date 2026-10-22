package androidx.compose.material3;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083@\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/ListItemType;", "", GXTemplateKey.STYLE_FONT_LINES, "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-yh95HIg", "(II)I", "equals", "", "", "hashCode", "toString", "", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class ListItemType implements Comparable<ListItemType> {
    public static final Companion Companion = null;
    private static final int OneLine = 0;
    private static final int ThreeLine = 0;
    private static final int TwoLine = 0;
    private final int lines;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0080\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/ListItemType$Companion;", "", "<init>", "()V", "OneLine", "Landroidx/compose/material3/ListItemType;", "getOneLine-AlXitO8", "()I", "I", "TwoLine", "getTwoLine-AlXitO8", "ThreeLine", "getThreeLine-AlXitO8", AbsMethodDelegate.TAG_INVOKE, "hasOverline", "", "hasSupporting", "isSupportingMultiline", "invoke-Z-LSjz4$material3", "(ZZZ)I", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getOneLine-AlXitO8, reason: not valid java name */
        public final int m2369getOneLineAlXitO8() {
            return ListItemType.access$getOneLine$cp();
        }

        /* JADX INFO: renamed from: getThreeLine-AlXitO8, reason: not valid java name */
        public final int m2370getThreeLineAlXitO8() {
            return ListItemType.access$getThreeLine$cp();
        }

        /* JADX INFO: renamed from: getTwoLine-AlXitO8, reason: not valid java name */
        public final int m2371getTwoLineAlXitO8() {
            return ListItemType.access$getTwoLine$cp();
        }

        /* JADX INFO: renamed from: invoke-Z-LSjz4$material3, reason: not valid java name */
        public final int m2372invokeZLSjz4$material3(boolean r100, boolean r101, boolean r102) {
            if (r100 == false) goto L4;
            if (r101 == false) goto L4;
        L12:
            return m2370getThreeLineAlXitO8();
        L4:
            if (r102 == true) goto L12;
            if (r100 == true) goto L11;
            if (r101 == true) goto L11;
            return m2369getOneLineAlXitO8();
        L11:
            return m2371getTwoLineAlXitO8();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ListItemType m2360boximpl(int r100) {
        return new ListItemType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2362constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2363equalsimpl(int r100, Object r101) {
        if ((r101 instanceof ListItemType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ListItemType) r101).m2368unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2364equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2365hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2366toStringimpl(int r100) {
        return "ListItemType(lines=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m2363equalsimpl(this.lines, r100);
    }

    public int hashCode() {
        return m2365hashCodeimpl(this.lines);
    }

    public String toString() {
        return m2366toStringimpl(this.lines);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2368unboximpl() {
        return this.lines;
    }

    static {
        Companion = new Companion(null);
        OneLine = m2362constructorimpl(1);
        TwoLine = m2362constructorimpl(2);
        ThreeLine = m2362constructorimpl(3);
    }

    public static final /* synthetic */ int access$getOneLine$cp() {
        return OneLine;
    }

    public static final /* synthetic */ int access$getThreeLine$cp() {
        return ThreeLine;
    }

    public static final /* synthetic */ int access$getTwoLine$cp() {
        return TwoLine;
    }

    private /* synthetic */ ListItemType(int r100) {
        this.lines = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ListItemType r100) {
        return m2367compareToyh95HIg(r100.m2368unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-yh95HIg, reason: not valid java name */
    public int m2367compareToyh95HIg(int r100) {
        return m2361compareToyh95HIg(this.lines, r100);
    }

    /* JADX INFO: renamed from: compareTo-yh95HIg, reason: not valid java name */
    public static int m2361compareToyh95HIg(int r100, int r101) {
        return Intrinsics.compare(r100, r101);
    }
}
