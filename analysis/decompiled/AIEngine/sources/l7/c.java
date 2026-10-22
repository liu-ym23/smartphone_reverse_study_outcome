package l7;

import com.stepos.core.common.utils.SysfsReader;
import java.util.function.Supplier;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10345a;

    public /* synthetic */ c(int i10) {
        this.f10345a = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f10345a) {
            case 0:
                return new byte[1024];
            default:
                return SysfsReader.scratch$lambda$0();
        }
    }
}
