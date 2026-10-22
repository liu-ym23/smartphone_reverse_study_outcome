package z5;

import android.content.res.Configuration;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lz5/b;", "", "<init>", "()V", "", "fontScale", "Landroid/content/res/Configuration;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Float;)Landroid/content/res/Configuration;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, Const.INTENT_KEY_APIKEY, "(F)Landroid/content/res/Configuration;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6362b {
    public static final C6362b INSTANCE = new C6362b();

    public final Configuration a(float scale) {
        Configuration configuration = new Configuration();
        configuration.fontScale = scale;
        return configuration;
    }

    public final Configuration b(Float fontScale) {
        Configuration configuration = new Configuration();
        configuration.uiMode = 32;
        if (fontScale != null) {
            configuration.fontScale = fontScale.floatValue();
        }
        return configuration;
    }
}
