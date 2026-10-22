package com.obric.matrixpro.sdk.deviceinfoclient;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ContentObserverWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContentObserverWrapper extends ContentObserver {
    private final a.InterfaceC0914a callback;

    public final a.InterfaceC0914a getCallback() {
        return this.callback;
    }

    public ContentObserverWrapper(Handler r3, a.InterfaceC0914a r4) {
        a.InterfaceC0914a r5 = (a.InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r4, a.InterfaceC0914a.class, "com.obric.aiagent.plugin");
        o.e(r3, "handler");
        o.e(r5, "callback");
        super(r3);
        this.callback = r5;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r3, Uri r4) {
        if (r4 == null) goto L4;
        String r5 = r4.getQueryParameter("value");
    L5:
        b.f33791a.a("matrix_pro", "receive did change from content observer: " + r5);
        a.InterfaceC0914a r2 = this.callback;
        if (r5 != null) goto L8;
        return;
    L8:
        r2.b(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public boolean equals(Object r4) {
        a.InterfaceC0914a r2 = null;
        if (ZeusTransformUtils.instanceOf(r4, ContentObserverWrapper.class) == true) goto L5;
        r4 = null;
    L5:
        ContentObserverWrapper r5 = (ContentObserverWrapper) ZeusTransformUtils.preCheckCast(r4, ContentObserverWrapper.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        r2 = r5.callback;
    L9:
        return o.a(r2, this.callback);
    }

    public int hashCode() {
        return this.callback.hashCode();
    }
}
