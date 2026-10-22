package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJCommonRecommendInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "recommend_desc", "", "recommend_ext", "Lcom/android/ttcjpaysdk/base/ui/data/CJCommonRecommendInfo$CJCommonRecommendInfoExt;", a.KEY_RECOMMEND_TYPE, "getRecommendDesc", "isRecommendChecked", "", "isShowPreSign", "isShowRecommendVerify", "CJCommonRecommendInfoExt", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJCommonRecommendInfo implements CJPayObject, Serializable {
    public static final Companion Companion = null;
    public static final String RECOMMEND_TYPE_BYTEPAY_PRIORITY = "bytepay_priority";
    public static final String RECOMMEND_TYPE_PREFER_VERIFY = "prefer_verify";
    public String recommend_desc;
    public CJCommonRecommendInfoExt recommend_ext;
    public String recommend_type;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJCommonRecommendInfo$CJCommonRecommendInfoExt;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "choose_status", "", "desc_text", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJCommonRecommendInfoExt implements CJPayObject, Serializable {
        public String choose_status;
        public String desc_text;

        public CJCommonRecommendInfoExt() {
            this.choose_status = "";
            this.desc_text = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJCommonRecommendInfo$Companion;", "", "()V", "RECOMMEND_TYPE_BYTEPAY_PRIORITY", "", "RECOMMEND_TYPE_PREFER_VERIFY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final String getRecommendDesc() {
        String r100 = this.recommend_ext.desc_text;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean isRecommendChecked() {
        return Intrinsics.areEqual(this.recommend_ext.choose_status, "1");
    }

    public final boolean isShowPreSign() {
        return Intrinsics.areEqual(this.recommend_type, RECOMMEND_TYPE_BYTEPAY_PRIORITY);
    }

    public final boolean isShowRecommendVerify() {
        return Intrinsics.areEqual(this.recommend_type, RECOMMEND_TYPE_PREFER_VERIFY);
    }

    public CJCommonRecommendInfo() {
        this.recommend_type = "";
        this.recommend_desc = "";
        this.recommend_ext = new CJCommonRecommendInfoExt();
    }
}
