package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.MobConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "activityMagicGestureStatusChange")
public final class d2 extends com.bytedance.ies.web.jsbridge2.g<a, JSONObject> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d2$a;", "", "", "status", "I", "e", "()I", "", "effectId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", ReportConstant.COMMON_ACTION_TYPE, "b", "actionSchema", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bizId", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("action_schema")
        private final String actionSchema;

        @SerializedName("action_type")
        private final int actionType;

        @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
        private final String bizId;

        @SerializedName(MobConstants.EFFECT_ID)
        private final String effectId;

        @SerializedName("status")
        private final int status;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (this.status == r101.status) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.effectId, r101.effectId) == true) goto L10;
            return false;
        L10:
            if (this.actionType == r101.actionType) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.actionSchema, r101.actionSchema) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r100 = this.status * 31;
            String r101 = this.effectId;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (((r100 + r103) * 31) + this.actionType) * 31;
            String r105 = this.actionSchema;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.bizId;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            return r107 + r102;
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(status=" + this.status + ", effectId=" + this.effectId + ", actionType=" + this.actionType + ", actionSchema=" + this.actionSchema + ", bizId=" + this.bizId + ")";
        }

        public a() {
            Intrinsics.checkNotNullParameter("", "effectId");
            Intrinsics.checkNotNullParameter("", "bizId");
            this.status = 0;
            this.effectId = "";
            this.actionType = 0;
            this.actionSchema = null;
            this.bizId = "";
        }

        public final String a() {
            return this.actionSchema;
        }

        public final int b() {
            return this.actionType;
        }

        public final String c() {
            return this.bizId;
        }

        public final String d() {
            return this.effectId;
        }

        public final int e() {
            return this.status;
        }
    }

    public d2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.e("MagicGestureActivityMethod", "invoke status: " + r102.e() + ", effectId: " + r102.d() + ",actionType: " + r102.b() + ", actionSchema: " + r102.a() + ", bizId: " + r102.c());
        xs2.b.a().post(new zg1.q1(r102.e(), r102.d(), r102.b(), r102.a(), r102.c()));
        return null;
    }
}
