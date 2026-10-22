package androidx.datastore.preferences;

import J0.c;
import J0.d;
import K0.b;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Z8.C1173v;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import s9.InterfaceC5452d;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00070\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", "name", "LK0/b;", "LM0/a;", "corruptionHandler", "Lkotlin/Function1;", "Landroid/content/Context;", "", "LJ0/c;", "produceMigrations", "LUa/M;", "scope", "Ls9/d;", "LJ0/d;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;LK0/b;Lp9/l;LUa/M;)Ls9/d;", "datastore-preferences_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PreferenceDataStoreDelegateKt {
    public static final InterfaceC5452d<Context, d<M0.a>> a(String name, b<M0.a> bVar, InterfaceC5074l<? super Context, ? extends List<? extends c<M0.a>>> produceMigrations, M scope) {
        p.i(name, "name");
        p.i(produceMigrations, "produceMigrations");
        p.i(scope, "scope");
        return new PreferenceDataStoreSingletonDelegate(name, bVar, produceMigrations, scope);
    }

    public static /* synthetic */ InterfaceC5452d b(String str, b bVar, InterfaceC5074l interfaceC5074l, M m10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l<Context, List<? extends c<M0.a>>>() { // from class: androidx.datastore.preferences.PreferenceDataStoreDelegateKt$preferencesDataStore$1
                @Override // p9.InterfaceC5074l
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final List<c<M0.a>> invoke(Context it) {
                    p.i(it, "it");
                    return C1173v.m();
                }
            };
        }
        if ((i10 & 8) != 0) {
            m10 = kotlinx.coroutines.d.a(Y.b().plus(L0.b(null, 1, null)));
        }
        return a(str, bVar, interfaceC5074l, m10);
    }
}
