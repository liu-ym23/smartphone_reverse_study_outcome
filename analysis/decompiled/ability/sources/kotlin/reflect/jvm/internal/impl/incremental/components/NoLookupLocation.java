package kotlin.reflect.jvm.internal.impl.incremental.components;

import p8.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class NoLookupLocation implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final NoLookupLocation f4986a;
    public static final NoLookupLocation b;
    public static final NoLookupLocation c;
    public static final NoLookupLocation d;
    public static final NoLookupLocation e;
    public static final NoLookupLocation f;
    public static final NoLookupLocation g;
    public static final NoLookupLocation h;
    public static final /* synthetic */ NoLookupLocation[] i;

    static {
        NoLookupLocation noLookupLocation = new NoLookupLocation("FROM_IDE", 0);
        NoLookupLocation noLookupLocation2 = new NoLookupLocation("FROM_BACKEND", 1);
        NoLookupLocation noLookupLocation3 = new NoLookupLocation("FROM_TEST", 2);
        NoLookupLocation noLookupLocation4 = new NoLookupLocation("FROM_BUILTINS", 3);
        f4986a = noLookupLocation4;
        NoLookupLocation noLookupLocation5 = new NoLookupLocation("WHEN_CHECK_DECLARATION_CONFLICTS", 4);
        NoLookupLocation noLookupLocation6 = new NoLookupLocation("WHEN_CHECK_OVERRIDES", 5);
        NoLookupLocation noLookupLocation7 = new NoLookupLocation("FOR_SCRIPT", 6);
        NoLookupLocation noLookupLocation8 = new NoLookupLocation("FROM_REFLECTION", 7);
        b = noLookupLocation8;
        NoLookupLocation noLookupLocation9 = new NoLookupLocation("WHEN_RESOLVE_DECLARATION", 8);
        NoLookupLocation noLookupLocation10 = new NoLookupLocation("WHEN_GET_DECLARATION_SCOPE", 9);
        NoLookupLocation noLookupLocation11 = new NoLookupLocation("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);
        NoLookupLocation noLookupLocation12 = new NoLookupLocation("FOR_ALREADY_TRACKED", 11);
        c = noLookupLocation12;
        NoLookupLocation noLookupLocation13 = new NoLookupLocation("WHEN_GET_ALL_DESCRIPTORS", 12);
        d = noLookupLocation13;
        NoLookupLocation noLookupLocation14 = new NoLookupLocation("WHEN_TYPING", 13);
        NoLookupLocation noLookupLocation15 = new NoLookupLocation("WHEN_GET_SUPER_MEMBERS", 14);
        e = noLookupLocation15;
        NoLookupLocation noLookupLocation16 = new NoLookupLocation("FOR_NON_TRACKED_SCOPE", 15);
        f = noLookupLocation16;
        NoLookupLocation noLookupLocation17 = new NoLookupLocation("FROM_SYNTHETIC_SCOPE", 16);
        NoLookupLocation noLookupLocation18 = new NoLookupLocation("FROM_DESERIALIZATION", 17);
        g = noLookupLocation18;
        NoLookupLocation noLookupLocation19 = new NoLookupLocation("FROM_JAVA_LOADER", 18);
        h = noLookupLocation19;
        NoLookupLocation[] noLookupLocationArr = {noLookupLocation, noLookupLocation2, noLookupLocation3, noLookupLocation4, noLookupLocation5, noLookupLocation6, noLookupLocation7, noLookupLocation8, noLookupLocation9, noLookupLocation10, noLookupLocation11, noLookupLocation12, noLookupLocation13, noLookupLocation14, noLookupLocation15, noLookupLocation16, noLookupLocation17, noLookupLocation18, noLookupLocation19, new NoLookupLocation("WHEN_GET_LOCAL_VARIABLE", 19), new NoLookupLocation("WHEN_FIND_BY_FQNAME", 20), new NoLookupLocation("WHEN_GET_COMPANION_OBJECT", 21), new NoLookupLocation("FOR_DEFAULT_IMPORTS", 22)};
        i = noLookupLocationArr;
        kotlin.enums.a.a(noLookupLocationArr);
    }

    public static NoLookupLocation valueOf(String str) {
        return (NoLookupLocation) Enum.valueOf(NoLookupLocation.class, str);
    }

    public static NoLookupLocation[] values() {
        return (NoLookupLocation[]) i.clone();
    }
}
