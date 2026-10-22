package com.stepos.motionkit;

import C7.r;
import S7.k;
import androidx.compose.ui.text.d;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/motionkit/FxModule;", "", "", "Lcom/stepos/motionkit/EffectDefinition;", "effects", "Lkotlin/Function1;", "Lcom/stepos/motionkit/FxConfig;", "LC7/r;", "config", "Lcom/stepos/motionkit/FxInstance;", "play", "(Ljava/util/List;LS7/k;)Lcom/stepos/motionkit/FxInstance;", "instance", "stop", "(Lcom/stepos/motionkit/FxInstance;)V", "", "fps", "setFrameRate", "(I)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FxModule {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ FxInstance play$default(FxModule fxModule, List list, k kVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
            }
            if ((i & 2) != 0) {
                kVar = new d(22);
            }
            return fxModule.play(list, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static r play$lambda$0(FxConfig fxConfig) {
            kotlin.jvm.internal.k.f(fxConfig, "<this>");
            return r.f317a;
        }
    }

    FxInstance play(List<EffectDefinition> effects, k config);

    void setFrameRate(int fps);

    void stop(FxInstance instance);
}
