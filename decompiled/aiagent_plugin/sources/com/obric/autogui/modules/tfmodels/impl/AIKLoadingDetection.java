package com.obric.autogui.modules.tfmodels.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.model.IAutoActionLocalModelProvider;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.modules.tfmodels.ITFLiteModel;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.b;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.f.a;
import kotlinx.coroutines.f.c;
import org.json.JSONObject;

/* JADX INFO: compiled from: AIKLoadingDetection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIKLoadingDetection implements IAutoActionLocalModelProvider.ImageClassifyModel<String>, ITFLiteModel {
    public static final Companion Companion = null;
    private static final String MODEL_NAME = "oauto_wait";
    private static final String TAG = "LoadingDet/AIK";
    private static final float WAIT_PROB_TRUST_THRESHOLD = 0.9f;
    private AtomicReference<PkgDownloadJob> mDownloadJob;
    private boolean mInitialized;
    private IBaseModel mModel;
    private a mModelLoadingMutex;
    private boolean mNeedReInitialize;
    private boolean mSupported;

    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    private static final class PkgDownloadJob {
        private final String oldVersion;
        private final long startedMillis;

        public static /* synthetic */ PkgDownloadJob copy$default(PkgDownloadJob r0, long r1, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.startedMillis;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r0.oldVersion;
        L9:
            return r0.copy(r1, r3);
        }

        public final long component1() {
            return this.startedMillis;
        }

        public final String component2() {
            return this.oldVersion;
        }

        public final PkgDownloadJob copy(long r1, String r3) {
            o.e(r3, "oldVersion");
            return new PkgDownloadJob(r1, r3);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, PkgDownloadJob.class) == true) goto L8;
            return false;
        L8:
            PkgDownloadJob r10 = (PkgDownloadJob) ZeusTransformUtils.preCheckCast(r9, PkgDownloadJob.class, "com.obric.aiagent.plugin");
            if (this.startedMillis == r10.startedMillis) goto L12;
            return false;
        L12:
            if (o.a(this.oldVersion, r10.oldVersion) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.startedMillis) * 31) + this.oldVersion.hashCode();
        }

        public String toString() {
            return "PkgDownloadJob(startedMillis=" + this.startedMillis + ", oldVersion=" + this.oldVersion + ')';
        }

        public PkgDownloadJob(long r2, String r4) {
            o.e(r4, "oldVersion");
            this.startedMillis = r2;
            this.oldVersion = r4;
        }

        public final long getStartedMillis() {
            return this.startedMillis;
        }

        public final String getOldVersion() {
            return this.oldVersion;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection$dealWithAvailablePackage$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    @f(b = "AIKLoadingDetection.kt", c = {220}, d = "dealWithAvailablePackage", e = "com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection")
    static final class AnonymousClass1 extends d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKLoadingDetection this$0;

        AnonymousClass1(AIKLoadingDetection r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return AIKLoadingDetection.access$dealWithAvailablePackage(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection$deinitialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    @f(b = "AIKLoadingDetection.kt", c = {BDAbstractUpload.KeyIsSDKRetryPolicy}, d = "deinitialize", e = "com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection")
    static final class C11531 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKLoadingDetection this$0;

        C11531(AIKLoadingDetection r3, d.c.d<? super C11531> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.deinitialize((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection$inference$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    @f(b = "AIKLoadingDetection.kt", c = {BDAbstractUpload.KeyIsRetryStatesDir, 449, 332}, d = "inference", e = "com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection")
    static final class C11541 extends d {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKLoadingDetection this$0;

        C11541(AIKLoadingDetection r3, d.c.d<? super C11541> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.inference(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection$initialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    @f(b = "AIKLoadingDetection.kt", c = {98, 112}, d = "initialize", e = "com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection")
    static final class C11551 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKLoadingDetection this$0;

        C11551(AIKLoadingDetection r3, d.c.d<? super C11551> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.initialize(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection$launchDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    @f(b = "AIKLoadingDetection.kt", c = {181, 198}, d = "invokeSuspend", e = "com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection$launchDownload$1")
    static final class C11561 extends l implements b<d.c.d<? super x>, Object> {
        final /* synthetic */ PackageResource $pkg;
        int label;
        final /* synthetic */ AIKLoadingDetection this$0;

        C11561(PackageResource r3, AIKLoadingDetection r4, d.c.d<? super C11561> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.$pkg = r3;
            this.this$0 = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C11561(this.$pkg, this.this$0, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d.c.d<? super x> r3) {
            return ((C11561) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), C11561.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return invoke2((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            d.o.a(r14);     // Catch: Throwable -> L12
        L33:
            AIKLoadingDetection.access$getMDownloadJob$p(this.this$0).set(null);
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r14);     // Catch: Throwable -> L12
            Object r15 = ((n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L12
        L19:
            if (n.b(r15) == false) goto L21;
            Object r2 = null;
        L22:
            PackageResource r3 = (PackageResource) ZeusTransformUtils.preCheckCast(r2, PackageResource.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
            if (r3 != null) goto L25;
        L37:
            Loog.INSTANCE.e(AIKLoadingDetection.TAG, " - [LoadingDet/AIK][DOWNLOAD] failed. ret=" + r3 + ", exc=" + n.c(r15));     // Catch: Throwable -> L12
            Throwable r16 = n.c(r15);     // Catch: Throwable -> L12
            if (ZeusTransformUtils.instanceOf(r16, AIKernelException.class) == false) goto L40;
            AIKernelException r17 = (AIKernelException) ZeusTransformUtils.preCheckCast(r16, AIKernelException.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        L41:
            if (r17 == null) goto L43;
            Integer r4 = d.c.b.a.b.a(r17.getCode());     // Catch: Throwable -> L12
        L44:
            if (r17 == null) goto L46;
            String r5 = r17.getMessage();     // Catch: Throwable -> L12
        L47:
            if (r17 == null) goto L49;
            Throwable r6 = r17.getCause();     // Catch: Throwable -> L12
        L50:
            Loog.INSTANCE.e(AIKLoadingDetection.TAG, " - [LoadingDet/AIK][DOWNLOAD] AIKError: code=" + r4 + ", msg=" + r5 + ", cause=" + r6, (Throwable) ZeusTransformUtils.preCheckCast(r17, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
            x r18 = x.f38692a;     // Catch: Throwable -> L12
        L35:
            AIKLoadingDetection.access$getMDownloadJob$p(this.this$0).set(null);
            return r18;
        L49:
            r6 = null;
            goto L50
        L46:
            r5 = null;
            goto L47
        L43:
            r4 = null;
            goto L44
        L40:
            r17 = null;
            goto L41
        L25:
            if (n.b(r15) == true) goto L37;
            if (r3.isAvailable() == false) goto L34;
            Loog.INSTANCE.i(AIKLoadingDetection.TAG, " - [LoadingDet/AIK][DOWNLOAD] new package (v." + r3.getVersion() + ") is available.");     // Catch: Throwable -> L12
            AIKLoadingDetection r19 = this.this$0;     // Catch: Throwable -> L12
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
            this.label = 2;     // Catch: Throwable -> L12
            if (AIKLoadingDetection.access$dealWithAvailablePackage(r19, r3, r7) != r0) goto L33;
            return r0;
        L34:
            Loog.INSTANCE.e(AIKLoadingDetection.TAG, " - [LoadingDet/AIK][DOWNLOAD] new package (v." + r3.getVersion() + ") isn't available (" + r3 + ").");     // Catch: Throwable -> L12
            r18 = x.f38692a;     // Catch: Throwable -> L12
            goto L35
        L21:
            r2 = r15;
            goto L22
        L14:
            d.o.a(r14);
            IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
            PackageResource r9 = this.$pkg;     // Catch: Throwable -> L12
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
            this.label = 1;     // Catch: Throwable -> L12
            r15 = IAIKernelManager.DefaultImpls.m396updatePackage0E7RQCE$default(r8, r9, null, r10, 2, null);     // Catch: Throwable -> L12
            if (r15 != r0) goto L19;
            return r0;
        L12:
            th = move-exception;
            Loog.INSTANCE.e(AIKLoadingDetection.TAG, " - [LoadingDet/AIK][DOWNLOAD] failed (exception when running the job). e=" + th, th);     // Catch: Throwable -> L56
        L56:
            th = move-exception;
            AIKLoadingDetection.access$getMDownloadJob$p(this.this$0).set(null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection$loadModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKLoadingDetection.kt */
    @f(b = "AIKLoadingDetection.kt", c = {BDAbstractUpload.KeyIsSDKRetryPolicy, 231}, d = "loadModel", e = "com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection")
    static final class C11571 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKLoadingDetection this$0;

        C11571(AIKLoadingDetection r3, d.c.d<? super C11571> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return AIKLoadingDetection.access$loadModel(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX INFO: renamed from: lambda$6OFGrod5wpUCYNr-TLwlsEsFvLk, reason: not valid java name */
    public static /* synthetic */ x m820lambda$6OFGrod5wpUCYNrTLwlsEsFvLk(z.f r0, int r1, String r2, JSONObject r3) {
        return inference$lambda$12$lambda$11(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$SPrfpnf9VsGUVjdSHnzNcQ0Y_KY(Bitmap r0, Bundle r1) {
        return inference$lambda$12$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ x lambda$UwfOztt1ehzrhjhEihnIoJK0dw8(z.f r0, z.f r1, boolean r2, Object r3, JSONObject r4) {
        return inference$lambda$12$lambda$10(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$egKSNsj8Zc7hBRfchAaL_cNNpII(Bitmap r0, RequestParams r1) {
        return inference$lambda$12$lambda$9(r0, r1);
    }

    public AIKLoadingDetection() {
        this.mDownloadJob = new AtomicReference(null);
        this.mModelLoadingMutex = c.a(false, 1, null);
    }

    public static final /* synthetic */ Object access$dealWithAvailablePackage(AIKLoadingDetection r2, PackageResource r3, d.c.d r4) {
        return r2.dealWithAvailablePackage(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$dealWithFetchedPackage(AIKLoadingDetection r2, PackageResource r3, d.c.d r4) {
        return r2.dealWithFetchedPackage(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReference access$getMDownloadJob$p(AIKLoadingDetection r0) {
        return r0.mDownloadJob;
    }

    public static final /* synthetic */ Object access$loadModel(AIKLoadingDetection r2, String r3, d.c.d r4) {
        return r2.loadModel(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final List<Float> softmax(List<Float> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [JudgeV2][LoadingDet/AIK][INFER]~input." + r6);
        Float r8 = p.u((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L15;
        float r9 = r8.floatValue();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r1.add(Float.valueOf((float) Math.exp(((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r9)));
        goto L6
    L8:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        float r13 = p.D((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"));
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        r2.add(Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r15.next(), Number.class, "com.obric.aiagent.plugin")).floatValue() / r13));
        goto L10
    L12:
        List<Float> r16 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [JudgeV2][LoadingDet/AIK][INFER]~output." + r16);
        return r16;
    L15:
        throw new IllegalStateException("logits not empty".toString());
    }

    @Override // com.obric.autogui.modules.tfmodels.ITFLiteModel
    public Object initialize(Context r11, d.c.d<? super x> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C11551.class) == false) goto L7;
        C11551 r15 = (C11551) ZeusTransformUtils.preCheckCast(r14, C11551.class, "com.obric.aiagent.plugin");
        if ((r15.label & Integer.MIN_VALUE) == 0) goto L7;
        r15.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r15.result;
        Object r0 = d.c.a.b.a();
        int r2 = r15.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        d.o.a(r16);
    L35:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIKLoadingDetection this = (AIKLoadingDetection) ZeusTransformUtils.preCheckCast(r15.L$0, AIKLoadingDetection.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
        Object r17 = ((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin")).a();
    L24:
        if (n.b(r17) == false) goto L26;
        Object r3 = null;
    L27:
        PackageResource r1 = (PackageResource) ZeusTransformUtils.preCheckCast(r3, PackageResource.class, "com.obric.aiagent.plugin");
        if (n.a(r17) == false) goto L36;
        if (r1 == null) goto L36;
        this.mSupported = true;
        r15.L$0 = null;
        r15.label = 2;
        if (this.dealWithFetchedPackage(r1, r15) != r0) goto L35;
        return r0;
    L36:
        Loog.INSTANCE.e(TAG, "[LoadingDet/AIK] this pkg `oauto_wait` isn't (currently) supported on this device (pkg=" + r1 + ", found=" + n.a(r17) + ").", n.c(r17));
        this.dealWithInitialisationException(n.c(r17));
        return x.f38692a;
    L26:
        r3 = r17;
        goto L27
    L16:
        d.o.a(r16);
        if (this.mInitialized == true) goto L19;
        IAIKernelManager r4 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.aiagent.plugin");
        r15.L$0 = this;
        r15.label = 1;
        r17 = IAIKernelManager.DefaultImpls.m395getPackage0E7RQCE$default(r4, MODEL_NAME, null, r15, 2, null);
        if (r17 != r0) goto L24;
        return r0;
    L19:
        return x.f38692a;
    L7:
        r15 = new C11551(this, r14);
        goto L8
    }

    private final void dealWithInitialisationException(Throwable r9) {
        if (ZeusTransformUtils.instanceOf(r9, AIKernelException.class) == false) goto L7;
        int r0 = ((AIKernelException) ZeusTransformUtils.preCheckCast(r9, AIKernelException.class, "com.obric.aiagent.plugin")).getCode();
        Loog.INSTANCE.e(TAG, "[LoadingDet/AIK] init-AIKError --> code=" + r0 + ", msg=" + ((AIKernelException) ZeusTransformUtils.preCheckCast(r9, AIKernelException.class, "com.obric.aiagent.plugin")).getMessage() + ", cause=" + ((AIKernelException) ZeusTransformUtils.preCheckCast(r9, AIKernelException.class, "com.obric.aiagent.plugin")).getCause(), r9);
        if (r0 != 102) goto L9;
        this.mInitialized = false;
        this.mNeedReInitialize = true;
        this.mSupported = false;
        return;
    L9:
        return;
    L7:
        Loog.INSTANCE.e(TAG, "[LoadingDet/AIK] init-unexpected-error --> e=" + r9, r9);
        this.mInitialized = false;
        this.mNeedReInitialize = false;
        this.mSupported = false;
    }

    private final Object dealWithFetchedPackage(PackageResource r4, d.c.d<? super x> r5) {
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (r4.isAvailable() == false) goto L13;
        if (r4.isDownloaded() == true) goto L7;
        Loog.INSTANCE.d(TAG, " - [LoadingDet/AIK][INIT] downloadable update available.");
        launchDownload(r4);
    L7:
        Object r3 = dealWithAvailablePackage(r4, r6);
        if (r3 != d.c.a.b.a()) goto L11;
        return r3;
    L11:
        return x.f38692a;
    L13:
        if (r4.isProvisioned() == true) goto L17;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INIT] this device does not support this pkg. pkg=" + r4);
        return x.f38692a;
    L17:
        if (r4.isDownloaded() == true) goto L20;
        Loog.INSTANCE.i(TAG, " - [LoadingDet/AIK][INIT] the package isn't downloaded. downloading.");
        launchDownload(r4);
    L20:
        return x.f38692a;
    }

    private final void launchDownload(PackageResource r7) {
        long r0 = AOSystemTools.INSTANCE.nowTimeMillis();
        PkgDownloadJob r2 = new PkgDownloadJob(r0, r7.getVersion());
        if (this.mDownloadJob.compareAndSet(null, r2) == true) goto L9;
        PkgDownloadJob r6 = (PkgDownloadJob) ZeusTransformUtils.preCheckCast(this.mDownloadJob.get(), PkgDownloadJob.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][DOWNLOAD] there're one running job in progress.");
        return;
    L7:
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][DOWNLOAD] running download-job (started " + (r0 - r6.getStartedMillis()) + "ms ago).");
        return;
    L9:
        runInBg("AIK-Download-" + r2.getStartedMillis(), (b) ZeusTransformUtils.preCheckCast(new C11561(r7, this, null), b.class, "com.obric.aiagent.plugin"));
    }

    private final Object dealWithAvailablePackage(PackageResource r9, d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r11, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = d.c.a.b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r8 = r0.J$0;
        z.a r4 = (z.a) ZeusTransformUtils.preCheckCast(r0.L$2, z.a.class, "com.obric.aiagent.plugin");
        z.a r5 = (z.a) ZeusTransformUtils.preCheckCast(r0.L$1, z.a.class, "com.obric.aiagent.plugin");
        AIKLoadingDetection r1 = (AIKLoadingDetection) ZeusTransformUtils.preCheckCast(r0.L$0, AIKLoadingDetection.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L21:
        r4.f38499a = ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Loog.INSTANCE.i(TAG, " - [LoadingDet/AIK][PKG] load-time: " + (System.currentTimeMillis() - r8) + "ms, load-ok=" + r5.f38499a);
        r1.mInitialized = true;
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        if (r9.isAvailable() == true) goto L17;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][PKG] pkg isn't available. pkg=" + r9);
    L17:
        Loog.INSTANCE.i(TAG, " - [LoadingDet/AIK][PKG] using available pkg (v." + r9.getVersion() + ", name=" + r9.getName() + ')');
        z.a r13 = new z.a();
        long r6 = System.currentTimeMillis();
        r0.L$0 = this;
        r0.L$1 = r13;
        r0.L$2 = r13;
        r0.J$0 = r6;
        r0.label = 1;
        r12 = loadModel(MODEL_NAME, r0);
        if (r12 != r2) goto L20;
        return r2;
    L20:
        r1 = this;
        r4 = r13;
        r5 = r4;
        r8 = r6;
    L7:
        r0 = new AnonymousClass1(this, r11);
        goto L8
    }

    private final Object loadModel(String r18, d.c.d<? super Boolean> r19) {
        AIKLoadingDetection r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C11571.class) == false) goto L7;
        C11571 r4 = (C11571) ZeusTransformUtils.preCheckCast(r2, C11571.class, "com.obric.aiagent.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        C11571 r9 = r4;
        Object r3 = r9.result;
        Object r5 = d.c.a.b.a();
        int r6 = r9.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r9.L$1, a.class, "com.obric.aiagent.plugin");
        r0 = (AIKLoadingDetection) ZeusTransformUtils.preCheckCast(r9.L$0, AIKLoadingDetection.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15
    L27:
        IBaseModel r1 = (IBaseModel) ZeusTransformUtils.preCheckCast(r3, IBaseModel.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r1 != null) goto L32;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][MODEL-LOAD] failed to load model. check AIKernel error.");     // Catch: Throwable -> L15
        Boolean r8 = d.c.b.a.b.a(false);     // Catch: Throwable -> L15
        r7.b(null);
        return r8;
    L32:
        Loog.INSTANCE.d(TAG, " - [LoadingDet/AIK][MODEL-LOAD] substituting model from " + r0.mModel + " to " + r1);     // Catch: Throwable -> L15
        r0.mModel = r1;     // Catch: Throwable -> L15
        Boolean r10 = d.c.b.a.b.a(true);     // Catch: Throwable -> L15
        r7.b(null);
        return r10;
    L15:
        th = th;
    L45:
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][MODEL-LOAD] failed to load model. e=" + th, th);     // Catch: Throwable -> L40
        Boolean r11 = d.c.b.a.b.a(false);     // Catch: Throwable -> L40
        r7.b(null);
        return r11;
    L40:
        th = move-exception;
        r7.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        a r12 = (a) ZeusTransformUtils.preCheckCast(r9.L$2, a.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r9.L$1, String.class, "com.obric.aiagent.plugin");
        AIKLoadingDetection r14 = (AIKLoadingDetection) ZeusTransformUtils.preCheckCast(r9.L$0, AIKLoadingDetection.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        String r15 = r13;
        a r16 = r12;
        r0 = r14;
    L43:
        IAIKernelManager r17 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        RequestParams r20 = new RequestParams(null, null, 3, null);     // Catch: Throwable -> L35
        r9.L$0 = r0;     // Catch: Throwable -> L35
        r9.L$1 = r16;     // Catch: Throwable -> L35
        r9.L$2 = null;     // Catch: Throwable -> L35
        r9.label = 2;     // Catch: Throwable -> L35
        r3 = IAIKernelManager.DefaultImpls.loadPackage$default(r17, r15, false, r20, r9, 2, null);     // Catch: Throwable -> L35
        if (r3 != r5) goto L26;
        return r5;
    L26:
        r7 = r16;
    L35:
        th = th;
        r7 = r16;
        goto L45
    L20:
        d.o.a(r3);
        r16 = r0.mModelLoadingMutex;
        r9.L$0 = r0;
        r15 = r18;
        r9.L$1 = r15;
        r9.L$2 = r16;
        r9.label = 1;
        if (r16.a(null, r9) != r5) goto L43;
        return r5;
    L7:
        r4 = new C11571(r0, r2);
        goto L8
    }

    private final void runInBg(String r3, b<? super d.c.d<? super x>, ? extends Object> r4) {
        final b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        new Thread((Runnable) ZeusTransformUtils.preCheckCast(new AIKLoadingDetection$runInBg$$inlined$Runnable$1(r2), Runnable.class, "com.obric.aiagent.plugin"), r3).start();
    }

    private final <T> Object withModel(m<? super IBaseModel, ? super d.c.d<? super T>, ? extends Object> r9, d.c.d<? super T> r10) {
        m r11 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
    L4:
        if (this.mInitialized == true) goto L10;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] the model isn't initialized. need-reinit=" + this.mNeedReInitialize);
        if (this.mNeedReInitialize == false) goto L8;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] the model needs reinitialisation. do it now!");
        this.mNeedReInitialize = false;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.m.a(0);
        initialize(r0, r12);
        d.h.b.m.a(1);
        goto L4
    L8:
        return null;
    L10:
        if (this.mSupported == true) goto L13;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] this model isn't supported on this device.");
        return null;
    L13:
        a r1 = this.mModelLoadingMutex;
        d.h.b.m.a(0);
        r1.a(null, r12);
        d.h.b.m.a(1);
        IBaseModel r8 = this.mModel;     // Catch: Throwable -> L27
        if (r8 != null) goto L30;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] the model isn't loaded while it's being referenced.");     // Catch: Throwable -> L27
        d.h.b.m.b(4);
        r1.b(null);
        d.h.b.m.c(4);
        return null;
    L30:
        d.h.b.m.a(3);     // Catch: Throwable -> L23
        d.h.b.m.a(0);     // Catch: Throwable -> L23
        Object r13 = r11.invoke(r8, null);     // Catch: Throwable -> L23
        d.h.b.m.a(1);     // Catch: Throwable -> L23
        d.h.b.m.b(2);
        r1.b(null);
        d.h.b.m.c(2);
        return r13;
    L23:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] failed to use the model. e=" + th, th);     // Catch: Throwable -> L27
        d.h.b.m.b(3);
        r1.b(null);
        d.h.b.m.c(3);
        return null;
    L27:
        th = move-exception;
        d.h.b.m.b(1);
        r1.b(null);
        d.h.b.m.c(1);
        throw th;
    }

    private final void dumpInferenceInputBitmap(Bitmap r7, long r8) {
        File r1 = new File("/data/data/com.larus.nova/files/zeus_com.obric.aiagent.plugin/AutoOperator");     // Catch: Throwable -> L19
        if (r1.exists() == false) goto L6;
    L9:
        File r2 = new File(r1, "aik_loading_det_input_" + r8 + '_' + r7.getWidth() + 'x' + r7.getHeight() + ".png");     // Catch: Throwable -> L19
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        FileOutputStream r3 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r9, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r7.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) ZeusTransformUtils.preCheckCast(r3, OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        r3.flush();     // Catch: Throwable -> L14
        x r6 = x.f38692a;     // Catch: Throwable -> L14
        d.f.c.a(r9, null);     // Catch: Throwable -> L19
        Loog.INSTANCE.i(TAG, " - [LoadingDet/AIK][INFER] saved input bitmap -> " + r2.getAbsolutePath());     // Catch: Throwable -> L19
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.f.c.a(r9, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L6:
        if (r1.mkdirs() == true) goto L9;
        Loog.INSTANCE.w(TAG, " - [LoadingDet/AIK][INFER] failed to create dir: " + r1.getAbsolutePath());     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to save input bitmap. e=" + th, th);
    }

    @Override // com.obric.autogui.common.api.model.IAutoActionLocalModelProvider.ImageClassifyModel
    public Object inference(Bitmap r18, d.c.d<? super com.obric.autogui.common.d<String>> r19) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C11541.class) == false) goto L7;
        C11541 r4 = (C11541) ZeusTransformUtils.preCheckCast(r2, C11541.class, "com.obric.aiagent.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
        AIKLoadingDetection r5 = this;
    L8:
        Object r3 = r4.result;
        Object r6 = d.c.a.b.a();
        int r7 = r4.label;
        com.obric.autogui.common.d r13 = null;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L19;
        long r8 = r4.J$1;
        long r9 = r4.J$0;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r4.L$1, a.class, "com.obric.aiagent.plugin");
        Bitmap r10 = (Bitmap) ZeusTransformUtils.preCheckCast(r4.L$0, Bitmap.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L16
    L45:
        Response r11 = (Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        long r12 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L16
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new AIKLoadingDetection$inference$ret$1$1(r10, null), m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        Loog.INSTANCE.d(TAG, " - [LoadingDet/AIK][INFER] inference-timing: all=" + (r12 - r9) + "ms, param-time=" + (r8 - r9) + "ms, infer-time=" + (r12 - r8) + "ms");     // Catch: Throwable -> L16
        if (r11 != null) goto L48;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to get inference result (NULL).");     // Catch: Throwable -> L16
        com.obric.autogui.common.d r0 = com.obric.autogui.common.d.f29012a.a("infer_result_null");     // Catch: Throwable -> L16
    L54:
        r1.b(null);
        r13 = r0;
    L72:
        if (r13 != null) goto L75;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to get inference result (model-uninitialized).");
        return com.obric.autogui.common.d.f29012a.a("failed to get inference result");
    L75:
        return r13;
    L48:
        final z.f r14 = new z.f();     // Catch: Throwable -> L16
        final z.f r15 = new z.f();     // Catch: Throwable -> L16
        r15.f38504a = "";     // Catch: Throwable -> L16
        ResponseKt.fail(ResponseKt.ok(r11, new $$Lambda$AIKLoadingDetection$UwfOztt1ehzrhjhEihnIoJK0dw8(r15, r14)), new $$Lambda$AIKLoadingDetection$6OFGrod5wpUCYNrTLwlsEsFvLk(r15));     // Catch: Throwable -> L16
        float[] r16 = (float[]) ZeusTransformUtils.preCheckCast(r14.f38504a, float[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r16 != null) goto L52;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to get inference result (ERROR).");     // Catch: Throwable -> L16
        r0 = com.obric.autogui.common.d.f29012a.a((String) ZeusTransformUtils.preCheckCast(r15.f38504a, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        goto L54
    L52:
        if (r16.length == 2) goto L55;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to get inference result (SizeMismatched=" + r16.length + ").");     // Catch: Throwable -> L16
        r0 = com.obric.autogui.common.d.f29012a.a("infer_result_dim_mismatch__" + r16.length);     // Catch: Throwable -> L16
        goto L54
    L55:
        Loog.INSTANCE.d(TAG, " - [JudgeV2][LoadingDet/AIK][INFER] logits=" + r16[0] + ", " + r16[1] + '.');     // Catch: Throwable -> L16
        int r17 = r16.length;     // Catch: Throwable -> L16
        int r20 = 1;
        int r21 = 0;
    L56:
        if (r20 >= r17) goto L61;
        if (r16[r20] <= r16[r21]) goto L60;
        r21 = r20;
    L60:
        r20 = r20 + 1;     // Catch: Throwable -> L16
        goto L56
    L61:
        Loog.INSTANCE.d(TAG, " - [LoadingDet/AIK][INFER] logits=" + r16[0] + ", " + r16[1] + '.');     // Catch: Throwable -> L16
        com.obric.autogui.common.d.a r22 = com.obric.autogui.common.d.f29012a;     // Catch: Throwable -> L16
        if (r21 != 0) goto L64;
        String r23 = "unwait";
    L65:
        com.obric.autogui.common.d r24 = r22.a(r23);     // Catch: Throwable -> L16
        r1.b(null);
        return r24;
    L64:
        r23 = "wait";
    L16:
        th = th;
    L83:
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] failed to use the model. e=" + th, th);     // Catch: Throwable -> L76
        r1.b(null);
    L76:
        th = th;
        a r25 = r1;
    L79:
        r25.b(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        a r26 = (a) ZeusTransformUtils.preCheckCast(r4.L$2, a.class, "com.obric.aiagent.plugin");
        AIKLoadingDetection r27 = (AIKLoadingDetection) ZeusTransformUtils.preCheckCast(r4.L$1, AIKLoadingDetection.class, "com.obric.aiagent.plugin");
        final Bitmap r28 = (Bitmap) ZeusTransformUtils.preCheckCast(r4.L$0, Bitmap.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r25 = r26;
    L86:
        IBaseModel r29 = r27.mModel;     // Catch: Throwable -> L78
        if (r29 != null) goto L81;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] the model isn't loaded while it's being referenced.");     // Catch: Throwable -> L78
        r25.b(null);
        goto L72
    L81:
        d.c.d r30 = (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        long r110 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L68
        RequestParams r31 = new RequestParams(null, new $$Lambda$AIKLoadingDetection$egKSNsj8Zc7hBRfchAaL_cNNpII(r28), 1, null);     // Catch: Throwable -> L68
        long r32 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L68
        Loog.INSTANCE.d(TAG, " - [LoadingDet/AIK][INFER] started inferring.");     // Catch: Throwable -> L68
        r4.L$0 = r28;     // Catch: Throwable -> L68
        r4.L$1 = r25;     // Catch: Throwable -> L68
        r4.L$2 = null;     // Catch: Throwable -> L68
        r4.J$0 = r110;     // Catch: Throwable -> L68
        r4.J$1 = r32;     // Catch: Throwable -> L68
        r4.label = 3;     // Catch: Throwable -> L68
        Object r33 = r29.infer(r31, r4);     // Catch: Throwable -> L68
        if (r33 != r6) goto L44;
        return r6;
    L44:
        r10 = r28;
        r8 = r32;
        r9 = r110;
        a r111 = r25;
        r3 = r33;
        r1 = r111;
    L68:
        th = th;
        r1 = r25;
    L78:
        th = th;
        goto L79
    L21:
        AIKLoadingDetection r34 = (AIKLoadingDetection) ZeusTransformUtils.preCheckCast(r4.L$1, AIKLoadingDetection.class, "com.obric.aiagent.plugin");
        Bitmap r35 = (Bitmap) ZeusTransformUtils.preCheckCast(r4.L$0, Bitmap.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r5 = r34;
        Bitmap r36 = r35;
    L24:
        if (r5.mInitialized == true) goto L31;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] the model isn't initialized. need-reinit=" + r5.mNeedReInitialize);
        if (r5.mNeedReInitialize == false) goto L72;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] the model needs reinitialisation. do it now!");
        r5.mNeedReInitialize = false;
        Context r37 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r4.L$0 = r36;
        r4.L$1 = r5;
        r4.label = 1;
        if (r5.initialize(r37, r4) != r6) goto L24;
        return r6;
    L31:
        if (r5.mSupported == true) goto L33;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][WITH-MODEL] this model isn't supported on this device.");
        goto L72
    L33:
        r25 = r5.mModelLoadingMutex;
        r4.L$0 = r36;
        r4.L$1 = r5;
        r4.L$2 = r25;
        r4.label = 2;
        if (r25.a(null, r4) != r6) goto L36;
        return r6;
    L36:
        r28 = r36;
        r27 = r5;
        goto L86
    L22:
        d.o.a(r3);
        r36 = r18;
    L7:
        r5 = this;
        r4 = new C11541(r5, r2);
        goto L8
    }

    private static final x inference$lambda$12$lambda$9(final Bitmap r1, RequestParams r2) {
        o.e(r2, "$this$RequestParams");
        ParamsKt.setCustomArgs(r2, new $$Lambda$AIKLoadingDetection$SPrfpnf9VsGUVjdSHnzNcQ0Y_KY(r1));
        return x.f38692a;
    }

    private static final x inference$lambda$12$lambda$9$lambda$8(Bitmap r2, Bundle r3) {
        o.e(r3, "$this$setCustomArgs");
        r3.putParcelable("bitmapObject", (Parcelable) ZeusTransformUtils.preCheckCast(r2, Parcelable.class, "com.obric.aiagent.plugin"));
        r3.putInt(IdlKeys.Args_Priority, 1);
        r3.putInt(IdlKeys.Args_Force_Execute, 1);
        return x.f38692a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final x inference$lambda$12$lambda$10(z.f r1, z.f r2, boolean r3, Object r4, JSONObject r5) {
        o.e(r5, "extra");
        if (r4 != null) goto L7;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to get inference result (Data=NULL).");
        r1.f38504a = "infer_result_data_null";
        return x.f38692a;
    L7:
        if ((r4 instanceof float[]) == false) goto L9;
        T r6 = (float[]) ZeusTransformUtils.preCheckCast(r4, float[].class, "com.obric.aiagent.plugin");
    L10:
        r2.f38504a = r6;
        if (r2.f38504a != 0) goto L15;
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to get inference result (DataTypeMismatch=" + r4.getClass() + ").");
        r1.f38504a = "data_type_mismatch";
        return x.f38692a;
    L15:
        return x.f38692a;
    L9:
        r6 = 0;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.String] */
    private static final x inference$lambda$12$lambda$11(z.f r2, int r3, String r4, JSONObject r5) {
        o.e(r4, "errInfo");
        o.e(r5, "extra");
        Loog.INSTANCE.e(TAG, " - [LoadingDet/AIK][INFER] failed to get inference result (errCode=" + r3 + ", errInfo=" + r4 + ").");
        r2.f38504a = "err_" + r3 + '_' + r4;
        return x.f38692a;
    }

    @Override // com.obric.autogui.modules.tfmodels.ITFLiteModel
    public Object deinitialize(d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C11531.class) == false) goto L7;
        C11531 r0 = (C11531) ZeusTransformUtils.preCheckCast(r8, C11531.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = d.c.a.b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r0.L$1, a.class, "com.obric.aiagent.plugin");
        AIKLoadingDetection r1 = (AIKLoadingDetection) ZeusTransformUtils.preCheckCast(r0.L$0, AIKLoadingDetection.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
        a r10 = r6;
        AIKLoadingDetection this = r1;
    L26:
        Loog.INSTANCE.d(TAG, " - [LoadingDet/AIK][DEINITIALIZE] deinitialized model: " + this.mModel);     // Catch: Throwable -> L23
        IBaseModel r4 = this.mModel;     // Catch: Throwable -> L23
        if (r4 == null) goto L20;
        r4.close();     // Catch: Throwable -> L23
    L20:
        this.mModel = null;     // Catch: Throwable -> L23
        this.mInitialized = false;     // Catch: Throwable -> L23
        x r11 = x.f38692a;     // Catch: Throwable -> L23
        r10.b(null);
        return x.f38692a;
    L23:
        th = move-exception;
        r10.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        r10 = this.mModelLoadingMutex;
        r0.L$0 = this;
        r0.L$1 = r10;
        r0.label = 1;
        if (r10.a(null, r0) != r2) goto L26;
        return r2;
    L7:
        r0 = new C11531(this, r8);
        goto L8
    }
}
