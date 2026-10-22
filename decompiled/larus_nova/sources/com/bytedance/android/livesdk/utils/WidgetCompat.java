package com.bytedance.android.livesdk.utils;

import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/utils/WidgetCompat;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "()V", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WidgetCompat extends Widget implements LifecycleOwnerCompat {
    @Override // com.bytedance.ies.sdk.widgets.Widget, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return getLifecycleCompat();
    }

    public WidgetCompat() {
    }

    public Lifecycle getLifecycleCompat() {
        return this.lifecycleRegistry;
    }
}
