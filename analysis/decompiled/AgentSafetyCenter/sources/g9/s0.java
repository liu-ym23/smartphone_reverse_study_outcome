package g9;

import androidx.exifinterface.media.ExifInterface;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: c, reason: collision with root package name */
    public static final s0 f4607c;

    /* renamed from: f, reason: collision with root package name */
    public static final s0 f4608f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ s0[] f4609g;

    static {
        s0 s0Var = new s0(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
        f4607c = s0Var;
        s0 s0Var2 = new s0("B", 1);
        f4608f = s0Var2;
        s0[] s0VarArr = {s0Var, s0Var2, new s0("C", 2)};
        f4609g = s0VarArr;
        a.a.p(s0VarArr);
    }

    public static s0 valueOf(String str) {
        return (s0) Enum.valueOf(s0.class, str);
    }

    public static s0[] values() {
        return (s0[]) f4609g.clone();
    }
}
