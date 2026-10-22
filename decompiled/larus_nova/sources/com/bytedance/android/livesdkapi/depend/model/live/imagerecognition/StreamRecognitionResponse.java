package com.bytedance.android.livesdkapi.depend.model.live.imagerecognition;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.StreamRecognitionResponseData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/StreamRecognitionResponse;", "", "()V", "containerSchema", "", "extra", "requestId", "", "results", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/RecognitionBox;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamRecognitionResponse implements h {

    @SerializedName("container_schema")
    public String containerSchema;

    @SerializedName("extra")
    public String extra;

    @SerializedName("request_id")
    public long requestId;

    @SerializedName("bbox_list")
    public List<RecognitionBox> results;

    public StreamRecognitionResponse() {
    }

    public StreamRecognitionResponse(g r100) {
        this.results = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.requestId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.containerSchema = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.results.add(new RecognitionBox(r100));
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.extra = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
