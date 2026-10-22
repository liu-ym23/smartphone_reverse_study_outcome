package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.quickcomment.QuickCommentViewModel;
import com.bytedance.android.livesdk.interactivity.quickcomment.QuickCommentWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/QuickCommentService;", "Lcom/bytedance/android/livesdk/interactivity/api/IQuickCommentService;", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getQuickCommentWidgetClass", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/f;", "getQuickCommentService", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class QuickCommentService implements IQuickCommentService {
    public QuickCommentService() {
        jc1.k.l(IQuickCommentService.class, this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IQuickCommentService
    public Class<? extends Widget> getQuickCommentWidgetClass() {
        return QuickCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IQuickCommentService
    public com.bytedance.android.livesdk.interactivity.api.quickcomment.f getQuickCommentService(MiddlewareRoomContext r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        return new QuickCommentViewModel(r100, r101);
    }
}
