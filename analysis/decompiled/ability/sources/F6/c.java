package F6;

import C7.r;
import android.content.Context;
import android.graphics.Paint;
import com.stepos.ability.R;
import com.stepos.ability.voicewakeup.service.l;
import com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;
import com.stepos.widget.list.StepOSListItem;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f585a;
    public final /* synthetic */ Context b;

    public /* synthetic */ c(Context context, int i) {
        this.f585a = i;
        this.b = context;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f585a;
        Context context = this.b;
        switch (i) {
            case 0:
                int[] iArr = StepOSListItem.b0;
                Paint paint = new Paint();
                paint.setColor(context.getColor(R.color.stepos_list_item_swipe_overlay));
                return paint;
            case 1:
                l.n = context.getApplicationContext();
                Context applicationContext = context.getApplicationContext();
                k.e(applicationContext, "getApplicationContext(...)");
                l.o = new E4.e(applicationContext);
                if (l.p == null) {
                    l.p = new C4.a(context);
                }
                return r.f317a;
            case 2:
                return MockWhitelistRemoteSource._init_$lambda$0(context);
            default:
                return WhitelistCacheManager.Companion.create$lambda$0(context);
        }
    }
}
