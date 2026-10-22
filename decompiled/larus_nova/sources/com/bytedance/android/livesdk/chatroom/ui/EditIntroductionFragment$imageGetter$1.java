package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.drawable.Drawable;
import android.text.Html;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class EditIntroductionFragment$imageGetter$1 implements Html.ImageGetter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditIntroductionFragment f112166a;

    public EditIntroductionFragment$imageGetter$1(EditIntroductionFragment r100) {
        this.f112166a = r100;
    }

    @Override // android.text.Html.ImageGetter
    public final Drawable getDrawable(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        EditIntroductionFragment r101 = this.f112166a;
        Function2<String, Drawable, Unit> r102 = new EditIntroductionFragment$imageGetter$1$getDrawable$1(this);
        Function1<String, Unit> r103 = new EditIntroductionFragment$imageGetter$1$getDrawable$2(this);
        int r104 = EditIntroductionFragment.f112142p;
        r101.U90(r100, r102, r103);
        return null;
    }
}
