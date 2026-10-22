package kotlinx.coroutines;

import Ua.C;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "LUa/C;", "", "message", "Lkotlinx/coroutines/g;", "coroutine", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/g;)V", "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()Lkotlinx/coroutines/TimeoutCancellationException;", "Lkotlinx/coroutines/g;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeoutCancellationException extends CancellationException implements C<TimeoutCancellationException> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final transient g coroutine;

    public TimeoutCancellationException(String str, g gVar) {
        super(str);
        this.coroutine = gVar;
    }

    @Override // Ua.C
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(String str) {
        this(str, null);
    }
}
