package com.bytedance.android.btm.api.model;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements xc.a<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42069a;

    public static final class a {
    }

    static {
    }

    public final String getType() {
        return null;
    }

    @Override // xc.a
    public final String save() {
        JSONObject r100 = new JSONObject();
        r100.put(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD, null);
        r100.put("type", null);
        r100.put("extra_info", null);
        r100.put("target_btm", null);
        r100.put("expire", this.f42069a);
        return r100.toString();
    }
}
