package z;

import com.autonavi.aps.amapapi.config.Const;
import eb.InterfaceC4021a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0010"}, d2 = {"Lz/l;", "Lz/z;", "Leb/a;", "mutex", "<init>", "(Leb/a;)V", "", "release", "()Z", Const.INTENT_KEY_APIKEY, "Leb/a;", "LOa/a;", Const.INTENT_KEY_PKGNAME, "LOa/a;", "_released", "released", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class l implements z {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4021a mutex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Oa.a _released;

    public l(InterfaceC4021a mutex) {
        kotlin.jvm.internal.p.i(mutex, "mutex");
        this.mutex = mutex;
        this._released = Oa.b.a(false);
    }

    @Override // z.z
    public boolean a() {
        return this._released.b();
    }

    @Override // z.z
    public boolean release() {
        if (!this._released.a(false, true)) {
            return false;
        }
        InterfaceC4021a.i(this.mutex, null, 1, null);
        return true;
    }
}
