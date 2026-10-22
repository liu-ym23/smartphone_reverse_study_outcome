package com.obric.autogui.agents.scripted.impl;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ScriptDecryptorPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    private static final String TAG = "Script-DecryptorPool";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f27033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f27034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f27035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScheduledExecutorService f27036e;

    /* JADX INFO: compiled from: ScriptDecryptorPool.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptDecryptorPool.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m f27038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f27039c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27037a, r6.f27037a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27038b, r6.f27038b) == true) goto L15;
            return false;
        L15:
            if (this.f27039c == r6.f27039c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f27037a.hashCode() * 31) + this.f27038b.hashCode()) * 31) + Integer.hashCode(this.f27039c);
        }

        public String toString() {
            return "Entry(rootPath=" + this.f27037a + ", decryptor=" + this.f27038b + ", generation=" + this.f27039c + ')';
        }

        public b(String r2, m r3, int r4) {
            d.h.b.o.e(r2, "rootPath");
            d.h.b.o.e(r3, "decryptor");
            this.f27037a = r2;
            this.f27038b = r3;
            this.f27039c = r4;
        }

        public final String a() {
            return this.f27037a;
        }

        public final m b() {
            return this.f27038b;
        }

        public final int c() {
            return this.f27039c;
        }
    }

    static {
        f27032a = new a(null);
    }

    public static /* synthetic */ void lambda$kTZER1N22RbfCQLQWfKWPSmlL1g(o r0) {
        a(r0);
    }

    public o() {
        this.f27033b = new ConcurrentHashMap();
        this.f27034c = new AtomicInteger(0);
        this.f27035d = new AtomicBoolean(false);
        this.f27036e = Executors.newSingleThreadScheduledExecutor();
    }

    public final void a() {
        if (this.f27035d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f27036e.scheduleAtFixedRate(new $$Lambda$o$kTZER1N22RbfCQLQWfKWPSmlL1g(this), 5, 5, TimeUnit.MINUTES);
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L9;
        Loog.INSTANCE.d(TAG, "Periodic decryptor cache clear scheduled every 5 minutes");
        return;
    }

    public final m a(String r6, File r7) {
        d.h.b.o.e(r6, "packageName");
        d.h.b.o.e(r7, "rootDir");
        String r0 = r7.getAbsolutePath();
        int r1 = this.f27034c.get();
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f27033b.get(r6), b.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L10:
        m r8 = m.f27019a.a(r7);
        if (r8 != null) goto L14;
        this.f27033b.remove(r6);
        return null;
    L14:
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(this.f27033b, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0);
        r5.put(r6, new b(r0, r8, r1));
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L17;
        Loog.INSTANCE.d(TAG, "Loaded decryptor into cache: pkg=" + r6 + ", generation=" + r1);
    L17:
        return r8;
    L5:
        if (r2.c() != r1) goto L10;
        if (d.h.b.o.a(r2.a(), r0) == false) goto L10;
        return r2.b();
    }

    public final void b() {
        int r0 = this.f27034c.incrementAndGet();
        this.f27033b.clear();
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L6;
        Loog.INSTANCE.d(TAG, "Cleared decryptor cache, bumped generation to " + r0);
        return;
    }

    private static final void a(o r3) {
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "Periodic decryptor cache clear");
    L5:
        r3.b();
    }
}
