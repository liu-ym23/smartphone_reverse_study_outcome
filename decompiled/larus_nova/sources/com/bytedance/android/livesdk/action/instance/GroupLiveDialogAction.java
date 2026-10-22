package com.bytedance.android.livesdk.action.instance;

import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0096\u0002J\b\u0010\n\u001a\u00020\u0005H\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/action/instance/GroupLiveDialogAction;", "Lcom/bytedance/android/livesdk/action/BaseActionMethod;", "Lorg/json/JSONObject;", "()V", AbsMethodDelegate.TAG_INVOKE, "", "params", "", "", "", "onTerminate", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@ActionMethod("webcast_inroom_grouplive")
public final class GroupLiveDialogAction extends BaseActionMethod<JSONObject> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public GroupLiveDialogAction() {
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("source");
    L7:
        if ((r102 instanceof String) == false) goto L10;
        r101 = r102;
    L10:
        String r103 = (String) r101;
        if (r103 != null) goto L13;
        r103 = "banner";
    L13:
        ((IGiftServiceExternal) k.n(IGiftServiceExternal.class)).openGroupLiveDialog(r103);
        return;
    L5:
        r102 = null;
        goto L7
    }
}
