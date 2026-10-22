package com.stepos.aiengine.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.deepbinder.core.constant.Constants;
import f5.InterfaceC1435a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u000eR\u0014\u0010#\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013¨\u0006$"}, d2 = {"Lcom/stepos/aiengine/model/IDownloaderImpl;", "Lcom/stepos/aiengine/model/IDownloader;", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", "", "algorithmId", AppAgent.CONSTRUCT, "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Ljava/lang/String;)V", "Landroid/os/Bundle;", "bundle", "LC7/r;", "start", "(Landroid/os/Bundle;)V", "pause", "()V", "resume", "cancel", "", "getProgress", "()I", "id", "Lf5/a;", "callback", "registerCallback", "(Ljava/lang/String;Lf5/a;)V", "unregisterCallback", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "Landroid/os/ParcelFileDescriptor;", Constants.GET_FILE_DESCRIPTOR, "()Landroid/os/ParcelFileDescriptor;", "destroy", "getStatus", "status", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IDownloaderImpl implements IDownloader {

    /* renamed from: a, reason: collision with root package name */
    public final IOtaDeepBinderService f3528a;
    public final String b;

    public IDownloaderImpl(IOtaDeepBinderService svc, String algorithmId) {
        k.f(svc, "svc");
        k.f(algorithmId, "algorithmId");
        this.f3528a = svc;
        this.b = algorithmId;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void cancel() {
        this.f3528a.cancelDownload(this.b);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void destroy() {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public ParcelFileDescriptor getFileDescriptor() {
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public Uri getFileUri() {
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getProgress() {
        return this.f3528a.getDownloadProgress(this.b);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getStatus() {
        return this.f3528a.getDownloadStatus(this.b);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void pause() {
        this.f3528a.pauseDownload(this.b);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, InterfaceC1435a callback) {
        k.f(id, "id");
        k.f(callback, "callback");
        this.f3528a.registerDownloadCallback(this.b, callback);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void resume() {
        this.f3528a.resumeDownload(this.b);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void start(Bundle bundle) {
        this.f3528a.startDownload(this.b);
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void unregisterCallback(String id) {
        k.f(id, "id");
    }
}
