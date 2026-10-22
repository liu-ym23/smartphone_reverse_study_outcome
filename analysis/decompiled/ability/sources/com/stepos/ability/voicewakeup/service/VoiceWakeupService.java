package com.stepos.ability.voicewakeup.service;

import D7.N;
import D7.w;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.IVoiceWakeupCallback;
import com.stepos.ability.IVoiceWakeupService;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u0011\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/ability/voicewakeup/service/VoiceWakeupService;", "Landroid/app/Service;", AppAgent.CONSTRUCT, "()V", "LC7/r;", AppAgent.ON_CREATE, "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "com/stepos/ability/voicewakeup/service/VoiceWakeupService$binder$1", "binder", "Lcom/stepos/ability/voicewakeup/service/VoiceWakeupService$binder$1;", "Companion", "com/stepos/ability/voicewakeup/service/n", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceWakeupService extends Service {
    public static final String ACTION_BIND = "com.stepos.ability.BIND_VOICE_WAKEUP";
    public static final String ACTION_RELOAD = "com.stepos.ability.voicewakeup.action.RELOAD";
    public static final String ACTION_START = "com.stepos.ability.voicewakeup.action.START";
    public static final String ACTION_STOP = "com.stepos.ability.voicewakeup.action.STOP";
    public static final n Companion = new n();
    private static final String TAG = "VoiceWakeupService";
    private final VoiceWakeupService$binder$1 binder = new IVoiceWakeupService.Stub() { // from class: com.stepos.ability.voicewakeup.service.VoiceWakeupService$binder$1
        @Override // com.stepos.ability.IVoiceWakeupService
        public void clearVoiceprint() {
            Log.i("VoiceWakeupService", "AIDL: clearVoiceprint");
            l.o(!l.i(), new D6.i(null, 19));
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void clearVoiceprintFor(String wordId) {
            if (wordId == null || wordId.length() == 0) {
                return;
            }
            Log.i("VoiceWakeupService", "AIDL: clearVoiceprintFor ".concat(wordId));
            l lVar = l.f3333a;
            if (wordId.length() == 0) {
                return;
            }
            l.o(!l.i(), new d(wordId, l.g().b, 1));
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public String[] getTrainedWordIds() {
            Collection collection;
            Context context = l.n;
            if (context == null) {
                collection = EmptyList.f4893a;
            } else {
                List listE = N.E(context);
                ArrayList arrayList = new ArrayList(w.c0(listE, 10));
                Iterator it = listE.iterator();
                while (it.hasNext()) {
                    arrayList.add(((C4.g) it.next()).f296a);
                }
                collection = arrayList;
            }
            return (String[]) collection.toArray(new String[0]);
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public boolean hasVoiceprintModel() {
            l lVar = l.f3333a;
            E4.e eVar = l.o;
            return eVar != null && eVar.b();
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public boolean hasVoiceprintModelFor(String wordId) {
            if (wordId == null || wordId.length() == 0) {
                return false;
            }
            l lVar = l.f3333a;
            kotlin.jvm.internal.k.f(wordId, "wordId");
            E4.e eVar = l.o;
            if (eVar == null) {
                return false;
            }
            File fileA = eVar.a(wordId);
            return fileA.exists() && fileA.length() > 0;
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public boolean isWakeupRunning() {
            l lVar = l.f3333a;
            return l.f3334j;
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void registerCallback(IVoiceWakeupCallback callback) {
            if (callback != null) {
                l lVar = l.f3333a;
                l.f3341x.register(callback);
            }
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void reloadModel() {
            Log.i("VoiceWakeupService", "AIDL: reloadModel");
            l.o(!l.i(), new d(l.g().b, null));
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void startTraining() {
            Log.i("VoiceWakeupService", "AIDL: startTraining");
            Intent intent = new Intent("com.stepos.ability.action.VOICE_WAKEUP_TRAINING");
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void startWakeup() {
            Log.i("VoiceWakeupService", "AIDL: startWakeup");
            l lVar = l.f3333a;
            l.t();
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void stopWakeup() {
            Log.i("VoiceWakeupService", "AIDL: stopWakeup");
            l lVar = l.f3333a;
            l.u();
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void unregisterCallback(IVoiceWakeupCallback callback) {
            if (callback != null) {
                l lVar = l.f3333a;
                l.f3341x.unregister(callback);
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: action=" + (intent != null ? intent.getAction() : null));
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, AppAgent.ON_CREATE);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: action=" + (intent != null ? intent.getAction() : null));
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != 1127938376) {
                if (iHashCode == 1574450527 && action.equals(ACTION_RELOAD)) {
                    l.o(!l.i(), new d(l.g().b, null));
                    return 1;
                }
            } else if (action.equals(ACTION_STOP)) {
                l lVar = l.f3333a;
                l.u();
                stopSelf();
                return 2;
            }
        }
        l lVar2 = l.f3333a;
        l.t();
        return 1;
    }
}
