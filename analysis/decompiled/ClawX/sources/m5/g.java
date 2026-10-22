package m5;

import java.io.File;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f3915b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f3916c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f3917e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, File rootDir) {
        super(rootDir);
        p.e(rootDir, "rootDir");
        this.f3917e = hVar;
    }

    @Override // m5.i
    public final File a() {
        p5.p pVar;
        boolean z = this.f3915b;
        File file = this.f3919a;
        if (!z) {
            this.f3915b = true;
            return file;
        }
        File[] fileArr = this.f3916c;
        if (fileArr != null && this.d >= fileArr.length) {
            return null;
        }
        if (fileArr == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f3916c = fileArrListFiles;
            if (fileArrListFiles == null && (pVar = this.f3917e.d.f3922c) != null) {
                pVar.invoke(file, new a(file));
            }
            File[] fileArr2 = this.f3916c;
            if (fileArr2 == null || fileArr2.length == 0) {
                return null;
            }
        }
        File[] fileArr3 = this.f3916c;
        p.b(fileArr3);
        int i8 = this.d;
        this.d = i8 + 1;
        return fileArr3[i8];
    }
}
