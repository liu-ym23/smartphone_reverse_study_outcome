package com.bytedance.android.livesdkapi.sti.framework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u0004\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/ICommonTemplateFeature;", "", "isBackgroundEnabled", "", "()Z", "setBackgroundEnabled", "(Z)V", "isMaskEnabled", "setMaskEnabled", "label", "", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "superscript", "getSuperscript", "setSuperscript", "setTemplateAlpha", "", "alpha", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICommonTemplateFeature {
    String getLabel();

    String getSuperscript();

    boolean isBackgroundEnabled();

    boolean isMaskEnabled();

    void setBackgroundEnabled(boolean r100);

    void setLabel(String r100);

    void setMaskEnabled(boolean r100);

    void setSuperscript(String r100);

    void setTemplateAlpha(float r100);
}
