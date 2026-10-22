package com.obric.autogui.api;

import android.content.Context;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: IAutoActionAppListApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionAppListApi {
    Object getAppListForModel(Context r1, d<? super List<String>> r2);

    Object getAppListForModelV2(Context r1, d<? super List<String[]>> r2);
}
