package io.ktor.util.collections;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@InternalAPI
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/util/collections/SerializedMapValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "key", "Lkotlin/Function1;", "serialize", "deserialize", "<init>", "(Ljava/lang/String;Lp9/l;Lp9/l;)V", "Ljava/lang/String;", "getKey$ktor_utils", "()Ljava/lang/String;", "Lp9/l;", "getSerialize$ktor_utils", "()Lp9/l;", "getDeserialize$ktor_utils", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SerializedMapValue<T> {
    private final InterfaceC5074l<String, T> deserialize;
    private final String key;
    private final InterfaceC5074l<T, String> serialize;

    /* JADX WARN: Multi-variable type inference failed */
    public SerializedMapValue(String key, InterfaceC5074l<? super T, String> serialize, InterfaceC5074l<? super String, ? extends T> deserialize) {
        p.i(key, "key");
        p.i(serialize, "serialize");
        p.i(deserialize, "deserialize");
        this.key = key;
        this.serialize = serialize;
        this.deserialize = deserialize;
    }

    public final InterfaceC5074l<String, T> getDeserialize$ktor_utils() {
        return this.deserialize;
    }

    /* renamed from: getKey$ktor_utils, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final InterfaceC5074l<T, String> getSerialize$ktor_utils() {
        return this.serialize;
    }
}
