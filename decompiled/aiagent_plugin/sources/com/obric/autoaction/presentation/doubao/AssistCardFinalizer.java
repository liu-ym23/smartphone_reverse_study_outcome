package com.obric.autoaction.presentation.doubao;

import android.net.Uri;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.autogui.session.state.holderfile.ISessionFinalizer;
import com.obric.autogui.session.state.holderfile.SHF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: AssisCardFinializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistCardFinalizer implements ISessionFinalizer {
    public AssistCardFinalizer() {
    }

    @Override // com.obric.autogui.session.state.holderfile.ISessionFinalizer
    public Object doFinalize(SHF r18, d.c.d<? super Boolean> r19) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        Long r1 = r18.getDoubaoMsgId();
        if (r1 == null) goto L7;
        long r12 = r1.longValue();
        Uri r2 = f.f24886a.a(r18.getSessionKey());
        JSONObject r3 = new JSONObject().put("extra_ui_model", j.f24894a.a().toJson(new AssistRemoteCardUIParams(1, r18.getSessionId(), r18.getSessionKey(), r18.getQuery(), r12, null, 32, null))).put("doubao_message_id", r12);
        ILogDepend.Companion.d("AssistRemoteCard", "update card on SessionFinalizer:" + r2);
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a(r2, r3);
        return d.c.b.a.b.a(true);
    L7:
        return d.c.b.a.b.a(true);
    }
}
