package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class Text extends FlexModelBase<a5> implements a5 {

    @SerializedName("default_format")
    b5 defaultFormat;

    @SerializedName("default_pattern")
    String defaultPattern;

    @SerializedName("key")
    String key;

    @SerializedName("pieces")
    List<TextPiece> pieces;

    @SerializedName("schema_infos")
    Map<String, m6> schemaInfos;

    public Text() {
        super(a5.class);
    }

    public String getDefaultColor() {
        b5 r100 = this.defaultFormat;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getColor();
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public String getDefaultPattern() {
        String r100 = this.defaultPattern;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public List<c5> getPieces() {
        return KotlinTypeUtilsKt.castElementType(this.pieces);
    }

    public String toString() {
        return "Text{key='" + this.key + "', defaultPattern='" + this.defaultPattern + "', defaultFormat=" + this.defaultFormat + ", pieces=" + this.pieces + '}';
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public b5 getDefaultFormat() {
        return this.defaultFormat;
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public String getKey() {
        return this.key;
    }

    public List<TextPiece> getMPieces() {
        return this.pieces;
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public Map<String, m6> getSchemaInfos() {
        return this.schemaInfos;
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public void setDefaultFormat(b5 r100) {
        this.defaultFormat = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public void setDefaultPattern(String r100) {
        this.defaultPattern = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public void setKey(String r100) {
        this.key = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.a5
    public void setPieces(List<? extends c5> r100) {
        this.pieces = KotlinTypeUtilsKt.castElementType(r100);
    }
}
