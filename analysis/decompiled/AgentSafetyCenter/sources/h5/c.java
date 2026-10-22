package h5;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ d f5308c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ArrayList f5309f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f5310g;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        d dVar = this.f5308c;
        ArrayList arrayList = this.f5309f;
        String str = this.f5310g;
        WorkDatabase workDatabase = dVar.f5319d;
        arrayList.addAll(workDatabase.D().d(str));
        return workDatabase.C().j(str);
    }
}
