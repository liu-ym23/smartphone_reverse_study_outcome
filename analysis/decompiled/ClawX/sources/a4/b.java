package a4;

import b5.a0;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.stepclaw.GatewayRuntime;
import com.stepos.stepclaw.StepClawManager;
import com.stepos.stepclaw.base.util.StepAccount;
import com.stepos.stepclaw.chroot.AssetManifest;
import com.stepos.stepclaw.gateway.GatewayAutoStart;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.search.QueryRewriteStage;
import com.stepos.stepclaw.memory.search.SearchPipeline;
import com.stepos.stepclaw.memory.upload.SignatureData;
import com.stepos.stepclaw.openclaw.memory.MemorySearchResult;
import java.util.LinkedHashMap;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f91a;

    public /* synthetic */ b(int i8) {
        this.f91a = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f91a) {
            case 0:
                return a0.f883a;
            case 1:
                return Boolean.valueOf(GatewayRuntime.buildEdgeServicesDeps$lambda$0());
            case 2:
                return StepClawManager.memory_delegate$lambda$0();
            case 3:
                return StepClawManager.init$lambda$1();
            case 4:
                return StepClawManager.init$lambda$2();
            case 5:
                return StepAccount.init$lambda$0();
            case 6:
                return AssetManifest._childSerializers$_anonymous_();
            case 7:
                return a0.f883a;
            case 8:
                return a0.f883a;
            case 9:
                return a0.f883a;
            case 10:
                return Boolean.valueOf(GatewayAutoStart.handlePersistentConnectFailure$lambda$2());
            case BERTags.EMBEDDED_PDV /* 11 */:
                return a0.f883a;
            case 12:
                return a0.f883a;
            case BERTags.RELATIVE_OID /* 13 */:
                return OfflineEvolutionService.runPipeline$lambda$8();
            case BERTags.TIME /* 14 */:
                return OfflineEvolutionService.runPipeline$lambda$9();
            case 15:
                return OfflineEvolutionService.runPipeline$lambda$12();
            case 16:
                return OfflineEvolutionService.collectPendingFromDaily$lambda$1();
            case 17:
                return OfflineEvolutionService.clearCachedTriggerData$lambda$0();
            case BERTags.NUMERIC_STRING /* 18 */:
                return OfflineEvolutionService.maybeAutoTrigger$lambda$0();
            case 19:
                return OfflineEvolutionService.runPipeline$lambda$1();
            case 20:
                return OfflineEvolutionService.runPipeline$lambda$2();
            case BERTags.VIDEOTEX_STRING /* 21 */:
                return OfflineEvolutionService.runPipeline$lambda$3();
            case BERTags.IA5_STRING /* 22 */:
                return QueryRewriteStage.tryLocalInfer$lambda$0();
            case BERTags.UTC_TIME /* 23 */:
                return QueryRewriteStage.execute$lambda$1();
            case 24:
                return QueryRewriteStage.tryRemote$lambda$3();
            case BERTags.GRAPHIC_STRING /* 25 */:
                return SearchPipeline.execute$lambda$1();
            case BERTags.VISIBLE_STRING /* 26 */:
                return SignatureData._childSerializers$_anonymous_();
            case BERTags.GENERAL_STRING /* 27 */:
                return MemorySearchResult._childSerializers$_anonymous_();
            case BERTags.UNIVERSAL_STRING /* 28 */:
                return new LinkedHashMap();
            default:
                return AgentCacheSdk.init$lambda$0();
        }
    }
}
