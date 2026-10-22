package androidx.work;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5412a = null;

    static {
        f5412a = i.i("InputMerger");
    }

    public e() {
    }

    public static e a(String r10) {
        return (e) Class.forName(r10).getDeclaredConstructor(null).newInstance(null);
    L5:
        e = move-exception;
        i.e().d(f5412a, "Trouble instantiating + " + r10, e);
        return null;
    }

    public abstract c b(List r10);
}
