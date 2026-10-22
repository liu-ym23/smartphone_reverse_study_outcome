package androidx.compose.foundation.content;

import D7.v;
import S7.k;
import android.content.ClipData;
import android.content.ClipDescription;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a)\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/content/TransferableContent;", "Lkotlin/Function1;", "Landroid/content/ClipData$Item;", "", "predicate", "consume", "(Landroidx/compose/foundation/content/TransferableContent;LS7/k;)Landroidx/compose/foundation/content/TransferableContent;", "Landroidx/compose/foundation/content/MediaType;", "mediaType", "hasMediaType", "(Landroidx/compose/foundation/content/TransferableContent;Landroidx/compose/foundation/content/MediaType;)Z", "Landroidx/compose/ui/platform/ClipEntry;", "", "readPlainText", "(Landroidx/compose/ui/platform/ClipEntry;)Ljava/lang/String;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransferableContent_androidKt {
    @ExperimentalFoundationApi
    public static final TransferableContent consume(TransferableContent transferableContent, k kVar) {
        ClipData clipData = transferableContent.getClipEntry().getClipData();
        if (clipData.getItemCount() != 1) {
            int itemCount = clipData.getItemCount();
            ArrayList arrayList = null;
            for (int i = 0; i < itemCount; i++) {
                ClipData.Item itemAt = clipData.getItemAt(i);
                if (!((Boolean) kVar.invoke(itemAt)).booleanValue()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(itemAt);
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            if (arrayList.size() != clipData.getItemCount()) {
                ClipDescription clipDescription = new ClipDescription(transferableContent.getClipMetadata().getClipDescription());
                ClipData clipData2 = new ClipData(clipDescription, (ClipData.Item) v.A0(arrayList));
                int size = arrayList.size();
                for (int i6 = 1; i6 < size; i6++) {
                    clipData2.addItem((ClipData.Item) arrayList.get(i6));
                }
                return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(clipData2), AndroidClipboardManager_androidKt.toClipMetadata(clipDescription), transferableContent.getSource(), transferableContent.getPlatformTransferableContent(), null);
            }
        } else if (((Boolean) kVar.invoke(clipData.getItemAt(0))).booleanValue()) {
            return null;
        }
        return transferableContent;
    }

    @ExperimentalFoundationApi
    public static final boolean hasMediaType(TransferableContent transferableContent, MediaType mediaType) {
        return transferableContent.getClipMetadata().getClipDescription().hasMimeType(mediaType.getRepresentation());
    }

    public static final String readPlainText(ClipEntry clipEntry) {
        int itemCount = clipEntry.getClipData().getItemCount();
        boolean z10 = false;
        for (int i = 0; i < itemCount; i++) {
            z10 = z10 || clipEntry.getClipData().getItemAt(i).getText() != null;
        }
        if (!z10) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int itemCount2 = clipEntry.getClipData().getItemCount();
        boolean z11 = false;
        for (int i6 = 0; i6 < itemCount2; i6++) {
            CharSequence text = clipEntry.getClipData().getItemAt(i6).getText();
            if (text != null) {
                if (z11) {
                    sb.append("\n");
                }
                sb.append(text);
                z11 = true;
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
