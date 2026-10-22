package com.smt.obric.appstore.assistant.intent;

import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemDownloadAppParams;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/smt/obric/appstore/assistant/intent/DownloadAppIntentV2Handler;", "", "handle", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "params", "Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface DownloadAppIntentV2Handler {
    @Nullable
    Object handle(@NotNull SystemDownloadAppParams r10, @NotNull DispatchContext r11, @NotNull Continuation<? super IntentResult<AppInfoEntity[]>> r12);
}
