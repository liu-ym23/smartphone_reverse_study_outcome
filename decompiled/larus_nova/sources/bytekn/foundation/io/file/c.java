package bytekn.foundation.io.file;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f21788b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f21789c = null;

    static {
        int[] r100 = new int[ContentEncoding.values().length];
        f21787a = r100;
        ContentEncoding r101 = ContentEncoding.Ascii;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[ContentEncoding.values().length];
        f21788b = r102;
        r102[r101.ordinal()] = 1;
        int[] r103 = new int[ContentEncoding.values().length];
        f21789c = r103;
        r103[r101.ordinal()] = 1;
    }
}
