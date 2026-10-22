package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;

/* JADX INFO: loaded from: classes11.dex */
public interface IBaseSchemaHandler<T extends BaseSchemaModel> {
    public static final String SUPPORT_PARAM_KEY = "__live_platform__";
    public static final String SUPPORT_PARAM_VALUE = "webcast";

    boolean canHandle(Uri r100);

    boolean handle(Context r100, T r101);
}
