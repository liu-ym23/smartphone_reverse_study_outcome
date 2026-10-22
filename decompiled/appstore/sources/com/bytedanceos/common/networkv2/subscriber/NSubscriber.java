package com.bytedanceos.common.networkv2.subscriber;

import android.content.Context;
import android.text.TextUtils;
import com.bytedanceos.common.networkv2.entity.BaseEntity;
import com.bytedanceos.common.toolbox.i;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NSubscriber<T> extends Subscriber {
    public static final String TAG = "NSubscriber";
    private Context mContext;
    private String mErrorText;

    static {
    }

    public NSubscriber() {
    }

    @Override // rx.Observer
    public void onCompleted() {
        i.e(TAG, "onCompleted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onFail(T r10) {
        if ((r10 instanceof BaseEntity) == false) goto L15;
        BaseEntity r11 = (BaseEntity) r10;
        if (r11.isExpired() == false) goto L10;
        if (this.mContext == null) goto L16;
        TextUtils.isEmpty(r11.getMessage());
        return;
    L16:
        return;
    L10:
        if (this.mContext != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(this.mErrorText) == true) goto L19;
        TextUtils.isEmpty(r11.getMessage());
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.Observer
    public void onNext(T r10) {
        if ((r10 instanceof BaseEntity) == true) goto L5;
        return;
    L5:
        if (((BaseEntity) r10).isOk() == false) goto L7;
        onSuccess(r10);
        return;
    L7:
        onFail(r10);
    }

    public void onSuccess(T r10) {
    }

    public void setContext(Context r10) {
        this.mContext = r10;
    }

    public void setErrorText(String r10) {
        this.mErrorText = r10;
    }

    public NSubscriber(Context r10) {
        this.mContext = r10;
    }
}
