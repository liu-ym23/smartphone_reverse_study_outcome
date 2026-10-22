package com.android.ttcjpaysdk.ocr.data;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/MultiplePhotosInfo;", "Ljava/io/Serializable;", "id_photo", "", "(Ljava/lang/String;)V", "id_photo_back", "getId_photo_back", "()Ljava/lang/String;", "setId_photo_back", "id_photo_back_type", "getId_photo_back_type", "setId_photo_back_type", "id_photo_type", "getId_photo_type", "setId_photo_type", "toJson", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiplePhotosInfo implements Serializable {
    private final String id_photo;
    private String id_photo_back;
    private String id_photo_back_type;
    private String id_photo_type;

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("id_photo", this.id_photo);     // Catch: Exception -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("MultiplePhotosInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "MultiplePhotosInfo#toJson", e);
        return null;
    }

    public final String getId_photo_back() {
        return this.id_photo_back;
    }

    public final String getId_photo_back_type() {
        return this.id_photo_back_type;
    }

    public final String getId_photo_type() {
        return this.id_photo_type;
    }

    public MultiplePhotosInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id_photo");
        this.id_photo = r100;
        this.id_photo_type = "";
        this.id_photo_back = "";
        this.id_photo_back_type = "";
    }

    public final void setId_photo_back(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.id_photo_back = r100;
    }

    public final void setId_photo_back_type(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.id_photo_back_type = r100;
    }

    public final void setId_photo_type(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.id_photo_type = r100;
    }
}
