package C;

import La.C0951a;
import Z8.F;
import Z8.X;
import android.hardware.camera2.MultiResolutionImageReader;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.hardware.camera2.params.OutputConfiguration;
import android.media.Image;
import android.media.ImageReader;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.util.date.GMTDateParser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import p9.InterfaceC5074l;
import w.G;
import w.P;
import w.U;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0001:\u0001\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R/\u00106\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R/\u0010=\u001a\u0004\u0018\u0001072\b\u0010/\u001a\u0004\u0018\u0001078V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b8\u00101\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006?"}, d2 = {"LC/d;", "", "Landroid/media/ImageReader$OnImageAvailableListener;", "Landroid/media/ImageReader;", "reader", "LY8/t;", "onImageAvailable", "(Landroid/media/ImageReader;)V", "close", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Landroid/hardware/camera2/MultiResolutionImageReader;", Const.INTENT_KEY_APIKEY, "Landroid/hardware/camera2/MultiResolutionImageReader;", "multiResolutionImageReader", "Lw/P;", Const.INTENT_KEY_PKGNAME, "I", "streamFormat", "Lw/Q;", "c", "streamId", "", "Landroid/hardware/camera2/params/OutputConfiguration;", Const.INTENT_KEY_UMID, "Ljava/util/List;", "u1", "()Ljava/util/List;", "outputConfigurations", "", "Landroid/hardware/camera2/params/MultiResolutionStreamInfo;", "Lw/G;", "e", "Ljava/util/Map;", "streamInfoToOutputIdMap", "", "f", "Z", "concurrentOutputsEnabled", "LC/k;", "<set-?>", Const.INTENT_KEY_BACKGROUND_COMMAND, "LOa/e;", "t1", "()LC/k;", "setOnImageListener", "(LC/k;)V", "onImageListener", "LC/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "s1", "()LC/j;", "setOnExpectedOutputsListener", "(LC/j;)V", "onExpectedOutputsListener", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements U, AutoCloseable, ImageReader.OnImageAvailableListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final MultiResolutionImageReader multiResolutionImageReader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int streamFormat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int streamId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<OutputConfiguration> outputConfigurations;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<MultiResolutionStreamInfo, G> streamInfoToOutputIdMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean concurrentOutputsEnabled;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Oa.e onImageListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Oa.e onExpectedOutputsListener;

    public static final CharSequence v1(MultiResolutionStreamInfo it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getPhysicalCameraId() + ":w" + it.getWidth() + GMTDateParser.HOURS + it.getHeight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, t.b(d.class))) {
            return this;
        }
        if (kotlin.jvm.internal.p.d(type, t.b(MultiResolutionImageReader.class))) {
            return (T) this.multiResolutionImageReader;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.multiResolutionImageReader.close();
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader reader) {
        j jVarS1;
        Image imageAcquireNextImage = reader != null ? reader.acquireNextImage() : null;
        if (imageAcquireNextImage != null) {
            k kVarT1 = t1();
            if (kVarT1 == null) {
                imageAcquireNextImage.close();
                return;
            }
            MultiResolutionStreamInfo streamInfoForImageReader = this.multiResolutionImageReader.getStreamInfoForImageReader(reader);
            kotlin.jvm.internal.p.h(streamInfoForImageReader, "getStreamInfoForImageReader(...)");
            G g10 = this.streamInfoToOutputIdMap.get(streamInfoForImageReader);
            if (g10 != null) {
                int value = g10.getValue();
                if (!this.concurrentOutputsEnabled && (jVarS1 = s1()) != null) {
                    jVarS1.a(imageAcquireNextImage.getTimestamp(), X.d(G.a(value)));
                }
                kVarT1.a(this.streamId, value, new a(imageAcquireNextImage));
                return;
            }
            throw new IllegalStateException((this + ": Failed to find OutputId for " + reader + " based on streamInfo " + streamInfoForImageReader + '!').toString());
        }
    }

    public j s1() {
        return (j) this.onExpectedOutputsListener.c();
    }

    public k t1() {
        return (k) this.onImageListener.c();
    }

    public String toString() {
        String strA0 = F.A0(this.streamInfoToOutputIdMap.keySet(), null, "[", "]", 0, null, new InterfaceC5074l() { // from class: C.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return d.v1((MultiResolutionStreamInfo) obj);
            }
        }, 25, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MultiResolutionImageReader@");
        String string = Integer.toString(super.hashCode(), C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        sb2.append(string);
        sb2.append('-');
        sb2.append(P.g(this.streamFormat));
        sb2.append('-');
        sb2.append(strA0);
        return sb2.toString();
    }

    public final List<OutputConfiguration> u1() {
        return this.outputConfigurations;
    }
}
