package w0;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import s0.t;
import y1.f;

/* renamed from: w0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0969a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f15795c = t.f("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f15796a;

    /* renamed from: b, reason: collision with root package name */
    public final f f15797b;

    public C0969a(Context context, f fVar) {
        this.f15797b = fVar;
        this.f15796a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
