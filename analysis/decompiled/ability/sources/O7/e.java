package O7;

import java.io.File;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class e extends b {
    public boolean b;
    public File[] c;
    public int d;

    @Override // O7.g
    public final File a() {
        boolean z10 = this.b;
        File file = this.f1039a;
        if (!z10) {
            this.b = true;
            return file;
        }
        File[] fileArr = this.c;
        if (fileArr != null && this.d >= fileArr.length) {
            return null;
        }
        if (fileArr == null) {
            File[] fileArrListFiles = file.listFiles();
            this.c = fileArrListFiles;
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return null;
            }
        }
        File[] fileArr2 = this.c;
        k.c(fileArr2);
        int i = this.d;
        this.d = i + 1;
        return fileArr2[i];
    }
}
