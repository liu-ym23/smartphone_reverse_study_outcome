package b5;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lb5/a;", "Lb5/b;", "", "attr", "<init>", "(I)V", "Landroid/content/Context;", "ctx", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", "I", "getAttr", "()I", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: b5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1449a extends AbstractC1450b {
    private final int attr;

    public C1449a(int i10) {
        super(null);
        this.attr = i10;
    }

    public int a(Context ctx) {
        p.i(ctx, "ctx");
        return M2.a.b(ctx, this.attr, -65281);
    }
}
