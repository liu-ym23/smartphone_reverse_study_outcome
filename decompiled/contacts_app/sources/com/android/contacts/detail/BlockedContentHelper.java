package com.android.contacts.detail;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.calllog.blocked.repo.BlockedDataRequester;
import com.android.contacts.detail.item.button.ContactItemButtonCard;
import com.android.contacts.util.OAlertDialogUtils;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.toast.OToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockedContentHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J¿\u0001\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\r\u001a\u00020\u000e2y\u0010\u001f\u001au\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0 J\u0018\u0010&\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010'\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0004H\u0002J \u0010)\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/contacts/detail/BlockedContentHelper;", "", "()V", "hasQueriedWhiteList", "", "inWhiteListBtn", "mInWhiteList", "mInterceptType", "", "mIsInBlockList", "mNumberMainMarkClassify", "insertWhitelist", "", "contentResolver", "Landroid/content/ContentResolver;", "phoneNumber", "", "blockedCallTextView", "Landroid/widget/TextView;", "blockedCallBtn", "Landroid/view/View;", "showWhiteListSheet", "activity", "Landroid/app/Activity;", "toastAddToWhiteList", "toastRemoveFromBlackList", "tryUpdateBlockedCallBtn", "interceptType", "numberMainMarkClassify", "isInBlockList", "Lcom/android/contacts/detail/item/button/ContactItemButtonCard;", "onClick", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "inBlackList", "isMarked", "inWhiteList", "updateBlockedCallBtn", "updateBlockedCallBtnByBlocked", "inBlockList", "updateBlockedCallBtnInWhiteList", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockedContentHelper {
    private boolean hasQueriedWhiteList;
    private boolean inWhiteListBtn;
    private boolean mInWhiteList;
    private int mInterceptType;
    private boolean mIsInBlockList;
    private int mNumberMainMarkClassify;

    public static /* synthetic */ void $r8$lambda$wWPcWGAXr21md4Nd2eUyfiOcsyU(BlockedContentHelper r0, Activity r1, String r2, TextView r3, View r4, DialogInterface r5, int r6) {
        showWhiteListSheet$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$zjP1dATYWuoMv7cuFbEo25UzuE8(Function5 r0, BlockedContentHelper r1, TextView r2, ContactItemButtonCard r3, View r4) {
        tryUpdateBlockedCallBtn$lambda$0(r0, r1, r2, r3, r4);
    }

    public BlockedContentHelper() {
    }

    public static final /* synthetic */ void access$setMInWhiteList$p(BlockedContentHelper r0, boolean r1) {
        r0.mInWhiteList = r1;
    }

    public static final /* synthetic */ void access$updateBlockedCallBtn(BlockedContentHelper r0, View r1, TextView r2) {
        r0.updateBlockedCallBtn(r1, r2);
    }

    public final void tryUpdateBlockedCallBtn(int r3, int r4, boolean r5, String r6, final TextView r7, final ContactItemButtonCard r8, ContentResolver r9, final Function5<? super Boolean, ? super Boolean, ? super Boolean, ? super TextView, ? super View, Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "contentResolver");
        Intrinsics.checkNotNullParameter(r10, "onClick");
        if (r3 > 0) goto L5;
        return;
    L5:
        String r0 = r6;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        if (r8 == null) goto L29;
        if (r7 != null) goto L18;
        return;
    L18:
        if (this.mInterceptType == r3) goto L20;
    L24:
        this.mInterceptType = r3;
        this.mNumberMainMarkClassify = r4;
        this.mIsInBlockList = r5;
        r8.setOnContentClickListener(new BlockedContentHelper$$ExternalSyntheticLambda0(r10, this, r7, r8));
        if (this.hasQueriedWhiteList == true) goto L27;
        this.hasQueriedWhiteList = true;
        BlockedDataRequester.INSTANCE.queryIsPhoneNumberInWhiteListWithCallback(r9, r6, new AnonymousClass2(this, r8, r7));
        return;
    L27:
        updateBlockedCallBtn(r8, r7);
        return;
    L20:
        if (this.mNumberMainMarkClassify != r4) goto L24;
        if (this.mIsInBlockList != r5) goto L24;
        return;
    L29:
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    private static final void tryUpdateBlockedCallBtn$lambda$0(Function5 r6, BlockedContentHelper r7, TextView r8, ContactItemButtonCard r9, View r10) {
        Intrinsics.checkNotNullParameter(r6, "$onClick");
        Intrinsics.checkNotNullParameter(r7, "this$0");
        Boolean r1 = Boolean.valueOf(r7.mIsInBlockList);
        if (r7.mNumberMainMarkClassify <= 0) goto L5;
        boolean r11 = true;
    L6:
        r6.invoke(r1, Boolean.valueOf(r11), Boolean.valueOf(r7.mInWhiteList), r8, r9);
        return;
    L5:
        r11 = false;
        goto L6
    }

    private final void updateBlockedCallBtn(View r2, TextView r3) {
        if (this.mNumberMainMarkClassify <= 0) goto L5;
    L6:
        this.inWhiteListBtn = true;
    L8:
        if (this.inWhiteListBtn == false) goto L11;
        updateBlockedCallBtnInWhiteList(r3, r2, this.mInWhiteList);
        return;
    L11:
        updateBlockedCallBtnByBlocked(r3, r2, this.mIsInBlockList);
        return;
    L5:
        if (this.mInWhiteList == false) goto L8;
        goto L6
    }

    private final void updateBlockedCallBtnInWhiteList(TextView r1, View r2, boolean r3) {
        if (r3 == false) goto L4;
        r1.setText(R.string.added_to_whitelist);
        r2.setEnabled(false);
        return;
    L4:
        r1.setText(R.string.allow_calls);
        r2.setEnabled(true);
    }

    private final void updateBlockedCallBtnByBlocked(TextView r1, View r2, boolean r3) {
        if (r3 == false) goto L4;
        r1.setText(R.string.common_remove_from_blocklist);
    L5:
        r2.setEnabled(true);
        r2.setAlpha(1.0f);
        return;
    L4:
        r1.setText(R.string.common_add_to_blacklist);
        goto L5
    }

    public final void insertWhitelist(ContentResolver r3, String r4, final TextView r5, final View r6) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "phoneNumber");
        Intrinsics.checkNotNullParameter(r5, "blockedCallTextView");
        Intrinsics.checkNotNullParameter(r6, "blockedCallBtn");
        BlockedDataRequester.INSTANCE.insertWhitelistWithCallback(r3, r4, new AnonymousClass1(this, r6, r5));
    }

    public final void showWhiteListSheet(final Activity r18, final String r19, final TextView r20, final View r21) {
        Intrinsics.checkNotNullParameter(r18, "activity");
        Intrinsics.checkNotNullParameter(r19, "phoneNumber");
        Intrinsics.checkNotNullParameter(r20, "blockedCallTextView");
        Intrinsics.checkNotNullParameter(r21, "blockedCallBtn");
        OAlertDialogUtils.showConfirmationDialog$default(r18, r18.getString(R.string.do_not_block_this_number), r18.getString(R.string.white_list_dialog_subtitle), r18.getString(R.string.allow_calls), new BlockedContentHelper$$ExternalSyntheticLambda1(this, r18, r19, r20, r21), ButtonStyleController.TextColorType.Negative, r18.getString(R.string.common_cancel), null, null, 256, null);
    }

    private static final void showWhiteListSheet$lambda$1(BlockedContentHelper r0, Activity r1, String r2, TextView r3, View r4, DialogInterface r5, int r6) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$activity");
        Intrinsics.checkNotNullParameter(r2, "$phoneNumber");
        Intrinsics.checkNotNullParameter(r3, "$blockedCallTextView");
        Intrinsics.checkNotNullParameter(r4, "$blockedCallBtn");
        ContentResolver r7 = r1.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r7, "activity.contentResolver");
        r0.insertWhitelist(r7, r2, r3, r4);
        r0.toastAddToWhiteList(r1);
    }

    public final void toastRemoveFromBlackList(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        OToast.Companion r0 = OToast.Companion;
        String r2 = r7.getResources().getString(R.string.toast_remove_from_blacklist);
        Intrinsics.checkNotNullExpressionValue(r2, "activity.resources.getSt…st_remove_from_blacklist)");
        OToast.Companion.show$default(r0, r7, r2, 0, 4, null);
    }

    public final void toastAddToWhiteList(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        OToast.Companion r0 = OToast.Companion;
        String r2 = r7.getResources().getString(R.string.toast_add_to_whitelist);
        Intrinsics.checkNotNullExpressionValue(r2, "activity.resources.getSt…g.toast_add_to_whitelist)");
        OToast.Companion.show$default(r0, r7, r2, 0, 4, null);
    }
}
