package com.android.ttcjpaysdk.thirdparty.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/data/ProcessingGuideBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "title", "", SocialConstants.PARAM_APP_DESC, "btn_text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProcessingGuideBean implements CJPayObject {
    public String btn_text;
    public String desc;
    public String title;

    public ProcessingGuideBean() {
        this(null, null, null, 7, null);
    }

    public ProcessingGuideBean(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r102, "btn_text");
        this.title = r100;
        this.desc = r101;
        this.btn_text = r102;
    }

    public /* synthetic */ ProcessingGuideBean(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
