package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "", "DECODE_TYPE_BASE64", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SSRDataDecodingFormat extends Enum<SSRDataDecodingFormat> {

    @SerializedName("0")
    public static final SSRDataDecodingFormat DECODE_TYPE_BASE64 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SSRDataDecodingFormat[] f47085a = null;

    static {
        SSRDataDecodingFormat r100 = new SSRDataDecodingFormat();
        DECODE_TYPE_BASE64 = r100;
        f47085a = new SSRDataDecodingFormat[]{r100};
    }

    public static SSRDataDecodingFormat valueOf(String r100) {
        return (SSRDataDecodingFormat) r27.a.a(SSRDataDecodingFormat.class, r100);
    }

    public static SSRDataDecodingFormat[] values() {
        return (SSRDataDecodingFormat[]) f47085a.clone();
    }

    public SSRDataDecodingFormat() {
        super("DECODE_TYPE_BASE64", 0);
    }
}
