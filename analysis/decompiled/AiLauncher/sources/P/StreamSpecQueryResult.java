package P;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.y;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0018"}, d2 = {"LP/h;", "", "", "Landroidx/camera/core/UseCase;", "Landroidx/camera/core/impl/y;", "streamSpecs", "", "maxSupportedFrameRate", "<init>", "(Ljava/util/Map;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "I", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: P.h, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class StreamSpecQueryResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<UseCase, y> streamSpecs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxSupportedFrameRate;

    /* JADX WARN: Multi-variable type inference failed */
    public StreamSpecQueryResult() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getMaxSupportedFrameRate() {
        return this.maxSupportedFrameRate;
    }

    public final Map<UseCase, y> b() {
        return this.streamSpecs;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamSpecQueryResult)) {
            return false;
        }
        StreamSpecQueryResult streamSpecQueryResult = (StreamSpecQueryResult) other;
        return p.d(this.streamSpecs, streamSpecQueryResult.streamSpecs) && this.maxSupportedFrameRate == streamSpecQueryResult.maxSupportedFrameRate;
    }

    public int hashCode() {
        return (this.streamSpecs.hashCode() * 31) + Integer.hashCode(this.maxSupportedFrameRate);
    }

    public String toString() {
        return "StreamSpecQueryResult(streamSpecs=" + this.streamSpecs + ", maxSupportedFrameRate=" + this.maxSupportedFrameRate + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreamSpecQueryResult(Map<UseCase, ? extends y> streamSpecs, int i10) {
        p.i(streamSpecs, "streamSpecs");
        this.streamSpecs = streamSpecs;
        this.maxSupportedFrameRate = i10;
    }

    public /* synthetic */ StreamSpecQueryResult(Map map, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? kotlin.collections.a.i() : map, (i11 & 2) != 0 ? Integer.MAX_VALUE : i10);
    }
}
