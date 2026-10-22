package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0208a f16992c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16993d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f16994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16995b;

    /* JADX INFO: renamed from: com.obric.oui.slider.a$a, reason: collision with other inner class name */
    public static final class C0208a {
        public /* synthetic */ C0208a(DefaultConstructorMarker r10) {
            this();
        }

        public C0208a() {
        }
    }

    static {
        f16992c = new C0208a(null);
        f16993d = "SeekBarVibrateHelper";
    }

    public a() {
        this.f16995b = Channel.UNLIMITED;
    }

    public static /* synthetic */ void c(a r10, Context r11, int r12, String r13, boolean r14, View r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = true;
    L5:
        boolean r18 = r14;
        if ((r16 & 16) == 0) goto L8;
        r15 = null;
    L8:
        r10.b(r11, r12, r13, r18, r15);
    }

    public final void a(Context r15, SeekBar r16, int r17, boolean r18, int r19, boolean r20) {
        q.g(r15, "context");
        q.g(r16, "seekBar");
        if (r18 == true) goto L6;
        this.f16994a = Integer.valueOf(r17);
        this.f16995b = Channel.UNLIMITED;
        return;
    L6:
        this.f16995b = 0;
        int r10 = r16.getMin();
        int r11 = r16.getMax();
        if (r17 != r10) goto L9;
        c(this, r15, 5, "hit minProgress", false, null, 24, null);
        return;
    L9:
        if (r17 != r11) goto L11;
        c(this, r15, 4, "hit maxProgress", false, null, 24, null);
        return;
    L11:
        int r12 = r19 - 1;
        if (r20 == false) goto L49;
        if (r12 > 1) goto L15;
        return;
    L15:
        if (this.f16994a == null) goto L43;
        float r13 = (r11 - r10) / r12;
        if (1 > r12) goto L43;
        int r14 = 1;
    L19:
        int r110 = r14 + 1;
        int r111 = yf.b.b((r14 * r13) - (r13 / 2)) + r10;
        Integer r112 = this.f16994a;
        q.d(r112);
        if (r112.intValue() >= r111) goto L23;
        if (r17 < r111) goto L23;
        boolean r113 = true;
    L24:
        Integer r114 = this.f16994a;
        q.d(r114);
        if (r114.intValue() <= r111) goto L28;
        if (r17 > r111) goto L28;
        boolean r115 = true;
    L29:
        if (r14 == 1) goto L38;
        if (r14 != r12) goto L33;
        r113 = r115;
        goto L38
    L33:
        if (r113 == true) goto L37;
        if (r115 == true) goto L37;
        r113 = false;
    L37:
        r113 = true;
    L38:
        if (r113 == true) goto L39;
        if (r14 == r12) goto L43;
        r14 = r110;
        goto L19
    L39:
        b(r15, 26, "passed boundary: " + r14 + '/' + r12 + ", progress: " + r17, false, r16);
    L28:
        r115 = false;
    L23:
        r113 = false;
    L43:
        this.f16994a = Integer.valueOf(r17);
        return;
    }

    public final void b(Context r10, int r11, String r12, boolean r13, View r14) {
        if (this.f16995b >= 2) goto L10;
        L.a(f16993d, q.p("vibrateIfNeeded: ", r12));
        if (r13 == false) goto L7;
        dd.a.b(r10, r11);
    L8:
        this.f16995b++;
        return;
    L7:
        dd.a.f19178a.a(r14, r11);
        goto L8
    }
}
