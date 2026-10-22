package com.bytedance.android.livesdk.schema;

import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/schema/SchemaHandlerData;", "", "schemaHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "modelClassType", "Ljava/lang/Class;", "(Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;Ljava/lang/Class;)V", "getModelClassType", "()Ljava/lang/Class;", "getSchemaHandler", "()Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SchemaHandlerData {
    private final Class<?> modelClassType;
    private final IBaseSchemaHandler<?> schemaHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SchemaHandlerData copy$default(SchemaHandlerData r100, IBaseSchemaHandler r101, Class r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.schemaHandler;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.modelClassType;
    L9:
        return r100.copy(r101, r102);
    }

    public final IBaseSchemaHandler<?> component1() {
        return this.schemaHandler;
    }

    public final Class<?> component2() {
        return this.modelClassType;
    }

    public final SchemaHandlerData copy(IBaseSchemaHandler<?> r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaHandler");
        return new SchemaHandlerData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SchemaHandlerData) == false) goto L10;
        SchemaHandlerData r101 = (SchemaHandlerData) r100;
        if (Intrinsics.areEqual(this.schemaHandler, r101.schemaHandler) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.modelClassType, r101.modelClassType) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        IBaseSchemaHandler<?> r100 = this.schemaHandler;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Class<?> r104 = this.modelClassType;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SchemaHandlerData(schemaHandler=" + this.schemaHandler + ", modelClassType=" + this.modelClassType + ")";
    }

    public final Class<?> getModelClassType() {
        return this.modelClassType;
    }

    public final IBaseSchemaHandler<?> getSchemaHandler() {
        return this.schemaHandler;
    }

    public SchemaHandlerData(IBaseSchemaHandler<?> r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaHandler");
        this.schemaHandler = r100;
        this.modelClassType = r101;
    }
}
