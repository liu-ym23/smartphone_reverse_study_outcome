package rb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lrb/x;", "Lrb/e;", "Lqb/a;", "json", "Lkotlin/Function1;", "Lqb/i;", "LY8/t;", "nodeConsumer", "<init>", "(Lqb/a;Lp9/l;)V", "", "key", "element", "s0", "(Ljava/lang/String;Lqb/i;)V", "o0", "()Lqb/i;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lqb/i;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class x extends AbstractC5255e {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public qb.i content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(AbstractC5171a json, InterfaceC5074l<? super qb.i, Y8.t> nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(nodeConsumer, "nodeConsumer");
        V("primitive");
    }

    @Override // rb.AbstractC5255e
    public qb.i o0() {
        qb.i iVar = this.content;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
    }

    @Override // rb.AbstractC5255e
    public void s0(String key, qb.i element) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(element, "element");
        if (key != "primitive") {
            throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag");
        }
        if (this.content != null) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
        }
        this.content = element;
        p0().invoke(element);
    }
}
