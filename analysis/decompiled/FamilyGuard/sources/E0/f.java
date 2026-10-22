package E0;

import E0.d;
import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class f extends d {

    class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f1290a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1291b;

        a(Context context, String str) {
            this.f1290a = context;
            this.f1291b = str;
        }

        @Override // E0.d.a
        public File a() {
            File cacheDir = this.f1290a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f1291b != null ? new File(cacheDir, this.f1291b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j5) {
        super(new a(context, str), j5);
    }
}
