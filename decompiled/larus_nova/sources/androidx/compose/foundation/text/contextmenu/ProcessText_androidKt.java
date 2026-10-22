package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.foundation.text.contextmenu.data.ProcessTextKey;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.ui.text.TextRange;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import p016j.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"addProcessedTextContextMenuItems", "", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "editable", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "addProcessedTextContextMenuItems-UAq72N0", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Landroid/content/Context;ZLjava/lang/CharSequence;J)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProcessText_androidKt {
    public static /* synthetic */ Unit a(Context r100, ResolveInfo r101, boolean r102, CharSequence r103, long r104, TextContextMenuSession r105) {
        return addProcessedTextContextMenuItems_UAq72N0$lambda$1$lambda$0(r100, r101, r102, r103, r104, r105);
    }

    /* JADX INFO: renamed from: addProcessedTextContextMenuItems-UAq72N0, reason: not valid java name */
    public static final void m1167addProcessedTextContextMenuItemsUAq72N0(TextContextMenuBuilderScope r110, final Context r210, final boolean r211, final CharSequence r212, final long r213) {
        if (ComposeFoundationFlags.isSmartSelectionEnabled == true) goto L5;
        return;
    L5:
        if (TextRange.m6992getCollapsedimpl(r213) == true) goto L24;
        int r100 = 0;
        if (r212.length() != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 23) goto L26;
        PackageManager r102 = r210.getPackageManager();
        List<ResolveInfo> r103 = ProcessTextApi23Impl.INSTANCE.queryProcessTextActivities(r210);
        if (r103.isEmpty() == false) goto L17;
        return;
    L17:
        r110.separator();
        int r111 = r103.size();
    L18:
        if (r100 >= r111) goto L20;
        final ResolveInfo r104 = (ResolveInfo) ListProtector.get(r103, r100);
        TextContextMenuBuilderScope_androidKt.item$default(r110, new ProcessTextKey(r100), r104.loadLabel(r102).toString(), 0, new c(r210, r104, r211, r212, r213), 4, null);
        r100 = r100 + 1;
        goto L18
    L20:
        r110.separator();
        return;
    L26:
        return;
    L9:
        r101 = false;
        goto L10
    }

    private static final Unit addProcessedTextContextMenuItems_UAq72N0$lambda$1$lambda$0(Context r100, ResolveInfo r101, boolean r102, CharSequence r110, long r111, TextContextMenuSession r112) {
        ProcessTextApi23Impl.INSTANCE.getOnClickProcessTextItem().invoke(r100, r101, Boolean.valueOf(r102), r110, TextRange.m6986boximpl(r111));
        r112.close();
        return Unit.INSTANCE;
    }
}
