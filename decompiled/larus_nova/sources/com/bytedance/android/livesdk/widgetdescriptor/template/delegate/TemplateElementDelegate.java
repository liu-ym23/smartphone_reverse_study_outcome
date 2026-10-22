package com.bytedance.android.livesdk.widgetdescriptor.template.delegate;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.template.delegate.BaseTemplateDelegate;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/widgetdescriptor/template/delegate/TemplateElementDelegate;", "Lcom/bytedance/android/live/core/tetris/template/delegate/BaseTemplateDelegate;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TemplateElementDelegate extends BaseTemplateDelegate<e0> {
    @Override // com.bytedance.android.live.core.tetris.template.delegate.BaseTemplateDelegate
    public final void a(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
    }

    @Override // com.bytedance.android.live.core.tetris.template.delegate.BaseTemplateDelegate
    public final void b(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
    }

    public TemplateElementDelegate() {
    }
}
