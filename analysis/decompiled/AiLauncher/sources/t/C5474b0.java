package t;

import D.C0761b0;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import android.hardware.camera2.CaptureResult;
import android.util.Log;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001d8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u001e¨\u0006 "}, d2 = {"Lt/b0;", "Landroidx/camera/camera2/pipe/t$a;", "", "timeLimitNs", "Lkotlin/Function1;", "Lw/w;", "", "checker", "<init>", "(JLp9/l;)V", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "totalCaptureResult", "LY8/t;", "N0", "(Lw/K;JLw/w;)V", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "LUa/u;", "c", "LUa/u;", "completeSignal", Const.INTENT_KEY_UMID, "Ljava/lang/Long;", "timestampOfFirstUpdateNs", "LUa/Q;", "()LUa/Q;", "result", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: t.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5474b0 implements t.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long timeLimitNs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<w.w, Boolean> checker;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1083u<w.w> completeSignal;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile Long timestampOfFirstUpdateNs;

    /* JADX WARN: Multi-variable type inference failed */
    public C5474b0(long j10, InterfaceC5074l<? super w.w, Boolean> checker) {
        kotlin.jvm.internal.p.i(checker, "checker");
        this.timeLimitNs = j10;
        this.checker = checker;
        this.completeSignal = C1087w.c(null, 1, null);
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void N0(w.K requestMetadata, long frameNumber, w.w totalCaptureResult) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(totalCaptureResult, "totalCaptureResult");
        if (this.completeSignal.g() || this.completeSignal.isCancelled()) {
            return;
        }
        w.x metadata = totalCaptureResult.getMetadata();
        CaptureResult.Key SENSOR_TIMESTAMP = CaptureResult.SENSOR_TIMESTAMP;
        kotlin.jvm.internal.p.h(SENSOR_TIMESTAMP, "SENSOR_TIMESTAMP");
        Long l10 = (Long) metadata.U(SENSOR_TIMESTAMP);
        if (l10 != null && this.timestampOfFirstUpdateNs == null) {
            this.timestampOfFirstUpdateNs = l10;
        }
        Long l11 = this.timestampOfFirstUpdateNs;
        if (this.timeLimitNs == 0 || l11 == null || l10 == null || l10.longValue() - l11.longValue() <= this.timeLimitNs) {
            if (this.checker.invoke(totalCaptureResult).booleanValue()) {
                this.completeSignal.complete(totalCaptureResult);
                return;
            }
            return;
        }
        this.completeSignal.complete(null);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Wait for capture result timeout, current: " + l10.longValue() + " first: " + l11.longValue());
        }
    }

    public final Ua.Q<w.w> a() {
        return this.completeSignal;
    }
}
