package androidx.compose.foundation.content;

import android.content.ClipData;
import android.content.ClipDescription;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"consume", "Landroidx/compose/foundation/content/TransferableContent;", "predicate", "Lkotlin/Function1;", "Landroid/content/ClipData$Item;", "", "hasMediaType", "mediaType", "Landroidx/compose/foundation/content/MediaType;", "readPlainText", "", "Landroidx/compose/ui/platform/ClipEntry;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransferableContent_androidKt {
    public static final String readPlainText(ClipEntry r100) {
        int r101 = r100.getClipData().getItemCount();
        int r102 = 0;
        int r103 = 0;
        boolean r104 = false;
    L4:
        if (r103 >= r101) goto L12;
        if (r104 == false) goto L7;
    L10:
        r104 = true;
    L11:
        r103 = r103 + 1;
        goto L4
    L7:
        if (r100.getClipData().getItemAt(r103).getText() != null) goto L10;
        r104 = false;
        goto L11
    L12:
        if (r104 == false) goto L22;
        StringBuilder r105 = new StringBuilder();
        int r106 = r100.getClipData().getItemCount();
        boolean r107 = false;
    L14:
        if (r102 >= r106) goto L30;
        CharSequence r108 = r100.getClipData().getItemAt(r102).getText();
        if (r108 == null) goto L20;
        if (r107 == false) goto L19;
        r105.append("\n");
    L19:
        r105.append(r108);
        r107 = true;
    L20:
        r102 = r102 + 1;
        goto L14
    L30:
        return r105.toString();
    L22:
        return null;
    }

    public static final TransferableContent consume(TransferableContent r110, Function1<? super ClipData.Item, Boolean> r111) {
        ClipData r100 = r110.getClipEntry().getClipData();
        boolean r101 = false;
        int r102 = 1;
        if (r100.getItemCount() == 1) goto L5;
        int r103 = r100.getItemCount();
        ArrayList r104 = null;
        int r105 = 0;
    L10:
        if (r105 >= r103) goto L17;
        ClipData.Item r106 = r100.getItemAt(r105);
        if (r111.invoke(r106).booleanValue() == true) goto L16;
        if (r104 != null) goto L15;
        r104 = new ArrayList();
    L15:
        r104.add(r106);
    L16:
        r105 = r105 + 1;
        goto L10
    L17:
        if (r104 != null) goto L19;
    L20:
        r101 = true;
    L21:
        if (r101 == false) goto L24;
        return null;
    L24:
        if (r104.size() != r100.getItemCount()) goto L26;
        return r110;
    L26:
        ClipDescription r112 = new ClipDescription(r110.getClipMetadata().getClipDescription());
        ClipData r107 = new ClipData(r112, (ClipData.Item) CollectionsKt.first(r104));
        int r108 = r104.size();
    L27:
        if (r102 >= r108) goto L30;
        r107.addItem((ClipData.Item) ListProtector.get(r104, r102));
        r102 = r102 + 1;
        goto L27
    L30:
        return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(r107), AndroidClipboardManager_androidKt.toClipMetadata(r112), r110.m323getSourcekB6V9T0(), r110.getPlatformTransferableContent(), null);
    L19:
        if (r104.isEmpty() == false) goto L21;
    L5:
        if ((!r111.invoke(r100.getItemAt(0)).booleanValue()) == false) goto L8;
        return r110;
    L8:
        return null;
    }

    public static final boolean hasMediaType(TransferableContent r100, MediaType r101) {
        return r100.getClipMetadata().getClipDescription().hasMimeType(r101.getRepresentation());
    }
}
