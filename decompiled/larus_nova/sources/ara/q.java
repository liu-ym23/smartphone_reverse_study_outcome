package ara;

import android.app.Activity;
import android.content.Intent;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.sendSms")
public final class q extends bra.k {
    public q() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        bra.k.b r113 = (bra.k.b) r111;
        long r100 = System.currentTimeMillis();
        Activity r114 = r110.getOwnerActivity();
        if (r114 == null) goto L11;
        String r101 = r113.getPhoneNumber();
        String r102 = r113.getContent();
        Intent r103 = new Intent("android.intent.action.SENDTO", UriProtector.parse(String.format("smsto:%s", new Object[]{r101})));
        r103.putExtra("sms_body", r102);
        String r104 = Telephony.Sms.getDefaultSmsPackage(r114);
        if (TextUtils.isEmpty(r104) == true) goto L13;
        r103.setPackage(r104);
    L13:
        r114.startActivity(r103);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.getStackTraceString(e);
    L11:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(bra.k.c.class), null, 2, null);
        int r115 = a.f16045a;
        String r105 = this.f20188a;
        long r106 = System.currentTimeMillis() - r100;
        JSONObject r116 = new JSONObject();
        r116.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, r113.getPhoneNumber());
        r116.put("content", r113.getContent());
        a.b(r105, r116.toString(), null, r106, null, 116);
    }
}
