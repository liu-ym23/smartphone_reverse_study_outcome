package da;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f8414a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ContentResolver contentResolver, Handler handler) {
        super(handler);
        this.f8414a = contentResolver;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        boolean z3 = b.f8415a;
        b.a("settings", b.f(this.f8414a));
    }
}
