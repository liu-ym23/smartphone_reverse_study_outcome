package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayIntegratedStyleService extends ICJPayService {
    Object getConfirmAdapter(Context r100);

    Object getConfirmWrapper(View r100);

    Object getMethodAdapter(Context r100);

    Object getMethodWrapper(View r100);
}
