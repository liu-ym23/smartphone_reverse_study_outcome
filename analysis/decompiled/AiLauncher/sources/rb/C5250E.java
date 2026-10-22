package rb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.C5172b;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0017j\b\u0012\u0004\u0012\u00020\u0005`\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lrb/E;", "Lrb/e;", "Lqb/a;", "json", "Lkotlin/Function1;", "Lqb/i;", "LY8/t;", "nodeConsumer", "<init>", "(Lqb/a;Lp9/l;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "X", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "key", "element", "s0", "(Ljava/lang/String;Lqb/i;)V", "o0", "()Lqb/i;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/ArrayList;", "array", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.E, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5250E extends AbstractC5255e {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final ArrayList<qb.i> array;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5250E(AbstractC5171a json, InterfaceC5074l<? super qb.i, Y8.t> nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(nodeConsumer, "nodeConsumer");
        this.array = new ArrayList<>();
    }

    @Override // rb.AbstractC5255e, pb.AbstractC5117q0
    public String X(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return String.valueOf(index);
    }

    @Override // rb.AbstractC5255e
    public qb.i o0() {
        return new C5172b(this.array);
    }

    @Override // rb.AbstractC5255e
    public void s0(String key, qb.i element) throws NumberFormatException {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(element, "element");
        this.array.add(Integer.parseInt(key), element);
    }
}
