package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.RequestId;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import nb.C4958k;
import qb.InterfaceC5178h;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/RequestIdSerializer;", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/RequestId;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestIdSerializer implements KSerializer<RequestId> {
    private final SerialDescriptor descriptor = C4958k.e("RequestId", new SerialDescriptor[0], null, 4, null);

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // lb.InterfaceC4883a
    public RequestId deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        InterfaceC5178h interfaceC5178h = decoder instanceof InterfaceC5178h ? (InterfaceC5178h) decoder : null;
        if (interfaceC5178h == null) {
            throw new IllegalStateException("Can only deserialize JSON");
        }
        qb.i iVarB = interfaceC5178h.b();
        if (!(iVarB instanceof qb.F)) {
            throw new IllegalStateException("Invalid RequestId format");
        }
        qb.F f10 = (qb.F) iVarB;
        if (f10.getIsString()) {
            return new RequestId.StringId(f10.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
        }
        if (qb.j.n(f10) != null) {
            return new RequestId.NumberId(qb.j.m(f10));
        }
        throw new IllegalStateException("Invalid RequestId type");
    }

    @Override // lb.m
    public void serialize(Encoder encoder, RequestId value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        qb.s sVar = encoder instanceof qb.s ? (qb.s) encoder : null;
        if (sVar == null) {
            throw new IllegalStateException("Can only serialize JSON");
        }
        if (value instanceof RequestId.StringId) {
            sVar.D(((RequestId.StringId) value).getValue());
        } else {
            if (!(value instanceof RequestId.NumberId)) {
                throw new NoWhenBranchMatchedException();
            }
            sVar.i(((RequestId.NumberId) value).getValue());
        }
    }
}
