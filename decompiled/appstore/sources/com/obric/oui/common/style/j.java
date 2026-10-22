package com.obric.oui.common.style;

import android.media.SoundPool;
import com.obric.oui.utils.log.L;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SoundPool f13078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f13079c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f13080d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f13081e = null;

    static {
        f13077a = new j();
        f13079c = new ConcurrentHashMap();
        f13080d = Collections.newSetFromMap(new ConcurrentHashMap());
        f13081e = new Object();
    }

    public j() {
    }

    public final void a() {
        L.a("OUISoundEffectHelper", "release");     // Catch: Exception -> L9
        SoundPool r10 = f13078b;     // Catch: Exception -> L9
        if (r10 == null) goto L7;
        r10.release();     // Catch: Exception -> L9
    L7:
        f13078b = null;     // Catch: Exception -> L9
        f13079c.clear();     // Catch: Exception -> L9
        f13080d.clear();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        L.j("OUISoundEffectHelper", q.p("release Exception: ", e));
    }
}
