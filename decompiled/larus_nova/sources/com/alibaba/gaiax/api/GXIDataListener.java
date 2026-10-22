package com.alibaba.gaiax.api;

import com.alibaba.gaiax.model.GXTextData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/api/GXIDataListener;", "", "onTextProcess", "", "gxTextData", "Lcom/alibaba/gaiax/model/GXTextData;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GXIDataListener {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static CharSequence onTextProcess(GXIDataListener r100, GXTextData r101) {
            Intrinsics.checkNotNullParameter(r101, "gxTextData");
            return null;
        }
    }

    CharSequence onTextProcess(GXTextData r100);
}
