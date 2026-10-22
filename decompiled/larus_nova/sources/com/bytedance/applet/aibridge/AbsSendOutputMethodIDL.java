package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AbsSendOutputMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/AbsSendOutputMethodIDL$SendOutputMethodParamModel;", "Lcom/bytedance/applet/aibridge/AbsSendOutputMethodIDL$SendOutputMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SupportedOutputType", "SendOutputMethodParamModel", "SendOutputMethodResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSendOutputMethodIDL extends CoreAIBridgeMethod<a, b> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applet/aibridge/AbsSendOutputMethodIDL$SupportedOutputType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "Tips", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SupportedOutputType extends Enum<SupportedOutputType> {
        public static final SupportedOutputType Tips = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SupportedOutputType[] f190861a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f190862b = null;
        private final String typeName;

        public static EnumEntries<SupportedOutputType> getEntries() {
            return f190862b;
        }

        static {
            SupportedOutputType r100 = new SupportedOutputType();
            Tips = r100;
            SupportedOutputType[] r101 = {r100};
            f190861a = r101;
            f190862b = EnumEntriesKt.enumEntries(r101);
        }

        public SupportedOutputType() {
            super("Tips", 0);
            this.typeName = "tips";
        }

        public static SupportedOutputType[] values() {
            return (SupportedOutputType[]) f190861a.clone();
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public static SupportedOutputType valueOf(String r100) {
            return (SupportedOutputType) r27.a.a(SupportedOutputType.class, r100);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "message", required = true)
        String getMessage();

        @AIBridgeParamField(keyPath = "type", required = true)
        String getType();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return "applet.sendOutput";
    }

    public AbsSendOutputMethodIDL() {
    }
}
