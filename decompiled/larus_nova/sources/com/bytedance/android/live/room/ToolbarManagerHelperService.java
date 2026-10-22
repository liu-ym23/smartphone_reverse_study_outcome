package com.bytedance.android.live.room;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarMutexHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/ToolbarManagerHelperService;", "Lcom/bytedance/android/live/room/IToolbarManagerHelper;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0;", "unfolder", DocumentType.FOLDER_NAME, "both", "Lcom/bytedance/android/livesdk/chatroom/utils/c0;", "toolbarHelper", "<init>", "()V", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarManagerHelperService implements IToolbarManagerHelper {
    public ToolbarManagerHelperService() {
    }

    @Override // com.bytedance.android.live.room.IToolbarManagerHelper
    public c0 both(DataCenter r100) {
        return y3.b(r100);
    }

    @Override // com.bytedance.android.live.room.IToolbarManagerHelper
    public c0 folder(DataCenter r100) {
        return y3.f(r100);
    }

    @Override // com.bytedance.android.live.room.IToolbarManagerHelper
    public com.bytedance.android.livesdk.chatroom.utils.c0 toolbarHelper(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new ToolbarMutexHelper(r100);
    }

    @Override // com.bytedance.android.live.room.IToolbarManagerHelper
    public c0 unfolder(DataCenter r100) {
        return y3.m(r100);
    }
}
