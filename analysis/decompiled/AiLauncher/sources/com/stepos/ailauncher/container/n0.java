package com.stepos.ailauncher.container;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/container/n0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", "wallpaperMainColor", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;I)I", "", "c", "(Landroid/content/Context;)Z", "", "TAG", "Ljava/lang/String;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n0 {
    public static final n0 INSTANCE = new n0();
    public static final String TAG = "OverlayThemeUtils";

    public final int a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        int iD = com.stepos.ailauncher.container.wallpaper.e.b().d();
        C4148a.d(TAG, "getActivityThemeRes wallpaperMainColor == " + iD, false, 4, null);
        return b(context, iD);
    }

    public final int b(Context context, int wallpaperMainColor) {
        kotlin.jvm.internal.p.i(context, "context");
        boolean z10 = wallpaperMainColor == -1;
        return c(context) ? z10 ? R$style.AppTheme_SystemDark_WallpaperDark : R$style.AppTheme_SystemDark_WallpaperLight : z10 ? R$style.AppTheme_WallpaperDark : R$style.AppTheme_WallpaperLight;
    }

    public final boolean c(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
