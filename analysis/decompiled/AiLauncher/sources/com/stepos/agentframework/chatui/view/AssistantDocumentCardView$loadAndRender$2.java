package com.stepos.agentframework.chatui.view;

import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.view.AssistantDocumentCardView$loadAndRender$2", f = "AssistantDocumentCardView.kt", l = {104}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AssistantDocumentCardView$loadAndRender$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.p<String, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> $fetcher;
    final /* synthetic */ String $id;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AssistantDocumentCardView this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentFileSyncBridge.Status.values().length];
            try {
                iArr[AgentFileSyncBridge.Status.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentFileSyncBridge.Status.SYNCING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AssistantDocumentCardView$loadAndRender$2(AssistantDocumentCardView assistantDocumentCardView, p9.p<? super String, ? super InterfaceC4014c<? super AgentFileSyncBridge.Result>, ? extends Object> pVar, String str, InterfaceC4014c<? super AssistantDocumentCardView$loadAndRender$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = assistantDocumentCardView;
        this.$fetcher = pVar;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AssistantDocumentCardView$loadAndRender$2 assistantDocumentCardView$loadAndRender$2 = new AssistantDocumentCardView$loadAndRender$2(this.this$0, this.$fetcher, this.$id, interfaceC4014c);
        assistantDocumentCardView$loadAndRender$2.L$0 = obj;
        return assistantDocumentCardView$loadAndRender$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AssistantDocumentCardView$loadAndRender$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                p9.p<String, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> pVar = this.$fetcher;
                String str = this.$id;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = pVar.invoke(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((AgentFileSyncBridge.Result) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        AgentFileSyncBridge.Result result = (AgentFileSyncBridge.Result) objB;
        this.this$0.loading = false;
        this.this$0.syncResult = result;
        AgentFileSyncBridge.Status status = result != null ? result.getStatus() : null;
        int i11 = status == null ? -1 : a.$EnumSwitchMapping$0[status.ordinal()];
        if (i11 == 1) {
            AssistantDocumentCardView assistantDocumentCardView = this.this$0;
            String markdownText = result.getMarkdownText();
            if (markdownText == null) {
                markdownText = "";
            }
            assistantDocumentCardView.markdown = markdownText;
            AssistantDocumentCardView assistantDocumentCardView2 = this.this$0;
            String str2 = assistantDocumentCardView2.markdown;
            kotlin.jvm.internal.p.f(str2);
            assistantDocumentCardView2.o(str2);
        } else if (i11 != 2) {
            this.this$0.p("预览失败");
        }
        return Y8.t.f7040a;
    }
}
