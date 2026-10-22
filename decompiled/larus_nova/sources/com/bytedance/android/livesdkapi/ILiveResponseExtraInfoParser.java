package com.bytedance.android.livesdkapi;

import com.bytedance.retrofit2.SsResponse;
import com.lynx.tasm.LynxError;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\bH&R\u001c\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/ILiveResponseExtraInfoParser;", "", "targetResponseTypes", "", "Ljava/lang/Class;", "getTargetResponseTypes", "()Ljava/util/Set;", "targetThrowableTypes", "", "getTargetThrowableTypes", "parse", "Lcom/bytedance/android/livesdkapi/ILiveResponseExtraInfo;", "url", "", "response", "Lcom/bytedance/retrofit2/SsResponse;", "parseFromThrowable", LynxError.LYNX_THROWABLE, "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveResponseExtraInfoParser {
    Set<Class<?>> getTargetResponseTypes();

    Set<Class<? extends Throwable>> getTargetThrowableTypes();

    ILiveResponseExtraInfo parse(String r100, SsResponse<Object> r101);

    ILiveResponseExtraInfo parseFromThrowable(Throwable r100);
}
