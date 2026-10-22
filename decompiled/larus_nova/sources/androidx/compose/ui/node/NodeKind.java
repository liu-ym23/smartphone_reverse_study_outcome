package androidx.compose.ui.node;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0086\f¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0003¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/NodeKind;", ExifInterface.GPS_DIRECTION_TRUE, "", BuyNowCloseMethod.MASK, "", "constructor-impl", "(I)I", "getMask", "()I", SRStrategy.KEY_ORIGIN_RESOLUTION, "other", "or-H91voCI", "(II)I", "or-impl", "equals", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class NodeKind<T> {
    private final int mask;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ NodeKind m6555boximpl(int r100) {
        return new NodeKind(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> int m6556constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6557equalsimpl(int r100, Object r101) {
        if ((r101 instanceof NodeKind) == true) goto L6;
        return false;
    L6:
        if (r100 == ((NodeKind) r101).m6563unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6558equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6559hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: or-H91voCI, reason: not valid java name */
    public static final int m6560orH91voCI(int r100, int r101) {
        return r100 | r101;
    }

    /* JADX INFO: renamed from: or-impl, reason: not valid java name */
    public static final int m6561orimpl(int r100, int r101) {
        return r100 | r101;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6562toStringimpl(int r100) {
        return "NodeKind(mask=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m6557equalsimpl(this.mask, r100);
    }

    public int hashCode() {
        return m6559hashCodeimpl(this.mask);
    }

    public String toString() {
        return m6562toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6563unboximpl() {
        return this.mask;
    }

    public final int getMask() {
        return this.mask;
    }

    private /* synthetic */ NodeKind(int r100) {
        this.mask = r100;
    }
}
