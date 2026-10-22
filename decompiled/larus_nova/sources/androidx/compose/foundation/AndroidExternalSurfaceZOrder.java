package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "", "zOrder", "", "constructor-impl", "(I)I", "getZOrder", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class AndroidExternalSurfaceZOrder {
    private static final int Behind = 0;
    public static final Companion Companion = null;
    private static final int MediaOverlay = 0;
    private static final int OnTop = 0;
    private final int zOrder;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder$Companion;", "", "<init>", "()V", "Behind", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "getBehind-B_4ceCc", "()I", "I", "MediaOverlay", "getMediaOverlay-B_4ceCc", "OnTop", "getOnTop-B_4ceCc", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getBehind-B_4ceCc, reason: not valid java name */
        public final int m223getBehindB_4ceCc() {
            return AndroidExternalSurfaceZOrder.access$getBehind$cp();
        }

        /* JADX INFO: renamed from: getMediaOverlay-B_4ceCc, reason: not valid java name */
        public final int m224getMediaOverlayB_4ceCc() {
            return AndroidExternalSurfaceZOrder.access$getMediaOverlay$cp();
        }

        /* JADX INFO: renamed from: getOnTop-B_4ceCc, reason: not valid java name */
        public final int m225getOnTopB_4ceCc() {
            return AndroidExternalSurfaceZOrder.access$getOnTop$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AndroidExternalSurfaceZOrder m216boximpl(int r100) {
        return new AndroidExternalSurfaceZOrder(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m217constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m218equalsimpl(int r100, Object r101) {
        if ((r101 instanceof AndroidExternalSurfaceZOrder) == true) goto L6;
        return false;
    L6:
        if (r100 == ((AndroidExternalSurfaceZOrder) r101).m222unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m219equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m220hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m221toStringimpl(int r100) {
        return "AndroidExternalSurfaceZOrder(zOrder=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m218equalsimpl(this.zOrder, r100);
    }

    public int hashCode() {
        return m220hashCodeimpl(this.zOrder);
    }

    public String toString() {
        return m221toStringimpl(this.zOrder);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m222unboximpl() {
        return this.zOrder;
    }

    static {
        Companion = new Companion(null);
        Behind = m217constructorimpl(0);
        MediaOverlay = m217constructorimpl(1);
        OnTop = m217constructorimpl(2);
    }

    public static final /* synthetic */ int access$getBehind$cp() {
        return Behind;
    }

    public static final /* synthetic */ int access$getMediaOverlay$cp() {
        return MediaOverlay;
    }

    public static final /* synthetic */ int access$getOnTop$cp() {
        return OnTop;
    }

    public final int getZOrder() {
        return this.zOrder;
    }

    private /* synthetic */ AndroidExternalSurfaceZOrder(int r100) {
        this.zOrder = r100;
    }
}
