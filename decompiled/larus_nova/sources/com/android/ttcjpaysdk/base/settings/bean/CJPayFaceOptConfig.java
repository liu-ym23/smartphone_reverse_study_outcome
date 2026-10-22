package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceOptConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "face_dialog_opt", "", "face_full_progress_bar_opt", "face_full_result", "face_prompt_animation_enable", "face_prompt_audio_enable", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceOptConfig implements CJPayObject, Serializable {
    public String face_dialog_opt;
    public String face_full_progress_bar_opt;
    public String face_full_result;
    public String face_prompt_animation_enable;
    public String face_prompt_audio_enable;

    public CJPayFaceOptConfig() {
        this.face_prompt_animation_enable = "0";
        this.face_full_progress_bar_opt = "0";
        this.face_dialog_opt = "0";
        this.face_prompt_audio_enable = "0";
        this.face_full_result = "1";
    }
}
