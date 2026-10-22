package com.stepos.ailauncher.contract.api.homebar;

import Y8.t;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homebar/IHomeBarSysUiService;", "", "", "notifyHomeBarLighted", "()Z", "show", "", "msg", "LY8/t;", "showHomeBarCapsule", "(ZLjava/lang/String;)V", "Lkotlin/Function0;", "listener", "setOnHomeBarCapsuleClickListener", "(Lp9/a;)V", "setOnHomeBarSysUiConnectedListener", "", "startTime", "notifyChatViewClosed", "(J)V", "isWhiteHomeBar", "openChatViewAfterAgentAuth", "()V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IHomeBarSysUiService {
    boolean isWhiteHomeBar();

    void notifyChatViewClosed(long startTime);

    boolean notifyHomeBarLighted();

    void openChatViewAfterAgentAuth();

    void setOnHomeBarCapsuleClickListener(InterfaceC5063a<t> listener);

    void setOnHomeBarSysUiConnectedListener(InterfaceC5063a<t> listener);

    void showHomeBarCapsule(boolean show, String msg);
}
