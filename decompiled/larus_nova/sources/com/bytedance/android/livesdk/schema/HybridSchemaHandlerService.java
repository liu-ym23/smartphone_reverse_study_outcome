package com.bytedance.android.livesdk.schema;

import android.content.Context;
import com.bytedance.android.live.schema.IHybridSchemaHandlerService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IHybridHandler;
import com.bytedance.android.livesdk.schema.interfaces.IMiddlewareHandlerWithCallback;
import com.bytedance.android.livesdk.schema.interfaces.ISchemaHandler;
import com.bytedance.android.livesdk.schema.model.RedirectSchemaModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/schema/HybridSchemaHandlerService;", "Lcom/bytedance/android/live/schema/IHybridSchemaHandlerService;", "()V", "getCommerceWebViewSchemaHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/IMiddlewareHandlerWithCallback;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "getLynxViewSchemaHandler", "getRedirectSchemaHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/ISchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/RedirectSchemaModel;", "getWebViewHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/IHybridHandler;", "getWebViewSchemaHandler", "show", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dialogFragment", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HybridSchemaHandlerService implements IHybridSchemaHandlerService {
    public HybridSchemaHandlerService() {
    }

    @Override // com.bytedance.android.live.schema.IHybridSchemaHandlerService
    public IMiddlewareHandlerWithCallback<BaseSchemaModel> getCommerceWebViewSchemaHandler() {
        return new CommerceWebActionHandler();
    }

    @Override // com.bytedance.android.live.schema.IHybridSchemaHandlerService
    public IMiddlewareHandlerWithCallback<BaseSchemaModel> getLynxViewSchemaHandler() {
        return new LynxSchemaHandler();
    }

    @Override // com.bytedance.android.live.schema.IHybridSchemaHandlerService
    public ISchemaHandler<RedirectSchemaModel> getRedirectSchemaHandler() {
        return new RedirectHandler();
    }

    @Override // com.bytedance.android.live.schema.IHybridSchemaHandlerService
    public IHybridHandler getWebViewHandler() {
        return new WebViewActionHandler();
    }

    @Override // com.bytedance.android.live.schema.IHybridSchemaHandlerService
    public IMiddlewareHandlerWithCallback<BaseSchemaModel> getWebViewSchemaHandler() {
        return new WebViewActionHandler();
    }

    @Override // com.bytedance.android.live.schema.IHybridSchemaHandlerService
    public boolean show(Context r100, LiveDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dialogFragment");
        return p8.a(r101, r100);
    }
}
