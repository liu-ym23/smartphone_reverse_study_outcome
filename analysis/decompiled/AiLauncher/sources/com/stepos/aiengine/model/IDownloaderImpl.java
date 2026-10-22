package com.stepos.aiengine.model;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.flow.ModelFlowCallback;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.deepbinder.core.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u0019\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u0010R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0015¨\u0006-"}, d2 = {"Lcom/stepos/aiengine/model/IDownloaderImpl;", "Lcom/stepos/aiengine/model/IDownloader;", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", "", "algorithmId", "Landroid/content/Context;", "context", "<init>", "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Ljava/lang/String;Landroid/content/Context;)V", "Landroid/os/Bundle;", "bundle", "LY8/t;", "start", "(Landroid/os/Bundle;)V", "pause", "()V", "resume", "cancel", "", "getProgress", "()I", "id", "Lcom/stepos/core/download/IDownloadCallback;", "callback", "registerCallback", "(Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;)V", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "flowCallback", "(Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;Lcom/stepos/aiengine/flow/ModelFlowCallback;)V", "unregisterCallback", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "Landroid/os/ParcelFileDescriptor;", Constants.GET_FILE_DESCRIPTOR, "()Landroid/os/ParcelFileDescriptor;", "destroy", "Lcom/stepos/aiengine/model/RemoteDownloader;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/aiengine/model/RemoteDownloader;", "delegate", "getStatus", "status", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IDownloaderImpl implements IDownloader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RemoteDownloader delegate;

    public IDownloaderImpl(IOtaDeepBinderService svc, String algorithmId, Context context) {
        p.i(svc, "svc");
        p.i(algorithmId, "algorithmId");
        p.i(context, "context");
        this.delegate = new RemoteDownloader(algorithmId, svc, context);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void cancel() {
        this.delegate.cancel();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void destroy() {
        this.delegate.destroy();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public ParcelFileDescriptor getFileDescriptor() {
        return this.delegate.getFileDescriptor();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public Uri getFileUri() {
        return this.delegate.getFileUri();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getProgress() {
        return this.delegate.getProgress();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getStatus() {
        return this.delegate.getStatus();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void pause() {
        this.delegate.pause();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, IDownloadCallback callback) {
        p.i(id, "id");
        p.i(callback, "callback");
        this.delegate.registerCallback(id, callback);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void resume() {
        this.delegate.resume();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void start(Bundle bundle) {
        this.delegate.start(bundle);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void unregisterCallback(String id) {
        p.i(id, "id");
        this.delegate.unregisterCallback(id);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, IDownloadCallback callback, ModelFlowCallback flowCallback) {
        p.i(id, "id");
        p.i(callback, "callback");
        p.i(flowCallback, "flowCallback");
        this.delegate.registerCallback(id, callback, flowCallback);
    }
}
