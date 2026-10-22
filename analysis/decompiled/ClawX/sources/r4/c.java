package r4;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f5092a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5093b;

    public c(String content) {
        p.e(content, "content");
        this.f5092a = content;
        int length = content.length();
        int lowerCase = 0;
        for (int i8 = 0; i8 < length; i8++) {
            lowerCase = (lowerCase * 31) + Character.toLowerCase(content.charAt(i8));
        }
        this.f5093b = lowerCase;
    }

    public final boolean equals(Object obj) {
        String str;
        c cVar = obj instanceof c ? (c) obj : null;
        return (cVar == null || (str = cVar.f5092a) == null || !str.equalsIgnoreCase(this.f5092a)) ? false : true;
    }

    public final int hashCode() {
        return this.f5093b;
    }

    public final String toString() {
        return this.f5092a;
    }
}
