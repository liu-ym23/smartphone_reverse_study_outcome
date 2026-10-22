package com.stepos.ability.manager.watcher;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.stepos.ability.net.biz.model.DeviceAppRequest;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.watcher.AbilityInstallerWatcher$handleAppRemoved$1", f = "AbilityInstallerWatcher.kt", l = {245, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilityInstallerWatcher$handleAppRemoved$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3165a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ b d;
    public final /* synthetic */ DeviceAppRequest e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityInstallerWatcher$handleAppRemoved$1(Context context, String str, b bVar, DeviceAppRequest deviceAppRequest, H7.c cVar) {
        super(2, cVar);
        this.b = context;
        this.c = str;
        this.d = bVar;
        this.e = deviceAppRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilityInstallerWatcher$handleAppRemoved$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilityInstallerWatcher$handleAppRemoved$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        if (r11 == r2) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            com.stepos.ability.manager.watcher.b r0 = r10.d
            java.lang.String r1 = "handleAppRemoved pkg="
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r10.f3165a
            C7.r r4 = C7.r.f317a
            r5 = 2
            r6 = 1
            java.lang.String r7 = "AbilityInstallerWatcher"
            java.lang.String r8 = r10.c
            java.lang.String r9 = "handleAppRemoved pkg:"
            if (r3 == 0) goto L2a
            if (r3 == r6) goto L26
            if (r3 != r5) goto L1e
            kotlin.b.b(r11)     // Catch: java.lang.Exception -> L1c
            goto L72
        L1c:
            r10 = move-exception
            goto L89
        L1e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L26:
            kotlin.b.b(r11)     // Catch: java.lang.Exception -> L1c
            goto L3e
        L2a:
            kotlin.b.b(r11)
            F.i r11 = com.stepos.ability.manager.cache.a.e     // Catch: java.lang.Exception -> L1c
            android.content.Context r3 = r10.b     // Catch: java.lang.Exception -> L1c
            com.stepos.ability.manager.cache.a r11 = r11.x(r3)     // Catch: java.lang.Exception -> L1c
            r10.f3165a = r6     // Catch: java.lang.Exception -> L1c
            java.lang.Object r11 = r11.c(r8, r10)     // Catch: java.lang.Exception -> L1c
            if (r11 != r2) goto L3e
            goto L71
        L3e:
            d4.d r11 = r0.c     // Catch: java.lang.Exception -> L1c
            boolean r11 = r11.a()     // Catch: java.lang.Exception -> L1c
            if (r11 != 0) goto L5b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1c
            r10.<init>(r1)     // Catch: java.lang.Exception -> L1c
            r10.append(r8)     // Catch: java.lang.Exception -> L1c
            java.lang.String r11 = ": skip upload, no auth token"
            r10.append(r11)     // Catch: java.lang.Exception -> L1c
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L1c
            android.util.Log.i(r7, r10)     // Catch: java.lang.Exception -> L1c
            return r4
        L5b:
            com.stepos.ability.net.INet r11 = r0.f3169a     // Catch: java.lang.Exception -> L1c
            java.lang.Class<com.stepos.ability.net.biz.ApiService> r0 = com.stepos.ability.net.biz.ApiService.class
            java.lang.Object r11 = r11.create(r0)     // Catch: java.lang.Exception -> L1c
            com.stepos.ability.net.biz.ApiService r11 = (com.stepos.ability.net.biz.ApiService) r11     // Catch: java.lang.Exception -> L1c
            if (r11 == 0) goto L74
            com.stepos.ability.net.biz.model.DeviceAppRequest r0 = r10.e     // Catch: java.lang.Exception -> L1c
            r10.f3165a = r5     // Catch: java.lang.Exception -> L1c
            java.lang.Object r11 = r11.uploadAbilities(r0, r10)     // Catch: java.lang.Exception -> L1c
            if (r11 != r2) goto L72
        L71:
            return r2
        L72:
            com.stepos.ability.net.biz.model.ApiResult r11 = (com.stepos.ability.net.biz.model.ApiResult) r11     // Catch: java.lang.Exception -> L1c
        L74:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1c
            r10.<init>(r9)     // Catch: java.lang.Exception -> L1c
            r10.append(r8)     // Catch: java.lang.Exception -> L1c
            java.lang.String r11 = ", req:<redacted>, result:<redacted>"
            r10.append(r11)     // Catch: java.lang.Exception -> L1c
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L1c
            android.util.Log.i(r7, r10)     // Catch: java.lang.Exception -> L1c
            return r4
        L89:
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r9)
            r11.append(r8)
            java.lang.String r0 = " error:"
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            android.util.Log.e(r7, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.watcher.AbilityInstallerWatcher$handleAppRemoved$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
