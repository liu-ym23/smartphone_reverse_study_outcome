package androidx.datastore.preferences.core;

import J0.c;
import J0.d;
import J0.e;
import K0.b;
import M0.a;
import Ua.M;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l9.k;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStoreFactory;", "", "<init>", "()V", "LK0/b;", "LM0/a;", "corruptionHandler", "", "LJ0/c;", "migrations", "LUa/M;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "LJ0/d;", Const.INTENT_KEY_APIKEY, "(LK0/b;Ljava/util/List;LUa/M;Lp9/a;)LJ0/d;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PreferenceDataStoreFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final PreferenceDataStoreFactory f13399a = new PreferenceDataStoreFactory();

    public final d<a> a(b<a> corruptionHandler, List<? extends c<a>> migrations, M scope, final InterfaceC5063a<? extends File> produceFile) {
        p.i(migrations, "migrations");
        p.i(scope, "scope");
        p.i(produceFile, "produceFile");
        return new PreferenceDataStore(e.f3690a.a(M0.d.f4498a, corruptionHandler, migrations, scope, new InterfaceC5063a<File>() { // from class: androidx.datastore.preferences.core.PreferenceDataStoreFactory$create$delegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final File invoke() {
                File fileInvoke = produceFile.invoke();
                String strW = k.w(fileInvoke);
                M0.d dVar = M0.d.f4498a;
                if (p.d(strW, dVar.e())) {
                    return fileInvoke;
                }
                throw new IllegalStateException(("File extension for file: " + fileInvoke + " does not match required extension for Preferences file: " + dVar.e()).toString());
            }
        }));
    }
}
