package Q4;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.flow.ModelFlowCallback;
import com.stepos.aiengine.flow.ModelFlowError;
import com.stepos.aiengine.model.IDownloader;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.deepbinder.core.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010\u0019R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010'R\u0014\u0010)\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000e¨\u0006+"}, d2 = {"LQ4/g;", "Lcom/stepos/aiengine/model/IDownloader;", "<init>", "()V", "Landroid/os/Bundle;", "bundle", "LY8/t;", "start", "(Landroid/os/Bundle;)V", "pause", "resume", "cancel", "", "getProgress", "()I", "", "id", "Lcom/stepos/core/download/IDownloadCallback;", "callback", "registerCallback", "(Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;)V", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "flowCallback", "(Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;Lcom/stepos/aiengine/flow/ModelFlowCallback;)V", "unregisterCallback", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "Landroid/os/ParcelFileDescriptor;", Constants.GET_FILE_DESCRIPTOR, "()Landroid/os/ParcelFileDescriptor;", "destroy", "op", Const.INTENT_KEY_PKGNAME, "Landroid/os/Handler;", Const.INTENT_KEY_APIKEY, "Landroid/os/Handler;", "main", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "getStatus", "status", "c", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class g implements IDownloader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Handler main = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public ModelFlowCallback flowCallback;

    public static final void c(ModelFlowCallback modelFlowCallback) {
        modelFlowCallback.onFailed(ModelFlowError.SERVICE_UNAVAILABLE, "OTA service unavailable");
    }

    public final void b(String op) {
        Log.w("StubDownloader", op + " ignored: OTA service unavailable");
        final ModelFlowCallback modelFlowCallback = this.flowCallback;
        if (modelFlowCallback == null) {
            return;
        }
        this.main.post(new Runnable() { // from class: Q4.f
            @Override // java.lang.Runnable
            public final void run() {
                g.c(modelFlowCallback);
            }
        });
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void cancel() {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void destroy() {
        this.flowCallback = null;
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
        return 0;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public int getStatus() {
        return 0;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void pause() {
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, IDownloadCallback callback) {
        p.i(id, "id");
        p.i(callback, "callback");
        this.flowCallback = null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void resume() {
        b("resume");
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void start(Bundle bundle) {
        b("start");
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void unregisterCallback(String id) {
        p.i(id, "id");
        this.flowCallback = null;
    }

    @Override // com.stepos.aiengine.model.IDownloader
    public void registerCallback(String id, IDownloadCallback callback, ModelFlowCallback flowCallback) {
        p.i(id, "id");
        p.i(callback, "callback");
        p.i(flowCallback, "flowCallback");
        this.flowCallback = flowCallback;
    }
}
