package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/SelectedMsgLayoutManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/SmoothLinearLayoutManager;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectedMsgLayoutManager extends SmoothLinearLayoutManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f139462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectedMsgLayoutManager$scrollController$1 f139463c;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.SelectedMsgLayoutManager$scrollController$1] */
    public SelectedMsgLayoutManager(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f139462b = Integer.MAX_VALUE;
        this.f139463c = new SelectedMsgLayoutManager$scrollController$1(this, r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        int r103 = Math.max(0, r102);
        setTargetPosition(r103);
        startSmoothScroll(this.f139463c);
    }
}
