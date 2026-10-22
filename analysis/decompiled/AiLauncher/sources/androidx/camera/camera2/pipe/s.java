package androidx.camera.camera2.pipe;

import Z8.C1173v;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import w.C5708n;
import w.P;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\b-\u001d\u0012%\u0015\n\u0003)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u0004\u0018\u00010,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/s;", "", "", "f", "()Z", "Landroidx/camera/camera2/pipe/k;", "k", "()Landroidx/camera/camera2/pipe/k;", "stream", "Lw/G;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", "id", "Landroid/util/Size;", "getSize", "()Landroid/util/Size;", ContentDisposition.Parameters.Size, "Lw/P;", "c", "format", "Lw/n;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", C3081a.CAMERA_FOCUS, "Landroidx/camera/camera2/pipe/s$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", Const.INTENT_KEY_UMID, "()Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "Landroidx/camera/camera2/pipe/s$d;", "e", "()Landroidx/camera/camera2/pipe/s$d;", "outputType", "Landroidx/camera/camera2/pipe/s$g;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/camera2/pipe/s$g;", "streamUseHint", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface s {

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 22\u00020\u0001:\u0004\u001a# \u001eBc\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b \u0010\"\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u001e\u0010(R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b*\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b-\u0010/\u001a\u0004\b&\u00100R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103\u0082\u0001\u0003456¨\u00067"}, d2 = {"Landroidx/camera/camera2/pipe/s$a;", "", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Lw/P;", "format", "Lw/n;", C3081a.CAMERA_FOCUS, "Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "Landroidx/camera/camera2/pipe/s$g;", "streamUseHint", "", "Landroidx/camera/camera2/pipe/s$e;", "sensorPixelModes", "<init>", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/s$c;Landroidx/camera/camera2/pipe/s$h;Landroidx/camera/camera2/pipe/s$b;Landroidx/camera/camera2/pipe/s$f;Landroidx/camera/camera2/pipe/s$g;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/util/Size;", "f", "()Landroid/util/Size;", Const.INTENT_KEY_PKGNAME, "I", "c", "()I", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/pipe/s$c;", "()Landroidx/camera/camera2/pipe/s$c;", "e", "Landroidx/camera/camera2/pipe/s$b;", "()Landroidx/camera/camera2/pipe/s$b;", "Landroidx/camera/camera2/pipe/s$f;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroidx/camera/camera2/pipe/s$f;", "Landroidx/camera/camera2/pipe/s$g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/camera/camera2/pipe/s$g;", "Ljava/util/List;", "()Ljava/util/List;", "Landroidx/camera/camera2/pipe/s$h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroidx/camera/camera2/pipe/s$h;", "Landroidx/camera/camera2/pipe/s$a$b;", "Landroidx/camera/camera2/pipe/s$a$c;", "Landroidx/camera/camera2/pipe/s$a$d;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class a {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Size size;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int format;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final String camera;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final c mirrorMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final b dynamicRangeProfile;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final f streamUseCase;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final g streamUseHint;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final List<e> sensorPixelModes;

        @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u007f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u001c*\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/pipe/s$a$a;", "", "<init>", "()V", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Lw/P;", "format", "Lw/n;", C3081a.CAMERA_FOCUS, "Landroidx/camera/camera2/pipe/s$d;", "outputType", "Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "Landroidx/camera/camera2/pipe/s$g;", "streamUseHint", "", "Landroidx/camera/camera2/pipe/s$e;", "sensorPixelModes", "Landroidx/camera/camera2/pipe/s$a;", Const.INTENT_KEY_APIKEY, "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/s$d;Landroidx/camera/camera2/pipe/s$c;Landroidx/camera/camera2/pipe/s$h;Landroidx/camera/camera2/pipe/s$b;Landroidx/camera/camera2/pipe/s$f;Landroidx/camera/camera2/pipe/s$g;Ljava/util/List;)Landroidx/camera/camera2/pipe/s$a;", "", "c", "(Landroidx/camera/camera2/pipe/s$d;)Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.s$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ a b(Companion companion, Size size, int i10, String str, d dVar, c cVar, h hVar, b bVar, f fVar, g gVar, List list, int i11, Object obj) {
                if ((i11 & 4) != 0) {
                    str = null;
                }
                if ((i11 & 8) != 0) {
                    dVar = d.INSTANCE.c();
                }
                if ((i11 & 16) != 0) {
                    cVar = null;
                }
                if ((i11 & 32) != 0) {
                    hVar = null;
                }
                if ((i11 & 64) != 0) {
                    bVar = null;
                }
                if ((i11 & 128) != 0) {
                    fVar = null;
                }
                if ((i11 & 256) != 0) {
                    gVar = null;
                }
                if ((i11 & 512) != 0) {
                    list = C1173v.m();
                }
                return companion.a(size, i10, str, dVar, cVar, hVar, bVar, fVar, gVar, list);
            }

            public final a a(Size size, int format, String camera, d outputType, c mirrorMode, h timestampBase, b dynamicRangeProfile, f streamUseCase, g streamUseHint, List<e> sensorPixelModes) {
                kotlin.jvm.internal.p.i(size, "size");
                kotlin.jvm.internal.p.i(outputType, "outputType");
                kotlin.jvm.internal.p.i(sensorPixelModes, "sensorPixelModes");
                if (c(outputType)) {
                    return new c(size, format, camera, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, sensorPixelModes, null);
                }
                if (kotlin.jvm.internal.p.d(outputType, d.INSTANCE.c())) {
                    return new d(size, format, camera, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, sensorPixelModes, null);
                }
                throw new IllegalStateException("Check failed.");
            }

            public final boolean c(d dVar) {
                d.Companion companion = d.INSTANCE;
                if (kotlin.jvm.internal.p.d(dVar, companion.e()) || kotlin.jvm.internal.p.d(dVar, companion.f())) {
                    return true;
                }
                return (kotlin.jvm.internal.p.d(dVar, companion.a()) || kotlin.jvm.internal.p.d(dVar, companion.b())) && Build.VERSION.SDK_INT >= 35;
            }

            public Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/s$a$b;", "Landroidx/camera/camera2/pipe/s$a;", "Landroid/hardware/camera2/params/OutputConfiguration;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/hardware/camera2/params/OutputConfiguration;", "()Landroid/hardware/camera2/params/OutputConfiguration;", "output", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b extends a {

            /* renamed from: j, reason: collision with root package name and from kotlin metadata */
            public final OutputConfiguration output;

            /* renamed from: j, reason: from getter */
            public final OutputConfiguration getOutput() {
                return this.output;
            }
        }

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/camera/camera2/pipe/s$a$c;", "Landroidx/camera/camera2/pipe/s$a;", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Lw/P;", "format", "Lw/n;", C3081a.CAMERA_FOCUS, "Landroidx/camera/camera2/pipe/s$d;", "outputType", "Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "Landroidx/camera/camera2/pipe/s$g;", "streamUseHint", "", "Landroidx/camera/camera2/pipe/s$e;", "sensorPixelModes", "<init>", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/s$d;Landroidx/camera/camera2/pipe/s$c;Landroidx/camera/camera2/pipe/s$h;Landroidx/camera/camera2/pipe/s$b;Landroidx/camera/camera2/pipe/s$f;Landroidx/camera/camera2/pipe/s$g;Ljava/util/List;Lkotlin/jvm/internal/i;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroidx/camera/camera2/pipe/s$d;", "()Landroidx/camera/camera2/pipe/s$d;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class c extends a {

            /* renamed from: j, reason: collision with root package name and from kotlin metadata */
            public final d outputType;

            public /* synthetic */ c(Size size, int i10, String str, d dVar, c cVar, h hVar, b bVar, f fVar, g gVar, List list, kotlin.jvm.internal.i iVar) {
                this(size, i10, str, dVar, cVar, hVar, bVar, fVar, gVar, list);
            }

            /* renamed from: j, reason: from getter */
            public final d getOutputType() {
                return this.outputType;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Size size, int i10, String str, d outputType, c cVar, h hVar, b bVar, f fVar, g gVar, List<e> sensorPixelModes) {
                super(size, i10, str, cVar, hVar, bVar, fVar, gVar, sensorPixelModes, null);
                kotlin.jvm.internal.p.i(size, "size");
                kotlin.jvm.internal.p.i(outputType, "outputType");
                kotlin.jvm.internal.p.i(sensorPixelModes, "sensorPixelModes");
                this.outputType = outputType;
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/s$a$d;", "Landroidx/camera/camera2/pipe/s$a;", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Lw/P;", "format", "Lw/n;", C3081a.CAMERA_FOCUS, "Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "Landroidx/camera/camera2/pipe/s$g;", "streamUseHint", "", "Landroidx/camera/camera2/pipe/s$e;", "sensorPixelModes", "<init>", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/s$c;Landroidx/camera/camera2/pipe/s$h;Landroidx/camera/camera2/pipe/s$b;Landroidx/camera/camera2/pipe/s$f;Landroidx/camera/camera2/pipe/s$g;Ljava/util/List;Lkotlin/jvm/internal/i;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class d extends a {
            public /* synthetic */ d(Size size, int i10, String str, c cVar, h hVar, b bVar, f fVar, g gVar, List list, kotlin.jvm.internal.i iVar) {
                this(size, i10, str, cVar, hVar, bVar, fVar, gVar, list);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Size size, int i10, String str, c cVar, h hVar, b bVar, f fVar, g gVar, List<e> sensorPixelModes) {
                super(size, i10, str, cVar, hVar, bVar, fVar, gVar, sensorPixelModes, null);
                kotlin.jvm.internal.p.i(size, "size");
                kotlin.jvm.internal.p.i(sensorPixelModes, "sensorPixelModes");
            }
        }

        public /* synthetic */ a(Size size, int i10, String str, c cVar, h hVar, b bVar, f fVar, g gVar, List list, kotlin.jvm.internal.i iVar) {
            this(size, i10, str, cVar, hVar, bVar, fVar, gVar, list);
        }

        /* renamed from: a, reason: from getter */
        public final String getCamera() {
            return this.camera;
        }

        /* renamed from: b, reason: from getter */
        public final b getDynamicRangeProfile() {
            return this.dynamicRangeProfile;
        }

        /* renamed from: c, reason: from getter */
        public final int getFormat() {
            return this.format;
        }

        /* renamed from: d, reason: from getter */
        public final c getMirrorMode() {
            return this.mirrorMode;
        }

        public final List<e> e() {
            return this.sensorPixelModes;
        }

        /* renamed from: f, reason: from getter */
        public final Size getSize() {
            return this.size;
        }

        /* renamed from: g, reason: from getter */
        public final f getStreamUseCase() {
            return this.streamUseCase;
        }

        /* renamed from: h, reason: from getter */
        public final g getStreamUseHint() {
            return this.streamUseHint;
        }

        public final h i() {
            return null;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Config(size=");
            sb2.append(this.size);
            sb2.append(", format=");
            sb2.append((Object) P.i(this.format));
            sb2.append(", camera=");
            String str = this.camera;
            sb2.append((Object) (str == null ? "null" : C5708n.f(str)));
            sb2.append(", mirrorMode=");
            sb2.append(this.mirrorMode);
            sb2.append(", timestampBase=");
            sb2.append((Object) null);
            sb2.append(", dynamicRangeProfile=");
            sb2.append(this.dynamicRangeProfile);
            sb2.append(", streamUseCase=");
            sb2.append(this.streamUseCase);
            sb2.append(", streamUseHint=");
            sb2.append(this.streamUseHint);
            sb2.append(", sensorPixelModes=");
            sb2.append(this.sensorPixelModes);
            sb2.append(')');
            return sb2.toString();
        }

        public a(Size size, int i10, String str, c cVar, h hVar, b bVar, f fVar, g gVar, List<e> sensorPixelModes) {
            kotlin.jvm.internal.p.i(size, "size");
            kotlin.jvm.internal.p.i(sensorPixelModes, "sensorPixelModes");
            this.size = size;
            this.format = i10;
            this.camera = str;
            this.mirrorMode = cVar;
            this.dynamicRangeProfile = bVar;
            this.streamUseCase = fVar;
            this.streamUseHint = gVar;
            this.sensorPixelModes = sensorPixelModes;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/pipe/s$b;", "", "", UxipConstants.f30680s, "c", "(J)J", "", "f", "(J)Ljava/lang/String;", "", "e", "(J)I", "other", "", Const.INTENT_KEY_UMID, "(JLjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "getValue", "()J", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final long f11087c = c(1);

        /* renamed from: d, reason: collision with root package name */
        public static final long f11088d = c(2);

        /* renamed from: e, reason: collision with root package name */
        public static final long f11089e = c(4);

        /* renamed from: f, reason: collision with root package name */
        public static final long f11090f = c(8);

        /* renamed from: g, reason: collision with root package name */
        public static final long f11091g = c(16);

        /* renamed from: h, reason: collision with root package name */
        public static final long f11092h = c(32);

        /* renamed from: i, reason: collision with root package name */
        public static final long f11093i = c(64);

        /* renamed from: j, reason: collision with root package name */
        public static final long f11094j = c(128);

        /* renamed from: k, reason: collision with root package name */
        public static final long f11095k = c(256);

        /* renamed from: l, reason: collision with root package name */
        public static final long f11096l = c(512);

        /* renamed from: m, reason: collision with root package name */
        public static final long f11097m = c(1024);

        /* renamed from: n, reason: collision with root package name */
        public static final long f11098n = c(2048);

        /* renamed from: o, reason: collision with root package name */
        public static final long f11099o = c(4096);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/s$b$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/s$b;", "STANDARD", "J", Const.INTENT_KEY_APIKEY, "()J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.s$b$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final long a() {
                return b.f11087c;
            }

            public Companion() {
            }
        }

        public /* synthetic */ b(long j10) {
            this.value = j10;
        }

        public static final /* synthetic */ b b(long j10) {
            return new b(j10);
        }

        public static long c(long j10) {
            return j10;
        }

        public static boolean d(long j10, Object obj) {
            return (obj instanceof b) && j10 == ((b) obj).getValue();
        }

        public static int e(long j10) {
            return Long.hashCode(j10);
        }

        public static String f(long j10) {
            return "DynamicRangeProfile(value=" + j10 + ')';
        }

        public boolean equals(Object obj) {
            return d(this.value, obj);
        }

        /* renamed from: g, reason: from getter */
        public final /* synthetic */ long getValue() {
            return this.value;
        }

        public int hashCode() {
            return e(this.value);
        }

        public String toString() {
            return f(this.value);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00042\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/s$c;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(I)I", "", "e", "(I)Ljava/lang/String;", Const.INTENT_KEY_UMID, "other", "", "c", "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final int f11102c = b(0);

        /* renamed from: d, reason: collision with root package name */
        public static final int f11103d = b(1);

        /* renamed from: e, reason: collision with root package name */
        public static final int f11104e = b(2);

        /* renamed from: f, reason: collision with root package name */
        public static final int f11105f = b(3);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int value;

        public /* synthetic */ c(int i10) {
            this.value = i10;
        }

        public static final /* synthetic */ c a(int i10) {
            return new c(i10);
        }

        public static int b(int i10) {
            return i10;
        }

        public static boolean c(int i10, Object obj) {
            return (obj instanceof c) && i10 == ((c) obj).getValue();
        }

        public static int d(int i10) {
            return Integer.hashCode(i10);
        }

        public static String e(int i10) {
            return "MirrorMode(value=" + i10 + ')';
        }

        public boolean equals(Object obj) {
            return c(this.value, obj);
        }

        /* renamed from: f, reason: from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        public int hashCode() {
            return d(this.value);
        }

        public String toString() {
            return e(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/pipe/s$d;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        public static final d f11108b = new d();

        /* renamed from: c, reason: collision with root package name */
        public static final d f11109c = new d();

        /* renamed from: d, reason: collision with root package name */
        public static final d f11110d = new d();

        /* renamed from: e, reason: collision with root package name */
        public static final d f11111e = new d();

        /* renamed from: f, reason: collision with root package name */
        public static final d f11112f = new d();

        /* renamed from: g, reason: collision with root package name */
        public static final d f11113g = new d();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/s$d$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/s$d;", "SURFACE", "Landroidx/camera/camera2/pipe/s$d;", "c", "()Landroidx/camera/camera2/pipe/s$d;", "SURFACE_VIEW", "f", "SURFACE_TEXTURE", "e", "SURFACE_DEFERRED_FOR_QUERY_ONLY", Const.INTENT_KEY_UMID, "MEDIA_CODEC", Const.INTENT_KEY_APIKEY, "MEDIA_RECORDER", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.s$d$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final d a() {
                return d.f11112f;
            }

            public final d b() {
                return d.f11113g;
            }

            public final d c() {
                return d.f11108b;
            }

            public final d d() {
                return d.f11111e;
            }

            public final d e() {
                return d.f11110d;
            }

            public final d f() {
                return d.f11109c;
            }

            public Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/s$e;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(I)I", "", Const.INTENT_KEY_UMID, "(I)Ljava/lang/String;", "c", "other", "", Const.INTENT_KEY_PKGNAME, "(ILjava/lang/Object;)Z", "I", "getValue", "()I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e {

        /* renamed from: c, reason: collision with root package name */
        public static final int f11115c = a(0);

        /* renamed from: d, reason: collision with root package name */
        public static final int f11116d = a(1);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int value;

        public static int a(int i10) {
            return i10;
        }

        public static boolean b(int i10, Object obj) {
            return (obj instanceof e) && i10 == ((e) obj).getValue();
        }

        public static int c(int i10) {
            return Integer.hashCode(i10);
        }

        public static String d(int i10) {
            return "SensorPixelMode(value=" + i10 + ')';
        }

        /* renamed from: e, reason: from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            return b(this.value, obj);
        }

        public int hashCode() {
            return c(this.value);
        }

        public String toString() {
            return d(this.value);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/pipe/s$f;", "", "", UxipConstants.f30680s, "e", "(J)J", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)Ljava/lang/String;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(J)I", "other", "", "f", "(JLjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "getValue", "()J", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final long f11119c = e(0);

        /* renamed from: d, reason: collision with root package name */
        public static final long f11120d = e(1);

        /* renamed from: e, reason: collision with root package name */
        public static final long f11121e = e(2);

        /* renamed from: f, reason: collision with root package name */
        public static final long f11122f = e(3);

        /* renamed from: g, reason: collision with root package name */
        public static final long f11123g = e(4);

        /* renamed from: h, reason: collision with root package name */
        public static final long f11124h = e(5);

        /* renamed from: i, reason: collision with root package name */
        public static final long f11125i = e(6);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/s$f$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/s$f;", "DEFAULT", "J", Const.INTENT_KEY_APIKEY, "()J", "PREVIEW", Const.INTENT_KEY_PKGNAME, "VIDEO_RECORD", "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.s$f$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final long a() {
                return f.f11119c;
            }

            public final long b() {
                return f.f11120d;
            }

            public final long c() {
                return f.f11122f;
            }

            public Companion() {
            }
        }

        public /* synthetic */ f(long j10) {
            this.value = j10;
        }

        public static final /* synthetic */ f d(long j10) {
            return new f(j10);
        }

        public static long e(long j10) {
            return j10;
        }

        public static boolean f(long j10, Object obj) {
            return (obj instanceof f) && j10 == ((f) obj).getValue();
        }

        public static final boolean g(long j10, long j11) {
            return j10 == j11;
        }

        public static int h(long j10) {
            return Long.hashCode(j10);
        }

        public static String i(long j10) {
            return "StreamUseCase(value=" + j10 + ')';
        }

        public boolean equals(Object obj) {
            return f(this.value, obj);
        }

        public int hashCode() {
            return h(this.value);
        }

        /* renamed from: j, reason: from getter */
        public final /* synthetic */ long getValue() {
            return this.value;
        }

        public String toString() {
            return i(this.value);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/pipe/s$g;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(J)J", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(J)Ljava/lang/String;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(J)I", "other", "", "e", "(JLjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "getValue", "()J", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final long f11128c = d(0);

        /* renamed from: d, reason: collision with root package name */
        public static final long f11129d = d(1);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/s$g$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/s$g;", "DEFAULT", "J", Const.INTENT_KEY_APIKEY, "()J", "VIDEO_RECORD", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.s$g$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final long a() {
                return g.f11128c;
            }

            public final long b() {
                return g.f11129d;
            }

            public Companion() {
            }
        }

        public /* synthetic */ g(long j10) {
            this.value = j10;
        }

        public static final /* synthetic */ g c(long j10) {
            return new g(j10);
        }

        public static long d(long j10) {
            return j10;
        }

        public static boolean e(long j10, Object obj) {
            return (obj instanceof g) && j10 == ((g) obj).getValue();
        }

        public static final boolean f(long j10, long j11) {
            return j10 == j11;
        }

        public static int g(long j10) {
            return Long.hashCode(j10);
        }

        public static String h(long j10) {
            return "StreamUseHint(value=" + j10 + ')';
        }

        public boolean equals(Object obj) {
            return e(this.value, obj);
        }

        public int hashCode() {
            return g(this.value);
        }

        /* renamed from: i, reason: from getter */
        public final /* synthetic */ long getValue() {
            return this.value;
        }

        public String toString() {
            return h(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/s$h;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(I)I", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        public static final int f11132b = b(0);

        /* renamed from: c, reason: collision with root package name */
        public static final int f11133c = b(1);

        /* renamed from: d, reason: collision with root package name */
        public static final int f11134d = b(2);

        /* renamed from: e, reason: collision with root package name */
        public static final int f11135e = b(3);

        /* renamed from: f, reason: collision with root package name */
        public static final int f11136f = b(4);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/s$h$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/s$h;", "TIMESTAMP_BASE_REALTIME", "I", Const.INTENT_KEY_APIKEY, "()I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.s$h$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final int a() {
                return h.f11135e;
            }

            public Companion() {
            }
        }

        public static int b(int i10) {
            return i10;
        }
    }

    /* renamed from: a */
    g getStreamUseHint();

    /* renamed from: b */
    String getCamera();

    /* renamed from: c */
    int getFormat();

    h d();

    /* renamed from: e */
    d getOutputType();

    default boolean f() {
        if (getStreamUseCase() == null) {
            return true;
        }
        f fVarH = getStreamUseCase();
        f.Companion companion = f.INSTANCE;
        if (fVarH == null ? false : f.g(fVarH.getValue(), companion.a())) {
            return true;
        }
        f fVarH2 = getStreamUseCase();
        if (fVarH2 == null ? false : f.g(fVarH2.getValue(), companion.b())) {
            return true;
        }
        f fVarH3 = getStreamUseCase();
        if ((fVarH3 == null ? false : f.g(fVarH3.getValue(), companion.c())) || getStreamUseHint() == null) {
            return true;
        }
        g gVarA = getStreamUseHint();
        g.Companion companion2 = g.INSTANCE;
        if (gVarA == null ? false : g.f(gVarA.getValue(), companion2.a())) {
            return true;
        }
        g gVarA2 = getStreamUseHint();
        return gVarA2 == null ? false : g.f(gVarA2.getValue(), companion2.b());
    }

    /* renamed from: g */
    int getId();

    Size getSize();

    /* renamed from: h */
    f getStreamUseCase();

    /* renamed from: i */
    c getMirrorMode();

    /* renamed from: j */
    b getDynamicRangeProfile();

    k k();
}
