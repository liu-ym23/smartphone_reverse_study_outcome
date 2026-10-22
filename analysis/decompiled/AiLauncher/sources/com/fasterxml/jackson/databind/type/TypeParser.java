package com.fasterxml.jackson.databind.type;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
public class TypeParser implements Serializable {
    protected static final int MAX_TYPE_LENGTH = 64000;
    protected static final int MAX_TYPE_NESTING = 1000;
    private static final long serialVersionUID = 1;
    protected final TypeFactory _factory;

    public static final class MyTokenizer extends StringTokenizer {
        protected int _index;
        protected final String _input;
        protected String _pushbackToken;

        public MyTokenizer(String str) {
            super(str, "<,>", true);
            this._input = str;
        }

        public String getAllInput() {
            return this._input;
        }

        public String getRemainingInput() {
            return this._input.substring(this._index);
        }

        @Override // java.util.StringTokenizer
        public boolean hasMoreTokens() {
            return this._pushbackToken != null || super.hasMoreTokens();
        }

        @Override // java.util.StringTokenizer
        public String nextToken() {
            String str = this._pushbackToken;
            if (str != null) {
                this._pushbackToken = null;
                return str;
            }
            String strNextToken = super.nextToken();
            this._index += strNextToken.length();
            return strNextToken.trim();
        }

        public void pushBack(String str) {
            this._pushbackToken = str;
        }
    }

    public TypeParser(TypeFactory typeFactory) {
        this._factory = typeFactory;
    }

    private static String _quoteTruncated(String str) {
        if (str.length() > 1000) {
            return String.format("'%s...'[truncated %d charaters]", str.substring(0, 1000), Integer.valueOf(str.length() - 1000));
        }
        return "'" + str + "'";
    }

    public IllegalArgumentException _problem(MyTokenizer myTokenizer, String str) {
        return new IllegalArgumentException(String.format("Failed to parse type %s (remaining: %s): %s", _quoteTruncated(myTokenizer.getAllInput()), _quoteTruncated(myTokenizer.getRemainingInput()), str));
    }

    public Class<?> findClass(String str, MyTokenizer myTokenizer) {
        try {
            return this._factory.findClass(str);
        } catch (Exception e10) {
            ClassUtil.throwIfRTE(e10);
            throw this._problem(myTokenizer, "Cannot locate class '" + str + "', problem: " + e10.getMessage());
        }
    }

    public JavaType parse(String str) throws IllegalArgumentException {
        if (str.length() > MAX_TYPE_LENGTH) {
            throw new IllegalArgumentException(String.format("Failed to parse type %s: too long (%d characters), maximum length allowed: %d", _quoteTruncated(str), Integer.valueOf(str.length()), Integer.valueOf(MAX_TYPE_LENGTH)));
        }
        MyTokenizer myTokenizer = new MyTokenizer(str.trim());
        JavaType type = parseType(myTokenizer, 1000);
        if (myTokenizer.hasMoreTokens()) {
            throw _problem(myTokenizer, "Unexpected tokens after complete type");
        }
        return type;
    }

    public JavaType parseType(MyTokenizer myTokenizer, int i10) throws IllegalArgumentException {
        if (!myTokenizer.hasMoreTokens()) {
            throw _problem(myTokenizer, "Unexpected end-of-string");
        }
        Class<?> clsFindClass = findClass(myTokenizer.nextToken(), myTokenizer);
        if (myTokenizer.hasMoreTokens()) {
            String strNextToken = myTokenizer.nextToken();
            if ("<".equals(strNextToken)) {
                return this._factory._fromClass(null, clsFindClass, TypeBindings.create(clsFindClass, parseTypes(myTokenizer, i10 - 1)));
            }
            myTokenizer.pushBack(strNextToken);
        }
        return this._factory._fromClass(null, clsFindClass, TypeBindings.emptyBindings());
    }

    public List<JavaType> parseTypes(MyTokenizer myTokenizer, int i10) throws IllegalArgumentException {
        if (i10 < 0) {
            throw _problem(myTokenizer, "too deeply nested; exceeds maximum of 1000 nesting levels");
        }
        ArrayList arrayList = new ArrayList();
        while (myTokenizer.hasMoreTokens()) {
            arrayList.add(parseType(myTokenizer, i10));
            if (!myTokenizer.hasMoreTokens()) {
                break;
            }
            String strNextToken = myTokenizer.nextToken();
            if (">".equals(strNextToken)) {
                return arrayList;
            }
            if (!Const.STR_MART_COMMA.equals(strNextToken)) {
                throw _problem(myTokenizer, "Unexpected token '" + strNextToken + "', expected ',' or '>')");
            }
        }
        throw _problem(myTokenizer, "Unexpected end-of-string");
    }

    public TypeParser withFactory(TypeFactory typeFactory) {
        return typeFactory == this._factory ? this : new TypeParser(typeFactory);
    }
}
