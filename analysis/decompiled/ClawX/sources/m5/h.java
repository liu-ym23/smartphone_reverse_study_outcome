package m5;

import a6.w;
import java.io.File;
import java.util.ArrayDeque;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends c5.c {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f3918c;
    public final /* synthetic */ j d;

    public h(j jVar) {
        this.d = jVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f3918c = arrayDeque;
        File rootFile = jVar.f3920a;
        if (rootFile.isDirectory()) {
            arrayDeque.push(b(rootFile));
        } else if (!rootFile.isFile()) {
            this.f1079a = 2;
        } else {
            p.e(rootFile, "rootFile");
            arrayDeque.push(new f(rootFile));
        }
    }

    @Override // c5.c
    public final void a() {
        File file;
        File fileA;
        while (true) {
            ArrayDeque arrayDeque = this.f3918c;
            i iVar = (i) arrayDeque.peek();
            if (iVar == null) {
                file = null;
                break;
            }
            fileA = iVar.a();
            if (fileA == null) {
                arrayDeque.pop();
            } else if (fileA.equals(iVar.f3919a) || !fileA.isDirectory() || arrayDeque.size() >= Integer.MAX_VALUE) {
                break;
            } else {
                arrayDeque.push(b(fileA));
            }
        }
        file = fileA;
        if (file == null) {
            this.f1079a = 2;
        } else {
            this.f1080b = file;
            this.f1079a = 1;
        }
    }

    public final d b(File file) {
        int iOrdinal = this.d.f3921b.ordinal();
        if (iOrdinal == 0) {
            return new g(this, file);
        }
        if (iOrdinal == 1) {
            return new e(this, file);
        }
        throw new w();
    }
}
