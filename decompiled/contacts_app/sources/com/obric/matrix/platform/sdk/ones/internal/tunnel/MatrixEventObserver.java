package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixEventObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH&J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixEventObserver;", "Landroid/database/ContentObserver;", "myPath", "", "notifyForDescendants", "", "handler", "Landroid/os/Handler;", "(Ljava/lang/String;ZLandroid/os/Handler;)V", "myUri", "Landroid/net/Uri;", "getMyUri", "()Landroid/net/Uri;", "myUri$delegate", "Lkotlin/Lazy;", "registered", "handleContentChange", "", "uri", "onChange", "selfChange", "register", "context", "Landroid/content/Context;", "unregister", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MatrixEventObserver extends ContentObserver {
    private static final String BROADCAST_PROVIDER_AUTHORITY = "com.obric.matrix.outward_event_provider";
    public static final Companion Companion = null;
    private static final String TAG = "MatrixEventObserver";
    private final String myPath;
    private final Lazy myUri$delegate;
    private final boolean notifyForDescendants;
    private volatile boolean registered;

    /* JADX INFO: compiled from: MatrixEventObserver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixEventObserver$Companion;", "", "()V", "BROADCAST_PROVIDER_AUTHORITY", "", "TAG", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract void handleContentChange(Uri r1);

    public /* synthetic */ MatrixEventObserver(String r1, boolean r2, Handler r3, int r4, DefaultConstructorMarker r5) {
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
        Intrinsics.checkNotNullParameter(r2, "myPath");
        super(r4);
        this.myPath = r2;
        this.notifyForDescendants = r3;
        this.myUri$delegate = LazyKt.lazy(new MatrixEventObserver$myUri$2(this));
    }

    private final Uri getMyUri() {
        Object r1 = this.myUri$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-myUri>(...)");
        return (Uri) r1;
    }

    public final synchronized void register(Context r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "context");     // Catch: Throwable -> L14
        if (this.registered == true) goto L11;
        ContentResolver r8 = r7.getContentResolver();     // Catch: Throwable -> L14
        if (r8 == null) goto L10;
        r8.registerContentObserver(getMyUri(), this.notifyForDescendants, this);     // Catch: Throwable -> L14
        MLog.d$default(TAG, "register, " + getMyUri(), null, 4, null);     // Catch: Throwable -> L14
        this.registered = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        throw new IllegalStateException("contentResolver not found");     // Catch: Throwable -> L14
    L11:
        MLog.w$default(TAG, "register, already registered", null, 4, null);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void unregister(Context r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L14
        if (this.registered == false) goto L11;
        ContentResolver r6 = r5.getContentResolver();     // Catch: Throwable -> L14
        if (r6 == null) goto L10;
        r6.unregisterContentObserver(this);     // Catch: Throwable -> L14
        MLog.d$default(TAG, "unregister, " + getMyUri(), null, 4, null);     // Catch: Throwable -> L14
        this.registered = false;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        throw new IllegalStateException("contentResolver not found");     // Catch: Throwable -> L14
    L11:
        MLog.w$default(TAG, "unregister, not registered", null, 4, null);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r6, Uri r7) {
        super.onChange(r6, r7);
        if (r7 != null) goto L5;
    L13:
        MLog.w$default(TAG, "onChange, ignore! uri: [" + r7 + "], registered: [" + this.registered + DefaultContactListAdapter.SNIPPET_END_MATCH, null, 4, null);
        return;
    L5:
        if (this.registered == false) goto L13;
        MLog.d$default(TAG, "onChange, uri: [" + r7 + DefaultContactListAdapter.SNIPPET_END_MATCH, null, 4, null);
        handleContentChange(r7);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        MLog.e(TAG, "onChange, error! myUri: " + getMyUri() + ", uri Changed: " + r7, e);
    }
}
