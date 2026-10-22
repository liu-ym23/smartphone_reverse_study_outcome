package android.net.shared;

import java.net.InetAddress;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InitialConfiguration$$ExternalSyntheticLambda11 implements Function {
    public /* synthetic */ InitialConfiguration$$ExternalSyntheticLambda11() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return IpConfigurationParcelableUtil.parcelAddress((InetAddress) r1);
    }
}
