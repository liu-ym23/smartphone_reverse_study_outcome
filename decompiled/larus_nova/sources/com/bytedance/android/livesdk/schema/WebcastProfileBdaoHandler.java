package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IHandlerWithCallback;
import com.bytedance.android.livesdk.utils.x6;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/WebcastProfileBdaoHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IHandlerWithCallback;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "handleAction", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebcastProfileBdaoHandler implements IHandlerWithCallback<BaseSchemaModel> {
    public WebcastProfileBdaoHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean handle(Context r100, BaseSchemaModel r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return false;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (Intrinsics.areEqual("webcast_profile_bdao", r100.getHost()) == false) goto L6;
        return true;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IHandlerWithCallback
    public boolean handleAction(Context r100, Uri r101, DialogInterface.OnDismissListener r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        String r103 = UriProtector.getQueryParameter(r101, "user_id");
        if (r103 != null) goto L6;
        r103 = UriProtector.getQueryParameter(r101, "user_open_id");
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        f2.b(R.string.ttlive_live_end_page_profile_tips, 0);
        return true;
    L15:
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<T> r106 = UriProtector.getQueryParameterNames(r101).iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        String r107 = (String) r106.next();
        r105.put(r107, UriProtector.getQueryParameter(r101, r107));
        goto L17
    L19:
        x6.a(r100, r103, r105, 3);
        return true;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    }
}
