package androidx.lifecycle;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.lifecycle.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0312i implements E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3948a = 2;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3949b;

    public C0312i() {
        Intrinsics.checkNotNullParameter(null, "generatedAdapter");
        this.f3949b = null;
    }

    @Override // androidx.lifecycle.E
    public final void a(G source, EnumC0326x event) {
        int i4 = this.f3948a;
        Object obj = this.f3949b;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                new HashMap();
                r[] rVarArr = (r[]) obj;
                if (rVarArr.length > 0) {
                    r rVar = rVarArr[0];
                    throw null;
                }
                if (rVarArr.length <= 0) {
                    return;
                }
                r rVar2 = rVarArr[0];
                throw null;
            case 1:
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == EnumC0326x.ON_CREATE) {
                    source.getLifecycle().b(this);
                    ((i0) obj).b();
                    return;
                } else {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
                }
            default:
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                B0.g.y(obj);
                throw null;
        }
    }

    public C0312i(r[] generatedAdapters) {
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        this.f3949b = generatedAdapters;
    }

    public C0312i(i0 provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f3949b = provider;
    }
}
