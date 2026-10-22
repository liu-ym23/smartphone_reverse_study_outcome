package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import com.stepos.ailauncher.contract.model.search.SidebarSessionKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;)I", "frameworkKindCode", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L8 {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SidebarSessionKind.values().length];
            try {
                iArr[SidebarSessionKind.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SidebarSessionKind.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SidebarSessionKind.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int a(SidebarSessionKind sidebarSessionKind) {
        kotlin.jvm.internal.p.i(sidebarSessionKind, "<this>");
        int i10 = a.$EnumSwitchMapping$0[sidebarSessionKind.ordinal()];
        if (i10 == 1) {
            return ConversationSessionKind.NORMAL.getCode();
        }
        if (i10 == 2) {
            return ConversationSessionKind.MAIN.getCode();
        }
        if (i10 == 3) {
            return ConversationSessionKind.CHANNEL.getCode();
        }
        throw new NoWhenBranchMatchedException();
    }
}
