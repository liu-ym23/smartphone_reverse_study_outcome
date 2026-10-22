package com.android.ttcjpaysdk.base.h5.cjjsb.base;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0005J\u0012\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBDefaultOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "callFail", "", "errCode", "errMsg", "callSuccess", RuleConditionBean.BIZ_DATA_KEY, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBDefaultOutput extends JSBBaseOutput {
    public int code;
    public JSONObject data;
    public String msg;

    public JSBDefaultOutput() {
        this(0, null, null, 7, null);
    }

    public final void callSuccess(JSONObject r100) {
        this.code = 1;
        this.msg = "success";
        if (r100 == null) goto L5;
        this.data = r100;
    L5:
        onSuccess();
    }

    public final void callFail(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        this.code = r100;
        this.msg = r101;
        IJSBResult.DefaultImpls.onFailed$default(this, r101, null, 2, null);
    }

    public JSBDefaultOutput(int r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "data");
        this.code = r100;
        this.msg = r101;
        this.data = r102;
    }

    public static /* synthetic */ void callSuccess$default(JSBDefaultOutput r100, JSONObject r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.callSuccess(r101);
    }

    public /* synthetic */ JSBDefaultOutput(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new JSONObject();
    L11:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void callFail$default(JSBDefaultOutput r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = "fail";
    L8:
        r100.callFail(r101, r102);
    }
}
