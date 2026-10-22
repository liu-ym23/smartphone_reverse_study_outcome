package com.bytedance.als;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/als/UIRootContainerGroupScene;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/als/UIRootContainerGroupScene;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class UIRootComponent$containerGroupScene$2 extends Lambda implements Function0<UIRootContainerGroupScene> {
    final /* synthetic */ UIRootComponent this$0;

    public UIRootComponent$containerGroupScene$2(UIRootComponent r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UIRootContainerGroupScene invoke() {
        UIRootContainerGroupScene r100 = this.this$0.f38087c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UIRootContainerGroupScene invoke() {
        return invoke();
    }
}
