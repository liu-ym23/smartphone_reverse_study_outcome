package com.bytedance.android.livesdkapi.feed;

/* JADX INFO: loaded from: classes12.dex */
public interface IPullableForSaas<T> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.feed.IPullableForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static void $default$pullToRefresh(IPullableForSaas r100, IPullable.IPullCallback r101) {
        }
    }

    void pullToRefresh(IPullable.IPullCallback<T> r100);
}
