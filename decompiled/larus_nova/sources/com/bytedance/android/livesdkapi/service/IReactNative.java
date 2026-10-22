package com.bytedance.android.livesdkapi.service;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes12.dex */
public interface IReactNative {
    void createHalfScreenReactBoxDialog(String r100, String r101, String r102, int r103, int r104, int r105, int r106, String r107, IReactNativeHost.Callback1<DialogFragment> r108);

    void goRN(Context r100, Uri r101);

    void initReactNative(Application r100);
}
