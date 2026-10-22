package qb;

import La.L;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import nb.AbstractC4952e;
import nb.C4958k;
import rb.C5268s;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lqb/x;", "Lkotlinx/serialization/KSerializer;", "Lqb/w;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;Lqb/w;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)Lqb/w;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class x implements KSerializer<w> {

    /* renamed from: a, reason: collision with root package name */
    public static final x f38680a = new x();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final SerialDescriptor descriptor = C4958k.c("kotlinx.serialization.json.JsonLiteral", AbstractC4952e.i.f37271a);

    @Override // lb.InterfaceC4883a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        i iVarB = r.d(decoder).b();
        if (iVarB instanceof w) {
            return (w) iVarB;
        }
        throw C5268s.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + kotlin.jvm.internal.t.b(iVarB.getClass()), iVarB.toString());
    }

    @Override // lb.m
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, w value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        r.h(encoder);
        if (value.getIsString()) {
            encoder.D(value.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
            return;
        }
        if (value.getCoerceToInlineType() != null) {
            encoder.h(value.getCoerceToInlineType()).D(value.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
            return;
        }
        Long lY = La.C.y(value.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
        if (lY != null) {
            encoder.i(lY.longValue());
            return;
        }
        Y8.o oVarH = L.h(value.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
        if (oVarH != null) {
            encoder.h(C4931a.w(Y8.o.INSTANCE).getDescriptor()).i(oVarH.getData());
            return;
        }
        Double dT = La.B.t(value.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
        if (dT != null) {
            encoder.c(dT.doubleValue());
            return;
        }
        Boolean boolC1 = La.H.C1(value.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
        if (boolC1 != null) {
            encoder.p(boolC1.booleanValue());
        } else {
            encoder.D(value.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
        }
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }
}
