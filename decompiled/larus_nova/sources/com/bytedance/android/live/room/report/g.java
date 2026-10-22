package com.bytedance.android.live.room.report;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.u;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f100250k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReportConstant$BusinessSource f100251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final User f100252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRoom f100253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f100254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f100255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f100256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f100257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f100258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReportObject f100259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f100260j;

    public static final class a {
        public static g a(y71.a r110) {
            Intrinsics.checkNotNullParameter(r110, "wrapper");
            Map<String, String> r100 = ReportTracer.f100240a;
            ReportTracer.b(ReportTracer.EventName.generate_report_params);
            ReportTracer.a(r110.f566574c, r110.f566575d, r110.f566576e, r110.f566577f);
            IBaseUser r101 = r110.f566572a;
            if ((r101 instanceof User) == true) goto L5;
            r101 = null;
        L5:
            User r102 = (User) r101;
            if (r102 != null) goto L8;
            return null;
        L8:
            IRoom r103 = r110.f566573b;
            if ((r103 instanceof Room) == true) goto L11;
            r103 = null;
        L11:
            Room r104 = (Room) r103;
            if (r104 != null) goto L14;
            return null;
        L14:
            ReportConstant$BusinessSource r105 = r110.f566580i;
            String r106 = r110.f566574c;
            if (r106 != null) goto L17;
            String r107 = "";
        L18:
            String r108 = r110.f566575d;
            if (r108 != null) goto L21;
            String r109 = "";
        L22:
            String r111 = r110.f566576e;
            if (r111 != null) goto L25;
            String r112 = "";
        L27:
            return new g(r105, r102, r104, r107, r109, r112, r110.f566577f, Intrinsics.areEqual(r102.getIdString(), r104.getOwnerUserIdString()), r110.f566578g, r110.f566579h);
        L25:
            r112 = r111;
            goto L27
        L21:
            r109 = r108;
            goto L22
        L17:
            r107 = r106;
            goto L18
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L28;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f100251a, r101.f100251a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f100252b, r101.f100252b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f100253c, r101.f100253c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f100254d, r101.f100254d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f100255e, r101.f100255e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f100256f, r101.f100256f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f100257g, r101.f100257g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        if (this.f100258h == r101.f100258h) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f100259i, r101.f100259i) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f100260j, r101.f100260j) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v32 */
    public final int hashCode() {
        ReportConstant$BusinessSource r100 = this.f100251a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        User r104 = this.f100252b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IRoom r107 = this.f100253c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f100254d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f100255e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f100256f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        u r119 = this.f100257g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (((r118 + r120) * 31) + 0) * 31;
        boolean r122 = this.f100258h;
        ?? r123 = r122;
        if (r122 == false) goto L33;
        r123 = 1;
    L33:
        int r124 = (r121 + r123) * 31;
        ReportObject r125 = this.f100259i;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.f100260j;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        return r127 + r101;
    L36:
        r126 = 0;
        goto L37
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "ReportParams(businessSource=" + this.f100251a + ", targetUser=" + this.f100252b + ", room=" + this.f100253c + ", fromSource=" + this.f100254d + ", reportSource=" + this.f100255e + ", reportTypeForLog=" + this.f100256f + ", commentReportModel=" + this.f100257g + ", channelLinkReportModel=null, targetUserIsAnchor=" + this.f100258h + ", reportObject=" + this.f100259i + ", extraParams=" + this.f100260j + ")";
    }

    public /* synthetic */ g(ReportConstant$BusinessSource r110, User r111, IRoom r112, String r113, String r114, String r115, u r116, boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, null, null);
    }

    public g(ReportConstant$BusinessSource r100, User r101, IRoom r102, String r103, String r104, String r105, u r106, boolean r107, ReportObject r110, Map r111) {
        Intrinsics.checkNotNullParameter(r100, "businessSource");
        Intrinsics.checkNotNullParameter(r101, "targetUser");
        Intrinsics.checkNotNullParameter(r102, "room");
        Intrinsics.checkNotNullParameter(r103, "fromSource");
        Intrinsics.checkNotNullParameter(r104, "reportSource");
        Intrinsics.checkNotNullParameter(r105, "reportTypeForLog");
        this.f100251a = r100;
        this.f100252b = r101;
        this.f100253c = r102;
        this.f100254d = r103;
        this.f100255e = r104;
        this.f100256f = r105;
        this.f100257g = r106;
        this.f100258h = r107;
        this.f100259i = r110;
        this.f100260j = r111;
    }
}
