package androidx.compose.foundation.text.contextmenu.builder;

import android.view.textclassifier.TextClassification;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f\u001a$\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¨\u0006\u0011"}, d2 = {MapController.ITEM_LAYER_TAG, "", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "key", "", "label", "", "leadingIcon", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ExtensionFunctionType;", "textClassificationItem", "textClassification", "Landroid/view/textclassifier/TextClassification;", "index", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuBuilderScope_androidKt {
    public static final void textClassificationItem(TextContextMenuBuilderScope r100, Object r101, TextClassification r102, int r103) {
        r100.addComponent$foundation_release(new TextContextMenuTextClassificationItem(r101, r102, r103));
    }

    public static final void item(TextContextMenuBuilderScope r100, Object r101, String r102, int r103, Function1<? super TextContextMenuSession, Unit> r104) {
        r100.addComponent$foundation_release(new TextContextMenuItem(r101, r102, r103, r104));
    }

    public static /* synthetic */ void item$default(TextContextMenuBuilderScope r100, Object r101, String r102, int r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L5;
        r103 = 0;
    L5:
        item(r100, r101, r102, r103, r104);
    }
}
