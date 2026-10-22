package com.bytedance.android.livesdk.announcement;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.android.live.core.utils.f2;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementSettingDialog f103529a;

    public m(AnnouncementSettingDialog r100) {
        this.f103529a = r100;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        if (r104 != this.f103529a.f103201h) goto L5;
        f2.c("最多输入" + this.f103529a.f103201h + "个字符", 0);
    L5:
        if (r100 != null) goto L9;
        return null;
    L9:
        return new Regex("\n").replace(r100, "");
    }
}
