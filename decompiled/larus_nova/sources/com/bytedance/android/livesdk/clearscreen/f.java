package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$GuideType;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f119367a;

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L4:
        if (ClearScreenHelper.d(null) == false) goto L6;
        xs2.b.a().post(new m(ClearScreenConst$GuideType.SHOW_CLICK_CLEAR, this.f119367a));     // Catch: Throwable -> L8
    L13:
        return;
    L6:
        xs2.b.a().post(new m(ClearScreenConst$GuideType.SHOW_CLEAR, this.f119367a));     // Catch: Throwable -> L8
        goto L13
    }

    public f(String r100) {
        this.f119367a = r100;
    }
}
