package com.stepos.aiengine.model;

import B7.a;
import C7.r;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.deepbinder.core.constant.Constants;
import f5.InterfaceC1435a;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u000eR\u0014\u0010#\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013¨\u0006$"}, d2 = {"Lcom/stepos/aiengine/model/RemoteDownloader;", "Lcom/stepos/aiengine/model/IDownloader;", "", "algorithmId", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/core/deepbinder/IOtaDeepBinderService;)V", "Landroid/os/Bundle;", "bundle", "LC7/r;", "start", "(Landroid/os/Bundle;)V", "pause", "()V", "resume", "cancel", "", "getProgress", "()I", "id", "Lf5/a;", "callback", "registerCallback", "(Ljava/lang/String;Lf5/a;)V", "unregisterCallback", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "Landroid/os/ParcelFileDescriptor;", Constants.GET_FILE_DESCRIPTOR, "()Landroid/os/ParcelFileDescriptor;", "destroy", "getStatus", "status", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteDownloader implements IDownloader {

    /* renamed from: a, reason: collision with root package name */
    public final String f3530a;
    public final IOtaDeepBinderService b;
    public final String c;
    public final LinkedHashMap d;

    public RemoteDownloader(String algorithmId, IOtaDeepBinderService svc) {
        k.f(algorithmId, "algorithmId");
        k.f(svc, "svc");
        this.f3530a = algorithmId;
        this.b = svc;
        this.c = a.m("RemoteDownloader[", algorithmId, "]");
        this.d = new LinkedHashMap();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void cancel() {
        Object objA;
        String str = this.c;
        Log.i(str, "cancel");
        try {
            this.b.cancelDownload(this.f3530a);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "cancelDownload failed", thA);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void destroy() {
        Log.i(this.c, "destroy");
        this.d.clear();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public ParcelFileDescriptor getFileDescriptor() {
        Log.w(this.c, "getFileDescriptor: not supported in current version");
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public Uri getFileUri() {
        Log.w(this.c, "getFileUri: not supported in current version");
        return null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getProgress() {
        Object objA;
        try {
            objA = Integer.valueOf(this.b.getDownloadProgress(this.f3530a));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(this.c, "getDownloadProgress failed", thA);
        }
        if (objA instanceof Result.Failure) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getStatus() {
        Object objA;
        try {
            objA = Integer.valueOf(this.b.getDownloadStatus(this.f3530a));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(this.c, "getDownloadStatus failed", thA);
        }
        if (objA instanceof Result.Failure) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void pause() {
        Object objA;
        String str = this.c;
        Log.i(str, "pause");
        try {
            this.b.pauseDownload(this.f3530a);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "pauseDownload failed", thA);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, InterfaceC1435a callback) {
        Object objA;
        k.f(id, "id");
        k.f(callback, "callback");
        String strConcat = "registerCallback id=".concat(id);
        String str = this.c;
        Log.d(str, strConcat);
        this.d.put(id, callback);
        try {
            this.b.registerDownloadCallback(this.f3530a, callback);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "registerDownloadCallback failed", thA);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void resume() {
        Object objA;
        String str = this.c;
        Log.i(str, "resume");
        try {
            this.b.resumeDownload(this.f3530a);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "resumeDownload failed", thA);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void start(Bundle bundle) {
        Object objA;
        String str = "start plugin=" + (bundle != null ? bundle.getString("plugin") : null);
        String str2 = this.c;
        Log.i(str2, str);
        try {
            this.b.startDownload(this.f3530a);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str2, "startDownload failed", thA);
        }
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void unregisterCallback(String id) {
        Object objA;
        k.f(id, "id");
        InterfaceC1435a interfaceC1435a = (InterfaceC1435a) this.d.remove(id);
        if (interfaceC1435a == null) {
            return;
        }
        String strConcat = "unregisterCallback id=".concat(id);
        String str = this.c;
        Log.d(str, strConcat);
        try {
            this.b.unregisterDownloadCallback(this.f3530a, interfaceC1435a);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "unregisterDownloadCallback failed", thA);
        }
    }
}
