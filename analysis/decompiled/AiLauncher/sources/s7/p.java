package s7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Ls7/p;", "", "<init>", "()V", "Ls7/q;", "error", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ls7/q;)V", "Ls7/f;", Const.INTENT_KEY_PKGNAME, "Ls7/f;", "errorHandler", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f40121a = new p();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static f errorHandler = new d();

    public final void a(MotionKitError error) {
        kotlin.jvm.internal.p.i(error, "error");
        errorHandler.a(error);
    }
}
