package com.bytedance.android.btm.bridge.provider;

import android.view.View;
import com.bytedance.android.btm.bridge.b;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0018\u00010\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/btm/bridge/provider/IBtmBridgeDefaultConfig;", "", "", "Ljava/lang/Class;", "Landroid/view/View;", "getHybridViewClasses", "Lcom/bytedance/android/btm/bridge/b;", "getHybridContainerContext", "btm-bridge_cnRelease"}, k = 1, mv = {1, 4, 0})
public interface IBtmBridgeDefaultConfig {
    b getHybridContainerContext();

    List<Class<? extends View>> getHybridViewClasses();
}
