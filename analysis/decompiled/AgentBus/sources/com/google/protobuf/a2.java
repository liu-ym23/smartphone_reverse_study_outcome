package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class a2 extends i2 implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final a2 DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile p3 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;
    private int kind_;
    private int number_;
    private int oneofIndex_;
    private boolean packed_;
    private String name_ = "";
    private String typeUrl_ = "";
    private o2 options_ = r3.f2514j;
    private String jsonName_ = "";
    private String defaultValue_ = "";

    static {
        a2 a2Var = new a2();
        DEFAULT_INSTANCE = a2Var;
        i2.n(a2.class, a2Var);
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", o3.class, "jsonName_", "defaultValue_"});
            case 3:
                return new a2();
            case 4:
                return new b7.a(27, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (a2.class) {
                    try {
                        g2Var = PARSER;
                        if (g2Var == null) {
                            g2Var = new g2();
                            PARSER = g2Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return g2Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final y1 getCardinality() {
        int i2 = this.cardinality_;
        y1 y1Var = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : y1.CARDINALITY_REPEATED : y1.CARDINALITY_REQUIRED : y1.CARDINALITY_OPTIONAL : y1.CARDINALITY_UNKNOWN;
        return y1Var == null ? y1.UNRECOGNIZED : y1Var;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final String getDefaultValue() {
        return this.defaultValue_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final l getDefaultValueBytes() {
        return l.i(this.defaultValue_);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final String getJsonName() {
        return this.jsonName_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final l getJsonNameBytes() {
        return l.i(this.jsonName_);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final z1 getKind() {
        z1 z1Var;
        switch (this.kind_) {
            case 0:
                z1Var = z1.TYPE_UNKNOWN;
                break;
            case 1:
                z1Var = z1.TYPE_DOUBLE;
                break;
            case 2:
                z1Var = z1.TYPE_FLOAT;
                break;
            case 3:
                z1Var = z1.TYPE_INT64;
                break;
            case 4:
                z1Var = z1.TYPE_UINT64;
                break;
            case 5:
                z1Var = z1.TYPE_INT32;
                break;
            case 6:
                z1Var = z1.TYPE_FIXED64;
                break;
            case 7:
                z1Var = z1.TYPE_FIXED32;
                break;
            case 8:
                z1Var = z1.TYPE_BOOL;
                break;
            case 9:
                z1Var = z1.TYPE_STRING;
                break;
            case 10:
                z1Var = z1.TYPE_GROUP;
                break;
            case 11:
                z1Var = z1.TYPE_MESSAGE;
                break;
            case 12:
                z1Var = z1.TYPE_BYTES;
                break;
            case 13:
                z1Var = z1.TYPE_UINT32;
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                z1Var = z1.TYPE_ENUM;
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                z1Var = z1.TYPE_SFIXED32;
                break;
            case 16:
                z1Var = z1.TYPE_SFIXED64;
                break;
            case 17:
                z1Var = z1.TYPE_SINT32;
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                z1Var = z1.TYPE_SINT64;
                break;
            default:
                z1Var = null;
                break;
        }
        return z1Var == null ? z1.UNRECOGNIZED : z1Var;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final o3 getOptions(int i2) {
        return (o3) this.options_.get(i2);
    }

    @Override // com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final List getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public final l getTypeUrlBytes() {
        return l.i(this.typeUrl_);
    }
}
