package com.bytedance.android.live.virtuallive.impl.rtc;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/live/virtuallive/impl/rtc/VirtualLiveLinkManager$mRtcListener$2$1", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/live/virtuallive/impl/rtc/VirtualLiveLinkManager$mRtcListener$2$1;"}, k = 3, mv = {1, 5, 1})
final class VirtualLiveLinkManager$mRtcListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.virtuallive.impl.rtc.VirtualLiveLinkManager$mRtcListener$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ii6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VirtualLiveLinkManager$mRtcListener$2 f102641a;

        public AnonymousClass1(VirtualLiveLinkManager$mRtcListener$2 r100) {
            this.f102641a = r100;
        }

        @Override // ii6.a
        public final void H(ei6.a r100, final int r101, final long r102, final Exception r110) {
            UtilityKotlinExtentionsKt.s(0, false, false, new VirtualLiveLinkManager$mRtcListener$2$1$onError$1(r101, r102, r110), 7);
        }

        @Override // ii6.a
        public final void M(final ei6.a r110, final int r111, final long r112, final Object... r113) {
            Intrinsics.checkNotNullParameter(r113, "params");
            UtilityKotlinExtentionsKt.s(0, false, false, new VirtualLiveLinkManager$mRtcListener$2$1$onInfo$1(this, r111, r112, r113, r110), 7);
        }
    }

    public VirtualLiveLinkManager$mRtcListener$2(a r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnonymousClass1 invoke() {
        return invoke();
    }
}
