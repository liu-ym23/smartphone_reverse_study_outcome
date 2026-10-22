package com.stepos.ailauncher.chat.voice.support;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u0018\u0018\u0000 \u001b2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0005\u0010\u0003J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J#\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00150\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/support/VoiceService;", "Landroid/app/Service;", "<init>", "()V", "LY8/t;", "onCreate", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onUnbind", "(Landroid/content/Intent;)Z", "onDestroy", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "f", "(Landroid/content/Intent;Landroid/content/Intent;)Z", "", "Lkotlin/Pair;", "Lcom/stepos/ailauncher/chat/voice/support/VoiceServiceBinder;", "sessions", "Ljava/util/List;", "com/stepos/ailauncher/chat/voice/support/VoiceService$b", "homeListenerReceiver", "Lcom/stepos/ailauncher/chat/voice/support/VoiceService$b;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceService extends Service {
    public static final String ACTION_BIND = "com.stepos.ailauncher.voice.support.VoiceService";
    private static final String TAG = "VoiceService";
    private final List<Pair<Intent, VoiceServiceBinder>> sessions = new ArrayList();
    private final b homeListenerReceiver = new b();

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceService$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "SYSTEM_DIALOG_REASON_KEY", "Ljava/lang/String;", "SYSTEM_DIALOG_REASON_HOME_KEY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        private final String SYSTEM_DIALOG_REASON_KEY = "reason";
        private final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent == null || (action = intent.getAction()) == null) {
                return;
            }
            String stringExtra = intent.getStringExtra(this.SYSTEM_DIALOG_REASON_KEY);
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("onReceive action=%s reason=%s", Arrays.copyOf(new Object[]{action, stringExtra}, 2));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(VoiceService.TAG, str, false, 4, null);
            if (kotlin.jvm.internal.p.d(action, "android.intent.action.CLOSE_SYSTEM_DIALOGS") && kotlin.jvm.internal.p.d(stringExtra, this.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                Iterator it = VoiceService.this.sessions.iterator();
                while (it.hasNext()) {
                    VoiceServiceBinder voiceServiceBinder = (VoiceServiceBinder) ((Pair) it.next()).b();
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        voiceServiceBinder.onBackPressed();
                        Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.b(C4849c.a(th));
                    }
                }
            }
        }
    }

    public static final boolean d(VoiceService voiceService, Intent intent, Pair pair) {
        kotlin.jvm.internal.p.i(pair, "<destruct>");
        Intent intent2 = (Intent) pair.a();
        VoiceServiceBinder voiceServiceBinder = (VoiceServiceBinder) pair.b();
        boolean zF = voiceService.f(intent2, intent);
        if (zF) {
            try {
                Result.Companion companion = Result.INSTANCE;
                voiceServiceBinder.destroy();
                Result.b(Y8.t.f7040a);
                return zF;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        return zF;
    }

    public static final boolean e(VoiceService voiceService, Intent intent, Pair pair) {
        kotlin.jvm.internal.p.i(pair, "<destruct>");
        Intent intent2 = (Intent) pair.a();
        VoiceServiceBinder voiceServiceBinder = (VoiceServiceBinder) pair.b();
        boolean zF = voiceService.f(intent2, intent);
        if (zF) {
            try {
                Result.Companion companion = Result.INSTANCE;
                voiceServiceBinder.destroy();
                Result.b(Y8.t.f7040a);
                return zF;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        return zF;
    }

    public final boolean f(Intent a10, Intent b10) {
        return (a10 == null || b10 == null) ? a10 == null && b10 == null : a10.filterEquals(b10);
    }

    @Override // android.app.Service
    public IBinder onBind(final Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null && !kotlin.jvm.internal.p.d(action, ACTION_BIND)) {
            C4148a.u(TAG, "onBind rejected: unexpected action", false, 4, null);
            return null;
        }
        C4148a.d(TAG, "onBind", false, 4, null);
        VoiceServiceBinder voiceServiceBinder = new VoiceServiceBinder(this, intent);
        Z8.A.L(this.sessions, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.support.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(VoiceService.d(this.f26568a, intent, (Pair) obj));
            }
        });
        this.sessions.add(Y8.j.a(intent, voiceServiceBinder));
        return voiceServiceBinder;
    }

    @Override // android.app.Service
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public void onCreate() {
        super.onCreate();
        C4148a.d(TAG, "onCreate", false, 4, null);
        try {
            registerReceiver(this.homeListenerReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2);
        } catch (Throwable th) {
            C4148a.t(TAG, "registerReceiver failed", th, false, 8, null);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        C4148a.d(TAG, "onDestroy", false, 4, null);
        try {
            unregisterReceiver(this.homeListenerReceiver);
        } catch (Throwable unused) {
        }
        Iterator<Pair<Intent, VoiceServiceBinder>> it = this.sessions.iterator();
        while (it.hasNext()) {
            VoiceServiceBinder voiceServiceBinderB = it.next().b();
            try {
                Result.Companion companion = Result.INSTANCE;
                voiceServiceBinderB.destroy();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        this.sessions.clear();
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(final Intent intent) {
        C4148a.d(TAG, "onUnbind", false, 4, null);
        Z8.A.L(this.sessions, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.support.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(VoiceService.e(this.f26566a, intent, (Pair) obj));
            }
        });
        return super.onUnbind(intent);
    }
}
