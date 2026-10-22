package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public class CommentColor implements Serializable {
    private static final long serialVersionUID = -3387446332096328323L;

    @SerializedName("color")
    public String mColor;

    @SerializedName("name")
    public String mColorName;

    public CommentColor() {
    }
}
