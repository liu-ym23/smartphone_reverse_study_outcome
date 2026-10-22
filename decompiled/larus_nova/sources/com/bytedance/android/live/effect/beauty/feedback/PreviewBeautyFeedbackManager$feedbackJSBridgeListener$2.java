package com.bytedance.android.live.effect.beauty.feedback;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.jsbridge.base.CloseFeedbackPageResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import w20.e8;
import w20.w;
import y6.c;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/live/effect/beauty/feedback/PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/live/effect/beauty/feedback/PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2 extends Lambda implements Function0<a> {
    final /* synthetic */ b this$0;

    public static final class a implements IHybridComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2 f67217a;

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.feedback.PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a$a, reason: collision with other inner class name */
        public static final class C1107a implements f.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f67218a;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.feedback.PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a$a$a, reason: collision with other inner class name */
            public static final class C1108a extends w<e8, CloseFeedbackPageResultModel> {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ C1107a f67219b;

                public C1108a(C1107a r100) {
                    this.f67219b = r100;
                }

                @Override // com.bytedance.ies.web.jsbridge2.f
                public final void invoke(Object r100, CallContext r101) {
                    Intrinsics.checkNotNullParameter((e8) r100, "params");
                    Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
                    ALogger.d("ttlive_anchor_effect_PreviewBeautyFeedbackManager", "onCloseFeedbackPage: hide feedback");
                    this.f67219b.f67218a.f67217a.getClass();
                    int r102 = b.f67220a;
                    throw null;
                }
            }

            public C1107a(a r100) {
                this.f67218a = r100;
            }

            @Override // com.bytedance.ies.web.jsbridge2.f.b
            public final f<Object, Object> a() {
                return new C1108a(this);
            }
        }

        public a(PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2 r100) {
            this.f67217a = r100;
        }

        @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
        public final void onJSBridgeCreated(c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            r100.registerMethod("closeFeedbackPage", new C1107a(this));
        }
    }

    public PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2(b r100) {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return new a(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
