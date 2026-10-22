package com.obric.matrix.platform.sdk.ones.settings;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class MatrixSettingsManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f11938g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static MatrixSettingsManager f11939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f11940i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f11941j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.matrix.platform.sdk.ones.settings.a f11943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f11945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Gson f11946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReentrantLock f11947f;

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$ConfigDataWrapper;", "", "config_data", "(Ljava/lang/Object;)V", "getConfig_data", "()Ljava/lang/Object;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ConfigDataWrapper {

        @Nullable
        private final Object config_data;

        public ConfigDataWrapper() {
            DefaultConstructorMarker r10 = null;
            this(r10, 1, r10);
        }

        public static /* synthetic */ ConfigDataWrapper copy$default(ConfigDataWrapper r10, Object r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r11 = r10.config_data;
        L6:
            return r10.copy(r11);
        }

        @Nullable
        public final Object component1() {
            return this.config_data;
        }

        @NotNull
        public final ConfigDataWrapper copy(@Nullable Object r10) {
            return new ConfigDataWrapper(r10);
        }

        public boolean equals(@Nullable Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ConfigDataWrapper) == true) goto L9;
            return false;
        L9:
            if (q.b(this.config_data, ((ConfigDataWrapper) r10).config_data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        @Nullable
        public final Object getConfig_data() {
            return this.config_data;
        }

        public int hashCode() {
            Object r10 = this.config_data;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.hashCode();
        }

        @NotNull
        public String toString() {
            return "ConfigDataWrapper(config_data=" + this.config_data + ')';
        }

        public ConfigDataWrapper(@Nullable Object r10) {
            this.config_data = r10;
        }

        public /* synthetic */ ConfigDataWrapper(Object r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = null;
        L5:
            this(r10);
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final MatrixSettingsManager a() {
            if (MatrixSettingsManager.a() == null) goto L7;
            MatrixSettingsManager r10 = MatrixSettingsManager.a();
            q.d(r10);
            return r10;
        L7:
            throw new IllegalStateException("MatrixSettingsManager还没初始化，请先调用init方法进行初始化~~~");
        }

        public final void b(Context r10, com.obric.matrix.platform.sdk.ones.settings.a r11) {
            q.g(r10, "context");
            q.g(r11, "config");
            if (MatrixSettingsManager.e().get() == false) goto L6;
            bc.a.c("MatrixSettingsManager", "is inited");
            return;
        L6:
            Object r12 = MatrixSettingsManager.b();
            monitor-enter(r12);
        L11:
            th = move-exception;
            throw th;
        L9:
            if (MatrixSettingsManager.a() != null) goto L13;
            MatrixSettingsManager.f(new MatrixSettingsManager(r10, r11, null));     // Catch: Throwable -> L11
        L13:
            Unit r13 = Unit.f21064a;     // Catch: Throwable -> L11
            monitor-exit(r12);
            MatrixSettingsManager r14 = MatrixSettingsManager.a();
            q.d(r14);
            r14.j();
            MatrixSettingsManager r15 = MatrixSettingsManager.a();
            q.d(r15);
            r15.k();
            MatrixSettingsManager.e().set(true);
        }

        public final boolean c() {
            return MatrixSettingsManager.e().get();
        }

        public a() {
        }
    }

    public static final class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixSettingsManager f11948a;

        public b(MatrixSettingsManager r10, Handler r11) {
            this.f11948a = r10;
            super(r11);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10, Uri r11) {
            super.onChange(r10, r11);
            bc.a.c("MatrixSettingsManager", "Settings provider updated, refreshing...");
            this.f11948a.j();
            String r12 = MatrixSettingsManager.d(this.f11948a);
            if (r12 != null) goto L5;
            r12 = null;
        L5:
            bc.a.c("MatrixSettingsManager", "settings刷新了，通知所有listener " + r12);
            Iterator r13 = MatrixSettingsManager.c(this.f11948a).iterator();
        L7:
            if (r13.hasNext() == false) goto L9;
            ((SettingsUpdateListener) r13.next()).onSettingsUpdate(r12);
            goto L7
        }
    }

    static {
        f11938g = new a(null);
        f11940i = new Object();
        f11941j = new AtomicBoolean(false);
    }

    public /* synthetic */ MatrixSettingsManager(Context r10, com.obric.matrix.platform.sdk.ones.settings.a r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final /* synthetic */ MatrixSettingsManager a() {
        return f11939h;
    }

    public static final /* synthetic */ Object b() {
        return f11940i;
    }

    public static final /* synthetic */ CopyOnWriteArrayList c(MatrixSettingsManager r10) {
        return r10.f11945d;
    }

    public static final /* synthetic */ String d(MatrixSettingsManager r10) {
        return r10.f11944c;
    }

    public static final /* synthetic */ AtomicBoolean e() {
        return f11941j;
    }

    public static final /* synthetic */ void f(MatrixSettingsManager r10) {
        f11939h = r10;
    }

    public final void g(SettingsUpdateListener r10) {
        q.g(r10, "listener");
        bc.a.c("MatrixSettingsManager", "addSettingsUpdateListener " + r10);
        if (this.f11945d.contains(r10) == true) goto L5;
        this.f11945d.add(r10);
    L5:
        ReentrantLock r11 = this.f11947f;
        r11.lock();
        String r12 = this.f11944c;     // Catch: Throwable -> L10
        if (r12 == null) goto L12;
        bc.a.c("MatrixSettingsManager", "注册settingsUpdateListener时settingsObject有值，立即回调 " + r12);     // Catch: Throwable -> L10
        r10.onSettingsUpdate(r12);     // Catch: Throwable -> L10
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L10
    L12:
        r11.unlock();
        return;
    L10:
        th = move-exception;
        r11.unlock();
        throw th;
    }

    public final String h() {
        ReentrantLock r10 = this.f11947f;
        r10.lock();
        String r11 = this.f11944c;     // Catch: Throwable -> L8
        if (r11 != null) goto L10;
        String r12 = j();     // Catch: Throwable -> L8
        r10.unlock();
        return r12;
    L10:
        r10.unlock();
        return r11;
    L8:
        th = move-exception;
        r10.unlock();
        throw th;
    }

    public final Gson i() {
        return this.f11946e;
    }

    public final String j() {
        ReentrantLock r10 = this.f11947f;
        r10.lock();
        Object r11 = null;
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L15
        Uri r13 = Uri.parse("content://com.obric.matrix.systemapp.settings.provider/get_app_settings");     // Catch: Throwable -> L15
        Bundle r14 = new Bundle();     // Catch: Throwable -> L15
        r14.putString("packageName", this.f11943b.a());     // Catch: Throwable -> L15
        r14.putString("receiverName", this.f11943b.b());     // Catch: Throwable -> L15
        Cursor r15 = this.f11942a.getContentResolver().query(r13, null, r14, null);     // Catch: Throwable -> L15
        if (r15 != null) goto L42;
    L21:
        bc.a.b("MatrixSettingsManager", "getAllSettings cursor is null");     // Catch: Throwable -> L15
        this.f11944c = null;     // Catch: Throwable -> L15
        String r16 = null;
    L22:
        Object r17 = Result.m35constructorimpl(r16);     // Catch: Throwable -> L15
    L25:
        Throwable r18 = Result.m38exceptionOrNullimpl(r17);     // Catch: Throwable -> L28
        if (r18 == null) goto L31;
        bc.a.f5978a.e("MatrixSettingsManager", "getAllSettings error", r18);     // Catch: Throwable -> L28
        this.f11944c = null;     // Catch: Throwable -> L28
    L31:
        if (Result.m41isFailureimpl(r17) == true) goto L34;
        r11 = r17;
    L34:
        String r19 = (String) r11;     // Catch: Throwable -> L28
        r10.unlock();
        return r19;
    L42:
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        kotlin.io.b.a(r15, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L6:
        if (r15.moveToFirst() == false) goto L10;
        r16 = this.f11946e.toJson(((ConfigDataWrapper) this.f11946e.fromJson(r15.getString(r15.getColumnIndexOrThrow("all_config_str")), ConfigDataWrapper.class)).getConfig_data());     // Catch: Throwable -> L8
        this.f11944c = r16;     // Catch: Throwable -> L8
    L12:
        kotlin.io.b.a(r15, null);     // Catch: Throwable -> L15
        if (r16 != null) goto L22;
    L10:
        bc.a.b("MatrixSettingsManager", "getAllSettings cursor is empty");     // Catch: Throwable -> L8
        this.f11944c = null;     // Catch: Throwable -> L8
        r16 = null;
    L28:
        th = move-exception;
        r10.unlock();
        throw th;
    L15:
        th = move-exception;
        Result.a r20 = Result.Companion;     // Catch: Throwable -> L28
        r17 = Result.m35constructorimpl(c.a(th));     // Catch: Throwable -> L28
        goto L25
    }

    public final void k() {
        bc.a.c("MatrixSettingsManager", "注册observer");
        Uri r10 = Uri.parse("content://com.obric.matrix.systemapp.settings.provider/get_app_settings");
        b r11 = new b(this, new Handler(Looper.getMainLooper()));
        this.f11942a.getContentResolver().registerContentObserver(r10, true, r11);
    }

    public MatrixSettingsManager(Context r10, com.obric.matrix.platform.sdk.ones.settings.a r11) {
        this.f11942a = r10;
        this.f11943b = r11;
        this.f11945d = new CopyOnWriteArrayList();
        this.f11946e = new Gson();
        this.f11947f = new ReentrantLock();
    }
}
