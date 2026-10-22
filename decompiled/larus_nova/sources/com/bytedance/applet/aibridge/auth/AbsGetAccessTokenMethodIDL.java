package com.bytedance.applet.aibridge.auth;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/AbsGetAccessTokenMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsGetAccessTokenMethodIDL$GetAccessTokenParamModel;", "Lcom/bytedance/applet/aibridge/auth/AbsGetAccessTokenMethodIDL$GetAccessTokenResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetAccessTokenParamModel", "GetAccessTokenResultModel", "LoginPlatform", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetAccessTokenMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190883a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/AbsGetAccessTokenMethodIDL$LoginPlatform;", "", "<init>", "(Ljava/lang/String;I)V", "DOUYIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoginPlatform extends Enum<LoginPlatform> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LoginPlatform[] $VALUES = null;

        @SerializedName("douyin")
        public static final LoginPlatform DOUYIN = null;

        private static final /* synthetic */ LoginPlatform[] $values() {
            return new LoginPlatform[]{DOUYIN};
        }

        public static EnumEntries<LoginPlatform> getEntries() {
            return $ENTRIES;
        }

        static {
            DOUYIN = new LoginPlatform("DOUYIN", 0);
            LoginPlatform[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static LoginPlatform[] values() {
            return (LoginPlatform[]) $VALUES.clone();
        }

        public static LoginPlatform valueOf(String r100) {
            return (LoginPlatform) r27.a.a(LoginPlatform.class, r100);
        }

        private LoginPlatform(String r100, int r101) {
            super(r100, r101);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "loginPlatform", required = true)
        LoginPlatform getLoginPlatform();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "", type = DefaultType.STRING), keyPath = "accessToken", required = true)
        void setAccessToken(String r100);
    }

    public AbsGetAccessTokenMethodIDL() {
        this.f190883a = "applet.getAccessToken";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f190883a;
    }
}
