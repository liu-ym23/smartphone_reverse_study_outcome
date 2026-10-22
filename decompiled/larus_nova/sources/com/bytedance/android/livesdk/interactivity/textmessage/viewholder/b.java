package com.bytedance.android.livesdk.interactivity.textmessage.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f141288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f141289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f141290c;

    public b(View r100, long r101, Function0 r102) {
        this.f141288a = r100;
        this.f141289b = r101;
        this.f141290c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = this.f141288a.getTag(R.id.ttlive_tag_abs_text_msg);     // Catch: Throwable -> L10
        if ((r100 instanceof f) == false) goto L13;
        T r101 = ((f) r100).f133141b;     // Catch: Throwable -> L10
        if (r101 == 0) goto L17;
        long r102 = r101.getMessageId();     // Catch: Throwable -> L10
        if (this.f141289b == r102) goto L18;
        this.f141290c.invoke();     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
