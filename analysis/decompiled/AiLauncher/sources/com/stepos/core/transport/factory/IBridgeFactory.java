package com.stepos.core.transport.factory;

import android.content.Context;
import com.stepos.core.AbilityHandle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/stepos/core/transport/factory/IBridgeFactory;", "", "createHandle", "Lcom/stepos/core/AbilityHandle;", "context", "Landroid/content/Context;", "abilityId", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IBridgeFactory {
    AbilityHandle createHandle(Context context, String abilityId);
}
