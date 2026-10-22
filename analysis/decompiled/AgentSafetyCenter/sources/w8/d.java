package w8;

import android.net.Uri;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f15379a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f15380b;

    static {
        Uri uri = Uri.parse("content://com.stepos.notepaper.NotePaper");
        uri.getClass();
        f15379a = uri;
        Uri uri2 = Uri.parse("content://com.stepos.notepaper.NotePaper.Expose/note");
        uri2.getClass();
        f15380b = uri2;
    }
}
