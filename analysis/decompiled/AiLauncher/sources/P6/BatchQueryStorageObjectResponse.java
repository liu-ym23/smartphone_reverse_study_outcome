package P6;

import P6.StorageObjectDetail;
import Z8.C1173v;
import Z8.C1174w;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.C5094f;
import pb.T0;
import pb.Y0;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002'#B'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b!\u0010 R\u001d\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"LP6/c;", "", "", "LP6/i;", DidiCardProvider.KEY_ITEMS, "", "notFoundFileIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/util/List;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "e", "(LP6/c;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "c", "()Ljava/util/List;", Const.INTENT_KEY_UMID, "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "byFileId", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.c, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class BatchQueryStorageObjectResponse {
    private final List<StorageObjectDetail> items;
    private final List<String> notFoundFileIds;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new C5094f(StorageObjectDetail.a.INSTANCE), new C5094f(Y0.f38329a)};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/c$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/c;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.c$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<BatchQueryStorageObjectResponse> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BatchQueryStorageObjectResponse() {
        this((List) null, (List) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.i) (0 == true ? 1 : 0));
    }

    public static final /* synthetic */ void e(BatchQueryStorageObjectResponse self, ob.d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.y(serialDesc, 0) || !p.d(self.items, C1173v.m())) {
            output.x(serialDesc, 0, kSerializerArr[0], self.items);
        }
        if (!output.y(serialDesc, 1) && p.d(self.notFoundFileIds, C1173v.m())) {
            return;
        }
        output.x(serialDesc, 1, kSerializerArr[1], self.notFoundFileIds);
    }

    public final Map<String, StorageObjectDetail> b() {
        List<StorageObjectDetail> list = this.items;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((StorageObjectDetail) obj).getFileId(), obj);
        }
        return linkedHashMap;
    }

    public final List<StorageObjectDetail> c() {
        return this.items;
    }

    public final List<String> d() {
        return this.notFoundFileIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchQueryStorageObjectResponse)) {
            return false;
        }
        BatchQueryStorageObjectResponse batchQueryStorageObjectResponse = (BatchQueryStorageObjectResponse) other;
        return p.d(this.items, batchQueryStorageObjectResponse.items) && p.d(this.notFoundFileIds, batchQueryStorageObjectResponse.notFoundFileIds);
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + this.notFoundFileIds.hashCode();
    }

    public String toString() {
        return "BatchQueryStorageObjectResponse(items=" + this.items + ", notFoundFileIds=" + this.notFoundFileIds + ")";
    }

    public /* synthetic */ BatchQueryStorageObjectResponse(int i10, List list, List list2, T0 t02) {
        this.items = (i10 & 1) == 0 ? C1173v.m() : list;
        if ((i10 & 2) == 0) {
            this.notFoundFileIds = C1173v.m();
        } else {
            this.notFoundFileIds = list2;
        }
    }

    public BatchQueryStorageObjectResponse(List<StorageObjectDetail> items, List<String> notFoundFileIds) {
        p.i(items, "items");
        p.i(notFoundFileIds, "notFoundFileIds");
        this.items = items;
        this.notFoundFileIds = notFoundFileIds;
    }

    public /* synthetic */ BatchQueryStorageObjectResponse(List list, List list2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? C1173v.m() : list2);
    }
}
