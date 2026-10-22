package com.bytedance.android.livesdk.livecommerce.room;

import android.app.Application;
import android.util.LruCache;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Pair<String, String>, Object> f151382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2332a f151383b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.a$a, reason: collision with other inner class name */
    public static final class C2332a extends LruCache<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f151384a;

        public C2332a(a r100, int r101) {
            this.f151384a = r100;
            super(r101);
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r100, String r101, Object r102, Object r103) {
            final String r104 = r101;
            super.entryRemoved(r100, r104, r102, r103);
            ConcurrentHashMap<Pair<String, String>, Object> r105 = this.f151384a.f151382a;
            Function1<Map.Entry<? extends Pair<? extends String, ? extends String>, ? extends Object>, Boolean> r106 = new ControllerCache$roomIdCache$1$entryRemoved$1(r104);
            CollectionsKt.removeAll(r105.entrySet(), r106);
            if (r102 == null) goto L6;
            Lazy r107 = LiveRoomProvider.f151373a;
            LiveRoomProvider.b(r102);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final void clear() {
        this.f151383b.evictAll();
        this.f151382a.clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final Map<String, Object> snapshot() {
        return this.f151383b.snapshot();
    }

    public a() {
        this.f151382a = new ConcurrentHashMap();
        Lazy r100 = LiveRoomProvider.f151373a;
        this.f151383b = new C2332a(this, ((Number) LiveRoomProvider.f151373a.getValue()).intValue());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final Object getController(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        Iterator<T> r103 = this.f151382a.entrySet().iterator();
    L10:
        Object r104 = null;
        if (r103.hasNext() == false) goto L20;
        Object r105 = r103.next();
        Map.Entry r106 = (Map.Entry) r105;
        if (Intrinsics.areEqual((String) ((Pair) r106.getKey()).getFirst(), r100) == true) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r107 == false) goto L10;
    L21:
        Map.Entry r108 = (Map.Entry) r105;
        if (r108 == null) goto L24;
        r104 = r108.getValue();
    L24:
        if (r104 == null) goto L26;
    L31:
        return r104;
    L26:
        if (this.f151383b.get(r100) == null) goto L31;
        Application.ActivityLifecycleCallbacks r109 = ControllerCenter.f151390a;
        if (ControllerCenter.f151391b.size() > 1) goto L31;
        return this.f151383b.get(r100);
    L15:
        if (Intrinsics.areEqual((String) ((Pair) r106.getKey()).getSecond(), r101) == false) goto L17;
        r107 = true;
        goto L18
    L20:
        r105 = null;
        goto L21
    L8:
        return this.f151383b.get(r100);
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final void a(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "controller");
        this.f151383b.put(r100, r102);
        this.f151382a.put(new Pair(r100, r101), r102);
    }
}
