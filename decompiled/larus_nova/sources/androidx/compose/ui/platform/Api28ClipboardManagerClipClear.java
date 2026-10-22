package androidx.compose.ui.platform;

import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/Api28ClipboardManagerClipClear;", "", "<init>", "()V", "clearPrimaryClip", "", "clipboardManager", "Landroid/content/ClipboardManager;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Api28ClipboardManagerClipClear {
    public static final Api28ClipboardManagerClipClear INSTANCE = null;

    static {
        INSTANCE = new Api28ClipboardManagerClipClear();
    }

    private Api28ClipboardManagerClipClear() {
    }

    private static void androidx_compose_ui_platform_Api28ClipboardManagerClipClear_android_content_ClipboardManager_clearPrimaryClip(android.content.ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101800);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101800, "android/content/ClipboardManager", "clearPrimaryClip", r110, r111, "void", r112);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        r110.clearPrimaryClip();
        return;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @JvmStatic
    public static final void clearPrimaryClip(android.content.ClipboardManager r100) {
        androidx_compose_ui_platform_Api28ClipboardManagerClipClear_android_content_ClipboardManager_clearPrimaryClip(r100);
    }
}
