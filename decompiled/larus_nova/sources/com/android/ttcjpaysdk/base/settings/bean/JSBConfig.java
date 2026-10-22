package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\"\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/JSBConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "fix_input_params_jsb_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "fixJSBInputParams", "", "methodName", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBConfig implements CJPayObject, Serializable {
    public ArrayList<String> fix_input_params_jsb_list;

    /* JADX WARN: Multi-variable type inference failed */
    public JSBConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public JSBConfig(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "fix_input_params_jsb_list");
        this.fix_input_params_jsb_list = r100;
    }

    public final boolean fixJSBInputParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        return this.fix_input_params_jsb_list.contains(r100);
    }

    public /* synthetic */ JSBConfig(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
