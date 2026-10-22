package x;

import androidx.camera.camera2.pipe.compat.ClosedReason;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.C5706l;
import w.C5708n;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0080\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u0010+R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b4\u0010)\u001a\u0004\b5\u0010+R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b\u001d\u00108¨\u00069"}, d2 = {"Lx/l0;", "Lx/k0;", "Lw/n;", "cameraId", "Landroidx/camera/camera2/pipe/compat/ClosedReason;", "cameraClosedReason", "", "cameraRetryCount", "Lz/i;", "cameraRetryDurationNs", "", "cameraException", "cameraOpenDurationNs", "cameraActiveDurationNs", "cameraClosingDurationNs", "Lw/l;", "cameraErrorCode", "<init>", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/ClosedReason;Ljava/lang/Integer;Lz/i;Ljava/lang/Throwable;Lz/i;Lz/i;Lz/i;Lw/l;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getCameraId-Dz_R5H8", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/compat/ClosedReason;", "getCameraClosedReason", "()Landroidx/camera/camera2/pipe/compat/ClosedReason;", "c", "Ljava/lang/Integer;", "getCameraRetryCount", "()Ljava/lang/Integer;", Const.INTENT_KEY_UMID, "Lz/i;", "getCameraRetryDurationNs-QWez1Bs", "()Lz/i;", "e", "Ljava/lang/Throwable;", "getCameraException", "()Ljava/lang/Throwable;", "f", "getCameraOpenDurationNs-QWez1Bs", Const.INTENT_KEY_BACKGROUND_COMMAND, "getCameraActiveDurationNs-QWez1Bs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getCameraClosingDurationNs-QWez1Bs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lw/l;", "()Lw/l;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.l0, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final /* data */ class CameraStateClosed extends AbstractC5824k0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cameraId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ClosedReason cameraClosedReason;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer cameraRetryCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final z.i cameraRetryDurationNs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final Throwable cameraException;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final z.i cameraOpenDurationNs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final z.i cameraActiveDurationNs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final z.i cameraClosingDurationNs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final C5706l cameraErrorCode;

    public /* synthetic */ CameraStateClosed(String str, ClosedReason closedReason, Integer num, z.i iVar, Throwable th, z.i iVar2, z.i iVar3, z.i iVar4, C5706l c5706l, kotlin.jvm.internal.i iVar5) {
        this(str, closedReason, num, iVar, th, iVar2, iVar3, iVar4, c5706l);
    }

    /* renamed from: a, reason: from getter */
    public final C5706l getCameraErrorCode() {
        return this.cameraErrorCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraStateClosed)) {
            return false;
        }
        CameraStateClosed cameraStateClosed = (CameraStateClosed) other;
        return C5708n.d(this.cameraId, cameraStateClosed.cameraId) && this.cameraClosedReason == cameraStateClosed.cameraClosedReason && kotlin.jvm.internal.p.d(this.cameraRetryCount, cameraStateClosed.cameraRetryCount) && kotlin.jvm.internal.p.d(this.cameraRetryDurationNs, cameraStateClosed.cameraRetryDurationNs) && kotlin.jvm.internal.p.d(this.cameraException, cameraStateClosed.cameraException) && kotlin.jvm.internal.p.d(this.cameraOpenDurationNs, cameraStateClosed.cameraOpenDurationNs) && kotlin.jvm.internal.p.d(this.cameraActiveDurationNs, cameraStateClosed.cameraActiveDurationNs) && kotlin.jvm.internal.p.d(this.cameraClosingDurationNs, cameraStateClosed.cameraClosingDurationNs) && kotlin.jvm.internal.p.d(this.cameraErrorCode, cameraStateClosed.cameraErrorCode);
    }

    public int hashCode() {
        int iE = ((C5708n.e(this.cameraId) * 31) + this.cameraClosedReason.hashCode()) * 31;
        Integer num = this.cameraRetryCount;
        int iHashCode = (iE + (num == null ? 0 : num.hashCode())) * 31;
        z.i iVar = this.cameraRetryDurationNs;
        int iE2 = (iHashCode + (iVar == null ? 0 : z.i.e(iVar.getValue()))) * 31;
        Throwable th = this.cameraException;
        int iHashCode2 = (iE2 + (th == null ? 0 : th.hashCode())) * 31;
        z.i iVar2 = this.cameraOpenDurationNs;
        int iE3 = (iHashCode2 + (iVar2 == null ? 0 : z.i.e(iVar2.getValue()))) * 31;
        z.i iVar3 = this.cameraActiveDurationNs;
        int iE4 = (iE3 + (iVar3 == null ? 0 : z.i.e(iVar3.getValue()))) * 31;
        z.i iVar4 = this.cameraClosingDurationNs;
        int iE5 = (iE4 + (iVar4 == null ? 0 : z.i.e(iVar4.getValue()))) * 31;
        C5706l c5706l = this.cameraErrorCode;
        return iE5 + (c5706l != null ? C5706l.s(c5706l.getValue()) : 0);
    }

    public String toString() {
        return "CameraStateClosed(cameraId=" + ((Object) C5708n.f(this.cameraId)) + ", cameraClosedReason=" + this.cameraClosedReason + ", cameraRetryCount=" + this.cameraRetryCount + ", cameraRetryDurationNs=" + this.cameraRetryDurationNs + ", cameraException=" + this.cameraException + ", cameraOpenDurationNs=" + this.cameraOpenDurationNs + ", cameraActiveDurationNs=" + this.cameraActiveDurationNs + ", cameraClosingDurationNs=" + this.cameraClosingDurationNs + ", cameraErrorCode=" + this.cameraErrorCode + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateClosed(String cameraId, ClosedReason cameraClosedReason, Integer num, z.i iVar, Throwable th, z.i iVar2, z.i iVar3, z.i iVar4, C5706l c5706l) {
        super(null);
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(cameraClosedReason, "cameraClosedReason");
        this.cameraId = cameraId;
        this.cameraClosedReason = cameraClosedReason;
        this.cameraRetryCount = num;
        this.cameraRetryDurationNs = iVar;
        this.cameraException = th;
        this.cameraOpenDurationNs = iVar2;
        this.cameraActiveDurationNs = iVar3;
        this.cameraClosingDurationNs = iVar4;
        this.cameraErrorCode = c5706l;
    }

    public /* synthetic */ CameraStateClosed(String str, ClosedReason closedReason, Integer num, z.i iVar, Throwable th, z.i iVar2, z.i iVar3, z.i iVar4, C5706l c5706l, int i10, kotlin.jvm.internal.i iVar5) {
        this(str, closedReason, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : iVar, (i10 & 16) != 0 ? null : th, (i10 & 32) != 0 ? null : iVar2, (i10 & 64) != 0 ? null : iVar3, (i10 & 128) != 0 ? null : iVar4, (i10 & 256) != 0 ? null : c5706l, null);
    }
}
