package com.stepos.ability.sdk.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.IVoiceWakeupCallback;
import com.stepos.ability.IVoiceWakeupService;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u001b\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0011\u0010!\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/ability/sdk/client/v;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lkotlin/Function0;", "LY8/t;", "onConnected", "e", "(Lp9/a;)V", "", "", "f", "()[Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "Lcom/stepos/ability/IVoiceWakeupService;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ability/IVoiceWakeupService;", "service", "c", "Lp9/a;", "Lcom/stepos/ability/IVoiceWakeupCallback;", Const.INTENT_KEY_UMID, "Lcom/stepos/ability/IVoiceWakeupCallback;", "pendingCallback", "com/stepos/ability/sdk/client/v$b", "Lcom/stepos/ability/sdk/client/v$b;", "connection", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "isConnected", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public IVoiceWakeupService service;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<Y8.t> onConnected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public IVoiceWakeupCallback pendingCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final b connection;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ability/sdk/client/v$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "binder", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) throws RemoteException {
            IVoiceWakeupService iVoiceWakeupService;
            V3.b.g(V3.b.f6474a, "Ability_VoiceWakeupClient", "onServiceConnected", null, 4, null);
            v.this.service = IVoiceWakeupService.Stub.asInterface(binder);
            IVoiceWakeupCallback iVoiceWakeupCallback = v.this.pendingCallback;
            if (iVoiceWakeupCallback != null && (iVoiceWakeupService = v.this.service) != null) {
                iVoiceWakeupService.registerCallback(iVoiceWakeupCallback);
            }
            InterfaceC5063a interfaceC5063a = v.this.onConnected;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            V3.b.j(V3.b.f6474a, "Ability_VoiceWakeupClient", "onServiceDisconnected", null, 4, null);
            v.this.service = null;
        }
    }

    public v(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.connection = new b();
    }

    public final void e(InterfaceC5063a<Y8.t> onConnected) {
        Object objB;
        this.onConnected = onConnected;
        Intent intent = new Intent("com.stepos.ability.BIND_VOICE_WAKEUP");
        intent.setPackage("com.stepos.ability");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(this.context.bindService(intent, this.connection, 1)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            V3.b.f6474a.d("Ability_VoiceWakeupClient", "bind failed", thE);
        }
    }

    public final String[] f() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            IVoiceWakeupService iVoiceWakeupService = this.service;
            objB = Result.b(iVoiceWakeupService != null ? iVoiceWakeupService.getTrainedWordIds() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String[] strArr = (String[]) (Result.g(objB) ? null : objB);
        return strArr == null ? new String[0] : strArr;
    }

    public final boolean g() {
        return this.service != null;
    }
}
