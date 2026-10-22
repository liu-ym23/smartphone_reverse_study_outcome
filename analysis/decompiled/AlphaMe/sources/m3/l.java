package m3;

import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Method;
import net.sourceforge.jeval.EvaluationConstants;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Method f13629a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadMode f13630b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f13631c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13632d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13633e;

    /* renamed from: f, reason: collision with root package name */
    public String f13634f;

    public l(Method method, Class cls, ThreadMode threadMode, int i4, boolean z4) {
        this.f13629a = method;
        this.f13630b = threadMode;
        this.f13631c = cls;
        this.f13632d = i4;
        this.f13633e = z4;
    }

    public final synchronized void a() {
        if (this.f13634f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f13629a.getDeclaringClass().getName());
            sb.append(EvaluationConstants.POUND_SIGN);
            sb.append(this.f13629a.getName());
            sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
            sb.append(this.f13631c.getName());
            this.f13634f = sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f13634f.equals(lVar.f13634f);
    }

    public final int hashCode() {
        return this.f13629a.hashCode();
    }
}
