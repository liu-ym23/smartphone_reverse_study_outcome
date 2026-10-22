package com.stepos.ailauncher.taskstore.artifact;

import La.H;
import Ua.InterfaceC1066l;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.f;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.c;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;
import p9.q;
import v9.C5685n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\n\u001a\u00020\u000728\u0010\t\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\n\u0010\u000bJG\u0010\f\u001a\u00020\u000728\u0010\t\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\f\u0010\u000bJG\u0010\r\u001a\u00020\u000728\u0010\t\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\r\u0010\u000bJE\u0010\u0012\u001a\u00020\u000726\u0010\t\u001a2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u0015\u001a\u00020\u000726\u0010\u0014\u001a2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0004\b\u0015\u0010\u0013J\u001b\u0010\u0018\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u0003J?\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J?\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\"\u0010 J?\u0010#\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b#\u0010 J*\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0086@¢\u0006\u0004\b%\u0010&J;\u0010(\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b(\u0010)J;\u0010*\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b*\u0010)J\u0085\u0001\u0010,\u001a\u00020\u00072:\u0010\t\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010/RJ\u0010\t\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00100RJ\u00101\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100RJ\u00102\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100RH\u00103\u001a4\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104RH\u00105\u001a4\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R \u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0016068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/stepos/ailauncher/taskstore/artifact/a;", "", "<init>", "()V", "Lkotlin/Function3;", "", "Lkotlin/Function1;", "LY8/t;", "", "resolver", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/q;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "Lkotlin/Function2;", "", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lp9/p;)V", "peek", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlin/Function0;", "listener", Const.INTENT_KEY_APIKEY, "(Lp9/a;)V", "l", "c", "fileId", "onUrl", "onError", "m", "(Ljava/lang/String;Lp9/l;Lp9/l;)V", "onText", "o", "n", "fileIds", "e", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "onResult", "f", "(Ljava/util/List;Lp9/l;)V", Const.INTENT_KEY_UMID, "what", Const.INTENT_KEY_PKGNAME, "(Lp9/q;Ljava/lang/String;Ljava/lang/String;Lp9/l;Lp9/l;)V", "TAG", "Ljava/lang/String;", "Lp9/q;", "previewResolver", "textResolver", "availabilityResolver", "Lp9/p;", "availabilityPeek", "Ljava/util/concurrent/CopyOnWriteArrayList;", "availabilityListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    private static final String TAG = "TaskArtifactUrlResolver";
    private static p<? super List<String>, ? super InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t>, t> availabilityPeek;
    private static p<? super List<String>, ? super InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t>, t> availabilityResolver;
    private static q<? super String, ? super InterfaceC5074l<? super String, t>, ? super InterfaceC5074l<? super Throwable, t>, t> previewResolver;
    private static q<? super String, ? super InterfaceC5074l<? super String, t>, ? super InterfaceC5074l<? super Throwable, t>, t> resolver;
    private static q<? super String, ? super InterfaceC5074l<? super String, t>, ? super InterfaceC5074l<? super Throwable, t>, t> textResolver;
    public static final a INSTANCE = new a();
    private static final CopyOnWriteArrayList<InterfaceC5063a<t>> availabilityListeners = new CopyOnWriteArrayList<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.artifact.a$a, reason: collision with other inner class name */
    public static final class C0337a implements InterfaceC5074l<Map<String, ? extends ArtifactAvailability>, t> {
        final /* synthetic */ InterfaceC1066l<Map<String, ? extends ArtifactAvailability>> $cont;

        /* JADX WARN: Multi-variable type inference failed */
        public C0337a(InterfaceC1066l<? super Map<String, ? extends ArtifactAvailability>> interfaceC1066l) {
            this.$cont = interfaceC1066l;
        }

        public final void a(Map<String, ? extends ArtifactAvailability> it) {
            kotlin.jvm.internal.p.i(it, "it");
            this.$cont.resumeWith(Result.b(it));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Map<String, ? extends ArtifactAvailability> map) {
            a(map);
            return t.f7040a;
        }
    }

    public final void a(InterfaceC5063a<t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        availabilityListeners.addIfAbsent(listener);
    }

    public final void b(q<? super String, ? super InterfaceC5074l<? super String, t>, ? super InterfaceC5074l<? super Throwable, t>, t> resolver2, String what, String fileId, InterfaceC5074l<? super String, t> onUrl, InterfaceC5074l<? super Throwable, t> onError) {
        Object objB;
        if (resolver2 == null) {
            C4148a.u(TAG, "no " + what + " resolver registered, fileId=" + fileId, false, 4, null);
            onError.invoke(null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            resolver2.invoke(fileId, onUrl, onError);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, what + " threw fileId=" + fileId, thE, false, 8, null);
            onError.invoke(thE);
        }
    }

    public final void c() {
        CopyOnWriteArrayList<InterfaceC5063a<t>> copyOnWriteArrayList = availabilityListeners;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        C4148a.d(TAG, "notifyAvailabilityChanged listeners=" + copyOnWriteArrayList.size(), false, 4, null);
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            InterfaceC5063a interfaceC5063a = (InterfaceC5063a) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5063a.invoke();
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void d(List<String> fileIds, InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> onResult) {
        Object objB;
        kotlin.jvm.internal.p.i(fileIds, "fileIds");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fileIds) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listG0 = F.g0(arrayList);
        if (listG0.isEmpty()) {
            onResult.invoke(kotlin.collections.a.i());
            return;
        }
        p<? super List<String>, ? super InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t>, t> pVar = availabilityPeek;
        if (pVar == null) {
            C4148a.u(TAG, "no availability peek registered, count=" + listG0.size(), false, 4, null);
            List list = listG0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap.put(obj2, ArtifactAvailability.UNKNOWN);
            }
            onResult.invoke(linkedHashMap);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            pVar.invoke(listG0, onResult);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "peekAvailabilityAsync threw", thE, false, 8, null);
            List list2 = listG0;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list2, 10)), 16));
            for (Object obj3 : list2) {
                linkedHashMap2.put(obj3, ArtifactAvailability.UNKNOWN);
            }
            onResult.invoke(linkedHashMap2);
        }
    }

    public final Object e(List<String> list, InterfaceC4014c<? super Map<String, ? extends ArtifactAvailability>> interfaceC4014c) {
        Object objB;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listG0 = F.g0(arrayList);
        if (listG0.isEmpty()) {
            return kotlin.collections.a.i();
        }
        p<? super List<String>, ? super InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t>, t> pVar = availabilityResolver;
        if (pVar == null) {
            C4148a.u(TAG, "no availability resolver registered, count=" + listG0.size(), false, 4, null);
            List list2 = listG0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list2, 10)), 16));
            for (Object obj2 : list2) {
                linkedHashMap.put(obj2, ArtifactAvailability.UNKNOWN);
            }
            return linkedHashMap;
        }
        c cVar = new c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        try {
            Result.Companion companion = Result.INSTANCE;
            pVar.invoke(listG0, new C0337a(cVar));
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "queryAvailability threw", thE, false, 8, null);
            List list3 = listG0;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list3, 10)), 16));
            for (Object obj3 : list3) {
                linkedHashMap2.put(obj3, ArtifactAvailability.UNKNOWN);
            }
            cVar.resumeWith(Result.b(linkedHashMap2));
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objC;
    }

    public final void f(List<String> fileIds, InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> onResult) {
        Object objB;
        kotlin.jvm.internal.p.i(fileIds, "fileIds");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fileIds) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listG0 = F.g0(arrayList);
        if (listG0.isEmpty()) {
            onResult.invoke(kotlin.collections.a.i());
            return;
        }
        p<? super List<String>, ? super InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t>, t> pVar = availabilityResolver;
        if (pVar == null) {
            C4148a.u(TAG, "no availability resolver registered, count=" + listG0.size(), false, 4, null);
            List list = listG0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap.put(obj2, ArtifactAvailability.UNKNOWN);
            }
            onResult.invoke(linkedHashMap);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            pVar.invoke(listG0, onResult);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "queryAvailabilityAsync threw", thE, false, 8, null);
            List list2 = listG0;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list2, 10)), 16));
            for (Object obj3 : list2) {
                linkedHashMap2.put(obj3, ArtifactAvailability.UNKNOWN);
            }
            onResult.invoke(linkedHashMap2);
        }
    }

    public final void g(q<? super String, ? super InterfaceC5074l<? super String, t>, ? super InterfaceC5074l<? super Throwable, t>, t> resolver2) {
        kotlin.jvm.internal.p.i(resolver2, "resolver");
        resolver = resolver2;
        C4148a.k(TAG, "artifact url resolver registered", false, 4, null);
    }

    public final void h(p<? super List<String>, ? super InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t>, t> resolver2) {
        kotlin.jvm.internal.p.i(resolver2, "resolver");
        availabilityResolver = resolver2;
        C4148a.k(TAG, "artifact availability resolver registered", false, 4, null);
    }

    public final void i(p<? super List<String>, ? super InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t>, t> peek) {
        kotlin.jvm.internal.p.i(peek, "peek");
        availabilityPeek = peek;
        C4148a.k(TAG, "artifact availability peek registered", false, 4, null);
    }

    public final void j(q<? super String, ? super InterfaceC5074l<? super String, t>, ? super InterfaceC5074l<? super Throwable, t>, t> resolver2) {
        kotlin.jvm.internal.p.i(resolver2, "resolver");
        previewResolver = resolver2;
        C4148a.k(TAG, "artifact preview url resolver registered", false, 4, null);
    }

    public final void k(q<? super String, ? super InterfaceC5074l<? super String, t>, ? super InterfaceC5074l<? super Throwable, t>, t> resolver2) {
        kotlin.jvm.internal.p.i(resolver2, "resolver");
        textResolver = resolver2;
        C4148a.k(TAG, "artifact text resolver registered", false, 4, null);
    }

    public final void l(InterfaceC5063a<t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        availabilityListeners.remove(listener);
    }

    public final void m(String fileId, InterfaceC5074l<? super String, t> onUrl, InterfaceC5074l<? super Throwable, t> onError) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(onUrl, "onUrl");
        kotlin.jvm.internal.p.i(onError, "onError");
        b(resolver, "resolve", fileId, onUrl, onError);
    }

    public final void n(String fileId, InterfaceC5074l<? super String, t> onUrl, InterfaceC5074l<? super Throwable, t> onError) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(onUrl, "onUrl");
        kotlin.jvm.internal.p.i(onError, "onError");
        b(previewResolver, "resolvePreview", fileId, onUrl, onError);
    }

    public final void o(String fileId, InterfaceC5074l<? super String, t> onText, InterfaceC5074l<? super Throwable, t> onError) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(onText, "onText");
        kotlin.jvm.internal.p.i(onError, "onError");
        b(textResolver, "resolveText", fileId, onText, onError);
    }
}
