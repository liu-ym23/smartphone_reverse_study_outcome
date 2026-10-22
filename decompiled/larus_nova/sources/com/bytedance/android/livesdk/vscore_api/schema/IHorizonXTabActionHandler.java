package com.bytedance.android.livesdk.vscore_api.schema;

import android.content.Context;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;

/* JADX INFO: loaded from: classes11.dex */
public interface IHorizonXTabActionHandler<T extends BaseSchemaModel> extends IBaseSchemaHandler<T> {
    boolean handleXTab(Context r100, HorizonXTabSchemaModel r101);
}
