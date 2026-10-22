package kotlin.reflect.jvm.internal;

/* JADX INFO: loaded from: classes4.dex */
class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> r0, String r1) {
        return Enum.valueOf(r0, r1);
    }
}
