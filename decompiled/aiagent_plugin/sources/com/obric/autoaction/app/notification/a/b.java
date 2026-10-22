package com.obric.autoaction.app.notification.a;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BaseChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManagerCompat f24566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f24567b;

    public abstract String a();

    public abstract int b();

    public b() {
    }

    public final void a(NotificationManagerCompat r1) {
        this.f24566a = r1;
    }

    public final void a(c r1) {
        this.f24567b = r1;
    }

    public j.c a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        j.c r4 = new j.c(a(), 4).a((CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(b()), CharSequence.class, "com.obric.aiagent.plugin")).a(true);
        o.c(r4, "setVibrationEnabled(...)");
        return r4;
    }
}
