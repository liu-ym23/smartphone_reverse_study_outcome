package com.bytedance.android.livesdk.audiencerecord;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import io.reactivex.functions.Action;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BacktrackServiceImp f104047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f104048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f104049c;

    public g(BacktrackServiceImp r100, String r101, ArrayList r102) {
        this.f104047a = r100;
        this.f104048b = r101;
        this.f104049c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f104047a.f103978b.b();
        BacktrackServiceImp r100 = this.f104047a;
        r100.f103985i = this.f104048b;
        int r101 = ue1.a.f549790a;
        ue1.a.a(this.f104049c);
        this.f104047a.f103977a.f(BacktrackState.DONE);
        this.f104047a.f103987k.put("cmd_show_aud_backtrack_finished_popup", new Object());
    }
}
