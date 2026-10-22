package ay7;

import android.content.Context;
import com.ixigua.lib.list.d;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16755a;

    @Override // com.ixigua.lib.list.d
    public final Context a() {
        return this.f16755a;
    }

    public b(Context r100) {
        this.f16755a = r100;
        new ConcurrentHashMap();
    }
}
