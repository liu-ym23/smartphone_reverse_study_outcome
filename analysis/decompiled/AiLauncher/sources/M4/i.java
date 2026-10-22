package M4;

import L4.r;
import Ua.M;
import Xa.t;
import Xa.u;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import eb.InterfaceC4021a;
import java.util.ArrayDeque;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000b\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\r\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"LM4/i;", "", "LUa/M;", "scope", "LL4/r;", PolicySdkConstants.policyFileDir, "<init>", "(LUa/M;LL4/r;)V", "LY8/t;", "c", "()V", Const.INTENT_KEY_APIKEY, "LUa/M;", Const.INTENT_KEY_PKGNAME, "LL4/r;", "Leb/a;", "Leb/a;", "mutex", "Ljava/util/ArrayDeque;", Const.INTENT_KEY_UMID, "Ljava/util/ArrayDeque;", AuthSessionDto.STATUS_PENDING, "LXa/k;", "e", "LXa/k;", "eventFlowMut", "LXa/t;", "f", "LXa/t;", "()LXa/t;", "eventFlow", "LXa/j;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LXa/j;", "transientFlowMut", "LXa/o;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LXa/o;", "()LXa/o;", "transientFlow", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlinx/coroutines/g;", "holdJob", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final r policy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4021a mutex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ArrayDeque<Object> pending;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<Object> eventFlowMut;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final t<Object> eventFlow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Xa.j<Object> transientFlowMut;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Xa.o<Object> transientFlow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g holdJob;

    public i(M scope, r policy) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(policy, "policy");
        this.scope = scope;
        this.policy = policy;
        this.mutex = eb.f.b(false, 1, null);
        this.pending = new ArrayDeque<>();
        Xa.k<Object> kVarA = u.a(null);
        this.eventFlowMut = kVarA;
        this.eventFlow = Xa.d.c(kVarA);
        Xa.j<Object> jVarB = Xa.p.b(0, 16, null, 4, null);
        this.transientFlowMut = jVarB;
        this.transientFlow = Xa.d.b(jVarB);
    }

    public final t<Object> a() {
        return this.eventFlow;
    }

    public final Xa.o<Object> b() {
        return this.transientFlow;
    }

    public final void c() {
        kotlinx.coroutines.g gVar = this.holdJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }
}
