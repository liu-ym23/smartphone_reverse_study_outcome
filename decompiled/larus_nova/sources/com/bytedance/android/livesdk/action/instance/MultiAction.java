package com.bytedance.android.livesdk.action.instance;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.action.ActionManager;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@ActionMethod("webcast_inroom_actions")
public class MultiAction extends BaseActionMethod<Void> {
    final String ACTION_KEY;

    public static class ActionItem {

        @SerializedName("next_actions")
        public List<String> nextActions;

        @SerializedName("schema")
        public String schema;

        public ActionItem() {
        }
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public MultiAction() {
        this.ACTION_KEY = SlcCommonAction.KEY_ACTIONS;
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r100) throws Exception {
        String r101 = String.valueOf(r100.get(SlcCommonAction.KEY_ACTIONS));
        TypeToken<List<ActionItem>> r102 = new AnonymousClass1(this);
        List r103 = (List) GsonProtectorUtils.fromJson(GsonHelper.get(), r101, r102.getType());
        if (Lists.isEmpty(r103) == false) goto L5;
        return;
    L5:
        Iterator r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ActionItem r105 = (ActionItem) r104.next();
        String r106 = r105.schema;
        final List<String> r107 = r105.nextActions;
        ActionManager.getInstance().actionCallback(r106, new AnonymousClass2(this, r107));
        goto L7
    L9:
        finishWithResult(null);
    }
}
