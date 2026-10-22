package stepai.aios.guiagent.llm.parser;

import H7.c;
import android.util.Size;
import androidx.autofill.HintConstants;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.config.PromptOverrideManager;
import za.e;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJF\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u000b\u0010\u0013J@\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u000e\u0010\u0013J\u001b\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJI\u0010&\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010)J\u0011\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b+\u0010,J\u0011\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b.\u0010/R\u0014\u00101\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0004R\u0014\u00103\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0004R\u0016\u00105\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0004R\u0014\u00107\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0004R\u001c\u0010;\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<À\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/llm/parser/IModelCell;", "", "", "effectiveSystemPrompt", "()Ljava/lang/String;", "Lza/e;", "session", "imageBase64", "imageUrl", "", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lstepai/aios/guiagent/llm/parser/ModelRequestPayload;", "generateRequestPayload", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Lstepai/aios/guiagent/llm/parser/ModelRequestPayload;", "Lstepai/aios/guiagent/config/LlmConfig;", "llmConfig", "sessionId", "(Lza/e;Ljava/lang/String;Lstepai/aios/guiagent/config/LlmConfig;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "getLastRequestMetadata", "()Ljava/util/Map;", "response", "Lstepai/aios/guiagent/config/Action;", "parseActionResponse", "(Ljava/lang/String;Lza/e;)Lstepai/aios/guiagent/config/Action;", "question", "answer", "LC7/r;", "handleInquiry", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)V", "explain", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "point", "value", "summary", "injectExperienceAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "removeSession", "(Ljava/lang/String;)V", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "Lstepai/aios/guiagent/llm/parser/ModelParam;", "getModelParam", "()Lstepai/aios/guiagent/llm/parser/ModelParam;", "getName", HintConstants.AUTOFILL_HINT_NAME, "getType", "type", "getDesc", "desc", "getSystemPrompt", "systemPrompt", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "getSupportedMode", "()Ljava/util/List;", "supportedMode", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IModelCell {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String effectiveSystemPrompt(IModelCell iModelCell) {
            return IModelCell.super.effectiveSystemPrompt();
        }

        @Deprecated
        public static Object generateRequestMessage(IModelCell iModelCell, e eVar, String str, LlmConfig llmConfig, String str2, String str3, c<? super List<Message>> cVar) {
            return IModelCell.super.generateRequestMessage(eVar, str, llmConfig, str2, str3, cVar);
        }

        @Deprecated
        public static ModelRequestPayload generateRequestPayload(IModelCell iModelCell, e eVar, String str, String str2) {
            return IModelCell.super.generateRequestPayload(eVar, str, str2);
        }

        @Deprecated
        public static Size getCompressBitmapSize(IModelCell iModelCell) {
            return IModelCell.super.getCompressBitmapSize();
        }

        @Deprecated
        public static Map<String, Object> getLastRequestMetadata(IModelCell iModelCell) {
            return IModelCell.super.getLastRequestMetadata();
        }

        @Deprecated
        public static ModelParam getModelParam(IModelCell iModelCell) {
            return IModelCell.super.getModelParam();
        }

        @Deprecated
        public static List<GUIAgentMode> getSupportedMode(IModelCell iModelCell) {
            return IModelCell.super.getSupportedMode();
        }

        @Deprecated
        public static void handleInquiry(IModelCell iModelCell, e eVar, String str, String str2) {
            IModelCell.super.handleInquiry(eVar, str, str2);
        }

        @Deprecated
        public static void injectExperienceAction(IModelCell iModelCell, String str, String str2, List<Integer> list, String str3, String str4) {
            IModelCell.super.injectExperienceAction(str, str2, list, str3, str4);
        }

        @Deprecated
        public static void removeSession(IModelCell iModelCell, String sessionId) {
            k.f(sessionId, "sessionId");
            IModelCell.super.removeSession(sessionId);
        }

        @Deprecated
        public static Object generateRequestPayload(IModelCell iModelCell, e eVar, String str, LlmConfig llmConfig, String str2, String str3, c<? super ModelRequestPayload> cVar) {
            return IModelCell.super.generateRequestPayload(eVar, str, llmConfig, str2, str3, cVar);
        }
    }

    @J7.c(c = "stepai.aios.guiagent.llm.parser.IModelCell", f = "IActionParser.kt", l = {88}, m = "generateRequestPayload$suspendImpl", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.parser.IModelCell$generateRequestPayload$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IModelCell.generateRequestPayload$suspendImpl(IModelCell.this, null, null, null, null, null, this);
        }
    }

    static /* synthetic */ List generateRequestMessage$default(IModelCell iModelCell, e eVar, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateRequestMessage");
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return iModelCell.generateRequestMessage(eVar, str, str2);
    }

    static /* synthetic */ Object generateRequestMessage$suspendImpl(IModelCell iModelCell, e eVar, String str, LlmConfig llmConfig, String str2, String str3, c<? super List<Message>> cVar) {
        return iModelCell.generateRequestMessage(eVar, str, str3);
    }

    static /* synthetic */ ModelRequestPayload generateRequestPayload$default(IModelCell iModelCell, e eVar, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateRequestPayload");
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return iModelCell.generateRequestPayload(eVar, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.Object generateRequestPayload$suspendImpl(stepai.aios.guiagent.llm.parser.IModelCell r5, za.e r6, java.lang.String r7, stepai.aios.guiagent.config.LlmConfig r8, java.lang.String r9, java.lang.String r10, H7.c<? super stepai.aios.guiagent.llm.parser.ModelRequestPayload> r11) {
        /*
            boolean r0 = r11 instanceof stepai.aios.guiagent.llm.parser.IModelCell.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            stepai.aios.guiagent.llm.parser.IModelCell$generateRequestPayload$1 r0 = (stepai.aios.guiagent.llm.parser.IModelCell.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r11 = r0
            goto L1a
        L14:
            stepai.aios.guiagent.llm.parser.IModelCell$generateRequestPayload$1 r0 = new stepai.aios.guiagent.llm.parser.IModelCell$generateRequestPayload$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r0 = r11.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r11.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r5 = r11.L$5
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r11.L$4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r11.L$3
            stepai.aios.guiagent.config.LlmConfig r5 = (stepai.aios.guiagent.config.LlmConfig) r5
            java.lang.Object r5 = r11.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r11.L$1
            za.e r5 = (za.e) r5
            java.lang.Object r5 = r11.L$0
            stepai.aios.guiagent.llm.parser.IModelCell r5 = (stepai.aios.guiagent.llm.parser.IModelCell) r5
            kotlin.b.b(r0)
            goto L62
        L42:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L4a:
            kotlin.b.b(r0)
            r11.L$0 = r4
            r11.L$1 = r4
            r11.L$2 = r4
            r11.L$3 = r4
            r11.L$4 = r4
            r11.L$5 = r4
            r11.label = r3
            java.lang.Object r0 = r5.generateRequestMessage(r6, r7, r8, r9, r10, r11)
            if (r0 != r1) goto L62
            return r1
        L62:
            java.util.List r0 = (java.util.List) r0
            stepai.aios.guiagent.llm.parser.ModelRequestPayload r5 = new stepai.aios.guiagent.llm.parser.ModelRequestPayload
            r6 = 2
            r5.<init>(r0, r4, r6, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.parser.IModelCell.generateRequestPayload$suspendImpl(stepai.aios.guiagent.llm.parser.IModelCell, za.e, java.lang.String, stepai.aios.guiagent.config.LlmConfig, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    static /* synthetic */ void injectExperienceAction$default(IModelCell iModelCell, String str, String str2, List list, String str3, String str4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: injectExperienceAction");
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        iModelCell.injectExperienceAction(str, str2, list, str3, str4);
    }

    default String effectiveSystemPrompt() {
        return PromptOverrideManager.INSTANCE.getEffectivePrompt(getType(), getSystemPrompt());
    }

    default Object generateRequestMessage(e eVar, String str, LlmConfig llmConfig, String str2, String str3, c<? super List<Message>> cVar) {
        return generateRequestMessage$suspendImpl(this, eVar, str, llmConfig, str2, str3, cVar);
    }

    List<Message> generateRequestMessage(e session, String imageBase64, String imageUrl);

    default Object generateRequestPayload(e eVar, String str, LlmConfig llmConfig, String str2, String str3, c<? super ModelRequestPayload> cVar) {
        return generateRequestPayload$suspendImpl(this, eVar, str, llmConfig, str2, str3, cVar);
    }

    default Size getCompressBitmapSize() {
        return null;
    }

    String getDesc();

    default Map<String, Object> getLastRequestMetadata() {
        return a.M();
    }

    default ModelParam getModelParam() {
        return null;
    }

    String getName();

    default List<GUIAgentMode> getSupportedMode() {
        return null;
    }

    String getSystemPrompt();

    String getType();

    default void handleInquiry(e session, String question, String answer) {
    }

    default void injectExperienceAction(String explain, String action, List<Integer> point, String value, String summary) {
    }

    Action parseActionResponse(String response, e session);

    default void removeSession(String sessionId) {
        k.f(sessionId, "sessionId");
    }

    static /* synthetic */ Object generateRequestMessage$default(IModelCell iModelCell, e eVar, String str, LlmConfig llmConfig, String str2, String str3, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateRequestMessage");
        }
        if ((i & 16) != 0) {
            str3 = null;
        }
        return iModelCell.generateRequestMessage(eVar, str, llmConfig, str2, str3, cVar);
    }

    static /* synthetic */ Object generateRequestPayload$default(IModelCell iModelCell, e eVar, String str, LlmConfig llmConfig, String str2, String str3, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateRequestPayload");
        }
        if ((i & 16) != 0) {
            str3 = null;
        }
        return iModelCell.generateRequestPayload(eVar, str, llmConfig, str2, str3, cVar);
    }

    default ModelRequestPayload generateRequestPayload(e session, String imageBase64, String imageUrl) {
        return new ModelRequestPayload(generateRequestMessage(session, imageBase64, imageUrl), null, 2, null);
    }
}
