package ub;

import java.io.File;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: b, reason: collision with root package name */
    public boolean f14294b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f14295c;

    /* renamed from: d, reason: collision with root package name */
    public int f14296d;

    @Override // ub.f
    public final File a() {
        File file = this.f14297a;
        if (!this.f14294b) {
            this.f14294b = true;
            return file;
        }
        File[] fileArr = this.f14295c;
        if (fileArr != null && this.f14296d >= fileArr.length) {
            return null;
        }
        if (fileArr == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f14295c = fileArrListFiles;
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return null;
            }
        }
        File[] fileArr2 = this.f14295c;
        fileArr2.getClass();
        int i = this.f14296d;
        this.f14296d = i + 1;
        return fileArr2[i];
    }
}
