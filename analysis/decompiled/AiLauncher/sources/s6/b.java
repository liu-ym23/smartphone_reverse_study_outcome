package s6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.api.IOverlayPageRegistry;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "", "PAGE_ID", "Ljava/lang/String;", "", "registered", "Z", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    private static final String PAGE_ID = "home_space";
    private static boolean registered;

    public static final void a() {
        IOverlayPageRegistry iOverlayPageRegistry;
        if (registered || (iOverlayPageRegistry = (IOverlayPageRegistry) D5.a.INSTANCE.a(IOverlayPageRegistry.class)) == null) {
            return;
        }
        iOverlayPageRegistry.registerPage(new C5445a());
        registered = true;
    }
}
