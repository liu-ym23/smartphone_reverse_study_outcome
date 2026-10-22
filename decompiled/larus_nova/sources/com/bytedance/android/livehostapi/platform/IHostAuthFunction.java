package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import android.content.Context;
import androidx.autofill.HintConstants;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J*\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b0\u0005H&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0017J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H&J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H&J\"\u0010\u0015\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u000b0\u0005H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0012H&J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0019\u001a\u00020\u0006H&J\u0016\u0010\u001a\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u001b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001c\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J:\u0010!\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2\u0006\u0010&\u001a\u00020'H&J \u0010(\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010(\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0017J&\u0010)\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H&J&\u0010+\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H&J.\u0010,\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H&¨\u0006.À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/IHostAuthFunction;", "", "bindDouyinAccountByPhoneNumber", "", "resultCallback", "Lcom/bytedance/android/livesdkapi/service/ILiveCallback;", "", "createDouyinAccountByPhoneNumber", "doDouyinAuth", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lkotlin/Pair;", "", "doHostBindPhoneNumber", "doHostLoginAndAuth", "Lcom/bytedance/android/livehostapi/platform/UserSelection;", "doPhoneNumberAuth", "finishAuth", "Lcom/bytedance/android/livehostapi/platform/TokenInfo;", "getCurrentAccountPhoneNumber", "", "getLocalPhoneNumber", "getTokenInfo", "isCurrentAccountWithDouyinAuth", "isCurrentAccountWithLegalPhoneNumber", "isHostLogin", "isLocalPhoneNumberLegal", "isPhoneNumberUsedInDouyin", "isUserAgreePhoneNumberUsageForDouyin", "onAuthRoutineEnd", "tokenInfo", LynxError.LYNX_THROWABLE, "", "onAuthRoutineStart", "activity", "Landroid/app/Activity;", "extra", "", "handler", "Lcom/bytedance/android/livehostapi/platform/IAuthRoutineHandler;", "resolveBindConflict", "showDouyinAccountAccessDialog", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "showDouyinAccountCreateDialog", "showPhoneNumberAuthDialog", Constants.OperatorKey.KEY_CARRIER, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostAuthFunction {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IHostAuthFunction$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$doHostBindPhoneNumber(IHostAuthFunction r100, ILiveCallback r101) {
            Intrinsics.checkNotNullParameter(r101, "resultCallback");
            r101.onSuccess(Boolean.TRUE);
        }

        @Deprecated(message = "建议实现doHostBindPhoneNumber", replaceWith = @ReplaceWith(expression = "doHostBindPhoneNumber", imports = {}))
        public static void $default$doPhoneNumberAuth(IHostAuthFunction r100, ILiveCallback r101) {
            Intrinsics.checkNotNullParameter(r101, "resultCallback");
            r101.onSuccess(Boolean.TRUE);
        }

        @Deprecated(message = "建议实现带context的resolveBindConflict", replaceWith = @ReplaceWith(expression = "resolveBindConflict(context, callback)", imports = {}))
        public static void $default$resolveBindConflict(IHostAuthFunction r100, ILiveCallback r101) {
            Intrinsics.checkNotNullParameter(r101, "resultCallback");
            r101.onSuccess(Boolean.TRUE);
        }

        public static /* synthetic */ void access$doHostBindPhoneNumber$jd(IHostAuthFunction r100, ILiveCallback r101) {
            $default$doHostBindPhoneNumber(r100, r101);
        }

        public static /* synthetic */ void access$doPhoneNumberAuth$jd(IHostAuthFunction r100, ILiveCallback r101) {
            $default$doPhoneNumberAuth(r100, r101);
        }

        public static /* synthetic */ void access$resolveBindConflict$jd(IHostAuthFunction r100, ILiveCallback r101) {
            $default$resolveBindConflict(r100, r101);
        }

        public static void $default$resolveBindConflict(IHostAuthFunction r100, Context r101, ILiveCallback r102) {
            Intrinsics.checkNotNullParameter(r102, "resultCallback");
            r102.onSuccess(Boolean.TRUE);
        }

        public static /* synthetic */ void access$resolveBindConflict$jd(IHostAuthFunction r100, Context r101, ILiveCallback r102) {
            $default$resolveBindConflict(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void doHostBindPhoneNumber(IHostAuthFunction r100, ILiveCallback<Boolean> r101) {
            CC.access$doHostBindPhoneNumber$jd(r100, r101);
        }

        @Deprecated(message = "建议实现doHostBindPhoneNumber", replaceWith = @ReplaceWith(expression = "doHostBindPhoneNumber", imports = {}))
        public static void doPhoneNumberAuth(IHostAuthFunction r100, ILiveCallback<Boolean> r101) {
            CC.access$doPhoneNumberAuth$jd(r100, r101);
        }

        @Deprecated(message = "建议实现带context的resolveBindConflict", replaceWith = @ReplaceWith(expression = "resolveBindConflict(context, callback)", imports = {}))
        public static void resolveBindConflict(IHostAuthFunction r100, ILiveCallback<Boolean> r101) {
            CC.access$resolveBindConflict$jd(r100, r101);
        }

        public static void resolveBindConflict(IHostAuthFunction r100, Context r101, ILiveCallback<Boolean> r102) {
            CC.access$resolveBindConflict$jd(r100, r101, r102);
        }
    }

    void bindDouyinAccountByPhoneNumber(ILiveCallback<Boolean> r100);

    void createDouyinAccountByPhoneNumber(ILiveCallback<Boolean> r100);

    void doDouyinAuth(Context r100, ILiveCallback<Pair<Boolean, Integer>> r101);

    void doHostBindPhoneNumber(ILiveCallback<Boolean> r100);

    void doHostLoginAndAuth(Context r100, ILiveCallback<UserSelection> r101);

    @Deprecated(message = "建议实现doHostBindPhoneNumber", replaceWith = @ReplaceWith(expression = "doHostBindPhoneNumber", imports = {}))
    void doPhoneNumberAuth(ILiveCallback<Boolean> r100);

    void finishAuth(ILiveCallback<TokenInfo> r100);

    void getCurrentAccountPhoneNumber(ILiveCallback<String> r100);

    void getLocalPhoneNumber(ILiveCallback<Pair<String, String>> r100);

    TokenInfo getTokenInfo();

    void isCurrentAccountWithDouyinAuth(ILiveCallback<Boolean> r100);

    void isCurrentAccountWithLegalPhoneNumber(ILiveCallback<Boolean> r100);

    boolean isHostLogin();

    void isLocalPhoneNumberLegal(ILiveCallback<Boolean> r100);

    void isPhoneNumberUsedInDouyin(ILiveCallback<Boolean> r100);

    void isUserAgreePhoneNumberUsageForDouyin(ILiveCallback<Boolean> r100);

    void onAuthRoutineEnd(TokenInfo r100, Throwable r101);

    void onAuthRoutineStart(TokenInfo r100, Activity r101, Map<String, String> r102, IAuthRoutineHandler r103);

    void resolveBindConflict(Context r100, ILiveCallback<Boolean> r101);

    @Deprecated(message = "建议实现带context的resolveBindConflict", replaceWith = @ReplaceWith(expression = "resolveBindConflict(context, callback)", imports = {}))
    void resolveBindConflict(ILiveCallback<Boolean> r100);

    void showDouyinAccountAccessDialog(Context r100, String r101, ILiveCallback<UserSelection> r102);

    void showDouyinAccountCreateDialog(Context r100, String r101, ILiveCallback<UserSelection> r102);

    void showPhoneNumberAuthDialog(Context r100, String r101, String r102, ILiveCallback<UserSelection> r103);
}
