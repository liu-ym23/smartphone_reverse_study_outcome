package io.ktor.util;

import La.H;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/util/AttributeKey;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "Lio/ktor/util/reflect/TypeInfo;", "type", "<init>", "(Ljava/lang/String;Lio/ktor/util/reflect/TypeInfo;)V", "toString", "()Ljava/lang/String;", "component1", "component2", "()Lio/ktor/util/reflect/TypeInfo;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lio/ktor/util/reflect/TypeInfo;)Lio/ktor/util/AttributeKey;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getName", "Lio/ktor/util/reflect/TypeInfo;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AttributeKey<T> {
    private final String name;
    private final TypeInfo type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AttributeKey(String name) {
        this(name, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.i(name, "name");
    }

    /* renamed from: component2, reason: from getter */
    private final TypeInfo getType() {
        return this.type;
    }

    public static /* synthetic */ AttributeKey copy$default(AttributeKey attributeKey, String str, TypeInfo typeInfo, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = attributeKey.name;
        }
        if ((i10 & 2) != 0) {
            typeInfo = attributeKey.type;
        }
        return attributeKey.copy(str, typeInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final AttributeKey<T> copy(String name, TypeInfo type) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(type, "type");
        return new AttributeKey<>(name, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttributeKey)) {
            return false;
        }
        AttributeKey attributeKey = (AttributeKey) other;
        return kotlin.jvm.internal.p.d(this.name, attributeKey.name) && kotlin.jvm.internal.p.d(this.type, attributeKey.type);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "AttributeKey: " + this.name;
    }

    public AttributeKey(String name, TypeInfo type) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(type, "type");
        this.name = name;
        this.type = type;
        if (H.x0(name)) {
            throw new IllegalArgumentException("Name can't be blank");
        }
    }

    public /* synthetic */ AttributeKey(String str, TypeInfo typeInfo, int i10, kotlin.jvm.internal.i iVar) {
        InterfaceC5755n interfaceC5755nM;
        if ((i10 & 2) != 0) {
            InterfaceC5745d interfaceC5745dB = t.b(Object.class);
            try {
                interfaceC5755nM = t.m(Object.class);
            } catch (Throwable unused) {
                interfaceC5755nM = null;
            }
            typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
        }
        this(str, typeInfo);
    }
}
