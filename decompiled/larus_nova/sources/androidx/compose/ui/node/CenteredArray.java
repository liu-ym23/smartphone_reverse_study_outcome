package androidx.compose.ui.node;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/node/CenteredArray;", "", "data", "", "constructor-impl", "([I)[I", "mid", "", "getMid-impl", "([I)I", MonitorConstants.CONNECT_TYPE_GET, "index", "get-impl", "([II)I", "set", "", "value", "set-impl", "([III)V", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class CenteredArray {
    private final int[] data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CenteredArray m6394boximpl(int[] r100) {
        return new CenteredArray(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m6395constructorimpl(int[] r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6396equalsimpl(int[] r100, Object r101) {
        if ((r101 instanceof CenteredArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((CenteredArray) r101).m6403unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6397equalsimpl0(int[] r100, int[] r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6400hashCodeimpl(int[] r100) {
        return Arrays.hashCode(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6402toStringimpl(int[] r100) {
        return "CenteredArray(data=" + Arrays.toString(r100) + ')';
    }

    public boolean equals(Object r100) {
        return m6396equalsimpl(this.data, r100);
    }

    public int hashCode() {
        return m6400hashCodeimpl(this.data);
    }

    public String toString() {
        return m6402toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m6403unboximpl() {
        return this.data;
    }

    private /* synthetic */ CenteredArray(int[] r100) {
        this.data = r100;
    }

    /* JADX INFO: renamed from: getMid-impl, reason: not valid java name */
    private static final int m6399getMidimpl(int[] r100) {
        return r100.length / 2;
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final int m6398getimpl(int[] r100, int r101) {
        return r100[r101 + m6399getMidimpl(r100)];
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m6401setimpl(int[] r100, int r101, int r102) {
        r100[r101 + m6399getMidimpl(r100)] = r102;
    }
}
