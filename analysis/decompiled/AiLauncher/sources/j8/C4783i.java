package j8;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u0005\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lj8/i;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "message", "", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "e", "(Ljava/lang/Throwable;)V", "cause", "", "Ljava/util/Map;", Const.INTENT_KEY_UMID, "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "payload", "", "[Ljava/lang/Object;", "()[Ljava/lang/Object;", "setArguments", "([Ljava/lang/Object;)V", "arguments", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: j8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4783i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String message;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Throwable cause;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Map<String, ? extends Object> payload;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Object[] arguments;

    /* renamed from: a, reason: from getter */
    public final Object[] getArguments() {
        return this.arguments;
    }

    /* renamed from: b, reason: from getter */
    public final Throwable getCause() {
        return this.cause;
    }

    /* renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Map<String, Object> d() {
        return this.payload;
    }

    public final void e(Throwable th) {
        this.cause = th;
    }

    public final void f(String str) {
        this.message = str;
    }
}
