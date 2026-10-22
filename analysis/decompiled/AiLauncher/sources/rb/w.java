package rb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lrb/w;", "Lrb/c;", "Lqb/a;", "json", "Lqb/i;", UxipConstants.f30680s, "", "polymorphicDiscriminator", "<init>", "(Lqb/a;Lqb/i;Ljava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "tag", "G", "(Ljava/lang/String;)Lqb/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lqb/i;", "U", "()Lqb/i;", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class w extends AbstractC5253c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final qb.i value;

    public /* synthetic */ w(AbstractC5171a abstractC5171a, qb.i iVar, String str, int i10, kotlin.jvm.internal.i iVar2) {
        this(abstractC5171a, iVar, (i10 & 4) != 0 ? null : str);
    }

    @Override // rb.AbstractC5253c
    public qb.i G(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        if (tag == "primitive") {
            return getValue();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    @Override // rb.AbstractC5253c
    /* renamed from: U, reason: from getter */
    public qb.i getValue() {
        return this.value;
    }

    @Override // ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(AbstractC5171a json, qb.i value, String str) {
        super(json, value, str, null);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(value, "value");
        this.value = value;
        x("primitive");
    }
}
