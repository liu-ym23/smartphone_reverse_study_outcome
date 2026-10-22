package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayGrowthModelView;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "growthType", "", "contactInfo", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "viewModelList", "Lorg/json/JSONArray;", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;Lorg/json/JSONArray;)V", "getContactInfo", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "getGrowthType", "()Ljava/lang/String;", "getViewModelList", "()Lorg/json/JSONArray;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getJsonObject", "Lorg/json/JSONObject;", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayGrowthModelView implements CJPayObject {
    private final CJPayRetainContactInfo contactInfo;
    private final String growthType;
    private final JSONArray viewModelList;

    public static /* synthetic */ CJPayGrowthModelView copy$default(CJPayGrowthModelView r100, String r101, CJPayRetainContactInfo r102, JSONArray r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.growthType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.contactInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.viewModelList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.growthType;
    }

    public final CJPayRetainContactInfo component2() {
        return this.contactInfo;
    }

    public final JSONArray component3() {
        return this.viewModelList;
    }

    public final CJPayGrowthModelView copy(String r100, CJPayRetainContactInfo r101, JSONArray r102) {
        Intrinsics.checkNotNullParameter(r100, "growthType");
        Intrinsics.checkNotNullParameter(r101, "contactInfo");
        Intrinsics.checkNotNullParameter(r102, "viewModelList");
        return new CJPayGrowthModelView(r100, r101, r102);
    }

    public final JSONObject getJsonObject() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "growth_type", this.growthType);
        KtSafeMethodExtensionKt.safePut(r100, DocCallbackImpl.KEY_CONTACT_INFO, this.contactInfo.toJsonObject());
        KtSafeMethodExtensionKt.safePut(r100, "view_model_list", this.viewModelList);
        return r100;
    }

    public int hashCode() {
        return (((this.growthType.hashCode() * 31) + this.contactInfo.hashCode()) * 31) + this.viewModelList.hashCode();
    }

    public String toString() {
        return "CJPayGrowthModelView(growthType='" + this.growthType + "', contactInfo=" + this.contactInfo + ", viewModelList=" + this.viewModelList + ')';
    }

    public final CJPayRetainContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public final String getGrowthType() {
        return this.growthType;
    }

    public final JSONArray getViewModelList() {
        return this.viewModelList;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(CJPayGrowthModelView.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayGrowthModelView");
        CJPayGrowthModelView r102 = (CJPayGrowthModelView) r100;
        if (Intrinsics.areEqual(this.growthType, r102.growthType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.contactInfo, r102.contactInfo) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.viewModelList, r102.viewModelList) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public CJPayGrowthModelView(String r100, CJPayRetainContactInfo r101, JSONArray r102) {
        Intrinsics.checkNotNullParameter(r100, "growthType");
        Intrinsics.checkNotNullParameter(r101, "contactInfo");
        Intrinsics.checkNotNullParameter(r102, "viewModelList");
        this.growthType = r100;
        this.contactInfo = r101;
        this.viewModelList = r102;
    }
}
