package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggView f140009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a f140010b;

    public f(LikeEggView r100, com.bytedance.android.livesdk.chatroom.likeegg.a r101) {
        this.f140009a = r100;
        this.f140010b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView r100 = this.f140009a.f139989d;     // Catch: Throwable -> L16
        if (r100 == null) goto L19;
        String r101 = this.f140010b.finishContent;     // Catch: Throwable -> L16
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        String r103 = "点赞完成 彩蛋即将揭晓";
    L14:
        r100.setText(r103);     // Catch: Throwable -> L16
        return;
    L13:
        r103 = this.f140010b.finishContent;     // Catch: Throwable -> L16
        goto L14
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L19:
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
