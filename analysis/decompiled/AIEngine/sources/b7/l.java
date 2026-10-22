package b7;

import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImplKt;
import java.io.File;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f3104b;

    public /* synthetic */ l(Set set, int i10) {
        this.f3103a = i10;
        this.f3104b = set;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f3103a) {
            case 0:
                File it = (File) obj;
                kotlin.jvm.internal.g.f(it, "it");
                boolean z = false;
                if (it.isFile()) {
                    String name = it.getName();
                    kotlin.jvm.internal.g.e(name, "getName(...)");
                    if (!gc.o.k0(name, ".", false)) {
                        String lowerCase = wb.d.U(it).toLowerCase(Locale.ROOT);
                        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
                        if (this.f3104b.contains(lowerCase)) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            default:
                return Boolean.valueOf(OtaDeepBinderServiceImplKt.totalBytes$lambda$0(this.f3104b, (File) obj));
        }
    }
}
