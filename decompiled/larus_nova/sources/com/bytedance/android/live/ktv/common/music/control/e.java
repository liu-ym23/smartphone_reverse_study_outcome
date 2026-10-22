package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class e extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IMusicControlNode.OperationType f70027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRoom f70028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f70029h;

    public void e() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void c() {
        e();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public IMusicControlNode.OperationType getType() {
        return this.f70027f;
    }

    public e(MusicPanel r100, boolean r101, ModeType r102) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r102, "modeType");
        super(r100, r102);
        this.f70029h = r101;
        this.f70027f = IMusicControlNode.OperationType.PAUSE_MUSIC;
        m<IRoom> r103 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r103 == null) goto L5;
        IRoom r104 = r103.getValue();
    L6:
        this.f70028g = r104;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
