package rb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.C5172b;
import qb.C5173c;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lrb/G;", "Lrb/C;", "Lqb/a;", "json", "Lkotlin/Function1;", "Lqb/i;", "LY8/t;", "nodeConsumer", "<init>", "(Lqb/a;Lp9/l;)V", "", "key", "element", "s0", "(Ljava/lang/String;Lqb/i;)V", "o0", "()Lqb/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/String;", "tag", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Z", "isKey", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class G extends C5248C {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public String tag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean isKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(AbstractC5171a json, InterfaceC5074l<? super qb.i, Y8.t> nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(nodeConsumer, "nodeConsumer");
        this.isKey = true;
    }

    @Override // rb.C5248C, rb.AbstractC5255e
    public qb.i o0() {
        return new qb.D(t0());
    }

    @Override // rb.C5248C, rb.AbstractC5255e
    public void s0(String key, qb.i element) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(element, "element");
        if (!this.isKey) {
            Map<String, qb.i> mapT0 = t0();
            String str = this.tag;
            if (str == null) {
                kotlin.jvm.internal.p.A("tag");
                str = null;
            }
            mapT0.put(str, element);
            this.isKey = true;
            return;
        }
        if (element instanceof qb.F) {
            this.tag = ((qb.F) element).getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String();
            this.isKey = false;
        } else {
            if (element instanceof qb.D) {
                throw C5268s.d(qb.E.f38623a.getDescriptor());
            }
            if (!(element instanceof C5172b)) {
                throw new NoWhenBranchMatchedException();
            }
            throw C5268s.d(C5173c.f38635a.getDescriptor());
        }
    }
}
