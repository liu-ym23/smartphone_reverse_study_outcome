package com.android.ttcjpaysdk.kmp.common.container;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.kmp.common.utils.CJJsonUtils;
import java.util.Map;
import juc.v;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.modules.d;
import org.json.JSONObject;
import ouc.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\tB\u001d\b\u0016\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\u0004\u0010\fJ\u0016\u0010\u0010\u001a\u0002H\u0011\"\u0006\b\u0000\u0010\u0011\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/PlatformObject;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "()V", "jsonString", "", "(Ljava/lang/String;)V", "map", "", "(Ljava/util/Map;)V", "value", "getValue", "()Lorg/json/JSONObject;", "toModel", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformObject {
    public static final int $stable = 8;
    private final JSONObject value;

    public final <T> T toModel() {
        a r100 = CJJsonUtils.INSTANCE.getJsonInstance();
        String r101 = getValue().toString();
        d r102 = r100.f526800b;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return (T) r100.c(v.d(r102, null), r101);
    }

    public PlatformObject() {
        this.value = new JSONObject();
    }

    public final JSONObject getValue() {
        return this.value;
    }

    public PlatformObject(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L11;
        r102 = new JSONObject();
    L11:
        this.value = (JSONObject) r102;
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public PlatformObject(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L11;
        r102 = new JSONObject();
    L11:
        this.value = (JSONObject) r102;
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public PlatformObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        this.value = r100;
    }
}
