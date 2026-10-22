package com.bytedance.android.live.screenrotate;

import c81.a;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.room.api.screenrotation.entrance.b;
import com.bytedance.android.live.room.api.screenrotation.rotate.c;
import com.bytedance.android.live.room.api.screenrotation.rotate.e;
import com.bytedance.android.live.screenrotate.config.ConfigChangeHandler;
import com.bytedance.android.live.screenrotate.rotate.ScreenRotateContext;
import com.bytedance.android.live.screenrotate.rotate.d;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016JA\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u001a\u0010'\u001a\u00020&2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020%H\u0016J\u001a\u0010)\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020%H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006."}, d2 = {"Lcom/bytedance/android/live/screenrotate/ScreenRotateService;", "Lcom/bytedance/android/live/room/api/screenrotation/api/IScreenRotateService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initRotateContext", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/d;", "rotateSession", "dc", "Lz71/a;", "rotateContext", "R", "Lkotlin/Function1;", "action", "useContext", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/e;", "rotation", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/a;", "rotateHandler", "Lc81/a;", "rotateInterceptor", "Lcom/bytedance/android/live/room/api/screenrotation/entrance/b;", "entranceVisibleNotify", "handler", "", "registerRotateHandler", "unregisterRotateHandler", "interceptor", "registerRotateInterceptor", "unregisterRotateInterceptor", "Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "rotateMonitor", "La81/a;", "configHandler", "La81/b;", "Lio/reactivex/disposables/Disposable;", "registerOnConfigChanged", "registerGlobalOnConfigChanged", "unregisterOnConfigChanged", "unregisterOnGlobalConfigChanged", "paidLiveRotateInterceptor", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ScreenRotateService implements IScreenRotateService {
    public ScreenRotateService() {
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public a paidLiveRotateInterceptor() {
        ScreenRotateContext.Companion.getClass();
        z71.a r100 = ScreenRotateContext.Companion.a(null);
        if (r100 == null) goto L21;
        c r101 = r100.getHandleRegistry();
        if (r101 == null) goto L22;
        List<a> r102 = r101.e();
        if (r102 == null) goto L23;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((a) r105).getTag(), "paid_live") == false) goto L10;
        r103.add(r105);
        goto L10
    L15:
        return (a) CollectionsKt.firstOrNull(r103);
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public a81.a configHandler() {
        return ConfigChangeHandler.f100560b;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public b entranceVisibleNotify() {
        return na1.a.f518434c;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public com.bytedance.android.live.room.api.screenrotation.rotate.a rotateHandler() {
        return com.bytedance.android.live.screenrotate.rotate.c.f100581a;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public a rotateInterceptor() {
        return oa1.b.f522530a;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IMiddlewareScreenRotateService
    public e rotation() {
        return d.f100584c;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public Disposable registerGlobalOnConfigChanged(a81.b r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Map<a81.b, Disposable> r101 = ConfigChangeHandler.f100559a;
        Intrinsics.checkNotNullParameter(r100, "action");
        ConcurrentHashMap r102 = (ConcurrentHashMap) ConfigChangeHandler.f100559a;
        Disposable r103 = (Disposable) r102.get(r100);
        if (r103 != null) goto L6;
        Disposable r104 = Disposables.fromAction(new com.bytedance.android.live.screenrotate.config.a(r102, r100));
        r102.put(r100, r104);
        return r104;
    L6:
        return r103;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void registerRotateHandler(com.bytedance.android.live.room.api.screenrotation.rotate.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        ScreenRotateContext.Companion.getClass();
        z71.a r101 = ScreenRotateContext.Companion.a(null);
        if (r101 == null) goto L8;
        c r102 = r101.getHandleRegistry();
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void registerRotateInterceptor(a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ScreenRotateContext.Companion.getClass();
        z71.a r101 = ScreenRotateContext.Companion.a(null);
        if (r101 == null) goto L8;
        c r102 = r101.getHandleRegistry();
        if (r102 == null) goto L9;
        r102.c(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public z71.a rotateContext(DataCenter r100) {
        ScreenRotateContext.Companion.getClass();
        return ScreenRotateContext.Companion.b(r100);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public IScreenRotateMonitor rotateMonitor(DataCenter r100) {
        ScreenRotateContext.Companion.getClass();
        z71.a r101 = ScreenRotateContext.Companion.b(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getMonitor();
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterOnGlobalConfigChanged(a81.b r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Map<a81.b, Disposable> r101 = ConfigChangeHandler.f100559a;
        Intrinsics.checkNotNullParameter(r100, "action");
        Disposable r102 = (Disposable) ((ConcurrentHashMap) ConfigChangeHandler.f100559a).get(r100);
        if (r102 == null) goto L6;
        r102.dispose();
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterRotateHandler(com.bytedance.android.live.room.api.screenrotation.rotate.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        ScreenRotateContext.Companion.getClass();
        z71.a r101 = ScreenRotateContext.Companion.a(null);
        if (r101 == null) goto L8;
        c r102 = r101.getHandleRegistry();
        if (r102 == null) goto L9;
        r102.f(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterRotateInterceptor(a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ScreenRotateContext.Companion.getClass();
        z71.a r101 = ScreenRotateContext.Companion.a(null);
        if (r101 == null) goto L8;
        c r102 = r101.getHandleRegistry();
        if (r102 == null) goto L9;
        r102.g(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public DataContext initRotateContext(DataCenter r100, RoomContext r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        ScreenRotateContext r102 = new ScreenRotateContext(r101, r100);
        r102.initialize();
        return r102;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public Disposable registerOnConfigChanged(DataCenter r100, a81.b r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        ConfigChangeHandler.f100560b.getClass();
        return ConfigChangeHandler.b(r100, r101);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public com.bytedance.android.live.room.api.screenrotation.rotate.d rotateSession(DataCenter r100, RoomContext r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        ScreenRotateContext.Companion.getClass();
        z71.a r102 = ScreenRotateContext.Companion.a(r101);
        if (r102 == null) goto L7;
        com.bytedance.android.live.room.api.screenrotation.rotate.d r103 = r102.getRotateSession();
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new com.bytedance.android.live.screenrotate.rotate.a(r100, r101);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public void unregisterOnConfigChanged(DataCenter r100, a81.b r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        ConfigChangeHandler.f100560b.getClass();
        ConfigChangeHandler.c(r100, r101);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService
    public <R> R useContext(RoomContext r100, DataCenter r101, Function1<? super z71.a, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r102, "action");
        ScreenRotateContext.Companion.getClass();
        return (R) ScreenRotateContext.Companion.c(r100, r101, r102);
    }
}
