package com.stepos.net.response;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.net.exception.ExceptionHandler;
import com.stepos.net.response.HttpResult;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"toHttpResult", "Lcom/stepos/net/response/HttpResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Result;", "(Ljava/lang/Object;)Lcom/stepos/net/response/HttpResult;", "net_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpResultKt {
    public static final <T> HttpResult<T> toHttpResult(Object obj) {
        Throwable thE = Result.e(obj);
        return thE == null ? new HttpResult.Success(obj) : new HttpResult.Error(ExceptionHandler.INSTANCE.handle(thE));
    }
}
