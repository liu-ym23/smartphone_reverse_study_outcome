package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import com.obric.oui.d.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SeekBarVibrateHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0993a f36257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f36258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36259c;

    /* JADX INFO: renamed from: com.obric.oui.slider.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SeekBarVibrateHelper.kt */
    public static final class C0993a {
        public /* synthetic */ C0993a(h r1) {
            this();
        }

        private C0993a() {
        }
    }

    public a() {
        this.f36259c = Integer.MAX_VALUE;
    }

    public final void a(Context r16, SeekBar r17, int r18, boolean r19, int r20, boolean r21) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r17, "seekBar");
        if (r19 == true) goto L6;
        this.f36258b = Integer.valueOf(r18);
        this.f36259c = Integer.MAX_VALUE;
        return;
    L6:
        this.f36259c = 0;
        int r4 = r17.getMin();
        int r5 = r17.getMax();
        if (r18 != r4) goto L9;
        a(this, r1, 5, "hit minProgress", false, null, 24, null);
        return;
    L9:
        if (r18 != r5) goto L11;
        a(this, r1, 4, "hit maxProgress", false, null, 24, null);
        return;
    L11:
        int r9 = r20 - 1;
        if (r21 == false) goto L49;
        if (r9 > 1) goto L15;
        return;
    L15:
        if (this.f36258b == null) goto L43;
        float r6 = (r5 - r4) / r9;
        if (1 > r9) goto L43;
        int r10 = 1;
    L19:
        int r11 = r10 + 1;
        int r12 = d.i.a.a((r10 * r6) - (r6 / 2)) + r4;
        Integer r13 = this.f36258b;
        o.a(r13);
        if (r13.intValue() >= r12) goto L23;
        if (r18 < r12) goto L23;
        boolean r14 = true;
    L24:
        Integer r15 = this.f36258b;
        o.a(r15);
        if (r15.intValue() <= r12) goto L28;
        if (r18 > r12) goto L28;
        boolean r110 = true;
    L29:
        if (r10 == 1) goto L38;
        if (r10 != r9) goto L33;
        r14 = r110;
        goto L38
    L33:
        if (r14 == true) goto L37;
        if (r110 == true) goto L37;
        r14 = false;
    L37:
        r14 = true;
    L38:
        if (r14 == true) goto L39;
        if (r10 == r9) goto L43;
        r10 = r11;
        goto L19
    L39:
        a(r1, 26, "passed boundary: " + r10 + '/' + r9 + ", progress: " + r18, false, (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.aiagent.plugin"));
    L28:
        r110 = false;
    L23:
        r14 = false;
    L43:
        this.f36258b = Integer.valueOf(r18);
        return;
    }

    static /* synthetic */ void a(a r6, Context r7, int r8, String r9, boolean r10, View r11, int r12, Object r13) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if ((r12 & 8) == 0) goto L5;
        r10 = true;
    L5:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = null;
    L8:
        r6.a(r1, r8, r9, r4, r11);
    }

    private final void a(Context r3, int r4, String r5, boolean r6, View r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.f36259c >= 2) goto L10;
        b.b(TAG, o.a("vibrateIfNeeded: ", r5));
        if (r6 == false) goto L7;
        com.obric.oui.b.a.a(r8, r4);
    L8:
        this.f36259c++;
        return;
    L7:
        com.obric.oui.b.a.f34003a.a(r7, r4);
        goto L8
    }

    static {
        f36257a = new C0993a(null);
        TAG = "SeekBarVibrateHelper";
    }
}
