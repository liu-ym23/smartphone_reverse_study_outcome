package com.smt.obric.appstore.domain.app;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n {
    public static final DownloadTask a(com.smt.obric.appstore.domain.app.entity.a r12) {
        q.g(r12, "<this>");
        String r10 = '[' + r12.K() + ']';
        String r11 = r12.t();
        l r13 = l.f18037a;
        String r14 = r13.c(r12, false);
        com.bytedanceos.common.toolbox.j.n("[AppStatus] AppDownloadRequest.buildDownloadTask " + r10 + " Download [url:" + r11 + "][FileName:" + r14 + ']');
        if (o.r(r14) == false) goto L6;
        com.bytedanceos.common.toolbox.j.p("[AppStatus] AppDownloadRequest.buildDownloadTask error. " + r10 + " fileName is empty");
        return null;
    L6:
        if (r11 != null) goto L8;
    L29:
        com.bytedanceos.common.toolbox.j.p("[AppStatus] AppDownloadRequest.buildDownloadTask error. " + r10 + " invalid downloadUrl " + r11);
        return null;
    L8:
        if (o.r(r11) == true) goto L29;
        BaseApplication r15 = BaseApplication.c();
        q.f(r15, "getContext(...)");
        String r16 = r13.b(r15, r12);
        File r17 = com.bytedanceos.common.toolbox.e.H();
        if (r17 == null) goto L13;
        String r18 = r17.getAbsolutePath();
    L14:
        if (r18 != null) goto L17;
        com.bytedanceos.common.toolbox.j.p("[AppStatus] AppDownloadRequest.buildDownloadTask error. " + r10 + " getDownloadedDir() is null");
        return null;
    L17:
        boolean r19 = r12.w();
        String r110 = r12.E();
        if (o.r(r110) == false) goto L21;
        r110 = null;
    L21:
        if (r110 != null) goto L24;
        com.bytedanceos.common.toolbox.j.p("[AppStatus] AppDownloadRequest.buildDownloadTask error. " + r10 + " pkg is empty");
        return null;
    L24:
        List r20 = r12.u();
        if (r20 != null) goto L27;
        r20 = t.i();
    L27:
        com.bytedanceos.common.toolbox.j.n("[AppStatus] AppDownloadRequest.buildDownloadTask " + r10 + ", backurl_size=" + r20.size());
        StringBuilder r21 = new StringBuilder();
        r21.append(r12.f());
        r21.append(".apk");
        return new zb.a(r11).f(r14).m(r21.toString()).j(r18).a(r110).g(r19).k(2).l(false).b(r20).i(3).e(r12.M()).h(false).d(r16).c();
    L13:
        r18 = null;
        goto L14
    }

    public static final com.smt.obric.appstore.domain.app.entity.a b(he.a r46, boolean r47, boolean r48) {
        q.g(r46, "<this>");
        le.c r10 = (le.c) ((Map) le.a.f21945a.b().getValue()).get(r46.j());
        if (r10 == null) goto L5;
        Long r11 = Long.valueOf(r10.b());
    L6:
        boolean r12 = false;
        if (r11 != null) goto L9;
    L11:
        String r13 = r46.j();
        long r14 = r46.o();
        String r15 = r46.i();
        String r16 = r46.h();
        AppStatus.l r17 = AppStatus.l.f17990a;
        String r18 = r46.k();
        String r19 = r46.g();
        return new com.smt.obric.appstore.domain.app.entity.a(0, r13, r14, r15, r16, r17, r18, r19, r12, false, r47, false, r46.d(), r46.e(), null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, r46.f(), null, System.currentTimeMillis(), r48, r46.l(), 1526712321, 0, null);
    L9:
        if (r46.o() <= r11.longValue()) goto L11;
        r12 = true;
        goto L11
    L5:
        r11 = null;
        goto L6
    }

    public static /* synthetic */ com.smt.obric.appstore.domain.app.entity.a c(he.a r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = true;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = false;
    L9:
        return b(r10, r11, r12);
    }

    public static final com.smt.obric.appstore.domain.app.entity.a d(he.a r45, int r46, int r47, AppInstallMode r48) {
        q.g(r45, "<this>");
        q.g(r48, "installMode");
        String r10 = r45.j();
        long r11 = r45.o();
        String r12 = r45.i();
        String r13 = r45.h();
        AppStatus.l r14 = AppStatus.l.f17990a;
        String r15 = r45.k();
        String r16 = r45.g();
        if (r46 != 3) goto L6;
        boolean r17 = true;
    L5:
        boolean r31 = r17;
        return new com.smt.obric.appstore.domain.app.entity.a(0, r10, r11, r12, r13, r14, r15, r16, true, false, r31, false, r45.d(), r45.e(), null, null, null, null, 0.0f, null, 0, 0, null, null, r46, r47, 0, r48, null, r45.f(), null, System.currentTimeMillis(), false, r45.l(), 1358940161, 1, null);
    L6:
        r17 = false;
        goto L5
    }

    public static /* synthetic */ com.smt.obric.appstore.domain.app.entity.a e(he.a r10, int r11, int r12, AppInstallMode r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = AppInstallMode.c.f17964a;
    L9:
        return d(r10, r11, r12, r13);
    }

    public static final com.smt.obric.appstore.domain.app.entity.a f(he.a r46, boolean r47) {
        q.g(r46, "<this>");
        le.c r10 = (le.c) ((Map) le.a.f21945a.b().getValue()).get(r46.j());
        if (r10 == null) goto L5;
        Long r11 = Long.valueOf(r10.b());
    L6:
        boolean r12 = false;
        if (r11 != null) goto L9;
    L11:
        String r13 = r46.j();
        long r14 = r46.o();
        String r15 = r46.i();
        String r16 = r46.h();
        AppStatus.l r17 = AppStatus.l.f17990a;
        String r18 = r46.k();
        String r19 = r46.g();
        return new com.smt.obric.appstore.domain.app.entity.a(0, r13, r14, r15, r16, r17, r18, r19, r12, false, true, true, r46.d(), r46.e(), null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, r46.f(), null, System.currentTimeMillis(), r47, r46.l(), 1526710273, 0, null);
    L9:
        if (r46.o() <= r11.longValue()) goto L11;
        r12 = true;
        goto L11
    L5:
        r11 = null;
        goto L6
    }

    public static final com.smt.obric.appstore.domain.app.entity.a g(he.a r45) {
        q.g(r45, "<this>");
        return new com.smt.obric.appstore.domain.app.entity.a(0, r45.j(), r45.o(), r45.i(), r45.h(), AppStatus.l.f17990a, r45.k(), r45.g(), true, true, true, false, r45.d(), r45.e(), null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, r45.f(), null, System.currentTimeMillis(), false, r45.l(), 1526712321, 1, null);
    }

    public static final com.smt.obric.appstore.domain.app.entity.a h(DownloadInfo r48) {
        q.g(r48, "<this>");
        AppInfo r10 = com.smt.obric.appstore.domain.downloader.b.b(r48);
        String r11 = r10.appPackageName;
        Long r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        le.c r13 = (le.c) ((Map) le.a.f21945a.b().getValue()).get(r11);
        boolean r14 = false;
        if (r13 != null) goto L8;
    L10:
        boolean r16 = r14;
        String r15 = r10.appPackageName;
        if (r15 != null) goto L13;
        return null;
    L13:
        long r17 = r10.appVersionCode;
        String r18 = r10.appName;
        if (r18 != null) goto L16;
        return null;
    L16:
        String r19 = r10.appIcon;
        if (r19 != null) goto L19;
        r19 = "";
    L19:
        String r110 = r19;
        AppStatus r111 = i(r48);
        if (r111 != null) goto L22;
        return null;
    L22:
        String r112 = r10.fileMd5;
        if (r112 != null) goto L25;
        return null;
    L25:
        String r20 = r48.getUrl();
        long r21 = r48.getId();
        long r22 = r48.getStatus();
        Integer r23 = r48.getErrorCode();
        if (r23 == null) goto L28;
        r12 = Long.valueOf(r23.intValue());
    L28:
        Long r24 = r12;
        String r25 = r48.getErrorMsg();
        float r26 = r48.getProgress();
        String r27 = r48.getTargetFilePath();
        long r28 = r48.getCurBytes();
        long r30 = r48.getTotalBytes();
        float r29 = (float) r48.getSpeed();
        String r33 = r48.getLastModifiedTime();
        String r39 = r48.getExtraInfo();
        int r31 = r10.mUpdateModel;
        int r32 = r10.mInstallFlag;
        AppInstallMode r34 = AppInstallMode.Companion.a(r10.installMode);
        if (r34 != null) goto L31;
        r34 = AppInstallMode.c.f17964a;
    L31:
        long r41 = System.currentTimeMillis();
        return new com.smt.obric.appstore.domain.app.entity.a(0, r15, r17, r18, r110, r111, null, r112, r16, false, true, false, r20, null, Long.valueOf(r21), Long.valueOf(r22), r24, r25, r26, r27, r28, r30, Float.valueOf(r29), r33, r31, 0, r32, r34, null, r39, null, r41, false, null, 1375733760, 1, null);
    L8:
        if (r10.appVersionCode <= r13.b()) goto L10;
        r14 = true;
        goto L10
    }

    public static final AppStatus i(DownloadInfo r10) {
        q.g(r10, "<this>");
        switch(r10.getStatus()) {
            case -8: goto L25;
            case -7: goto L45;
            case -6: goto L44;
            case -5: goto L43;
            case -4: goto L20;
            case -3: goto L41;
            case -2: goto L40;
            case -1: goto L39;
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            default: goto L26;
        };
    L20:
        return null;
    L26:
        return AppStatus.d.f17974a;
    L27:
        return AppStatus.d.f17974a;
    L28:
        return AppStatus.d.f17974a;
    L29:
        return AppStatus.d.f17974a;
    L30:
        return AppStatus.d.f17974a;
    L31:
        return AppStatus.d.f17974a;
    L32:
        return AppStatus.d.f17974a;
    L33:
        return AppStatus.d.f17974a;
    L34:
        return AppStatus.d.f17974a;
    L35:
        return AppStatus.d.f17974a;
    L36:
        return AppStatus.d.f17974a;
    L37:
        return AppStatus.c.f17972a;
    L38:
        return AppStatus.c.f17972a;
    L39:
        return AppStatus.a.f17968a;
    L40:
        return AppStatus.b.f17970a;
    L41:
        return AppStatus.e.f17976a;
    L43:
        return AppStatus.b.f17970a;
    L44:
        return AppStatus.e.f17976a;
    L45:
        return AppStatus.d.f17974a;
    L25:
        return AppStatus.c.f17972a;
    }
}
