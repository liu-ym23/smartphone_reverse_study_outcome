package com.bytedance.android.livesdk.audiencerecord;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BacktrackServiceImp f104059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f104060b;

    public n(BacktrackServiceImp r100, String r101) {
        this.f104059a = r100;
        this.f104060b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f104059a.f103978b.b();
        BacktrackServiceImp r100 = this.f104059a;
        r100.f103985i = this.f104060b;
        r100.f103977a.f(BacktrackState.DONE);
        this.f104059a.f103987k.put("cmd_show_aud_backtrack_finished_popup", new Object());
    }
}
