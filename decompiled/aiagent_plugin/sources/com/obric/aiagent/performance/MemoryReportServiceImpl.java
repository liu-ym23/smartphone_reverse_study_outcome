package com.obric.aiagent.performance;

import android.app.Application;
import android.os.Debug;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.aiagent.privacy.IPrivacyService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.l.n;
import d.o;
import d.x;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: MemoryReportServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemoryReportServiceImpl implements IMemoryReportService {
    private static final String AIAGENT_PROCESS = "aiagent";
    public static final a Companion = null;
    private static final int DEFAULT_MAX_RETRY_COUNT = 2;
    private static final String MEMORY_FILE_DIR = "obric_memory_upload";
    private static final String MEMORY_INFO_ENTRY_NAME = "memoryinfo.txt";
    private static final String MEMORY_SNAPSHOT = "memory_snapshot";
    private static final long MEMORY_STABLE_DELAY_MS = 30000;
    private static final int MIN_THRESHOLD_PSS_KB = 1024;
    private static final String SLARDAR_DID = "4245639790640852";
    private static final String SMAPS_ENTRY_NAME = "smaps.txt";
    public static final String TAG = "MemoryReportServiceImpl";
    private static final int UPLOAD_MEMORY_INFO_SUCCESS = -1;
    private static final String UPLOAD_SCENE = "aiagent_upload";
    private static final String ZIP_EXTENSION = ".zip";
    private final AtomicBoolean hasStartedMonitor;
    private final am ioScope;
    private volatile boolean isUploadingMemoryInfo;
    private volatile int uploadMemoryInfoRetryCount;

    /* JADX INFO: compiled from: MemoryReportServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MemoryReportServiceImpl.kt */
    @f(b = "MemoryReportServiceImpl.kt", c = {247}, d = "mergeUploadMemoryFiles", e = "com.obric.aiagent.performance.MemoryReportServiceImpl")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f18733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18734e;
        final /* synthetic */ MemoryReportServiceImpl f;
        int g;

        b(MemoryReportServiceImpl r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18734e = r3;
            this.g |= Integer.MIN_VALUE;
            return MemoryReportServiceImpl.access$mergeUploadMemoryFiles(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MemoryReportServiceImpl.kt */
    @f(b = "MemoryReportServiceImpl.kt", c = {92, 98, 112}, d = "invokeSuspend", e = "com.obric.aiagent.performance.MemoryReportServiceImpl$startMonitor$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f18737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f18738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18739e;
        final /* synthetic */ String f;
        final /* synthetic */ MemoryReportServiceImpl g;
        private /* synthetic */ Object h;

        c(String r3, MemoryReportServiceImpl r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.g = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f, this.g, r6);
            r0.h = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01e8 -> B:60:0x020f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01f0 -> B:60:0x020f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x020c -> B:60:0x020f). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f18739e;
            int r4 = 2;
            if (r2 == 0) goto L18;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L12;
            if (r2 != 3) goto L11;
            long r8 = this.f18738d;
            float r3 = this.f18737c;
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f18736b, String.class, "com.obric.aiagent.plugin");
            ThresholdItemConfig r10 = (ThresholdItemConfig) ZeusTransformUtils.preCheckCast(this.f18735a, ThresholdItemConfig.class, "com.obric.aiagent.plugin");
            am r11 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            o.a(r21);     // Catch: Throwable -> L61
        L60:
            r4 = 2;
        L43:
            if (an.a(r11) == false) goto L64;
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            this.h = r11;     // Catch: Throwable -> L61
            this.f18735a = r10;     // Catch: Throwable -> L61
            this.f18736b = r5;     // Catch: Throwable -> L61
            this.f18737c = r3;     // Catch: Throwable -> L61
            this.f18738d = r8;     // Catch: Throwable -> L61
            this.f18739e = r4;     // Catch: Throwable -> L61
            if (ax.a(r8, r12) != r0) goto L48;
            return r0;
        L48:
            if (MemoryReportServiceImpl.access$isPrivacyAgreed(this.g) == true) goto L51;
            ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "stop upload monitor, privacy switch disabled");     // Catch: Throwable -> L61
            goto L64
        L51:
            if (MemoryReportServiceImpl.access$shouldUploadMemoryInfo(this.g) == false) goto L64;
            long r13 = Debug.getPss();     // Catch: Throwable -> L61
            ILogDepend.Companion.d(MemoryReportServiceImpl.TAG, "check threshold, totalPssKb=" + r13 + ", thresholdPssKb=" + r3 + ", isUploading=" + MemoryReportServiceImpl.access$isUploadingMemoryInfo$p(this.g));     // Catch: Throwable -> L61
            if (r13 < r3) goto L60;
            if (MemoryReportServiceImpl.access$isUploadingMemoryInfo$p(this.g) == true) goto L60;
            MemoryReportServiceImpl r6 = this.g;     // Catch: Throwable -> L61
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            this.h = r11;     // Catch: Throwable -> L61
            this.f18735a = r10;     // Catch: Throwable -> L61
            this.f18736b = r5;     // Catch: Throwable -> L61
            this.f18737c = r3;     // Catch: Throwable -> L61
            this.f18738d = r8;     // Catch: Throwable -> L61
            this.f18739e = 3;     // Catch: Throwable -> L61
            if (MemoryReportServiceImpl.access$uploadMemoryInfoFilesOnce(r6, r5, r10, r14) != r0) goto L60;
            return r0;
        L64:
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r8 = this.f18738d;
            r3 = this.f18737c;
            r5 = (String) ZeusTransformUtils.preCheckCast(this.f18736b, String.class, "com.obric.aiagent.plugin");
            r10 = (ThresholdItemConfig) ZeusTransformUtils.preCheckCast(this.f18735a, ThresholdItemConfig.class, "com.obric.aiagent.plugin");
            r11 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            o.a(r21);     // Catch: Throwable -> L61
            goto L48
        L15:
            r8 = this.f18738d;
            r3 = this.f18737c;
            r5 = (String) ZeusTransformUtils.preCheckCast(this.f18736b, String.class, "com.obric.aiagent.plugin");
            r10 = (ThresholdItemConfig) ZeusTransformUtils.preCheckCast(this.f18735a, ThresholdItemConfig.class, "com.obric.aiagent.plugin");
            r11 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            o.a(r21);     // Catch: Throwable -> L61
        L39:
            if (MemoryReportServiceImpl.access$retryUploadPendingFile(this.g, r5) == false) goto L43;
            return x.f38692a;
        L18:
            o.a(r21);
            r11 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            ThresholdPssUploadFilesConfig r7 = ThresholdPssUploadFilesConfig.Companion.a();     // Catch: Throwable -> L61
            Map<String, ThresholdItemConfig> r9 = r7.getProcessConfigs();     // Catch: Throwable -> L61
            if (r9 == null) goto L23;
            ThresholdItemConfig r15 = (ThresholdItemConfig) ZeusTransformUtils.preCheckCast(r9.get(MemoryReportServiceImpl.AIAGENT_PROCESS), ThresholdItemConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            if (r15 == null) goto L23;
        L24:
            r10 = r15;
            float r16 = r10.getPssLimit();     // Catch: Throwable -> L61
            long r17 = n.a(r7.getCheckIntervalMs(), 1);     // Catch: Throwable -> L61
            ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "start, trigger=" + this.f + ", config=" + r7);     // Catch: Throwable -> L61
            if (r7.getEnableMemInfo() == true) goto L31;
            if (d.h.b.o.a(IAppContext.Companion.getBuildChannel(), "auto_test") == true) goto L31;
            ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "start ignored, switch disabled");     // Catch: Throwable -> L61
            return x.f38692a;
        L31:
            if (r16 >= 1024.0f) goto L34;
            ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "start ignored, invalid thresholdPssKb=" + r16);     // Catch: Throwable -> L61
            return x.f38692a;
        L34:
            ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "start wait memory stable, delayMs=30000");     // Catch: Throwable -> L61
            d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            this.h = r11;     // Catch: Throwable -> L61
            this.f18735a = r10;     // Catch: Throwable -> L61
            this.f18736b = MemoryReportServiceImpl.SLARDAR_DID;     // Catch: Throwable -> L61
            this.f18737c = r16;     // Catch: Throwable -> L61
            this.f18738d = r17;     // Catch: Throwable -> L61
            this.f18739e = 1;     // Catch: Throwable -> L61
            if (ax.a(30000, r18) != r0) goto L37;
            return r0;
        L37:
            r5 = MemoryReportServiceImpl.SLARDAR_DID;
            r3 = r16;
            r8 = r17;
        L23:
            r15 = new ThresholdItemConfig(false, false, 0.0f, 0, 15, null);     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            ILogDepend.Companion.e(MemoryReportServiceImpl.TAG, "start error, trigger=" + this.f, th);
            goto L64
        }
    }

    /* JADX INFO: compiled from: MemoryReportServiceImpl.kt */
    public static final class d implements com.bytedance.services.apm.api.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryReportServiceImpl f18740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f18741b;

        d(MemoryReportServiceImpl r1, File r2) {
            this.f18740a = r1;
            this.f18741b = r2;
        }

        @Override // com.bytedance.services.apm.api.f
        public void a() {
            MemoryReportServiceImpl.access$cleanupUploadFile(this.f18740a, this.f18741b);
            MemoryReportServiceImpl.access$setUploadMemoryInfoRetryCount$p(this.f18740a, -1);
            MemoryReportServiceImpl.access$setUploadingMemoryInfo$p(this.f18740a, false);
            ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "uploadFileOnce success");
        }

        @Override // com.bytedance.services.apm.api.f
        public void a(String r4) {
            MemoryReportServiceImpl.access$setUploadMemoryInfoRetryCount$p(this.f18740a, MemoryReportServiceImpl.access$getUploadMemoryInfoRetryCount$p(this.f18740a) + 1);
            MemoryReportServiceImpl.access$setUploadingMemoryInfo$p(this.f18740a, false);
            ILogDepend.Companion.e(MemoryReportServiceImpl.TAG, "uploadFileOnce failed, msg=" + r4 + ", retryCount=" + MemoryReportServiceImpl.access$getUploadMemoryInfoRetryCount$p(this.f18740a));
        }
    }

    /* JADX INFO: compiled from: MemoryReportServiceImpl.kt */
    @f(b = "MemoryReportServiceImpl.kt", c = {170}, d = "uploadMemoryInfoFilesOnce", e = "com.obric.aiagent.performance.MemoryReportServiceImpl")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MemoryReportServiceImpl f18745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18746e;

        e(MemoryReportServiceImpl r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18745d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18744c = r3;
            this.f18746e |= Integer.MIN_VALUE;
            return MemoryReportServiceImpl.access$uploadMemoryInfoFilesOnce(this.f18745d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$95DM1uuPDhV0L1b5Q5UFOiqkGzE(MemoryReportServiceImpl r0, IFlowSettingsIDL r1) {
        init$lambda$0(r0, r1);
    }

    public static /* synthetic */ boolean lambda$tiawQa8hs4YZvz18YWPC77TApSg(File r0) {
        return findPendingMemoryInfoFile$lambda$1(r0);
    }

    public MemoryReportServiceImpl() {
        this.ioScope = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
        this.hasStartedMonitor = new AtomicBoolean(false);
    }

    public static final /* synthetic */ void access$cleanupUploadFile(MemoryReportServiceImpl r0, File r1) {
        r0.cleanupUploadFile(r1);
    }

    public static final /* synthetic */ int access$getUploadMemoryInfoRetryCount$p(MemoryReportServiceImpl r0) {
        return r0.uploadMemoryInfoRetryCount;
    }

    public static final /* synthetic */ boolean access$isPrivacyAgreed(MemoryReportServiceImpl r0) {
        return r0.isPrivacyAgreed();
    }

    public static final /* synthetic */ boolean access$isUploadingMemoryInfo$p(MemoryReportServiceImpl r0) {
        return r0.isUploadingMemoryInfo;
    }

    public static final /* synthetic */ Object access$mergeUploadMemoryFiles(MemoryReportServiceImpl r2, ThresholdItemConfig r3, d.c.d r4) {
        return r2.mergeUploadMemoryFiles(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$prepareUploadFile(MemoryReportServiceImpl r2, ThresholdItemConfig r3, d.c.d r4) {
        return r2.prepareUploadFile(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$retryUploadPendingFile(MemoryReportServiceImpl r0, String r1) {
        return r0.retryUploadPendingFile(r1);
    }

    public static final /* synthetic */ void access$setUploadMemoryInfoRetryCount$p(MemoryReportServiceImpl r0, int r1) {
        r0.uploadMemoryInfoRetryCount = r1;
    }

    public static final /* synthetic */ void access$setUploadingMemoryInfo$p(MemoryReportServiceImpl r0, boolean r1) {
        r0.isUploadingMemoryInfo = r1;
    }

    public static final /* synthetic */ boolean access$shouldUploadMemoryInfo(MemoryReportServiceImpl r0) {
        return r0.shouldUploadMemoryInfo();
    }

    public static final /* synthetic */ Object access$uploadMemoryInfoFilesOnce(MemoryReportServiceImpl r2, String r3, ThresholdItemConfig r4, d.c.d r5) {
        return r2.uploadMemoryInfoFilesOnce(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.performance.IMemoryReportService
    public void init() {
        if (at.a(aa.b(IFlowSettingsIDL.class)) == null) goto L6;
        startMonitor("ipc_already_registered");
        return;
    L6:
        at.a(aa.b(IFlowSettingsIDL.class), false, true, new $$Lambda$MemoryReportServiceImpl$95DM1uuPDhV0L1b5Q5UFOiqkGzE(this));
    }

    private static final void init$lambda$0(MemoryReportServiceImpl r2, IFlowSettingsIDL r3) {
        d.h.b.o.e((IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin"), "it");
        r2.startMonitor("ipc_registered_callback");
    }

    private final void startMonitor(String r8) {
        if (this.hasStartedMonitor.compareAndSet(false, true) == true) goto L6;
        ILogDepend.Companion.i(TAG, "startMonitor ignored, trigger=" + r8);
        return;
    L6:
        i.a(this.ioScope, null, null, (m) ZeusTransformUtils.preCheckCast(new c(r8, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean isPrivacyAgreed() {
        IPrivacyService r2 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r2.isAgreed() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private final boolean shouldUploadMemoryInfo() {
        int r2 = this.uploadMemoryInfoRetryCount;
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= 3) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean retryUploadPendingFile(String r6) {
        if (isPrivacyAgreed() == true) goto L6;
        ILogDepend.Companion.i(TAG, "retryUpload stop, privacy not agreed");
        return false;
    L6:
        File r0 = findPendingMemoryInfoFile();
        if (r0 != null) goto L9;
        return false;
    L9:
        ILogDepend.Companion.i(TAG, "retryUpload found pending file");
        if (r0.exists() == true) goto L14;
        ILogDepend.Companion.i(TAG, "retryUpload file missing");
        return false;
    L14:
        if (this.isUploadingMemoryInfo == false) goto L17;
        ILogDepend.Companion.i(TAG, "retryUpload skipped, upload in progress");
        return true;
    L17:
        this.isUploadingMemoryInfo = true;
        uploadFileOnce(r0, r6);
        return true;
    }

    private final File findPendingMemoryInfoFile() {
        File[] r9 = resolveMemoryUploadDir().listFiles($$Lambda$MemoryReportServiceImpl$tiawQa8hs4YZvz18YWPC77TApSg.INSTANCE);
        File r0 = null;
        if (r9 != null) goto L5;
        return null;
    L5:
        int r3 = 1;
        if (r9.length != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L21;
        r0 = r9[0];
        int r2 = d.a.i.f(r9);
        if (r2 == 0) goto L21;
        long r4 = r0.lastModified();
        if (1 > r2) goto L21;
    L16:
        File r5 = r9[r3];
        long r6 = r5.lastModified();
        if (r4 >= r6) goto L19;
        r0 = r5;
        r4 = r6;
    L19:
        if (r3 == r2) goto L21;
        r3 = r3 + 1;
    L21:
        return r0;
    L8:
        r1 = false;
        goto L9
    }

    private static final boolean findPendingMemoryInfoFile$lambda$1(File r4) {
        if (r4.isFile() == false) goto L8;
        String r5 = r4.getName();
        d.h.b.o.c(r5, "getName(...)");
        if (d.o.o.c(r5, ZIP_EXTENSION, false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    private final Object uploadMemoryInfoFilesOnce(String r7, ThresholdItemConfig r8, d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin");
        if ((r0.f18746e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18746e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f18744c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f18746e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f18743b, String.class, "com.obric.aiagent.plugin");
        MemoryReportServiceImpl this = (MemoryReportServiceImpl) ZeusTransformUtils.preCheckCast(r0.f18742a, MemoryReportServiceImpl.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L25:
        File r12 = (File) ZeusTransformUtils.preCheckCast(r11, File.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L29;
        this.uploadMemoryInfoRetryCount++;
        ILogDepend.Companion.i(TAG, "uploadMemoryInfoFilesOnce skipped, dump file failed");
        return x.f38692a;
    L29:
        this.isUploadingMemoryInfo = true;
        this.uploadFileOnce(r12, r7);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        if (shouldUploadMemoryInfo() == true) goto L19;
        ILogDepend.Companion.i(TAG, "uploadMemoryInfoFilesOnce skipped");
        return x.f38692a;
    L19:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L22;
        this.uploadMemoryInfoRetryCount++;
        ILogDepend.Companion.i(TAG, "uploadMemoryInfoFilesOnce skipped, did is blank");
        return x.f38692a;
    L22:
        ILogDepend.Companion.i(TAG, "uploadMemoryInfoFilesOnce start");
        r0.f18742a = this;
        r0.f18743b = r7;
        r0.f18746e = 1;
        r11 = prepareUploadFile(r8, r0);
        if (r11 != r2) goto L25;
        return r2;
    L7:
        r0 = new e(this, r10);
        goto L8
    }

    private final Object prepareUploadFile(ThresholdItemConfig r3, d.c.d<? super File> r4) {
        d.c.d<? super File> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        File r0 = findPendingMemoryInfoFile();
        if (r0 == null) goto L7;
        ILogDepend.Companion.i(TAG, "prepareUploadFile retry");
        return r0;
    L7:
        return mergeUploadMemoryFiles(r3, r5);
    }

    private final void uploadFileOnce(File r13, String r14) {
        if (r13.exists() == true) goto L14;
        this.uploadMemoryInfoRetryCount++;
        this.isUploadingMemoryInfo = false;
        ILogDepend.Companion.i(TAG, "uploadFileOnce file not exists");
        return;
    L14:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L8
        new com.bytedance.apm.k.a().a(String.valueOf(IAppContext.Companion.getAppId()), r14, MEMORY_SNAPSHOT, p.a(r13.getAbsolutePath()), UPLOAD_SCENE, new JSONObject(), (com.bytedance.services.apm.api.f) ZeusTransformUtils.preCheckCast(new d((MemoryReportServiceImpl) ZeusTransformUtils.preCheckCast(this, MemoryReportServiceImpl.class, "com.obric.aiagent.plugin"), r13), com.bytedance.services.apm.api.f.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        Object r15 = d.n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r16 = d.n.c(r15);
        if (r16 == null) goto L16;
        this.uploadMemoryInfoRetryCount++;
        this.isUploadingMemoryInfo = false;
        ILogDepend.Companion.e(TAG, "uploadFileOnce exception, retryCount=" + this.uploadMemoryInfoRetryCount, r16);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        r15 = d.n.f(o.a(th));
        goto L10
    }

    private final void cleanupUploadFile(File r4) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L10
        MemoryReportServiceImpl r3 = (MemoryReportServiceImpl) ZeusTransformUtils.preCheckCast(this, MemoryReportServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r4.exists() == true) goto L6;
    L8:
        Object r5 = d.n.f(x.f38692a);     // Catch: Throwable -> L10
    L12:
        Throwable r6 = d.n.c(r5);
        if (r6 == null) goto L18;
        ILogDepend.Companion.e(TAG, "cleanupUploadFile error", r6);
        return;
    L18:
        return;
    L6:
        if (r4.delete() == true) goto L8;
        ILogDepend.Companion.i(TAG, "cleanupUploadFile delete failed");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r5 = d.n.f(o.a(th));
        goto L12
    }

    private final Object mergeUploadMemoryFiles(ThresholdItemConfig r10, d.c.d<? super File> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.f18734e;
        Object r3 = d.c.a.b.a();
        int r4 = r1.g;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r9 = r1.f18733d;
        File r5 = (File) ZeusTransformUtils.preCheckCast(r1.f18732c, File.class, "com.obric.aiagent.plugin");
        ThresholdItemConfig r6 = (ThresholdItemConfig) ZeusTransformUtils.preCheckCast(r1.f18731b, ThresholdItemConfig.class, "com.obric.aiagent.plugin");
        MemoryReportServiceImpl r2 = (MemoryReportServiceImpl) ZeusTransformUtils.preCheckCast(r1.f18730a, MemoryReportServiceImpl.class, "com.obric.aiagent.plugin");
        o.a(r13);
        long r7 = r9;
        MemoryReportServiceImpl this = r2;
        r10 = r6;
    L18:
        List<? extends File> r14 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L45
        MemoryReportServiceImpl r15 = (MemoryReportServiceImpl) ZeusTransformUtils.preCheckCast(this, MemoryReportServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        File r16 = r5.getParentFile();     // Catch: Throwable -> L45
        if (r16 == null) goto L23;
        d.c.b.a.b.a(r16.mkdirs());     // Catch: Throwable -> L45
    L23:
        if (r5.exists() == false) goto L25;
        r5.delete();     // Catch: Throwable -> L45
    L25:
        OutputStream r0 = (OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r5), OutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        if (ZeusTransformUtils.instanceOf(r0, BufferedOutputStream.class) == false) goto L28;
        BufferedOutputStream r17 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r0, BufferedOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
    L29:
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(r17, OutputStream.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        ZipOutputStream r19 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r18, ZipOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        r19.putNextEntry(new ZipEntry(MEMORY_INFO_ENTRY_NAME));     // Catch: Throwable -> L40
        byte[] r20 = com.obric.aiagent.performance.a.f18747a.a(r7).getBytes(d.o.d.f38623b);     // Catch: Throwable -> L40
        d.h.b.o.c(r20, "getBytes(...)");     // Catch: Throwable -> L40
        r19.write(r20);     // Catch: Throwable -> L40
        r19.closeEntry();     // Catch: Throwable -> L40
        r19.putNextEntry(new ZipEntry(SMAPS_ENTRY_NAME));     // Catch: Throwable -> L40
        Closeable r21 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(new File("/proc/self/smaps")), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r21, FileInputStream.class, "com.obric.aiagent.plugin"), InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r19, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L35
        d.f.c.a(r21, null);     // Catch: Throwable -> L40
        r19.closeEntry();     // Catch: Throwable -> L40
        int r110 = com.obric.aiagent.performance.a.f18747a.a(r19, r14, r10);     // Catch: Throwable -> L40
        d.f.c.a(r18, null);     // Catch: Throwable -> L45
        Object r22 = d.n.f(d.c.b.a.b.a(r110));     // Catch: Throwable -> L45
    L47:
        Throwable r111 = d.n.c(r22);
        if (r111 == null) goto L51;
        r5.delete();
        ILogDepend.Companion.e(TAG, "mergeMemoryFiles error", r111);
    L51:
        if (d.n.a(r22) == false) goto L53;
        d.n.a r112 = d.n.f38560a;
        ((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.aiagent.plugin")).intValue();
        Object r23 = d.n.f(r5);
    L55:
        if (d.n.b(r23) == false) goto L58;
        return null;
    L58:
        return r23;
    L53:
        r23 = d.n.f(r22);
        goto L55
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        d.f.c.a(r21, th);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        d.f.c.a(r18, th);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L28:
        r17 = new BufferedOutputStream(r0, 8192);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        d.n.a r113 = d.n.f38560a;
        r22 = d.n.f(o.a(th));
        goto L47
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        r7 = System.currentTimeMillis();
        File r114 = buildMemoryUploadFile(r7);
        com.obric.aiagent.performance.a r24 = com.obric.aiagent.performance.a.f18747a;
        r1.f18730a = this;
        r1.f18731b = r10;
        r1.f18732c = r114;
        r1.f18733d = r7;
        r1.g = 1;
        Object r25 = r24.a(r7, r10, r1);
        if (r25 != r3) goto L17;
        return r3;
    L17:
        r5 = r114;
        r13 = r25;
    L7:
        r1 = new b(this, r12);
        goto L8
    }

    private final File buildMemoryUploadFile(long r8) {
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L5
        MemoryReportServiceImpl r4 = (MemoryReportServiceImpl) ZeusTransformUtils.preCheckCast(this, MemoryReportServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        String r0 = MEMORY_SNAPSHOT + '_' + com.obric.aiagent.performance.a.f18747a.b(r8) + "__" + IAppContext.Companion.getPackageName() + "." + r4.buildProcessTag() + "__" + com.obric.aiagent.performance.a.f18747a.a() + ZIP_EXTENSION;     // Catch: Throwable -> L5
        d.h.b.o.c(r0, "toString(...)");     // Catch: Throwable -> L5
        Object r1 = d.n.f(new File(r4.resolveMemoryUploadDir(), r0));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = d.n.c(r1);
        if (r5 == null) goto L11;
        ILogDepend.Companion.e(TAG, "buildMemoryUploadFile error, timestamp=" + r8, r5);
    L11:
        if (d.n.c(r1) == null) goto L15;
        r1 = new File(resolveMemoryUploadDir(), "memory_snapshot_" + r8 + ZIP_EXTENSION);
    L15:
        return (File) ZeusTransformUtils.preCheckCast(r1, File.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r1 = d.n.f(o.a(th));
        goto L7
    }

    private final File resolveMemoryUploadDir() {
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        File r0 = r2.getFilesDir();
        if (r0 != null) goto L8;
        r0 = r2.getCacheDir();
        if (r0 != null) goto L8;
        r0 = r2.getDir(MEMORY_FILE_DIR, 0);
    L8:
        return new File(r0, MEMORY_FILE_DIR);
    }

    private final String buildProcessTag() {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(d.o.o.c(IRuntimeContext.Companion.getProcessName(), ':', null, 2, null), ':', '.', false, 4, null), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r9) == false) goto L6;
        r9 = SensitiveType.UNKNOWN;
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    }
}
