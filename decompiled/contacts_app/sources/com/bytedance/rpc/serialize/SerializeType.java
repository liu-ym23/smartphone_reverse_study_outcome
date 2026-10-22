package com.bytedance.rpc.serialize;

import com.bytedance.rpc.internal.RpcUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final enum SerializeType extends Enum<SerializeType> {
    private static final /* synthetic */ SerializeType[] $VALUES = null;
    public static final SerializeType FORM = null;
    public static final SerializeType JSON = null;
    public static final SerializeType PB = null;
    public static final SerializeType THRIFT = null;
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = null;
    String mContentType;

    public static SerializeType valueOf(String r1) {
        return (SerializeType) Enum.valueOf(SerializeType.class, r1);
    }

    public static SerializeType[] values() {
        return (SerializeType[]) $VALUES.clone();
    }

    static {
        SerializeType r0 = new SerializeType("JSON", 0, "application/json; charset=utf-8");
        JSON = r0;
        SerializeType r1 = new SerializeType("PB", 1, "application/x-protobuf");
        PB = r1;
        SerializeType r2 = new SerializeType("THRIFT", 2, "application/application/x-thrift");
        THRIFT = r2;
        SerializeType r4 = new SerializeType("FORM", 3, "application/x-www-form-urlencoded; charset=UTF-8");
        FORM = r4;
        $VALUES = new SerializeType[]{r0, r1, r2, r4};
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    }

    private SerializeType(String r1, int r2, String r3) {
        super(r1, r2);
        this.mContentType = r3;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public String[] getTypeAndSubType() {
        return getTypeAndSubType(this.mContentType);
    }

    public static String[] getTypeAndSubType(String r4) {
        Matcher r5 = TYPE_SUBTYPE.matcher(r4);
        if (r5.lookingAt() == false) goto L7;
        return new String[]{r5.group(1).toLowerCase(Locale.US), r5.group(2).toLowerCase(Locale.US)};
    L7:
        return RpcUtils.EMPTY_STR_ARR;
    }

    public static SerializeType parser(String r5) {
        if (RpcUtils.isVisible(r5) == false) goto L10;
        String r6 = r5.toLowerCase(Locale.US);
        SerializeType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        SerializeType r3 = r0[r2];
        if (r3.getContentType().equals(r6) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return r3;
    L14:
        return null;
    L10:
        return null;
    }
}
