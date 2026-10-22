package com.bytedance.android.livesdk.chatroom.tetris.vr;

import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class x implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrModeAudienceTetris f111961a;

    public x(VrModeAudienceTetris r100) {
        this.f111961a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        UIUtils.setViewVisibility(this.f111961a.C, 8);
    }
}
