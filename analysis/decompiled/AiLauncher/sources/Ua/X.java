package Ua;

import Za.C1189i;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LUa/X;", "Ljava/util/concurrent/Executor;", "LUa/I;", "dispatcher", "<init>", "(LUa/I;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "LUa/I;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class X implements Executor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final I dispatcher;

    public X(I i10) {
        this.dispatcher = i10;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable block) {
        I i10 = this.dispatcher;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f34779a;
        if (C1189i.d(i10, emptyCoroutineContext)) {
            C1189i.c(this.dispatcher, emptyCoroutineContext, block);
        } else {
            block.run();
        }
    }

    public String toString() {
        return this.dispatcher.getName();
    }
}
