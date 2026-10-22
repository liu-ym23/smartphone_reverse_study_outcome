package bw;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;

/* JADX INFO: loaded from: classes44.dex */
public interface r extends IBaseHostService {
    boolean handle(Context r100, Uri r101);

    boolean handle(Context r100, String r101);

    boolean handleWithCallback(Context r100, Uri r101, DialogInterface.OnDismissListener r102);

    void openExternalBrowser(Context r100, String r101, String r102);
}
