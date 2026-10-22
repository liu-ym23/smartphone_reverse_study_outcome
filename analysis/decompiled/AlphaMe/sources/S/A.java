package S;

import android.content.Context;
import androidx.lifecycle.C0314k;
import androidx.lifecycle.g0;
import androidx.lifecycle.j0;
import androidx.lifecycle.u0;
import b3.InterfaceC0379h;
import d.C0527a;
import java.io.File;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import l0.C0753g;
import l0.C0754h;

/* loaded from: classes.dex */
public final class A extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1661a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1662b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(int i4, Object obj) {
        super(0);
        this.f1661a = i4;
        this.f1662b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0753g sQLiteOpenHelper;
        switch (this.f1661a) {
            case 0:
                File file = (File) ((M) this.f1662b).f1726a.invoke();
                String it = file.getAbsolutePath();
                synchronized (M.f1725k) {
                    LinkedHashSet linkedHashSet = M.f1724j;
                    if (!(!linkedHashSet.contains(it))) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    linkedHashSet.add(it);
                }
                return file;
            case 1:
                ((C0314k) this.f1662b).f3958m = null;
                return Unit.INSTANCE;
            case 2:
                u0 u0Var = (u0) this.f1662b;
                Intrinsics.checkNotNullParameter(u0Var, "<this>");
                return (j0) new android.support.v4.media.session.c(u0Var, new g0()).f(j0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
            case 3:
                androidx.room.G g4 = (androidx.room.G) this.f1662b;
                return g4.database.compileStatement(g4.createQuery());
            case 4:
                C0754h c0754h = (C0754h) this.f1662b;
                if (c0754h.f13446b == null || !c0754h.f13448d) {
                    sQLiteOpenHelper = new C0753g(c0754h.f13445a, c0754h.f13446b, new C0527a(29, null), c0754h.f13447c, c0754h.f13449e);
                } else {
                    Context context = c0754h.f13445a;
                    Intrinsics.checkNotNullParameter(context, "context");
                    File noBackupFilesDir = context.getNoBackupFilesDir();
                    Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "context.noBackupFilesDir");
                    sQLiteOpenHelper = new C0753g(c0754h.f13445a, new File(noBackupFilesDir, c0754h.f13446b).getAbsolutePath(), new C0527a(29, null), c0754h.f13447c, c0754h.f13449e);
                }
                boolean z4 = c0754h.f13451g;
                Intrinsics.checkNotNullParameter(sQLiteOpenHelper, "sQLiteOpenHelper");
                sQLiteOpenHelper.setWriteAheadLoggingEnabled(z4);
                return sQLiteOpenHelper;
            default:
                return new x0.c[((InterfaceC0379h[]) this.f1662b).length];
        }
    }
}
