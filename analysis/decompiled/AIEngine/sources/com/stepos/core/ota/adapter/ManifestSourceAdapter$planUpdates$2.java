package com.stepos.core.ota.adapter;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.install.OtaBucketLegacy;
import gc.q;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import mb.m;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$2", f = "ManifestSourceAdapter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ManifestSourceAdapter$planUpdates$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends List<? extends ModelManifest>>>, Object> {
    final /* synthetic */ String $baseOtaId;
    final /* synthetic */ boolean $forceRefresh;
    final /* synthetic */ Set<String> $plugins;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ManifestSourceAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManifestSourceAdapter$planUpdates$2(String str, ManifestSourceAdapter manifestSourceAdapter, Set<String> set, boolean z, b<? super ManifestSourceAdapter$planUpdates$2> bVar) {
        super(2, bVar);
        this.$baseOtaId = str;
        this.this$0 = manifestSourceAdapter;
        this.$plugins = set;
        this.$forceRefresh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$6$lambda$4(OtaRemoteModel otaRemoteModel) {
        return otaRemoteModel.getName() + ":v" + otaRemoteModel.getVersion_code();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ManifestSourceAdapter$planUpdates$2 manifestSourceAdapter$planUpdates$2 = new ManifestSourceAdapter$planUpdates$2(this.$baseOtaId, this.this$0, this.$plugins, this.$forceRefresh, bVar);
        manifestSourceAdapter$planUpdates$2.L$0 = obj;
        return manifestSourceAdapter$planUpdates$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends List<? extends ModelManifest>>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<? extends List<ModelManifest>>>) bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v4, types: [kotlin.Result$Failure] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        String str = this.$baseOtaId;
        ManifestSourceAdapter manifestSourceAdapter = this.this$0;
        Set<String> set = this.$plugins;
        boolean z = this.$forceRefresh;
        try {
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (q.m0(str, '.')) {
            throw new IllegalArgumentException("baseOtaId must be base model, got ".concat(str).toString());
        }
        ArrayList arrayList = new ArrayList();
        manifestSourceAdapter.collectUpdates(str, set, new LinkedHashSet(), arrayList, z);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            if (!manifestSourceAdapter.isAlreadyInstalled((OtaRemoteModel) obj2, z)) {
                arrayList2.add(obj2);
            }
        }
        List listI0 = kotlin.collections.a.I0(kotlin.collections.a.I0(arrayList2, new Comparator() { // from class: com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$2$invokeSuspend$lambda$6$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Long.valueOf(((OtaRemoteModel) t10).getFile_size()), Long.valueOf(((OtaRemoteModel) t8).getFile_size()));
            }
        }), new Comparator() { // from class: com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$2$invokeSuspend$lambda$6$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Boolean.valueOf(!((OtaRemoteModel) t10).isPlugin()), Boolean.valueOf(!((OtaRemoteModel) t8).isPlugin()));
            }
        });
        AIEngineLogger.i(LogModule.OTA, ManifestSourceAdapter.TAG, "planUpdates " + str + ": collected=" + arrayList.size() + " need=" + listI0.size() + " forceRefresh=" + z + " localVer=" + OtaBucketLegacy.INSTANCE.effectiveVersion(str) + " remoteVers=" + kotlin.collections.a.z0(arrayList, ",", null, null, new a(), 30));
        objA = new ArrayList(m.Z(listI0, 10));
        Iterator it = listI0.iterator();
        while (it.hasNext()) {
            objA.add(manifestSourceAdapter.toManifest((OtaRemoteModel) it.next()));
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<? extends List<ModelManifest>>> bVar) {
        return ((ManifestSourceAdapter$planUpdates$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
