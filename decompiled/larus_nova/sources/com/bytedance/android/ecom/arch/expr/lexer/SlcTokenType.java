package com.bytedance.android.ecom.arch.expr.lexer;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ecom/arch/expr/lexer/SlcTokenType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-expr_release"}, k = 1, mv = {1, 4, 0})
public @interface SlcTokenType {
    public static final int ASTERISK = 5;
    public static final int BIT_AND = 19;
    public static final int BIT_NOT = 18;
    public static final int BIT_OR = 20;
    public static final int BIT_XOR = 21;
    public static final int COMMA = 23;
    public static final a Companion = null;
    public static final int DOT = 22;
    public static final int EOF = 32;
    public static final int EQUAL = 13;
    public static final int FALSE = 29;
    public static final int GREATER = 11;
    public static final int GREATER_EQUAL = 12;
    public static final int IDENTIFIER = 0;
    public static final int INTEGER = 31;
    public static final int LEFT_BRACKET = 26;
    public static final int LEFT_PAREN = 24;
    public static final int LESS = 9;
    public static final int LESS_EQUAL = 10;
    public static final int LOGIC_AND = 16;
    public static final int LOGIC_NOT = 15;
    public static final int LOGIC_OR = 17;
    public static final int MINUS = 3;
    public static final int NOT_EQUAL = 14;
    public static final int NULL = 30;
    public static final int NUMBER = 2;
    public static final int PERCENT = 7;
    public static final int PLUS = 4;
    public static final int POWER = 8;
    public static final int RIGHT_BRACKET = 27;
    public static final int RIGHT_PAREN = 25;
    public static final int SLASH = 6;
    public static final int STRING = 1;
    public static final int TRUE = 28;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f49946a = null;

        public a() {
        }

        static {
            f49946a = new a();
        }
    }

    static {
        Companion = a.f49946a;
    }
}
