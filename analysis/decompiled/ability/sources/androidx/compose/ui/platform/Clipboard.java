package androidx.compose.ui.platform;

import C7.r;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u00060\tj\u0002`\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/Clipboard;", "", "Landroidx/compose/ui/platform/ClipEntry;", "getClipEntry", "(LH7/c;)Ljava/lang/Object;", "clipEntry", "LC7/r;", "setClipEntry", "(Landroidx/compose/ui/platform/ClipEntry;LH7/c;)Ljava/lang/Object;", "Landroid/content/ClipboardManager;", "Landroidx/compose/ui/platform/NativeClipboard;", "getNativeClipboard", "()Landroid/content/ClipboardManager;", "nativeClipboard", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Clipboard {
    Object getClipEntry(H7.c<? super ClipEntry> cVar);

    android.content.ClipboardManager getNativeClipboard();

    Object setClipEntry(ClipEntry clipEntry, H7.c<? super r> cVar);
}
