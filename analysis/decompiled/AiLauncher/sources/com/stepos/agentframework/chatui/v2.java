package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\tH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "isDragging", "wasAtBottom", "", "anchorMessageId", "", "anchorOffsetFromBottom", "oldMessageId", "newMessageId", "Lkotlin/Function1;", "indexOfMessage", "Lcom/stepos/agentframework/chatui/u2;", Const.INTENT_KEY_APIKEY, "(ZZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lp9/l;)Lcom/stepos/agentframework/chatui/u2;", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class v2 {
    public static final VariantScrollTarget a(boolean z10, boolean z11, String str, int i10, String oldMessageId, String newMessageId, InterfaceC5074l<? super String, Integer> indexOfMessage) {
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        kotlin.jvm.internal.p.i(newMessageId, "newMessageId");
        kotlin.jvm.internal.p.i(indexOfMessage, "indexOfMessage");
        if (z10) {
            return null;
        }
        if (z11) {
            return new VariantScrollTarget(0, 0);
        }
        if (str == null) {
            return null;
        }
        if (kotlin.jvm.internal.p.d(str, oldMessageId)) {
            str = newMessageId;
        }
        int iIntValue = indexOfMessage.invoke(str).intValue();
        if (iIntValue < 0) {
            return null;
        }
        return new VariantScrollTarget(iIntValue, i10);
    }
}
