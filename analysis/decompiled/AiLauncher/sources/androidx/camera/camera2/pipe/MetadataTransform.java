package androidx.camera.camera2.pipe;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/r;", "", "", "past", "future", "Landroidx/camera/camera2/pipe/r$b;", "transformFn", "<init>", "(IILandroidx/camera/camera2/pipe/r$b;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getPast", Const.INTENT_KEY_PKGNAME, "getFuture", "c", "Landroidx/camera/camera2/pipe/r$b;", "getTransformFn", "()Landroidx/camera/camera2/pipe/r$b;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: androidx.camera.camera2.pipe.r, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class MetadataTransform {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int past;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int future;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final b transformFn;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"androidx/camera/camera2/pipe/r$a", "Landroidx/camera/camera2/pipe/r$b;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.r$a */
    public static final class a implements b {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/r$b;", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.r$b */
    public interface b {
    }

    public MetadataTransform() {
        this(0, 0, null, 7, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataTransform)) {
            return false;
        }
        MetadataTransform metadataTransform = (MetadataTransform) other;
        return this.past == metadataTransform.past && this.future == metadataTransform.future && kotlin.jvm.internal.p.d(this.transformFn, metadataTransform.transformFn);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.past) * 31) + Integer.hashCode(this.future)) * 31) + this.transformFn.hashCode();
    }

    public String toString() {
        return "MetadataTransform(past=" + this.past + ", future=" + this.future + ", transformFn=" + this.transformFn + ')';
    }

    public MetadataTransform(int i10, int i11, b transformFn) {
        kotlin.jvm.internal.p.i(transformFn, "transformFn");
        this.past = i10;
        this.future = i11;
        this.transformFn = transformFn;
        if (i10 < 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i11 < 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public /* synthetic */ MetadataTransform(int i10, int i11, b bVar, int i12, kotlin.jvm.internal.i iVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? new a() : bVar);
    }
}
