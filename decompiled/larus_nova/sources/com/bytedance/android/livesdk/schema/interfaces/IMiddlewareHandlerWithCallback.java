package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;

/* JADX INFO: loaded from: classes11.dex */
public interface IMiddlewareHandlerWithCallback<T extends BaseSchemaModel> extends IHandlerWithCallback<T>, ISchemaHandler<T> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.schema.interfaces.IMiddlewareHandlerWithCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T extends BaseSchemaModel> {
        public static Fragment $default$getLiveLynxFragment(IMiddlewareHandlerWithCallback r100, Context r101, String r102) {
            return null;
        }
    }

    Fragment getLiveLynxFragment(Context r100, String r101);
}
