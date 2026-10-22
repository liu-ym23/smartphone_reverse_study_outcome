package n7;

import java.io.File;

/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f6864b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f6865c;

    /* renamed from: d, reason: collision with root package name */
    public int f6866d;

    @Override // n7.j
    public final File a() {
        boolean z4 = this.f6864b;
        File file = this.f6869a;
        if (!z4) {
            this.f6864b = true;
            return file;
        }
        File[] fileArr = this.f6865c;
        if (fileArr != null && this.f6866d >= fileArr.length) {
            return null;
        }
        if (fileArr == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f6865c = fileArrListFiles;
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return null;
            }
        }
        File[] fileArr2 = this.f6865c;
        q7.k.b(fileArr2);
        int i2 = this.f6866d;
        this.f6866d = i2 + 1;
        return fileArr2[i2];
    }
}
