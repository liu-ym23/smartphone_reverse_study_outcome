package com.android.ttcjpaysdk.thirdparty.verify.params;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyTokenPayParams;", "", "getToken", "", "getTokenDegradePwdParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyTokenPayParams$TokenDegradePwdParams;", "TokenDegradePwdParams", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyTokenPayParams {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyTokenPayParams$TokenDegradePwdParams;", "", "()V", "extraTask", "Lkotlin/Function0;", "", "getExtraTask", "()Lkotlin/jvm/functions/Function0;", "setExtraTask", "(Lkotlin/jvm/functions/Function0;)V", "hasMask", "", "getHasMask", "()Z", "setHasMask", "(Z)V", "inAnimStyle", "", "getInAnimStyle", "()I", "setInAnimStyle", "(I)V", "outAnimStyle", "getOutAnimStyle", "setOutAnimStyle", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TokenDegradePwdParams {
        private Function0<Unit> extraTask;
        private boolean hasMask;
        private int inAnimStyle;
        private int outAnimStyle;

        public TokenDegradePwdParams() {
            this.inAnimStyle = 2;
            this.outAnimStyle = 2;
        }

        public final Function0<Unit> getExtraTask() {
            return this.extraTask;
        }

        public final boolean getHasMask() {
            return this.hasMask;
        }

        public final int getInAnimStyle() {
            return this.inAnimStyle;
        }

        public final int getOutAnimStyle() {
            return this.outAnimStyle;
        }

        public final void setExtraTask(Function0<Unit> r100) {
            this.extraTask = r100;
        }

        public final void setHasMask(boolean r100) {
            this.hasMask = r100;
        }

        public final void setInAnimStyle(int r100) {
            this.inAnimStyle = r100;
        }

        public final void setOutAnimStyle(int r100) {
            this.outAnimStyle = r100;
        }
    }

    String getToken();

    TokenDegradePwdParams getTokenDegradePwdParams();
}
