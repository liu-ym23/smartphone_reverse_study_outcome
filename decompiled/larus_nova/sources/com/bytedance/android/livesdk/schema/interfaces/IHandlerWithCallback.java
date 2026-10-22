package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;

/* JADX INFO: loaded from: classes11.dex */
public interface IHandlerWithCallback<T extends BaseSchemaModel> extends IBaseSchemaHandler<T> {
    boolean handleAction(Context r100, Uri r101, DialogInterface.OnDismissListener r102);
}
