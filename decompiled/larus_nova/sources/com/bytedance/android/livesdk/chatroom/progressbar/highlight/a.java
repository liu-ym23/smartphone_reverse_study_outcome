package com.bytedance.android.livesdk.chatroom.progressbar.highlight;

import com.bytedance.android.livesdk.chatroom.progressbar.highlight.VsSeekHighLightResultModel;
import com.bytedance.android.livesdk.chatroom.progressbar.highlight.g;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<P extends g, R extends VsSeekHighLightResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
