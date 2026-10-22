package j;

import X.ThreadFactoryC0110a;
import android.content.Context;
import android.content.res.Configuration;
import com.stepos.alphame.R;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: j.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0622a implements X.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13045a;

    /* renamed from: b, reason: collision with root package name */
    public Context f13046b;

    public /* synthetic */ C0622a(int i4) {
        this.f13045a = i4;
        this.f13046b = null;
    }

    public static C0622a c(Context context) {
        return new C0622a(context, 5);
    }

    @Override // X.i
    public final void a(B0.f fVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0110a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new X.l(0, this, fVar, threadPoolExecutor));
    }

    public final boolean b() {
        switch (this.f13045a) {
            case 0:
                if (this.f13046b.getApplicationInfo().targetSdkVersion < 14) {
                    break;
                }
                break;
            default:
                if (this.f13046b.getApplicationInfo().targetSdkVersion < 14) {
                    break;
                }
                break;
        }
        return true;
    }

    public final int d() {
        switch (this.f13045a) {
        }
        return this.f13046b.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public final int e() {
        switch (this.f13045a) {
            case 0:
                Configuration configuration = this.f13046b.getResources().getConfiguration();
                int i4 = configuration.screenWidthDp;
                int i5 = configuration.screenHeightDp;
                if (configuration.smallestScreenWidthDp > 600 || i4 > 600 || ((i4 > 960 && i5 > 720) || (i4 > 720 && i5 > 960))) {
                    return 5;
                }
                if (i4 >= 500 || ((i4 > 640 && i5 > 480) || (i4 > 480 && i5 > 640))) {
                    return 4;
                }
                return i4 >= 360 ? 3 : 2;
            default:
                return this.f13046b.getResources().getInteger(R.integer.abc_max_action_buttons);
        }
    }

    public final int f() {
        return this.f13046b.getResources().getDimensionPixelSize(R.dimen.stepos_action_mode_split_padding);
    }

    public final boolean g() {
        switch (this.f13045a) {
            case 0:
                return this.f13046b.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
            default:
                return this.f13046b.getApplicationInfo().targetSdkVersion >= 16 ? this.f13046b.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs) : this.f13046b.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
        }
    }

    public /* synthetic */ C0622a(Context context, int i4) {
        this.f13045a = i4;
        this.f13046b = context;
    }

    public C0622a(Context context) {
        this.f13045a = 1;
        this.f13046b = context.getApplicationContext();
    }
}
