package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0017\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", "", "Lw9/d;", "type", "Lw9/n;", "kotlinType", "<init>", "(Lw9/d;Lw9/n;)V", "Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "(Lw9/d;Ljava/lang/reflect/Type;Lw9/n;)V", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "Lw9/d;", "getType", "()Lw9/d;", "Lw9/n;", "getKotlinType", "()Lw9/n;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TypeInfo {
    private final InterfaceC5755n kotlinType;
    private final InterfaceC5745d<?> type;

    public TypeInfo(InterfaceC5745d<?> type, InterfaceC5755n interfaceC5755n) {
        p.i(type, "type");
        this.type = type;
        this.kotlinType = interfaceC5755n;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypeInfo)) {
            return false;
        }
        InterfaceC5755n interfaceC5755n = this.kotlinType;
        if (interfaceC5755n == null) {
            TypeInfo typeInfo = (TypeInfo) other;
            if (typeInfo.kotlinType == null) {
                return p.d(this.type, typeInfo.type);
            }
        }
        return p.d(interfaceC5755n, ((TypeInfo) other).kotlinType);
    }

    public final InterfaceC5755n getKotlinType() {
        return this.kotlinType;
    }

    public final InterfaceC5745d<?> getType() {
        return this.type;
    }

    public int hashCode() {
        InterfaceC5755n interfaceC5755n = this.kotlinType;
        return interfaceC5755n != null ? interfaceC5755n.hashCode() : this.type.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TypeInfo(");
        Object obj = this.kotlinType;
        if (obj == null) {
            obj = this.type;
        }
        sb2.append(obj);
        sb2.append(')');
        return sb2.toString();
    }

    public /* synthetic */ TypeInfo(InterfaceC5745d interfaceC5745d, InterfaceC5755n interfaceC5755n, int i10, i iVar) {
        this(interfaceC5745d, (i10 & 2) != 0 ? null : interfaceC5755n);
    }

    public /* synthetic */ TypeInfo(InterfaceC5745d interfaceC5745d, Type type, InterfaceC5755n interfaceC5755n, int i10, i iVar) {
        this(interfaceC5745d, type, (i10 & 4) != 0 ? null : interfaceC5755n);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeInfo(InterfaceC5745d<?> type, Type reifiedType, InterfaceC5755n interfaceC5755n) {
        this(type, interfaceC5755n);
        p.i(type, "type");
        p.i(reifiedType, "reifiedType");
    }
}
