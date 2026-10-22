package com.bytedance.android.live.schema;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IHybridHandler;
import com.bytedance.android.livesdk.schema.interfaces.IMiddlewareHandlerWithCallback;
import com.bytedance.android.livesdk.schema.interfaces.ISchemaHandler;
import com.bytedance.android.livesdk.schema.model.RedirectSchemaModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/schema/IHybridSchemaHandlerService;", "Lcom/bytedance/android/live/base/IService;", "getCommerceWebViewSchemaHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/IMiddlewareHandlerWithCallback;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "getLynxViewSchemaHandler", "getRedirectSchemaHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/ISchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/RedirectSchemaModel;", "getWebViewHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/IHybridHandler;", "getWebViewSchemaHandler", "show", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dialogFragment", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHybridSchemaHandlerService extends IService {
    IMiddlewareHandlerWithCallback<BaseSchemaModel> getCommerceWebViewSchemaHandler();

    IMiddlewareHandlerWithCallback<BaseSchemaModel> getLynxViewSchemaHandler();

    ISchemaHandler<RedirectSchemaModel> getRedirectSchemaHandler();

    IHybridHandler getWebViewHandler();

    IMiddlewareHandlerWithCallback<BaseSchemaModel> getWebViewSchemaHandler();

    boolean show(Context r100, LiveDialogFragment r101);
}
