package com.stepos.motionkit;

import com.stepos.motionkit.FxInstance;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/motionkit/InternalFxInstance;", "Lcom/stepos/motionkit/FxInstance;", "", "elapsedMs", "", "dt", "LC7/r;", "onFrame", "(JF)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface InternalFxInstance extends FxInstance {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static FxInstance instance(InternalFxInstance internalFxInstance, String name) {
            k.f(name, "name");
            return FxInstance.DefaultImpls.instance(internalFxInstance, name);
        }
    }

    void onFrame(long elapsedMs, float dt);
}
