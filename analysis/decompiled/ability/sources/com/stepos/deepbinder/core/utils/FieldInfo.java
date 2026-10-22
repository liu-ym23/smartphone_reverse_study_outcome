package com.stepos.deepbinder.core.utils;

import androidx.appfunctions.metadata.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stepos/deepbinder/core/utils/FieldInfo;", "", TypedValues.AttributesType.S_TARGET, "field", "Ljava/lang/reflect/Field;", "depth", "", AppAgent.CONSTRUCT, "(Ljava/lang/Object;Ljava/lang/reflect/Field;I)V", "getTarget", "()Ljava/lang/Object;", "getField", "()Ljava/lang/reflect/Field;", "getDepth", "()I", "getFieldValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FieldInfo {
    private final int depth;
    private final Field field;
    private final Object target;

    public FieldInfo(Object obj, Field field, int i) {
        k.f(field, "field");
        this.target = obj;
        this.field = field;
        this.depth = i;
    }

    public static /* synthetic */ FieldInfo copy$default(FieldInfo fieldInfo, Object obj, Field field, int i, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            obj = fieldInfo.target;
        }
        if ((i6 & 2) != 0) {
            field = fieldInfo.field;
        }
        if ((i6 & 4) != 0) {
            i = fieldInfo.depth;
        }
        return fieldInfo.copy(obj, field, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getTarget() {
        return this.target;
    }

    /* renamed from: component2, reason: from getter */
    public final Field getField() {
        return this.field;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    public final FieldInfo copy(Object target, Field field, int depth) {
        k.f(field, "field");
        return new FieldInfo(target, field, depth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FieldInfo)) {
            return false;
        }
        FieldInfo fieldInfo = (FieldInfo) other;
        return k.b(this.target, fieldInfo.target) && k.b(this.field, fieldInfo.field) && this.depth == fieldInfo.depth;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final Field getField() {
        return this.field;
    }

    public final Object getFieldValue() throws SecurityException {
        try {
            this.field.setAccessible(true);
            return this.field.get(this.target);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Object getTarget() {
        return this.target;
    }

    public int hashCode() {
        Object obj = this.target;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        return Integer.hashCode(this.depth) + ((this.field.hashCode() + (iHashCode * 31)) * 31);
    }

    public String toString() {
        Object obj = this.target;
        Field field = this.field;
        int i = this.depth;
        StringBuilder sb = new StringBuilder("FieldInfo(target=");
        sb.append(obj);
        sb.append(", field=");
        sb.append(field);
        sb.append(", depth=");
        return a.o(sb, ")", i);
    }
}
