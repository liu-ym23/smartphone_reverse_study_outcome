package com.stepos.alphame.request;

import com.stepos.alphame.NotProguard;

@NotProguard
/* loaded from: classes.dex */
public interface ResponseListener<T> {
    void onFailed(int i4, Exception exc);

    void onSuccess(int i4, T t4);
}
