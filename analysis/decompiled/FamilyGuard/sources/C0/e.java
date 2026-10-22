package C0;

import E0.a;
import java.io.File;
import z0.C1342h;
import z0.InterfaceC1338d;

/* loaded from: classes.dex */
class e<DataType> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC1338d<DataType> f315a;

    /* renamed from: b, reason: collision with root package name */
    private final DataType f316b;

    /* renamed from: c, reason: collision with root package name */
    private final C1342h f317c;

    e(InterfaceC1338d<DataType> interfaceC1338d, DataType datatype, C1342h c1342h) {
        this.f315a = interfaceC1338d;
        this.f316b = datatype;
        this.f317c = c1342h;
    }

    @Override // E0.a.b
    public boolean a(File file) {
        return this.f315a.b(this.f316b, file, this.f317c);
    }
}
