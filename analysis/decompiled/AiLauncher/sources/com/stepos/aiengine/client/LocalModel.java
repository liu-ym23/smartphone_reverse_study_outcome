package com.stepos.aiengine.client;

import android.content.Context;
import com.stepos.aiengine.model.IModelManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/client/LocalModel;", "Lcom/stepos/aiengine/client/BaseModel;", "checkResources", "", "context", "Landroid/content/Context;", "getModelManager", "Lcom/stepos/aiengine/model/IModelManager;", "checkPluginResources", "pluginKey", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LocalModel extends BaseModel {
    int checkPluginResources(Context context, String pluginKey);

    int checkResources(Context context);

    IModelManager getModelManager(Context context);
}
