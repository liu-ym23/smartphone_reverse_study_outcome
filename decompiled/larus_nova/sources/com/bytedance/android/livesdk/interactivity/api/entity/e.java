package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.r;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f133137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g52.c f133138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f133139c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.r
    public final void onFailed() {
        ALogger.d("PSOperatePanel", "open panel fail");
        boolean r100 = this.f133139c.E(this.f133138b);
        WeakReference r101 = this.f133137a;
        if (r101 == null) goto L5;
        Function1 r102 = (Function1) r101.get();
    L6:
        if (r102 == null) goto L9;
        r102.invoke(Boolean.valueOf(r100));
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.r
    public final void onSuccess() {
        ALogger.d("PSOperatePanel", "success open panel");
        this.f133139c.J("action_sheet");
        WeakReference r100 = this.f133137a;
        if (r100 == null) goto L5;
        Function1 r101 = (Function1) r100.get();
    L6:
        if (r101 == null) goto L9;
        r101.invoke(Boolean.TRUE);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public e(f r100, WeakReference r101, g52.c r102) {
        this.f133139c = r100;
        this.f133137a = r101;
        this.f133138b = r102;
    }
}
