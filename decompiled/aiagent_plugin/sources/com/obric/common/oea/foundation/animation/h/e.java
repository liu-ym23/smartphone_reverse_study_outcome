package com.obric.common.oea.foundation.animation.h;

import com.google.protobuf.DescriptorProtos;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Token.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: compiled from: Token.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32428a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f32429b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f32430c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f32431d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f32432e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        private static final /* synthetic */ a[] j = null;
        private final float k;
        private final float l;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(j.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2, float r3, float r4) {
            super(r1, r2);
            this.k = r3;
            this.l = r4;
        }

        public final float a() {
            return this.k;
        }

        public final float b() {
            return this.l;
        }

        static {
            a r1 = new a("OUI_ANIMATION_BOUNCE_SMOOTH", 0, 0.0f, 1.0f);
            f32428a = r1;
            a r2 = new a("OUI_ANIMATION_BOUNCE_SNAPPY_1", 1, 0.05f, 0.95f);
            f32429b = r2;
            a r3 = new a("OUI_ANIMATION_BOUNCE_SNAPPY_2", 2, 0.1f, 0.9f);
            f32430c = r3;
            a r4 = new a("OUI_ANIMATION_BOUNCE_SNAPPY_3", 3, 0.15f, 0.85f);
            f32431d = r4;
            a r5 = new a("OUI_ANIMATION_BOUNCE_SNAPPY_4", 4, 0.2f, 0.8f);
            f32432e = r5;
            a r6 = new a("OUI_ANIMATION_BOUNCE_BOUNCY_1", 5, 0.25f, 0.75f);
            f = r6;
            a r7 = new a("OUI_ANIMATION_BOUNCE_BOUNCY_2", 6, 0.3f, 0.7f);
            g = r7;
            a r8 = new a("OUI_ANIMATION_BOUNCE_BOUNCY_3", 7, 0.35f, 0.65f);
            h = r8;
            a r9 = new a("OUI_ANIMATION_BOUNCE_BOUNCY_4", 8, 0.4f, 0.6f);
            i = r9;
            j = new a[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32433a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f32434b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f32435c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f32436d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f32437e = null;
        public static final b f = null;
        public static final b g = null;
        public static final b h = null;
        public static final b i = null;
        public static final b j = null;
        public static final b k = null;
        public static final b l = null;
        public static final b m = null;
        public static final b n = null;
        public static final b o = null;
        public static final b p = null;
        public static final b q = null;
        private static final /* synthetic */ b[] r = null;
        private final int s;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(r.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.s = r3;
        }

        public final int a() {
            return this.s;
        }

        static {
            b r1 = new b("OUI_ANIMATION_DELAY_NONE", 0, 0);
            f32433a = r1;
            b r2 = new b("OUI_ANIMATION_DELAY_SHORT_1", 1, 50);
            f32434b = r2;
            b r3 = new b("OUI_ANIMATION_DELAY_SHORT_2", 2, 100);
            f32435c = r3;
            b r4 = new b("OUI_ANIMATION_DELAY_SHORT_3", 3, 150);
            f32436d = r4;
            b r5 = new b("OUI_ANIMATION_DELAY_SHORT_4", 4, 200);
            f32437e = r5;
            b r6 = new b("OUI_ANIMATION_DELAY_MEDIUM_1", 5, ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION);
            f = r6;
            b r7 = new b("OUI_ANIMATION_DELAY_MEDIUM_2", 6, 300);
            g = r7;
            b r8 = new b("OUI_ANIMATION_DELAY_MEDIUM_3", 7, 350);
            h = r8;
            b r9 = new b("OUI_ANIMATION_DELAY_MEDIUM_4", 8, 400);
            i = r9;
            b r10 = new b("OUI_ANIMATION_DELAY_LONG_1", 9, 450);
            j = r10;
            b r11 = new b("OUI_ANIMATION_DELAY_LONG_2", 10, 500);
            k = r11;
            b r12 = new b("OUI_ANIMATION_DELAY_LONG_3", 11, 550);
            l = r12;
            b r13 = new b("OUI_ANIMATION_DELAY_LONG_4", 12, 600);
            m = r13;
            b r14 = new b("OUI_ANIMATION_DELAY_VERY_LONG_1", 13, 700);
            n = r14;
            b r15 = new b("OUI_ANIMATION_DELAY_VERY_LONG_2", 14, 800);
            o = r15;
            b r16 = new b("OUI_ANIMATION_DELAY_VERY_LONG_3", 15, DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
            p = r16;
            b r17 = new b("OUI_ANIMATION_DELAY_VERY_LONG_4", 16, 1000);
            q = r17;
            r = new b[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17};
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32438a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f32439b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f32440c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f32441d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f32442e = null;
        public static final c f = null;
        public static final c g = null;
        public static final c h = null;
        public static final c i = null;
        public static final c j = null;
        public static final c k = null;
        public static final c l = null;
        public static final c m = null;
        public static final c n = null;
        public static final c o = null;
        public static final c p = null;
        private static final /* synthetic */ c[] q = null;
        private final int r;
        private final int s;

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(q.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        private c(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.r = r3;
            this.s = r4;
        }

        public final int a() {
            return this.r;
        }

        public final int b() {
            return this.s;
        }

        static {
            c r1 = new c("OUI_ANIMATION_DURATION_SHORT_1", 0, 50, 15791);
            f32438a = r1;
            c r2 = new c("OUI_ANIMATION_DURATION_SHORT_2", 1, 100, 3948);
            f32439b = r2;
            c r3 = new c("OUI_ANIMATION_DURATION_SHORT_3", 2, 150, 1755);
            f32440c = r3;
            c r4 = new c("OUI_ANIMATION_DURATION_SHORT_4", 3, 200, 987);
            f32441d = r4;
            c r5 = new c("OUI_ANIMATION_DURATION_MEDIUM_1", 4, ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, 632);
            f32442e = r5;
            c r6 = new c("OUI_ANIMATION_DURATION_MEDIUM_2", 5, 300, 439);
            f = r6;
            c r7 = new c("OUI_ANIMATION_DURATION_MEDIUM_3", 6, 350, 322);
            g = r7;
            c r8 = new c("OUI_ANIMATION_DURATION_MEDIUM_4", 7, 400, 247);
            h = r8;
            c r9 = new c("OUI_ANIMATION_DURATION_LONG_1", 8, 450, 195);
            i = r9;
            c r10 = new c("OUI_ANIMATION_DURATION_LONG_2", 9, 500, 158);
            j = r10;
            c r11 = new c("OUI_ANIMATION_DURATION_LONG_3", 10, 550, ApWakeEvent.ACCELERATING_END);
            k = r11;
            c r12 = new c("OUI_ANIMATION_DURATION_LONG_4", 11, 600, 110);
            l = r12;
            c r13 = new c("OUI_ANIMATION_DURATION_VERY_LONG_1", 12, 700, 81);
            m = r13;
            c r14 = new c("OUI_ANIMATION_DURATION_VERY_LONG_2", 13, 800, 62);
            n = r14;
            c r15 = new c("OUI_ANIMATION_DURATION_VERY_LONG_3", 14, DescriptorProtos.Edition.EDITION_LEGACY_VALUE, 49);
            o = r15;
            c r16 = new c("OUI_ANIMATION_DURATION_VERY_LONG_4", 15, 1000, 39);
            p = r16;
            q = new c[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16};
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f32443a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f32444b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f32445c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f32446d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f32447e = null;
        public static final d f = null;
        public static final d g = null;
        public static final d h = null;
        public static final d i = null;
        public static final d j = null;
        public static final d k = null;
        public static final d l = null;
        public static final d m = null;
        public static final d n = null;
        public static final d o = null;
        public static final d p = null;
        public static final d q = null;
        public static final d r = null;
        public static final d s = null;
        public static final d t = null;
        public static final d u = null;
        public static final d v = null;
        public static final d w = null;
        public static final d x = null;
        private static final /* synthetic */ d[] y = null;
        private final float[] z;

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(y.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        private d(String r1, int r2, float... r3) {
            super(r1, r2);
            this.z = r3;
        }

        public final float[] a() {
            return this.z;
        }

        static {
            d r1 = new d("OUI_ANIMATION_EASING_LINEAR", 0, new float[]{0.0f, 0.0f, 1.0f, 1.0f});
            f32443a = r1;
            d r2 = new d("OUI_ANIMATION_EASING_STANDARD", 1, new float[]{0.34f, 0.69f, 0.1f, 1.0f});
            f32444b = r2;
            d r3 = new d("OUI_ANIMATION_EASING_EASE", 2, new float[]{0.25f, 0.1f, 0.25f, 1.0f});
            f32445c = r3;
            d r4 = new d("OUI_ANIMATION_EASING_EASE_IN", 3, new float[]{0.42f, 0.0f, 1.0f, 1.0f});
            f32446d = r4;
            d r5 = new d("OUI_ANIMATION_EASING_EASE_OUT", 4, new float[]{0.0f, 0.0f, 0.58f, 1.0f});
            f32447e = r5;
            d r6 = new d("OUI_ANIMATION_EASING_EASE_IN_OUT", 5, new float[]{0.42f, 0.0f, 0.58f, 1.0f});
            f = r6;
            d r7 = new d("OUI_ANIMATION_EASING_EASE_IN_SINE", 6, new float[]{0.47f, 0.0f, 0.745f, 0.715f});
            g = r7;
            d r8 = new d("OUI_ANIMATION_EASING_EASE_OUT_SINE", 7, new float[]{0.39f, 0.575f, 0.565f, 1.0f});
            h = r8;
            d r9 = new d("OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", 8, new float[]{0.445f, 0.05f, 0.55f, 0.95f});
            i = r9;
            d r10 = new d("OUI_ANIMATION_EASING_EASE_IN_QUAD", 9, new float[]{0.26f, 0.0f, 0.6f, 0.2f});
            j = r10;
            d r11 = new d("OUI_ANIMATION_EASING_EASE_OUT_QUAD", 10, new float[]{0.4f, 0.8f, 0.74f, 1.0f});
            k = r11;
            d r12 = new d("OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", 11, new float[]{0.48f, 0.04f, 0.52f, 0.96f});
            l = r12;
            d r13 = new d("OUI_ANIMATION_EASING_EASE_IN_CUBIC", 12, new float[]{0.4f, 0.0f, 0.68f, 0.06f});
            m = r13;
            d r14 = new d("OUI_ANIMATION_EASING_EASE_OUT_CUBIC", 13, new float[]{0.32f, 0.94f, 0.6f, 1.0f});
            n = r14;
            d r15 = new d("OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", 14, new float[]{0.66f, 0.0f, 0.34f, 1.0f});
            o = r15;
            d r16 = new d("OUI_ANIMATION_EASING_EASE_IN_QUART", 15, new float[]{0.52f, 0.0f, 0.74f, 0.0f});
            p = r16;
            d r17 = new d("OUI_ANIMATION_EASING_EASE_OUT_QUART", 16, new float[]{0.26f, 1.0f, 0.48f, 1.0f});
            q = r17;
            d r18 = new d("OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", 17, new float[]{0.76f, 0.0f, 0.24f, 1.0f});
            r = r18;
            d r19 = new d("OUI_ANIMATION_EASING_EASE_IN_QUINT", 18, new float[]{0.64f, 0.0f, 0.78f, 0.0f});
            s = r19;
            d r20 = new d("OUI_ANIMATION_EASING_EASE_OUT_QUINT", 19, new float[]{0.22f, 1.0f, 0.36f, 1.0f});
            t = r20;
            d r21 = new d("OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", 20, new float[]{0.84f, 0.0f, 0.16f, 1.0f});
            u = r21;
            d r22 = new d("OUI_ANIMATION_EASING_EASE_IN_EXPO", 21, new float[]{0.66f, 0.0f, 0.86f, 0.0f});
            v = r22;
            d r23 = new d("OUI_ANIMATION_EASING_EASE_OUT_EXPO", 22, new float[]{0.14f, 1.0f, 0.34f, 1.0f});
            w = r23;
            d r24 = new d("OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", 23, new float[]{0.9f, 0.0f, 0.1f, 1.0f});
            x = r24;
            y = new d[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        }
    }
}
