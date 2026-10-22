package com.bytedanceos.common.ui.widget.oui;

import android.app.Activity;
import android.view.View;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/bytedanceos/common/ui/widget/oui/OAppStatusView;", "", "operateApp", "", "activity", "Landroid/app/Activity;", "v", "Landroid/view/View;", "appInfo", "Lcom/bytedanceos/common/model/AppInfo;", "pagesource", "", "updateDownloadStatus", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface OAppStatusView {
    void operateApp(@NotNull Activity r10, @NotNull View r11, @NotNull AppInfo r12, @NotNull String r13);

    void updateDownloadStatus(@NotNull AppInfo r10);
}
