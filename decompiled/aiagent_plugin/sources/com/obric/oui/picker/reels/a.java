package com.obric.oui.picker.reels;

import android.view.View;
import com.obric.oui.picker.reels.views.WheelView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: OReelPicker.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.oui.picker.reels.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OReelPicker.kt */
    public interface InterfaceC0969a {
    }

    /* JADX INFO: compiled from: OReelPicker.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f35924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CharSequence f35925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f35926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Integer f35927e;
        private final Integer f;
        private final Integer g;
        private final int h;
        private final c i;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f35923a == r6.f35923a) goto L12;
            return false;
        L12:
            if (o.a(this.f35924b, r6.f35924b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f35925c, r6.f35925c) == true) goto L18;
            return false;
        L18:
            if (o.a(Float.valueOf(this.f35926d), Float.valueOf(r6.f35926d)) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f35927e, r6.f35927e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (o.a(this.i, r6.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f35923a) * 31) + this.f35924b.hashCode()) * 31;
            CharSequence r1 = this.f35925c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Float.hashCode(this.f35926d)) * 31;
            Integer r5 = this.f35927e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (((r10 + r12) * 31) + Integer.hashCode(this.h)) * 31;
            c r14 = this.i;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return r13 + r2;
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Reel(id=" + this.f35923a + ", entries=" + this.f35924b + ", tag=" + this.f35925c + ", widthWeight=" + this.f35926d + ", width=" + this.f35927e + ", minWidth=" + this.f + ", tagGap=" + this.g + ", selectedIndex=" + this.h + ", reelChangedListener=" + this.i + ')';
        }

        public b(int r3, List<String> r4, CharSequence r5, float r6, Integer r7, Integer r8, Integer r9, int r10, c r11) {
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            c r14 = (c) ZeusTransformUtils.wrapperContextForParams(r11, c.class, "com.obric.aiagent.plugin");
            o.e(r12, "entries");
            this.f35923a = r3;
            this.f35924b = r12;
            this.f35925c = r13;
            this.f35926d = r6;
            this.f35927e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r14;
        }

        public /* synthetic */ b(int r11, List r12, CharSequence r13, float r14, Integer r15, Integer r16, Integer r17, int r18, c r19, int r20, h r21) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
            c r2 = (c) ZeusTransformUtils.wrapperContextForParams(r19, c.class, "com.obric.aiagent.plugin");
            c r5 = null;
            if ((r20 & 4) == 0) goto L6;
            r3 = null;
        L6:
            if ((r20 & 8) == 0) goto L8;
            float r4 = 1.0f;
        L10:
            if ((r20 & 16) == 0) goto L12;
            Integer r6 = null;
        L14:
            if ((r20 & 32) == 0) goto L16;
            Integer r7 = null;
        L18:
            if ((r20 & 64) == 0) goto L20;
            Integer r8 = null;
        L22:
            if ((r20 & 128) == 0) goto L24;
            int r9 = 0;
        L26:
            if ((r20 & 256) != 0) goto L29;
            r5 = r2;
        L29:
            this(r11, r1, r3, r4, r6, r7, r8, r9, r5);
            return;
        L24:
            r9 = r18;
            goto L26
        L20:
            r8 = r17;
            goto L22
        L16:
            r7 = r16;
            goto L18
        L12:
            r6 = r15;
            goto L14
        L8:
            r4 = r14;
            goto L10
        }

        public final int a() {
            return this.f35923a;
        }

        public final List<String> b() {
            return this.f35924b;
        }

        public final CharSequence c() {
            return this.f35925c;
        }

        public final float d() {
            return this.f35926d;
        }

        public final Integer e() {
            return this.f35927e;
        }

        public final Integer f() {
            return this.f;
        }

        public final Integer g() {
            return this.g;
        }

        public final int h() {
            return this.h;
        }

        public final c i() {
            return this.i;
        }
    }

    /* JADX INFO: compiled from: OReelPicker.kt */
    public interface c {
        void onReelChanged(int r1, int r2);
    }

    View asView();

    WheelView getReelView(int r1);
}
