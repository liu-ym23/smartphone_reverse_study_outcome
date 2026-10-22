package cb;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import com.stepos.core.model.manager.ModelLoaderImpl;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.install.PreInstallOptions;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3392a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3393b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3394c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3395d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3396e;

    public /* synthetic */ s(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f3392a = i10;
        this.f3393b = obj;
        this.f3394c = obj2;
        this.f3395d = obj3;
        this.f3396e = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3392a) {
            case 0:
                ((ya.f) this.f3393b).onError((Download) this.f3394c, (Error) this.f3395d, (Throwable) this.f3396e);
                break;
            case 1:
                ModelLoaderImpl.loadAsync$lambda$4(null, (String) this.f3393b, (ModelLoaderImpl) this.f3394c, (b7.k) this.f3395d, (Context) this.f3396e);
                break;
            case 2:
                PreInstallModels.scheduleZipExtract$lambda$17((String) this.f3393b, (File) this.f3394c, (PreInstallOptions) this.f3395d, (Context) this.f3396e);
                break;
            default:
                List list = (List) this.f3393b;
                q2.k kVar = (q2.k) this.f3394c;
                androidx.work.a aVar = (androidx.work.a) this.f3395d;
                WorkDatabase workDatabase = (WorkDatabase) this.f3396e;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((i2.h) it.next()).cancel(kVar.f11498a);
                }
                i2.j.b(aVar, workDatabase, list);
                break;
        }
    }
}
