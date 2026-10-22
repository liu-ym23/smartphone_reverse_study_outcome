package f6;

import android.content.Context;
import android.content.SharedPreferences;
import e3.C1417f;
import kotlin.jvm.internal.k;

/* renamed from: f6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1437b {
    public static final C1417f b = new C1417f(7);
    public static volatile C1437b c;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f4440a;

    public C1437b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("TaskRobotPrefs", 0);
        k.e(sharedPreferences, "getSharedPreferences(...)");
        this.f4440a = sharedPreferences;
    }
}
