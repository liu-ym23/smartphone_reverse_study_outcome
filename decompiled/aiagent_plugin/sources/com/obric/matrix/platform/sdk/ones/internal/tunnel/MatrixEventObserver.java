package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: MatrixEventObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MatrixEventObserver extends ContentObserver {
    private static final String BROADCAST_PROVIDER_AUTHORITY = "com.obric.matrix.outward_event_provider";
    public static final a Companion = null;
    private static final String TAG = "MatrixEventObserver";
    private final String myPath;
    private final f myUri$delegate;
    private final boolean notifyForDescendants;
    private volatile boolean registered;

    /* JADX INFO: compiled from: MatrixEventObserver.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MatrixEventObserver.kt */
    static final class b extends p implements d.h.a.a<Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MatrixEventObserver f33686a;

        b(MatrixEventObserver r1) {
            this.f33686a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Uri invoke() {
            return a();
        }

        public final Uri a() {
            return new Uri.Builder().scheme("content").authority(MatrixEventObserver.BROADCAST_PROVIDER_AUTHORITY).path(MatrixEventObserver.access$getMyPath$p(this.f33686a)).build();
        }
    }

    static {
        Companion = new a(null);
    }

    public abstract void handleContentChange(Uri r1);

    public /* synthetic */ MatrixEventObserver(String r1, boolean r2, Handler r3, int r4, h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ String access$getMyPath$p(MatrixEventObserver r0) {
        return r0.myPath;
    }

    public MatrixEventObserver(String r2, boolean r3, Handler r4) {
        o.e(r2, "myPath");
        super(r4);
        this.myPath = r2;
        this.notifyForDescendants = r3;
        this.myUri$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final Uri getMyUri() {
        Object r2 = this.myUri$delegate.b();
        o.c(r2, "<get-myUri>(...)");
        return (Uri) ZeusTransformUtils.preCheckCast(r2, Uri.class, "com.obric.aiagent.plugin");
    }

    public final synchronized void register(Context r7) {
        monitor-enter(this);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        o.e(r8, "context");     // Catch: Throwable -> L13
        if (this.registered == true) goto L10;
        ContentResolver r9 = r8.getContentResolver();     // Catch: Throwable -> L13
        if (r9 == null) goto L9;
        ZeusProviderTransform.registerContentObserver(r9, getMyUri(), this.notifyForDescendants, (ContentObserver) ZeusTransformUtils.preCheckCast(this, ContentObserver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "register, " + getMyUri(), null, 4, null);     // Catch: Throwable -> L13
        this.registered = true;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("contentResolver not found");     // Catch: Throwable -> L13
    L10:
        com.obric.matrix.platform.sdk.ones.internal.b.b.d(TAG, "register, already registered", null, 4, null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void unregister(Context r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        o.e(r6, "context");     // Catch: Throwable -> L13
        if (this.registered == false) goto L10;
        ContentResolver r7 = r6.getContentResolver();     // Catch: Throwable -> L13
        if (r7 == null) goto L9;
        ZeusProviderTransform.unregisterContentObserver(r7, (ContentObserver) ZeusTransformUtils.preCheckCast(this, ContentObserver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "unregister, " + getMyUri(), null, 4, null);     // Catch: Throwable -> L13
        this.registered = false;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("contentResolver not found");     // Catch: Throwable -> L13
    L10:
        com.obric.matrix.platform.sdk.ones.internal.b.b.d(TAG, "unregister, not registered", null, 4, null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r6, Uri r7) {
        super.onChange(r6, r7);
        if (r7 != null) goto L5;
    L13:
        com.obric.matrix.platform.sdk.ones.internal.b.b.d(TAG, "onChange, ignore! uri: [" + r7 + "], registered: [" + this.registered + ']', null, 4, null);
        return;
    L5:
        if (this.registered == false) goto L13;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "onChange, uri: [" + r7 + ']', null, 4, null);
        handleContentChange(r7);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "onChange, error! myUri: " + getMyUri() + ", uri Changed: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
