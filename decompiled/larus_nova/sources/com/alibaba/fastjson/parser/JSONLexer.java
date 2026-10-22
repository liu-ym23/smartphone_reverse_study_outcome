package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes28.dex */
public interface JSONLexer {
    public static final int ARRAY = 2;
    public static final int END = 4;
    public static final char EOI = 26;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int OBJECT = 1;
    public static final int UNKNOWN = 0;
    public static final int VALUE = 3;
    public static final int VALUE_NULL = 5;

    byte[] bytesValue();

    void close();

    void config(Feature r100, boolean r101);

    Number decimalValue(boolean r100);

    BigDecimal decimalValue();

    float floatValue();

    char getCurrent();

    int getFeatures();

    Locale getLocale();

    TimeZone getTimeZone();

    String info();

    int intValue();

    Number integerValue();

    boolean isBlankInput();

    boolean isEnabled(int r100);

    boolean isEnabled(Feature r100);

    boolean isRef();

    long longValue();

    char next();

    void nextToken();

    void nextToken(int r100);

    void nextTokenWithColon();

    void nextTokenWithColon(int r100);

    String numberString();

    int pos();

    void resetStringPosition();

    boolean scanBoolean(char r100);

    BigDecimal scanDecimal(char r100);

    double scanDouble(char r100);

    Enum<?> scanEnum(Class<?> r100, SymbolTable r101, char r102);

    float scanFloat(char r100);

    int scanInt(char r100);

    long scanLong(char r100);

    void scanNumber();

    String scanString(char r100);

    void scanString();

    void scanStringArray(Collection<String> r100, char r101);

    String scanSymbol(SymbolTable r100);

    String scanSymbol(SymbolTable r100, char r101);

    String scanSymbolUnQuoted(SymbolTable r100);

    String scanSymbolWithSeperator(SymbolTable r100, char r101);

    String scanTypeName(SymbolTable r100);

    void setFeatures(int r100);

    void setLocale(Locale r100);

    void setTimeZone(TimeZone r100);

    void skipWhitespace();

    String stringVal();

    int token();

    String tokenName();
}
