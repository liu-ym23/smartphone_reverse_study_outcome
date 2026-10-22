package com.stepos.ability.net;

import F9.C0233k;
import F9.E;
import F9.F;
import S7.a;
import T3.c;
import U3.b;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.ability.api.init.IInit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m4.C1678a;
import n4.AbstractC1740a;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import qa.N;
import ra.C1884a;
import u1.d;

@Singleton
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001$\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/ability/net/NetImpl;", "Lcom/stepos/ability/api/init/IInit;", "Lcom/stepos/ability/net/INet;", "LT3/c;", "deviceIdManager", "LU3/b;", "envManager", AppAgent.CONSTRUCT, "(LT3/c;LU3/b;)V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "cls", "create", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lkotlin/Function0;", "", "provider", "setTokenProvider", "(LS7/a;)V", "LT3/c;", "LU3/b;", "Lqa/N;", "retrofit", "Lqa/N;", "getRetrofit", "()Lqa/N;", "setRetrofit", "(Lqa/N;)V", "Ln4/b;", "signInterceptor", "Ln4/b;", "m4/a", "onDeviceIdChangedListener", "Lm4/a;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetImpl implements IInit, INet {
    private final c deviceIdManager;
    private final b envManager;
    private final C1678a onDeviceIdChangedListener;
    private N retrofit;
    private n4.b signInterceptor;

    @Inject
    public NetImpl(c deviceIdManager, b envManager) {
        k.f(deviceIdManager, "deviceIdManager");
        k.f(envManager, "envManager");
        this.deviceIdManager = deviceIdManager;
        this.envManager = envManager;
        this.onDeviceIdChangedListener = new C1678a(this);
    }

    @Override // com.stepos.ability.net.INet
    public <T> T create(Class<T> cls) {
        k.f(cls, "cls");
        N n = this.retrofit;
        if (n != null) {
            return (T) n.b(cls);
        }
        return null;
    }

    public final N getRetrofit() {
        return this.retrofit;
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        k.f(context, "context");
        c cVar = this.deviceIdManager;
        C1678a listener = this.onDeviceIdChangedListener;
        T3.b bVar = (T3.b) cVar;
        bVar.getClass();
        k.f(listener, "listener");
        bVar.d.add(listener);
        byte[] bArr = AbstractC1740a.f5347a;
        AbstractC1740a.b = context.getApplicationContext();
        E e = new E();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e.b(15L, timeUnit);
        e.c(15L, timeUnit);
        e.b = new C0233k(5, 5L, TimeUnit.MINUTES);
        F f = new F(e);
        n4.b bVar2 = new n4.b(context, this.deviceIdManager.a());
        this.signInterceptor = bVar2;
        T9.b bVar3 = new T9.b();
        bVar3.b = HttpLoggingInterceptor$Level.b;
        bVar3.b("Authorization");
        bVar3.b("Cookie");
        bVar3.b("Set-Cookie");
        bVar3.b("zy-device-id");
        bVar3.b("zy-app-id");
        bVar3.b("zy-nonce");
        bVar3.b("zy-timestamp");
        bVar3.b("zy-sign");
        E eA = f.a();
        eA.a(bVar2);
        eA.a(bVar3);
        F f7 = new F(eA);
        if (this.retrofit == null) {
            d dVar = new d(20);
            dVar.I(this.envManager.a().getBaseUrl());
            dVar.b = f7;
            ((ArrayList) dVar.d).add(C1884a.c(new Gson()));
            this.retrofit = dVar.J();
        }
    }

    public final void setRetrofit(N n) {
        this.retrofit = n;
    }

    @Override // com.stepos.ability.net.INet
    public void setTokenProvider(a provider) {
        k.f(provider, "provider");
        n4.b bVar = this.signInterceptor;
        if (bVar != null) {
            bVar.c = provider;
        }
    }
}
