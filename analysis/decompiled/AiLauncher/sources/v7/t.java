package v7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010¨\u0006\u0011"}, d2 = {"Lv7/t;", "", "Lv7/s;", "channel", "LB7/a;", "binder", "<init>", "(Lv7/s;LB7/a;)V", "", "elapsedMs", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(J)V", Const.INTENT_KEY_APIKEY, "Lv7/s;", "()Lv7/s;", "LB7/a;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final s channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B7.a binder;

    public t(s channel, B7.a binder) {
        kotlin.jvm.internal.p.i(channel, "channel");
        kotlin.jvm.internal.p.i(binder, "binder");
        this.channel = channel;
        this.binder = binder;
    }

    /* renamed from: a, reason: from getter */
    public final s getChannel() {
        return this.channel;
    }

    public final void b(long elapsedMs) {
        this.binder.e(elapsedMs);
        this.channel.a(this.binder.j());
    }
}
