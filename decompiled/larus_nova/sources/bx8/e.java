package bx8;

import com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper;
import com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginListener;
import com.bytedance.caijing.sdk.infra.base.api.container.SilentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements ILivePluginHelper {
    public e() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper
    public final void a() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper
    public final boolean hasPluginInstalled() {
        return true;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper
    public final boolean hasPluginLoaded() {
        return true;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper
    public final void checkLiveAvailableAndInstall(ILivePluginListener r100, SilentType r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginListener");
        Intrinsics.checkNotNullParameter(r101, "silentType");
        r100.onSuccess();
    }
}
