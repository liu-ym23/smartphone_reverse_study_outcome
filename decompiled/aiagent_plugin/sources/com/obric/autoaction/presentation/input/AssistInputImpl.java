package com.obric.autoaction.presentation.input;

import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.k;
import d.o;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AssistInputImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistInputImpl implements IAssistInputHost {

    /* JADX INFO: compiled from: AssistInputImpl.kt */
    @f(b = "AssistInputImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.AssistInputImpl$completedInput$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAssistInputStateManager.AssistInputMode f24952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24953c;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.AssistInputImpl$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AssistInputImpl.kt */
        public /* synthetic */ class C0583a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f24954a = null;

            static {
                int[] r0 = new int[IAssistInputStateManager.AssistInputMode.values().length];
                r0[IAssistInputStateManager.AssistInputMode.CLARIFY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[IAssistInputStateManager.AssistInputMode.ADDITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[IAssistInputStateManager.AssistInputMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f24954a = r0;
            }
        }

        a(IAssistInputStateManager.AssistInputMode r3, String r4, d<? super a> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f24952b = r3;
            this.f24953c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f24952b, this.f24953c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f24951a != 0) goto L21;
            o.a(r4);
            IAssistInputStateManager.AssistInputMode r5 = this.f24952b;
            int r6 = C0583a.f24954a[r5.ordinal()];
            if (r6 != 1) goto L7;
            IAutoActionPresentationApi r7 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L24;
            r7.exitClarifyStateInSurfaceActivity(this.f24953c);
            return x.f38692a;
        L24:
            return null;
        L7:
            if (r6 != 2) goto L9;
            IAutoActionPresentationApi r8 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L23;
            r8.exitClarifyStateInSurfaceActivity(this.f24953c);
        L22:
            return x.f38692a;
        L23:
            return null;
        L9:
            if (r6 == 3) goto L22;
            throw new k();
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AssistInputImpl() {
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputHost
    public void startInput() {
        b.f24958a.b();
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputHost
    public void cancelInput() {
        b.f24958a.c();
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputHost
    public void closeInput() {
        b.f24958a.d();
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputHost
    public void openInput(boolean r8, Map<String, String> r9) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        b.a(b.f24958a, r8, false, null, r4, 6, null);
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputHost
    public void openInput(String r2, String r3, Map<String, String> r4) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "taskType");
        b.f24958a.a(r2, r3, r1);
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputHost
    public void completedInput(IAssistInputStateManager.AssistInputMode r3, String r4) {
        d.h.b.o.e(r3, "inputMode");
        d.h.b.o.e(r4, "text");
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new a(r3, r4, null), m.class, "com.obric.aiagent.plugin"));
    }
}
