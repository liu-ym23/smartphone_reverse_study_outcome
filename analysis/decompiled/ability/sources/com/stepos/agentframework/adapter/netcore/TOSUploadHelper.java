package com.stepos.agentframework.adapter.netcore;

import C7.r;
import D7.v;
import H4.o;
import H7.c;
import N4.a;
import S7.p;
import android.content.Context;
import android.net.Uri;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.statsrpk.d;
import com.stepos.taskrobot.llmapi.stepfun.trace.TraceParams;
import com.zyql.common.utils.upload.UploadConfig;
import com.zyql.common.utils.upload.UploadManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\r\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013JH\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019JH\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a2&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/TOSUploadHelper;", "", AppAgent.CONSTRUCT, "()V", "", "Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "results", "Lkotlin/Function4;", "", "", "", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "handleUploadResult", "(Ljava/util/List;LS7/p;)V", "ensureInitialized", "Lcom/zyql/common/utils/upload/UploadConfig;", "config", "init", "(Lcom/zyql/common/utils/upload/UploadConfig;)V", "Landroid/content/Context;", "context", "Ljava/io/File;", BffConstant.Type.File, "uploadFile", "(Landroid/content/Context;Ljava/io/File;LS7/p;LH7/c;)Ljava/lang/Object;", "Landroid/net/Uri;", "uri", "uploadUri", "(Landroid/content/Context;Landroid/net/Uri;LS7/p;LH7/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "initialized", "Z", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TOSUploadHelper {
    public static final TOSUploadHelper INSTANCE = new TOSUploadHelper();
    private static final String TAG = "TOSUploadHelper";
    private static volatile boolean initialized;

    private TOSUploadHelper() {
    }

    private final void ensureInitialized() {
        if (initialized) {
            return;
        }
        d.O(TAG, "TOS SDK not initialized, using default config");
        init(new UploadConfig(null, null, TraceParams.REGION, "", "", false, "default-bucket", 0, 0, McpErrorCode.TOKEN_EXPIRED, null));
    }

    private final void handleUploadResult(List<UploadManager.UploadResult> results, p onProgress) throws Throwable {
        UploadManager.UploadResult uploadResult = (UploadManager.UploadResult) v.C0(results);
        if (uploadResult == null) {
            d.u(TAG, "Upload failed: no result");
            throw new IllegalStateException("上传失败：未获取到结果");
        }
        if (uploadResult.getSuccess() && uploadResult.getUrl() != null) {
            d.D(TAG, "Upload success: " + uploadResult.getUrl());
            onProgress.invoke(100, Boolean.TRUE, "", uploadResult.getUrl());
            return;
        }
        Throwable error = uploadResult.getError();
        d.u(TAG, "Upload failed: " + (error != null ? error.getMessage() : null));
        Throwable error2 = uploadResult.getError();
        if (error2 != null) {
            throw error2;
        }
        throw new IllegalStateException("上传失败");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r uploadFile$lambda$0(p pVar, int i) {
        d.s(TAG, "Upload progress: " + i + "%");
        pVar.invoke(Integer.valueOf(i), Boolean.FALSE, "", null);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r uploadFile$lambda$1(p pVar, List results) throws Throwable {
        k.f(results, "results");
        try {
            INSTANCE.handleUploadResult(results, pVar);
        } catch (Exception e) {
            d.v(TAG, "Upload failed in callback", e);
            pVar.invoke(100, Boolean.TRUE, "", null);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r uploadUri$lambda$0(p pVar, int i) {
        pVar.invoke(Integer.valueOf(i), Boolean.FALSE, "", null);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r uploadUri$lambda$1(p pVar, List results) throws Throwable {
        k.f(results, "results");
        try {
            INSTANCE.handleUploadResult(results, pVar);
        } catch (Exception e) {
            d.v(TAG, "Upload URI failed in callback", e);
            pVar.invoke(100, Boolean.TRUE, "", null);
        }
        return r.f317a;
    }

    public final void init(UploadConfig config) {
        k.f(config, "config");
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (!initialized) {
                UploadManager.INSTANCE.setup(config);
                initialized = true;
                d.D(TAG, "TOS SDK initialized");
            }
        }
    }

    public final Object uploadFile(Context context, File file, p pVar, c<? super r> cVar) throws Exception {
        ensureInitialized();
        String absolutePath = file.getAbsolutePath();
        d.D(TAG, "Starting TOS upload: " + absolutePath);
        try {
            UploadManager.startBatchUpload$default(UploadManager.INSTANCE, context, o.M(absolutePath), null, new a(pVar, 2), false, new a(pVar, 3), 20, null);
            return r.f317a;
        } catch (Exception e) {
            d.v(TAG, "Upload exception", e);
            throw e;
        }
    }

    public final Object uploadUri(Context context, Uri uri, p pVar, c<? super r> cVar) throws Exception {
        ensureInitialized();
        String string = uri.toString();
        k.e(string, "toString(...)");
        d.D(TAG, "Starting TOS upload from URI: ".concat(string));
        try {
            UploadManager.startBatchUpload$default(UploadManager.INSTANCE, context, o.M(string), null, new a(pVar, 0), false, new a(pVar, 1), 20, null);
            return r.f317a;
        } catch (Exception e) {
            d.v(TAG, "Upload URI exception", e);
            throw e;
        }
    }
}
