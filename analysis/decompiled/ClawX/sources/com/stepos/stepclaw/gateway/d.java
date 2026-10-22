package com.stepos.stepclaw.gateway;

import b5.g;
import com.stepos.stepclaw.edge.intercept.handlers.AgentHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.GatewayHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.MessageHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.SessionHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.SubagentHookHandler;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.lightmem.local.LocalMemoryRuntime;
import com.stepos.stepclaw.memory.upload.MemoryUploadClient;
import com.stepos.stepclaw.memory.upload.MemoryUploadService;
import com.stepos.stepclaw.openclaw.OpenClawClient;
import com.stepos.stepclaw.openclaw.memory.MemorySearchEntry;
import com.stepos.stepclaw.openclaw.memory.MemorySearchResult;
import com.stepos.stepclaw.provider.handlers.MetaJsonMerge;
import com.stepos.stepclaw.runtime.SystemChrootRuntimeController;
import java.io.File;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import k4.w;
import kotlin.jvm.internal.p;
import kotlinx.serialization.builtins.InstantComponentSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import org.bouncycastle.asn1.BERTags;
import p5.l;
import z3.r0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1567a;

    public /* synthetic */ d(int i8) {
        this.f1567a = i8;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f1567a) {
            case 0:
                return GatewayDiscovery.createDirectResolver$lambda$2((InetAddress) obj);
            case 1:
                return GatewayLauncher._init_$lambda$2((String) obj);
            case 2:
                return GatewaySession.json$lambda$0((JsonBuilder) obj);
            case 3:
                return LightMemClient.logEvolutionGroupsSummary$lambda$0((Map.Entry) obj);
            case 4:
                return LightMemClient.json$lambda$0((JsonBuilder) obj);
            case 5:
                return LightMemClient.httpClient$lambda$0$1((r0) obj);
            case 6:
                return OfflineEvolutionService.episodicLineJson$lambda$0((JsonBuilder) obj);
            case 7:
                return LocalMemoryRuntime.json$lambda$0((JsonBuilder) obj);
            case 8:
                return MemoryUploadClient.json$lambda$0((JsonBuilder) obj);
            case 9:
                return MemoryUploadClient.httpClient$lambda$0$1((r0) obj);
            case 10:
                return MemoryUploadService.json$lambda$0((JsonBuilder) obj);
            case BERTags.EMBEDDED_PDV /* 11 */:
                return OpenClawClient.Companion.createInstance$lambda$1$0((r0) obj);
            case 12:
                return OpenClawClient.Companion.createInstance$lambda$0((JsonBuilder) obj);
            case BERTags.RELATIVE_OID /* 13 */:
                return OpenClawClient.Companion.createInstance$lambda$1((t3.d) obj);
            case BERTags.TIME /* 14 */:
                return MemorySearchResult.getCombinedSnippet$lambda$0((MemorySearchEntry) obj);
            case 15:
                return Boolean.valueOf(MetaJsonMerge.mergeAllTopLevelJsonFiles$lambda$0((File) obj));
            case 16:
                return SystemChrootRuntimeController._init_$lambda$0((List) obj);
            case 17:
                g it = (g) obj;
                p.e(it, "it");
                String str = (String) it.f892a;
                Object obj2 = it.f893b;
                if (obj2 == null) {
                    return str;
                }
                return str + '=' + String.valueOf(obj2);
            case BERTags.NUMERIC_STRING /* 18 */:
                return SerialDescriptorsKt.buildClassSerialDescriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            case 19:
                return SerialDescriptorsKt.buildSerialDescriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            case 20:
                return JsonElementSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            case BERTags.VIDEOTEX_STRING /* 21 */:
                return JsonObject.toString$lambda$0((Map.Entry) obj);
            case BERTags.IA5_STRING /* 22 */:
                CharSequence it2 = (CharSequence) obj;
                p.e(it2, "it");
                return Integer.valueOf(it2.length());
            case BERTags.UTC_TIME /* 23 */:
                w it3 = (w) obj;
                p.e(it3, "it");
                return Integer.valueOf(it3.f3640a.length());
            case 24:
                return InstantComponentSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            case BERTags.GRAPHIC_STRING /* 25 */:
                return AgentHookHandler.json$lambda$0((JsonBuilder) obj);
            case BERTags.VISIBLE_STRING /* 26 */:
                return GatewayHookHandler.json$lambda$0((JsonBuilder) obj);
            case BERTags.GENERAL_STRING /* 27 */:
                return MessageHookHandler.json$lambda$0((JsonBuilder) obj);
            case BERTags.UNIVERSAL_STRING /* 28 */:
                return SessionHookHandler.json$lambda$0((JsonBuilder) obj);
            default:
                return SubagentHookHandler.json$lambda$0((JsonBuilder) obj);
        }
    }
}
