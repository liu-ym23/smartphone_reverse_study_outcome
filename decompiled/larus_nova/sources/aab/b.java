package aab;

import android.text.Layout;
import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements z<LKUILightTextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2375a = null;

    static {
        f2375a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Class<LKUILightTextView> b() {
        return LKUILightTextView.class;
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Layout a(View r100) {
        LKUILightTextView r101 = (LKUILightTextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        return r101.getLayout();
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final CharSequence c(View r100) {
        LKUILightTextView r101 = (LKUILightTextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        return r101.getContentText();
    }
}
