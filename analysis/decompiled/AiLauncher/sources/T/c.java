package T;

import android.util.Size;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Size f5823a = new Size(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final Size f5824b = new Size(320, 240);

    /* renamed from: c, reason: collision with root package name */
    public static final Size f5825c = new Size(640, 480);

    /* renamed from: d, reason: collision with root package name */
    public static final Size f5826d = new Size(720, 480);

    /* renamed from: e, reason: collision with root package name */
    public static final Size f5827e = new Size(1280, 720);

    /* renamed from: f, reason: collision with root package name */
    public static final Size f5828f = new Size(1920, 1080);

    /* renamed from: g, reason: collision with root package name */
    public static final Size f5829g = new Size(1920, 1440);

    /* renamed from: h, reason: collision with root package name */
    public static final Size f5830h = new Size(2560, 1440);

    /* renamed from: i, reason: collision with root package name */
    public static final Size f5831i = new Size(3840, 2160);

    public static int a(int i10, int i11) {
        return i10 * i11;
    }

    public static int b(Size size) {
        return a(size.getWidth(), size.getHeight());
    }

    public static boolean c(Size size, Size size2) {
        return b(size) < b(size2);
    }
}
