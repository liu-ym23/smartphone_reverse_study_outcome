package E3;

import com.fasterxml.jackson.databind.node.JsonNodeType;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f467a;

    static {
        int[] iArr = new int[JsonNodeType.values().length];
        f467a = iArr;
        try {
            iArr[JsonNodeType.OBJECT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f467a[JsonNodeType.ARRAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f467a[JsonNodeType.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f467a[JsonNodeType.BINARY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f467a[JsonNodeType.NUMBER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f467a[JsonNodeType.BOOLEAN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f467a[JsonNodeType.NULL.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
