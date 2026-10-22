package fa;

import java.io.File;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3633a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3634b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3635c;

    public i(File file) {
        n7.k kVar = n7.k.f6870f;
        q7.k.e(file, "start");
        this.f3634b = file;
        this.f3635c = kVar;
    }

    @Override // fa.j
    public final Iterator iterator() {
        switch (this.f3633a) {
            case 0:
                return new h(this);
            default:
                return new n7.i(this);
        }
    }

    public i(p7.a aVar, p7.k kVar) {
        this.f3634b = aVar;
        this.f3635c = kVar;
    }
}
