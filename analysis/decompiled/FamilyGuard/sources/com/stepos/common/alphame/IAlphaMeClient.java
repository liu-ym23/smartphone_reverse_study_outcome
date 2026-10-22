package com.stepos.common.alphame;

import android.os.IInterface;

/* loaded from: classes.dex */
public interface IAlphaMeClient extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.common.alphame.IAlphaMeClient";
    public static final int ON_RECEIVER_TRANSACTION = 2;
    public static final int ON_RESULT_TRANSACTION = 1;

    void onReceiver(a aVar);

    void onResult(a aVar);
}
