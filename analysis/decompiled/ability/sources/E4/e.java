package E4;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f475a;

    public e(Context context) {
        this.f475a = context;
    }

    public final File a(String wordId) {
        k.f(wordId, "wordId");
        return new File(this.f475a.getFilesDir(), B7.a.m("user_wakeup_", wordId, ".udm"));
    }

    public final boolean b() {
        File[] fileArrListFiles;
        File filesDir = this.f475a.getFilesDir();
        if (filesDir != null && (fileArrListFiles = filesDir.listFiles(new c(0))) != null) {
            if (!(fileArrListFiles.length == 0)) {
                return true;
            }
        }
        return false;
    }
}
