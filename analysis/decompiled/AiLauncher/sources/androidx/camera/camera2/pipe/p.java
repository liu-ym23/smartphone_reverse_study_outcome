package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.k;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0007R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/p;", "", "Lw/E;", Const.INTENT_KEY_UMID, "()I", "id", "", Const.INTENT_KEY_APIKEY, "maxImages", "Lw/P;", "c", "format", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface p {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\n\u0010\u000fR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/p$a;", "", "Landroidx/camera/camera2/pipe/k$a;", "stream", "", "maxImages", "Lw/P;", "streamFormat", "<init>", "(Landroidx/camera/camera2/pipe/k$a;IILkotlin/jvm/internal/i;)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/k$a;", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/camera2/pipe/k$a;", "I", "()I", "c", "setStreamFormat-hNQ4ISI", "(I)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final k.a stream;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int maxImages;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int streamFormat;

        public /* synthetic */ a(k.a aVar, int i10, int i11, kotlin.jvm.internal.i iVar) {
            this(aVar, i10, i11);
        }

        /* renamed from: a, reason: from getter */
        public final int getMaxImages() {
            return this.maxImages;
        }

        /* renamed from: b, reason: from getter */
        public final k.a getStream() {
            return this.stream;
        }

        /* renamed from: c, reason: from getter */
        public final int getStreamFormat() {
            return this.streamFormat;
        }

        public a(k.a stream, int i10, int i11) {
            kotlin.jvm.internal.p.i(stream, "stream");
            this.stream = stream;
            this.maxImages = i10;
            this.streamFormat = i11;
        }
    }

    int a();

    int c();

    int d();
}
