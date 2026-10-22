package com.stepos.stepclaw.base.framework;

import com.stepos.stepclaw.SecurePrefs;
import i5.a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/base/framework/Factory;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "AUTO", "COMPANION_CREATE", "CONSTRUCTOR_WITH_CONTEXT", "CONSTRUCTOR_NO_ARG", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Factory {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ Factory[] $VALUES;
    public static final Factory AUTO = new Factory("AUTO", 0);
    public static final Factory COMPANION_CREATE = new Factory("COMPANION_CREATE", 1);
    public static final Factory CONSTRUCTOR_WITH_CONTEXT = new Factory("CONSTRUCTOR_WITH_CONTEXT", 2);
    public static final Factory CONSTRUCTOR_NO_ARG = new Factory("CONSTRUCTOR_NO_ARG", 3);

    private static final /* synthetic */ Factory[] $values() {
        return new Factory[]{AUTO, COMPANION_CREATE, CONSTRUCTOR_WITH_CONTEXT, CONSTRUCTOR_NO_ARG};
    }

    static {
        Factory[] factoryArr$values = $values();
        $VALUES = factoryArr$values;
        $ENTRIES = a.a.F(factoryArr$values);
    }

    private Factory(String str, int i8) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static Factory valueOf(String str) {
        return (Factory) Enum.valueOf(Factory.class, str);
    }

    public static Factory[] values() {
        return (Factory[]) $VALUES.clone();
    }
}
