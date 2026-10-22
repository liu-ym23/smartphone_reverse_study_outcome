package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdk.schema.model.LivePicPreviewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/schema/PreviewPicActionHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/LivePicPreviewModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Companion", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewPicActionHandler implements IBaseSchemaHandler<LivePicPreviewModel> {
    public static final Companion Companion = null;
    public static final String TAG = "PreviewPicActionHandler";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/schema/PreviewPicActionHandler$Companion;", "", "()V", "TAG", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public PreviewPicActionHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getHost();
        if (r101 == null) goto L6;
        return r101.equals(SchemaHandlerHostConstants.OPEN_PIC_PREVIEW);
    L6:
        return false;
    }

    public boolean handle(Context r100, LivePicPreviewModel r101) {
        if (r101 == null) goto L14;
        String r102 = r101.getUrl();
        if (r102 == null) goto L14;
        if (r100 != null) goto L9;
        return false;
    L9:
        IPublicScreenService r103 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
        if (r103 == null) goto L15;
        r103.showPicPreviewDialogFragment(r102, r100);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (LivePicPreviewModel) r101);
    }
}
