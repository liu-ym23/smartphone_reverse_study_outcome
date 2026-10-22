package androidx.datastore.preferences;

import J0.c;
import J0.d;
import K0.b;
import Ua.M;
import android.content.Context;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s9.InterfaceC5452d;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001BI\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n0\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R,\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/datastore/preferences/PreferenceDataStoreSingletonDelegate;", "Ls9/d;", "Landroid/content/Context;", "LJ0/d;", "LM0/a;", "", "name", "LK0/b;", "corruptionHandler", "Lkotlin/Function1;", "", "LJ0/c;", "produceMigrations", "LUa/M;", "scope", "<init>", "(Ljava/lang/String;LK0/b;Lp9/l;LUa/M;)V", "thisRef", "Lw9/k;", "property", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Lw9/k;)LJ0/d;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "Lp9/l;", "c", "LUa/M;", "", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "lock", "e", "LJ0/d;", "INSTANCE", "datastore-preferences_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate implements InterfaceC5452d<Context, d<M0.a>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<Context, List<c<M0.a>>> produceMigrations;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public volatile d<M0.a> INSTANCE;

    /* JADX WARN: Multi-variable type inference failed */
    public PreferenceDataStoreSingletonDelegate(String name, b<M0.a> bVar, InterfaceC5074l<? super Context, ? extends List<? extends c<M0.a>>> produceMigrations, M scope) {
        p.i(name, "name");
        p.i(produceMigrations, "produceMigrations");
        p.i(scope, "scope");
        this.name = name;
        this.produceMigrations = produceMigrations;
        this.scope = scope;
        this.lock = new Object();
    }

    @Override // s9.InterfaceC5452d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d<M0.a> getValue(Context thisRef, InterfaceC5752k<?> property) {
        d<M0.a> dVar;
        p.i(thisRef, "thisRef");
        p.i(property, "property");
        d<M0.a> dVar2 = this.INSTANCE;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    final Context applicationContext = thisRef.getApplicationContext();
                    PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.f13399a;
                    InterfaceC5074l<Context, List<c<M0.a>>> interfaceC5074l = this.produceMigrations;
                    p.h(applicationContext, "applicationContext");
                    this.INSTANCE = preferenceDataStoreFactory.a(null, interfaceC5074l.invoke(applicationContext), this.scope, new InterfaceC5063a<File>() { // from class: androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate$getValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // p9.InterfaceC5063a
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public final File invoke() {
                            Context applicationContext2 = applicationContext;
                            p.h(applicationContext2, "applicationContext");
                            return L0.a.a(applicationContext2, this.name);
                        }
                    });
                }
                dVar = this.INSTANCE;
                p.f(dVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }
}
