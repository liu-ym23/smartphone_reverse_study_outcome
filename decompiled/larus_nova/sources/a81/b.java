package a81;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    public static class a implements b {
        public a() {
        }

        @Override // a81.b
        public final void a(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
        }
    }

    void a(Configuration r100);

    void b(int r100);
}
