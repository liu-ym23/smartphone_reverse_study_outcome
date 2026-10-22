package com.stepos.ailauncher.chat.input.controller;

import com.stepos.ailauncher.chat.view.AskUserInquiry;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/input/controller/FloatingCardController$showInquiry$handler$1", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "LE4/d;", "event", "LE4/e;", "handle", "(LE4/d;Le9/c;)Ljava/lang/Object;", "", "businessType", "Ljava/lang/String;", "getBusinessType", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatingCardController$showInquiry$handler$1 implements IFloatCardEventHandler {
    final /* synthetic */ List<AskUserInquiry> $inquiries;
    final /* synthetic */ String $inquiryId;
    private final String businessType = LauncherChatLayout.ASK_USER_TOOL_NAME;
    final /* synthetic */ FloatingCardController this$0;

    public FloatingCardController$showInquiry$handler$1(List<AskUserInquiry> list, String str, FloatingCardController floatingCardController) {
        this.$inquiries = list;
        this.$inquiryId = str;
        this.this$0 = floatingCardController;
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
    public String getBusinessType() {
        return this.businessType;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object handle(E4.d r11, e9.InterfaceC4014c<? super E4.e> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.input.controller.FloatingCardController$showInquiry$handler$1.handle(E4.d, e9.c):java.lang.Object");
    }
}
