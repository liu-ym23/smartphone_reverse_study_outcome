package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f131514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.resources.e f131515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f131516c;

    public e(d r100, com.bytedance.android.live.core.resources.e r101, Map r102) {
        this.f131514a = r100;
        this.f131515b = r101;
        this.f131516c = r102;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        HashMap<String, d.a> r101 = this.f131514a.f131491a;
        monitor-enter(r101);
        com.bytedance.android.live.core.resources.b r102 = this.f131515b.getCleanStrategy();     // Catch: Throwable -> L33
        if (r102 != null) goto L7;
    L16:
        boolean r103 = false;
    L17:
        Map r104 = this.f131516c;     // Catch: Throwable -> L33
        if (r104 == null) goto L27;
        Iterator r105 = r104.entrySet().iterator();     // Catch: Throwable -> L33
    L21:
        if (r105.hasNext() == false) goto L27;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L33
        Iterator<Map.Entry<String, d.a>> r107 = this.f131514a.f131491a.entrySet().iterator();     // Catch: Throwable -> L33
    L24:
        if (r107.hasNext() == false) goto L26;
        r107.next().getValue().get(r106.getKey());     // Catch: Throwable -> L33
        goto L24
    L26:
        r103 = true;
    L27:
        this.f131514a.c("onAssetUsed");     // Catch: Throwable -> L33
        if (r103 == false) goto L30;
        d.a(this.f131514a);     // Catch: Throwable -> L33
    L30:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r101);
        return;
    L7:
        if (r102.getCleanType() != 1) goto L16;
        com.bytedance.android.live.core.resources.b r109 = this.f131515b.getCleanStrategy();     // Catch: Throwable -> L33
        if (r109 == null) goto L11;
        String r110 = r109.getAssetType();     // Catch: Throwable -> L33
    L12:
        d.a r111 = this.f131514a.f131491a.get(r110);     // Catch: Throwable -> L33
        if (r111 == null) goto L15;
        Pair<? extends Integer, ? extends String> r112 = r111.get(Long.valueOf(this.f131515b.getId()));     // Catch: Throwable -> L33
    L15:
        r103 = true;
        goto L17
    L11:
        r110 = null;
    L33:
        th = move-exception;
        throw th;
    }
}
