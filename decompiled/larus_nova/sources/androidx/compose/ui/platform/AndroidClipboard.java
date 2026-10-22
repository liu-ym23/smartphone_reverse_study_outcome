package androidx.compose.ui.platform;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\u00060\u0011j\u0002`\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidClipboard;", "Landroidx/compose/ui/platform/Clipboard;", "androidClipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "<init>", "(Landroidx/compose/ui/platform/AndroidClipboardManager;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getClipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setClipEntry", "", "clipEntry", "(Landroidx/compose/ui/platform/ClipEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nativeClipboard", "Landroid/content/ClipboardManager;", "Landroidx/compose/ui/platform/NativeClipboard;", "getNativeClipboard", "()Landroid/content/ClipboardManager;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidClipboard implements Clipboard {
    public static final int $stable = 8;
    private final AndroidClipboardManager androidClipboardManager;

    @Override // androidx.compose.ui.platform.Clipboard
    public android.content.ClipboardManager getNativeClipboard() {
        return this.androidClipboardManager.getNativeClipboard();
    }

    public AndroidClipboard(Context r100) {
        this(new AndroidClipboardManager(r100));
    }

    @Override // androidx.compose.ui.platform.Clipboard
    public Object getClipEntry(Continuation<? super ClipEntry> r100) {
        return this.androidClipboardManager.getClip();
    }

    public AndroidClipboard(AndroidClipboardManager r100) {
        this.androidClipboardManager = r100;
    }

    @Override // androidx.compose.ui.platform.Clipboard
    public Object setClipEntry(ClipEntry r100, Continuation<? super Unit> r101) {
        this.androidClipboardManager.setClip(r100);
        return Unit.INSTANCE;
    }
}
