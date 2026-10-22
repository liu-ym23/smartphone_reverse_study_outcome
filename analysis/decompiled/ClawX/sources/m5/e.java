package m5;

import java.io.File;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f3910b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f3911c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3912e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f3913f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, File rootDir) {
        super(rootDir);
        p.e(rootDir, "rootDir");
        this.f3913f = hVar;
    }

    @Override // m5.i
    public final File a() {
        boolean z = this.f3912e;
        File file = this.f3919a;
        if (!z && this.f3911c == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f3911c = fileArrListFiles;
            if (fileArrListFiles == null) {
                p5.p pVar = this.f3913f.d.f3922c;
                if (pVar != null) {
                    pVar.invoke(file, new a(file));
                }
                this.f3912e = true;
            }
        }
        File[] fileArr = this.f3911c;
        if (fileArr == null || this.d >= fileArr.length) {
            if (this.f3910b) {
                return null;
            }
            this.f3910b = true;
            return file;
        }
        p.b(fileArr);
        int i8 = this.d;
        this.d = i8 + 1;
        return fileArr[i8];
    }
}
