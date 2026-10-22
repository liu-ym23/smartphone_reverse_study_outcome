package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: OUISoundEffectHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private static final String TAG = "OUISoundEffectHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f34529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SoundPool f34530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Integer> f34531c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<Integer> f34532d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f34533e = null;

    public static /* synthetic */ void lambda$aecc7V9LING0DqnVrweER8CewMo(SoundPool r0, int r1, int r2) {
        a(r0, r1, r2);
    }

    private h() {
    }

    static {
        f34529a = new h();
        f34531c = new ConcurrentHashMap();
        f34532d = Collections.newSetFromMap((Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.aiagent.plugin"));
        f34533e = new Object();
    }

    private final void a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f34530b != null) goto L18;
        Object r4 = f34533e;
        monitor-enter(r4);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f34530b != null) goto L12;
        com.obric.oui.d.a.b.b(TAG, "init soundPool");     // Catch: Throwable -> L15
        AudioAttributes r5 = new AudioAttributes.Builder().setUsage(13).setContentType(4).build();     // Catch: Throwable -> L15
        SoundPool r6 = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(r5).build();     // Catch: Throwable -> L15
        f34530b = r6;     // Catch: Throwable -> L15
        if (r6 == null) goto L12;
        r6.setOnLoadCompleteListener($$Lambda$h$aecc7V9LING0DqnVrweER8CewMo.INSTANCE);     // Catch: Throwable -> L15
    L12:
        x r7 = x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(r4);
        return;
    }

    private static final void a(SoundPool r5, int r6, int r7) {
        if (r7 != 0) goto L23;
        Set<Map.Entry<Integer, Integer>> r8 = f34531c.entrySet();
        o.c(r8, "soundIdMap.entries");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L5:
        Integer r2 = null;
        if (r9.hasNext() == false) goto L16;
        Object r0 = r9.next();
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Integer.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L5;
    L17:
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L21;
        r2 = (Integer) ZeusTransformUtils.preCheckCast(r10.getKey(), Integer.class, "com.obric.aiagent.plugin");
    L21:
        if (r2 == null) goto L30;
        f34532d.add(r2);
        com.obric.oui.d.a.b.b(TAG, o.a("loaded: resId=", r2));
        return;
    L30:
        return;
    L11:
        if (r3.intValue() != r6) goto L13;
        r4 = true;
        goto L14
    L16:
        r0 = null;
        goto L17
    L23:
        com.obric.oui.d.a.b.e(TAG, "load failed, sampleId=" + r6 + ", status=" + r7);
    }

    public final void a(Context r13, int... r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        o.e(r14, "soundResIds");
        a(r15);     // Catch: Exception -> L14
        int r12 = 0;
        int r1 = r14.length;     // Catch: Exception -> L14
    L4:
        if (r12 >= r1) goto L23;
        int r3 = r14[r12];     // Catch: Exception -> L14
        ConcurrentHashMap<Integer, Integer> r4 = f34531c;     // Catch: Exception -> L14
        if (r4.containsKey(Integer.valueOf(r3)) == true) goto L13;
        SoundPool r5 = f34530b;     // Catch: Exception -> L14
        if (r5 != null) goto L10;
        Integer r6 = null;
    L11:
        if (r6 == null) goto L13;
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(Integer.valueOf(r3), r6);     // Catch: Exception -> L14
        com.obric.oui.d.a.b.b(TAG, "start load, resId=" + r3 + ", 分配的 soundId=" + r6);     // Catch: Exception -> L14
        goto L13
    L10:
        r6 = Integer.valueOf(r5.load((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, 1));     // Catch: Exception -> L14
    L13:
        r12 = r12 + 1;
        goto L4
    L23:
        return;
    L14:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, o.a("load failed, resIds=", d.a.i.a(r14, (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null)), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void a(Context r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L7;
        com.obric.oui.d.a.b.d(TAG, "can't play, context is null");
        return;
    L7:
        if (b(r12) != 0) goto L27;
        return;
    L27:
        a(r12);     // Catch: Exception -> L23
        if (f34532d.contains(Integer.valueOf(r11)) == false) goto L12;
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(f34531c.get(Integer.valueOf(r11)), Integer.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
        if (r9 == null) goto L26;
        SoundPool r2 = f34530b;     // Catch: Exception -> L23
        if (r2 == null) goto L26;
        r2.play(r9.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);     // Catch: Exception -> L23
    L26:
        return;
    L12:
        if (f34531c.containsKey(Integer.valueOf(r11)) == true) goto L14;
        com.obric.oui.d.a.b.d(TAG, o.a("not loaded, start now: resId=", Integer.valueOf(r11)));     // Catch: Exception -> L23
        a(r12, new int[]{r11});     // Catch: Exception -> L23
        goto L26
    L14:
        com.obric.oui.d.a.b.b(TAG, o.a("loading: resId=", Integer.valueOf(r11)));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, o.a("play failed, resId=", Integer.valueOf(r11)), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void a() {
        com.obric.oui.d.a.b.b(TAG, "release");     // Catch: Exception -> L9
        SoundPool r0 = f34530b;     // Catch: Exception -> L9
        if (r0 == null) goto L7;
        r0.release();     // Catch: Exception -> L9
    L7:
        f34530b = null;     // Catch: Exception -> L9
        f34531c.clear();     // Catch: Exception -> L9
        f34532d.clear();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.obric.oui.d.a.b.d(TAG, o.a("release Exception: ", e));
    }

    private final int b(Context r3) {
        return Settings.System.getInt(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), "sound_effects_enabled", 0);
    L5:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "get sound effect enabled failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return 0;
    }
}
