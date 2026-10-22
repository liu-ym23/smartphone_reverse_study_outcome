package com.bytedance.android.livehostapi.business.depend.share;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/CheckBoxConfigParams;", "", "()V", "checked", "", "getChecked", "()Z", "title", "", "getTitle", "()Ljava/lang/String;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckBoxConfigParams {

    @SerializedName("checked")
    private final boolean checked;

    @SerializedName("title")
    private final String title;

    public CheckBoxConfigParams() {
        this.title = "";
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getTitle() {
        return this.title;
    }
}
