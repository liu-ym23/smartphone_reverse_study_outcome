package com.bytedance.android.livesdkapi.message.lazy;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/lazy/ITextWrapper;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/a5;", "getText", "", "getRawPB", "()[B", "setRawPB", "([B)V", "rawPB", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ITextWrapper extends c<ITextWrapper> {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    byte[] getRawPB();

    a5 getText();

    void setRawPB(byte[] r100);
}
