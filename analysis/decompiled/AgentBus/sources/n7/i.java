package n7;

import a4.u;
import java.io.File;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class i extends d7.b {

    /* renamed from: h, reason: collision with root package name */
    public final ArrayDeque f6867h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ fa.i f6868i;

    public i(fa.i iVar) {
        this.f6868i = iVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f6867h = arrayDeque;
        File file = (File) iVar.f3634b;
        if (file.isDirectory()) {
            arrayDeque.push(c(file));
        } else if (!file.isFile()) {
            this.f2945f = 2;
        } else {
            q7.k.e(file, "rootFile");
            arrayDeque.push(new g(file));
        }
    }

    @Override // d7.b
    public final void a() {
        File file;
        File fileA;
        while (true) {
            ArrayDeque arrayDeque = this.f6867h;
            j jVar = (j) arrayDeque.peek();
            if (jVar == null) {
                file = null;
                break;
            }
            fileA = jVar.a();
            if (fileA == null) {
                arrayDeque.pop();
            } else if (fileA.equals(jVar.f6869a) || !fileA.isDirectory() || arrayDeque.size() >= Integer.MAX_VALUE) {
                break;
            } else {
                arrayDeque.push(c(fileA));
            }
        }
        file = fileA;
        if (file == null) {
            this.f2945f = 2;
        } else {
            this.f2946g = file;
            this.f2945f = 1;
        }
    }

    public final e c(File file) {
        int iOrdinal = ((k) this.f6868i.f3635c).ordinal();
        if (iOrdinal == 0) {
            q7.k.e(file, "rootDir");
            return new h(file);
        }
        if (iOrdinal != 1) {
            throw new u();
        }
        q7.k.e(file, "rootDir");
        return new f(file);
    }
}
