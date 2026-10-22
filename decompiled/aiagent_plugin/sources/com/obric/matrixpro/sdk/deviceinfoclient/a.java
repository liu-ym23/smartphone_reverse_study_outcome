package com.obric.matrixpro.sdk.deviceinfoclient;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Closeable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: DeviceInfoGetter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HandlerThread f33778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f33779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Handler f33780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f33781e;
    private static CopyOnWriteArrayList<ContentObserverWrapper> f;
    private static Context g;

    /* JADX INFO: renamed from: com.obric.matrixpro.sdk.deviceinfoclient.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DeviceInfoGetter.kt */
    public interface InterfaceC0914a {
        void a(String r1);

        void b(String r1);
    }

    /* JADX INFO: compiled from: DeviceInfoGetter.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f33782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0914a f33783b;

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L11;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f33782a, r4.f33782a) == true) goto L9;
            return false;
        L9:
            if (o.a(this.f33783b, r4.f33783b) == true) goto L17;
            return false;
        L17:
            return true;
        L11:
            return false;
        }

        public int hashCode() {
            Context r0 = this.f33782a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            InterfaceC0914a r4 = this.f33783b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "OsDidRequest(context=" + this.f33782a + ", callback=" + this.f33783b + ")";
        }

        public b(Context r3, InterfaceC0914a r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            InterfaceC0914a r6 = (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0914a.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            o.e(r6, "callback");
            this.f33782a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            this.f33783b = r6;
        }

        public final Context getContext() {
            return this.f33782a;
        }

        public final InterfaceC0914a a() {
            return this.f33783b;
        }
    }

    /* JADX INFO: compiled from: DeviceInfoGetter.kt */
    static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0914a f33784a;

        c(InterfaceC0914a r3) {
            this.f33784a = (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0914a.class, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f33784a.a("查询失败：Cursor为空");
        }
    }

    /* JADX INFO: compiled from: DeviceInfoGetter.kt */
    static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0914a f33785a;

        d(InterfaceC0914a r3) {
            this.f33785a = (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0914a.class, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f33785a.a("Cursor无有效数据");
        }
    }

    /* JADX INFO: compiled from: DeviceInfoGetter.kt */
    static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f33786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f33787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0914a f33788c;

        e(String r3, String r4, InterfaceC0914a r5) {
            InterfaceC0914a r6 = (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0914a.class, "com.obric.aiagent.plugin");
            this.f33786a = r3;
            this.f33787b = r4;
            this.f33788c = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = this.f33786a;
            if (r0 == null) goto L5;
            this.f33788c.a(r0);
            return;
        L5:
            String r1 = this.f33787b;
            if (r1 != null) goto L8;
        L13:
            this.f33788c.a("OSDID为空或列索引异常");
            return;
        L8:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
            boolean r2 = true;
        L11:
            if (r2 == false) goto L13;
            a.a(a.f33777a, this.f33787b);
            this.f33788c.b(this.f33787b);
            return;
        L10:
            r2 = false;
            goto L11
        }
    }

    /* JADX INFO: compiled from: DeviceInfoGetter.kt */
    static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0914a f33789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception f33790b;

        f(InterfaceC0914a r3, Exception r4) {
            this.f33789a = (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0914a.class, "com.obric.aiagent.plugin");
            this.f33790b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC0914a r0 = this.f33789a;
            StringBuilder r1 = new StringBuilder().append("获取失败：");
            String r3 = this.f33790b.getMessage();
            if (r3 != null) goto L5;
            r3 = "未知异常";
        L5:
            r0.a(r1.append(r3).toString());
        }
    }

    static {
        f33777a = new a();
        f = new CopyOnWriteArrayList();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r2, Context r3, InterfaceC0914a r4) {
        r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0914a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        f33781e = r1;
    }

    private final void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (g != null) goto L6;
        g = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L6:
        if (f33778b != null) goto L15;
        HandlerThread r6 = new HandlerThread("DeviceInfoGetter-Worker");
        f33778b = r6;
        if (r6 != null) goto L10;
        o.c("handlerThread");
    L10:
        r6.start();
        HandlerThread r2 = f33778b;
        if (r2 != null) goto L13;
        o.c("handlerThread");
    L13:
        final Looper r0 = r2.getLooper();
        f33779c = (Handler) ZeusTransformUtils.preCheckCast(new DeviceInfoGetter$initThreadIfNeeded$2(this, r0), Handler.class, "com.obric.aiagent.plugin");
        f33780d = new Handler(Looper.getMainLooper());
        return;
    }

    private final void b(Context r11, InterfaceC0914a r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        InterfaceC0914a r14 = (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r12, InterfaceC0914a.class, "com.obric.aiagent.plugin");
        Cursor r15 = ZeusProviderTransform.query(r13.getContentResolver(), Uri.parse("content://com.bytedance.securityserver.deviceInfoProvider/get_osdid"), null, null, null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L37
        if (r15 == null) goto L32;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37
        Cursor r16 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r16.moveToFirst() == true) goto L14;
        Handler r17 = f33780d;     // Catch: Throwable -> L27
        if (r17 != null) goto L11;
        o.c("mainHandler");     // Catch: Throwable -> L27
    L11:
        r17.post((Runnable) ZeusTransformUtils.preCheckCast(new d(r14), Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        d.f.c.a(r10, null);     // Catch: Exception -> L37
        return;
    L14:
        int r1 = r16.getColumnIndex("osdid");     // Catch: Throwable -> L27
        int r4 = r16.getColumnIndex(WsConstants.KEY_CONNECTION_ERROR);     // Catch: Throwable -> L27
        if (r4 < 0) goto L17;
        String r5 = r16.getString(r4);     // Catch: Throwable -> L27
    L18:
        if (r1 < 0) goto L20;
        String r18 = r16.getString(r1);     // Catch: Throwable -> L27
    L21:
        Handler r2 = f33780d;     // Catch: Throwable -> L27
        if (r2 != null) goto L24;
        o.c("mainHandler");     // Catch: Throwable -> L27
    L24:
        r2.post((Runnable) ZeusTransformUtils.preCheckCast(new e(r5, r18, r14), Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        d.f.c.a(r10, null);     // Catch: Exception -> L37
        return;
    L20:
        r18 = null;
        goto L21
    L17:
        r5 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        d.f.c.a(r10, th);     // Catch: Exception -> L37
        throw th;     // Catch: Exception -> L37
    L32:
        a r19 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37
        Handler r110 = f33780d;     // Catch: Exception -> L37
        if (r110 != null) goto L35;
        o.c("mainHandler");     // Catch: Exception -> L37
    L35:
        r110.post((Runnable) ZeusTransformUtils.preCheckCast(new c(r14), Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        com.obric.matrixpro.sdk.deviceinfoclient.b.f33791a.a("OsDidClient", "查询OSDID异常", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        Handler r111 = f33780d;
        if (r111 != null) goto L41;
        o.c("mainHandler");
    L41:
        r111.post((Runnable) ZeusTransformUtils.preCheckCast(new f(r14, e), Runnable.class, "com.obric.aiagent.plugin"));
    }

    public final void a(Context r3, InterfaceC0914a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        InterfaceC0914a r6 = (InterfaceC0914a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0914a.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "callback");
        a(r5);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context.applicationContext");
        b r2 = new b(r7, r6);
        Handler r8 = f33779c;
        if (r8 != null) goto L5;
        o.c("workerHandler");
    L5:
        Message r9 = Message.obtain(r8, 1, r2);
        Handler r10 = f33779c;
        if (r10 != null) goto L8;
        o.c("workerHandler");
    L8:
        r10.sendMessage(r9);
    }
}
