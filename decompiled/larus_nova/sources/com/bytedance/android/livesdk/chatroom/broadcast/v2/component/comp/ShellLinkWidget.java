package com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp;

import com.bytedance.android.live.link.ILinkServiceExternal;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/broadcast/v2/component/comp/ShellLinkWidget;", "Lcom/bytedance/android/livesdk/chatroom/broadcast/v2/component/comp/AbsShellWidget;", "<init>", "()V", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShellLinkWidget extends AbsShellWidget {
    @Override // com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.AbsShellWidget
    public final void wq() {
        ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getPerfManagerExternal().release();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getPerfManagerExternal().onBackground();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getPerfManagerExternal().onForeground();
    }

    public ShellLinkWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
    }
}
