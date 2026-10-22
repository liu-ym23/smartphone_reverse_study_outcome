package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import g3.l;
import g3.m;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import q7.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: f, reason: collision with root package name */
    public int f1044f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f1045g = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final m f1046h = new m(this);

    /* renamed from: i, reason: collision with root package name */
    public final l f1047i = new l(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        k.e(intent, "intent");
        return this.f1047i;
    }
}
