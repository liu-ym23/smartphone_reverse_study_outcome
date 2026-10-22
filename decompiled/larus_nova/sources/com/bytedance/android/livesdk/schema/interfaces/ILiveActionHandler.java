package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.schema.LiveActionHandlerImpl")
public interface ILiveActionHandler extends IBaseLiveActionHandler {
    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler
    <R> boolean handle(Context r100, Uri r101, IBaseCallbackSchemaHandler.SchemaCallback<R> r102);

    void postReportReason(long r100, long r101, long r102, String r103);

    boolean showUserProfile(String r100);

    boolean showUserProfile(String r100, String r101, Map<String, String> r102);
}
