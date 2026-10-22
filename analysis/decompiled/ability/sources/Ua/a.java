package Ua;

import android.content.Context;
import com.stepos.ability.R;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f1279a;

    public static a a(Context context) {
        a aVar = new a();
        aVar.f1279a = context;
        return aVar;
    }

    public final int b() {
        return this.f1279a.getResources().getDimensionPixelSize(R.dimen.stepos_action_mode_split_padding);
    }

    public final boolean c() {
        Context context = this.f1279a;
        return context.getApplicationInfo().targetSdkVersion >= 16 ? context.getResources().getBoolean(androidx.appcompat.R.bool.abc_action_bar_embed_tabs) : context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
    }
}
