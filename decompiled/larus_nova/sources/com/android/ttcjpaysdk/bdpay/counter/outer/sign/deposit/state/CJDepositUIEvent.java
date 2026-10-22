package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "OnClose", "OnConfirm", "OnRendered", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent$OnClose;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent$OnConfirm;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent$OnRendered;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJDepositUIEvent {
    private final String name;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent$OnClose;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OnClose extends CJDepositUIEvent {
        public static final OnClose INSTANCE = null;

        static {
            INSTANCE = new OnClose();
        }

        private OnClose() {
            super("onClose", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent$OnConfirm;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OnConfirm extends CJDepositUIEvent {
        public static final OnConfirm INSTANCE = null;

        static {
            INSTANCE = new OnConfirm();
        }

        private OnConfirm() {
            super("onConfirm", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent$OnRendered;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OnRendered extends CJDepositUIEvent {
        public static final OnRendered INSTANCE = null;

        static {
            INSTANCE = new OnRendered();
        }

        private OnRendered() {
            super("onRendered", null);
        }
    }

    public /* synthetic */ CJDepositUIEvent(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final String getName() {
        return this.name;
    }

    private CJDepositUIEvent(String r100) {
        this.name = r100;
    }
}
