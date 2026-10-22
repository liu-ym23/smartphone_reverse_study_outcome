package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.alipay.sdk.m.s.a;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008c\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0002\u0010\u0019J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u00101\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eHÆ\u0003J&\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010HÆ\u0003J\t\u00103\u001a\u00020\u0017HÆ\u0003J\t\u00104\u001a\u00020\u0011HÆ\u0003J¡\u0001\u00105\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0011HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\b\u0010<\u001a\u00020\bH\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R7\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010'R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006="}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainFetchParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "contactInfos", "", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "processInfo", "Lorg/json/JSONObject;", "merchantId", "", "appId", a.f25767y, "selectMetaInfos", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "Lkotlin/collections/ArrayList;", "finishTask", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "fetchCount", "", "isExpOpt", "([Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;JZ)V", "getAppId", "()Ljava/lang/String;", "getContactInfos", "()[Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "[Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "getExtInfo", "()Lorg/json/JSONObject;", "getFetchCount", "()J", "getFinishTask", "()Lkotlin/jvm/functions/Function1;", "setFinishTask", "(Lkotlin/jvm/functions/Function1;)V", "()Z", "getMerchantId", "getProcessInfo", "getSelectMetaInfos", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "([Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;JZ)Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainFetchParams;", "equals", "other", "", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainFetchParams implements CJPayObject {
    private final String appId;
    private final CJPayRetainContactInfo[] contactInfos;
    private final JSONObject extInfo;
    private final long fetchCount;
    private Function1<? super Boolean, Unit> finishTask;
    private final boolean isExpOpt;
    private final String merchantId;
    private final JSONObject processInfo;
    private final ArrayList<AssetInfoBean.AssetMetaInfoBean> selectMetaInfos;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayRetainFetchParams copy$default(CJPayRetainFetchParams r110, CJPayRetainContactInfo[] r111, JSONObject r112, String r113, String r114, JSONObject r115, ArrayList r116, Function1 r117, long r118, boolean r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        CJPayRetainContactInfo[] r100 = r110.contactInfos;
    L7:
        if ((r211 & 2) == 0) goto L9;
        JSONObject r101 = r110.processInfo;
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r102 = r110.merchantId;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r103 = r110.appId;
    L19:
        if ((r211 & 16) == 0) goto L21;
        JSONObject r104 = r110.extInfo;
    L23:
        if ((r211 & 32) == 0) goto L25;
        ArrayList r105 = r110.selectMetaInfos;
    L27:
        if ((r211 & 64) == 0) goto L29;
        Function1 r106 = r110.finishTask;
    L31:
        if ((r211 & 128) == 0) goto L33;
        long r107 = r110.fetchCount;
    L35:
        if ((r211 & 256) == 0) goto L37;
        boolean r108 = r110.isExpOpt;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final CJPayRetainContactInfo[] component1() {
        return this.contactInfos;
    }

    public final JSONObject component2() {
        return this.processInfo;
    }

    public final String component3() {
        return this.merchantId;
    }

    public final String component4() {
        return this.appId;
    }

    public final JSONObject component5() {
        return this.extInfo;
    }

    public final ArrayList<AssetInfoBean.AssetMetaInfoBean> component6() {
        return this.selectMetaInfos;
    }

    public final Function1<Boolean, Unit> component7() {
        return this.finishTask;
    }

    public final long component8() {
        return this.fetchCount;
    }

    public final boolean component9() {
        return this.isExpOpt;
    }

    public final CJPayRetainFetchParams copy(CJPayRetainContactInfo[] r110, JSONObject r111, String r112, String r113, JSONObject r114, ArrayList<AssetInfoBean.AssetMetaInfoBean> r115, Function1<? super Boolean, Unit> r116, long r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "contactInfos");
        Intrinsics.checkNotNullParameter(r111, "processInfo");
        Intrinsics.checkNotNullParameter(r112, "merchantId");
        Intrinsics.checkNotNullParameter(r113, "appId");
        return new CJPayRetainFetchParams(r110, r111, r112, r113, r114, r115, r116, r210, r211);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainFetchParams) == true) goto L8;
        return false;
    L8:
        CJPayRetainFetchParams r101 = (CJPayRetainFetchParams) r100;
        if (Intrinsics.areEqual(this.contactInfos, r101.contactInfos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.processInfo, r101.processInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.merchantId, r101.merchantId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extInfo, r101.extInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectMetaInfos, r101.selectMetaInfos) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.finishTask, r101.finishTask) == true) goto L30;
        return false;
    L30:
        if (this.fetchCount == r101.fetchCount) goto L33;
        return false;
    L33:
        if (this.isExpOpt == r101.isExpOpt) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((Arrays.hashCode(this.contactInfos) * 31) + this.processInfo.hashCode()) * 31) + this.merchantId.hashCode()) * 31) + this.appId.hashCode()) * 31;
        JSONObject r101 = this.extInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r105 = this.selectMetaInfos;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function1<? super Boolean, Unit> r108 = this.finishTask;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        long r109 = this.fetchCount;
        int r110 = (((r107 + r102) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        if (this.isExpOpt == false) goto L17;
        int r111 = 1231;
    L19:
        return r110 + r111;
    L17:
        r111 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CJPayRetainFetchParams(contactInfos=" + Arrays.toString(this.contactInfos) + ", processInfo=" + this.processInfo + ", merchantId='" + this.merchantId + "', appId='" + this.appId + "', extInfo=" + this.extInfo + ", selectMetaInfos=" + this.selectMetaInfos + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final CJPayRetainContactInfo[] getContactInfos() {
        return this.contactInfos;
    }

    public final JSONObject getExtInfo() {
        return this.extInfo;
    }

    public final long getFetchCount() {
        return this.fetchCount;
    }

    public final Function1<Boolean, Unit> getFinishTask() {
        return this.finishTask;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final JSONObject getProcessInfo() {
        return this.processInfo;
    }

    public final ArrayList<AssetInfoBean.AssetMetaInfoBean> getSelectMetaInfos() {
        return this.selectMetaInfos;
    }

    public final boolean isExpOpt() {
        return this.isExpOpt;
    }

    public final void setFinishTask(Function1<? super Boolean, Unit> r100) {
        this.finishTask = r100;
    }

    public CJPayRetainFetchParams(CJPayRetainContactInfo[] r100, JSONObject r101, String r102, String r103, JSONObject r104, ArrayList<AssetInfoBean.AssetMetaInfoBean> r105, Function1<? super Boolean, Unit> r106, long r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "contactInfos");
        Intrinsics.checkNotNullParameter(r101, "processInfo");
        Intrinsics.checkNotNullParameter(r102, "merchantId");
        Intrinsics.checkNotNullParameter(r103, "appId");
        this.contactInfos = r100;
        this.processInfo = r101;
        this.merchantId = r102;
        this.appId = r103;
        this.extInfo = r104;
        this.selectMetaInfos = r105;
        this.finishTask = r106;
        this.fetchCount = r107;
        this.isExpOpt = r110;
    }

    public /* synthetic */ CJPayRetainFetchParams(CJPayRetainContactInfo[] r110, JSONObject r111, String r112, String r113, JSONObject r114, ArrayList r115, Function1 r210, long r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 16) == 0) goto L5;
        JSONObject r100 = null;
    L7:
        if ((r213 & 32) == 0) goto L9;
        ArrayList r101 = null;
    L11:
        if ((r213 & 64) == 0) goto L13;
        Function1 r102 = null;
    L14:
        this(r110, r111, r112, r113, r100, r101, r102, r211, r212);
        return;
    L13:
        r102 = r210;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
