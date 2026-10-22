package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySignBizConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "confirm_need_check_again_config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySignBizConfig$CJPayConfirmNeedCheckAgainConfig;", "CJPayConfirmNeedCheckAgainConfig", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySignBizConfig implements CJPayObject, Serializable {
    public CJPayConfirmNeedCheckAgainConfig confirm_need_check_again_config;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySignBizConfig$CJPayConfirmNeedCheckAgainConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "alert_contents", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySignBizConfig$CJPayConfirmNeedCheckAgainConfig$CJPayAlertContents;", "merchant_ids", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "CJPayAlertContents", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayConfirmNeedCheckAgainConfig implements CJPayObject, Serializable {
        public CJPayAlertContents alert_contents;
        public ArrayList<String> merchant_ids;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySignBizConfig$CJPayConfirmNeedCheckAgainConfig$CJPayAlertContents;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "content", "", "left_btn", "right_btn", "title", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class CJPayAlertContents implements CJPayObject, Serializable {
            public String content;
            public String left_btn;
            public String right_btn;
            public String title;

            public CJPayAlertContents() {
                this.title = "自动续费服务提醒";
                this.content = "自动续费开通成功商户可按照约定规则自动扣款";
                this.left_btn = "取消";
                this.right_btn = "确认继续，推进后续流程";
            }
        }

        public CJPayConfirmNeedCheckAgainConfig() {
            this.merchant_ids = CollectionsKt.arrayListOf(new String[]{""});
            this.alert_contents = new CJPayAlertContents();
        }
    }

    public CJPaySignBizConfig() {
        this.confirm_need_check_again_config = new CJPayConfirmNeedCheckAgainConfig();
    }
}
