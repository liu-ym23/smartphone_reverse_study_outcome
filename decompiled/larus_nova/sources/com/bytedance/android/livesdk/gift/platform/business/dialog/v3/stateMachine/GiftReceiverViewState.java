package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.u0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r27.a;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverViewState$Mode;", "mode$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getMode", "()Lcom/bytedance/android/anya/r0;", "mode", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/NewReceiverPanelStatus;", "showNewReceiverPanel$delegate", "getShowNewReceiverPanel", "showNewReceiverPanel", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "receiver$delegate", "getReceiver", SocialConstants.PARAM_RECEIVER, "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverStateMachineState;", "receiverState$delegate", "getReceiverState", "()Lcom/bytedance/android/anya/u0;", "receiverState", "<init>", "()V", "Mode", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftReceiverViewState extends MVIState<GiftReceiverViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty mode$delegate;
    private final ReadOnlyProperty receiver$delegate;
    private final ReadOnlyProperty receiverState$delegate;
    private final ReadOnlyProperty showNewReceiverPanel$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverViewState$Mode;", "", "(Ljava/lang/String;I)V", "IDLE", "Receiver", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode IDLE = null;
        public static final Mode Receiver = null;

        static {
            Mode r100 = new Mode("IDLE", 0);
            IDLE = r100;
            Mode r101 = new Mode("Receiver", 1);
            Receiver = r101;
            $VALUES = new Mode[]{r100, r101};
        }

        public static Mode valueOf(String r100) {
            return (Mode) a.a(Mode.class, r100);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        private Mode(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, "mode", "getMode()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, "showNewReceiverPanel", "getShowNewReceiverPanel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, SocialConstants.PARAM_RECEIVER, "getReceiver()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, "receiverState", "getReceiverState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final r0<GiftReceiverViewState, Mode> getMode() {
        return (r0) this.mode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftReceiverViewState, IBaseUser> getReceiver() {
        return (r0) this.receiver$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final u0<GiftReceiverViewState, GiftReceiverStateMachineState> getReceiverState() {
        return (u0) this.receiverState$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftReceiverViewState, NewReceiverPanelStatus> getShowNewReceiverPanel() {
        return (r0) this.showNewReceiverPanel$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public GiftReceiverViewState() {
        Mode r100 = Mode.IDLE;
        Function1<c<STATE, ?>, Unit> r101 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r102 = this.propertyAddedCallback;
        r r103 = new r(r100, r101, r102);
        KProperty[] r104 = $$delegatedProperties;
        r103.f41672a = r104[0].getName();
        r102.invoke(r103);
        this.mode$delegate = r103;
        NewReceiverPanelStatus r105 = NewReceiverPanelStatus.Idle;
        Function1<c<STATE, ?>, Unit> r106 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r107 = this.propertyAddedCallback;
        r r108 = new r(r105, r106, r107);
        r108.f41672a = r104[1].getName();
        r107.invoke(r108);
        this.showNewReceiverPanel$delegate = r108;
        vh7.c r109 = f.c(IBaseUser.class);
        Function1<c<STATE, ?>, Unit> r110 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r111 = this.propertyAddedCallback;
        r r112 = new r(r109, r110, r111);
        r112.f41672a = r104[2].getName();
        r111.invoke(r112);
        this.receiver$delegate = r112;
        Function1<c<STATE, ?>, Unit> r113 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r114 = this.propertyAddedCallback;
        SubStatePropertyImpl r115 = new SubStatePropertyImpl(GiftReceiverStateMachineState.class, null, r113, r114);
        r115.f41672a = r104[3].getName();
        r114.invoke(r115);
        this.receiverState$delegate = r115;
    }
}
