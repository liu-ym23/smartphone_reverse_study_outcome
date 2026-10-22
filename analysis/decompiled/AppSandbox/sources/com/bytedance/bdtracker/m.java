package com.bytedance.bdtracker;

import com.bytedance.bdtracker.p;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applog/alink/model/ApiResponse;", "T", "Lcom/bytedance/applog/alink/model/BaseData;", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA, "getData", "()Lcom/bytedance/applog/alink/model/BaseData;", "setData", "(Lcom/bytedance/applog/alink/model/BaseData;)V", "Lcom/bytedance/applog/alink/model/BaseData;", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Companion", "agent_pickerChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class m<T extends p> {
    public static final a c = new a(null);
    public String a;
    public T b;

    public final T a() {
        return this.b;
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends p> m<T> a(String str, Class<T> clazz) {
            Intrinsics.checkParameterIsNotNull(clazz, "clazz");
            JSONObject jSONObject = new JSONObject(str);
            m<T> mVar = new m<>();
            jSONObject.optInt("code");
            mVar.a = jSONObject.optString("message");
            mVar.b = (T) p.a.a(jSONObject.optJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA), clazz);
            return mVar;
        }

        public final <T extends p> m<T> a(Throwable throwable) {
            String str;
            Intrinsics.checkParameterIsNotNull(throwable, "throwable");
            m<T> mVar = new m<>();
            if (throwable instanceof i3) {
                str = "DDL request timeout";
            } else {
                str = throwable + " message:" + throwable.getMessage();
            }
            mVar.a = str;
            return mVar;
        }
    }
}
