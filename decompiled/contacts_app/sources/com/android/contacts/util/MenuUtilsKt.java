package com.android.contacts.util;

import android.app.Activity;
import android.view.View;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.ttnet.org.chromium.net.NetError;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: MenuUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¨\u0006\t"}, d2 = {"show", "Lcom/obric/oui/popover/OPopover;", "activity", "Landroid/app/Activity;", "anchor", "Landroid/view/View;", "items", "", "Lcom/android/contacts/util/MenuItem;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.obric.oui.popover.OPopover] */
    @Deprecated(message = "use OUIPopoverHelper.showPopupAtAnchorView instead")
    public static final OPopover show(Activity r17, View r18, List<MenuItem> r19) {
        Intrinsics.checkNotNullParameter(r17, "activity");
        Intrinsics.checkNotNullParameter(r18, "anchor");
        Intrinsics.checkNotNullParameter(r19, "items");
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        OPopoverEntranceMenuView.Builder r3 = new OPopoverEntranceMenuView.Builder(r17);
        Iterator<T> r1 = r19.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        final MenuItem r5 = (MenuItem) r1.next();
        OPopoverEntranceMenuView.Builder.addPopoverItem$default(r3, r5.getHeadImageRes(), r5.getTailImageRes(), null, r5.getTitle(), null, null, false, null, new MenuUtilsKt$show$menu$1$1$1(r5, r2), 128, null);
        goto L4
    L6:
        r2.element = new OPopover.Builder(r17).setView(r3.build()).build();
        int r8 = OUnitExtensionKt.dp2px(NetError.ERR_SOCKET_SEND_BUFFER_SIZE_UNCHANGEABLE);
        int r9 = OUnitExtensionKt.dp2px(5);
        OPopover.show$default((OPopover) r2.element, r18, 80, false, OUnitExtensionKt.dp2px(160), r8, r9, false, 64, null);
        return (OPopover) r2.element;
    }
}
