package fa;

import com.obric.android.alog.ILibLoader;

/* JADX INFO: loaded from: classes3.dex */
public class c implements ILibLoader {
    public c() {
    }

    @Override // com.obric.android.alog.ILibLoader
    public void loadLibrary(String r10) {
        com.bytedance.librarian.a.a("oalog", a.f19549b.e());     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("oalog");
    }
}
