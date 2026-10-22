package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class i3 extends i2 implements MethodOrBuilder {
    private static final i3 DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile p3 PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private boolean requestStreaming_;
    private boolean responseStreaming_;
    private int syntax_;
    private String name_ = "";
    private String requestTypeUrl_ = "";
    private String responseTypeUrl_ = "";
    private o2 options_ = r3.f2514j;

    static {
        i3 i3Var = new i3();
        DEFAULT_INSTANCE = i3Var;
        i2.n(i3.class, i3Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001b\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", o3.class, "syntax_"});
            case 3:
                return new i3();
            case 4:
                return new b7.a(29, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (i3.class) {
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

    @Override // com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final o3 getOptions(int i2) {
        return (o3) this.options_.get(i2);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final List getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final String getRequestTypeUrl() {
        return this.requestTypeUrl_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final l getRequestTypeUrlBytes() {
        return l.i(this.requestTypeUrl_);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final String getResponseTypeUrl() {
        return this.responseTypeUrl_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final l getResponseTypeUrlBytes() {
        return l.i(this.responseTypeUrl_);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final a4 getSyntax() {
        int i2 = this.syntax_;
        a4 a4Var = i2 != 0 ? i2 != 1 ? i2 != 2 ? null : a4.SYNTAX_EDITIONS : a4.SYNTAX_PROTO3 : a4.SYNTAX_PROTO2;
        return a4Var == null ? a4.UNRECOGNIZED : a4Var;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final int getSyntaxValue() {
        return this.syntax_;
    }
}
