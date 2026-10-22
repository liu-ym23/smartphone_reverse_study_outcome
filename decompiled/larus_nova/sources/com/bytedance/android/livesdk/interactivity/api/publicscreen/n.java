package com.bytedance.android.livesdk.interactivity.api.publicscreen;

/* JADX INFO: loaded from: classes9.dex */
public interface n {
    void addMessageFactory(String r100, i.a r101);

    void addMessageInterceptor(PublicScreenConfig$InterceptorType r100, h r101);

    void addMessageListener(s42.b r100);

    void addMessageViewBinder(PublicScreenConfig$ViewBinderType r100, j<? extends i, ? extends PSMessageViewHolder> r101);

    l getPublicScreenContext();

    void removeMessageListener(s42.b r100);
}
