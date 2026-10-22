package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4$b;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/utils/q4$b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class CommonTrayView$comboAnim$2 extends Lambda implements Function0<q4.b> {
    final /* synthetic */ CommonTrayView this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.CommonTrayView$comboAnim$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ CommonTrayView$comboAnim$2 this$0;

        public AnonymousClass1(CommonTrayView$comboAnim$2 r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(q4 r100) {
            Intrinsics.checkNotNullParameter(r100, "$receiver");
            r100.d(new C22191(this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public CommonTrayView$comboAnim$2(CommonTrayView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final q4.b invoke() {
        return u4.c(new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ q4.b invoke() {
        return invoke();
    }
}
