package O7;

import java.io.File;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c extends b {
    public boolean b;
    public File[] c;
    public int d;
    public boolean e;

    @Override // O7.g
    public final File a() {
        boolean z10 = this.e;
        File file = this.f1039a;
        if (!z10 && this.c == null) {
            File[] fileArrListFiles = file.listFiles();
            this.c = fileArrListFiles;
            if (fileArrListFiles == null) {
                this.e = true;
            }
        }
        File[] fileArr = this.c;
        if (fileArr == null || this.d >= fileArr.length) {
            if (this.b) {
                return null;
            }
            this.b = true;
            return file;
        }
        k.c(fileArr);
        int i = this.d;
        this.d = i + 1;
        return fileArr[i];
    }
}
