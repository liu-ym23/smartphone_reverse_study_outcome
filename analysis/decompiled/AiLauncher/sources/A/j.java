package A;

import android.hardware.camera2.CaptureRequest;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.C5713t;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0097\u0001\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"LA/j;", "", "<init>", "()V", "Lw/a;", "aeMode", "Lw/b;", "afMode", "Lw/c;", "awbMode", "Lw/t;", "flashMode", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "aeRegions", "afRegions", "awbRegions", "", "aeLock", "afLock", "awbLock", "LY8/t;", "c", "(Lw/a;Lw/b;Lw/c;Lw/t;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "", "Landroid/hardware/camera2/CaptureRequest$Key;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "LOa/e;", "LA/p;", Const.INTENT_KEY_APIKEY, "LOa/e;", "_state", UxipConstants.f30680s, "()LA/p;", "setCurrent", "(LA/p;)V", "current", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<State3A> _state = Oa.b.g(new State3A(null, null, null, null, null, null, null, null, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null));

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(j jVar, C5695a c5695a, C5696b c5696b, C5697c c5697c, C5713t c5713t, List list, List list2, List list3, Boolean bool, Boolean bool2, Boolean bool3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c5695a = null;
        }
        if ((i10 & 2) != 0) {
            c5696b = null;
        }
        if ((i10 & 4) != 0) {
            c5697c = null;
        }
        if ((i10 & 8) != 0) {
            c5713t = null;
        }
        if ((i10 & 16) != 0) {
            list = null;
        }
        if ((i10 & 32) != 0) {
            list2 = null;
        }
        if ((i10 & 64) != 0) {
            list3 = null;
        }
        if ((i10 & 128) != 0) {
            bool = null;
        }
        if ((i10 & 256) != 0) {
            bool2 = null;
        }
        if ((i10 & 512) != 0) {
            bool3 = null;
        }
        jVar.c(c5695a, c5696b, c5697c, c5713t, list, list2, list3, bool, bool2, bool3);
    }

    public final State3A a() {
        return this._state.c();
    }

    public final Map<CaptureRequest.Key<?>, Object> b() {
        return k.a(a());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(w.C5695a r14, w.C5696b r15, w.C5697c r16, w.C5713t r17, java.util.List<android.hardware.camera2.params.MeteringRectangle> r18, java.util.List<android.hardware.camera2.params.MeteringRectangle> r19, java.util.List<android.hardware.camera2.params.MeteringRectangle> r20, java.lang.Boolean r21, java.lang.Boolean r22, java.lang.Boolean r23) {
        /*
            r13 = this;
            Oa.e<A.p> r13 = r13._state
        L2:
            java.lang.Object r0 = r13.c()
            r1 = r0
            A.p r1 = (A.State3A) r1
            if (r14 != 0) goto L10
            w.a r2 = r1.getAeMode()
            goto L11
        L10:
            r2 = r14
        L11:
            if (r15 != 0) goto L18
            w.b r3 = r1.getAfMode()
            goto L19
        L18:
            r3 = r15
        L19:
            if (r16 != 0) goto L20
            w.c r4 = r1.getAwbMode()
            goto L22
        L20:
            r4 = r16
        L22:
            if (r17 != 0) goto L29
            w.t r5 = r1.getFlashMode()
            goto L2b
        L29:
            r5 = r17
        L2b:
            r6 = 0
            if (r18 == 0) goto L3d
            r7 = r18
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L39
            r7 = r6
        L39:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L41
        L3d:
            java.util.List r7 = r1.d()
        L41:
            if (r19 == 0) goto L52
            r8 = r19
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r9 = r8.isEmpty()
            if (r9 == 0) goto L4e
            r8 = r6
        L4e:
            java.util.List r8 = (java.util.List) r8
            if (r8 != 0) goto L56
        L52:
            java.util.List r8 = r1.g()
        L56:
            if (r20 == 0) goto L68
            r9 = r20
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r10 = r9.isEmpty()
            if (r10 == 0) goto L63
            goto L64
        L63:
            r6 = r9
        L64:
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L6c
        L68:
            java.util.List r6 = r1.j()
        L6c:
            if (r21 != 0) goto L73
            java.lang.Boolean r9 = r1.getAeLock()
            goto L75
        L73:
            r9 = r21
        L75:
            if (r22 != 0) goto L7c
            java.lang.Boolean r10 = r1.getAfLock()
            goto L7e
        L7c:
            r10 = r22
        L7e:
            if (r23 != 0) goto L89
            java.lang.Boolean r11 = r1.getAwbLock()
            r12 = r8
            r8 = r6
            r6 = r7
            r7 = r12
            goto L8f
        L89:
            r11 = r8
            r8 = r6
            r6 = r7
            r7 = r11
            r11 = r23
        L8f:
            A.p r1 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = r13.a(r0, r1)
            if (r0 == 0) goto L2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: A.j.c(w.a, w.b, w.c, w.t, java.util.List, java.util.List, java.util.List, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean):void");
    }
}
