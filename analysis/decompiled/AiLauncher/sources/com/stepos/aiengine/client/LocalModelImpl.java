package com.stepos.aiengine.client;

import O6.l;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.clients.AICapabilityProvider;
import com.stepos.aiengine.model.IModelManager;
import com.stepos.aiengine.model.RemoteModelManager;
import com.stepos.aiengine.model.StubModelManager;
import com.stepos.aiengine.update.OtaServiceClient;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/client/LocalModelImpl;", "Lcom/stepos/aiengine/client/LocalModel;", "", "algorithmId", "<init>", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "isEnabled", "", "checkResources", "(Landroid/content/Context;)I", "Lcom/stepos/aiengine/model/IModelManager;", "getModelManager", "(Landroid/content/Context;)Lcom/stepos/aiengine/model/IModelManager;", "pluginKey", "checkPluginResources", "(Landroid/content/Context;Ljava/lang/String;)I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalModelImpl implements LocalModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    public LocalModelImpl(String algorithmId) {
        p.i(algorithmId, "algorithmId");
        this.algorithmId = algorithmId;
    }

    @Override // com.stepos.aiengine.client.LocalModel
    public int checkPluginResources(Context context, String pluginKey) {
        p.i(context, "context");
        p.i(pluginKey, "pluginKey");
        Boolean boolCheckModelReady = AbilityServiceClient.INSTANCE.get(context).checkModelReady(this.algorithmId + l.DATE_SEPARATOR + pluginKey);
        if (p.d(boolCheckModelReady, Boolean.TRUE)) {
            return 1;
        }
        if (p.d(boolCheckModelReady, Boolean.FALSE)) {
            return 0;
        }
        if (boolCheckModelReady == null) {
            return -2;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.aiengine.client.LocalModel
    public int checkResources(Context context) {
        Integer numB;
        p.i(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        if (iOtaDeepBinderService != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                numB = Result.b(Integer.valueOf(iOtaDeepBinderService.checkResources(this.algorithmId)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                numB = Result.b(C4849c.a(th));
            }
            num = Result.g(numB) ? null : numB;
        }
        if (num != null && num.intValue() != 0 && num.intValue() != 5 && num.intValue() != -2) {
            Log.d("LocalModelImpl", "checkResources: algorithmId=" + this.algorithmId + " source=ota state=" + num);
            return num.intValue();
        }
        int iCheckResources = AICapabilityProvider.INSTANCE.checkResources(context, this.algorithmId);
        Log.d("LocalModelImpl", "checkResources: algorithmId=" + this.algorithmId + " source=file otaState=" + num + " fileState=" + iCheckResources);
        return iCheckResources;
    }

    @Override // com.stepos.aiengine.client.LocalModel
    public IModelManager getModelManager(Context context) {
        p.i(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        return iOtaDeepBinderService != null ? new RemoteModelManager(this.algorithmId, iOtaDeepBinderService, context) : new StubModelManager();
    }

    @Override // com.stepos.aiengine.client.BaseModel
    public boolean isEnabled(Context context) {
        p.i(context, "context");
        return AICapabilityProvider.INSTANCE.checkEnable(context, this.algorithmId);
    }

    @Override // com.stepos.aiengine.client.BaseModel
    public boolean isSupported(Context context) {
        p.i(context, "context");
        return AICapabilityProvider.INSTANCE.isDeviceSupported(context, this.algorithmId);
    }
}
