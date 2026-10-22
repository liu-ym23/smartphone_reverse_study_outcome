package F5;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.stepos.common.widget.SearchEditText;
import kotlin.Result;

/* loaded from: classes3.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f549a;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Handler handler, int i) {
        super(handler);
        this.f549a = i;
        this.b = obj;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        switch (this.f549a) {
            case 0:
                boolean z11 = b.f550a;
                b.a("settings", b.c((ContentResolver) this.b));
                break;
            case 1:
                SearchEditText searchEditText = (SearchEditText) this.b;
                int i = SearchEditText.g;
                searchEditText.a(false);
                break;
            default:
                onChange(z10, null);
                break;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10, Uri uri) {
        switch (this.f549a) {
            case 2:
                com.stepos.ability.permission.cache.b bVar = (com.stepos.ability.permission.cache.b) this.b;
                bVar.getClass();
                P3.c.b("SlaPermMode", "onChange received -> refetch");
                Throwable thA = Result.a(null);
                if (thA != null) {
                    String strH = androidx.constraintlayout.core.dsl.a.h("onChangeListener threw: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE);
                    P3.c.f1086a.invoke(5, "Ability_".concat("SlaPermMode"), strH, thA);
                }
                bVar.c("observer", false, true);
                break;
            default:
                super.onChange(z10, uri);
                break;
        }
    }
}
