package b;

import android.os.Build;
import android.window.BackEvent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000  2\u00020\u0001:\u0001\u0012B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0016\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lb/c;", "", "", "touchX", "touchY", "progress", "", "swipeEdge", "", "frameTimeMillis", "<init>", "(FFFIJ)V", "Landroid/window/BackEvent;", "backEvent", "(Landroid/window/BackEvent;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "F", "getTouchX", "()F", Const.INTENT_KEY_PKGNAME, "getTouchY", "c", Const.INTENT_KEY_UMID, "I", "()I", "e", "J", "getFrameTimeMillis", "()J", "f", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: b.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1423c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final float touchX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final float touchY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final float progress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int swipeEdge;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final long frameTimeMillis;

    public C1423c(float f10, float f11, float f12, int i10, long j10) {
        this.touchX = f10;
        this.touchY = f11;
        this.progress = f12;
        this.swipeEdge = i10;
        this.frameTimeMillis = j10;
    }

    /* renamed from: a, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: b, reason: from getter */
    public final int getSwipeEdge() {
        return this.swipeEdge;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", frameTimeMillis=" + this.frameTimeMillis + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1423c(BackEvent backEvent) {
        kotlin.jvm.internal.p.i(backEvent, "backEvent");
        C1421a c1421a = C1421a.f15183a;
        this(c1421a.c(backEvent), c1421a.d(backEvent), c1421a.a(backEvent), c1421a.b(backEvent), Build.VERSION.SDK_INT >= 36 ? C1422b.f15184a.a(backEvent) : 0L);
    }
}
