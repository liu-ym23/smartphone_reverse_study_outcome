package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.SpecificationComputer;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5265b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5266c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f5267a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final int a(SidecarDeviceState r10) {
            q.g(r10, "sidecarDeviceState");
            return r10.posture;
        L5:
            Object r11 = SidecarDeviceState.class.getMethod("getPosture", null).invoke(r10, null);     // Catch: Throwable -> L11
            if (r11 == null) goto L10;
            return ((Integer) r11).intValue();
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L11
        L11:
            return 0;
        }

        public final int b(SidecarDeviceState r10) {
            q.g(r10, "sidecarDeviceState");
            int r11 = a(r10);
            if (r11 >= 0) goto L5;
        L6:
            return 0;
        L5:
            if (r11 > 4) goto L6;
            return r11;
        }

        public final List c(SidecarWindowLayoutInfo r10) {
            q.g(r10, ServerElements.INFO);
            List r11 = r10.displayFeatures;     // Catch: NoSuchFieldError -> L7
            if (r11 != null) goto L17;
            return t.i();
        L17:
            return r11;
        L7:
            Object r12 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(r10, null);     // Catch: Throwable -> L13
            if (r12 == null) goto L12;
            return (List) r12;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");     // Catch: Throwable -> L13
        L14:
            return t.i();
        }

        public final void d(SidecarDeviceState r10, int r11) {
            q.g(r10, "sidecarDeviceState");
            r10.posture = r11;     // Catch: NoSuchFieldError -> L5
            return;
        L5:
            SidecarDeviceState.class.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: Throwable -> L7
            return;
        }

        public a() {
        }
    }

    static {
        f5265b = new a(null);
        f5266c = SidecarAdapter.class.getSimpleName();
    }

    public SidecarAdapter(SpecificationComputer.VerificationMode r10) {
        q.g(r10, "verificationMode");
        this.f5267a = r10;
    }

    public final boolean a(SidecarDeviceState r10, SidecarDeviceState r11) {
        if (q.b(r10, r11) == false) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r11 != null) goto L10;
        return false;
    L10:
        a r12 = f5265b;
        if (r12.b(r10) != r12.b(r11)) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean b(SidecarDisplayFeature r10, SidecarDisplayFeature r11) {
        if (q.b(r10, r11) == false) goto L7;
        return true;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r11 != null) goto L12;
        return false;
    L12:
        if (r10.getType() == r11.getType()) goto L15;
        return false;
    L15:
        return q.b(r10.getRect(), r11.getRect());
    }

    public final boolean c(List r10, List r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r11 != null) goto L11;
        return false;
    L11:
        if (r10.size() == r11.size()) goto L13;
        return false;
    L13:
        int r12 = r10.size();
        int r13 = 0;
    L14:
        if (r13 >= r12) goto L19;
        int r14 = r13 + 1;
        if (b((SidecarDisplayFeature) r10.get(r13), (SidecarDisplayFeature) r11.get(r13)) == false) goto L17;
        r13 = r14;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public final boolean d(SidecarWindowLayoutInfo r10, SidecarWindowLayoutInfo r11) {
        if (q.b(r10, r11) == false) goto L7;
        return true;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r11 != null) goto L11;
        return false;
    L11:
        a r12 = f5265b;
        return c(r12.c(r10), r12.c(r11));
    }

    public final i e(SidecarWindowLayoutInfo r10, SidecarDeviceState r11) {
        q.g(r11, WsConstants.KEY_CONNECTION_STATE);
        if (r10 == null) goto L5;
        SidecarDeviceState r12 = new SidecarDeviceState();
        a r13 = f5265b;
        r13.d(r12, r13.b(r11));
        return new i(f(r13.c(r10), r12));
    L5:
        return new i(t.i());
    }

    public final List f(List r10, SidecarDeviceState r11) {
        q.g(r10, "sidecarDisplayFeatures");
        q.g(r11, "deviceState");
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        DisplayFeature r14 = g((SidecarDisplayFeature) r13.next(), r11);
        if (r14 == null) goto L4;
        r12.add(r14);
        goto L4
    L9:
        return r12;
    }

    public final DisplayFeature g(SidecarDisplayFeature r10, SidecarDeviceState r11) {
        q.g(r10, "feature");
        q.g(r11, "deviceState");
        SpecificationComputer.a r12 = SpecificationComputer.f5222a;
        String r13 = f5266c;
        q.f(r13, "TAG");
        SidecarDisplayFeature r14 = (SidecarDisplayFeature) SpecificationComputer.a.b(r12, r10, r13, this.f5267a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", SidecarAdapter$translate$checkedFeature$1.INSTANCE).c("Feature bounds must not be 0", SidecarAdapter$translate$checkedFeature$2.INSTANCE).c("TYPE_FOLD must have 0 area", SidecarAdapter$translate$checkedFeature$3.INSTANCE).c("Feature be pinned to either left or top", SidecarAdapter$translate$checkedFeature$4.INSTANCE).a();
        if (r14 != null) goto L5;
        return null;
    L5:
        int r15 = r14.getType();
        if (r15 == 1) goto L10;
        if (r15 == 2) goto L9;
        return null;
    L9:
        e.b r16 = e.b.f5311b.b();
    L11:
        int r17 = f5265b.b(r11);
        if (r17 == 0) goto L24;
        if (r17 == 1) goto L25;
        if (r17 != 2) goto L16;
        FoldingFeature.c r18 = FoldingFeature.c.f5261d;
    L22:
        Rect r19 = r10.getRect();
        q.f(r19, "feature.rect");
        return new e(new androidx.window.core.b(r19), r16, r18);
    L16:
        if (r17 != 3) goto L18;
        r18 = FoldingFeature.c.f5260c;
        goto L22
    L18:
        if (r17 == 4) goto L26;
        r18 = FoldingFeature.c.f5260c;
        goto L22
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L10:
        r16 = e.b.f5311b.a();
        goto L11
    }

    public /* synthetic */ SidecarAdapter(SpecificationComputer.VerificationMode r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = SpecificationComputer.VerificationMode.QUIET;
    L5:
        this(r10);
    }
}
