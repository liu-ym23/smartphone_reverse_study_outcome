package com.google.gson.stream;

import com.android.contacts.common.dialog.CallSubjectDialog;
import com.android.vcard.VCardConstants;

/* JADX INFO: loaded from: classes2.dex */
public final enum JsonToken extends Enum<JsonToken> {
    private static final /* synthetic */ JsonToken[] $VALUES = null;
    public static final JsonToken BEGIN_ARRAY = null;
    public static final JsonToken BEGIN_OBJECT = null;
    public static final JsonToken BOOLEAN = null;
    public static final JsonToken END_ARRAY = null;
    public static final JsonToken END_DOCUMENT = null;
    public static final JsonToken END_OBJECT = null;
    public static final JsonToken NAME = null;
    public static final JsonToken NULL = null;
    public static final JsonToken NUMBER = null;
    public static final JsonToken STRING = null;

    private JsonToken(String r1, int r2) {
        super(r1, r2);
    }

    public static JsonToken valueOf(String r1) {
        return (JsonToken) Enum.valueOf(JsonToken.class, r1);
    }

    public static JsonToken[] values() {
        return (JsonToken[]) $VALUES.clone();
    }

    static {
        JsonToken r0 = new JsonToken("BEGIN_ARRAY", 0);
        BEGIN_ARRAY = r0;
        JsonToken r1 = new JsonToken("END_ARRAY", 1);
        END_ARRAY = r1;
        JsonToken r3 = new JsonToken("BEGIN_OBJECT", 2);
        BEGIN_OBJECT = r3;
        JsonToken r5 = new JsonToken("END_OBJECT", 3);
        END_OBJECT = r5;
        JsonToken r7 = new JsonToken(VCardConstants.PROPERTY_NAME, 4);
        NAME = r7;
        JsonToken r9 = new JsonToken("STRING", 5);
        STRING = r9;
        JsonToken r11 = new JsonToken(CallSubjectDialog.ARG_NUMBER, 6);
        NUMBER = r11;
        JsonToken r13 = new JsonToken("BOOLEAN", 7);
        BOOLEAN = r13;
        JsonToken r15 = new JsonToken("NULL", 8);
        NULL = r15;
        JsonToken r14 = new JsonToken("END_DOCUMENT", 9);
        END_DOCUMENT = r14;
        $VALUES = new JsonToken[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }
}
