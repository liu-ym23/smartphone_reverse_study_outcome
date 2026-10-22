package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IMicrophoneItem;", "Lvh7/c;", "", "getMicrophoneType", "()I", "getMicrophoneType$annotations", "()V", "microphoneType", "getMicroPhoneNum", "getMicroPhoneNum$annotations", "microPhoneNum", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMicrophoneItem extends c<IMicrophoneItem> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "micro_phone_num")
        public static /* synthetic */ void getMicroPhoneNum$annotations() {
        }

        @FieldName(name = "microphone_type")
        public static /* synthetic */ void getMicrophoneType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "micro_phone_num")
    int getMicroPhoneNum();

    @FieldName(name = "microphone_type")
    int getMicrophoneType();
}
