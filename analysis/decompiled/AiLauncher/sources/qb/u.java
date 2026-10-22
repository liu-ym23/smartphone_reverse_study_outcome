package qb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lqb/u;", "Lqb/a;", "Lqb/f;", "configuration", "Lsb/c;", "module", "<init>", "(Lqb/f;Lsb/c;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u extends AbstractC5171a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(JsonConfiguration configuration, AbstractC5465c module) {
        super(configuration, module, null);
        kotlin.jvm.internal.p.i(configuration, "configuration");
        kotlin.jvm.internal.p.i(module, "module");
        h();
    }

    public final void h() {
        if (kotlin.jvm.internal.p.d(getSerializersModule(), sb.d.a())) {
            return;
        }
        getSerializersModule().a(new rb.y(getConfiguration()));
    }
}
