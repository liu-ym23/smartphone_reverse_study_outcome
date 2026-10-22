package com.bytedance.android.livesdk.action.instance;

import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0096\u0002J\b\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/action/instance/ShowMorePanelAction;", "Lcom/bytedance/android/livesdk/action/BaseActionMethod;", "", "()V", AbsMethodDelegate.TAG_INVOKE, "params", "", "", "", "onTerminate", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@ActionMethod("webcast_inroom_more_tools_panel")
public final class ShowMorePanelAction extends BaseActionMethod<Unit> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public ShowMorePanelAction() {
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r100) {
        x3 r101 = y3.l();
        if ((r101 instanceof x3) == true) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L9;
        c0.b r102 = r101.t(ToolbarButton.MORE);
        if (r102 == null) goto L9;
        r102.onClick(null);
    L9:
        finishWithResult(null);
    }
}
