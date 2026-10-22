package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.EasingType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import s7.v;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0086\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0086\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0003R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lu7/d;", "", "<init>", "()V", "", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "e", "(FF)Lu7/d;", "", Const.SP_KEY_GSM_UPLOAD_MXSIZE, Const.INTENT_KEY_PKGNAME, "(Lu7/d;J)Lu7/d;", "Lcom/stepos/motionkit/EasingType;", "type", "c", "(Lu7/d;Lcom/stepos/motionkit/EasingType;)Lu7/d;", "Ls7/v$e;", Const.INTENT_KEY_APIKEY, "()Ls7/v$e;", "LY8/t;", Const.INTENT_KEY_UMID, "", "Ls7/v$e$a;", "Ljava/util/List;", "segments", "F", "pendingFrom", "pendingTo", "J", "pendingDuration", "Lcom/stepos/motionkit/EasingType;", "pendingEasing", "", "f", "Z", "hasPending", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: u7.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5585d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public float pendingFrom;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float pendingTo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean hasPending;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<v.Sequence.Segment> segments = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public long pendingDuration = 300;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public EasingType pendingEasing = EasingType.LINEAR;

    public final v.Sequence a() {
        if (this.hasPending) {
            d();
        }
        return new v.Sequence(this.segments);
    }

    public final C5585d b(C5585d c5585d, long j10) {
        p.i(c5585d, "<this>");
        c5585d.pendingDuration = j10;
        return c5585d;
    }

    public final C5585d c(C5585d c5585d, EasingType type) {
        p.i(c5585d, "<this>");
        p.i(type, "type");
        c5585d.pendingEasing = type;
        return c5585d;
    }

    public final void d() {
        this.segments.add(new v.Sequence.Segment(this.pendingFrom, this.pendingTo, this.pendingDuration, this.pendingEasing));
    }

    public final C5585d e(float f10, float f11) {
        if (this.hasPending) {
            d();
        }
        this.pendingFrom = f10;
        this.pendingTo = f11;
        this.pendingDuration = 300L;
        this.pendingEasing = EasingType.LINEAR;
        this.hasPending = true;
        return this;
    }
}
