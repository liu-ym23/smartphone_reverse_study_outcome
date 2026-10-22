package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0002*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001\u000eJ\u001f\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ1\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00028\u00002\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fH&¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "R", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "handle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "(Landroid/content/Context;Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;)Z", "schemaCallback", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler$SchemaCallback;", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler$SchemaCallback;)Ljava/lang/Boolean;", "SchemaCallback", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBaseCallbackSchemaHandler<T extends BaseSchemaModel, R> extends IBaseSchemaHandler<T> {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static <T extends BaseSchemaModel, R> boolean handle(IBaseCallbackSchemaHandler<T, R> r100, Context r101, T r102) {
            Boolean r103 = r100.handle(r101, r102, null);
            if (r103 != null) goto L7;
            return false;
        L7:
            return r103.booleanValue();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001f\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00028\u0002H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler$SchemaCallback;", "R", "", "onComplete", "", "onFailure", "t", "", "onSuccess", "code", "", "response", "(Ljava/lang/Integer;Ljava/lang/Object;)V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface SchemaCallback<R> {
        void onComplete();

        void onFailure(Throwable r100);

        void onSuccess(Integer r100, R r101);
    }

    Boolean handle(Context r100, T r101, SchemaCallback<R> r102);

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    boolean handle(Context r100, T r101);
}
