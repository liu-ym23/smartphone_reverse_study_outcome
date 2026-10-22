package com.stepos.aiengine.client;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.clients.AICapabilityProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/aiengine/client/RemoteModelImpl;", "Lcom/stepos/aiengine/client/RemoteModel;", "", "algorithmId", "<init>", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "isEnabled", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteModelImpl implements RemoteModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    public RemoteModelImpl(String algorithmId) {
        p.i(algorithmId, "algorithmId");
        this.algorithmId = algorithmId;
    }

    @Override // com.stepos.aiengine.client.BaseModel
    public boolean isEnabled(Context context) {
        p.i(context, "context");
        return AICapabilityProvider.INSTANCE.checkCloudEnable(context, this.algorithmId);
    }

    @Override // com.stepos.aiengine.client.BaseModel
    public boolean isSupported(Context context) {
        p.i(context, "context");
        return AICapabilityProvider.INSTANCE.isCloudSupported(context, this.algorithmId);
    }
}
