package com.obric.matrix.platform.sdk.ones.location;

import android.net.Uri;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends MatrixEventObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Function0 f11936f;

    public a() {
        super("/location/status", false, null, 4, null);
    }

    @Override // com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver
    public void c(Uri r10) {
        q.g(r10, "uri");
        if (this.f11936f != null) goto L6;
        return;
    L6:
        if (q.b(r10.getPath(), "/location/status") == false) goto L11;
        Function0 r11 = this.f11936f;
        if (r11 == null) goto L12;
        r11.invoke();
        return;
    L12:
        return;
    }
}
