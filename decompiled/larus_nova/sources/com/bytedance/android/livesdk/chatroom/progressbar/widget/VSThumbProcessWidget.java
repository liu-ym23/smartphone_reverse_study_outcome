package com.bytedance.android.livesdk.chatroom.progressbar.widget;

import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdk.chatroom.progressbar.f;
import com.bytedance.android.livesdk.widget.LiveThumbProcessWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progressbar/widget/VSThumbProcessWidget;", "Lcom/bytedance/android/livesdk/widget/LiveThumbProcessWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSThumbProcessWidget extends LiveThumbProcessWidget {
    @Override // com.bytedance.android.livesdk.widget.LiveThumbProcessWidget
    public final IProgressCastService wq() {
        return new f();
    }

    public VSThumbProcessWidget() {
    }
}
