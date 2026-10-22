package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import g5.f;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class IterationType extends SimpleType {
    private static final long serialVersionUID = 1;
    protected final JavaType _iteratedType;

    public IterationType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z10) {
        super(cls, typeBindings, javaType, javaTypeArr, Objects.hashCode(javaType2), obj, obj2, z10);
        this._iteratedType = javaType2;
    }

    public static IterationType construct(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2) {
        return new IterationType(cls, typeBindings, javaType, javaTypeArr, javaType2, null, null, false);
    }

    public static IterationType upgradeFrom(JavaType javaType, JavaType javaType2) {
        Objects.requireNonNull(javaType2);
        if (javaType instanceof TypeBase) {
            return new IterationType((TypeBase) javaType, javaType2);
        }
        f.f(javaType.getClass(), "Cannot upgrade from an instance of ");
        return null;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.type.TypeBase
    public String buildCanonicalName() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this._class.getName());
        if (this._iteratedType != null && _hasNTypeParameters(1)) {
            sb2.append('<');
            sb2.append(this._iteratedType.toCanonical());
            sb2.append('>');
        }
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.type.TypeBase, com.fasterxml.jackson.databind.JavaType
    public StringBuilder getErasedSignature(StringBuilder sb2) {
        return TypeBase._classSignature(this._class, sb2, true);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.type.TypeBase, com.fasterxml.jackson.databind.JavaType
    public StringBuilder getGenericSignature(StringBuilder sb2) {
        TypeBase._classSignature(this._class, sb2, false);
        sb2.append('<');
        StringBuilder genericSignature = this._iteratedType.getGenericSignature(sb2);
        genericSignature.append(">;");
        return genericSignature;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public boolean hasContentType() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public boolean isIterationType() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public JavaType refine(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new IterationType(cls, this._bindings, javaType, javaTypeArr, this._iteratedType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public JavaType withContentType(JavaType javaType) {
        return this._iteratedType == javaType ? this : new IterationType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public IterationType withContentTypeHandler(Object obj) {
        return obj == this._iteratedType.getTypeHandler() ? this : new IterationType(this._class, this._bindings, this._superClass, this._superInterfaces, this._iteratedType.withTypeHandler(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public IterationType withContentValueHandler(Object obj) {
        return obj == this._iteratedType.getValueHandler() ? this : new IterationType(this._class, this._bindings, this._superClass, this._superInterfaces, this._iteratedType.withValueHandler(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public IterationType withStaticTyping() {
        return this._asStatic ? this : new IterationType(this._class, this._bindings, this._superClass, this._superInterfaces, this._iteratedType.withStaticTyping(), this._valueHandler, this._typeHandler, true);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public IterationType withTypeHandler(Object obj) {
        return obj == this._typeHandler ? this : new IterationType(this._class, this._bindings, this._superClass, this._superInterfaces, this._iteratedType, this._valueHandler, obj, this._asStatic);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public IterationType withValueHandler(Object obj) {
        return obj == this._valueHandler ? this : new IterationType(this._class, this._bindings, this._superClass, this._superInterfaces, this._iteratedType, obj, this._typeHandler, this._asStatic);
    }

    @Override // com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.core.type.ResolvedType
    public JavaType getContentType() {
        return this._iteratedType;
    }

    public IterationType(TypeBase typeBase, JavaType javaType) {
        super(typeBase);
        this._iteratedType = javaType;
    }
}
