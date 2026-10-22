package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data;

import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodFoldBean;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodBean;", "type", "", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "foldItemIconList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFoldItemIconList", "()Ljava/util/ArrayList;", "setFoldItemIconList", "(Ljava/util/ArrayList;)V", "foldItemList", "", "getFoldItemList", "setFoldItemList", "status", "", "getStatus", "()I", "setStatus", "(I)V", "getType", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyMethodFoldBean extends CJUnifyMethodBean {
    private final String desc;
    private ArrayList<String> foldItemIconList;
    private ArrayList<Object> foldItemList;
    private int status;
    private final String type;

    public final String getDesc() {
        return this.desc;
    }

    public final ArrayList<String> getFoldItemIconList() {
        return this.foldItemIconList;
    }

    public final ArrayList<Object> getFoldItemList() {
        return this.foldItemList;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public final void setFoldItemIconList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.foldItemIconList = r100;
    }

    public final void setFoldItemList(ArrayList<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.foldItemList = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public CJUnifyMethodFoldBean(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        this.type = r100;
        this.desc = r101;
        this.foldItemList = new ArrayList();
        this.foldItemIconList = new ArrayList();
    }
}
