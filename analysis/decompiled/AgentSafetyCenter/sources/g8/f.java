package g8;

import com.fasterxml.jackson.databind.node.JsonNodeType;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f4381a;

    static {
        int[] iArr = new int[JsonNodeType.values().length];
        f4381a = iArr;
        try {
            iArr[JsonNodeType.OBJECT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4381a[JsonNodeType.ARRAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4381a[JsonNodeType.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4381a[JsonNodeType.BINARY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4381a[JsonNodeType.NUMBER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4381a[JsonNodeType.BOOLEAN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4381a[JsonNodeType.NULL.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
