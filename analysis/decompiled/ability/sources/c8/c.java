package c8;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
public final class c implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public static final c f2099a = new c();

    @Override // S7.k
    public final Object invoke(Object obj) {
        String string;
        Map.Entry entry = (Map.Entry) obj;
        kotlin.jvm.internal.k.f(entry, "entry");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            string = Arrays.toString((boolean[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof char[]) {
            string = Arrays.toString((char[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof byte[]) {
            string = Arrays.toString((byte[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof short[]) {
            string = Arrays.toString((short[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof int[]) {
            string = Arrays.toString((int[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof float[]) {
            string = Arrays.toString((float[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof long[]) {
            string = Arrays.toString((long[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof double[]) {
            string = Arrays.toString((double[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else if (value instanceof Object[]) {
            string = Arrays.toString((Object[]) value);
            kotlin.jvm.internal.k.e(string, "toString(...)");
        } else {
            string = value.toString();
        }
        return str + '=' + string;
    }
}
