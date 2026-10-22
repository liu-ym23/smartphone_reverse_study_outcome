package com.bytedance.android.livesdk.record.admin;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.depend.model.live.PublishItemTextExtraInfo;
import com.larus.nova.R;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdminRecordAnchorPreviewDialog f157069a;

    public a(AdminRecordAnchorPreviewDialog r100) {
        this.f157069a = r100;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r110, int r111, int r112, Spanned r113, int r114, int r210) {
        AdminRecordAnchorPreviewDialog r100 = this.f157069a;
        boolean r101 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        boolean r103 = !r102;
        if (r100.f157051d.getTextDescInfos().isEmpty() == true) goto L57;
        int r104 = ((EditText) r100.findViewById(R.id.mAdminRecordAnchorPreviewEt)).getSelectionStart();
        int r105 = ((EditText) r100.findViewById(R.id.mAdminRecordAnchorPreviewEt)).getSelectionEnd();
        Iterator<T> r106 = r100.f157051d.getTextDescInfos().iterator();
    L14:
        if (r106.hasNext() == false) goto L53;
        Object r107 = r106.next();
        PublishItemTextExtraInfo r115 = (PublishItemTextExtraInfo) r107;
        if (r115.getStart() >= r104) goto L18;
    L20:
        boolean r116 = false;
    L22:
        if (r105 <= r115.getStart()) goto L32;
        int r117 = r115.getStop();
        if (r103 == false) goto L27;
        if (r105 < r117) goto L28;
    L29:
        boolean r118 = false;
    L30:
        if (r118 == false) goto L32;
        boolean r119 = true;
    L34:
        if (r104 <= r115.getStart()) goto L44;
        int r120 = r115.getStop();
        if (r103 == false) goto L39;
        if (r104 < r120) goto L40;
    L41:
        boolean r121 = false;
    L42:
        if (r121 == false) goto L44;
        boolean r122 = true;
    L45:
        if (r116 == true) goto L50;
        if (r119 == true) goto L50;
        if (r122 == true) goto L50;
        boolean r123 = false;
    L51:
        if (r123 == false) goto L14;
    L55:
        if (((PublishItemTextExtraInfo) r107) == null) goto L57;
        f2.c("话题及好友信息不支持编辑", 0);
        boolean r108 = true;
    L58:
        if (r108 == false) goto L62;
        if (r113 != null) goto L61;
        return null;
    L61:
        return r113.subSequence(r114, r210);
    L62:
        if (r110 != null) goto L64;
    L67:
        if (r101 == false) goto L69;
    L71:
        return null;
    L69:
        if ((r110.length() + ((EditText) this.f157069a.findViewById(R.id.mAdminRecordAnchorPreviewEt)).getText().length()) <= this.f157069a.f157048a) goto L71;
        f2.c("最长可输入" + this.f157069a.f157048a + "个字符", 0);
        goto L71
    L64:
        if (r110.length() == 0) goto L67;
        r101 = false;
    L50:
        r123 = true;
    L40:
        r121 = true;
        goto L42
    L39:
        if (r104 > r120) goto L41;
    L44:
        r122 = false;
    L28:
        r118 = true;
        goto L30
    L27:
        if (r105 > r117) goto L29;
    L32:
        r119 = false;
        goto L34
    L18:
        if (r115.getStop() > r105) goto L20;
        r116 = true;
        goto L22
    L53:
        r107 = null;
    L57:
        r108 = false;
        goto L58
    L5:
        if (r110.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
