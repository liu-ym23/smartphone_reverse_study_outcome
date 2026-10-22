package org.json;

import B7.a;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes4.dex */
public class JSONWriter {
    private static final int maxdepth = 200;
    private boolean comma = false;
    protected char mode = 'i';
    private final JSONObject[] stack = new JSONObject[200];
    private int top = 0;
    protected Appendable writer;

    public JSONWriter(Appendable appendable) {
        this.writer = appendable;
    }

    private JSONWriter append(String str) throws JSONException, IOException {
        if (str == null) {
            throw new JSONException("Null pointer");
        }
        char c = this.mode;
        if (c != 'o' && c != 'a') {
            throw new JSONException("Value out of sequence.");
        }
        try {
            if (this.comma && c == 'a') {
                this.writer.append(',');
            }
            this.writer.append(str);
            if (this.mode == 'o') {
                this.mode = 'k';
            }
            this.comma = true;
            return this;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    private JSONWriter end(char c, char c2) throws JSONException, IOException {
        if (this.mode != c) {
            throw new JSONException(c == 'a' ? "Misplaced endArray." : "Misplaced endObject.");
        }
        pop(c);
        try {
            this.writer.append(c2);
            this.comma = true;
            return this;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    private void pop(char c) throws JSONException {
        int i = this.top;
        if (i <= 0) {
            throw new JSONException("Nesting error.");
        }
        JSONObject[] jSONObjectArr = this.stack;
        char c2 = 'k';
        if ((jSONObjectArr[i + (-1)] == null ? 'a' : 'k') != c) {
            throw new JSONException("Nesting error.");
        }
        int i6 = i - 1;
        this.top = i6;
        if (i6 == 0) {
            c2 = 'd';
        } else if (jSONObjectArr[i - 2] == null) {
            c2 = 'a';
        }
        this.mode = c2;
    }

    private void push(JSONObject jSONObject) throws JSONException {
        int i = this.top;
        if (i >= 200) {
            throw new JSONException("Nesting too deep.");
        }
        this.stack[i] = jSONObject;
        this.mode = jSONObject == null ? 'a' : 'k';
        this.top = i + 1;
    }

    public static String valueToString(Object obj) throws JSONException {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof JSONString)) {
            if (!(obj instanceof Number)) {
                return ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) ? obj.toString() : obj instanceof Map ? new JSONObject((Map<?, ?>) obj).toString() : obj instanceof Collection ? new JSONArray((Collection<?>) obj).toString() : obj.getClass().isArray() ? new JSONArray(obj).toString() : obj instanceof Enum ? JSONObject.quote(((Enum) obj).name()) : JSONObject.quote(obj.toString());
            }
            String strNumberToString = JSONObject.numberToString((Number) obj);
            return JSONObject.NUMBER_PATTERN.matcher(strNumberToString).matches() ? strNumberToString : JSONObject.quote(strNumberToString);
        }
        try {
            String jSONString = ((JSONString) obj).toJSONString();
            if (jSONString != null) {
                return jSONString;
            }
            throw new JSONException(a.k("Bad value from toJSONString: ", jSONString));
        } catch (Exception e) {
            throw new JSONException(e);
        }
    }

    public JSONWriter array() throws JSONException, IOException {
        char c = this.mode;
        if (c != 'i' && c != 'o' && c != 'a') {
            throw new JSONException("Misplaced array.");
        }
        push(null);
        append("[");
        this.comma = false;
        return this;
    }

    public JSONWriter endArray() throws JSONException {
        return end('a', ']');
    }

    public JSONWriter endObject() throws JSONException {
        return end('k', '}');
    }

    public JSONWriter key(String str) throws JSONException, IOException {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        if (this.mode != 'k') {
            throw new JSONException("Misplaced key.");
        }
        try {
            JSONObject jSONObject = this.stack[this.top - 1];
            if (jSONObject.has(str)) {
                throw new JSONException("Duplicate key \"" + str + "\"");
            }
            jSONObject.put(str, true);
            if (this.comma) {
                this.writer.append(',');
            }
            this.writer.append(JSONObject.quote(str));
            this.writer.append(':');
            this.comma = false;
            this.mode = 'o';
            return this;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONWriter object() throws JSONException, IOException {
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        char c = this.mode;
        if (c != 'o' && c != 'a') {
            throw new JSONException("Misplaced object.");
        }
        append("{");
        push(new JSONObject());
        this.comma = false;
        return this;
    }

    public JSONWriter value(boolean z10) throws JSONException {
        return append(z10 ? "true" : "false");
    }

    public JSONWriter value(double d) throws JSONException {
        return value(Double.valueOf(d));
    }

    public JSONWriter value(long j5) throws JSONException {
        return append(Long.toString(j5));
    }

    public JSONWriter value(Object obj) throws JSONException {
        return append(valueToString(obj));
    }
}
