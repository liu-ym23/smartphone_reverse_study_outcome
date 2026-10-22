package c8;

import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum e {
    LEGACY("$", new b(0), new b(1)),
    JSON_PATH("$", new b(2), new b(3)),
    JSON_POINTER("", new b(4), new b(5)),
    URI_REFERENCE("", new b(6), new b(7));


    /* renamed from: c, reason: collision with root package name */
    public final String f2236c;

    /* renamed from: f, reason: collision with root package name */
    public final BiConsumer f2237f;

    /* renamed from: g, reason: collision with root package name */
    public final BiConsumer f2238g;

    e(String str, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f2236c = str;
        this.f2237f = biConsumer;
        this.f2238g = biConsumer2;
    }

    public static String a(String str) {
        if (str.indexOf(10) != -1) {
            str = str.replace("\n", "\\n");
        }
        if (str.indexOf(9) != -1) {
            str = str.replace("\t", "\\t");
        }
        if (str.indexOf(13) != -1) {
            str = str.replace("\r", "\\r");
        }
        if (str.indexOf(8) != -1) {
            str = str.replace("\b", "\\b");
        }
        return str.indexOf(12) != -1 ? str.replace("\f", "\\f") : str;
    }
}
