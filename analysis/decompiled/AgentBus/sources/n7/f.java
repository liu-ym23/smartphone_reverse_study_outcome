package n7;

import java.io.File;

/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f6859b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f6860c;

    /* renamed from: d, reason: collision with root package name */
    public int f6861d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6862e;

    @Override // n7.j
    public final File a() {
        boolean z4 = this.f6862e;
        File file = this.f6869a;
        if (!z4 && this.f6860c == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f6860c = fileArrListFiles;
            if (fileArrListFiles == null) {
                this.f6862e = true;
            }
        }
        File[] fileArr = this.f6860c;
        if (fileArr == null || this.f6861d >= fileArr.length) {
            if (this.f6859b) {
                return null;
            }
            this.f6859b = true;
            return file;
        }
        q7.k.b(fileArr);
        int i2 = this.f6861d;
        this.f6861d = i2 + 1;
        return fileArr[i2];
    }
}
