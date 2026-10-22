package org.json;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;

/* loaded from: classes4.dex */
public class CDL {
    private static String getValue(JSONTokener jSONTokener, char c) throws JSONException, IOException {
        char next;
        char next2;
        while (true) {
            next = jSONTokener.next();
            if (next != ' ' && next != '\t') {
                break;
            }
        }
        if (next == 0) {
            return null;
        }
        if (next != '\"' && next != '\'') {
            if (next == c) {
                jSONTokener.back();
                return "";
            }
            jSONTokener.back();
            return jSONTokener.nextTo(c);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            char next3 = jSONTokener.next();
            if (next3 == next && (next2 = jSONTokener.next()) != '\"') {
                if (next2 > 0) {
                    jSONTokener.back();
                }
                return sb.toString();
            }
            if (next3 == 0 || next3 == '\n' || next3 == '\r') {
                break;
            }
            sb.append(next3);
        }
        throw jSONTokener.syntaxError("Missing close quote '" + next + "'.");
    }

    public static JSONArray rowToJSONArray(JSONTokener jSONTokener) throws JSONException {
        return rowToJSONArray(jSONTokener, ',');
    }

    public static JSONObject rowToJSONObject(JSONArray jSONArray, JSONTokener jSONTokener) throws JSONException {
        return rowToJSONObject(jSONArray, jSONTokener, ',');
    }

    public static String rowToString(JSONArray jSONArray) {
        return rowToString(jSONArray, ',');
    }

    public static JSONArray toJSONArray(String str) throws JSONException {
        return toJSONArray(str, ',');
    }

    public static String toString(JSONArray jSONArray) throws JSONException {
        return toString(jSONArray, ',');
    }

    public static JSONArray rowToJSONArray(JSONTokener jSONTokener, char c) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String value = getValue(jSONTokener, c);
            char next = jSONTokener.next();
            if (value == null) {
                return null;
            }
            if (jSONArray.length() == 0 && value.length() == 0 && next != c) {
                return null;
            }
            jSONArray.put(value);
            while (next != c) {
                if (next != ' ') {
                    if (next == '\n' || next == '\r' || next == 0) {
                        return jSONArray;
                    }
                    throw jSONTokener.syntaxError("Bad character '" + next + "' (" + ((int) next) + ").");
                }
                next = jSONTokener.next();
            }
        }
    }

    public static JSONObject rowToJSONObject(JSONArray jSONArray, JSONTokener jSONTokener, char c) throws JSONException, IOException {
        JSONArray jSONArrayRowToJSONArray = rowToJSONArray(jSONTokener, c);
        if (jSONArrayRowToJSONArray != null) {
            return jSONArrayRowToJSONArray.toJSONObject(jSONArray);
        }
        return null;
    }

    public static String rowToString(JSONArray jSONArray, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                sb.append(c);
            }
            Object objOpt = jSONArray.opt(i);
            if (objOpt != null) {
                String string = objOpt.toString();
                if (string.length() <= 0 || (string.indexOf(c) < 0 && string.indexOf(10) < 0 && string.indexOf(13) < 0 && string.indexOf(0) < 0 && string.charAt(0) != '\"')) {
                    sb.append(string);
                } else {
                    sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    int length = string.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        char cCharAt = string.charAt(i6);
                        if (cCharAt >= ' ' && cCharAt != '\"') {
                            sb.append(cCharAt);
                        }
                    }
                    sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                }
            }
        }
        sb.append('\n');
        return sb.toString();
    }

    public static JSONArray toJSONArray(String str, char c) throws JSONException {
        return toJSONArray(new JSONTokener(str), c);
    }

    public static String toString(JSONArray jSONArray, char c) throws JSONException {
        JSONArray jSONArrayNames;
        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null || (jSONArrayNames = jSONObjectOptJSONObject.names()) == null) {
            return null;
        }
        return rowToString(jSONArrayNames, c) + toString(jSONArrayNames, jSONArray, c);
    }

    public static JSONArray toJSONArray(JSONTokener jSONTokener) throws JSONException {
        return toJSONArray(jSONTokener, ',');
    }

    public static JSONArray toJSONArray(JSONTokener jSONTokener, char c) throws JSONException {
        return toJSONArray(rowToJSONArray(jSONTokener, c), jSONTokener, c);
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, String str) throws JSONException {
        return toJSONArray(jSONArray, str, ',');
    }

    public static String toString(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        return toString(jSONArray, jSONArray2, ',');
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, String str, char c) throws JSONException {
        return toJSONArray(jSONArray, new JSONTokener(str), c);
    }

    public static String toString(JSONArray jSONArray, JSONArray jSONArray2, char c) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray2.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                sb.append(rowToString(jSONObjectOptJSONObject.toJSONArray(jSONArray), c));
            }
        }
        return sb.toString();
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, JSONTokener jSONTokener) throws JSONException {
        return toJSONArray(jSONArray, jSONTokener, ',');
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, JSONTokener jSONTokener, char c) throws JSONException, IOException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        while (true) {
            JSONObject jSONObjectRowToJSONObject = rowToJSONObject(jSONArray, jSONTokener, c);
            if (jSONObjectRowToJSONObject == null) {
                break;
            }
            jSONArray2.put(jSONObjectRowToJSONObject);
        }
        if (jSONArray2.length() == 0) {
            return null;
        }
        return jSONArray2;
    }
}
