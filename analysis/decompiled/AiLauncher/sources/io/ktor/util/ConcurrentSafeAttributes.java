package io.ktor.util;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR,\u0010\r\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/util/ConcurrentSafeAttributes;", "Lio/ktor/util/AttributesJvmBase;", "<init>", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/AttributeKey;", "key", "Lkotlin/Function0;", "block", "computeIfAbsent", "(Lio/ktor/util/AttributeKey;Lp9/a;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentHashMap;", C3081a.FOCUS_MAP_NAME, "Ljava/util/concurrent/ConcurrentHashMap;", "getMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ConcurrentSafeAttributes extends AttributesJvmBase {
    private final ConcurrentHashMap<AttributeKey<?>, Object> map = new ConcurrentHashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.Attributes
    public <T> T computeIfAbsent(AttributeKey<T> key, InterfaceC5063a<? extends T> block) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(block, "block");
        T t10 = (T) getMap().get(key);
        if (t10 != null) {
            return t10;
        }
        T tInvoke = block.invoke();
        Object objPutIfAbsent = getMap().putIfAbsent(key, tInvoke);
        if (objPutIfAbsent != 0) {
            tInvoke = objPutIfAbsent;
        }
        kotlin.jvm.internal.p.g(tInvoke, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return tInvoke;
    }

    @Override // io.ktor.util.AttributesJvmBase
    public ConcurrentHashMap<AttributeKey<?>, Object> getMap() {
        return this.map;
    }
}
