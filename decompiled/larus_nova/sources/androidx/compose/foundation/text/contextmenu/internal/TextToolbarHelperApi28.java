package androidx.compose.foundation.text.contextmenu.internal;

import android.R;
import android.app.RemoteAction;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.textclassifier.TextClassification;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.api.creation.TplType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/TextToolbarHelperApi28;", "", "<init>", "()V", "addMenuItem", "", TplType.MENU, "Landroid/view/Menu;", "orderId", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "index", "isPrimary", "", "remoteAction", "Landroid/app/RemoteAction;", "addLegacyMenuItem", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextToolbarHelperApi28 {
    public static final TextToolbarHelperApi28 INSTANCE = null;

    static {
        INSTANCE = new TextToolbarHelperApi28();
    }

    private TextToolbarHelperApi28() {
    }

    public static /* synthetic */ boolean a(Context r100, TextClassification r101, MenuItem r102) {
        return addLegacyMenuItem$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ boolean b(RemoteAction r100, MenuItem r101) {
        return addMenuItem$lambda$0(r100, r101);
    }

    private static final boolean addMenuItem$lambda$0(RemoteAction r100, MenuItem r101) {
        TextClassificationHelperApi28.INSTANCE.sendPendingIntent(r100.getActionIntent());
        return true;
    }

    private static final boolean addLegacyMenuItem$lambda$1(Context r100, TextClassification r101, MenuItem r102) {
        TextClassificationHelperApi28.INSTANCE.sendLegacyIntent(r100, r101);
        return true;
    }

    public final void addLegacyMenuItem(Menu r100, int r101, final Context r102, final TextClassification r103) {
        MenuItem r104 = r100.add(R.id.textAssist, R.id.textAssist, r101, r103.getLabel());
        r104.setShowAsAction(2);
        r104.setIcon(r103.getIcon());
        r104.setOnMenuItemClickListener(new l0(r102, r103));
    }

    public final void addMenuItem(Menu r100, int r101, Context r102, boolean r103, final RemoteAction r104) {
        int r105 = 0;
        if (r103 == false) goto L5;
        int r106 = R.id.textAssist;
    L6:
        MenuItem r107 = r100.add(R.id.textAssist, r106, r101, r104.getTitle());
        if (r103 == false) goto L9;
        r105 = 2;
    L9:
        r107.setShowAsAction(r105);
        if (r103 == false) goto L12;
    L13:
        r107.setIcon(r104.getIcon().loadDrawable(r102));
    L14:
        r107.setOnMenuItemClickListener(new k0(r104));
        return;
    L12:
        if (r104.shouldShowIcon() == false) goto L14;
    L5:
        r106 = 0;
        goto L6
    }

    public final void addMenuItem(Menu r100, int r101, Context r110, TextClassification r111, int r112) {
        if (r112 >= 0) goto L4;
        addLegacyMenuItem(r100, r101, r110, r111);
        return;
    L4:
        if (r112 != 0) goto L6;
        boolean r102 = true;
    L7:
        addMenuItem(r100, r101, r110, r102, (RemoteAction) ListProtector.get(r111.getActions(), r112));
        return;
    L6:
        r102 = false;
        goto L7
    }
}
