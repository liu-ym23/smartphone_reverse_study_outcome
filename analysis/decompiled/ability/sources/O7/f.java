package O7;

import D7.AbstractC0210b;
import java.io.File;
import java.util.ArrayDeque;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.FileWalkDirection;

/* loaded from: classes3.dex */
public final class f extends AbstractC0210b {
    public final ArrayDeque c;
    public final /* synthetic */ h d;

    public f(h hVar) {
        this.d = hVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.c = arrayDeque;
        File file = (File) hVar.b;
        if (file.isDirectory()) {
            arrayDeque.push(b(file));
        } else if (file.isFile()) {
            arrayDeque.push(new d(file));
        } else {
            this.f400a = 2;
        }
    }

    @Override // D7.AbstractC0210b
    public final void a() {
        File file;
        File fileA;
        while (true) {
            ArrayDeque arrayDeque = this.c;
            g gVar = (g) arrayDeque.peek();
            if (gVar == null) {
                file = null;
                break;
            }
            fileA = gVar.a();
            if (fileA == null) {
                arrayDeque.pop();
            } else if (fileA.equals(gVar.f1039a) || !fileA.isDirectory() || arrayDeque.size() >= Integer.MAX_VALUE) {
                break;
            } else {
                arrayDeque.push(b(fileA));
            }
        }
        file = fileA;
        if (file == null) {
            this.f400a = 2;
        } else {
            this.b = file;
            this.f400a = 1;
        }
    }

    public final b b(File file) {
        int iOrdinal = ((FileWalkDirection) this.d.c).ordinal();
        if (iOrdinal == 0) {
            return new e(file);
        }
        if (iOrdinal == 1) {
            return new c(file);
        }
        throw new NoWhenBranchMatchedException();
    }
}
