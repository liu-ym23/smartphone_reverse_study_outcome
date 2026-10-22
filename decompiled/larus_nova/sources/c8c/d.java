package c8c;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larksuite.framework.section.utils.d f22760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] f22761c;

    public d(int r100, com.larksuite.framework.section.c r101, com.ss.android.lark.todo.impl.features.detail.viewmodel.a... r102) {
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        this.f22759a = r100;
        this.f22760b = new com.larksuite.framework.section.utils.d(r101);
        this.f22761c = r102;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        int r106 = this.f22759a;
        int r107 = 0;
        if (r103 == null) goto L5;
        int r108 = r103.length();
    L6:
        int r109 = r102 - r101;
        if ((r106 - (r108 - (r105 - r104))) >= r109) goto L18;
        if (r109 == 0) goto L22;
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] r110 = this.f22761c;
        int r111 = r110.length;
    L11:
        if (r107 >= r111) goto L13;
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a r112 = r110[r107];
        com.larksuite.framework.section.utils.d.a(this.f22760b, r112);
        r107 = r107 + 1;
        goto L11
    L13:
        if (r103 == null) goto L16;
        CharSequence r113 = r103.subSequence(r104, r105);
        if (r113 == null) goto L16;
        return r113;
    L16:
        return "";
    L22:
        return null;
    L18:
        return null;
    L5:
        r108 = 0;
        goto L6
    }
}
