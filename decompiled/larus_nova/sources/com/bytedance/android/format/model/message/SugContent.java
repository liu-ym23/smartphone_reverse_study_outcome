package com.bytedance.android.format.model.message;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/format/model/message/SugContent;", "Ljava/io/Serializable;", "()V", "borderColor", "", "getBorderColor", "()Ljava/lang/String;", "candidateTexts", "", "getCandidateTexts", "()Ljava/util/List;", "image", "getImage", "leftColor", "getLeftColor", "responseText", "getResponseText", "rightColor", "getRightColor", "schema", "getSchema", "text", "getText", "setText", "(Ljava/lang/String;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SugContent implements Serializable {

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("candidate_texts")
    private final List<String> candidateTexts;

    @SerializedName("image_url")
    private final String image;

    @SerializedName("left_color")
    private final String leftColor;

    @SerializedName("response_text")
    private final String responseText;

    @SerializedName("right_color")
    private final String rightColor;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("text")
    private String text;

    public SugContent() {
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final List<String> getCandidateTexts() {
        return this.candidateTexts;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLeftColor() {
        return this.leftColor;
    }

    public final String getResponseText() {
        return this.responseText;
    }

    public final String getRightColor() {
        return this.rightColor;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
