package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0010R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/CustomizedConfig;", "Ljava/io/Serializable;", "()V", "faceClientSource", "", "Ljava/lang/Integer;", "isNewAnim", "", "isNotifyDirect", "logParams", "Lorg/json/JSONObject;", "needCertSign", "needMask", "preViewHeightDp", "", "signData", "", "voiceExt", "getVoiceExt", "()Lorg/json/JSONObject;", "setVoiceExt", "(Lorg/json/JSONObject;)V", "toJsonStr", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomizedConfig implements Serializable {
    public Integer faceClientSource;
    public boolean isNewAnim;
    public boolean isNotifyDirect;
    public JSONObject logParams;
    public boolean needCertSign;
    public boolean needMask;
    public float preViewHeightDp;
    public String signData;
    private JSONObject voiceExt;

    public final String toJsonStr() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "preViewHeightDp", Float.valueOf(this.preViewHeightDp));
        KtSafeMethodExtensionKt.safePut(r100, "isNewAnim", Boolean.valueOf(this.isNewAnim));
        KtSafeMethodExtensionKt.safePut(r100, "isNotifyDirect", Boolean.valueOf(this.isNotifyDirect));
        KtSafeMethodExtensionKt.safePut(r100, "needMask", Boolean.valueOf(this.needMask));
        KtSafeMethodExtensionKt.safePut(r100, "needCertSign", Boolean.valueOf(this.needCertSign));
        KtSafeMethodExtensionKt.safePut(r100, "signData", this.signData);
        KtSafeMethodExtensionKt.safePut(r100, "voiceExt", this.voiceExt);
        Object r101 = this.faceClientSource;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        KtSafeMethodExtensionKt.safePut(r100, "faceClientSource", r101);
        return r100.toString();
    }

    public CustomizedConfig() {
        this.preViewHeightDp = -1.0f;
        this.signData = "";
    }

    public final JSONObject getVoiceExt() {
        return this.voiceExt;
    }

    public final void setVoiceExt(JSONObject r100) {
        this.voiceExt = r100;
    }
}
