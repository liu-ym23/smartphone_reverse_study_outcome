package com.android.ttcjpaysdk.thirdparty.voiceprint.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/ResponseBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "code", "", "msg", "status", VoicePrintState.EXT_KEY_TEXT, "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResponseBean implements CJPayObject {
    public String code;
    public String msg;
    public String status;
    public String voice_text;

    public ResponseBean() {
        this.code = "";
        this.msg = "";
        this.status = "";
        this.voice_text = "";
    }
}
