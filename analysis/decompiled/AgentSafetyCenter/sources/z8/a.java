package z8;

import java.util.Set;
import kb.k;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final z4.b f16483c;

    /* renamed from: f, reason: collision with root package name */
    public static final Set f16484f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set f16485g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f16486h;
    public static final a i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f16487j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ a[] f16488k;

    static {
        a aVar = new a("Normal", 0);
        f16486h = aVar;
        a aVar2 = new a("Intercepted", 1);
        i = aVar2;
        a aVar3 = new a("InterceptedPending", 2);
        f16487j = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f16488k = aVarArr;
        a.a.p(aVarArr);
        f16483c = new z4.b();
        f16484f = k.v0(new String[]{"normal", "intercepted", "intercepted_pending"});
        f16485g = k.v0(new String[]{"undo_eligible", "undo_revoked"});
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f16488k.clone();
    }
}
