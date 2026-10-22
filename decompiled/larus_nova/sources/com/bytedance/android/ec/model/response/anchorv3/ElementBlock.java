package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ElementBlock;", "Ljava/io/Serializable;", "()V", "avatars", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAvatars", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setAvatars", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "blankWidth", "", "getBlankWidth", "()J", "setBlankWidth", "(J)V", "countDown", "Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "getCountDown", "()Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;)V", "image", "getImage", "setImage", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "type", "", "getType", "()I", "setType", "(I)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ElementBlock implements Serializable {

    @SerializedName("avatars")
    private ECUrlModel avatars;

    @SerializedName("blank_width")
    private long blankWidth;

    @SerializedName("countdown")
    private CountDown countDown;

    @SerializedName("image")
    private ECUrlModel image;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("element_type")
    private int type;

    public ElementBlock() {
    }

    public final ECUrlModel getAvatars() {
        return this.avatars;
    }

    public final long getBlankWidth() {
        return this.blankWidth;
    }

    public final CountDown getCountDown() {
        return this.countDown;
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAvatars(ECUrlModel r100) {
        this.avatars = r100;
    }

    public final void setBlankWidth(long r100) {
        this.blankWidth = r100;
    }

    public final void setCountDown(CountDown r100) {
        this.countDown = r100;
    }

    public final void setImage(ECUrlModel r100) {
        this.image = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
