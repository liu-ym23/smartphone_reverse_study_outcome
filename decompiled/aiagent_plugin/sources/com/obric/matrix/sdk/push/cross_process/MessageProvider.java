package com.obric.matrix.sdk.push.cross_process;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.matrix.push.common.a.c;
import com.obric.matrix.sdk.push.a;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: MessageProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MessageProvider extends PluginContentProvider implements a {
    private final CountDownLatch contextAttachedSignal;
    private final AtomicBoolean initComplete;
    private final String tag;

    public MessageProvider() {
        this.tag = "MessageProvider";
        this.initComplete = new AtomicBoolean();
        this.contextAttachedSignal = new CountDownLatch(1);
    }

    public Bundle call(String r6, String r7, Bundle r8) {
        o.e(r6, "method");
        c.a(this.tag, "message provider call: " + r6 + ", " + r7 + ", " + r8);
        ensureInitComplete();
        if (o.a(getCallingPackage(), "com.obric.matrix") == false) goto L20;
    L17:
        th = move-exception;
        c.c("message provider error: " + th);
        goto L20
    L5:
        if (o.a(r6, ".action.MESSAGE_EVENT") == false) goto L20;
        if (r8 == null) goto L20;
        Object r2 = r8.get("msg_id");     // Catch: Throwable -> L17
        if (r2 == null) goto L16;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Object r4 = r8.get("pass_though_data");     // Catch: Throwable -> L17
        if (r4 == null) goto L14;
        onReceiveMsg(new com.obric.matrix.sdk.push.a.a(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L17
        goto L20
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L17
    L20:
        return super.call(r6, r7, r8);
    }

    public void attachInfo(Context r3, ProviderInfo r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        c.b(this.tag, "attachInfo");
        super.attachInfo(r5, r4);
        this.contextAttachedSignal.countDown();
    }

    public boolean onCreate() {
        c.a(this.tag, "onCreate");
        return true;
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        ensureInitComplete();
        return 0;
    }

    public String getType(Uri r2) {
        o.e(r2, "uri");
        ensureInitComplete();
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        ensureInitComplete();
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        ensureInitComplete();
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        ensureInitComplete();
        return 0;
    }

    private final void ensureInitComplete() {
        AtomicBoolean r0 = this.initComplete;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.initComplete.get() == true) goto L7;
        waitForAppInit();     // Catch: Throwable -> L10
        this.initComplete.set(true);     // Catch: Throwable -> L10
    L7:
        x r2 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    private final void waitForAppInit() {
        long r3 = System.currentTimeMillis();
        this.contextAttachedSignal.await();     // Catch: Throwable -> L9 InterruptedException -> L11
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L8;
        c.a(this.tag, "wait for app init cost " + (System.currentTimeMillis() - r3) + " ms");
        return;
    L8:
        throw new IllegalArgumentException("context is null!".toString());     // Catch: Throwable -> L9 InterruptedException -> L11
    L11:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        c.a(this.tag, "wait for app init cost " + (System.currentTimeMillis() - r3) + " ms");
        throw th;
    }
}
