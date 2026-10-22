package com.obric.matrix.platform.sdk.ones.settings;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f.c;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.io.Closeable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: MatrixSettingsManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MatrixSettingsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33737a = null;
    private static final Object h = null;
    private static final AtomicBoolean i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f33738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.matrix.platform.sdk.ones.settings.a f33739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f33740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f33741e;
    private final Gson f;
    private final ReentrantLock g;

    /* JADX INFO: compiled from: MatrixSettingsManager.kt */
    private static final class ConfigDataWrapper {
        private final Object config_data;

        public ConfigDataWrapper() {
            h r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ ConfigDataWrapper copy$default(ConfigDataWrapper r0, Object r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.config_data;
        L6:
            return r0.copy(r1);
        }

        public final Object component1() {
            return this.config_data;
        }

        public final ConfigDataWrapper copy(Object r1) {
            return new ConfigDataWrapper(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ConfigDataWrapper.class) == true) goto L8;
            return false;
        L8:
            ConfigDataWrapper r6 = (ConfigDataWrapper) ZeusTransformUtils.preCheckCast(r5, ConfigDataWrapper.class, "com.obric.aiagent.plugin");
            if (o.a(this.config_data, r6.config_data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Object r0 = this.config_data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "ConfigDataWrapper(config_data=" + this.config_data + ')';
        }

        public ConfigDataWrapper(Object r1) {
            this.config_data = r1;
        }

        public /* synthetic */ ConfigDataWrapper(Object r1, int r2, h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        public final Object getConfig_data() {
            return this.config_data;
        }
    }

    /* JADX INFO: compiled from: MatrixSettingsManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public static final /* synthetic */ String a(MatrixSettingsManager r0) {
        return r0.f33740d;
    }

    public static final /* synthetic */ CopyOnWriteArrayList b(MatrixSettingsManager r0) {
        return r0.f33741e;
    }

    static {
        f33737a = new a(null);
        h = new Object();
        i = new AtomicBoolean(false);
    }

    public final String a() {
        Lock r1 = (Lock) ZeusTransformUtils.preCheckCast(this.g, Lock.class, "com.obric.aiagent.plugin");
        r1.lock();
        Object r2 = null;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L25
        Uri r6 = Uri.parse("content://com.obric.matrix.systemapp.settings.provider/get_app_settings");     // Catch: Throwable -> L25
        Bundle r8 = new Bundle();     // Catch: Throwable -> L25
        r8.putString("packageName", this.f33739c.a());     // Catch: Throwable -> L25
        r8.putString("receiverName", this.f33739c.b());     // Catch: Throwable -> L25
        Cursor r5 = ZeusProviderTransform.query(this.f33738b.getContentResolver(), r6, null, r8, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r5 == null) goto L22;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        Cursor r9 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r9.moveToFirst() == false) goto L13;
        Object r10 = ((ConfigDataWrapper) ZeusTransformUtils.preCheckCast(this.f.fromJson(r9.getString(r9.getColumnIndexOrThrow("all_config_str")), ConfigDataWrapper.class), ConfigDataWrapper.class, "com.obric.aiagent.plugin")).getConfig_data();     // Catch: Throwable -> L17
        if (r10 == null) goto L11;
        String r11 = this.f.toJson(r10);     // Catch: Throwable -> L17
    L12:
        this.f33740d = r11;     // Catch: Throwable -> L17
    L14:
        c.a(r7, null);     // Catch: Throwable -> L25
        if (r11 == null) goto L22;
    L23:
        Object r12 = n.f(r11);     // Catch: Throwable -> L25
    L27:
        Throwable r13 = n.c(r12);     // Catch: Throwable -> L37
        if (r13 == null) goto L31;
        com.obric.matrix.platform.sdk.ones.account.b.a.f33614a.b("MatrixSettingsManager", "getAllSettings error", r13);     // Catch: Throwable -> L37
        this.f33740d = null;     // Catch: Throwable -> L37
    L31:
        if (n.b(r12) == true) goto L34;
        r2 = r12;
    L34:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        r1.unlock();
        return r14;
    L11:
        r11 = null;
        goto L12
    L13:
        com.obric.matrix.platform.sdk.ones.account.b.a.d("MatrixSettingsManager", "getAllSettings cursor is empty");     // Catch: Throwable -> L17
        this.f33740d = null;     // Catch: Throwable -> L17
        r11 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        c.a(r7, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L22:
        MatrixSettingsManager r15 = (MatrixSettingsManager) ZeusTransformUtils.preCheckCast(this, MatrixSettingsManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        com.obric.matrix.platform.sdk.ones.account.b.a.d("MatrixSettingsManager", "getAllSettings cursor is null");     // Catch: Throwable -> L25
        r15.f33740d = null;     // Catch: Throwable -> L25
        r11 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
    L37:
        th = move-exception;
        r1.unlock();
        throw th;
    L25:
        th = move-exception;
        n.a r16 = n.f38560a;     // Catch: Throwable -> L37
        r12 = n.f(d.o.a(th));     // Catch: Throwable -> L37
        goto L27
    }
}
