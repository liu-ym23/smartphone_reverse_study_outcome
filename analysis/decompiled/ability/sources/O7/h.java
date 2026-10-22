package O7;

import S7.k;
import java.io.File;
import java.util.Iterator;
import kotlin.io.FileWalkDirection;

/* loaded from: classes3.dex */
public final class h implements i9.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1040a = 1;
    public final Object b;
    public final Object c;

    public h(File file) {
        FileWalkDirection fileWalkDirection = FileWalkDirection.f4914a;
        this.b = file;
        this.c = fileWalkDirection;
    }

    @Override // i9.i
    public final Iterator iterator() {
        switch (this.f1040a) {
            case 0:
                return new f(this);
            default:
                return new i9.h(this);
        }
    }

    public h(S7.a aVar, k getNextValue) {
        kotlin.jvm.internal.k.f(getNextValue, "getNextValue");
        this.b = aVar;
        this.c = getNextValue;
    }
}
