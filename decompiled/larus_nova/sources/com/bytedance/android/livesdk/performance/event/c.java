package com.bytedance.android.livesdk.performance.event;

import com.bytedance.android.livesdk.s1;
import com.bytedance.android.livesdkapi.model.LivePerfEventKitConfig;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.global.open.StrictModeTag;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f154591a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<EventType<?>, CopyOnWriteArraySet<b>> f154592b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LivePerfEventKitConfig f154593c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f154594d = null;

    public c() {
    }

    static {
        f154591a = LocalTestManager.b(new Class[]{StrictModeTag.class});
        f154592b = new ConcurrentHashMap();
        f154593c = s1.f157855a.getValue();
        f154594d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    public static void a(Object r100) {
        EventType.c r101 = EventType.c.f154580e;
        Intrinsics.checkNotNullParameter(r101, "event");
        if (f154593c.getEnable() == false) goto L7;
        MainCoroutineDispatcher r102 = Dispatchers.getMain();
        BuildersKt.launch$default(f154594d, r102, null, new PerformanceEventKit$postTrigger$1(r101, r100, null), 2, null);
        return;
    }

    public static void b(b r100, EventType... r101) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        Intrinsics.checkNotNullParameter(r101, "events");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        EventType r104 = r101[r103];
        ConcurrentHashMap<EventType<?>, CopyOnWriteArraySet<b>> r105 = f154592b;
        CopyOnWriteArraySet<b> r106 = r105.get(r104);
        if (r106 != null) goto L10;
        r106 = new CopyOnWriteArraySet();
        CopyOnWriteArraySet<b> r107 = r105.putIfAbsent((EventType<?>) r104, r106);
        if (r107 == null) goto L10;
        r106 = r107;
    L10:
        r106.add(r100);
        r103 = r103 + 1;
        goto L3
    }

    public static void c(EventType r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (f154593c.getEnable() == true) goto L6;
        return;
    L6:
        if (f154591a == false) goto L8;
        String r102 = r100.f154577a;
        Objects.toString(r101);
    L8:
        CopyOnWriteArraySet<b> r103 = f154592b.get(r100);
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        a.f154590a.a(r100, r101);
        return;
    L18:
        Iterator<b> r105 = r103.iterator();
    L20:
        if (r105.hasNext() == false) goto L25;
        b r106 = r105.next();
        r106.a(r100, r101);     // Catch: Exception -> L24
    L24:
        r106.getClass();
        goto L20
    L25:
        a.f154590a.a(r100, r101);
        return;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
        goto L15
    }

    public static void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (f154593c.getEnable() == true) goto L5;
        return;
    L5:
        EventType.f154576d.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        EventType r102 = (EventType) ((Map) EventType.f154575c.getValue()).get(r100);
        if (r102 == null) goto L8;
        c(r102, r101);
        return;
    }

    public static void e(b r100, EventType... r101) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        Intrinsics.checkNotNullParameter(r101, "events");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        EventType r104 = r101[r103];
        ConcurrentHashMap<EventType<?>, CopyOnWriteArraySet<b>> r105 = f154592b;
        CopyOnWriteArraySet<b> r106 = r105.get(r104);
        if (r106 == null) goto L7;
        r106.remove(r100);
    L7:
        CopyOnWriteArraySet<b> r107 = r105.get(r104);
        if (r107 == null) goto L12;
        if (r107.isEmpty() != true) goto L12;
        r105.remove(r104);
    L12:
        r103 = r103 + 1;
        goto L3
    }
}
