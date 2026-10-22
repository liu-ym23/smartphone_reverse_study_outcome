package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\b\u0012\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJA\u0010\u0018\u001a\u00020\u0006\"\b\b\u0000\u0010\u0010*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u001c8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lrb/C;", "Lrb/e;", "Lqb/a;", "json", "Lkotlin/Function1;", "Lqb/i;", "LY8/t;", "nodeConsumer", "<init>", "(Lqb/a;Lp9/l;)V", "", "key", "element", "s0", "(Ljava/lang/String;Lqb/i;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "Llb/m;", "serializer", UxipConstants.f30680s, "k", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILlb/m;Ljava/lang/Object;)V", "o0", "()Lqb/i;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/Map;", "t0", "()Ljava/util/Map;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.C, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5248C extends AbstractC5255e {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<String, qb.i> content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5248C(AbstractC5171a json, InterfaceC5074l<? super qb.i, Y8.t> nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(nodeConsumer, "nodeConsumer");
        this.content = new LinkedHashMap();
    }

    @Override // pb.c1, ob.d
    public <T> void k(SerialDescriptor descriptor, int index, lb.m<? super T> serializer, T value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(serializer, "serializer");
        if (value != null || this.configuration.getExplicitNulls()) {
            super.k(descriptor, index, serializer, value);
        }
    }

    @Override // rb.AbstractC5255e
    public qb.i o0() {
        return new qb.D(this.content);
    }

    @Override // rb.AbstractC5255e
    public void s0(String key, qb.i element) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(element, "element");
        this.content.put(key, element);
    }

    public final Map<String, qb.i> t0() {
        return this.content;
    }
}
