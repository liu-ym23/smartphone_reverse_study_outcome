package k4;

import com.stepos.stepclaw.bridge.openclaw.ToolsInvokeResult;
import com.stepos.stepclaw.edge.intercept.model.AgentEndRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeAgentStartRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeCompactionRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeModelResolveRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforePromptBuildRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeResetRequest;
import com.stepos.stepclaw.edge.intercept.model.GatewayStartRequest;
import com.stepos.stepclaw.edge.intercept.model.LlmInputRequest;
import com.stepos.stepclaw.edge.intercept.model.MessageSendingRequest;
import com.stepos.stepclaw.edge.intercept.model.SessionStartRequest;
import com.stepos.stepclaw.edge.intercept.model.SubagentSpawningRequest;
import com.stepos.stepclaw.memory.lightmem.remote.AutoCatchResponse;
import com.stepos.stepclaw.memory.lightmem.remote.AutoMessagesRequest;
import com.stepos.stepclaw.memory.lightmem.remote.AutoRecallResponse;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionGroup;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerFirstRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import java.util.ArrayList;
import kotlinx.serialization.json.JsonElementSerializer;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3635a;

    public /* synthetic */ r(int i8) {
        this.f3635a = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f3635a) {
            case 0:
                return new ArrayList();
            case 1:
                return new ArrayList();
            case 2:
                return JsonElementSerializer.descriptor$lambda$0$0();
            case 3:
                return JsonElementSerializer.descriptor$lambda$0$1();
            case 4:
                return JsonElementSerializer.descriptor$lambda$0$2();
            case 5:
                return JsonElementSerializer.descriptor$lambda$0$3();
            case 6:
                return JsonElementSerializer.descriptor$lambda$0$4();
            case 7:
                return ToolsInvokeResult._childSerializers$_anonymous_();
            case 8:
                return ToolsInvokeResult._childSerializers$_anonymous_$0();
            case 9:
                return AgentEndRequest._childSerializers$_anonymous_();
            case 10:
                return BeforeAgentStartRequest._childSerializers$_anonymous_();
            case BERTags.EMBEDDED_PDV /* 11 */:
                return BeforeCompactionRequest._childSerializers$_anonymous_();
            case 12:
                return BeforeModelResolveRequest._childSerializers$_anonymous_();
            case BERTags.RELATIVE_OID /* 13 */:
                return BeforePromptBuildRequest._childSerializers$_anonymous_();
            case BERTags.TIME /* 14 */:
                return BeforeResetRequest._childSerializers$_anonymous_();
            case 15:
                return GatewayStartRequest._childSerializers$_anonymous_();
            case 16:
                return LlmInputRequest._childSerializers$_anonymous_();
            case 17:
                return MessageSendingRequest._childSerializers$_anonymous_();
            case BERTags.NUMERIC_STRING /* 18 */:
                return SessionStartRequest._childSerializers$_anonymous_();
            case 19:
                return SubagentSpawningRequest._childSerializers$_anonymous_();
            case 20:
                return AutoCatchResponse._childSerializers$_anonymous_();
            case BERTags.VIDEOTEX_STRING /* 21 */:
                return AutoMessagesRequest._childSerializers$_anonymous_();
            case BERTags.IA5_STRING /* 22 */:
                return AutoRecallResponse._childSerializers$_anonymous_();
            case BERTags.UTC_TIME /* 23 */:
                return CatchMemoryItem._childSerializers$_anonymous_();
            case 24:
                return OfflineEvolutionGroup._childSerializers$_anonymous_();
            case BERTags.GRAPHIC_STRING /* 25 */:
                return OfflineEvolutionGroup._childSerializers$_anonymous_$0();
            case BERTags.VISIBLE_STRING /* 26 */:
                return OfflineSearchGroup._childSerializers$_anonymous_();
            case BERTags.GENERAL_STRING /* 27 */:
                return OfflineSearchGroup._childSerializers$_anonymous_$0();
            case BERTags.UNIVERSAL_STRING /* 28 */:
                return OfflineTriggerFirstRequest._childSerializers$_anonymous_();
            default:
                return OfflineTriggerResponse._childSerializers$_anonymous_();
        }
    }
}
