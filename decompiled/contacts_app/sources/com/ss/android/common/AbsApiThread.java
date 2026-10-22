package com.ss.android.common;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.dispatcher.ApiThread;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsApiThread extends ApiThread {
    public static final String KEY_DATA = "data";
    public static final String KEY_MESSAGE = "message";
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_SUCCESS = "success";

    public static boolean isApiSuccess(JSONObject r1) throws JSONException {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if ("success".equals(r1.optString("message")) == false) goto L6;
        return true;
    }

    public static boolean isApiSuccess(String r2) {
        if (StringUtils.isEmpty(r2) == false) goto L10;
        return false;
    L10:
        return isApiSuccess(new JSONObject(r2));
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean optBoolean(JSONObject r2, String r3, boolean r4) {
        if (r2 != null) goto L4;
    L14:
        return r4;
    L4:
        if (r2.isNull(r3) == true) goto L14;
        int r0 = r2.optInt(r3, -1);
        if (r0 < 1) goto L9;
        return true;
    L9:
        if (r0 != 0) goto L13;
        return false;
    L13:
        return r2.optBoolean(r3, r4);
    }

    public static boolean getHasMore(JSONObject r1, boolean r2) {
        return optBoolean(r1, "has_more", r2);
    }

    protected AbsApiThread(String r1, IRequest.Priority r2) {
        super(r1, r2);
    }

    protected AbsApiThread(String r1, boolean r2) {
        if (r2 == false) goto L4;
        IRequest.Priority r3 = IRequest.Priority.LOW;
    L5:
        this(r1, r3);
        return;
    L4:
        r3 = IRequest.Priority.NORMAL;
        goto L5
    }

    protected AbsApiThread(String r2) {
        this(r2, IRequest.Priority.NORMAL);
    }

    protected AbsApiThread() {
        this(null, IRequest.Priority.NORMAL);
    }

    protected AbsApiThread(IRequest.Priority r2) {
        this(null, r2);
    }

    protected AbsApiThread(boolean r2) {
        if (r2 == false) goto L4;
        IRequest.Priority r3 = IRequest.Priority.LOW;
    L5:
        this(null, r3);
        return;
    L4:
        r3 = IRequest.Priority.NORMAL;
        goto L5
    }
}
