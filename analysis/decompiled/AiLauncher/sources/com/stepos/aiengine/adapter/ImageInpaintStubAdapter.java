package com.stepos.aiengine.adapter;

import M5.b;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageInpaintStubAdapter;", "Lcom/stepos/aiengine/algorithm/imageinpaint/IImageInpaint;", "", "algorithmId", "<init>", "(Ljava/lang/String;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "images", "", "seed", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "progressCallback", "inpaintImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;JLcom/stepos/aiengine/api/task/IBundleCallback;)Landroid/os/Bundle;", e.f30860s, "", "cancel", "(J)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageInpaintStubAdapter implements IImageInpaint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    public ImageInpaintStubAdapter(String algorithmId) {
        p.i(algorithmId, "algorithmId");
        this.algorithmId = algorithmId;
    }

    @Override // com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint
    public boolean cancel(long identity) {
        return false;
    }

    @Override // com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint
    public Bundle inpaintImage(AlgorithmToken token, Bundle images, long seed, IBundleCallback progressCallback) {
        p.i(token, "token");
        p.i(images, "images");
        Bundle bundle = new Bundle();
        bundle.putString("exception", "ImageInpaint[" + this.algorithmId + "]: not implemented yet");
        return bundle;
    }
}
