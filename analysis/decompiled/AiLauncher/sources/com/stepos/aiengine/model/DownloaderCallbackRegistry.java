package com.stepos.aiengine.model;

import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.flow.ModelFlowCallback;
import com.stepos.aiengine.flow.ModelFlowError;
import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.aiengine.model.DownloaderCallbackRegistry;
import com.stepos.ailauncher.chat.trace.a;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.download.ModelFlowMeta;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$R,\u0010'\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070%0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010&R,\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0%0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010&¨\u0006)"}, d2 = {"Lcom/stepos/aiengine/model/DownloaderCallbackRegistry;", "", "<init>", "()V", "", "algorithmId", "id", "Lcom/stepos/core/download/IDownloadCallback;", a.BUTTON_DOWNLOAD, "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "flow", "register", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;Lcom/stepos/aiengine/flow/ModelFlowCallback;)Lcom/stepos/core/download/IDownloadCallback;", "unregister", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/core/download/IDownloadCallback;", "", "clear", "(Ljava/lang/String;)Ljava/util/List;", "op", "flowCallbackFor", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/aiengine/flow/ModelFlowCallback;", "Lkotlin/Function1;", "LY8/t;", "action", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lp9/l;)V", "", VoiceWakeupReceiver.EXTRA_STATE, "progress", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;II)V", "code", "message", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ILjava/lang/String;)V", "c", "(I)Ljava/lang/Integer;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "downloadCallbacks", "flowCallbacks", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DownloaderCallbackRegistry {
    public static final DownloaderCallbackRegistry INSTANCE = new DownloaderCallbackRegistry();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, IDownloadCallback>> downloadCallbacks = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, ModelFlowCallback>> flowCallbacks = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/stepos/aiengine/model/DownloaderCallbackRegistry$flowCallbackFor$1", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "Lcom/stepos/aiengine/flow/ModelFlowStage;", "stage", "LY8/t;", "onStateChanged", "(Lcom/stepos/aiengine/flow/ModelFlowStage;)V", "", ModelFlowMeta.KEY_CAN_UPDATE, "onReady", "(Z)V", "", "code", "", "message", "onFailed", "(ILjava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.aiengine.model.DownloaderCallbackRegistry$flowCallbackFor$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ModelFlowCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23793a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f23794b;

        public AnonymousClass1(String str, String str2) {
            this.f23793a = str;
            this.f23794b = str2;
        }

        public static final t d(int i10, String str, ModelFlowCallback it) {
            p.i(it, "it");
            it.onFailed(i10, str);
            return t.f7040a;
        }

        public static final t e(boolean z10, ModelFlowCallback it) {
            p.i(it, "it");
            it.onReady(z10);
            return t.f7040a;
        }

        public static final t f(ModelFlowStage modelFlowStage, ModelFlowCallback it) {
            p.i(it, "it");
            it.onStateChanged(modelFlowStage);
            return t.f7040a;
        }

        @Override // com.stepos.aiengine.flow.ModelFlowCallback
        public void onFailed(final int code, final String message) {
            p.i(message, "message");
            Log.i("DownloaderCallbackReg", this.f23794b + "[" + this.f23793a + "] failed code=" + code + " msg=" + message);
            DownloaderCallbackRegistry downloaderCallbackRegistry = DownloaderCallbackRegistry.INSTANCE;
            downloaderCallbackRegistry.d(this.f23793a, new InterfaceC5074l() { // from class: Q4.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DownloaderCallbackRegistry.AnonymousClass1.d(code, message, (ModelFlowCallback) obj);
                }
            });
            downloaderCallbackRegistry.a(this.f23793a, code, message);
        }

        @Override // com.stepos.aiengine.flow.ModelFlowCallback
        public void onReady(final boolean canUpdate) {
            Log.i("DownloaderCallbackReg", this.f23794b + "[" + this.f23793a + "] ready canUpdate=" + canUpdate);
            DownloaderCallbackRegistry downloaderCallbackRegistry = DownloaderCallbackRegistry.INSTANCE;
            downloaderCallbackRegistry.d(this.f23793a, new InterfaceC5074l() { // from class: Q4.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DownloaderCallbackRegistry.AnonymousClass1.e(canUpdate, (ModelFlowCallback) obj);
                }
            });
            downloaderCallbackRegistry.b(this.f23793a, 6, 100);
        }

        @Override // com.stepos.aiengine.flow.ModelFlowCallback
        public void onStateChanged(final ModelFlowStage stage) {
            p.i(stage, "stage");
            DownloaderCallbackRegistry.INSTANCE.d(this.f23793a, new InterfaceC5074l() { // from class: Q4.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DownloaderCallbackRegistry.AnonymousClass1.f(stage, (ModelFlowCallback) obj);
                }
            });
        }
    }

    public final void a(String algorithmId, int code, String message) {
        Collection<IDownloadCallback> collectionValues;
        List listM1;
        Integer numC = c(code);
        if (numC != null) {
            b(algorithmId, numC.intValue(), 0);
            return;
        }
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap = downloadCallbacks.get(algorithmId);
        if (concurrentHashMap == null || (collectionValues = concurrentHashMap.values()) == null || (listM1 = F.m1(collectionValues)) == null) {
            return;
        }
        for (Object obj : listM1) {
            p.h(obj, "next(...)");
            IDownloadCallback iDownloadCallback = (IDownloadCallback) obj;
            try {
                Result.Companion companion = Result.INSTANCE;
                iDownloadCallback.onError(code, message);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void b(String algorithmId, int state, int progress) {
        Collection<IDownloadCallback> collectionValues;
        List listM1;
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap = downloadCallbacks.get(algorithmId);
        if (concurrentHashMap == null || (collectionValues = concurrentHashMap.values()) == null || (listM1 = F.m1(collectionValues)) == null) {
            return;
        }
        for (Object obj : listM1) {
            p.h(obj, "next(...)");
            IDownloadCallback iDownloadCallback = (IDownloadCallback) obj;
            try {
                Result.Companion companion = Result.INSTANCE;
                iDownloadCallback.onUpdate(state, progress);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final Integer c(int code) {
        if (code == 4001) {
            return 14;
        }
        if (code != 4007) {
            if (code == 5001) {
                return 17;
            }
            if (code == 5003) {
                return 6;
            }
            if (code != 6003) {
                switch (code) {
                    case 5020:
                        return 19;
                    case 5021:
                        return 18;
                    case 5022:
                        break;
                    default:
                        return ModelFlowError.INSTANCE.isUserCanceled(code) ? 15 : null;
                }
            }
        }
        return 16;
    }

    public final List<IDownloadCallback> clear(String algorithmId) {
        Collection<IDownloadCallback> collectionValues;
        List<IDownloadCallback> listM1;
        p.i(algorithmId, "algorithmId");
        flowCallbacks.remove(algorithmId);
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMapRemove = downloadCallbacks.remove(algorithmId);
        return (concurrentHashMapRemove == null || (collectionValues = concurrentHashMapRemove.values()) == null || (listM1 = F.m1(collectionValues)) == null) ? C1173v.m() : listM1;
    }

    public final void d(String algorithmId, InterfaceC5074l<? super ModelFlowCallback, t> action) {
        Collection<ModelFlowCallback> collectionValues;
        List listM1;
        ConcurrentHashMap<String, ModelFlowCallback> concurrentHashMap = flowCallbacks.get(algorithmId);
        if (concurrentHashMap == null || (collectionValues = concurrentHashMap.values()) == null || (listM1 = F.m1(collectionValues)) == null) {
            return;
        }
        for (Object obj : listM1) {
            p.h(obj, "next(...)");
            ModelFlowCallback modelFlowCallback = (ModelFlowCallback) obj;
            try {
                Result.Companion companion = Result.INSTANCE;
                action.invoke(modelFlowCallback);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final ModelFlowCallback flowCallbackFor(String algorithmId, String op) {
        p.i(algorithmId, "algorithmId");
        p.i(op, "op");
        return new AnonymousClass1(algorithmId, op);
    }

    public final IDownloadCallback register(String algorithmId, String id, IDownloadCallback download, ModelFlowCallback flow) {
        ConcurrentHashMap<String, ModelFlowCallback> concurrentHashMapPutIfAbsent;
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMapPutIfAbsent2;
        p.i(algorithmId, "algorithmId");
        p.i(id, "id");
        p.i(download, "download");
        ConcurrentHashMap<String, ConcurrentHashMap<String, IDownloadCallback>> concurrentHashMap = downloadCallbacks;
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap2 = concurrentHashMap.get(algorithmId);
        if (concurrentHashMap2 == null && (concurrentHashMapPutIfAbsent2 = concurrentHashMap.putIfAbsent(algorithmId, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap2 = concurrentHashMapPutIfAbsent2;
        }
        IDownloadCallback iDownloadCallbackPut = concurrentHashMap2.put(id, download);
        if (flow == null) {
            ConcurrentHashMap<String, ModelFlowCallback> concurrentHashMap3 = flowCallbacks.get(algorithmId);
            if (concurrentHashMap3 != null) {
                concurrentHashMap3.remove(id);
            }
            return iDownloadCallbackPut;
        }
        ConcurrentHashMap<String, ConcurrentHashMap<String, ModelFlowCallback>> concurrentHashMap4 = flowCallbacks;
        ConcurrentHashMap<String, ModelFlowCallback> concurrentHashMap5 = concurrentHashMap4.get(algorithmId);
        if (concurrentHashMap5 == null && (concurrentHashMapPutIfAbsent = concurrentHashMap4.putIfAbsent(algorithmId, (concurrentHashMap5 = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap5 = concurrentHashMapPutIfAbsent;
        }
        p.h(concurrentHashMap5, "getOrPut(...)");
        concurrentHashMap5.put(id, flow);
        return iDownloadCallbackPut;
    }

    public final IDownloadCallback unregister(String algorithmId, String id) {
        p.i(algorithmId, "algorithmId");
        p.i(id, "id");
        ConcurrentHashMap<String, ConcurrentHashMap<String, ModelFlowCallback>> concurrentHashMap = flowCallbacks;
        ConcurrentHashMap<String, ModelFlowCallback> concurrentHashMap2 = concurrentHashMap.get(algorithmId);
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.remove(id);
            if (concurrentHashMap2.isEmpty()) {
                concurrentHashMap.remove(algorithmId);
            }
        }
        ConcurrentHashMap<String, ConcurrentHashMap<String, IDownloadCallback>> concurrentHashMap3 = downloadCallbacks;
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap4 = concurrentHashMap3.get(algorithmId);
        if (concurrentHashMap4 == null) {
            return null;
        }
        IDownloadCallback iDownloadCallbackRemove = concurrentHashMap4.remove(id);
        if (concurrentHashMap4.isEmpty()) {
            concurrentHashMap3.remove(algorithmId);
        }
        return iDownloadCallbackRemove;
    }
}
