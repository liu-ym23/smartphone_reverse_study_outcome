package com.bytedance.android.livesdk.chatroom.replay.widget;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/widget/DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f110293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f110294b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f110294b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f110293a.size();
    }

    public DiffCallback(List<? extends Object> r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "older");
        Intrinsics.checkNotNullParameter(r101, "newer");
        this.f110293a = r100;
        this.f110294b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        Object r102 = CollectionsKt.getOrNull(this.f110293a, r100);
        Object r103 = CollectionsKt.getOrNull(this.f110294b, r101);
        if ((r102 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.a) == false) goto L9;
        if ((r103 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.a) == false) goto L9;
        return Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.replay.adapter.a) r102).f108112a, ((com.bytedance.android.livesdk.chatroom.replay.adapter.a) r103).f108112a);
    L9:
        if ((r102 instanceof EpisodeGroup) == false) goto L15;
        if ((r103 instanceof EpisodeGroup) == false) goto L15;
        return Intrinsics.areEqual(((EpisodeGroup) r102).groupName, ((EpisodeGroup) r103).groupName);
    L15:
        if ((r102 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.b) == true) goto L17;
        return false;
    L17:
        if ((r103 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.b) == false) goto L22;
        return true;
    L22:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        Object r102 = CollectionsKt.getOrNull(this.f110293a, r100);
        Object r103 = CollectionsKt.getOrNull(this.f110294b, r101);
        if ((r102 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.a) == false) goto L9;
        if ((r103 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.a) == false) goto L9;
        return Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.replay.adapter.a) r102).f108112a, ((com.bytedance.android.livesdk.chatroom.replay.adapter.a) r103).f108112a);
    L9:
        if ((r102 instanceof EpisodeGroup) == false) goto L15;
        if ((r103 instanceof EpisodeGroup) == false) goto L15;
        return Intrinsics.areEqual(((EpisodeGroup) r102).groupName, ((EpisodeGroup) r103).groupName);
    L15:
        if ((r102 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.b) == true) goto L17;
        return false;
    L17:
        if ((r103 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.b) == false) goto L22;
        return true;
    L22:
        return false;
    }
}
