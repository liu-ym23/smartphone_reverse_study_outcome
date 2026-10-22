package fe;

import android.content.Context;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f8850a;

    public static a a(Context context) {
        a aVar = new a();
        aVar.f8850a = context;
        return aVar;
    }

    public final int b() {
        return this.f8850a.getResources().getDimensionPixelSize(R.dimen.stepos_action_mode_split_padding);
    }

    public final boolean c() {
        Context context = this.f8850a;
        return context.getApplicationInfo().targetSdkVersion >= 16 ? context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs) : context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
    }
}
