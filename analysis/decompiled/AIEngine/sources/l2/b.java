package l2;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.impl.background.systemjob.SystemJobService;
import h2.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final String f10190d = j.f("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f10191a;

    /* renamed from: b, reason: collision with root package name */
    public final b1 f10192b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10193c;

    public b(Context context, b1 b1Var, boolean z) {
        this.f10192b = b1Var;
        this.f10191a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
        this.f10193c = z;
    }
}
