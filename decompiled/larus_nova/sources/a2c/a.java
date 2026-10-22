package a2c;

import android.content.Context;
import com.ss.android.lark.biz.core.api.IQRCodeScanResultHandler;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    boolean canOpenAppBrand(String r100);

    boolean canOpenAppLink(String r100, Context r101, int r102);

    List<IQRCodeScanResultHandler> getQRCodeHandlers();

    List<IQRCodeScanResultHandler> getQRCodeInterceptHandlers();

    boolean isFeatureGatingEnable(String r100);

    boolean isInMeeting();

    boolean isMatchUrl(String r100);

    void openInviteExternalPage(Context r100, String r101, boolean r102);

    void otherOpenCamera();
}
