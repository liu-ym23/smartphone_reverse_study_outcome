package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/data/PopUpInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "content", "", "title", "isEmpty", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopUpInfo implements CJPayObject {
    public String content;
    public String title;

    public final boolean isEmpty() {
        if (TextUtils.isEmpty(this.title) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.content) == true) goto L8;
        return false;
    }

    public PopUpInfo() {
        this.title = "";
        this.content = "";
    }
}
