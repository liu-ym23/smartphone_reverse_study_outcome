package ub;

import java.io.File;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: b, reason: collision with root package name */
    public boolean f14289b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f14290c;

    /* renamed from: d, reason: collision with root package name */
    public int f14291d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14292e;

    @Override // ub.f
    public final File a() {
        File file = this.f14297a;
        if (!this.f14292e && this.f14290c == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f14290c = fileArrListFiles;
            if (fileArrListFiles == null) {
                this.f14292e = true;
            }
        }
        File[] fileArr = this.f14290c;
        if (fileArr == null || this.f14291d >= fileArr.length) {
            if (this.f14289b) {
                return null;
            }
            this.f14289b = true;
            return file;
        }
        fileArr.getClass();
        int i = this.f14291d;
        this.f14291d = i + 1;
        return fileArr[i];
    }
}
