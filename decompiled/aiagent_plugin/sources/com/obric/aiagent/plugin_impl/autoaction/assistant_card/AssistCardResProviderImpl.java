package com.obric.aiagent.plugin_impl.autoaction.assistant_card;

import android.content.Context;
import com.obric.aiagent.plugin_api.autoaction.assist_card.CardResProvider;
import com.obric.autogui.common.api.assistant.AssistCardBgResType;
import com.obric.autogui.common.api.assistant.AssistCardIconResType;
import com.obric.autogui.common.api.assistant.AssistCardIdResType;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AssistCardResProviderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AssistCardResProviderImpl implements IAssistCardResourceProvider {
    public AssistCardResProviderImpl() {
    }

    @Override // com.obric.autogui.common.api.assistant.IAssistCardResourceProvider
    public int getResId(Context r2, String r3, String r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "resName");
        o.e(r4, "type");
        return CardResProvider.getResId(r1, r3, r4);
    }

    @Override // com.obric.autogui.common.api.assistant.IAssistCardResourceProvider
    public int getLayoutRes() {
        return CardResProvider.getLayoutRes();
    }

    @Override // com.obric.autogui.common.api.assistant.IAssistCardResourceProvider
    public int getBackgroundRes(AssistCardBgResType r1, boolean r2) {
        o.e(r1, "type");
        return CardResProvider.getBackgroundRes(r1.name(), r2);
    }

    @Override // com.obric.autogui.common.api.assistant.IAssistCardResourceProvider
    public int getIconRes(AssistCardIconResType r1, boolean r2) {
        o.e(r1, "type");
        return CardResProvider.getIconRes(r1.name(), r2);
    }

    @Override // com.obric.autogui.common.api.assistant.IAssistCardResourceProvider
    public int getIdRes(AssistCardIdResType r1) {
        o.e(r1, "type");
        return CardResProvider.getIdRes(r1.name());
    }
}
