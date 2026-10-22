package com.bytedance.android.live.liveinteract.videotalk.emoji;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/DynamicEmojiDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicEmojiDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends TalkRoomBaseDynamicEmoji> f79311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends TalkRoomBaseDynamicEmoji> f79312b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f79312b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        List<? extends TalkRoomBaseDynamicEmoji> r100 = this.f79311a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public DynamicEmojiDiffCallback(List<? extends TalkRoomBaseDynamicEmoji> r100, List<? extends TalkRoomBaseDynamicEmoji> r101) {
        Intrinsics.checkNotNullParameter(r101, "newDatas");
        this.f79311a = r100;
        this.f79312b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        List<? extends TalkRoomBaseDynamicEmoji> r102 = this.f79311a;
        if (r102 == null) goto L5;
        TalkRoomBaseDynamicEmoji r103 = (TalkRoomBaseDynamicEmoji) ListProtector.get(r102, r100);
    L6:
        TalkRoomBaseDynamicEmoji r104 = (TalkRoomBaseDynamicEmoji) ListProtector.get(this.f79312b, r101);
        if ((r103 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L12;
        if ((r104 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L12;
        return true;
    L12:
        if (r104 == null) goto L29;
        if (r103 == null) goto L29;
        if ((r103 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L18;
    L28:
        return false;
    L18:
        if ((r104 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == true) goto L28;
        if (Intrinsics.areEqual(r103.emojiName, r104.emojiName) == false) goto L26;
        py.k r105 = r103.emojiImage();
        if (r105 == null) goto L26;
        if (r105.equalsOnlyUri(r104.emojiImage()) != true) goto L26;
        return true;
    L26:
        return false;
    L29:
        if (r104 == r103) goto L34;
        return false;
    L34:
        return true;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        List<? extends TalkRoomBaseDynamicEmoji> r102 = this.f79311a;
        if (r102 == null) goto L5;
        TalkRoomBaseDynamicEmoji r103 = (TalkRoomBaseDynamicEmoji) ListProtector.get(r102, r100);
    L6:
        TalkRoomBaseDynamicEmoji r104 = (TalkRoomBaseDynamicEmoji) ListProtector.get(this.f79312b, r101);
        if (r104 == null) goto L21;
        if (r103 == null) goto L21;
        if (r103.type == r104.type) goto L14;
        return false;
    L14:
        if ((r103 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L16;
    L20:
        return true;
    L16:
        if ((r104 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == true) goto L20;
        if (r103.emojiId == r104.emojiId) goto L20;
        return false;
    L21:
        if (r104 == r103) goto L25;
        return false;
    L25:
        return true;
    L5:
        r103 = null;
        goto L6
    }
}
