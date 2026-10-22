package com.stepos.mcp.sdk.base;

import C9.AbstractC0200b;
import C9.C0199a;
import C9.x;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.b;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a.\u0010\b\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086\b¢\u0006\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LC9/x;", "toJsonObject", "(Ljava/lang/Object;)LC9/x;", "", "jsonObject", "Ljava/lang/Class;", "type", "fromJson", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "EmptyJsonObject", "LC9/x;", "getEmptyJsonObject", "()LC9/x;", "sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityResultKt {
    private static final x EmptyJsonObject = new x(a.M());

    public static final /* synthetic */ <T> T fromJson(String jsonObject, Class<T> type) {
        k.f(jsonObject, "jsonObject");
        k.f(type, "type");
        return (T) b.a(jsonObject, type);
    }

    public static final x getEmptyJsonObject() {
        return EmptyJsonObject;
    }

    public static final <T> x toJsonObject(T t9) {
        C0199a c0199a = AbstractC0200b.d;
        k.m();
        throw null;
    }
}
