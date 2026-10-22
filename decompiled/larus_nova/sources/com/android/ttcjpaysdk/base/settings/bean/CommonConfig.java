package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007R\"\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CommonConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "black_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/settings/bean/BlackConfig;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CommonConfig implements CJPayObject, Serializable {
    public ArrayList<BlackConfig> black_list;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CommonConfig(ArrayList<BlackConfig> r100) {
        Intrinsics.checkNotNullParameter(r100, "black_list");
        this.black_list = r100;
    }

    public /* synthetic */ CommonConfig(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
