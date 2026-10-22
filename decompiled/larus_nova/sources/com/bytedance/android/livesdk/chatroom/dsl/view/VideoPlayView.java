package com.bytedance.android.livesdk.chatroom.dsl.view;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveVideoPreviewView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/dsl/view/VideoPlayView;", "Lcom/bytedance/android/livesdk/chatroom/backtrack/LiveVideoPreviewView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPlayView extends LiveVideoPreviewView {
    public VideoPlayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
