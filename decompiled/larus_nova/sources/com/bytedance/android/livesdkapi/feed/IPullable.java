package com.bytedance.android.livesdkapi.feed;

/* JADX INFO: loaded from: classes12.dex */
public interface IPullable<T> extends IPullableForSaas<T> {

    public interface IPullCallback<T> {
        void onError(Throwable r100);

        void onSuccess(T r100);
    }

    public interface IPullCheck {
        boolean checkEnable();

        void triggerAction();
    }

    void pullToRefresh(IPullCallback<T> r100, IPullCheck r101);
}
