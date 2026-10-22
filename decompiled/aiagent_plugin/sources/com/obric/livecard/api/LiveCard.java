package com.obric.livecard.api;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.impl.IslandImpl;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.aa;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.b;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.n;
import d.x;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: LiveCard.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LiveCard implements ILiveCard {
    public static final LiveCard INSTANCE = null;
    private static Application context = null;
    private static final IslandImpl islandImpl = null;
    private static volatile Integer islandVersion = null;
    public static final String keyIslandVersion = "island_version";

    /* JADX INFO: renamed from: com.obric.livecard.api.LiveCard$clearSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: LiveCard.kt */
    static final class AnonymousClass1 extends p implements b<IslandSession, Boolean> {
        final /* synthetic */ IslandSession $session;

        AnonymousClass1(IslandSession r1) {
            this.$session = r1;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(IslandSession r3) {
            o.e(r3, "it");
            if (r3.getTaskId() != this.$session.getTaskId()) goto L5;
            boolean r2 = true;
        L7:
            return Boolean.valueOf(r2);
        L5:
            r2 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(IslandSession r3) {
            return invoke2((IslandSession) ZeusTransformUtils.preCheckCast(r3, IslandSession.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.LiveCard$init$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveCard.kt */
    @f(b = "LiveCard.kt", c = {66}, d = "invokeSuspend", e = "com.obric.livecard.api.LiveCard$init$1")
    static final class C11721 extends l implements m<am, d<? super x>, Object> {
        int label;

        C11721(d<? super C11721> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new C11721((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11721) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11721.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            IslandImpl r6 = LiveCard.access$getIslandImpl$p();
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r6.getService(r2) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ boolean lambda$drdcgSSjpVAoqHTYWe5YPAQMbGg(b r0, Object r1) {
        return clearSession$lambda$3(r0, r1);
    }

    private LiveCard() {
    }

    public static final /* synthetic */ IslandImpl access$getIslandImpl$p() {
        return islandImpl;
    }

    static {
        INSTANCE = new LiveCard();
        islandImpl = new IslandImpl();
    }

    public final Integer getIslandVersion$LiveCard_sdk_release() {
        return islandVersion;
    }

    public final void setIslandVersion$LiveCard_sdk_release(Integer r1) {
        islandVersion = r1;
    }

    public void setContext(Application r2) {
        context = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.livecard.api.ILiveCard
    public Application getContext() {
        if (context == null) goto L5;
        boolean r2 = true;
    L7:
        if (aa.f38393b == false) goto L13;
        if (r2 == true) goto L13;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("you need call init(context) first"), Throwable.class, "com.obric.aiagent.plugin"));
    L13:
        return context;
    L5:
        r2 = false;
        goto L7
    }

    @Override // com.obric.livecard.api.ILiveCard
    public String getPackageName() {
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getPackageName();
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandApi getIslandService() {
        return (IslandApi) ZeusTransformUtils.preCheckCast(islandImpl, IslandApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandHideApi getIslandHideApi(Application r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.aiagent.plugin");
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) != null) goto L5;
        setContext(r5);
    L5:
        Application r6 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        String r7 = r6.getPackageName();
    L10:
        if (o.a(r7, "com.obric.appletapp") == true) goto L32;
        Application r8 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L14;
        String r9 = r8.getPackageName();
    L16:
        if (o.a(r9, IslandImpl.LIVE_CARD_HOST) == true) goto L32;
        Application r10 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L20;
        String r11 = r10.getPackageName();
    L22:
        if (o.a(r11, "com.android.launcher3") == true) goto L32;
        Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L26;
        String r12 = r3.getPackageName();
    L28:
        if (o.a(r12, IslandImpl.LIVE_CARD_HOST_DEPRECATED) == true) goto L32;
        return (IslandHideApi) ZeusTransformUtils.preCheckCast(null, IslandHideApi.class, "com.obric.aiagent.plugin");
    L26:
        r12 = null;
        goto L28
    L20:
        r11 = null;
        goto L22
    L14:
        r9 = null;
    L32:
        return (IslandHideApi) ZeusTransformUtils.preCheckCast(islandImpl, IslandHideApi.class, "com.obric.aiagent.plugin");
    L8:
        r7 = null;
        goto L10
    }

    @Override // com.obric.livecard.api.ILiveCard
    public int getVersion(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Integer r0 = islandVersion;
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return getVersionReal(r4);
    }

    private final int getVersionReal(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L11
        ApplicationInfo r5 = r3.getPackageManager().getPackageInfo(IslandImpl.LIVE_CARD_HOST, 128).applicationInfo;     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        Bundle r6 = r5.metaData;     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        int r7 = r6.getInt(keyIslandVersion, 0);     // Catch: Throwable -> L11
        islandVersion = Integer.valueOf(r7);     // Catch: Throwable -> L11
    L9:
        Object r8 = n.f(Integer.valueOf(r7));     // Catch: Throwable -> L11
    L14:
        if (n.b(r8) == false) goto L16;
        r8 = null;
    L16:
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L19;
        return 0;
    L19:
        return r9.intValue();
    L8:
        r7 = 0;
    L11:
        th = move-exception;
        n.a r2 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L14
    }

    @Override // com.obric.livecard.api.ILiveCard
    public void init(Application r9) {
        Application r10 = (Application) ZeusTransformUtils.wrapperContextForParams(r9, Application.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        setContext(r10);
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.a(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new C11721(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private static final boolean clearSession$lambda$3(b r2, Object r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "$tmp0");
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public final void clearSession(IslandSession r3) {
        o.e(r3, SensitiveType.SESSION);
        Set<IslandSession> r2 = islandImpl.getMSessionMap().keySet();
        final b r4 = (b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), b.class, "com.obric.aiagent.plugin");
        r2.removeIf(new $$Lambda$LiveCard$drdcgSSjpVAoqHTYWe5YPAQMbGg(r4));
    }
}
