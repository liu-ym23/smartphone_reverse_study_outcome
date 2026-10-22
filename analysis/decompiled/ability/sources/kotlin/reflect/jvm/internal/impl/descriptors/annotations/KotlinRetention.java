package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class KotlinRetention {

    /* renamed from: a, reason: collision with root package name */
    public static final KotlinRetention f4956a;
    public static final KotlinRetention b;
    public static final KotlinRetention c;
    public static final /* synthetic */ KotlinRetention[] d;

    static {
        KotlinRetention kotlinRetention = new KotlinRetention("RUNTIME", 0);
        f4956a = kotlinRetention;
        KotlinRetention kotlinRetention2 = new KotlinRetention("BINARY", 1);
        b = kotlinRetention2;
        KotlinRetention kotlinRetention3 = new KotlinRetention("SOURCE", 2);
        c = kotlinRetention3;
        KotlinRetention[] kotlinRetentionArr = {kotlinRetention, kotlinRetention2, kotlinRetention3};
        d = kotlinRetentionArr;
        a.a(kotlinRetentionArr);
    }

    public static KotlinRetention valueOf(String str) {
        return (KotlinRetention) Enum.valueOf(KotlinRetention.class, str);
    }

    public static KotlinRetention[] values() {
        return (KotlinRetention[]) d.clone();
    }
}
