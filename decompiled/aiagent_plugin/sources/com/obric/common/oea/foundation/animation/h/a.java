package com.obric.common.oea.foundation.animation.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: AnimationProperty.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimationProperty.kt */
    public static final enum EnumC0885a extends Enum<EnumC0885a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0885a f32412a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0885a f32413b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0885a f32414c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0885a f32415d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0885a f32416e = null;
        public static final EnumC0885a f = null;
        public static final EnumC0885a g = null;
        public static final EnumC0885a h = null;
        public static final EnumC0885a i = null;
        public static final EnumC0885a j = null;
        public static final C0886a k = null;
        private static final /* synthetic */ EnumC0885a[] l = null;
        private final String m;

        /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.h.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AnimationProperty.kt */
        public static final class C0886a {
            private C0886a() {
            }

            public /* synthetic */ C0886a(h r1) {
                this();
            }
        }

        public static EnumC0885a valueOf(String r2) {
            return (EnumC0885a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0885a.class, r2), EnumC0885a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0885a[] values() {
            return (EnumC0885a[]) ZeusTransformUtils.preCheckCast(l.clone(), EnumC0885a[].class, "com.obric.aiagent.plugin");
        }

        private EnumC0885a(String r1, int r2, String r3) {
            super(r1, r2);
            this.m = r3;
        }

        public final String a() {
            return this.m;
        }

        static {
            EnumC0885a r1 = new EnumC0885a("X", 0, "x");
            f32412a = r1;
            EnumC0885a r2 = new EnumC0885a("Y", 1, "y");
            f32413b = r2;
            EnumC0885a r3 = new EnumC0885a("SCALE_X", 2, "scaleX");
            f32414c = r3;
            EnumC0885a r4 = new EnumC0885a("SCALE_Y", 3, "scaleY");
            f32415d = r4;
            EnumC0885a r5 = new EnumC0885a("ROTATION", 4, "rotation");
            f32416e = r5;
            EnumC0885a r6 = new EnumC0885a("ROTATION_X", 5, "rotationX");
            f = r6;
            EnumC0885a r7 = new EnumC0885a("ROTATION_Y", 6, "rotationY");
            g = r7;
            EnumC0885a r8 = new EnumC0885a("TRANSLATION_X", 7, "translationX");
            h = r8;
            EnumC0885a r9 = new EnumC0885a("TRANSLATION_Y", 8, "translationY");
            i = r9;
            EnumC0885a r10 = new EnumC0885a("ALPHA", 9, "alpha");
            j = r10;
            l = new EnumC0885a[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
            k = new C0886a(null);
        }
    }

    /* JADX INFO: compiled from: AnimationProperty.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32417a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f32418b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f32419c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f32420d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f32421e = null;
        public static final b f = null;
        public static final C0887a g = null;
        private static final /* synthetic */ b[] h = null;
        private final String i;

        /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.h.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AnimationProperty.kt */
        public static final class C0887a {
            private C0887a() {
            }

            public /* synthetic */ C0887a(h r1) {
                this();
            }
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2, String r3) {
            super(r1, r2);
            this.i = r3;
        }

        public final String a() {
            return this.i;
        }

        static {
            b r1 = new b("BACKGROUND_COLOR", 0, "backgroundColor");
            f32417a = r1;
            b r2 = new b("TEXT_COLOR", 1, "textColor");
            f32418b = r2;
            b r3 = new b("STROKE_COLOR", 2, "strokeColor");
            f32419c = r3;
            b r4 = new b("FILL_COLOR", 3, "fillColor");
            f32420d = r4;
            b r5 = new b("WIDTH", 4, "width");
            f32421e = r5;
            b r6 = new b("HEIGHT", 5, "height");
            f = r6;
            h = new b[]{r1, r2, r3, r4, r5, r6};
            g = new C0887a(null);
        }
    }
}
