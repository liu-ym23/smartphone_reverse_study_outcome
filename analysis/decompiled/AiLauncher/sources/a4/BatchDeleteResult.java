package a4;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0013B#\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018¨\u0006\u001a"}, d2 = {"La4/n;", "", "", "La4/m;", DidiCardProvider.KEY_ITEMS, "La4/t;", "error", "<init>", "(Ljava/util/List;La4/t;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "La4/t;", "()La4/t;", "c", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.n, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class BatchDeleteResult {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<BatchDeleteItem> items;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ErrorShape error;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"La4/n$a;", "", "<init>", "()V", "", "code", "message", "La4/n;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)La4/n;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: a4.n$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final BatchDeleteResult a(String code, String message) {
            kotlin.jvm.internal.p.i(code, "code");
            kotlin.jvm.internal.p.i(message, "message");
            return new BatchDeleteResult(C1173v.m(), new ErrorShape(code, message));
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BatchDeleteResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final ErrorShape getError() {
        return this.error;
    }

    public final List<BatchDeleteItem> b() {
        return this.items;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchDeleteResult)) {
            return false;
        }
        BatchDeleteResult batchDeleteResult = (BatchDeleteResult) other;
        return kotlin.jvm.internal.p.d(this.items, batchDeleteResult.items) && kotlin.jvm.internal.p.d(this.error, batchDeleteResult.error);
    }

    public int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        ErrorShape errorShape = this.error;
        return iHashCode + (errorShape == null ? 0 : errorShape.hashCode());
    }

    public String toString() {
        return "BatchDeleteResult(items=" + this.items + ", error=" + this.error + ")";
    }

    public BatchDeleteResult(List<BatchDeleteItem> items, ErrorShape errorShape) {
        kotlin.jvm.internal.p.i(items, "items");
        this.items = items;
        this.error = errorShape;
    }

    public /* synthetic */ BatchDeleteResult(List list, ErrorShape errorShape, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? null : errorShape);
    }
}
