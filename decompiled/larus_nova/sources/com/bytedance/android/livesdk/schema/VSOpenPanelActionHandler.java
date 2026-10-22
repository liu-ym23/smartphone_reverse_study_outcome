package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.event.OpenVsPanelEvent;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IHandlerWithCallback;
import com.bytedance.android.livesdk.schema.model.VsOpenPanelSchemaModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/schema/VSOpenPanelActionHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IHandlerWithCallback;", "Lcom/bytedance/android/livesdk/schema/model/VsOpenPanelSchemaModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "handleAction", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "Companion", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSOpenPanelActionHandler implements IHandlerWithCallback<VsOpenPanelSchemaModel> {
    public static final Companion Companion = null;
    public static final String TAG = "VSOpenPanelActionHandler";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/schema/VSOpenPanelActionHandler$Companion;", "", "()V", "TAG", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VSOpenPanelActionHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getHost();
    L7:
        if (TextUtils.equals(SchemaHandlerHostConstants.VS_OPEN_PANEL_WEBVIEW_SCHEMA_HOST, r102) == true) goto L14;
        if (r100 == null) goto L11;
        r101 = r100.getHost();
    L11:
        if (TextUtils.equals(SchemaHandlerHostConstants.VS_OPEN_PANEL_LYNXVIEW_SCHEMA_HOST, r101) == true) goto L14;
        return false;
    L14:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public boolean handle(Context r100, VsOpenPanelSchemaModel r101) {
        if (r101 == null) goto L7;
        Uri r102 = r101.getUri();
        if (r102 == null) goto L7;
        String r103 = r102.toString();
        if (r103 == null) goto L7;
    L8:
        ALogger.i(TAG, r103);
        if (r101 == null) goto L13;
        Uri r104 = r101.getUri();
        if (r104 == null) goto L13;
        ALogger.i(TAG, r104.toString());
        int r105 = !TextUtils.equals(SchemaHandlerHostConstants.VS_OPEN_PANEL_WEBVIEW_SCHEMA_HOST, r104.getHost()) ? 1 : 0;
        xs2.b.a().post(new OpenVsPanelEvent(r104, r105, null, 4, null));
        return true;
    L13:
        return false;
    L7:
        r103 = "null";
        goto L8
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (VsOpenPanelSchemaModel) r101);
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IHandlerWithCallback
    public boolean handleAction(Context r100, Uri r101, DialogInterface.OnDismissListener r102) {
        if (r101 == null) goto L5;
        String r103 = r101.toString();
        if (r103 == null) goto L5;
    L6:
        ALogger.i(TAG, r103);
        if (r101 != null) goto L10;
        return false;
    L10:
        int r104 = !TextUtils.equals(SchemaHandlerHostConstants.VS_OPEN_PANEL_WEBVIEW_SCHEMA_HOST, r101.getHost()) ? 1 : 0;
        xs2.b.a().post(new OpenVsPanelEvent(r101, r104, r102));
        return true;
    L5:
        r103 = "null";
        goto L6
    }
}
