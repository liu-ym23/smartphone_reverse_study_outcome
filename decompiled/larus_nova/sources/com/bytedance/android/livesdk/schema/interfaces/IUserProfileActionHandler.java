package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface IUserProfileActionHandler<T extends BaseSchemaModel> extends IBaseSchemaHandler<T> {
    boolean handleUserProfile(Context r100, String r101, String r102, Map<String, String> r103);
}
