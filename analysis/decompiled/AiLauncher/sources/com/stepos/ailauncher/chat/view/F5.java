package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/view/F5;", "", "Lkotlin/Function0;", "LY8/t;", "cancelAction", "<init>", "(Lp9/a;)V", Const.INTENT_KEY_APIKEY, "()V", "Lp9/a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F5 {
    private final InterfaceC5063a<Y8.t> cancelAction;

    public F5(InterfaceC5063a<Y8.t> cancelAction) {
        kotlin.jvm.internal.p.i(cancelAction, "cancelAction");
        this.cancelAction = cancelAction;
    }

    public final void a() {
        this.cancelAction.invoke();
    }
}
