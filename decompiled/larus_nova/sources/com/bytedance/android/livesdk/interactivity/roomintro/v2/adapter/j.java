package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.depend.model.live.security.CorrectionResult;
import com.bytedance.android.livesdkapi.depend.model.live.security.TextCorrection;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f140618a;

    public j(a r100) {
        this.f140618a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        TextCorrectionEditText r102 = this.f140618a.f140606c;
        if (r102 == null) goto L11;
        if (r101 == null) goto L8;
        TextCorrection r103 = (TextCorrection) r101.data;
        if (r103 == null) goto L8;
        List<CorrectionResult> r104 = r103.correctionResults;
    L9:
        r102.d(r104);
        return;
    L8:
        r104 = null;
        goto L9
    }
}
