package androidx.compose.ui.text.android;

import android.text.Layout;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/android/TextAlignmentAdapter;", "", "<init>", "()V", "ALIGN_LEFT_FRAMEWORK", "Landroid/text/Layout$Alignment;", "ALIGN_RIGHT_FRAMEWORK", MonitorConstants.CONNECT_TYPE_GET, "value", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextAlignmentAdapter {
    public static final int $stable = 0;
    private static final Layout.Alignment ALIGN_LEFT_FRAMEWORK = null;
    private static final Layout.Alignment ALIGN_RIGHT_FRAMEWORK = null;
    public static final TextAlignmentAdapter INSTANCE = null;

    private TextAlignmentAdapter() {
    }

    static {
        INSTANCE = new TextAlignmentAdapter();
        Layout.Alignment[] r100 = Layout.Alignment.values();
        Layout.Alignment r101 = Layout.Alignment.ALIGN_NORMAL;
        int r102 = r100.length;
        Layout.Alignment r103 = r101;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L11;
        Layout.Alignment r105 = r100[r104];
        if (Intrinsics.areEqual(r105.name(), "ALIGN_LEFT") == false) goto L8;
        r101 = r105;
    L10:
        r104 = r104 + 1;
        goto L3
    L8:
        if (Intrinsics.areEqual(r105.name(), "ALIGN_RIGHT") == false) goto L10;
        r103 = r105;
        goto L10
    L11:
        ALIGN_LEFT_FRAMEWORK = r101;
        ALIGN_RIGHT_FRAMEWORK = r103;
    }

    public final Layout.Alignment get(int r100) {
        if (r100 == 0) goto L17;
        if (r100 == 1) goto L22;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L19;
        return Layout.Alignment.ALIGN_NORMAL;
    L19:
        return ALIGN_RIGHT_FRAMEWORK;
    L20:
        return ALIGN_LEFT_FRAMEWORK;
    L21:
        return Layout.Alignment.ALIGN_CENTER;
    L22:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L17:
        return Layout.Alignment.ALIGN_NORMAL;
    }
}
