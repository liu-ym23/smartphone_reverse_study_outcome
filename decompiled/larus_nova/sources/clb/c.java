package clb;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<String> f24150a;

    public c(EncryptImageUploader$uploadImage$1 r100) {
        this.f24150a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24150a.onSuccess(EffectConstants.CHANNEL_TEST);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
