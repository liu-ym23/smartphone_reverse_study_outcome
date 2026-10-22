package com.bytedance.android.livesdkapi.depend.model.live.security;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.security.text_correction.CorrectionResult")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/security/CorrectionResult;", "", "()V", "idxOfText", "", "originalWord", "", "replaceWords", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CorrectionResult implements h {

    @SerializedName("idx_of_text")
    public int idxOfText;

    @SerializedName("original_word")
    public String originalWord;

    @SerializedName("replace_words")
    public List<String> replaceWords;

    public CorrectionResult() {
    }

    public CorrectionResult(g r100) {
        this.replaceWords = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.idxOfText = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.originalWord = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.replaceWords.add(am3.h.c(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
