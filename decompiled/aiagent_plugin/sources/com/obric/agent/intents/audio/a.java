package com.obric.agent.intents.audio;

import android.app.Application;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Handler;
import android.os.Looper;
import com.obric.aiagent.executionengine.utils.d;
import com.obric.aiagent.executionengine.utils.pkms.PackageInfoCache;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AudioControlManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14676a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f14677b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<MediaController> f14678c;

    /* JADX INFO: renamed from: com.obric.agent.intents.audio.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class C0292a<T> implements Comparator {
        public C0292a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            PlaybackState r3 = ((MediaController) ZeusTransformUtils.preCheckCast(r5, MediaController.class, "com.obric.aiagent.plugin")).getPlaybackState();
            Long r6 = null;
            if (r3 == null) goto L5;
            Long r7 = Long.valueOf(r3.getLastPositionUpdateTime());
        L6:
            Comparable r8 = (Comparable) ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.aiagent.plugin");
            PlaybackState r9 = ((MediaController) ZeusTransformUtils.preCheckCast(r4, MediaController.class, "com.obric.aiagent.plugin")).getPlaybackState();
            if (r9 == null) goto L10;
            r6 = Long.valueOf(r9.getLastPositionUpdateTime());
        L10:
            return d.b.a.a(r8, (Comparable) ZeusTransformUtils.preCheckCast(r6, Comparable.class, "com.obric.aiagent.plugin"));
        L5:
            r7 = null;
            goto L6
        }
    }

    public static /* synthetic */ void lambda$MhLwCvNWGZXmFqEApCgfty9DDjY(List r0) {
        b(r0);
    }

    public static /* synthetic */ CharSequence lambda$V0j3pNglHB9ek5wilDcYUwyMlas(PackageInfoCache.a r0) {
        return a(r0);
    }

    public static /* synthetic */ MediaSessionManager lambda$mVJHCGwlbKKORixeqAdODWWSzZE() {
        return h();
    }

    private a() {
    }

    static {
        a r0 = new a();
        f14676a = r0;
        f14677b = g.a($$Lambda$a$mVJHCGwlbKKORixeqAdODWWSzZE.INSTANCE);
        Object r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        Object r3 = n.f(r0.g().getActiveSessions(null));     // Catch: Throwable -> L5
    L8:
        if (n.b(r3) == true) goto L11;
        r1 = r3;
    L11:
        List<MediaController> r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L14;
        r4 = p.b();
    L14:
        f14678c = r4;
        return;
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r3 = n.f(o.a(th));
        goto L8
    }

    private final MediaSessionManager g() {
        return (MediaSessionManager) ZeusTransformUtils.preCheckCast(f14677b.b(), MediaSessionManager.class, "com.obric.aiagent.plugin");
    }

    private static final MediaSessionManager h() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("media_session");
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
        MediaSessionManager r1 = (MediaSessionManager) ZeusTransformUtils.preCheckCast(r0, MediaSessionManager.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        r1.addOnActiveSessionsChangedListener($$Lambda$a$MhLwCvNWGZXmFqEApCgfty9DDjY.INSTANCE, null, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L5
        n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        return r1;
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        n.f(o.a(th));
        goto L7
    }

    private static final void b(List r2) {
        List<MediaController> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        r3 = p.b();
    L5:
        f14678c = r3;
    }

    public final List<MediaController> a() {
        return f14678c;
    }

    public final List<MediaController> b() {
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(f14678c, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        Object r2 = r8.next();
        PlaybackState r3 = ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getPlaybackState();
        boolean r4 = false;
        if (r3 != null) goto L9;
    L13:
        if (r4 == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        if (r3.getState() != 3) goto L13;
        if (r3.getPlaybackSpeed() <= 0.0f) goto L13;
        r4 = true;
        goto L13
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public final List<MediaController> c() {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(f14678c, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        Object r2 = r7.next();
        PlaybackState r3 = ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getPlaybackState();
        boolean r4 = false;
        if (r3 != null) goto L8;
    L10:
        if (r4 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        if (r3.getState() != 2) goto L10;
        r4 = true;
        goto L10
    L13:
        return p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0292a(), Comparator.class, "com.obric.aiagent.plugin"));
    }

    public final MediaController d() {
        return (MediaController) ZeusTransformUtils.preCheckCast(p.l(b()), MediaController.class, "com.obric.aiagent.plugin");
    }

    public final MediaController e() {
        return (MediaController) ZeusTransformUtils.preCheckCast(p.l(c()), MediaController.class, "com.obric.aiagent.plugin");
    }

    public final MediaController f() {
        MediaController r0 = d();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return e();
    }

    public final String a(List<MediaController> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        MediaController r1 = (MediaController) ZeusTransformUtils.preCheckCast(r14.next(), MediaController.class, "com.obric.aiagent.plugin");
        d r2 = d.f18567a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r4 = r1.getPackageName();
        d.h.b.o.c(r4, "getPackageName(...)");
        PackageInfoCache.a r5 = r2.a(r3, r4);
        if (r5 == null) goto L4;
        r13.add(r5);
        goto L4
    L9:
        return p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$a$V0j3pNglHB9ek5wilDcYUwyMlas.INSTANCE, 30, null);
    }

    private static final CharSequence a(PackageInfoCache.a r2) {
        d.h.b.o.e(r2, "it");
        CharSequence r3 = r2.b();
        if (r3 == null) goto L5;
        return r3;
    L5:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    }
}
