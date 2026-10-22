package Ua;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"LUa/w0;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "LUa/a0;", "LUa/q0;", "<init>", "()V", "LY8/t;", "dispose", "", "toString", "()Ljava/lang/String;", "", "cause", "v", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/JobSupport;", Const.INTENT_KEY_UMID, "Lkotlinx/coroutines/JobSupport;", "t", "()Lkotlinx/coroutines/JobSupport;", "w", "(Lkotlinx/coroutines/JobSupport;)V", "job", "", "u", "()Z", "onCancelling", Const.INTENT_KEY_PKGNAME, "isActive", "LUa/B0;", "getList", "()LUa/B0;", "list", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.w0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1088w0 extends LockFreeLinkedListNode implements InterfaceC1045a0, InterfaceC1077q0 {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public JobSupport job;

    @Override // Ua.InterfaceC1077q0
    /* renamed from: b */
    public boolean getIsActive() {
        return true;
    }

    @Override // Ua.InterfaceC1045a0
    public void dispose() {
        t().E0(this);
    }

    @Override // Ua.InterfaceC1077q0
    public B0 getList() {
        return null;
    }

    public final JobSupport t() {
        JobSupport jobSupport = this.job;
        if (jobSupport != null) {
            return jobSupport;
        }
        kotlin.jvm.internal.p.A("job");
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return N.a(this) + '@' + N.b(this) + "[job@" + N.b(t()) + ']';
    }

    public abstract boolean u();

    public abstract void v(Throwable cause);

    public final void w(JobSupport jobSupport) {
        this.job = jobSupport;
    }
}
