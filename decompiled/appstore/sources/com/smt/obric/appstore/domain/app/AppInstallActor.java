package com.smt.obric.appstore.domain.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.PowerManager;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.bytedanceos.common.utils.ObricSysappWifiUpdateSetting;
import com.bytedanceos.common.utils.v;
import com.obric.download.DownloadListener;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import com.obric.download.base.TaskOperateResult;
import com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import com.smt.obric.appstore.domain.downloader.ODownloader;
import com.smt.obric.appstore.ktx.ConnectivityManagerNetworkMonitorKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.u;

/* JADX INFO: loaded from: classes4.dex */
public final class AppInstallActor {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f17891n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CompletableDeferred f17892o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static AppInstallActor f17893p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f17894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f17895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppInstallTaskDAO f17896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReceiveChannel f17897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SysAppAutoUpdateAnalytics f17898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StateFlow f17899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompletableDeferred f17900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SendChannel f17901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f17902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f17903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f17904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f17905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StateFlow f17906m;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final CompletableDeferred a() {
            return AppInstallActor.m();
        }

        public final AppInstallActor b() {
            AppInstallActor r10 = AppInstallActor.f17893p;
            if (r10 == null) goto L5;
            return r10;
        L5:
            q.y("instance");
            return null;
        }

        public final AppInstallActor c(CoroutineScope r10, Context r11, AppInstallTaskDAO r12) {
            q.g(r10, "scope");
            q.g(r11, "context");
            q.g(r12, "taskDao");
            CoroutineContext.Element r13 = r10.getCoroutineContext().get(Job.Key);
            q.d(r13);
            CoroutineScope r14 = d0.g(r10, h1.a((Job) r13));
            AppInstallActor r15 = new AppInstallActor(r14, r11, r12, ProduceKt.d(r14, null, Channel.UNLIMITED, new AppInstallActor$Companion$launchIn$act$1(null), 1, null), SysAppAutoUpdateAnalytics.Companion.a(), null);
            AppInstallActor.D(r15, kotlinx.coroutines.channels.b.b(r14, null, Channel.UNLIMITED, null, null, new AppInstallActor$Companion$launchIn$sendCh$1(r15, null), 13, null));
            return r15;
        }

        public final void d(AppInstallActor r10) {
            q.g(r10, "<set-?>");
            AppInstallActor.f17893p = r10;
        }

        public Companion() {
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.smt.obric.appstore.domain.app.entity.a f17908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Deferred f17909b;

        public a(com.smt.obric.appstore.domain.app.entity.a r10, Deferred r11) {
            q.g(r10, "task");
            q.g(r11, "deferredResult");
            this.f17908a = r10;
            this.f17909b = r11;
        }

        public final Deferred a() {
            return this.f17909b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(this.f17908a, r11.f17908a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f17909b, r11.f17909b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f17908a.hashCode() * 31) + this.f17909b.hashCode();
        }

        public String toString() {
            return "Installing(task=" + this.f17908a + ", deferredResult=" + this.f17909b + ')';
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f17910a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CompletableDeferred f17911b;

            public a(String r10, CompletableDeferred r11) {
                kotlin.jvm.internal.q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
                super(null);
                this.f17910a = r10;
                this.f17911b = r11;
            }

            public final CompletableDeferred a() {
                return this.f17911b;
            }

            public final String b() {
                return this.f17910a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L8;
                return false;
            L8:
                a r11 = (a) r10;
                if (kotlin.jvm.internal.q.b(this.f17910a, r11.f17910a) == true) goto L12;
                return false;
            L12:
                if (kotlin.jvm.internal.q.b(this.f17911b, r11.f17911b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r10 = this.f17910a.hashCode() * 31;
                CompletableDeferred r11 = this.f17911b;
                if (r11 != null) goto L5;
                int r12 = 0;
            L7:
                return r10 + r12;
            L5:
                r12 = r11.hashCode();
                goto L7
            }

            public String toString() {
                return "CancelAppInstallTask(pkg=" + this.f17910a + ", ack=" + this.f17911b + ')';
            }
        }

        /* JADX INFO: renamed from: com.smt.obric.appstore.domain.app.AppInstallActor$b$b, reason: collision with other inner class name */
        public static abstract class AbstractC0215b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final DownloadInfo f17912a;

            public /* synthetic */ AbstractC0215b(DownloadInfo r10, DefaultConstructorMarker r11) {
                this(r10);
            }

            public abstract DownloadInfo a();

            public AbstractC0215b(DownloadInfo r10) {
                super(null);
                this.f17912a = r10;
            }
        }

        public static final class c extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17913b;

            public c(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17913b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17913b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof c) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17913b, ((c) r10).f17913b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17913b.hashCode();
            }

            public String toString() {
                return "DlCbOnDownloadCancel(info=" + this.f17913b + ')';
            }
        }

        public static final class d extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17914b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f17915c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f17916d;

            public d(DownloadInfo r10, int r11, String r12) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                kotlin.jvm.internal.q.g(r12, "errorMsg");
                super(r10, null);
                this.f17914b = r10;
                this.f17915c = r11;
                this.f17916d = r12;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17914b;
            }

            public final int b() {
                return this.f17915c;
            }

            public final String c() {
                return this.f17916d;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof d) == true) goto L8;
                return false;
            L8:
                d r11 = (d) r10;
                if (kotlin.jvm.internal.q.b(this.f17914b, r11.f17914b) == true) goto L12;
                return false;
            L12:
                if (this.f17915c == r11.f17915c) goto L15;
                return false;
            L15:
                if (kotlin.jvm.internal.q.b(this.f17916d, r11.f17916d) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f17914b.hashCode() * 31) + Integer.hashCode(this.f17915c)) * 31) + this.f17916d.hashCode();
            }

            public String toString() {
                return "DlCbOnDownloadFailed(info=" + this.f17914b + ", errorCode=" + this.f17915c + ", errorMsg=" + this.f17916d + ')';
            }
        }

        public static final class e extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17917b;

            public e(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17917b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17917b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof e) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17917b, ((e) r10).f17917b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17917b.hashCode();
            }

            public String toString() {
                return "DlCbOnDownloadFinish(info=" + this.f17917b + ')';
            }
        }

        public static final class f extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17918b;

            public f(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17918b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17918b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof f) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17918b, ((f) r10).f17918b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17918b.hashCode();
            }

            public String toString() {
                return "DlCbOnDownloadPause(info=" + this.f17918b + ')';
            }
        }

        public static final class g extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17919b;

            public g(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17919b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17919b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof g) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17919b, ((g) r10).f17919b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17919b.hashCode();
            }

            public String toString() {
                return "DlCbOnDownloadPending(info=" + this.f17919b + ')';
            }
        }

        public static final class h extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17920b;

            public h(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17920b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17920b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof h) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17920b, ((h) r10).f17920b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17920b.hashCode();
            }

            public String toString() {
                return "DlCbOnDownloadStart(info=" + this.f17920b + ')';
            }
        }

        public static final class i extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17921b;

            public i(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17921b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17921b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof i) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17921b, ((i) r10).f17921b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17921b.hashCode();
            }

            public String toString() {
                return "DlCbOnDownloading(info=" + this.f17921b + ')';
            }
        }

        public static final class j extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17922b;

            public j(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17922b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17922b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof j) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17922b, ((j) r10).f17922b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17922b.hashCode();
            }

            public String toString() {
                return "DlCbOnExtraInfoUpdate(info=" + this.f17922b + ')';
            }
        }

        public static final class k extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17923b;

            public k(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17923b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17923b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof k) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17923b, ((k) r10).f17923b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17923b.hashCode();
            }

            public String toString() {
                return "DlCbOnFirstStart(info=" + this.f17923b + ')';
            }
        }

        public static final class l extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17924b;

            public l(DownloadInfo r10) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                super(r10, null);
                this.f17924b = r10;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17924b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof l) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17924b, ((l) r10).f17924b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17924b.hashCode();
            }

            public String toString() {
                return "DlCbOnFirstSuccess(info=" + this.f17924b + ')';
            }
        }

        public static final class m extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17925b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f17926c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f17927d;

            public m(DownloadInfo r10, int r11, String r12) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                kotlin.jvm.internal.q.g(r12, "errorMsg");
                super(r10, null);
                this.f17925b = r10;
                this.f17926c = r11;
                this.f17927d = r12;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17925b;
            }

            public final int b() {
                return this.f17926c;
            }

            public final String c() {
                return this.f17927d;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof m) == true) goto L8;
                return false;
            L8:
                m r11 = (m) r10;
                if (kotlin.jvm.internal.q.b(this.f17925b, r11.f17925b) == true) goto L12;
                return false;
            L12:
                if (this.f17926c == r11.f17926c) goto L15;
                return false;
            L15:
                if (kotlin.jvm.internal.q.b(this.f17927d, r11.f17927d) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f17925b.hashCode() * 31) + Integer.hashCode(this.f17926c)) * 31) + this.f17927d.hashCode();
            }

            public String toString() {
                return "DlCbOnRetry(info=" + this.f17925b + ", errorCode=" + this.f17926c + ", errorMsg=" + this.f17927d + ')';
            }
        }

        public static final class n extends AbstractC0215b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DownloadInfo f17928b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f17929c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f17930d;

            public n(DownloadInfo r10, int r11, String r12) {
                kotlin.jvm.internal.q.g(r10, ServerElements.INFO);
                kotlin.jvm.internal.q.g(r12, "errorMsg");
                super(r10, null);
                this.f17928b = r10;
                this.f17929c = r11;
                this.f17930d = r12;
            }

            @Override // com.smt.obric.appstore.domain.app.AppInstallActor.b.AbstractC0215b
            public DownloadInfo a() {
                return this.f17928b;
            }

            public final int b() {
                return this.f17929c;
            }

            public final String c() {
                return this.f17930d;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof n) == true) goto L8;
                return false;
            L8:
                n r11 = (n) r10;
                if (kotlin.jvm.internal.q.b(this.f17928b, r11.f17928b) == true) goto L12;
                return false;
            L12:
                if (this.f17929c == r11.f17929c) goto L15;
                return false;
            L15:
                if (kotlin.jvm.internal.q.b(this.f17930d, r11.f17930d) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f17928b.hashCode() * 31) + Integer.hashCode(this.f17929c)) * 31) + this.f17930d.hashCode();
            }

            public String toString() {
                return "DlCbOnRetryDelay(info=" + this.f17928b + ", errorCode=" + this.f17929c + ", errorMsg=" + this.f17930d + ')';
            }
        }

        public static final class o extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.smt.obric.appstore.domain.app.entity.a f17931a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CompletableDeferred f17932b;

            public o(com.smt.obric.appstore.domain.app.entity.a r10, CompletableDeferred r11) {
                kotlin.jvm.internal.q.g(r10, "task");
                super(null);
                this.f17931a = r10;
                this.f17932b = r11;
            }

            public final CompletableDeferred a() {
                return this.f17932b;
            }

            public final com.smt.obric.appstore.domain.app.entity.a b() {
                return this.f17931a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof o) == true) goto L8;
                return false;
            L8:
                o r11 = (o) r10;
                if (kotlin.jvm.internal.q.b(this.f17931a, r11.f17931a) == true) goto L12;
                return false;
            L12:
                if (kotlin.jvm.internal.q.b(this.f17932b, r11.f17932b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r10 = this.f17931a.hashCode() * 31;
                CompletableDeferred r11 = this.f17932b;
                if (r11 != null) goto L5;
                int r12 = 0;
            L7:
                return r10 + r12;
            L5:
                r12 = r11.hashCode();
                goto L7
            }

            public String toString() {
                return "EnqueueAppInstallTask(task=" + this.f17931a + ", ack=" + this.f17932b + ')';
            }
        }

        public static final class p extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.smt.obric.appstore.domain.app.entity.a f17933a;

            public p(com.smt.obric.appstore.domain.app.entity.a r10) {
                kotlin.jvm.internal.q.g(r10, "task");
                super(null);
                this.f17933a = r10;
            }

            public final com.smt.obric.appstore.domain.app.entity.a a() {
                return this.f17933a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof p) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17933a, ((p) r10).f17933a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17933a.hashCode();
            }

            public String toString() {
                return "InnerEnqueueToInstall(task=" + this.f17933a + ')';
            }
        }

        public static final class q extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.smt.obric.appstore.domain.app.entity.a f17934a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CompletableDeferred f17935b;

            public q(com.smt.obric.appstore.domain.app.entity.a r10, CompletableDeferred r11) {
                kotlin.jvm.internal.q.g(r10, "task");
                super(null);
                this.f17934a = r10;
                this.f17935b = r11;
            }

            public final CompletableDeferred a() {
                return this.f17935b;
            }

            public final com.smt.obric.appstore.domain.app.entity.a b() {
                return this.f17934a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof q) == true) goto L8;
                return false;
            L8:
                q r11 = (q) r10;
                if (kotlin.jvm.internal.q.b(this.f17934a, r11.f17934a) == true) goto L12;
                return false;
            L12:
                if (kotlin.jvm.internal.q.b(this.f17935b, r11.f17935b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r10 = this.f17934a.hashCode() * 31;
                CompletableDeferred r11 = this.f17935b;
                if (r11 != null) goto L5;
                int r12 = 0;
            L7:
                return r10 + r12;
            L5:
                r12 = r11.hashCode();
                goto L7
            }

            public String toString() {
                return "InnerInstallApk(task=" + this.f17934a + ", ack=" + this.f17935b + ')';
            }
        }

        public static final class r extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CompletableDeferred f17936a;

            public r(CompletableDeferred r10) {
                kotlin.jvm.internal.q.g(r10, "result");
                super(null);
                this.f17936a = r10;
            }

            public final CompletableDeferred a() {
                return this.f17936a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof r) == true) goto L9;
                return false;
            L9:
                if (kotlin.jvm.internal.q.b(this.f17936a, ((r) r10).f17936a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f17936a.hashCode();
            }

            public String toString() {
                return "InnerStartDownloadWaitWiFi(result=" + this.f17936a + ')';
            }
        }

        public static final class s extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final s f17937a = null;

            static {
                f17937a = new s();
            }

            public s() {
                super(null);
            }
        }

        public static final class t extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f17938a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CompletableDeferred f17939b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final AppInstallMode f17940c;

            public t(String r10, CompletableDeferred r11, AppInstallMode r12) {
                kotlin.jvm.internal.q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
                super(null);
                this.f17938a = r10;
                this.f17939b = r11;
                this.f17940c = r12;
            }

            public final CompletableDeferred a() {
                return this.f17939b;
            }

            public final AppInstallMode b() {
                return this.f17940c;
            }

            public final String c() {
                return this.f17938a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof t) == true) goto L8;
                return false;
            L8:
                t r11 = (t) r10;
                if (kotlin.jvm.internal.q.b(this.f17938a, r11.f17938a) == true) goto L12;
                return false;
            L12:
                if (kotlin.jvm.internal.q.b(this.f17939b, r11.f17939b) == true) goto L15;
                return false;
            L15:
                if (kotlin.jvm.internal.q.b(this.f17940c, r11.f17940c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                int r10 = this.f17938a.hashCode() * 31;
                CompletableDeferred r11 = this.f17939b;
                int r12 = 0;
                if (r11 != null) goto L5;
                int r13 = 0;
            L6:
                int r14 = (r10 + r13) * 31;
                AppInstallMode r15 = this.f17940c;
                if (r15 == null) goto L11;
                r12 = r15.hashCode();
            L11:
                return r14 + r12;
            L5:
                r13 = r11.hashCode();
                goto L6
            }

            public String toString() {
                return "InstallSysAppAutoUpdateManually(pkg=" + this.f17938a + ", ack=" + this.f17939b + ", installMode=" + this.f17940c + ')';
            }
        }

        public static final class u extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f17941a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f17942b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final CompletableDeferred f17943c;

            public u(String r10, boolean r11, CompletableDeferred r12) {
                kotlin.jvm.internal.q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
                super(null);
                this.f17941a = r10;
                this.f17942b = r11;
                this.f17943c = r12;
            }

            public final CompletableDeferred a() {
                return this.f17943c;
            }

            public final String b() {
                return this.f17941a;
            }

            public final boolean c() {
                return this.f17942b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof u) == true) goto L8;
                return false;
            L8:
                u r11 = (u) r10;
                if (kotlin.jvm.internal.q.b(this.f17941a, r11.f17941a) == true) goto L12;
                return false;
            L12:
                if (this.f17942b == r11.f17942b) goto L15;
                return false;
            L15:
                if (kotlin.jvm.internal.q.b(this.f17943c, r11.f17943c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                int r10 = ((this.f17941a.hashCode() * 31) + Boolean.hashCode(this.f17942b)) * 31;
                CompletableDeferred r11 = this.f17943c;
                if (r11 != null) goto L5;
                int r12 = 0;
            L7:
                return r10 + r12;
            L5:
                r12 = r11.hashCode();
                goto L7
            }

            public String toString() {
                return "ResumeAppInstallTask(pkg=" + this.f17941a + ", wifiOnly=" + this.f17942b + ", ack=" + this.f17943c + ')';
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f17944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f17945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f17946c;

        public c(List r10, List r11, List r12) {
            q.g(r10, "toInstall");
            q.g(r11, "waitInstallRetry");
            q.g(r12, "waitWiFiDownload");
            this.f17944a = r10;
            this.f17945b = r11;
            this.f17946c = r12;
        }

        public final List a() {
            return this.f17944a;
        }

        public final List b() {
            return this.f17945b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (q.b(this.f17944a, r11.f17944a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f17945b, r11.f17945b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f17946c, r11.f17946c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f17944a.hashCode() * 31) + this.f17945b.hashCode()) * 31) + this.f17946c.hashCode();
        }

        public String toString() {
            return "RestoreInstallTasksResult(toInstall=" + this.f17944a + ", waitInstallRetry=" + this.f17945b + ", waitWiFiDownload=" + this.f17946c + ')';
        }
    }

    public static final class d implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendChannel f17947a;

        public d(SendChannel r10) {
            this.f17947a = r10;
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadCancel(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f17947a.mo53trySendJP2dKIU(new b.c(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadFailed(DownloadInfo r10, int r11, String r12) {
            q.g(r10, ServerElements.INFO);
            q.g(r12, "errorMsg");
            r10.setErrorCode(Integer.valueOf(r11));
            r10.setErrorMsg(r12);
            this.f17947a.mo53trySendJP2dKIU(new b.d(r10, r11, r12));
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadFinish(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f17947a.mo53trySendJP2dKIU(new b.e(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadPause(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f17947a.mo53trySendJP2dKIU(new b.f(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadPending(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f17947a.mo53trySendJP2dKIU(new b.g(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadStart(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f17947a.mo53trySendJP2dKIU(new b.h(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloading(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f17947a.mo53trySendJP2dKIU(new b.i(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onExtraInfoUpdate(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f17947a.mo53trySendJP2dKIU(new b.j(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onFirstStart(DownloadInfo r10) {
            q.g(r10, "entity");
            this.f17947a.mo53trySendJP2dKIU(new b.k(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onFirstSuccess(DownloadInfo r10) {
            q.g(r10, "entity");
            this.f17947a.mo53trySendJP2dKIU(new b.l(r10));
        }

        @Override // com.obric.download.DownloadListener
        public void onRetry(DownloadInfo r10, int r11, String r12) {
            q.g(r10, "entity");
            q.g(r12, "errorMsg");
            this.f17947a.mo53trySendJP2dKIU(new b.m(r10, r11, r12));
        }

        @Override // com.obric.download.DownloadListener
        public void onRetryDelay(DownloadInfo r10, int r11, String r12) {
            q.g(r10, "entity");
            q.g(r12, "errorMsg");
            this.f17947a.mo53trySendJP2dKIU(new b.n(r10, r11, r12));
        }
    }

    static {
        f17891n = new Companion(null);
        f17892o = u.b(null, 1, null);
    }

    public /* synthetic */ AppInstallActor(CoroutineScope r10, Context r11, AppInstallTaskDAO r12, ReceiveChannel r13, SysAppAutoUpdateAnalytics r14, DefaultConstructorMarker r15) {
        this(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ void A(AppInstallActor r10, PowerManager.WakeLock r11) {
        r10.k0(r11);
    }

    public static final /* synthetic */ Object B(AppInstallActor r10, Continuation r11) {
        return r10.p0(r11);
    }

    public static final /* synthetic */ void C(AppInstallActor r10, a r11) {
        r10.f17904k = r11;
    }

    public static final /* synthetic */ void D(AppInstallActor r10, SendChannel r11) {
        r10.f17901h = r11;
    }

    public static final /* synthetic */ Object E(AppInstallActor r10, b.AbstractC0215b r11, SendChannel r12, Continuation r13) {
        return r10.q0(r11, r12, r13);
    }

    public static final /* synthetic */ Object F(AppInstallActor r10, Continuation r11) {
        return r10.r0(r11);
    }

    public static final /* synthetic */ Object G(AppInstallActor r10, Continuation r11) {
        return r10.s0(r11);
    }

    public static final /* synthetic */ SendChannel H(AppInstallActor r10, CoroutineScope r11) {
        return r10.t0(r11);
    }

    public static /* synthetic */ void N(AppInstallActor r10, com.smt.obric.appstore.domain.app.entity.a r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = false;
    L5:
        r10.M(r11, r12);
    }

    public static final boolean O(Function1 r10, Object r11) {
        q.g(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    public static final boolean P(Function1 r10, Object r11) {
        q.g(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    public static final boolean Q(Function1 r10, Object r11) {
        q.g(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    public static /* synthetic */ boolean a(Function1 r10, Object r11) {
        return P(r10, r11);
    }

    public static /* synthetic */ boolean b(Function1 r10, Object r11) {
        return n0(r10, r11);
    }

    public static /* synthetic */ boolean c(Function1 r10, Object r11) {
        return O(r10, r11);
    }

    public static /* synthetic */ boolean d(Function1 r10, Object r11) {
        return m0(r10, r11);
    }

    public static /* synthetic */ boolean e(Function1 r10, Object r11) {
        return o0(r10, r11);
    }

    public static /* synthetic */ boolean f(Function1 r10, Object r11) {
        return Q(r10, r11);
    }

    public static final /* synthetic */ void g(AppInstallActor r10, PowerManager.WakeLock r11) {
        r10.I(r11);
    }

    public static final /* synthetic */ boolean h(AppInstallActor r10, b.o r11) {
        return r10.J(r11);
    }

    public static final /* synthetic */ void i(AppInstallActor r10, CoroutineScope r11, Context r12, ReceiveChannel r13, SendChannel r14) {
        r10.K(r11, r12, r13, r14);
    }

    public static final /* synthetic */ void j(AppInstallActor r10, CoroutineScope r11, StateFlow r12, SendChannel r13) {
        r10.L(r11, r12, r13);
    }

    public static final /* synthetic */ SendChannel k(AppInstallActor r10, CoroutineScope r11) {
        return r10.R(r11);
    }

    public static final /* synthetic */ Context l(AppInstallActor r10) {
        return r10.f17895b;
    }

    public static final /* synthetic */ CompletableDeferred m() {
        return f17892o;
    }

    public static final boolean m0(Function1 r10, Object r11) {
        q.g(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    public static final /* synthetic */ List n(AppInstallActor r10) {
        return r10.f17902i;
    }

    public static final boolean n0(Function1 r10, Object r11) {
        q.g(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    public static final /* synthetic */ List o(AppInstallActor r10) {
        return r10.f17903j;
    }

    public static final boolean o0(Function1 r10, Object r11) {
        q.g(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    public static final /* synthetic */ a p(AppInstallActor r10) {
        return r10.f17904k;
    }

    public static final /* synthetic */ ReceiveChannel q(AppInstallActor r10) {
        return r10.f17897d;
    }

    public static final /* synthetic */ SysAppAutoUpdateAnalytics r(AppInstallActor r10) {
        return r10.f17898e;
    }

    public static final /* synthetic */ StateFlow s(AppInstallActor r10) {
        return r10.f17906m;
    }

    public static final /* synthetic */ AppInstallTaskDAO t(AppInstallActor r10) {
        return r10.f17896c;
    }

    public static final /* synthetic */ void u(AppInstallActor r10, CoroutineScope r11, b r12, SendChannel r13, SendChannel r14, SendChannel r15, SendChannel r16) {
        r10.U(r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ Object v(AppInstallActor r10, SendChannel r11, Continuation r12) {
        return r10.V(r11, r12);
    }

    public static final /* synthetic */ void w(AppInstallActor r10, CoroutineScope r11, SendChannel r12) {
        r10.X(r11, r12);
    }

    public static final /* synthetic */ Object x(AppInstallActor r10, Channel r11, Continuation r12) {
        return r10.Z(r11, r12);
    }

    public static final /* synthetic */ void y(AppInstallActor r10, CoroutineScope r11, i r12) {
        r10.g0(r11, r12);
    }

    public static final /* synthetic */ void z(AppInstallActor r10, String r11) {
        r10.j0(r11);
    }

    public final void I(PowerManager.WakeLock r10) {
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L5
        if (r10.isHeld() == true) goto L7;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] wake lock acquire");     // Catch: Throwable -> L5
        r10.acquire(AdConstant.SPLASH_AD_INTERVAL);     // Catch: Throwable -> L5
    L7:
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.a r12 = Result.Companion;
        Result.m35constructorimpl(kotlin.c.a(th));
    }

    public final boolean J(b.o r10) {
        com.smt.obric.appstore.domain.app.entity.a r11 = r10.b();
        if (r11.I() != 1) goto L6;
        return true;
    L6:
        if (r11.w() == true) goto L8;
    L15:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][AutoUpdate] autoUpdateCheck: passed, req=" + r11.P());
        return true;
    L8:
        if (ConnectivityManagerNetworkMonitorKt.f(this.f17895b) == true) goto L12;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][AutoUpdate] autoUpdateCheck: failed, wifi not connected, req=" + r11.P());
        return false;
    L12:
        if (com.bytedanceos.common.toolbox.e.l0() == true) goto L15;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][AutoUpdate] autoUpdateCheck: failed, environment check failed, req=" + r11.P());
        return false;
    }

    public final void K(CoroutineScope r10, Context r11, ReceiveChannel r12, SendChannel r13) {
        kotlinx.coroutines.h.d(r10, null, null, new AppInstallActor$cancelTaskOnPackageChange$1(r12, this, r13, r11, null), 3, null);
    }

    public final void L(CoroutineScope r10, StateFlow r11, SendChannel r12) {
        if (h.a() == false) goto L6;
        kotlinx.coroutines.h.d(r10, null, null, new AppInstallActor$cancelTaskSysAppWiFiAutoUpdateOnSettingDisabled$1(r11, this, r12, null), 3, null);
        return;
    }

    public final void M(final com.smt.obric.appstore.domain.app.entity.a r10, boolean r11) {
        List r12 = this.f17902i;
        final Function1<com.smt.obric.appstore.domain.app.entity.a, Boolean> r13 = new AppInstallActor$doEnqueueToInstall$1(r10);
        r12.removeIf(new com.smt.obric.appstore.domain.app.b(r13));
        List r14 = this.f17903j;
        final Function1<com.smt.obric.appstore.domain.app.entity.a, Boolean> r15 = new AppInstallActor$doEnqueueToInstall$2(r10);
        r14.removeIf(new com.smt.obric.appstore.domain.app.c(r15));
        List r16 = this.f17905l;
        final Function1<com.smt.obric.appstore.domain.app.entity.a, Boolean> r17 = new AppInstallActor$doEnqueueToInstall$3(r10);
        r16.removeIf(new com.smt.obric.appstore.domain.app.d(r17));
        if (Y(r10) == false) goto L5;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] doEnqueueToInstall: installQueuePriority, atFront=true, " + r10.P());
        this.f17903j.add(0, r10);
        return;
    L5:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] doEnqueueToInstall: installQueue, atFront=" + r11 + ", " + r10.P());
        if (r11 == false) goto L8;
        this.f17902i.add(0, r10);
        return;
    L8:
        this.f17902i.add(r10);
    }

    public final SendChannel R(CoroutineScope r10) {
        return kotlinx.coroutines.channels.b.b(r10, null, Channel.UNLIMITED, null, null, new AppInstallActor$downloadCallbackActor$1(this, null), 13, null);
    }

    public final StateFlow S() {
        return this.f17899f;
    }

    public final SendChannel T() {
        SendChannel r10 = this.f17901h;
        if (r10 != null) goto L6;
        q.y("_sendCh");
        return null;
    L6:
        return r10;
    }

    public final void U(CoroutineScope r10, b r11, SendChannel r12, SendChannel r13, SendChannel r14, SendChannel r15) {
        if ((r11 instanceof b.AbstractC0215b) == false) goto L6;
        r15.mo53trySendJP2dKIU(r11);
        return;
    L6:
        if ((r11 instanceof b.o) == false) goto L9;
        b0(r10, (b.o) r11, r12);
        return;
    L9:
        if ((r11 instanceof b.u) == false) goto L12;
        i0(r10, (b.u) r11);
        return;
    L12:
        if ((r11 instanceof b.a) == false) goto L15;
        a0(r10, (b.a) r11, r13);
        return;
    L15:
        if ((r11 instanceof b.s) == false) goto L18;
        f0((b.s) r11);
        return;
    L18:
        if ((r11 instanceof b.r) == false) goto L21;
        e0(r10, (b.r) r11, r14);
        return;
    L21:
        if ((r11 instanceof b.q) == false) goto L24;
        d0(r10, (b.q) r11, r12);
        return;
    L24:
        if ((r11 instanceof b.p) == false) goto L27;
        c0((b.p) r11);
        return;
    L27:
        if ((r11 instanceof b.t) == false) goto L38;
        h0(r10, (b.t) r11, r12);
        return;
    }

    public final Object V(SendChannel r10, Continuation r11) {
        if ((r11 instanceof AppInstallActor$init$1) == false) goto L7;
        AppInstallActor$init$1 r12 = (AppInstallActor$init$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        AppInstallActor this = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
    L22:
        c r17 = (c) r14;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] restoreInstallTasks, enqueue size=" + r17.a());
        this.f17902i.addAll(r17.a());
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] restoreInstallTasks, waitInstallRetry size=" + r17.b());
        this.f17905l.addAll(r17.b());
        CompletableDeferred r18 = this.f17900g;
        Unit r19 = Unit.f21064a;
        r18.complete(r19);
        return r19;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        this = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
    L19:
        r12.L$0 = this;
        r12.label = 2;
        r14 = this.p0(r12);
        if (r14 != r15) goto L22;
        return r15;
    L16:
        kotlin.c.b(r14);
        W(r10);
        r12.L$0 = this;
        r12.label = 1;
        if (r0(r12) != r15) goto L19;
        return r15;
    L7:
        r12 = new AppInstallActor$init$1(this, r11);
        goto L8
    }

    public final void W(SendChannel r10) {
        ODownloader.n(this.f17895b, new d(r10));
    }

    public final void X(CoroutineScope r10, SendChannel r11) {
        kotlinx.coroutines.h.d(r10, null, null, new AppInstallActor$installRetryTicker$1(r11, null), 3, null);
    }

    public final boolean Y(com.smt.obric.appstore.domain.app.entity.a r10) {
        return q.b(r10.C(), AppInstallMode.b.f17962a);
    }

    public final Object Z(Channel r10, Continuation r11) {
        Object r12 = d0.e(new AppInstallActor$loop$2(this, r10, null), r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    public final void a0(CoroutineScope r10, final b.a r11, SendChannel r12) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onCancelInstallTaskReq: " + fe.b.a(r11));
        kotlinx.coroutines.h.d(r10, null, null, new AppInstallActor$onCancelInstallTaskRequest$1(this, r11.b(), r12, null), 3, null).invokeOnCompletion(new AppInstallActor$onCancelInstallTaskRequest$2(r11));
    }

    public final void b0(CoroutineScope r11, final b.o r12, SendChannel r13) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: " + fe.b.a(r12));
        com.smt.obric.appstore.domain.app.entity.a r10 = r12.b();
        final Ref$BooleanRef r14 = new Ref$BooleanRef();
        kotlinx.coroutines.h.d(r11, null, null, new AppInstallActor$onEnqueueAppInstallTaskRequest$1(this, r10, r13, r12, r14, null), 3, null).invokeOnCompletion(new AppInstallActor$onEnqueueAppInstallTaskRequest$2(r12, r14));
    }

    public final void c0(b.p r10) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onInnerEnqueueToInstall: " + fe.b.a(r10));
        N(this, r10.a(), false, 2, null);
    }

    public final void d0(CoroutineScope r50, b.q r51, SendChannel r52) {
        kotlinx.coroutines.h.d(r50, null, null, new AppInstallActor$onInnerInstallApk$1(this, com.smt.obric.appstore.domain.app.entity.a.b(r51.b(), 0, null, 0, null, null, AppStatus.j.f17986a, null, null, false, false, false, false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, false, null, -33, 3, null), r51, r52, null), 3, null);
    }

    public final void e0(CoroutineScope r10, b.r r11, SendChannel r12) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onInnerStartDownloadWaitWiFi: " + fe.b.a(r11));
        kotlinx.coroutines.h.d(r10, null, null, new AppInstallActor$onInnerStartDownloadWaitWiFi$1(r12, r11, null), 3, null);
    }

    public final void f0(b.s r10) {
        if (this.f17905l.isEmpty() == false) goto L5;
        return;
    L5:
        int r11 = this.f17905l.size();
        int r12 = this.f17902i.size();
        int r13 = this.f17903j.size();
        List r14 = s.c();
        r14.addAll(this.f17905l);
        Iterator r15 = s.a(r14).iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        M((com.smt.obric.appstore.domain.app.entity.a) r15.next(), true);
        goto L7
    L9:
        int r16 = this.f17905l.size();
        int r17 = this.f17902i.size();
        int r18 = this.f17903j.size();
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onInnerStartRetryInstall: sizeAfter(W,Q,QP)=(" + r16 + '[' + (r16 - r11) + "], " + r17 + '[' + (r17 - r12) + "], " + r18 + '[' + (r18 - r13) + "])");
    }

    public final void g0(CoroutineScope r47, i r48) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onInstallResult: result=" + r48.g());
        this.f17904k = null;
        if (r48.c() == false) goto L7;
        AppStatus r10 = AppStatus.h.f17982a;
    L5:
        AppStatus r11 = r10;
        if (r48.d() == false) goto L22;
    L23:
        l0(r48.e().E());
    L24:
        com.smt.obric.appstore.domain.app.entity.a r12 = com.smt.obric.appstore.domain.app.entity.a.b(r48.e(), 0, null, 0, null, null, r11, null, null, false, false, false, false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, Integer.valueOf(r48.a()), null, null, 0, false, null, -268435489, 3, null);
        if (r48.c() == false) goto L27;
        this.f17905l.add(r12);
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][Job][InstallStage] onInstallResult: install result need retry, add to waitInstallRetry. scheduleIfNotExistAppInstallRetry, jobId=" + com.smt.obric.appstore.domain.app.jobs.a.f18032a.d(this.f17895b).getId() + ", task=" + r12.P());
    L27:
        kotlinx.coroutines.h.d(r47, null, null, new AppInstallActor$onInstallResult$1(r48, this, r12, null), 3, null);
        return;
    L22:
        if (r48.f() == false) goto L24;
    L7:
        if (r48.e().M() == false) goto L16;
        if (r48.d() == false) goto L11;
        this.f17898e.onInstallSucc(r48.e().E());
        goto L16
    L11:
        SysAppAutoUpdateAnalytics r13 = this.f17898e;
        String r14 = r48.e().E();
        StringBuilder r15 = new StringBuilder();
        r15.append(r48.a());
        r15.append('@');
        String r16 = r48.b();
        if (r16 != null) goto L14;
        r16 = "";
    L14:
        r15.append(r16);
        r13.onInstallFailed(r14, r15.toString());
    L16:
        if (r48.d() == false) goto L18;
        r10 = AppStatus.i.f17984a;
        goto L5
    L18:
        r10 = AppStatus.g.f17980a;
        goto L5
    }

    public final void h0(CoroutineScope r10, final b.t r11, SendChannel r12) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onInstallSysAppAutoUpdateManually: " + fe.b.a(r11));
        kotlinx.coroutines.h.d(r10, null, null, new AppInstallActor$onInstallSysAppAutoUpdateManually$1(this, r11, r12, null), 3, null).invokeOnCompletion(new AppInstallActor$onInstallSysAppAutoUpdateManually$2(r11));
    }

    public final void i0(CoroutineScope r11, final b.u r12) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onResumeAppInstallTaskRequest: " + fe.b.a(r12));
        String r10 = r12.b();
        final Ref$BooleanRef r13 = new Ref$BooleanRef();
        kotlinx.coroutines.h.d(r11, null, null, new AppInstallActor$onResumeAppInstallTaskRequest$1(this, r10, r12, r13, null), 3, null).invokeOnCompletion(new AppInstallActor$onResumeAppInstallTaskRequest$2(r12, r13));
    }

    public final void j0(String r10) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onTaskCancelled, pkg=" + r10);
        l0(r10);
    }

    public final void k0(PowerManager.WakeLock r10) {
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L5
        if (r10.isHeld() == false) goto L7;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] wake lock release");     // Catch: Throwable -> L5
        r10.release();     // Catch: Throwable -> L5
    L7:
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.a r12 = Result.Companion;
        Result.m35constructorimpl(kotlin.c.a(th));
    }

    public final void l0(final String r10) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] removeTaskFromInstallQueue, pkg=" + r10);
        List r11 = this.f17902i;
        final Function1<com.smt.obric.appstore.domain.app.entity.a, Boolean> r12 = new AppInstallActor$removeTaskFromInstallQueue$1(r10);
        r11.removeIf(new e(r12));
        List r13 = this.f17903j;
        final Function1<com.smt.obric.appstore.domain.app.entity.a, Boolean> r14 = new AppInstallActor$removeTaskFromInstallQueue$2(r10);
        r13.removeIf(new f(r14));
        List r15 = this.f17905l;
        final Function1<com.smt.obric.appstore.domain.app.entity.a, Boolean> r16 = new AppInstallActor$removeTaskFromInstallQueue$3(r10);
        r15.removeIf(new g(r16));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x023e -> B:85:0x02c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x02ae -> B:84:0x02af). Please report as a decompilation issue!!! */
    public final Object p0(Continuation r22) {
        AppInstallActor r10 = this;
        int r11 = 0;
        char r12 = 4;
        char r13 = 5;
        if ((r22 instanceof AppInstallActor$restoreInstallTasks$1) == false) goto L7;
        AppInstallActor$restoreInstallTasks$1 r14 = (AppInstallActor$restoreInstallTasks$1) r22;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L21;
        if (r18 == 2) goto L20;
        if (r18 == 3) goto L19;
        if (r18 == 4) goto L18;
        if (r18 != 5) goto L17;
        com.smt.obric.appstore.domain.app.entity.a r19 = (com.smt.obric.appstore.domain.app.entity.a) r14.L$5;
        Iterator r110 = (Iterator) r14.L$4;
        List r111 = (List) r14.L$3;
        List r112 = (List) r14.L$2;
        List r113 = (List) r14.L$1;
        AppInstallActor r114 = (AppInstallActor) r14.L$0;
        kotlin.c.b(r16);
        char r20 = 4;
        char r21 = 5;
    L84:
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] restoreInstallTasks: buildDownloadTask return null, delete it, task=" + r19.P());
    L85:
        r13 = r21;
        r12 = r20;
        r11 = 0;
    L27:
        if (r110.hasNext() == false) goto L87;
        com.smt.obric.appstore.domain.app.entity.a r23 = (com.smt.obric.appstore.domain.app.entity.a) r110.next();
        AppStatus r24 = r23.G();
        if (q.b(r24, AppStatus.f.f17978a) == false) goto L33;
        r111.add(r23);
        com.smt.obric.appstore.domain.app.jobs.a.f18032a.e(r114.f17895b);
        r20 = r12;
        r21 = r13;
        goto L85
    L33:
        if (q.b(r24, AppStatus.h.f17982a) == false) goto L36;
        r112.add(r23);
        com.smt.obric.appstore.domain.app.jobs.a.f18032a.d(r114.f17895b);
        r20 = r12;
        r21 = r13;
        goto L85
    L36:
        if (q.b(r24, AppStatus.e.f17976a) == false) goto L38;
        boolean r25 = true;
    L39:
        if (r25 == false) goto L70;
        Result.a r26 = Result.Companion;     // Catch: Throwable -> L42
        Object r27 = Result.m35constructorimpl(r114.f17895b.getPackageManager().getPackageInfo(r23.E(), r11));     // Catch: Throwable -> L42
    L45:
        if (Result.m41isFailureimpl(r27) == false) goto L47;
        r27 = null;
    L47:
        PackageInfo r28 = (PackageInfo) r27;
        if (r28 != null) goto L50;
    L68:
        r113.add(r23);
    L67:
        r20 = 4;
        r21 = 5;
        goto L85
    L50:
        if (r28.getLongVersionCode() < r23.J()) goto L68;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] restoreInstallTasks, delete installed task, curStatus=" + r23.G() + ", pkg=" + r23.E() + ", taskVer=" + r23.J() + ", installedVer=" + r28.getLongVersionCode() + ", task=" + r23.P());
        if (r23.M() == false) goto L55;
        r114.f17898e.onInstallSucc(r23.E());
    L55:
        AppInstallTaskDAO r29 = r114.f17896c;
        String r30 = r23.E();
        r14.L$0 = r114;
        r14.L$1 = r113;
        r14.L$2 = r112;
        r14.L$3 = r111;
        r14.L$4 = r110;
        r14.L$5 = r23;
        r14.label = 2;
        if (r29.deleteByPkg(r30, r14) != r17) goto L58;
        return r17;
    L58:
        com.smt.obric.appstore.domain.app.entity.a r31 = r23;
    L59:
        Long r32 = r31.o();
        if (r32 == null) goto L67;
        long r33 = r32.longValue();
        ODownloader r34 = ODownloader.f18038a;
        r14.L$0 = r114;
        r14.L$1 = r113;
        r14.L$2 = r112;
        r14.L$3 = r111;
        r14.L$4 = r110;
        r14.L$5 = null;
        r14.label = 3;
        r16 = r34.v(r33, r14);
        if (r16 != r17) goto L64;
        return r17;
    L64:
        Iterator r35 = r110;
        List r115 = r111;
        List r116 = r112;
        List r117 = r113;
        AppInstallActor r118 = r114;
    L65:
        TaskOperateResult r36 = (TaskOperateResult) r16;
        r114 = r118;
        r20 = 4;
        r21 = 5;
        r113 = r117;
        r112 = r116;
        r111 = r115;
        r110 = r35;
    L42:
        th = move-exception;
        Result.a r37 = Result.Companion;
        r27 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L45
    L70:
        if (q.b(r24, AppStatus.l.f17990a) == false) goto L67;
        if (r23.o() != null) goto L67;
        DownloadTask r38 = n.a(r23);
        if (r38 == null) goto L80;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] restoreInstallTasks, curStatus=TaskEnqueued, submitTask task=" + r23.K());
        ODownloader r39 = ODownloader.f18038a;
        r14.L$0 = r114;
        r14.L$1 = r113;
        r14.L$2 = r112;
        r14.L$3 = r111;
        r14.L$4 = r110;
        r14.L$5 = null;
        r20 = 4;
        r14.label = 4;
        if (r39.A(r38, r14) != r17) goto L78;
        return r17;
    L78:
        Iterator r40 = r110;
        List r119 = r111;
        List r120 = r112;
        List r121 = r113;
        AppInstallActor r122 = r114;
    L79:
        r114 = r122;
        r21 = 5;
        r113 = r121;
        r112 = r120;
        r111 = r119;
        r110 = r40;
        goto L85
    L80:
        r20 = 4;
        AppInstallTaskDAO r41 = r114.f17896c;
        String r42 = r23.E();
        r14.L$0 = r114;
        r14.L$1 = r113;
        r14.L$2 = r112;
        r14.L$3 = r111;
        r14.L$4 = r110;
        r14.L$5 = r23;
        r21 = 5;
        r14.label = 5;
        if (r41.deleteByPkg(r42, r14) != r17) goto L83;
        return r17;
    L83:
        r19 = r23;
        goto L84
    L38:
        r25 = q.b(r24, AppStatus.j.f17986a);
        goto L39
    L87:
        return new c(r113, r112, r111);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r40 = (Iterator) r14.L$4;
        r119 = (List) r14.L$3;
        r120 = (List) r14.L$2;
        r121 = (List) r14.L$1;
        r122 = (AppInstallActor) r14.L$0;
        kotlin.c.b(r16);
        r20 = 4;
        goto L79
    L19:
        r35 = (Iterator) r14.L$4;
        r115 = (List) r14.L$3;
        r116 = (List) r14.L$2;
        r117 = (List) r14.L$1;
        r118 = (AppInstallActor) r14.L$0;
        kotlin.c.b(r16);
        goto L65
    L20:
        r31 = (com.smt.obric.appstore.domain.app.entity.a) r14.L$5;
        r110 = (Iterator) r14.L$4;
        r111 = (List) r14.L$3;
        r112 = (List) r14.L$2;
        r113 = (List) r14.L$1;
        r114 = (AppInstallActor) r14.L$0;
        kotlin.c.b(r16);
        goto L59
    L21:
        List r43 = (List) r14.L$3;
        List r123 = (List) r14.L$2;
        List r124 = (List) r14.L$1;
        AppInstallActor r125 = (AppInstallActor) r14.L$0;
        kotlin.c.b(r16);
        List r44 = r43;
        r10 = r125;
        Object r126 = r16;
    L25:
        Iterator r127 = ((List) r126).iterator();
        r114 = r10;
        r113 = r124;
        r111 = r44;
        r112 = r123;
        r110 = r127;
        goto L27
    L22:
        kotlin.c.b(r16);
        r124 = new ArrayList();
        r123 = new ArrayList();
        r44 = new ArrayList();
        AppInstallTaskDAO r128 = r10.f17896c;
        List<? extends AppStatus> r129 = t.l(new AppStatus[]{AppStatus.e.f17976a, AppStatus.j.f17986a, AppStatus.h.f17982a, AppStatus.f.f17978a, AppStatus.l.f17990a});
        r14.L$0 = r10;
        r14.L$1 = r124;
        r14.L$2 = r123;
        r14.L$3 = r44;
        r14.label = 1;
        r126 = r128.getTasksByState(r129, r14);
        if (r126 != r17) goto L25;
        return r17;
    L7:
        r14 = new AppInstallActor$restoreInstallTasks$1(r10, r22);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v56, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.smt.obric.appstore.domain.app.entity.a] */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.smt.obric.appstore.domain.app.AppInstallActor$b$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.smt.obric.appstore.domain.app.AppInstallActor$b$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v47, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v22 */
    public final Object q0(b.AbstractC0215b r20, SendChannel r21, Continuation r22) {
        AppInstallActor r10 = this;
        ?? r11 = r20;
        if ((r22 instanceof AppInstallActor$syncWithDownloadInfo$1) == false) goto L7;
        AppInstallActor$syncWithDownloadInfo$1 r12 = (AppInstallActor$syncWithDownloadInfo$1) r22;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        switch(r12.label) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        com.smt.obric.appstore.domain.app.entity.a r16 = (com.smt.obric.appstore.domain.app.entity.a) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L15
    L151:
        ?? r17 = new StringBuilder();
        r17.append("[AppStatus][AppInstallActor][InstallStage] syncWithDownloadInfo: complete, task=");
        r11 = r16.P();
        r17.append(r11);
        com.bytedanceos.common.toolbox.j.o(r17.toString());
    L155:
        return Unit.f21064a;
    L17:
        CompletableDeferred r18 = (CompletableDeferred) r12.L$1;
        r16 = (com.smt.obric.appstore.domain.app.entity.a) r12.L$0;
        kotlin.c.b(r14);
    L147:
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor][InstallStage] syncWithDownloadInfo: wait ack, task=" + r16.P());
        r12.L$0 = r16;     // Catch: Throwable -> L15
        r12.L$1 = null;     // Catch: Throwable -> L15
        r12.label = 10;     // Catch: Throwable -> L15
        if (r18.await(r12) != r15) goto L151;
        return r15;
    L18:
        kotlin.c.b(r14);
    L142:
        return Unit.f21064a;
    L19:
        DownloadInfo r19 = (DownloadInfo) r12.L$2;
        SendChannel r23 = (SendChannel) r12.L$1;
        AppInstallActor r24 = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
    L136:
        com.smt.obric.appstore.domain.app.entity.a r25 = (com.smt.obric.appstore.domain.app.entity.a) r14;
        if (r25 != null) goto L143;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] syncWithDownloadInfo: download succ, taskDao.getByDownloadId return null, dlId=" + r19.getId() + ". remove it");
        ODownloader r26 = ODownloader.f18038a;
        long r27 = (long) r19.getId();
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.label = 8;
        if (r26.v(r27, r12) != r15) goto L142;
        return r15;
    L143:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] syncWithDownloadInfo: download succ, enqueue to install, task=" + r25.P());
        r18 = u.b(null, 1, null);
        b.q r28 = new b.q(r25, r18);
        r12.L$0 = r25;
        r12.L$1 = r18;
        r12.L$2 = null;
        r12.label = 9;
        if (r23.send(r28, r12) != r15) goto L146;
        return r15;
    L146:
        r16 = r25;
        goto L147
    L20:
        int r110 = r12.I$0;
        Ref$IntRef r29 = (Ref$IntRef) r12.L$6;
        Ref$IntRef r30 = (Ref$IntRef) r12.L$5;
        DownloadInfo r31 = (DownloadInfo) r12.L$4;
        AppStatus.DownloadStatus r32 = (AppStatus.DownloadStatus) r12.L$3;
        SendChannel r33 = (SendChannel) r12.L$2;
        b.AbstractC0215b r34 = (b.AbstractC0215b) r12.L$1;
        AppInstallActor r35 = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
        ?? r36 = r34;
    L124:
        r29.element = ((Number) r14).intValue();
        Ref$IntRef r111 = r30;
        r19 = r31;
        AppStatus.DownloadStatus r37 = r32;
        r23 = r33;
        ?? r38 = r36;
        AppInstallActor r39 = r35;
    L127:
        if ((r38 instanceof b.i) == true) goto L129;
    L130:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] syncWithDownloadInfo, dlId=" + r19.getId() + ", newStatus=" + r37 + ", downloadInfo=" + com.smt.obric.appstore.domain.downloader.c.a(r19) + ", updated=" + r111.element + ", updateCase=" + r110);
    L132:
        if ((r37 instanceof AppStatus.e) == false) goto L155;
        AppInstallTaskDAO r40 = r39.f17896c;
        long r41 = r19.getId();
        r12.L$0 = r39;
        r12.L$1 = r23;
        r12.L$2 = r19;
        r12.L$3 = null;
        r12.L$4 = null;
        r12.L$5 = null;
        r12.L$6 = null;
        r12.label = 7;
        r14 = r40.getByDownloadId(r41, r12);
        if (r14 != r15) goto L136;
        return r15;
    L129:
        if (j.a() == false) goto L132;
    L21:
        Ref$IntRef r42 = (Ref$IntRef) r12.L$6;
        Ref$IntRef r43 = (Ref$IntRef) r12.L$5;
        DownloadInfo r44 = (DownloadInfo) r12.L$4;
        AppStatus.DownloadStatus r45 = (AppStatus.DownloadStatus) r12.L$3;
        SendChannel r46 = (SendChannel) r12.L$2;
        b.AbstractC0215b r47 = (b.AbstractC0215b) r12.L$1;
        AppInstallActor r48 = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
        Ref$IntRef r112 = r43;
        DownloadInfo r49 = r44;
        r37 = r45;
        SendChannel r50 = r46;
        ?? r51 = r47;
        r39 = r48;
    L114:
        r42.element = ((Number) r14).intValue();
        if (r112.element != 0) goto L125;
        AppInfo r52 = com.smt.obric.appstore.domain.downloader.b.b(r49);
        String r53 = r52.getAppPackageName();
        if (r53 != null) goto L119;
        String r54 = "";
    L120:
        long r113 = r52.appVersionCode;
        AppInstallTaskDAO r55 = r39.f17896c;
        r12.L$0 = r39;
        r12.L$1 = r51;
        r12.L$2 = r50;
        r12.L$3 = r37;
        r12.L$4 = r49;
        r29 = r112;
        r12.L$5 = r29;
        r12.L$6 = r29;
        r12.I$0 = 2;
        r12.label = 6;
        ?? r114 = r51;
        AppInstallActor r115 = r39;
        SendChannel r116 = r50;
        AppStatus.DownloadStatus r117 = r37;
        Object r56 = ge.f.b(r55, r54, r113, r37, r49, r12);
        if (r56 != r15) goto L123;
        return r15;
    L123:
        r33 = r116;
        r32 = r117;
        r36 = r114;
        r35 = r115;
        r110 = 2;
        r14 = r56;
        r31 = r49;
        r30 = r29;
        goto L124
    L119:
        r54 = r53;
        goto L120
    L125:
        r111 = r112;
        r19 = r49;
        r23 = r50;
        r110 = 1;
        r38 = r51;
        goto L127
    L22:
        r10 = (AppInstallActor) r12.L$4;
        AppStatus.DownloadStatus r57 = (AppStatus.DownloadStatus) r12.L$3;
        SendChannel r58 = (SendChannel) r12.L$2;
        b.AbstractC0215b r59 = (b.AbstractC0215b) r12.L$1;
        AppInstallActor r60 = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
        ?? r61 = r59;
    L97:
        com.smt.obric.appstore.domain.app.entity.a r62 = (com.smt.obric.appstore.domain.app.entity.a) r14;
        ?? r63 = r61;
        if (r62 != null) goto L99;
    L76:
        AppStatus.DownloadStatus r64 = r57;
        SendChannel r65 = r58;
        ?? r66 = r63;
        r10 = r60;
    L103:
        if (r64 == null) goto L105;
        DownloadInfo r67 = r66.a();
        if (r67 != null) goto L110;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] syncWithDownloadInfo: downloadInfo is null");
        return Unit.f21064a;
    L110:
        Ref$IntRef r68 = new Ref$IntRef();
        AppInstallTaskDAO r69 = r10.f17896c;
        long r70 = r67.getId();
        r12.L$0 = r10;
        r12.L$1 = r66;
        r12.L$2 = r65;
        r12.L$3 = r64;
        r12.L$4 = r67;
        r12.L$5 = r68;
        r12.L$6 = r68;
        r12.label = 5;
        r112 = r68;
        SendChannel r118 = r65;
        Object r71 = ge.f.a(r69, r70, r64, r67, r12);
        if (r71 != r15) goto L113;
        return r15;
    L113:
        r39 = r10;
        r51 = r66;
        r37 = r64;
        r14 = r71;
        r42 = r112;
        r49 = r67;
        r50 = r118;
        goto L114
    L105:
        return Unit.f21064a;
    L99:
        r63 = r61;
        if (r62.M() == false) goto L76;
        r10.f17898e.onDownloadSuccess(r62.E());
        r63 = r61;
        goto L76
    L23:
        r10 = (AppInstallActor) r12.L$4;
        r57 = (AppStatus.DownloadStatus) r12.L$3;
        r58 = (SendChannel) r12.L$2;
        b.AbstractC0215b r72 = (b.AbstractC0215b) r12.L$1;
        r60 = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
        ?? r73 = r72;
    L83:
        com.smt.obric.appstore.domain.app.entity.a r74 = (com.smt.obric.appstore.domain.app.entity.a) r14;
        r63 = r73;
        if (r74 == null) goto L76;
        r63 = r73;
        if (r74.M() == false) goto L76;
        SysAppAutoUpdateAnalytics r75 = r10.f17898e;
        String r76 = r74.E();
        String r77 = ((b.d) r73).a().getErrorMsg();
        if (r77 != null) goto L90;
        r77 = "";
    L90:
        r75.onDownloadFailed(r76, r77);
        r63 = r73;
        goto L76
    L24:
        r10 = (AppInstallActor) r12.L$4;
        r57 = (AppStatus.DownloadStatus) r12.L$3;
        r58 = (SendChannel) r12.L$2;
        b.AbstractC0215b r78 = (b.AbstractC0215b) r12.L$1;
        r60 = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
        ?? r79 = r78;
    L71:
        com.smt.obric.appstore.domain.app.entity.a r80 = (com.smt.obric.appstore.domain.app.entity.a) r14;
        r63 = r79;
        if (r80 == null) goto L76;
        r63 = r79;
        if (r80.M() == false) goto L76;
        r10.f17898e.onDownloadStart(r80.E());
        r63 = r79;
        goto L76
    L25:
        SendChannel r81 = (SendChannel) r12.L$2;
        b.AbstractC0215b r82 = (b.AbstractC0215b) r12.L$1;
        AppInstallActor r83 = (AppInstallActor) r12.L$0;
        kotlin.c.b(r14);
        SendChannel r84 = r81;
        r10 = r83;
        ?? r85 = r82;
    L29:
        r64 = null;
        ?? r86 = r85;
    L65:
        AppInstallActor$syncWithDownloadInfo$2$getTask$1 r87 = new AppInstallActor$syncWithDownloadInfo$2$getTask$1(r86, r10, null);
        if ((r86 instanceof b.h) == false) goto L78;
        r12.L$0 = r10;
        r12.L$1 = r86;
        r12.L$2 = r84;
        r12.L$3 = r64;
        r12.L$4 = r10;
        r12.label = 2;
        Object r88 = r87.invoke(r12);
        if (r88 != r15) goto L70;
        return r15;
    L70:
        r60 = r10;
        SendChannel r119 = r84;
        r79 = r86;
        r57 = r64;
        r14 = r88;
        r58 = r119;
        goto L71
    L78:
        if ((r86 instanceof b.d) == false) goto L92;
        r12.L$0 = r10;
        r12.L$1 = r86;
        r12.L$2 = r84;
        r12.L$3 = r64;
        r12.L$4 = r10;
        r12.label = 3;
        Object r89 = r87.invoke(r12);
        if (r89 != r15) goto L82;
        return r15;
    L82:
        r60 = r10;
        SendChannel r120 = r84;
        r73 = r86;
        r57 = r64;
        r14 = r89;
        r58 = r120;
        goto L83
    L92:
        if ((r86 instanceof b.e) == false) goto L102;
        r12.L$0 = r10;
        r12.L$1 = r86;
        r12.L$2 = r84;
        r12.L$3 = r64;
        r12.L$4 = r10;
        r12.label = 4;
        Object r90 = r87.invoke(r12);
        if (r90 != r15) goto L96;
        return r15;
    L96:
        r60 = r10;
        SendChannel r121 = r84;
        r61 = r86;
        r57 = r64;
        r14 = r90;
        r58 = r121;
        goto L97
    L102:
        r65 = r84;
        r66 = r86;
        goto L103
    L26:
        kotlin.c.b(r14);
        if ((r11 instanceof b.m) == false) goto L31;
    L28:
        r84 = r21;
        r85 = r11;
        goto L29
    L31:
        if ((r11 instanceof b.n) == true) goto L28;
        if ((r11 instanceof b.j) == true) goto L28;
        if ((r11 instanceof b.c) == false) goto L41;
        AppInstallTaskDAO r91 = r10.f17896c;
        List<Long> r92 = s.e(tf.a.d(((b.c) r11).a().getId()));
        r12.L$0 = r10;
        r12.L$1 = r11;
        r84 = r21;
        r12.L$2 = r84;
        r12.label = 1;
        r85 = r11;
        if (r91.deleteByDownloadId(r92, r12) != r15) goto L29;
        return r15;
    L41:
        r84 = r21;
        if ((r11 instanceof b.d) == false) goto L45;
        r64 = AppStatus.a.f17968a;
        r86 = r11;
        goto L65
    L45:
        if ((r11 instanceof b.e) == false) goto L48;
        r64 = AppStatus.e.f17976a;
        r86 = r11;
        goto L65
    L48:
        if ((r11 instanceof b.f) == false) goto L51;
        r64 = AppStatus.b.f17970a;
        r86 = r11;
        goto L65
    L51:
        if ((r11 instanceof b.g) == false) goto L54;
        r64 = AppStatus.c.f17972a;
        r86 = r11;
        goto L65
    L54:
        if ((r11 instanceof b.h) == false) goto L57;
        r64 = AppStatus.d.f17974a;
        r86 = r11;
        goto L65
    L57:
        if ((r11 instanceof b.i) == false) goto L60;
        r64 = AppStatus.d.f17974a;
        r86 = r11;
        goto L65
    L60:
        if ((r11 instanceof b.k) == false) goto L63;
        r64 = AppStatus.d.f17974a;
        r86 = r11;
        goto L65
    L63:
        if ((r11 instanceof b.l) == false) goto L157;
        r64 = AppStatus.e.f17976a;
        r86 = r11;
        goto L65
    L157:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        th = move-exception;
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor][InstallStage] syncWithDownloadInfo: complete, task=" + r11.P());
        throw th;
    L7:
        r12 = new AppInstallActor$syncWithDownloadInfo$1(r10, r22);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x022f -> B:79:0x025f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0231 -> B:79:0x025f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x02c0 -> B:88:0x02c3). Please report as a decompilation issue!!! */
    public final Object r0(Continuation r15) {
        if ((r15 instanceof AppInstallActor$syncWithDownloader$1) == false) goto L7;
        AppInstallActor$syncWithDownloader$1 r10 = (AppInstallActor$syncWithDownloader$1) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r16 = r10.result;
        Object r12 = kotlin.coroutines.intrinsics.a.d();
        switch(r10.label) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        Iterator r14 = (Iterator) r10.L$1;
        AppInstallActor r13 = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);
    L99:
        if (r14.hasNext() == false) goto L103;
        com.smt.obric.appstore.domain.app.entity.a r17 = (com.smt.obric.appstore.domain.app.entity.a) r14.next();
        AppInstallTaskDAO r18 = r13.f17896c;
        r10.L$0 = r13;
        r10.L$1 = r14;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.label = 8;
        if (r18.upsert(r17, r10) != r12) goto L99;
        return r12;
    L103:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] syncWithDownloader: done");
        return Unit.f21064a;
    L13:
        DownloadInfo r19 = (DownloadInfo) r10.L$3;
        Iterator r20 = (Iterator) r10.L$2;
        List r21 = (List) r10.L$1;
        AppInstallActor r22 = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);
    L89:
        if (((Number) r16).intValue() == 0) goto L90;
    L79:
        Iterator r110 = r20;
        List r111 = r21;
        r13 = r22;
    L60:
        if (r110.hasNext() == false) goto L91;
        Pair r23 = (Pair) r110.next();
        AppStatus r24 = (AppStatus) r23.component1();
        DownloadInfo r25 = (DownloadInfo) r23.component2();
        if (r24 == null) goto L60;
        AppInstallTaskDAO r26 = r13.f17896c;
        long r27 = r25.getId();
        r10.L$0 = r13;
        r10.L$1 = r111;
        r10.L$2 = r110;
        r10.L$3 = r24;
        r10.L$4 = r25;
        r10.label = 5;
        Object r28 = r26.getByDownloadId(r27, r10);
        if (r28 != r12) goto L66;
        return r12;
    L66:
        AppStatus r112 = r24;
        r22 = r13;
        r20 = r110;
        r19 = r25;
        r21 = r111;
        r16 = r28;
    L67:
        com.smt.obric.appstore.domain.app.entity.a r113 = (com.smt.obric.appstore.domain.app.entity.a) r16;
        if (r113 != null) goto L70;
    L85:
        AppInstallTaskDAO r29 = r22.f17896c;
        long r30 = r19.getId();
        r10.L$0 = r22;
        r10.L$1 = r21;
        r10.L$2 = r20;
        r10.L$3 = r19;
        r10.L$4 = null;
        r10.label = 7;
        r16 = ge.f.a(r29, r30, r112, r19, r10);
        if (r16 != r12) goto L89;
        return r12;
    L70:
        if ((r113.G() instanceof AppStatus.f) == false) goto L85;
        if (q.b(r113.p(), r19.getLastModifiedTime()) == true) goto L74;
    L80:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] syncWithDownloader: task DownloadWaitWiFi touched when we are offline, syncWith downloader, newState=" + r112 + ", info=" + com.smt.obric.appstore.domain.downloader.c.a(r19));
        AppInstallTaskDAO r31 = r22.f17896c;
        long r32 = (long) r19.getId();
        r10.L$0 = r22;
        r10.L$1 = r21;
        r10.L$2 = r20;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.label = 6;
        if (ge.f.a(r31, r32, r112, r19, r10) != r12) goto L83;
        return r12;
    L83:
        r110 = r20;
        r111 = r21;
        r13 = r22;
        goto L60
    L74:
        if ((r112 instanceof AppStatus.e) == true) goto L80;
        if (j.a() == false) goto L79;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] syncWithDownloader: task DownloadWaitWiFi untouched when we are offline, ts=" + r113.p() + '/' + r19.getLastModifiedTime() + ", info=" + com.smt.obric.appstore.domain.downloader.c.a(r19));
        goto L79
    L91:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r111.iterator();
    L93:
        if (r115.hasNext() == false) goto L97;
        com.smt.obric.appstore.domain.app.entity.a r33 = n.h((DownloadInfo) r115.next());
        if (r33 == null) goto L93;
        r114.add(r33);
        goto L93
    L97:
        r14 = r114.iterator();
        goto L99
    L90:
        r21.add(r19);
        goto L79
    L14:
        r110 = (Iterator) r10.L$2;
        List r34 = (List) r10.L$1;
        AppInstallActor r35 = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);
        r111 = r34;
        r13 = r35;
        goto L60
    L15:
        r19 = (DownloadInfo) r10.L$4;
        AppStatus r36 = (AppStatus) r10.L$3;
        Iterator r37 = (Iterator) r10.L$2;
        List r38 = (List) r10.L$1;
        AppInstallActor r39 = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);
        r112 = r36;
        r20 = r37;
        r21 = r38;
        r22 = r39;
        goto L67
    L16:
        List r116 = (List) r10.L$1;
        r13 = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);
    L54:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] syncWithDownloader: delete cancelled, deleted=" + ((Number) r16).intValue());
        r111 = new ArrayList();
        ArrayList r40 = new ArrayList(kotlin.collections.u.r(r116, 10));
        Iterator r41 = r116.iterator();
    L56:
        if (r41.hasNext() == false) goto L58;
        r40.add(n.i((DownloadInfo) r41.next()));
        goto L56
    L58:
        r110 = b0.E0(r40, r116).iterator();
        goto L60
    L17:
        r116 = (List) r10.L$1;
        r13 = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);
    L41:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] syncWithDownloader: prune, deleted=" + ((Number) r16).intValue());
        ArrayList r117 = new ArrayList();
        Iterator r42 = r116.iterator();
    L43:
        if (r42.hasNext() == false) goto L47;
        Object r43 = r42.next();
        if (((DownloadInfo) r43).getStatus() != (-4)) goto L43;
        r117.add(r43);
        goto L43
    L47:
        ArrayList r44 = new ArrayList(kotlin.collections.u.r(r117, 10));
        Iterator r118 = r117.iterator();
    L49:
        if (r118.hasNext() == false) goto L51;
        r44.add(tf.a.d(((DownloadInfo) r118.next()).getId()));
        goto L49
    L51:
        AppInstallTaskDAO r119 = r13.f17896c;
        r10.L$0 = r13;
        r10.L$1 = r116;
        r10.label = 4;
        r16 = r119.deleteByDownloadId(r44, r10);
        if (r16 != r12) goto L54;
        return r12;
    L18:
        long r45 = r10.J$0;
        AppInstallActor this = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);     // Catch: TimeoutCancellationException -> L105
    L29:
        List r120 = (List) r16;     // Catch: TimeoutCancellationException -> L105
        if (r120 != null) goto L33;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] syncWithDownloader: getAllDownloadInfo return null");     // Catch: TimeoutCancellationException -> L105
        return Unit.f21064a;
    L33:
        ArrayList r46 = new ArrayList(kotlin.collections.u.r(r120, 10));
        Iterator r47 = r120.iterator();
    L35:
        if (r47.hasNext() == false) goto L37;
        r46.add(tf.a.d(((DownloadInfo) r47.next()).getId()));
        goto L35
    L37:
        AppInstallTaskDAO r48 = this.f17896c;
        r10.L$0 = this;
        r10.L$1 = r120;
        r10.label = 3;
        Object r49 = r48.pruneByDownloadIds(r46, r10);
        if (r49 != r12) goto L40;
        return r12;
    L40:
        r13 = this;
        r116 = r120;
        r16 = r49;
        goto L41
    L21:
        this = (AppInstallActor) r10.L$0;
        kotlin.c.b(r16);
    L25:
        r45 = 10000;
        AppInstallActor$syncWithDownloader$allDownloads$1 r121 = new AppInstallActor$syncWithDownloader$allDownloads$1(null);     // Catch: TimeoutCancellationException -> L105
        r10.L$0 = this;     // Catch: TimeoutCancellationException -> L105
        r10.J$0 = 10000;     // Catch: TimeoutCancellationException -> L105
        r10.label = 2;     // Catch: TimeoutCancellationException -> L105
        r16 = TimeoutKt.c(10000, r121, r10);     // Catch: TimeoutCancellationException -> L105
        if (r16 != r12) goto L29;
        return r12;
    L22:
        kotlin.c.b(r16);
        le.a r122 = le.a.f21945a;
        r10.L$0 = this;
        r10.label = 1;
        if (r122.a(r10) != r12) goto L25;
        return r12;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L105:
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] syncWithDownloader: getAllDownloadInfo timeout " + r45 + "ms");
        return Unit.f21064a;
    L7:
        r10 = new AppInstallActor$syncWithDownloader$1(this, r15);
        goto L8
    }

    public final Object s0(Continuation r10) {
        if ((r10 instanceof AppInstallActor$tryWiFiDownloads$1) == false) goto L7;
        AppInstallActor$tryWiFiDownloads$1 r11 = (AppInstallActor$tryWiFiDownloads$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        kotlin.c.b(r13);
    L22:
        return tf.a.a(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        if (ConnectivityManagerNetworkMonitorKt.f(this.f17895b) == true) goto L18;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][wifiDownloader] tryWiFiDownloads, wifi not connected");
        return tf.a.a(false);
    L18:
        q1 r16 = q1.f21661b;
        AppInstallActor$tryWiFiDownloads$2 r17 = new AppInstallActor$tryWiFiDownloads$2(this, null);
        r11.label = 1;
        if (kotlinx.coroutines.h.g(r16, r17, r11) != r14) goto L22;
        return r14;
    L7:
        r11 = new AppInstallActor$tryWiFiDownloads$1(this, r10);
        goto L8
    }

    public final SendChannel t0(CoroutineScope r10) {
        return kotlinx.coroutines.channels.b.b(r10, null, Channel.UNLIMITED, null, null, new AppInstallActor$wifiDownloader$1(this, null), 13, null);
    }

    public AppInstallActor(CoroutineScope r10, Context r11, AppInstallTaskDAO r12, ReceiveChannel r13, SysAppAutoUpdateAnalytics r14) {
        this.f17894a = r10;
        this.f17895b = r11;
        this.f17896c = r12;
        this.f17897d = r13;
        this.f17898e = r14;
        Flow r15 = kotlinx.coroutines.flow.c.K(r12.getAll(), new AppInstallActor$installTasks$1(null));
        SharingStarted.a r16 = SharingStarted.Companion;
        this.f17899f = kotlinx.coroutines.flow.c.Q(r15, r10, SharingStarted.a.b(r16, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS, 0, 2, null), t.i());
        this.f17900g = u.b(null, 1, null);
        this.f17902i = new ArrayList();
        this.f17903j = new ArrayList();
        this.f17905l = new ArrayList();
        if (oe.b.a() == false) goto L5;
        StateFlow r17 = kotlinx.coroutines.flow.c.Q(new ObricSysappWifiUpdateSetting(r11).values(), r10, r16.c(), null);
    L6:
        this.f17906m = r17;
        return;
    L5:
        r17 = kotlinx.coroutines.flow.c.Q(new v(r11).values(), r10, r16.c(), null);
        goto L6
    }
}
