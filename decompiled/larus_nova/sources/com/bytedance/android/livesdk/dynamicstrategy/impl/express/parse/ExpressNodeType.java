package com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/express/parse/ExpressNodeType;", "", "CONST_INT", "CONST_FLOAT", "CONST_LONG", "CONST_DOUBLE", "CONST_BOOLEAN", "LEFT_BRACKET", "RIGHT_BRACKET", "OPERATOR_COMPARE", "OPERATOR_AND", "OPERATOR_OR", "PARAM", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExpressNodeType extends Enum<ExpressNodeType> {
    public static final ExpressNodeType CONST_BOOLEAN = null;
    public static final ExpressNodeType CONST_DOUBLE = null;
    public static final ExpressNodeType CONST_FLOAT = null;
    public static final ExpressNodeType CONST_INT = null;
    public static final ExpressNodeType CONST_LONG = null;
    public static final ExpressNodeType LEFT_BRACKET = null;
    public static final ExpressNodeType OPERATOR_AND = null;
    public static final ExpressNodeType OPERATOR_COMPARE = null;
    public static final ExpressNodeType OPERATOR_OR = null;
    public static final ExpressNodeType PARAM = null;
    public static final ExpressNodeType RIGHT_BRACKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExpressNodeType[] f123088a = null;

    static {
        ExpressNodeType r100 = new ExpressNodeType("CONST_INT", 0);
        CONST_INT = r100;
        ExpressNodeType r101 = new ExpressNodeType("CONST_FLOAT", 1);
        CONST_FLOAT = r101;
        ExpressNodeType r102 = new ExpressNodeType("CONST_LONG", 2);
        CONST_LONG = r102;
        ExpressNodeType r103 = new ExpressNodeType("CONST_DOUBLE", 3);
        CONST_DOUBLE = r103;
        ExpressNodeType r104 = new ExpressNodeType("CONST_BOOLEAN", 4);
        CONST_BOOLEAN = r104;
        ExpressNodeType r105 = new ExpressNodeType("LEFT_BRACKET", 5);
        LEFT_BRACKET = r105;
        ExpressNodeType r106 = new ExpressNodeType("RIGHT_BRACKET", 6);
        RIGHT_BRACKET = r106;
        ExpressNodeType r107 = new ExpressNodeType("OPERATOR_COMPARE", 7);
        OPERATOR_COMPARE = r107;
        ExpressNodeType r108 = new ExpressNodeType("OPERATOR_AND", 8);
        OPERATOR_AND = r108;
        ExpressNodeType r109 = new ExpressNodeType("OPERATOR_OR", 9);
        OPERATOR_OR = r109;
        ExpressNodeType r110 = new ExpressNodeType("PARAM", 10);
        PARAM = r110;
        f123088a = new ExpressNodeType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public static ExpressNodeType valueOf(String r100) {
        return (ExpressNodeType) a.a(ExpressNodeType.class, r100);
    }

    public static ExpressNodeType[] values() {
        return (ExpressNodeType[]) f123088a.clone();
    }

    public ExpressNodeType(String r100, int r101) {
        super(r100, r101);
    }
}
