package cb;

import androidx.appcompat.widget.y0;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.core.ability.AbilityBinderImpl;
import com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator;
import com.stepos.core.ability.speech.TtsStreamBinderCoordinator;
import com.stepos.core.common.log.TraceContext;
import com.stepos.core.deepbinder.ICtaResultCallback;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.ConfirmUiRequest;
import com.stepos.core.ota.confirmui.FallbackConfirmHost;
import com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl;
import com.stepos.deepbinder.core.entity.internal.InternalMethod;
import com.stepos.deepbinder.service.cache.ServiceCache;
import com.tonyodev.fetch2.Download;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlinx.serialization.json.internal.JsonException;
import mb.y;
import rc.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3321a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3322b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3323c;

    public /* synthetic */ d(int i10, Object obj, Object obj2) {
        this.f3321a = i10;
        this.f3323c = obj;
        this.f3322b = obj2;
    }

    @Override // zb.a
    public final Object invoke() {
        String[] strArrNames;
        Object objInvoke;
        switch (this.f3321a) {
            case 0:
                c cVar = (c) this.f3323c;
                i iVar = (i) this.f3322b;
                hb.c cVar2 = iVar.f3341f;
                try {
                    List<Download> list = (List) cVar.invoke();
                    for (Download download : list) {
                        cVar2.a("Deleted download " + download);
                        iVar.f3342g.f3409i.onDeleted(download);
                    }
                    iVar.f3339d.post(new y0(list, 4));
                } catch (Exception e10) {
                    cVar2.b("Fetch with namespace " + iVar.f3336a + " error", e10);
                    y.x(e10.getMessage());
                }
                return lb.n.f10413a;
            case 1:
                i iVar2 = (i) this.f3322b;
                hb.c cVar3 = iVar2.f3341f;
                try {
                    ArrayList arrayListResumeGroup = iVar2.f3340e.resumeGroup(((Integer) this.f3323c).intValue());
                    int size = arrayListResumeGroup.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayListResumeGroup.get(i10);
                        i10++;
                        Download download2 = (Download) obj;
                        u uVar = iVar2.f3342g.f3409i;
                        cVar3.a("Queued download " + download2);
                        uVar.onQueued(download2, false);
                        cVar3.a("Resumed download " + download2);
                        uVar.onResumed(download2);
                    }
                    iVar2.f3339d.post(new y0(arrayListResumeGroup, 4));
                } catch (Exception e11) {
                    cVar3.b("Fetch with namespace " + iVar2.f3336a + " error", e11);
                    y.x(e11.getMessage());
                }
                return lb.n.f10413a;
            case 2:
                ((i) this.f3322b).f3340e.h((ya.f) this.f3323c);
                return lb.n.f10413a;
            case 3:
                return AbilityBinderImpl.handleInfer$lambda$27((AbilityBinderImpl) this.f3323c, (String) this.f3322b);
            case 4:
                return AsrRealtimeBinderCoordinator.openStreamingSession$lambda$15((AsrRealtimeBinderCoordinator) this.f3323c, (String) this.f3322b);
            case 5:
                return TtsStreamBinderCoordinator.openTtsStreamingSession$lambda$10((TtsStreamBinderCoordinator) this.f3323c, (String) this.f3322b);
            case 6:
                return TraceContext.wrapWithContext$lambda$3((TraceContext.TraceInfo) this.f3323c, (zb.a) this.f3322b);
            case 7:
                return FallbackConfirmHost.show$lambda$0((FallbackConfirmHost) this.f3323c, (ConfirmUiRequest) this.f3322b);
            case 8:
                return OtaConfirmDialogPresenter.showUpdateConfirm$lambda$18((zb.a) this.f3323c, (OtaConfirmDialogPresenter) this.f3322b);
            case 9:
                return OtaConfirmDialogPresenter.showWifiGuide$lambda$20((OtaConfirmDialogPresenter) this.f3323c, (ConfirmDecisionBus.Decision) this.f3322b);
            case 10:
                return OtaDeepBinderServiceImpl.requestCta$lambda$45((OtaDeepBinderServiceImpl) this.f3323c, (ICtaResultCallback) this.f3322b);
            case 11:
                return ModelManagerFragment.onPrimaryAction$lambda$43((ModelManagerFragment) this.f3323c, (h6.s) this.f3322b);
            case 12:
                rc.e eVar = (rc.e) this.f3323c;
                uc.a aVar = (uc.a) this.f3322b;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                uc.e eVar2 = aVar.f13194a;
                vc.h.b(eVar, aVar);
                int iE = eVar.e();
                for (int i11 = 0; i11 < iE; i11++) {
                    List<Annotation> listG = eVar.g(i11);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : listG) {
                        if (obj2 instanceof uc.o) {
                            arrayList.add(obj2);
                        }
                    }
                    uc.o oVar = (uc.o) (arrayList.size() == 1 ? arrayList.get(0) : null);
                    if (oVar != null && (strArrNames = oVar.names()) != null) {
                        for (String str : strArrNames) {
                            String str2 = kotlin.jvm.internal.g.b(eVar.d(), i.b.f11800a) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str)) {
                                String message = "The suggested name '" + str + "' for " + str2 + ' ' + eVar.f(i11) + " is already one of the names for " + str2 + ' ' + eVar.f(((Number) kotlin.collections.b.e0(str, linkedHashMap)).intValue()) + " in " + eVar;
                                kotlin.jvm.internal.g.f(message, "message");
                                throw new JsonException(message);
                            }
                            linkedHashMap.put(str, Integer.valueOf(i11));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? kotlin.collections.b.d0() : linkedHashMap;
            default:
                z9.c cVar4 = (z9.c) this.f3323c;
                Object[] objArr = (Object[]) this.f3322b;
                if (!cVar4.f14290i) {
                    InternalMethod internalMethodE = cVar4.e();
                    ServiceCache.b bVar = cVar4.f14286g;
                    kotlin.jvm.internal.g.c(bVar);
                    return internalMethodE.invoke(bVar.f7648f, Arrays.copyOf(objArr, objArr.length));
                }
                ServiceCache.b bVar2 = cVar4.f14286g;
                kotlin.jvm.internal.g.c(bVar2);
                Object obj3 = bVar2.f7648f;
                kotlin.jvm.internal.g.c(obj3);
                synchronized (obj3) {
                    InternalMethod internalMethodE2 = cVar4.e();
                    ServiceCache.b bVar3 = cVar4.f14286g;
                    kotlin.jvm.internal.g.c(bVar3);
                    objInvoke = internalMethodE2.invoke(bVar3.f7648f, Arrays.copyOf(objArr, objArr.length));
                }
                return objInvoke;
        }
    }

    public /* synthetic */ d(i iVar, Object obj, int i10) {
        this.f3321a = i10;
        this.f3322b = iVar;
        this.f3323c = obj;
    }
}
