package c4b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r100, int r101, Intent r102) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        Context r101 = r100.getContext();
        View r102 = r100.getContentView();
        if (DevEnvUtil.isDevelopPackage(r101) == false) goto L5;
    L6:
        TextView r103 = new TextView(r101);
        RelativeLayout.LayoutParams r104 = new RelativeLayout.LayoutParams(-2, -2);
        r104.addRule(10);
        r104.addRule(20);
        r104.topMargin = UIUtils.getScreenHeight(r101) / 4;
        r103.setLayoutParams(r104);
        r103.setText("CORE");
        r103.setTextSize(2, 12.0f);
        r103.setTextColor(1073741824);
        int r105 = UIUtils.dp2px(r101, 8.0f);
        r103.setPadding(r105, r105, r105, r105);
        if ((r102 instanceof ViewGroup) == false) goto L9;
        ViewGroup r106 = (ViewGroup) r102;
    L10:
        if (r106 == null) goto L14;
        r106.addView(r103);
        return;
    L14:
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        if (DevEnvUtil.isDebugMode(r101) == true) goto L6;
    }
}
