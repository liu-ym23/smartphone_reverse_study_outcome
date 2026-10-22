package com.bytedance.android.live.livepkaudience.seat;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class PkDynamicEmojiTask extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f82227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DynamicEmojiView f82228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f82229d;

    @Override // com.bytedance.android.live.livepkaudience.seat.a
    public final void a(final h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof c) == false) goto L10;
        this.f82227b.a(SeatAnimTaskState.DYNAMIC_EMOJI);
        HSImageView r101 = this.f82229d;
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        DynamicEmojiView r102 = this.f82228c;
        if (r102 == null) goto L14;
        r102.b(((c) r100).f82236a, new PkDynamicEmojiTask$handle$1(this, r100));
        return;
    L14:
        return;
    L10:
        a r103 = this.f82235a;
        if (r103 == null) goto L16;
        r103.a(r100);
        return;
    }

    public PkDynamicEmojiTask(g r100, DynamicEmojiView r101, HSImageView r102) {
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        this.f82227b = r100;
        this.f82228c = r101;
        this.f82229d = r102;
    }
}
