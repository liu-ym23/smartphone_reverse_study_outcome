package com.bytedance.bdtracker;

import com.bytedance.applog.IPickerCallback;
import com.bytedance.bdtracker.p3;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n3 implements IPickerCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ p3 b;

    public n3(p3 p3Var, int i) {
        this.b = p3Var;
        this.a = i;
    }

    @Override // com.bytedance.applog.IPickerCallback
    public void failed(String str) {
        JSONArray jSONArray = new JSONArray();
        p3 p3Var = this.b;
        int i = this.a;
        p3.b bVar = p3Var.f;
        if (bVar != null) {
            bVar.onGetCircleInfoFinish(i, jSONArray);
        }
        this.b.j.D.warn(Collections.singletonList("PickerApi"), "load reactNative pageInfo timeout", new Object[0]);
    }

    @Override // com.bytedance.applog.IPickerCallback
    public void success(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        p3 p3Var = this.b;
        int i = this.a;
        p3.b bVar = p3Var.f;
        if (bVar != null) {
            bVar.onGetCircleInfoFinish(i, jSONArray);
        }
    }
}
