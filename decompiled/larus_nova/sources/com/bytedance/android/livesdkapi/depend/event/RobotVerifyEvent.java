package com.bytedance.android.livesdkapi.depend.event;

/* JADX INFO: loaded from: classes12.dex */
public class RobotVerifyEvent {
    private IActionAfterVerify action;
    private Exception mException;

    public interface IActionAfterVerify {
        void onVerifyCancel();

        void onVerifyFailed();

        void onVerifySuccess();
    }

    public RobotVerifyEvent() {
    }

    public IActionAfterVerify getAction() {
        return this.action;
    }

    public Exception getException() {
        return this.mException;
    }

    public RobotVerifyEvent setAction(IActionAfterVerify r100) {
        this.action = r100;
        return this;
    }

    public RobotVerifyEvent setException(Exception r100) {
        this.mException = r100;
        return this;
    }
}
