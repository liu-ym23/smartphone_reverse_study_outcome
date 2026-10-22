package com.bytedance.android.livesdk.record.admin;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.livesdkapi.depend.model.live.PublishItemTextExtraInfo;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdminRecordAnchorPreviewDialog f157070a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public b(AdminRecordAnchorPreviewDialog r100) {
        this.f157070a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        AdminRecordAnchorPreviewDialog r104 = this.f157070a;
        int r105 = (r102 * (-1)) + r103;
        int r106 = AdminRecordAnchorPreviewDialog.f157047f;
        Iterator<T> r107 = r104.f157051d.getTextDescInfos().iterator();
    L4:
        if (r107.hasNext() == false) goto L8;
        PublishItemTextExtraInfo r108 = (PublishItemTextExtraInfo) r107.next();
        if (r101 > r108.getStart()) goto L4;
        r108.setStart(r108.getStart() + r105);
        r108.setStop(r108.getStop() + r105);
        goto L4
    }
}
