package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;

/* JADX INFO: loaded from: classes11.dex */
public interface ISchemaHandler<T extends BaseSchemaModel> extends IBaseSchemaHandler<T> {
    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    boolean canHandle(Uri r100);

    boolean handle(Context r100, Uri r101, T r102);
}
