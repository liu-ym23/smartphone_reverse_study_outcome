package cj9;

import android.view.View;
import com.bytedance.android.btm.bridge.b;
import com.lynx.tasm.LynxView;
import g66.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final String getHybridContainerType(c r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        if (r100.b(LynxView.class) == false) goto L6;
        return "lynx";
    L6:
        return "unkown";
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final String getPageUrl(c r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        if (r100.b(LynxView.class) == false) goto L9;
        g66.a r101 = r100.a(LynxView.class);
        if (r101 == null) goto L9;
        LynxView r102 = (LynxView) r101.provideInstance();
        if (r102 == null) goto L9;
        return r102.getTemplateUrl();
    L9:
        return null;
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final View obtainView(c r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        if (r100.b(LynxView.class) == false) goto L7;
        g66.a r101 = r100.a(LynxView.class);
        if (r101 == null) goto L7;
        return (LynxView) r101.provideInstance();
    L7:
        return null;
    }
}
