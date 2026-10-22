package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdk.schema.model.LiveCertModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/schema/LiveCertActionHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/LiveCertModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "certModel", "Companion", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCertActionHandler implements IBaseSchemaHandler<LiveCertModel> {
    public static final Companion Companion = null;
    private static final String TAG = "LiveCertActionHandler";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/schema/LiveCertActionHandler$Companion;", "", "()V", "TAG", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public LiveCertActionHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getHost();
    L6:
        return TextUtils.equals(r101, SchemaHandlerHostConstants.START_LIVE_CERT_HOST);
    L4:
        r101 = null;
        goto L6
    }

    public boolean handle(Context r110, final LiveCertModel r111) {
        boolean r100 = false;
        if (r110 != null) goto L5;
        return false;
    L5:
        if (r111 == null) goto L34;
        HashMap<String, String> r101 = new HashMap();
        String r102 = r111.getIdentity_code();
        if (r102 == null) goto L9;
        String r103 = r101.put(BytedCertConstant.CertKey.IDENTITY_CODE, r102);
    L9:
        String r104 = r111.getIdentity_name();
        if (r104 == null) goto L12;
        r101.put(BytedCertConstant.CertKey.IDENTITY_NAME, r104);
    L12:
        HashMap<String, String> r105 = new HashMap();
        String r106 = r111.getScene();
        if (r106 == null) goto L15;
        String r107 = r105.put("scene", r106);
    L15:
        String r108 = r111.getFlow();
        if (r108 == null) goto L18;
        String r109 = r105.put(BytedCertConstant.CertKey.FLOW, r108);
    L18:
        String r112 = r111.getTicket();
        if (r112 == null) goto L21;
        String r113 = r105.put("ticket", r112);
    L21:
        String r114 = r111.getCert_app_id();
        if (r114 == null) goto L24;
        r105.put("cert_app_id", r114);
    L24:
        JSONObject r115 = new JSONObject();
        String r116 = r111.getExtra_params();
        if (r116 != null) goto L36;
    L30:
        JSONObject r117 = r115;
        ALogger.i("[LiveVerifyFullTracer]", "LiveCertActionHandler， scene = " + r111.getScene() + ", flow = " + r111.getFlow() + ", face_only = " + r111.getFace_only() + ',');
        IHostVerify r118 = (IHostVerify) jc1.k.n(IHostVerify.class);
        if (r111.getFace_only() != 1) goto L33;
        r100 = true;
    L33:
        r118.doFaceLive(r110, r101, r105, r117, r100, new LiveCertActionHandler$handle$1$1$2(r111));
        goto L34
    L36:
        r115 = new JSONObject(r116);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        ALogger.e("[LiveVerifyFullTracer]", "LiveCertActionHandler， extra_params error " + e.toString());
    L34:
        return true;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (LiveCertModel) r101);
    }
}
