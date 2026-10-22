package fe;

import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.downloader.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final String a(AppInstallActor.b r10) {
        q.g(r10, "<this>");
        if ((r10 instanceof AppInstallActor.b.a) == false) goto L6;
        return "Msg.CancelAppInstallTask(task=" + ((AppInstallActor.b.a) r10).b() + ')';
    L6:
        if ((r10 instanceof AppInstallActor.b.c) == false) goto L9;
        return "Msg.DlCbOnDownloadCancel(info=" + c.a(((AppInstallActor.b.c) r10).a()) + ')';
    L9:
        if ((r10 instanceof AppInstallActor.b.d) == false) goto L12;
        StringBuilder r11 = new StringBuilder();
        r11.append("Msg.DlCbOnDownloadFailed(info=");
        AppInstallActor.b.d r12 = (AppInstallActor.b.d) r10;
        r11.append(c.a(r12.a()));
        r11.append(", errorCode=");
        r11.append(r12.b());
        r11.append(", errorMsg=");
        r11.append(r12.c());
        r11.append(')');
        return r11.toString();
    L12:
        if ((r10 instanceof AppInstallActor.b.e) == false) goto L15;
        return "Msg.DlCbOnDownloadFinish(info=" + c.a(((AppInstallActor.b.e) r10).a()) + ')';
    L15:
        if ((r10 instanceof AppInstallActor.b.f) == false) goto L18;
        return "Msg.DlCbOnDownloadPause(info=" + c.a(((AppInstallActor.b.f) r10).a()) + ')';
    L18:
        if ((r10 instanceof AppInstallActor.b.g) == false) goto L21;
        return "Msg.DlCbOnDownloadPending(info=" + c.a(((AppInstallActor.b.g) r10).a()) + ')';
    L21:
        if ((r10 instanceof AppInstallActor.b.h) == false) goto L24;
        return "Msg.DlCbOnDownloadStart(info=" + c.a(((AppInstallActor.b.h) r10).a()) + ')';
    L24:
        if ((r10 instanceof AppInstallActor.b.i) == false) goto L27;
        return "Msg.DlCbOnDownloading(info=" + c.a(((AppInstallActor.b.i) r10).a()) + ')';
    L27:
        if ((r10 instanceof AppInstallActor.b.j) == false) goto L30;
        return "Msg.DlCbOnExtraInfoUpdate(info=" + c.a(((AppInstallActor.b.j) r10).a()) + ')';
    L30:
        if ((r10 instanceof AppInstallActor.b.k) == false) goto L33;
        return "Msg.DlCbOnFirstStart(info=" + c.a(((AppInstallActor.b.k) r10).a()) + ')';
    L33:
        if ((r10 instanceof AppInstallActor.b.l) == false) goto L36;
        return "Msg.DlCbOnFirstSuccess(info=" + c.a(((AppInstallActor.b.l) r10).a()) + ')';
    L36:
        if ((r10 instanceof AppInstallActor.b.m) == false) goto L39;
        StringBuilder r13 = new StringBuilder();
        r13.append("Msg.DlCbOnRetry(info=");
        AppInstallActor.b.m r14 = (AppInstallActor.b.m) r10;
        r13.append(c.a(r14.a()));
        r13.append(", errorCode=");
        r13.append(r14.b());
        r13.append(", errorMsg=");
        r13.append(r14.c());
        r13.append(')');
        return r13.toString();
    L39:
        if ((r10 instanceof AppInstallActor.b.n) == false) goto L42;
        StringBuilder r15 = new StringBuilder();
        r15.append("Msg.DlCbOnRetryDelay(info=");
        AppInstallActor.b.n r16 = (AppInstallActor.b.n) r10;
        r15.append(c.a(r16.a()));
        r15.append(", errorCode=");
        r15.append(r16.b());
        r15.append(", errorMsg=");
        r15.append(r16.c());
        r15.append(')');
        return r15.toString();
    L42:
        if ((r10 instanceof AppInstallActor.b.o) == false) goto L45;
        return "Msg.EnqueueAppInstallTask(task=" + ((AppInstallActor.b.o) r10).b().P() + ')';
    L45:
        if ((r10 instanceof AppInstallActor.b.q) == false) goto L48;
        return "Msg.InstallApk(task=" + ((AppInstallActor.b.q) r10).b().P() + ')';
    L48:
        if (q.b(r10, AppInstallActor.b.s.f17937a) == false) goto L51;
        return "Msg.InnerStartRetryInstall";
    L51:
        if ((r10 instanceof AppInstallActor.b.r) == false) goto L54;
        return "Msg.InnerStartDownloadWaitWiFi";
    L54:
        if ((r10 instanceof AppInstallActor.b.t) == false) goto L57;
        StringBuilder r17 = new StringBuilder();
        r17.append("Msg.InstallSysAppAutoUpdateManually(pkg=");
        AppInstallActor.b.t r18 = (AppInstallActor.b.t) r10;
        r17.append(r18.c());
        r17.append(", installMode=");
        r17.append(r18.b());
        r17.append(')');
        return r17.toString();
    L57:
        if ((r10 instanceof AppInstallActor.b.u) == false) goto L60;
        StringBuilder r19 = new StringBuilder();
        r19.append("Msg.ResumeAppInstallTask(pkg=");
        AppInstallActor.b.u r20 = (AppInstallActor.b.u) r10;
        r19.append(r20.b());
        r19.append(", wifiOnly=");
        r19.append(r20.c());
        r19.append(')');
        return r19.toString();
    L60:
        if ((r10 instanceof AppInstallActor.b.p) == false) goto L64;
        return "Msg.InnerEnqueueToInstall(task=" + ((AppInstallActor.b.p) r10).a().P() + ')';
    L64:
        throw new NoWhenBranchMatchedException();
    }
}
