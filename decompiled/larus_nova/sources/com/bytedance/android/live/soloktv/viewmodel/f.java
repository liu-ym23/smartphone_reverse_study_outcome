package com.bytedance.android.live.soloktv.viewmodel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Surface;
import com.bytedance.android.live.soloktv.timeline.SoloKtvTimelineManager;
import com.bytedance.android.live.soloktv.view.FakeViewRoot;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Surface f101881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f101882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f101883c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f101881a, r101.f101881a) == true) goto L8;
            return false;
        L8:
            if (this.f101882b == r101.f101882b) goto L10;
            return false;
        L10:
            if (this.f101883c == r101.f101883c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            Surface r100 = this.f101881a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (((r101 * 31) + this.f101882b) * 31) + this.f101883c;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "BindSurface(surface=" + this.f101881a + ", width=" + this.f101882b + ", height=" + this.f101883c + ")";
        }

        public a(Surface r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            this.f101881a = r100;
            this.f101882b = r101;
            this.f101883c = r102;
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.ktv.common.model.bean.h f101884a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f101884a, ((b) r100).f101884a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            com.bytedance.android.live.ktv.common.model.bean.h r100 = this.f101884a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "ChooseTuningEffect(tuningEffectItem=" + this.f101884a + ")";
        }

        public b(com.bytedance.android.live.ktv.common.model.bean.h r100) {
            Intrinsics.checkNotNullParameter(r100, "tuningEffectItem");
            this.f101884a = r100;
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f101885a = null;

        static {
            f101885a = new c();
        }

        public c() {
        }
    }

    public static final class d extends f {
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f101886a = null;

        static {
            f101886a = new e();
        }

        public e() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.viewmodel.f$f, reason: collision with other inner class name */
    public static final class C1547f extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f101887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.live.soloktv.model.k f101888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FakeViewRoot f101889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f101890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final nb1.i f101891e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1547f) == false) goto L16;
            C1547f r101 = (C1547f) r100;
            if (Intrinsics.areEqual(this.f101887a, r101.f101887a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f101888b, r101.f101888b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f101889c, r101.f101889c) == true) goto L12;
            return false;
        L12:
            if (this.f101890d == r101.f101890d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f101891e, r101.f101891e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            Activity r100 = this.f101887a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            com.bytedance.android.live.soloktv.model.k r104 = this.f101888b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            FakeViewRoot r107 = this.f101889c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (((r106 + r108) * 31) + this.f101890d) * 31;
            nb1.i r110 = this.f101891e;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Init(activity=" + this.f101887a + ", compositionModel=" + this.f101888b + ", rootContainer=" + this.f101889c + ", timelineType=" + this.f101890d + ", templateModel=" + this.f101891e + ")";
        }

        public final Activity getActivity() {
            return this.f101887a;
        }

        public C1547f(Activity r100, com.bytedance.android.live.soloktv.model.k r101, FakeViewRoot r102, int r103, nb1.i r104, int r105) {
            if ((r105 & 4) == 0) goto L6;
            r102 = null;
        L6:
            if ((r105 & 8) == 0) goto L9;
            r103 = SoloKtvTimelineManager.E;
        L9:
            if ((r105 & 16) == 0) goto L11;
            r104 = null;
        L11:
            this.f101887a = r100;
            this.f101888b = r101;
            this.f101889c = r102;
            this.f101890d = r103;
            this.f101891e = r104;
        }
    }

    public static final class g extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f101892a = null;

        static {
            f101892a = new g();
        }

        public g() {
        }
    }

    public static final class h extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.soloktv.model.k f101893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FakeViewRoot f101894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bitmap f101895c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof h) == false) goto L12;
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f101893a, r101.f101893a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f101894b, r101.f101894b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f101895c, r101.f101895c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.live.soloktv.model.k r100 = this.f101893a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            FakeViewRoot r104 = this.f101894b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Bitmap r107 = this.f101895c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Publish(recordStore=" + this.f101893a + ", rootContainer=" + this.f101894b + ", bitmap=" + this.f101895c + ")";
        }

        public h(com.bytedance.android.live.soloktv.model.k r100, FakeViewRoot r101, Bitmap r102) {
            this.f101893a = r100;
            this.f101894b = r101;
            this.f101895c = r102;
        }
    }

    public static final class i extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f101896a = null;

        static {
            f101896a = new i();
        }

        public i() {
        }
    }

    public static final class j extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f101897a = null;

        static {
            f101897a = new j();
        }

        public j() {
        }
    }

    public static final class k extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.soloktv.model.k f101898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FakeViewRoot f101899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bitmap f101900c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof k) == false) goto L12;
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.f101898a, r101.f101898a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f101899b, r101.f101899b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f101900c, r101.f101900c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.live.soloktv.model.k r100 = this.f101898a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            FakeViewRoot r104 = this.f101899b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Bitmap r107 = this.f101900c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "SaveToDraft(recordStore=" + this.f101898a + ", rootContainer=" + this.f101899b + ", bitmap=" + this.f101900c + ")";
        }

        public k(com.bytedance.android.live.soloktv.model.k r100, FakeViewRoot r101, Bitmap r102) {
            this.f101898a = r100;
            this.f101899b = r101;
            this.f101900c = r102;
        }
    }

    public static final class l extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f101901a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof l) == true) goto L6;
            return false;
        L6:
            if (Float.compare(this.f101901a, ((l) r100).f101901a) == 0) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f101901a);
        }

        public final String toString() {
            return "SeekTo(time=" + this.f101901a + ")";
        }

        public l(float r100) {
            this.f101901a = r100;
        }
    }

    public static final class m extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f101902a = null;

        static {
            f101902a = new m();
        }

        public m() {
        }
    }

    public static final class n extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f101903a = null;

        static {
            f101903a = new n();
        }

        public n() {
        }
    }

    public static final class o extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f101904a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof o) == true) goto L6;
            return false;
        L6:
            if (this.f101904a == ((o) r100).f101904a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.f101904a;
        }

        public final String toString() {
            return "UpdateMusicVolume(musicVolume=" + this.f101904a + ")";
        }

        public o(int r100) {
            this.f101904a = r100;
        }
    }

    public static final class p extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f101905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f101906b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof p) == false) goto L10;
            p r101 = (p) r100;
            if (this.f101905a == r101.f101905a) goto L8;
            return false;
        L8:
            if (this.f101906b == r101.f101906b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            int r100 = this.f101905a * 31;
            boolean r101 = this.f101906b;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return r100 + r102;
        }

        public final String toString() {
            return "UpdateVoiceAlign(voiceAlign=" + this.f101905a + ", realUpdate=" + this.f101906b + ")";
        }

        public p(int r100, boolean r101) {
            this.f101905a = r100;
            this.f101906b = r101;
        }
    }

    public static final class q extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f101907a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof q) == true) goto L6;
            return false;
        L6:
            if (this.f101907a == ((q) r100).f101907a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.f101907a;
        }

        public final String toString() {
            return "UpdateVoiceVolume(voiceVolume=" + this.f101907a + ")";
        }

        public q(int r100) {
            this.f101907a = r100;
        }
    }

    public f() {
    }
}
