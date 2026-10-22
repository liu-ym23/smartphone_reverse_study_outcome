package com.bytedance.android.shopping.anchorv4.ai;

import com.bytedance.android.ec.base.api.ai.conversation.AIChatSchemaParams;
import com.bytedance.android.shopping.anchorv4.params.PdpAIConversationContext;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class t {
    public static final AIChatSchemaParams a(PdpAIConversationContext r100) {
        String r101 = null;
        if (r100 == null) goto L9;
        String r102 = r100.getConversationId();
        if (r102 == null) goto L9;
        if ((!StringsKt.isBlank(r102)) == false) goto L9;
    L10:
        if (r100 == null) goto L16;
        String r103 = r100.getOriginMessageId();
        if (r103 == null) goto L16;
        if ((!StringsKt.isBlank(r103)) == false) goto L16;
    L17:
        if (r100 == null) goto L23;
        String r104 = r100.getOriginBcmId();
        if (r104 == null) goto L23;
        if ((!StringsKt.isBlank(r104)) == false) goto L23;
        r101 = r104;
    L23:
        if (r102 != null) goto L27;
        return AIChatSchemaParams.EMPTY;
    L27:
        return new AIChatSchemaParams(r102, r103, r101);
    L16:
        r103 = null;
    L9:
        r102 = null;
        goto L10
    }
}
