package com.bytedance.android.androidadbbindings;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017JQ\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/androidadbbindings/AdbBindingsServerContentProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "android-bindings_release"}, k = 1, mv = {1, 4, 0})
public abstract class AdbBindingsServerContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f38382a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdbBindingsServerContentProvider f38383a;

        /* JADX INFO: renamed from: com.bytedance.android.androidadbbindings.AdbBindingsServerContentProvider$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes43.dex */
        public static final class RunnableC0722a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LocalSocket f38384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f38385b;

            public RunnableC0722a(LocalSocket r100, b r101) {
                this.f38384a = r100;
                this.f38385b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f38385b.a(new com.bytedance.android.androidadbbindings.a(this.f38384a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(AdbBindingsServerContentProvider r100) {
            this.f38383a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            xl3.b r100 = this.f38383a.a();     // Catch: Throwable -> L8
            LocalServerSocket r101 = (LocalServerSocket) this.f38383a.f38382a.getValue();     // Catch: Throwable -> L8
            if (r101 != null) goto L5;
            return;
        L5:
            if (Thread.interrupted() == true) goto L18;
            ThreadMethodProxy.start(new PthreadThreadV2(new RunnableC0722a(r101.accept(), r100), "AdbBindingsServerContentProvider$onCreate$1"));     // Catch: Throwable -> L8
            goto L5
        L18:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public abstract xl3.b a();

    public abstract void b();

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "AdbBindingsServerContentProvider"));
        return true;
    }

    public AdbBindingsServerContentProvider() {
        this.f38382a = LazyKt.lazy(new AdbBindingsServerContentProvider$localServerSocket$2(this));
    }
}
