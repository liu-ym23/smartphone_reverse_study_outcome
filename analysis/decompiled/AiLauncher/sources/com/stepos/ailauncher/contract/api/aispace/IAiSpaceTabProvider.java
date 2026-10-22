package com.stepos.ailauncher.contract.api.aispace;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabProvider;", "", "getTabSpec", "Lcom/stepos/ailauncher/contract/api/aispace/AiSpaceTabSpec;", "createView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAiSpaceTabProvider {
    View createView(ViewGroup parent);

    AiSpaceTabSpec getTabSpec();
}
