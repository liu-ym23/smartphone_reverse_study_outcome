package kotlinx.coroutines.selects;

import M5.c;
import Ua.U;
import Y8.t;
import cb.d;
import cb.e;
import cb.j;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.selects.OnTimeout;
import p9.q;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\t2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000e8F¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/selects/OnTimeout;", "", "", "timeMillis", "<init>", "(J)V", "Lcb/j;", c.ACTION_SELECT, "ignoredParam", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcb/j;Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "J", "Lcb/d;", "c", "()Lcb/d;", "getSelectClause$annotations", "()V", "selectClause", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnTimeout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long timeMillis;

    public OnTimeout(long j10) {
        this.timeMillis = j10;
    }

    public static final void e(j jVar, OnTimeout onTimeout) {
        jVar.f(onTimeout, t.f7040a);
    }

    public final d c() {
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.f36799a;
        p.g(onTimeout$selectClause$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new e(this, (q) z.g(onTimeout$selectClause$1, 3), null, 4, null);
    }

    public final void d(final j<?> select, Object ignoredParam) {
        if (this.timeMillis <= 0) {
            select.d(t.f7040a);
            return;
        }
        Runnable runnable = new Runnable() { // from class: cb.a
            @Override // java.lang.Runnable
            public final void run() {
                OnTimeout.e(select, this);
            }
        };
        p.g(select, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation selectImplementation = (SelectImplementation) select;
        kotlin.coroutines.d context = selectImplementation.getContext();
        selectImplementation.e(U.c(context).U(this.timeMillis, runnable, context));
    }
}
