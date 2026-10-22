package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class s extends i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f133517k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v f133518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f133519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.e f133520j;

    public static final class a extends yb2.a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f133521n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f133522o;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f133521n == r101.f133521n) goto L8;
            return false;
        L8:
            if (this.f133522o == r101.f133522o) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f133521n * 31) + this.f133522o;
        }

        public final String toString() {
            return "ColorConfig(nameColor=" + this.f133521n + ", contentColor=" + this.f133522o + ")";
        }

        public a(int r100, int r101) {
            this.f133521n = r100;
            this.f133522o = r101;
            this.f567062a = r100;
            this.f567065d = r101;
            this.f567063b = r101;
            this.f567064c = r101;
            this.f567066e = r101;
        }
    }

    public static final class b {
        public b() {
        }

        public static u c(PublicScreenConfig$MessageModelType r110, Text r111, User r112, PSMessageAction r113) {
            int r100 = s.f133517k;
            Intrinsics.checkNotNullParameter(r110, "type");
            Intrinsics.checkNotNullParameter(r111, "text");
            Intrinsics.checkNotNullParameter(r113, ReportConstant.COMMON_ACTION_TYPE);
            return new u(r110, r112, null, r111, null, false, true, r113);
        }

        public static /* synthetic */ t b(PublicScreenConfig$MessageModelType r100, String r110, Integer r111, boolean r112, boolean r113, PSMessageAction r114, int r115) {
            if ((r115 & 4) == 0) goto L5;
            r111 = null;
        L5:
            Integer r101 = r111;
            if ((r115 & 8) == 0) goto L8;
            boolean r102 = false;
        L10:
            if ((r115 & 16) == 0) goto L12;
            boolean r103 = false;
        L14:
            if ((r115 & 128) == 0) goto L17;
            r114 = PSMessageAction.UNKNOW;
        L17:
            return a(r100, r110, r101, r102, r103, false, null, r114, null);
        L12:
            r103 = r113;
            goto L14
        L8:
            r102 = r112;
            goto L10
        }

        @JvmStatic
        public static t a(PublicScreenConfig$MessageModelType r110, String r111, Integer r112, boolean r113, boolean r114, boolean r115, IBaseUser r116, PSMessageAction r117, IPublicAreaCommon r118) {
            Intrinsics.checkNotNullParameter(r110, "type");
            Intrinsics.checkNotNullParameter(r111, "content");
            Intrinsics.checkNotNullParameter(r117, ReportConstant.COMMON_ACTION_TYPE);
            return new t(r110, r116, r118, r112, r111, r113, r114, r115, r117);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tb2.d f133523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f133524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f133525c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f133523a, r101.f133523a) == true) goto L8;
            return false;
        L8:
            if (this.f133524b == r101.f133524b) goto L10;
            return false;
        L10:
            if (this.f133525c == r101.f133525c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            tb2.d r100 = this.f133523a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f133524b;
            ?? r104 = 1;
            ?? r105 = r103;
            if (r103 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r102 + r105) * 31;
            boolean r107 = this.f133525c;
            if (r107 == true) goto L14;
            r104 = r107;
        L14:
            return r106 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "TextInfo(renderText=" + this.f133523a + ", hasEmoji=" + this.f133524b + ", hasAnim=" + this.f133525c + ")";
        }

        public c(tb2.d r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "renderText");
            this.f133523a = r100;
            this.f133524b = r101;
            this.f133525c = r102;
        }

        public /* synthetic */ c(tb2.d r100, boolean r101, int r102) {
            if ((r102 & 4) == 0) goto L5;
            r101 = false;
        L5:
            this(r100, false, r101);
        }
    }

    static {
        new b();
    }

    public abstract c k();

    public void l(View r100, g52.d r101, g52.c r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public boolean m(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return false;
    }

    public boolean n(View r100, tb2.b r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return false;
    }

    public s() {
        this.f133518h = v.f133660b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public j<? extends i, ? extends PSMessageViewHolder> b() {
        return this.f133518h;
    }
}
