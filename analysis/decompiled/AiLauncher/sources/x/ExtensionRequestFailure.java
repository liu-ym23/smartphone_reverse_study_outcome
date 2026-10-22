package x;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\r*\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0016¨\u0006)"}, d2 = {"Lx/t0;", "Lw/J;", "Lw/K;", "requestMetadata", "", "wasImageCaptured", "Lw/y;", "frameNumber", "", "reason", "<init>", "(Lw/K;ZJILkotlin/jvm/internal/i;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lw/K;", "getRequestMetadata", "()Lw/K;", Const.INTENT_KEY_PKGNAME, "Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", "c", "J", "getFrameNumber-Ugla2oM", "()J", Const.INTENT_KEY_UMID, "I", "getReason", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.t0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class ExtensionRequestFailure implements w.J {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final w.K requestMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean wasImageCaptured;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long frameNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int reason;

    public /* synthetic */ ExtensionRequestFailure(w.K k10, boolean z10, long j10, int i10, kotlin.jvm.internal.i iVar) {
        this(k10, z10, j10, i10);
    }

    @Override // w.J
    /* renamed from: A, reason: from getter */
    public boolean getWasImageCaptured() {
        return this.wasImageCaptured;
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtensionRequestFailure)) {
            return false;
        }
        ExtensionRequestFailure extensionRequestFailure = (ExtensionRequestFailure) other;
        return kotlin.jvm.internal.p.d(this.requestMetadata, extensionRequestFailure.requestMetadata) && this.wasImageCaptured == extensionRequestFailure.wasImageCaptured && w.y.d(this.frameNumber, extensionRequestFailure.frameNumber) && this.reason == extensionRequestFailure.reason;
    }

    @Override // w.J
    public int getReason() {
        return this.reason;
    }

    public int hashCode() {
        return (((((this.requestMetadata.hashCode() * 31) + Boolean.hashCode(this.wasImageCaptured)) * 31) + w.y.e(this.frameNumber)) * 31) + Integer.hashCode(this.reason);
    }

    public String toString() {
        return "ExtensionRequestFailure(requestMetadata=" + this.requestMetadata + ", wasImageCaptured=" + this.wasImageCaptured + ", frameNumber=" + ((Object) w.y.f(this.frameNumber)) + ", reason=" + this.reason + ')';
    }

    public ExtensionRequestFailure(w.K requestMetadata, boolean z10, long j10, int i10) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        this.requestMetadata = requestMetadata;
        this.wasImageCaptured = z10;
        this.frameNumber = j10;
        this.reason = i10;
    }
}
