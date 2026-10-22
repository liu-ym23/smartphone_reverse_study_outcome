package android.net.shared;

import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InitialConfiguration$$ExternalSyntheticLambda8 implements Function {
    public /* synthetic */ InitialConfiguration$$ExternalSyntheticLambda8() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return IpConfigurationParcelableUtil.unparcelAddress((String) r1);
    }
}
