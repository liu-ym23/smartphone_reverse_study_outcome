package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.state;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", ErrorCode.CLOSED, "CONFIRMED", "CONFIRMING", "ERROR", "INFO_LOADED", "INITIAL", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$CLOSED;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$CONFIRMED;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$CONFIRMING;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$ERROR;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$INFO_LOADED;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$INITIAL;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJDepositState {
    private final String name;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$CLOSED;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CLOSED extends CJDepositState {
        public static final CLOSED INSTANCE = null;

        static {
            INSTANCE = new CLOSED();
        }

        private CLOSED() {
            super(PTYSocketStateCallback.CLOSED, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$CONFIRMED;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CONFIRMED extends CJDepositState {
        public static final CONFIRMED INSTANCE = null;

        static {
            INSTANCE = new CONFIRMED();
        }

        private CONFIRMED() {
            super("confirmed", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$CONFIRMING;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CONFIRMING extends CJDepositState {
        public static final CONFIRMING INSTANCE = null;

        static {
            INSTANCE = new CONFIRMING();
        }

        private CONFIRMING() {
            super("confirming", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$ERROR;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ERROR extends CJDepositState {
        public static final ERROR INSTANCE = null;

        static {
            INSTANCE = new ERROR();
        }

        private ERROR() {
            super("error", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$INFO_LOADED;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class INFO_LOADED extends CJDepositState {
        public static final INFO_LOADED INSTANCE = null;

        static {
            INSTANCE = new INFO_LOADED();
        }

        private INFO_LOADED() {
            super("infoLoaded", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState$INITIAL;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class INITIAL extends CJDepositState {
        public static final INITIAL INSTANCE = null;

        static {
            INSTANCE = new INITIAL();
        }

        private INITIAL() {
            super("initial", null);
        }
    }

    public /* synthetic */ CJDepositState(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final String getName() {
        return this.name;
    }

    private CJDepositState(String r100) {
        this.name = r100;
    }
}
