package androidx.compose.foundation.text.input.internal.selection;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import androidx.compose.ui.platform.Clipboard;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/ClipboardPasteState;", "", DataType.CLIPBOARD, "Landroidx/compose/ui/platform/Clipboard;", "<init>", "(Landroidx/compose/ui/platform/Clipboard;)V", "_hasClip", "", "_hasText", "hasText", "getHasText", "()Z", "hasClip", "getHasClip", "update", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClipboardPasteState {
    public static final int $stable = 8;
    private boolean _hasClip;
    private boolean _hasText;
    private final Clipboard clipboard;

    public final boolean getHasClip() {
        return this._hasClip;
    }

    public final boolean getHasText() {
        return this._hasText;
    }

    public ClipboardPasteState(Clipboard r100) {
        this.clipboard = r100;
    }

    private static ClipDescription androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_getPrimaryClipDescription(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101809);
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
        f06.d r106 = r105.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r110, r111, "android.content.ClipDescription", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (ClipDescription) r106.f474983b;
    L21:
        return r110.getPrimaryClipDescription();
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

    private static boolean androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_hasPrimaryClip(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101805);
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
        f06.d r106 = r105.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r110, r111, "boolean", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Boolean) r106.f474983b).booleanValue();
    L21:
        return r110.hasPrimaryClip();
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

    public final Object update(Continuation<? super Unit> r100) {
        boolean r101 = androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_hasPrimaryClip(this.clipboard.getNativeClipboard());
        this._hasClip = r101;
        boolean r102 = false;
        if (r101 == false) goto L12;
        ClipDescription r103 = androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_getPrimaryClipDescription(this.clipboard.getNativeClipboard());
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L12;
        r102 = true;
        goto L12
    L7:
        if (r103.hasMimeType("text/*") != true) goto L9;
        r104 = true;
    L12:
        this._hasText = r102;
        return Unit.INSTANCE;
    }
}
