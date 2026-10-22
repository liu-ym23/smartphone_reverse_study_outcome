package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import V4.C0257d;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.util.Base64;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.bff.AuthInfo;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.EventListener;
import com.stepos.taskrobot.llmapi.stepfun.util.AuthTokenCache;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import f6.AbstractC1436a;
import f6.C1438c;
import j9.AbstractC1607a;
import j9.t;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import stepai.aios.guiagent.llm.LlmChatRequest;
import stepai.aios.guiagent.llm.LlmModel;
import stepai.aios.guiagent.llm.LlmService;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.ModelCapabilities;
import stepai.android.llm.base.ContentBuilder;
import stepai.android.llm.base.ImageContentBuilder;
import stepai.android.llm.base.MessageBuilder;
import stepai.android.llm.base.Role;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 I2\u00020\u0001:\u0001IB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020\bH\u0096@¢\u0006\u0004\b+\u0010,J(\u0010\u0018\u001a\u0002022\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0086@¢\u0006\u0004\b\u0018\u00103R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b@\u0010>R\u001a\u0010A\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>R\u001a\u0010C\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\bC\u0010<\u001a\u0004\bD\u0010>R\u001a\u0010E\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\bE\u0010<\u001a\u0004\bF\u0010>R\u0017\u0010G\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\bG\u0010<\u001a\u0004\bH\u0010>¨\u0006J"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlStepService;", "Lstepai/aios/guiagent/llm/LlmService;", "Landroid/content/Context;", "context", "Lf6/c;", "taskRobotAccountUtil", AppAgent.CONSTRUCT, "(Landroid/content/Context;Lf6/c;)V", "", "base64String", "Landroid/graphics/Bitmap;", "base64ToBitmap", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "value", "", "isRemoteUrl", "(Ljava/lang/String;)Z", "isAvailable", "(LH7/c;)Ljava/lang/Object;", "getNetEnv", "(Landroid/content/Context;)Ljava/lang/String;", "Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;", "bizRequest", "Lstepai/aios/guiagent/llm/LlmChatResponse;", "chat", "(Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/MessageRole;", "role", "Lstepai/android/llm/base/Role;", "transformRole", "(Lstepai/aios/guiagent/llm/MessageRole;)Lstepai/android/llm/base/Role;", "Lstepai/aios/guiagent/llm/LlmChatRequest;", "request", "Lp9/c;", "Lstepai/aios/guiagent/llm/LlmStreamResponse;", "chatStream", "(Lstepai/aios/guiagent/llm/LlmChatRequest;)Lp9/c;", "", "Lstepai/aios/guiagent/llm/LlmModel;", "getSupportedModels", "()Ljava/util/List;", "modelName", "Lstepai/aios/guiagent/llm/ModelCapabilities;", "getModelCapabilities", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", SettingsConfig.KEY_DATA, AgentBusWakeContract.EXTRA_TRACE_ID, "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "eventListener", "LC7/r;", "([BLjava/lang/String;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lf6/c;", "Lm9/z;", "chatScope", "Lm9/z;", "serviceId", "Ljava/lang/String;", "getServiceId", "()Ljava/lang/String;", "bizModule", "getBizModule", "bizCommad", "getBizCommad", "aiModule", "getAiModule", "aiCommad", "getAiCommad", "traceId_tmp", "getTraceId_tmp", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlStepService implements LlmService {
    private static final String ACTION_SOURCE_LLM = "llm";
    private static final String TAG = "ZyqlStepService";
    private final String aiCommad;
    private final String aiModule;
    private final String bizCommad;
    private final String bizModule;
    private final InterfaceC1733z chatScope;
    private final Context context;
    private final String serviceId;
    private final C1438c taskRobotAccountUtil;
    private final String traceId_tmp;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageRole.values().length];
            try {
                iArr[MessageRole.SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageRole.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageRole.ASSISTANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageRole.TOOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlStepService", f = "ZyqlStepService.kt", l = {136, 364}, m = "chat", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlStepService$chat$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlStepService.this.chat(null, this);
        }
    }

    public ZyqlStepService(Context context, C1438c c1438c) {
        kotlin.jvm.internal.k.f(context, "context");
        this.context = context;
        this.taskRobotAccountUtil = c1438c;
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        this.chatScope = AbstractC1683A.b(z2.l.H(r0VarC, u9.c.f6743a));
        this.serviceId = "step";
        this.bizModule = "Gui";
        this.bizCommad = BffConstant.Cmd.Invoke;
        this.aiModule = "ClientAgent";
        this.aiCommad = BffConstant.Cmd.AgentCall;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        this.traceId_tmp = string;
    }

    private final Bitmap base64ToBitmap(String base64String) {
        try {
            byte[] bArrDecode = Base64.decode(base64String, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            AbstractC1436a.c(TAG, "base64ToBitmap error: " + e.getMessage(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chat$lambda$2$0$0(ZyqlStepService zyqlStepService, Message message, Map map, Map map2, MessageBuilder message2) {
        kotlin.jvm.internal.k.f(message2, "$this$message");
        message2.role(zyqlStepService.transformRole(message.getRole()));
        Iterator<T> it = message.getContent().iterator();
        while (it.hasNext()) {
            message2.content(new o((MessageContent) it.next(), zyqlStepService, map, map2));
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chat$lambda$2$0$0$0$0(MessageContent messageContent, ZyqlStepService zyqlStepService, Map map, Map map2, ContentBuilder content) {
        kotlin.jvm.internal.k.f(content, "$this$content");
        if (messageContent instanceof MessageContent.Image) {
            if (!j9.m.s0(((MessageContent.Image) messageContent).getImageUrl())) {
                content.image(new o(zyqlStepService, (MessageContent.Image) messageContent, map, map2));
            }
        } else if (messageContent instanceof MessageContent.ImageBase64) {
            if (!j9.m.s0(((MessageContent.ImageBase64) messageContent).getBase64())) {
                content.image(new R3.k(map, (MessageContent.ImageBase64) messageContent, map2, 8));
            }
        } else {
            if (!(messageContent instanceof MessageContent.Text)) {
                if (messageContent instanceof MessageContent.ToolCalls) {
                    throw new NotImplementedError();
                }
                throw new NoWhenBranchMatchedException();
            }
            MessageContent.Text text = (MessageContent.Text) messageContent;
            if (!j9.m.s0(text.getText())) {
                ContentBuilder.text$default(content, text.getText(), null, 2, null);
            }
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chat$lambda$2$0$0$0$0$0(ZyqlStepService zyqlStepService, MessageContent messageContent, Map map, Map map2, ImageContentBuilder image) {
        kotlin.jvm.internal.k.f(image, "$this$image");
        MessageContent.Image image2 = (MessageContent.Image) messageContent;
        if (zyqlStepService.isRemoteUrl(image2.getImageUrl())) {
            image.urlOrBase64(image2.getImageUrl());
        } else {
            String str = (String) map.get(image2.getImageUrl());
            String imageUrl = str != null ? (String) map2.get(str) : null;
            if (imageUrl == null) {
                imageUrl = image2.getImageUrl();
            }
            image.urlOrBase64(imageUrl);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chat$lambda$2$0$0$0$0$1(Map map, MessageContent messageContent, Map map2, ImageContentBuilder image) {
        kotlin.jvm.internal.k.f(image, "$this$image");
        MessageContent.ImageBase64 imageBase64 = (MessageContent.ImageBase64) messageContent;
        String str = (String) map.get(imageBase64.getBase64());
        String str2 = str != null ? (String) map2.get(str) : null;
        String strK = B7.a.k("data:image/jpeg;base64,", imageBase64.getBase64());
        if (str2 == null) {
            str2 = strK;
        }
        image.urlOrBase64(str2);
        return r.f317a;
    }

    private final boolean isRemoteUrl(String value) {
        return t.e0(value, "http://", true) || t.e0(value, "https://", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // stepai.aios.guiagent.llm.LlmService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object chat(stepai.aios.guiagent.llm.biz.LlmChatBizRequest r28, H7.c<? super stepai.aios.guiagent.llm.LlmChatResponse> r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlStepService.chat(stepai.aios.guiagent.llm.biz.LlmChatBizRequest, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public p9.c chatStream(LlmChatRequest request) {
        kotlin.jvm.internal.k.f(request, "request");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final String getAiCommad() {
        return this.aiCommad;
    }

    public final String getAiModule() {
        return this.aiModule;
    }

    public final String getBizCommad() {
        return this.bizCommad;
    }

    public final String getBizModule() {
        return this.bizModule;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public Object getModelCapabilities(String str, H7.c<? super ModelCapabilities> cVar) {
        return new ModelCapabilities(false, true, true, new Integer(8192), new Integer(32768), null, null, 96, null);
    }

    public final String getNetEnv(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "net_env");
        return string == null ? "" : string;
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public /* bridge */ boolean getPrefersBase64Image() {
        return super.getPrefersBase64Image();
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public String getServiceId() {
        return this.serviceId;
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public List<LlmModel> getSupportedModels() {
        return EmptyList.f4893a;
    }

    public final String getTraceId_tmp() {
        return this.traceId_tmp;
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public Object isAvailable(H7.c<? super Boolean> cVar) {
        return Boolean.TRUE;
    }

    public final Role transformRole(MessageRole role) {
        kotlin.jvm.internal.k.f(role, "role");
        int i = WhenMappings.$EnumSwitchMapping$0[role.ordinal()];
        if (i == 1) {
            return Role.System.INSTANCE;
        }
        if (i == 2) {
            return Role.User.INSTANCE;
        }
        if (i == 3) {
            return Role.Assistant.INSTANCE;
        }
        if (i == 4) {
            return Role.System.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ ZyqlStepService(Context context, C1438c c1438c, int i, kotlin.jvm.internal.e eVar) {
        this(context, (i & 2) != 0 ? null : c1438c);
    }

    public final Object chat(byte[] bArr, String str, EventListener eventListener, H7.c<? super r> cVar) {
        List listM = H4.o.M(new C0257d(bArr));
        System.currentTimeMillis();
        V4.l lVar = new V4.l();
        lVar.c = listM;
        lVar.d = BffConstant.Role.User;
        lVar.e = null;
        lVar.f = "text";
        lVar.g = true;
        lVar.h = 0;
        lVar.i = null;
        lVar.f1370j = this.traceId_tmp;
        String bizModule = this.bizModule;
        String bizCommand = this.bizCommad;
        String str2 = this.aiModule;
        String str3 = this.aiCommad;
        kotlin.jvm.internal.k.f(bizModule, "bizModule");
        kotlin.jvm.internal.k.f(bizCommand, "bizCommand");
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bizModule);
        sb.append("|");
        sb.append(bizCommand);
        sb.append("|");
        sb.append(str2);
        byte[] bytes = B7.a.q(sb, "|", str3).getBytes(AbstractC1607a.f4778a);
        kotlin.jvm.internal.k.e(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        kotlin.jvm.internal.k.e(strEncodeToString, "encodeToString(...)");
        lVar.f1364a = strEncodeToString;
        AbstractC1436a.a(TAG, "traceId " + lVar.f1370j, true);
        long jCurrentTimeMillis = System.currentTimeMillis();
        AuthTokenCache authTokenCache = AuthTokenCache.INSTANCE;
        String token = authTokenCache.getToken();
        String uid = authTokenCache.getUid();
        ApiManager apiManager = ApiManager.INSTANCE;
        apiManager.updateAuth(new AuthInfo(token, uid, "bearer", null, 0, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (token.length() == 0) {
            token = "<empty>";
        }
        if (uid.length() == 0) {
            uid = "<empty>";
        }
        String netEnv = getNetEnv(this.context);
        StringBuilder sb2 = new StringBuilder("ApiManager.updateAuth cost ");
        sb2.append(jCurrentTimeMillis2);
        sb2.append("ms  token: ");
        sb2.append(token);
        AbstractC1436a.a(TAG, androidx.appfunctions.metadata.a.p(sb2, "   uid: ", uid, "  netEnv: ", netEnv), true);
        Object objChat = apiManager.chat(ApiType.BFF, lVar, eventListener, cVar);
        return objChat == CoroutineSingletons.f4909a ? objChat : r.f317a;
    }
}
