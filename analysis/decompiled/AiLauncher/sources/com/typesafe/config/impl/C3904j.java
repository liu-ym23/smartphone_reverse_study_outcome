package com.typesafe.config.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;

/* renamed from: com.typesafe.config.impl.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3904j {
    public static String a(String str, String str2) throws ConfigException {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (char c10 : str.substring(str2.length(), str.length()).toCharArray()) {
            if (c10 == '_') {
                i10++;
            } else {
                if (i10 > 0 && i10 < 4) {
                    sb2.append(j(i10));
                } else if (i10 > 3) {
                    throw new ConfigException.BadPath(str, "Environment variable contains an un-mapped number of underscores.");
                }
                sb2.append(c10);
                i10 = 0;
            }
        }
        if (i10 > 0 && i10 < 4) {
            sb2.append(j(i10));
        } else if (i10 > 3) {
            throw new ConfigException.BadPath(str, "Environment variable contains an un-mapped number of underscores.");
        }
        return sb2.toString();
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null && obj2 != null) {
            return false;
        }
        if (obj != null && obj2 == null) {
            return false;
        }
        if (obj == obj2) {
            return true;
        }
        return obj.equals(obj2);
    }

    public static ConfigException c(ExceptionInInitializerError exceptionInInitializerError) {
        Throwable cause = exceptionInInitializerError.getCause();
        if (cause == null || !(cause instanceof ConfigException)) {
            throw exceptionInInitializerError;
        }
        return (ConfigException) cause;
    }

    public static boolean d(int i10) {
        return i10 >= 0 && i10 <= 31;
    }

    public static boolean e(int i10) {
        if (i10 == 10 || i10 == 32 || i10 == 160 || i10 == 8199 || i10 == 8239 || i10 == 65279) {
            return true;
        }
        return Character.isWhitespace(i10);
    }

    public static b8.k f(ObjectInputStream objectInputStream) throws IOException {
        return SerializedConfigValue.t0(objectInputStream, null);
    }

    public static String g(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\f') {
                sb2.append("\\f");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb2.append("\\b");
                        break;
                    case '\t':
                        sb2.append("\\t");
                        break;
                    case '\n':
                        sb2.append("\\n");
                        break;
                    default:
                        if (d(cCharAt)) {
                            sb2.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            break;
                        } else {
                            sb2.append(cCharAt);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        return sb2.toString();
    }

    public static String h(String str) {
        if (str.length() == 0) {
            return g(str);
        }
        int iCodePointAt = str.codePointAt(0);
        if (Character.isDigit(iCodePointAt) || iCodePointAt == 45) {
            return g(str);
        }
        if (str.startsWith("include") || str.startsWith("true") || str.startsWith("false") || str.startsWith("null") || str.contains("//")) {
            return g(str);
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (!Character.isLetter(cCharAt) && !Character.isDigit(cCharAt) && cCharAt != '-') {
                return g(str);
            }
        }
        return str;
    }

    public static ConfigSyntax i(String str) {
        if (str == null) {
            return null;
        }
        if (str.endsWith(".json")) {
            return ConfigSyntax.JSON;
        }
        if (str.endsWith(".conf")) {
            return ConfigSyntax.CONF;
        }
        if (str.endsWith(".properties")) {
            return ConfigSyntax.PROPERTIES;
        }
        return null;
    }

    public static char j(int i10) {
        if (i10 == 1) {
            return '.';
        }
        if (i10 != 2) {
            return i10 != 3 ? (char) 0 : '_';
        }
        return '-';
    }

    public static String k(String str) {
        int iCodePointAt;
        int i10;
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int iCharCount = 0;
        while (iCharCount < length) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt != ' ' && cCharAt != '\n') {
                int iCodePointAt2 = str.codePointAt(iCharCount);
                if (!e(iCodePointAt2)) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt2);
            } else {
                iCharCount++;
            }
        }
        while (length > iCharCount) {
            int i11 = length - 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 != ' ' && cCharAt2 != '\n') {
                if (Character.isLowSurrogate(cCharAt2)) {
                    iCodePointAt = str.codePointAt(length - 2);
                    i10 = 2;
                } else {
                    iCodePointAt = str.codePointAt(i11);
                    i10 = 1;
                }
                if (!e(iCodePointAt)) {
                    break;
                }
                length -= i10;
            } else {
                length--;
            }
        }
        return str.substring(iCharCount, length);
    }

    public static File l(URL url) {
        try {
            return new File(url.toURI());
        } catch (IllegalArgumentException unused) {
            return new File(url.getPath());
        } catch (URISyntaxException unused2) {
            return new File(url.getPath());
        }
    }

    public static void m(ObjectOutputStream objectOutputStream, b8.k kVar) throws IOException {
        SerializedConfigValue.A0(new DataOutputStream(objectOutputStream), (M) kVar, null);
    }
}
