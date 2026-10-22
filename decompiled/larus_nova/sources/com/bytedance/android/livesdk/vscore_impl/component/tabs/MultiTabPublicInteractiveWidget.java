package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/MultiTabPublicInteractiveWidget;", "Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/BaseMatchNativeWidget;", "Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/s$a;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiTabPublicInteractiveWidget extends BaseMatchNativeWidget {
    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_match_live_public_interactive_widget;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.BaseMatchNativeWidget
    public final void xq(boolean r100) {
    }

    public MultiTabPublicInteractiveWidget() {
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.s.a
    public final MultiTabType Ad() {
        return MultiTabType.PUBLIC_INTERACT_TAB;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.BaseMatchNativeWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        if ((this.contentView instanceof FrameLayout) == true) goto L5;
        return;
    L5:
        super.onLoad(r100);
    }
}
