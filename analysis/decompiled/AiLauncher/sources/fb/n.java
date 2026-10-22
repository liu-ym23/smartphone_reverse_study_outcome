package fb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lfb/n;", "Lfb/p;", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", "c", "()Z", "", "I", "copyCount", Const.INTENT_KEY_PKGNAME, "shared", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n extends p {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater<n> f32614c = AtomicIntegerFieldUpdater.newUpdater(n.class, Const.INTENT_KEY_APIKEY);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public volatile int copyCount;

    @Override // fb.p
    public void a() {
        f32614c.incrementAndGet(this);
    }

    @Override // fb.p
    public boolean b() {
        return this.copyCount > 0;
    }

    @Override // fb.p
    public boolean c() {
        if (this.copyCount == 0) {
            return false;
        }
        int iDecrementAndGet = f32614c.decrementAndGet(this);
        if (iDecrementAndGet >= 0) {
            return true;
        }
        if (iDecrementAndGet == -1) {
            this.copyCount = 0;
            return false;
        }
        throw new IllegalStateException(("Shared copies count is negative: " + (iDecrementAndGet + 1)).toString());
    }
}
