package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.android.ttcjpaysdk.base.service.bean.DyPayProcessConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J5\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IDyPayService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "asyncPreloadPwdLayout", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lorg/json/JSONObject;", "getLastAddConfig", "Lcom/android/ttcjpaysdk/base/service/bean/DyPayProcessConfig;", "start", "config", "builder", "Lkotlin/Function1;", "Lcom/android/ttcjpaysdk/base/service/IDyPayService$DyPayListenerBuilder;", "Lkotlin/ExtensionFunctionType;", "updateDyPayConfig", "DyPayListenerBuilder", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDyPayService extends ICJPayService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void asyncPreloadPwdLayout$default(IDyPayService r100, Context r101, JSONObject r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = new JSONObject();
        L6:
            r100.asyncPreloadPwdLayout(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncPreloadPwdLayout");
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010N\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\"0\u0004J\u0014\u0010O\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J@\u0010P\u001a\u00020\u000528\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u0018J\u0014\u0010Q\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J@\u0010R\u001a\u00020\u000528\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u0018J)\u0010S\u001a\u00020\u00052!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\u000eJL\u0010T\u001a\u00020\u00052D\u0010\u0012\u001a@\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00050\u0018J\u0014\u0010U\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J)\u0010V\u001a\u00020\u00052!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00050\u000eJL\u0010W\u001a\u00020\u00052D\u0010\u0012\u001a@\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u00050\u0018J\u0014\u0010X\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010Y\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004JB\u0010Z\u001a\u00020\u00052:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(J\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u00050\u0018Jh\u0010[\u001a\u00020\u00052`\u0010\u0012\u001a\\\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(<\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u00050:R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RN\u0010\u0017\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RZ\u0010!\u001aB\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR7\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016RN\u00101\u001a6\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 RZ\u00105\u001aB\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 Rv\u00109\u001a^\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(<\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u0005\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR\"\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tRP\u0010I\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(J\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001e\"\u0004\bM\u0010 ¨\u0006\\"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IDyPayService$DyPayListenerBuilder;", "", "()V", "beforeResultShowListener", "Lkotlin/Function0;", "", "getBeforeResultShowListener", "()Lkotlin/jvm/functions/Function0;", "setBeforeResultShowListener", "(Lkotlin/jvm/functions/Function0;)V", "bindCardPayTriggerListener", "getBindCardPayTriggerListener", "setBindCardPayTriggerListener", "buttonInfoActionListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "action", "getButtonInfoActionListener", "()Lkotlin/jvm/functions/Function1;", "setButtonInfoActionListener", "(Lkotlin/jvm/functions/Function1;)V", "cardSignListener", "Lkotlin/Function2;", "", "isSuccess", "Lorg/json/JSONObject;", "params", "getCardSignListener", "()Lkotlin/jvm/functions/Function2;", "setCardSignListener", "(Lkotlin/jvm/functions/Function2;)V", "creditPayListener", "", "code", "", "callBackInfo", "getCreditPayListener", "setCreditPayListener", "getUnknownFragmentHeightListener", "getGetUnknownFragmentHeightListener", "setGetUnknownFragmentHeightListener", "incomePayListener", "getIncomePayListener", "setIncomePayListener", "jumpLynxListener", "getJumpLynxListener", "setJumpLynxListener", "payNewCardListener", "result", "getPayNewCardListener", "setPayNewCardListener", "payResultListener", "data", "getPayResultListener", "setPayResultListener", "performPageHeightListener", "Lkotlin/Function4;", "unknownHeight", "isRemove", "isDoLayerAnimation", "isAdjustHeightSilently", "getPerformPageHeightListener", "()Lkotlin/jvm/functions/Function4;", "setPerformPageHeightListener", "(Lkotlin/jvm/functions/Function4;)V", "refreshHomePage", "getRefreshHomePage", "setRefreshHomePage", "startPayAgainListener", "getStartPayAgainListener", "setStartPayAgainListener", "verifyListener", "responseBean", "verifyParams", "getVerifyListener", "setVerifyListener", "getUnknownFragmentHeight", "onBeforeResultShow", "onBindCardFailed", "onBindCardPayTrigger", "onCardSignRequestEnd", "onClickButtonInfoAction", "onCreditPayActivate", "onIncomePayEnd", "onJumpLynxAction", "onPayResult", "onRefreshHomePage", "onStartPayAgain", "onVerifyFailed", "performPageHeightAnimation", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DyPayListenerBuilder {
        private Function0<Unit> beforeResultShowListener;
        private Function0<Unit> bindCardPayTriggerListener;
        private Function1<? super String, Unit> buttonInfoActionListener;
        private Function2<? super Boolean, ? super JSONObject, Unit> cardSignListener;
        private Function2<? super Integer, ? super Map<String, String>, Unit> creditPayListener;
        private Function0<Integer> getUnknownFragmentHeightListener;
        private Function0<Unit> incomePayListener;
        private Function1<? super Integer, Unit> jumpLynxListener;
        private Function2<? super String, ? super JSONObject, Unit> payNewCardListener;
        private Function2<? super Integer, ? super Map<String, String>, Unit> payResultListener;
        private Function4<? super Integer, ? super Boolean, ? super Boolean, ? super Boolean, Unit> performPageHeightListener;
        private Function0<Unit> refreshHomePage;
        private Function0<Unit> startPayAgainListener;
        private Function2<? super JSONObject, ? super JSONObject, Unit> verifyListener;

        public DyPayListenerBuilder() {
        }

        public final Function0<Unit> getBeforeResultShowListener() {
            return this.beforeResultShowListener;
        }

        public final Function0<Unit> getBindCardPayTriggerListener() {
            return this.bindCardPayTriggerListener;
        }

        public final Function1<String, Unit> getButtonInfoActionListener() {
            return this.buttonInfoActionListener;
        }

        public final Function2<Boolean, JSONObject, Unit> getCardSignListener() {
            return this.cardSignListener;
        }

        public final Function2<Integer, Map<String, String>, Unit> getCreditPayListener() {
            return this.creditPayListener;
        }

        public final Function0<Integer> getGetUnknownFragmentHeightListener() {
            return this.getUnknownFragmentHeightListener;
        }

        public final Function0<Unit> getIncomePayListener() {
            return this.incomePayListener;
        }

        public final Function1<Integer, Unit> getJumpLynxListener() {
            return this.jumpLynxListener;
        }

        public final Function2<String, JSONObject, Unit> getPayNewCardListener() {
            return this.payNewCardListener;
        }

        public final Function2<Integer, Map<String, String>, Unit> getPayResultListener() {
            return this.payResultListener;
        }

        public final Function4<Integer, Boolean, Boolean, Boolean, Unit> getPerformPageHeightListener() {
            return this.performPageHeightListener;
        }

        public final Function0<Unit> getRefreshHomePage() {
            return this.refreshHomePage;
        }

        public final Function0<Unit> getStartPayAgainListener() {
            return this.startPayAgainListener;
        }

        public final Function2<JSONObject, JSONObject, Unit> getVerifyListener() {
            return this.verifyListener;
        }

        public final void getUnknownFragmentHeight(Function0<Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.getUnknownFragmentHeightListener = r100;
        }

        public final void onBeforeResultShow(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.beforeResultShowListener = r100;
        }

        public final void onBindCardFailed(Function2<? super String, ? super JSONObject, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.payNewCardListener = r100;
        }

        public final void onBindCardPayTrigger(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.bindCardPayTriggerListener = r100;
        }

        public final void onCardSignRequestEnd(Function2<? super Boolean, ? super JSONObject, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.cardSignListener = r100;
        }

        public final void onClickButtonInfoAction(Function1<? super String, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.buttonInfoActionListener = r100;
        }

        public final void onCreditPayActivate(Function2<? super Integer, ? super Map<String, String>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.creditPayListener = r100;
        }

        public final void onIncomePayEnd(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.incomePayListener = r100;
        }

        public final void onJumpLynxAction(Function1<? super Integer, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.jumpLynxListener = r100;
        }

        public final void onPayResult(Function2<? super Integer, ? super Map<String, String>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.payResultListener = r100;
        }

        public final void onRefreshHomePage(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.refreshHomePage = r100;
        }

        public final void onStartPayAgain(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.startPayAgainListener = r100;
        }

        public final void onVerifyFailed(Function2<? super JSONObject, ? super JSONObject, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.verifyListener = r100;
        }

        public final void performPageHeightAnimation(Function4<? super Integer, ? super Boolean, ? super Boolean, ? super Boolean, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.performPageHeightListener = r100;
        }

        public final void setBeforeResultShowListener(Function0<Unit> r100) {
            this.beforeResultShowListener = r100;
        }

        public final void setBindCardPayTriggerListener(Function0<Unit> r100) {
            this.bindCardPayTriggerListener = r100;
        }

        public final void setButtonInfoActionListener(Function1<? super String, Unit> r100) {
            this.buttonInfoActionListener = r100;
        }

        public final void setCardSignListener(Function2<? super Boolean, ? super JSONObject, Unit> r100) {
            this.cardSignListener = r100;
        }

        public final void setCreditPayListener(Function2<? super Integer, ? super Map<String, String>, Unit> r100) {
            this.creditPayListener = r100;
        }

        public final void setGetUnknownFragmentHeightListener(Function0<Integer> r100) {
            this.getUnknownFragmentHeightListener = r100;
        }

        public final void setIncomePayListener(Function0<Unit> r100) {
            this.incomePayListener = r100;
        }

        public final void setJumpLynxListener(Function1<? super Integer, Unit> r100) {
            this.jumpLynxListener = r100;
        }

        public final void setPayNewCardListener(Function2<? super String, ? super JSONObject, Unit> r100) {
            this.payNewCardListener = r100;
        }

        public final void setPayResultListener(Function2<? super Integer, ? super Map<String, String>, Unit> r100) {
            this.payResultListener = r100;
        }

        public final void setPerformPageHeightListener(Function4<? super Integer, ? super Boolean, ? super Boolean, ? super Boolean, Unit> r100) {
            this.performPageHeightListener = r100;
        }

        public final void setRefreshHomePage(Function0<Unit> r100) {
            this.refreshHomePage = r100;
        }

        public final void setStartPayAgainListener(Function0<Unit> r100) {
            this.startPayAgainListener = r100;
        }

        public final void setVerifyListener(Function2<? super JSONObject, ? super JSONObject, Unit> r100) {
            this.verifyListener = r100;
        }
    }

    void asyncPreloadPwdLayout(Context r100, JSONObject r101);

    DyPayProcessConfig getLastAddConfig();

    void start(Context r100, DyPayProcessConfig r101, Function1<? super DyPayListenerBuilder, Unit> r102);

    void updateDyPayConfig(DyPayProcessConfig r100);
}
