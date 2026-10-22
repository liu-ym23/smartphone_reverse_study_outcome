package B;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w.InterfaceC5714u;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\u001d\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018¨\u0006\u001d"}, d2 = {"LB/j;", "", "Lw/u$a;", "listener", "<init>", "(Lw/u$a;)V", "Lw/y;", "frameNumber", "Lw/r;", "frameTimestamp", "LY8/t;", "e", "(JJ)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lw/Q;", "streamId", "c", "(I)V", "Lw/u$a;", "getListener", "()Lw/u$a;", "LOa/a;", "LOa/a;", "isStarted", "isImagesInvoked", "isFrameInfoInvoked", "isCompletedInvoked", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5714u.a listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Oa.a isStarted;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Oa.a isImagesInvoked;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Oa.a isFrameInfoInvoked;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Oa.a isCompletedInvoked;

    public j(InterfaceC5714u.a listener) {
        p.i(listener, "listener");
        this.listener = listener;
        this.isStarted = Oa.b.a(false);
        this.isImagesInvoked = Oa.b.a(false);
        this.isFrameInfoInvoked = Oa.b.a(false);
        this.isCompletedInvoked = Oa.b.a(false);
    }

    public final void a(long frameNumber, long frameTimestamp) {
        d(frameNumber, frameTimestamp);
        b(frameNumber, frameTimestamp);
        if (this.isCompletedInvoked.a(false, true)) {
            this.listener.e();
        }
    }

    public final void b(long frameNumber, long frameTimestamp) {
        e(frameNumber, frameTimestamp);
        if (this.isFrameInfoInvoked.a(false, true)) {
            this.listener.c();
        }
    }

    public final void c(int streamId) {
        this.listener.a(streamId);
    }

    public final void d(long frameNumber, long frameTimestamp) {
        e(frameNumber, frameTimestamp);
        if (this.isImagesInvoked.a(false, true)) {
            this.listener.b();
        }
    }

    public final void e(long frameNumber, long frameTimestamp) {
        if (this.isStarted.a(false, true)) {
            this.listener.d(frameNumber, frameTimestamp);
        }
    }
}
