package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.data.RetainMsg;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayDoubleVoucherTagsLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "firstVoucherTag", "Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayVoucherTag;", "secondVoucherTag", "setupRetainMsgList", "", "retainMsgList", "", "Lcom/android/ttcjpaysdk/base/ui/data/RetainMsg;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDoubleVoucherTagsLayout extends LinearLayout {
    private final CJPayVoucherTag firstVoucherTag;
    private final CJPayVoucherTag secondVoucherTag;

    public final void setupRetainMsgList(List<RetainMsg> r100) {
        Unit r101 = null;
        if (r100 == null) goto L23;
        List r102 = CollectionsKt.filterNotNull(r100);
        if (r102 == null) goto L23;
        if ((!r102.isEmpty()) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L23;
        if (r102.size() != 1) goto L17;
        RetainMsg r103 = (RetainMsg) CollectionsKt.getOrNull(r102, 0);
        if (r103 == null) goto L23;
        this.firstVoucherTag.refreshVoucherTag(r103);
        this.firstVoucherTag.setVisibility(0);
        this.secondVoucherTag.setVisibility(8);
        Unit r104 = Unit.INSTANCE;
    L16:
        r101 = r104;
        goto L23
    L17:
        RetainMsg r105 = (RetainMsg) CollectionsKt.getOrNull(r102, 0);
        if (r105 == null) goto L20;
        this.firstVoucherTag.refreshVoucherTag(r105);
        this.firstVoucherTag.setVisibility(0);
    L20:
        RetainMsg r106 = (RetainMsg) CollectionsKt.getOrNull(r102, 1);
        if (r106 == null) goto L23;
        this.secondVoucherTag.refreshVoucherTag(r106);
        this.secondVoucherTag.setVisibility(0);
        r104 = Unit.INSTANCE;
    L23:
        if (r101 != null) goto L26;
        CJPayViewExtensionsKt.viewGone(this);
        return;
    }

    public CJPayDoubleVoucherTagsLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_keep_dialog_v2_double_voucher_tags, this, true);
        this.firstVoucherTag = (CJPayVoucherTag) findViewById(R.id.voucher_tag_first);
        this.secondVoucherTag = (CJPayVoucherTag) findViewById(R.id.voucher_tag_second);
    }
}
