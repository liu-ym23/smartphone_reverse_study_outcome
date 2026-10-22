package l8;

import android.app.Activity;
import android.view.View;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.widget.oui.OAppItemView;
import com.bytedanceos.common.ui.widget.oui.OAppStatusView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity r10, View r11, AppInfo r12, String r13) {
        if ((r11 instanceof OAppStatusView) == false) goto L6;
        ((OAppStatusView) r11).operateApp(r10, r11, r12, r13);
        return;
    L6:
        if ((r11 instanceof OAppItemView) == false) goto L8;
        ((OAppItemView) r11).operateApp(r10, r11, r12);
        return;
    L8:
        j.p("[AppStatus] operateApp. unknown code path");
    }
}
