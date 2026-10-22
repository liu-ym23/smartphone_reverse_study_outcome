package t;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Display;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;
import r.C5190h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010+¨\u0006-"}, d2 = {"Lt/Q;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "l", "()V", "Landroid/util/Size;", "k", "()Landroid/util/Size;", "", "skipStateOffDisplay", "Landroid/view/Display;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Z)Landroid/view/Display;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()[Landroid/view/Display;", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lr/o;", Const.INTENT_KEY_APIKEY, "Lr/o;", "maxPreviewSize", "Lr/h;", Const.INTENT_KEY_PKGNAME, "Lr/h;", "displaySizeCorrector", "c", "Ljava/lang/Object;", "lock", Const.INTENT_KEY_UMID, "[Landroid/view/Display;", "displays", "Landroid/hardware/display/DisplayManager$DisplayListener;", "e", "Landroid/hardware/display/DisplayManager$DisplayListener;", "displayListener", "Landroid/hardware/display/DisplayManager;", "Landroid/hardware/display/DisplayManager;", "displayManager", "Landroid/util/Size;", "previewSize", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Q {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    public static final Size f41843i = new Size(1920, 1080);

    /* renamed from: j, reason: collision with root package name */
    public static final Size f41844j = new Size(320, 240);

    /* renamed from: k, reason: collision with root package name */
    public static final Size f41845k = new Size(640, 480);

    /* renamed from: l, reason: collision with root package name */
    public static volatile Q f41846l;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final r.o maxPreviewSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5190h displaySizeCorrector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile Display[] displays;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final DisplayManager.DisplayListener displayListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final DisplayManager displayManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile Size previewSize;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lt/Q$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lt/Q;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lt/Q;", "Landroid/util/Size;", "MAX_PREVIEW_SIZE", "Landroid/util/Size;", "ABNORMAL_DISPLAY_SIZE_THRESHOLD", "FALLBACK_DISPLAY_SIZE", "instance", "Lt/Q;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: t.Q$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Q a(Context context) {
            Q q10;
            kotlin.jvm.internal.p.i(context, "context");
            Q q11 = Q.f41846l;
            if (q11 != null) {
                return q11;
            }
            synchronized (this) {
                q10 = Q.f41846l;
                if (q10 == null) {
                    Context contextF = M.e.f(context);
                    kotlin.jvm.internal.p.h(contextF, "getPersistentApplicationContext(...)");
                    q10 = new Q(contextF, null);
                    Q.f41846l = q10;
                }
            }
            return q10;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"t/Q$b", "Landroid/hardware/display/DisplayManager$DisplayListener;", "", "displayId", "LY8/t;", "onDisplayAdded", "(I)V", "onDisplayRemoved", "onDisplayChanged", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements DisplayManager.DisplayListener {
        public b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
            Object obj = Q.this.lock;
            Q q10 = Q.this;
            synchronized (obj) {
                q10.displays = null;
                q10.previewSize = null;
                Y8.t tVar = Y8.t.f7040a;
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            Object obj = Q.this.lock;
            Q q10 = Q.this;
            synchronized (obj) {
                q10.displays = null;
                q10.previewSize = null;
                Y8.t tVar = Y8.t.f7040a;
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
            Object obj = Q.this.lock;
            Q q10 = Q.this;
            synchronized (obj) {
                q10.displays = null;
                q10.previewSize = null;
                Y8.t tVar = Y8.t.f7040a;
            }
        }
    }

    public /* synthetic */ Q(Context context, kotlin.jvm.internal.i iVar) {
        this(context);
    }

    public static /* synthetic */ Display j(Q q10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return q10.i(z10);
    }

    public final Size f() {
        Size sizeG = g();
        Size size = f41843i;
        if (T.c.c(size, sizeG)) {
            sizeG = size;
        }
        return this.maxPreviewSize.a(sizeG);
    }

    public final Size g() {
        Point point = new Point();
        i(false).getRealSize(point);
        Size size = new Size(point.x, point.y);
        if (T.c.c(size, f41844j)) {
            Size sizeA = this.displaySizeCorrector.a();
            if (sizeA == null) {
                sizeA = f41845k;
            }
            size = sizeA;
        }
        return size.getHeight() > size.getWidth() ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    public final Display[] h() {
        synchronized (this.lock) {
            Display[] displayArr = this.displays;
            if (displayArr != null) {
                return displayArr;
            }
            Display[] displays = this.displayManager.getDisplays();
            this.displays = displays;
            kotlin.jvm.internal.p.f(displays);
            return displays;
        }
    }

    public final Display i(boolean skipStateOffDisplay) {
        Display[] displayArrH = h();
        if (displayArrH.length == 1) {
            return displayArrH[0];
        }
        int i10 = -1;
        Display display = null;
        Display display2 = null;
        int i11 = -1;
        for (Display display3 : displayArrH) {
            Point point = new Point();
            display3.getRealSize(point);
            int i12 = point.x;
            int i13 = point.y;
            if (i12 * i13 > i10) {
                display = display3;
                i10 = i12 * i13;
            }
            if (display3.getState() != 1) {
                int i14 = point.x;
                int i15 = point.y;
                if (i14 * i15 > i11) {
                    display2 = display3;
                    i11 = i14 * i15;
                }
            }
        }
        if (skipStateOffDisplay && display2 != null) {
            display = display2;
        }
        if (display != null) {
            return display;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No displays found from ");
        String string = Arrays.toString(displayArrH);
        kotlin.jvm.internal.p.h(string, "toString(...)");
        sb2.append(string);
        sb2.append('!');
        throw new IllegalStateException(sb2.toString().toString());
    }

    public final Size k() {
        synchronized (this.lock) {
            if (this.previewSize != null) {
                Size size = this.previewSize;
                kotlin.jvm.internal.p.g(size, "null cannot be cast to non-null type android.util.Size");
                return size;
            }
            this.previewSize = f();
            Size size2 = this.previewSize;
            kotlin.jvm.internal.p.f(size2);
            return size2;
        }
    }

    public final void l() {
        synchronized (this.lock) {
            this.previewSize = f();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Q(Context context) {
        this.maxPreviewSize = new r.o(null, 1, 0 == true ? 1 : 0);
        this.displaySizeCorrector = new C5190h();
        this.lock = new Object();
        b bVar = new b();
        this.displayListener = bVar;
        Object systemService = context.getSystemService("display");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager displayManager = (DisplayManager) systemService;
        displayManager.registerDisplayListener(bVar, new Handler(Looper.getMainLooper()));
        this.displayManager = displayManager;
    }
}
