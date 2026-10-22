package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.downloadlib.constants.DownloadConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@LiveAtomicAbilityDescriptor(action = DownloadConstants.KEY_TOAST, description = "展示Toast", service = {"LiveBase"})
public final class h0 extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> {
    public h0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r100, JSONObject r101, Object r110, il2.a r111, com.bytedance.android.livesdk.livecommerce.ability.e r112) {
        JSONObject r102 = r101;
        if (r100 == null) goto L17;
        if (r102 == null) goto L17;
        String r103 = r102.optString("toast");
        int r104 = r102.optInt("toast_type", 0);
        if (r104 != 1) goto L9;
        Toast.makeText(r100, r103, 0).show();
    L15:
        if (r112 == null) goto L20;
        r112.onSuccess();
        return;
    L20:
        return;
    L9:
        if (r104 == 2) goto L13;
        if (r104 == 3) goto L12;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r100, r103);
        goto L15
    L12:
        ECToast.showToast$default(ECToast.INSTANCE, r100, r103, null, 4, null);
        goto L15
    L13:
        UIUtils.displayToast(r100, r103);
    L17:
        if (r112 == null) goto L22;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r112, 0, null, 3);
        return;
    }
}
