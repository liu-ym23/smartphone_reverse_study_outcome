package com.stepos.aiengine.model;

import Y8.t;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.flow.ModelFlowCallback;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import com.stepos.deepbinder.core.constant.Constants;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u0019\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u0010J)\u0010(\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b(\u0010\u001dJ\u0017\u0010)\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00102\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0015¨\u00063"}, d2 = {"Lcom/stepos/aiengine/model/RemoteDownloader;", "Lcom/stepos/aiengine/model/IDownloader;", "", "algorithmId", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", "Landroid/content/Context;", "context", "<init>", "(Ljava/lang/String;Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Landroid/content/Context;)V", "Landroid/os/Bundle;", "bundle", "LY8/t;", "start", "(Landroid/os/Bundle;)V", "pause", "()V", "resume", "cancel", "", "getProgress", "()I", "id", "Lcom/stepos/core/download/IDownloadCallback;", "callback", "registerCallback", "(Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;)V", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "flowCallback", "(Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;Lcom/stepos/aiengine/flow/ModelFlowCallback;)V", "unregisterCallback", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "Landroid/os/ParcelFileDescriptor;", Constants.GET_FILE_DESCRIPTOR, "()Landroid/os/ParcelFileDescriptor;", "destroy", "flow", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/core/download/IDownloadCallback;)V", "Ljava/lang/String;", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "c", "Landroid/content/Context;", Const.INTENT_KEY_UMID, "TAG", "getStatus", "status", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteDownloader implements IDownloader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final IOtaDeepBinderService svc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String TAG;

    public RemoteDownloader(String algorithmId, IOtaDeepBinderService svc, Context context) {
        p.i(algorithmId, "algorithmId");
        p.i(svc, "svc");
        p.i(context, "context");
        this.algorithmId = algorithmId;
        this.svc = svc;
        this.context = context;
        this.TAG = "RemoteDownloader[" + algorithmId + "]";
    }

    public final void a(String id, IDownloadCallback callback, ModelFlowCallback flow) {
        Object objB;
        Log.d(this.TAG, "registerCallback id=" + id + " flow=" + (flow != null));
        IDownloadCallback iDownloadCallbackRegister = DownloaderCallbackRegistry.INSTANCE.register(this.algorithmId, id, callback, flow);
        if (iDownloadCallbackRegister != null && iDownloadCallbackRegister != callback) {
            b(iDownloadCallbackRegister);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.registerDownloadCallback(this.algorithmId, callback);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "registerDownloadCallback failed", thE);
        }
    }

    public final void b(IDownloadCallback callback) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.unregisterDownloadCallback(this.algorithmId, callback);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "unregisterDownloadCallback failed", thE);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void cancel() {
        Object objB;
        Log.i(this.TAG, "cancel");
        ModelConfirmFlow.INSTANCE.markDetachedFromExternalControl(this.algorithmId);
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.cancelDownload(this.algorithmId);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "cancelDownload failed", thE);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void destroy() {
        Log.i(this.TAG, "destroy");
        Iterator<T> it = DownloaderCallbackRegistry.INSTANCE.clear(this.algorithmId).iterator();
        while (it.hasNext()) {
            b((IDownloadCallback) it.next());
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public ParcelFileDescriptor getFileDescriptor() {
        Log.w(this.TAG, "getFileDescriptor: not supported in current version");
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public Uri getFileUri() {
        Log.w(this.TAG, "getFileUri: not supported in current version");
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getProgress() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(this.svc.getDownloadProgress(this.algorithmId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "getDownloadProgress failed", thE);
        }
        if (Result.g(objB)) {
            objB = 0;
        }
        return ((Number) objB).intValue();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getStatus() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(this.svc.getDownloadStatus(this.algorithmId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "getDownloadStatus failed", thE);
        }
        if (Result.g(objB)) {
            objB = 0;
        }
        return ((Number) objB).intValue();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void pause() {
        Object objB;
        Log.i(this.TAG, "pause");
        ModelConfirmFlow.INSTANCE.markDetachedFromExternalControl(this.algorithmId);
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.pauseDownload(this.algorithmId);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "pauseDownload failed", thE);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, IDownloadCallback callback) {
        p.i(id, "id");
        p.i(callback, "callback");
        a(id, callback, null);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void resume() {
        Log.i(this.TAG, "resume");
        String str = this.algorithmId;
        ModelConfirmFlow.Mode mode = ModelConfirmFlow.Mode.DOWNLOAD;
        SdkConfirmHost sdkConfirmHost = SdkConfirmHost.INSTANCE;
        new ModelConfirmFlow(str, mode, null, 0L, null, sdkConfirmHost.hostFor(this.context), null, false, 220, null).startResume(this.context, this.svc, DownloaderCallbackRegistry.INSTANCE.flowCallbackFor(this.algorithmId, "resume"), null, sdkConfirmHost.getScope(), false, false, true);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void start(Bundle bundle) {
        Log.i(this.TAG, "start plugin=" + (bundle != null ? bundle.getString("plugin") : null));
        String str = this.algorithmId;
        ModelConfirmFlow.Mode mode = ModelConfirmFlow.Mode.DOWNLOAD;
        SdkConfirmHost sdkConfirmHost = SdkConfirmHost.INSTANCE;
        new ModelConfirmFlow(str, mode, null, 0L, null, sdkConfirmHost.hostFor(this.context), null, false, 220, null).start(this.context, this.svc, DownloaderCallbackRegistry.INSTANCE.flowCallbackFor(this.algorithmId, "start"), null, sdkConfirmHost.getScope());
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void unregisterCallback(String id) {
        p.i(id, "id");
        IDownloadCallback iDownloadCallbackUnregister = DownloaderCallbackRegistry.INSTANCE.unregister(this.algorithmId, id);
        if (iDownloadCallbackUnregister == null) {
            return;
        }
        Log.d(this.TAG, "unregisterCallback id=" + id);
        b(iDownloadCallbackUnregister);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, IDownloadCallback callback, ModelFlowCallback flowCallback) {
        p.i(id, "id");
        p.i(callback, "callback");
        p.i(flowCallback, "flowCallback");
        a(id, callback, flowCallback);
    }
}
