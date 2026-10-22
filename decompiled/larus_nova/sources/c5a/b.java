package c5a;

import com.lynx.clay.embedding.engine.loader.FlutterLoader;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f22525b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterLoader f22526a;

    public static b a() {
        if (f22525b != null) goto L6;
        f22525b = new b(new FlutterLoader());
    L6:
        return f22525b;
    }

    public b(FlutterLoader r100) {
        this.f22526a = r100;
    }
}
