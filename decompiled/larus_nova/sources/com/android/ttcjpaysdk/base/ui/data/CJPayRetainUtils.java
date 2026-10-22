package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogConfig;
import com.android.ttcjpaysdk.base.ui.dialog.nativev2.CJPayKeepDialogNativeV2Utils;
import com.android.ttcjpaysdk.base.utils.CJPaySharedPrefUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J*\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0005R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayRetainUtils;", "", "()V", "retainFromList", "", "", "getRetainFromList", "()Ljava/util/List;", "setRetainFromList", "(Ljava/util/List;)V", "retainTypeList", "getRetainTypeList", "getRetainType", "retainType", "", "isDiffCPMTradeNo", "", "hashedTradeNo", "isDiffTradeNo", "saveRetainInfoToSp", "", "retainFrom", "retainTypeStr", "teaParams", "updateCPMTradeNoInSp", "updateTradeNoInSp", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainUtils {
    public static final CJPayRetainUtils INSTANCE = null;
    private static List<String> retainFromList;
    private static final List<String> retainTypeList = null;

    private CJPayRetainUtils() {
    }

    static {
        INSTANCE = new CJPayRetainUtils();
        retainTypeList = CollectionsKt.listOf(new String[]{CJPayKeepDialogConfig.RETAIN_TYPE_DEFAULT, CJPayKeepDialogNativeV2Utils.RETAIN_TYPE_TEXT, CJPayKeepDialogNativeV2Utils.RETAIN_TYPE_BONUS});
        retainFromList = CollectionsKt.listOf(new String[]{"home_page", "verify_page"});
    }

    public final List<String> getRetainFromList() {
        return retainFromList;
    }

    public final List<String> getRetainTypeList() {
        return retainTypeList;
    }

    public final String getRetainType(int r100) {
        String r101 = (String) CollectionsKt.getOrNull(retainTypeList, r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public final boolean isDiffCPMTradeNo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hashedTradeNo");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r100, CJPaySharedPrefUtils.getStr(CJPayConstant.CJ_PAY_SP_KEY_CPM_KEEP_DIALOG_SHOWED_WITH_TRADE_NO, "")) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean isDiffTradeNo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hashedTradeNo");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r100, CJPaySharedPrefUtils.getStr(CJPayConstant.CJ_PAY_SP_KEY_KEEP_DIALOG_SHOWED_WITH_TRADE_NO, "")) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public final void setRetainFromList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        retainFromList = r100;
    }

    public final void updateCPMTradeNoInSp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hashedTradeNo");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        CJPaySharedPrefUtils.singlePutStr(CJPayConstant.CJ_PAY_SP_KEY_CPM_KEEP_DIALOG_SHOWED_WITH_TRADE_NO, r100);
        return;
    }

    public final void updateTradeNoInSp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hashedTradeNo");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        CJPaySharedPrefUtils.singlePutStr(CJPayConstant.CJ_PAY_SP_KEY_KEEP_DIALOG_SHOWED_WITH_TRADE_NO, r100);
        return;
    }

    public final void saveRetainInfoToSp(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "retainFrom");
        Intrinsics.checkNotNullParameter(r102, "retainTypeStr");
        Intrinsics.checkNotNullParameter(r103, "teaParams");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r100);
        JSONObject r104 = CJPayJsonParser.toJsonObject(new RetainInfoSp(r100, r102, r101, r103));
        if (r104 == null) goto L9;
        String r105 = r104.toString();
        if (r105 == null) goto L9;
    L10:
        CJPaySharedPrefUtils.singlePutStr(CJPayConstant.CJ_PAY_SP_KEY_KEEP_DIALOG_RETAIN_INFO_SP, r105);
        return;
    L9:
        r105 = "";
        goto L10
    }

    public static /* synthetic */ void saveRetainInfoToSp$default(CJPayRetainUtils r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = "";
    L5:
        r100.saveRetainInfoToSp(r101, r102, r103, r104);
    }
}
