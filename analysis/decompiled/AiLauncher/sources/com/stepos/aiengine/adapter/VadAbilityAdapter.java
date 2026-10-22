package com.stepos.aiengine.adapter;

import M5.b;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.vad.IVadDetection;
import com.stepos.aiengine.algorithm.vad.IVadDetector;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.core.AbilityHandle;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/aiengine/adapter/VadAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/vad/IVadDetection;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "params", "Lcom/stepos/aiengine/algorithm/vad/IVadDetector;", "detect", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/vad/IVadDetector;", "", e.f30860s, "", "cancel", "(J)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VadAbilityAdapter implements IVadDetection {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public VadAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    @Override // com.stepos.aiengine.algorithm.vad.IVadDetection
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.vad.IVadDetection
    public IVadDetector detect(AlgorithmToken token, Bundle params) {
        p.i(token, "token");
        return new VadDetector(this.handle, params);
    }
}
