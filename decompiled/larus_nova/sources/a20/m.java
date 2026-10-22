package a20;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenFeatureIconCallbackFrom f1406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OpenFeatureIconCallbackType f1407b;

    public final OpenFeatureIconCallbackType getType() {
        return this.f1407b;
    }

    public m(OpenFeatureIconCallbackFrom r100, OpenFeatureIconCallbackType r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f1406a = r100;
        this.f1407b = r101;
    }
}
