package com.bytedance.android.livesdk.action;

/* JADX INFO: loaded from: classes7.dex */
abstract class CallbackWrapper implements BaseActionMethod.Callback {
    private BaseActionMethod.Callback mCallback;

    public abstract void onFinish();

    public CallbackWrapper(BaseActionMethod.Callback r100) {
        this.mCallback = r100;
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod.Callback
    public void onFail(Throwable r100) {
        this.mCallback.onFail(r100);
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod.Callback
    public void onSuccess(Object r100) {
        this.mCallback.onSuccess(r100);
    }
}
