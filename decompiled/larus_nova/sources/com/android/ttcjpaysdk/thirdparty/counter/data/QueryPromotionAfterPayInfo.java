package com.android.ttcjpaysdk.thirdparty.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.ResultPageInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/data/QueryPromotionAfterPayInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "benefit_info", "", "code", "dynamic_components", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/ResultPageInfo$DynamicComponent;", "Lkotlin/collections/ArrayList;", "exts", "Lorg/json/JSONObject;", "msg", "ret_status", "Companion", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QueryPromotionAfterPayInfo implements CJPayObject {
    public static final Companion Companion = null;
    public static final String QUERY_CODE = "PP100066";
    public static final String SUCCESS_CODE = "PP000000";
    public static final String SUCCESS_STATUS = "SUCCESS";
    public String benefit_info;
    public String code;
    public ArrayList<ResultPageInfo.DynamicComponent> dynamic_components;
    public JSONObject exts;
    public String msg;
    public String ret_status;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/data/QueryPromotionAfterPayInfo$Companion;", "", "()V", "QUERY_CODE", "", "SUCCESS_CODE", "SUCCESS_STATUS", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public QueryPromotionAfterPayInfo() {
        this.dynamic_components = new ArrayList();
        this.benefit_info = "";
        this.exts = new JSONObject();
    }
}
