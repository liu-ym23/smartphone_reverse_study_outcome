package com.bytedance.android.livesdkapi.windowsprompt;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/windowsprompt/WindowsPrompt;", "", "()V", "bodyText", "", "getBodyText", "()Ljava/lang/String;", "setBodyText", "(Ljava/lang/String;)V", "buttonInfo", "", "Lcom/bytedance/android/livesdkapi/windowsprompt/WindowsButton;", "getButtonInfo", "()Ljava/util/List;", "setButtonInfo", "(Ljava/util/List;)V", "titleText", "getTitleText", "setTitleText", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WindowsPrompt implements h {

    @SerializedName("body_text")
    protected String bodyText;

    @SerializedName("button_info")
    protected List<WindowsButton> buttonInfo;

    @SerializedName("title_text")
    protected String titleText;

    public WindowsPrompt() {
    }

    public WindowsPrompt(g r100) {
        this.buttonInfo = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.titleText = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.bodyText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.buttonInfo.add(new WindowsButton(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getBodyText() {
        return this.bodyText;
    }

    public final List<WindowsButton> getButtonInfo() {
        return this.buttonInfo;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setBodyText(String r100) {
        this.bodyText = r100;
    }

    public final void setButtonInfo(List<WindowsButton> r100) {
        this.buttonInfo = r100;
    }

    public final void setTitleText(String r100) {
        this.titleText = r100;
    }
}
