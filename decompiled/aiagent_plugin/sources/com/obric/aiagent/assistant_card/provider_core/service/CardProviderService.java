package com.obric.aiagent.assistant_card.provider_core.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.obric.aiagent.assistant_card.provider_core.a.b;
import com.obric.aiagent.assistant_card.provider_core.a.d;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CardProviderService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CardProviderService extends PluginService {
    public static final a Companion = null;
    private static final String TAG = "CardProviderService";
    private final f cardProvider$delegate;
    private final f lightContext$delegate;
    private final f nightContext$delegate;

    /* JADX INFO: compiled from: CardProviderService.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$Zv-ybCfVaZQsjO2pioVlFbijvHc, reason: not valid java name */
    public static /* synthetic */ Context m154lambda$ZvybCfVaZQsjO2pioVlFbijvHc(CardProviderService r0) {
        return nightContext_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$ctB0-tPMayxH3eJAWp_J2EZ5Ahk, reason: not valid java name */
    public static /* synthetic */ Context m155lambda$ctB0tPMayxH3eJAWp_J2EZ5Ahk(CardProviderService r0) {
        return lightContext_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$ujL7tTQ2CIoL6-7k4_x9wSRITa4, reason: not valid java name */
    public static /* synthetic */ CardProviderService$cardProvider$2$1 m156lambda$ujL7tTQ2CIoL67k4_x9wSRITa4(CardProviderService r0) {
        return cardProvider_delegate$lambda$2(r0);
    }

    public CardProviderService() {
        this.lightContext$delegate = g.a(new $$Lambda$CardProviderService$ctB0tPMayxH3eJAWp_J2EZ5Ahk(this));
        this.nightContext$delegate = g.a(new $$Lambda$CardProviderService$ZvybCfVaZQsjO2pioVlFbijvHc(this));
        this.cardProvider$delegate = g.a(new $$Lambda$CardProviderService$ujL7tTQ2CIoL67k4_x9wSRITa4(this));
    }

    public static final /* synthetic */ Context access$getLightContext(CardProviderService r2) {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((CardProviderService) ZeusTransformUtils.wrapperContextForParams(r2, CardProviderService.class, "com.obric.aiagent.plugin")).getLightContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Context access$getNightContext(CardProviderService r2) {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((CardProviderService) ZeusTransformUtils.wrapperContextForParams(r2, CardProviderService.class, "com.obric.aiagent.plugin")).getNightContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    private final Context getLightContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.lightContext$delegate.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private static final Context lightContext_delegate$lambda$0(CardProviderService r2) {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((CardProviderService) ZeusTransformUtils.wrapperContextForParams(r2, CardProviderService.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "getApplicationContext(...)");
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.c(r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    private final Context getNightContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.nightContext$delegate.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private static final Context nightContext_delegate$lambda$1(CardProviderService r2) {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((CardProviderService) ZeusTransformUtils.wrapperContextForParams(r2, CardProviderService.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "getApplicationContext(...)");
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.b(r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    private final CardProviderService$cardProvider$2$1 getCardProvider() {
        return (CardProviderService$cardProvider$2$1) ZeusTransformUtils.preCheckCast(this.cardProvider$delegate.b(), CardProviderService$cardProvider$2$1.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.aiagent.assistant_card.provider_core.service.CardProviderService$cardProvider$2$1] */
    private static final CardProviderService$cardProvider$2$1 cardProvider_delegate$lambda$2(CardProviderService r2) {
        final CardProviderService r3 = (CardProviderService) ZeusTransformUtils.wrapperContextForParams(r2, CardProviderService.class, "com.obric.aiagent.plugin");
        return new CardProviderService$cardProvider$2$1(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        b.f16333a.a(TAG, "onCreate");
    }

    public IBinder onBind(Intent r4) {
        b.f16333a.a(TAG, "onBind: intent = " + r4);
        return (IBinder) ZeusTransformUtils.preCheckCast(getCardProvider(), IBinder.class, "com.obric.aiagent.plugin");
    }
}
