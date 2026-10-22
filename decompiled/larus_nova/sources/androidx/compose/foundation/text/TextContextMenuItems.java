package androidx.compose.foundation.text;

import android.R;
import android.content.res.Resources;
import android.os.Build;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/TextContextMenuItems;", "", "key", "", "stringId", "", "drawableId", "<init>", "(Ljava/lang/String;ILjava/lang/Object;II)V", "getKey", "()Ljava/lang/Object;", "getStringId", "()I", "getDrawableId", "Cut", "Copy", "Paste", "SelectAll", "Autofill", "resolvedString", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "resolveString", "resources", "Landroid/content/res/Resources;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextContextMenuItems extends Enum<TextContextMenuItems> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextContextMenuItems[] $VALUES = null;
    public static final TextContextMenuItems Autofill = null;
    public static final TextContextMenuItems Copy = null;
    public static final TextContextMenuItems Cut = null;
    public static final TextContextMenuItems Paste = null;
    public static final TextContextMenuItems SelectAll = null;
    private final int drawableId;
    private final Object key;
    private final int stringId;

    private static final /* synthetic */ TextContextMenuItems[] $values() {
        return new TextContextMenuItems[]{Cut, Copy, Paste, SelectAll, Autofill};
    }

    public static EnumEntries<TextContextMenuItems> getEntries() {
        return $ENTRIES;
    }

    static {
        TextContextMenuKeys r100 = TextContextMenuKeys.INSTANCE;
        Cut = new TextContextMenuItems("Cut", 0, r100.getCutKey(), R.string.cut, R.attr.actionModeCutDrawable);
        Copy = new TextContextMenuItems("Copy", 1, r100.getCopyKey(), R.string.copy, R.attr.actionModeCopyDrawable);
        Paste = new TextContextMenuItems("Paste", 2, r100.getPasteKey(), R.string.paste, R.attr.actionModePasteDrawable);
        SelectAll = new TextContextMenuItems("SelectAll", 3, r100.getSelectAllKey(), R.string.selectAll, R.attr.actionModeSelectAllDrawable);
        Object r101 = r100.getAutofillKey();
        if (Build.VERSION.SDK_INT > 26) goto L5;
        int r102 = com.larus.nova.R.string.autofill;
    L6:
        Autofill = new TextContextMenuItems("Autofill", 4, r101, r102, 0);
        TextContextMenuItems[] r103 = $values();
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
        return;
    L5:
        r102 = R.string.autofill;
        goto L6
    }

    public static TextContextMenuItems[] values() {
        return (TextContextMenuItems[]) $VALUES.clone();
    }

    public final int getDrawableId() {
        return this.drawableId;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getStringId() {
        return this.stringId;
    }

    public static TextContextMenuItems valueOf(String r100) {
        return (TextContextMenuItems) r27.a.a(TextContextMenuItems.class, r100);
    }

    public final String resolveString(Resources r100) {
        return r100.getString(this.stringId);
    }

    public final String resolvedString(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-309609081, r101, -1, "androidx.compose.foundation.text.TextContextMenuItems.resolvedString (ContextMenu.android.kt:188)");
    L5:
        String r102 = StringResources_androidKt.stringResource(this.stringId, r100, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r102;
    }

    private TextContextMenuItems(String r100, int r101, Object r102, int r103, int r104) {
        super(r100, r101);
        this.key = r102;
        this.stringId = r103;
        this.drawableId = r104;
    }
}
