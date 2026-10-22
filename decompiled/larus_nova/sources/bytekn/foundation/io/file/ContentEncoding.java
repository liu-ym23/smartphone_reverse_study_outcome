package bytekn.foundation.io.file;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lbytekn/foundation/io/file/ContentEncoding;", "", "Utf8", "Ascii", "Base64", "kn_io_release"}, k = 1, mv = {1, 4, 0})
public final enum ContentEncoding extends Enum<ContentEncoding> {
    public static final ContentEncoding Ascii = null;
    public static final ContentEncoding Base64 = null;
    public static final ContentEncoding Utf8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentEncoding[] f21781a = null;

    static {
        ContentEncoding r100 = new ContentEncoding("Utf8", 0);
        Utf8 = r100;
        ContentEncoding r101 = new ContentEncoding("Ascii", 1);
        Ascii = r101;
        ContentEncoding r102 = new ContentEncoding("Base64", 2);
        Base64 = r102;
        f21781a = new ContentEncoding[]{r100, r101, r102};
    }

    public static ContentEncoding valueOf(String r100) {
        return (ContentEncoding) r27.a.a(ContentEncoding.class, r100);
    }

    public static ContentEncoding[] values() {
        return (ContentEncoding[]) f21781a.clone();
    }

    public ContentEncoding(String r100, int r101) {
        super(r100, r101);
    }
}
