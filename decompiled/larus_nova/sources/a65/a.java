package a65;

import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static void a(PreviewViewModel r100) {
        if (r100 != null) goto L5;
        tt5.a.d("DriveEditModeSwitch", "onSwitchHide preview viewModel is null");
        return;
    L5:
        r100.liveInnerEditModeSwitchActive().postValue(Boolean.FALSE);
    }

    public static void b(PreviewViewModel r100) {
        if (r100 != null) goto L5;
        tt5.a.d("DriveEditModeSwitch", "onSwitchShow preview viewModel is null");
        return;
    L5:
        r100.liveInnerEditModeSwitchActive().postValue(Boolean.TRUE);
    }
}
