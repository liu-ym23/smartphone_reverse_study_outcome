package com.stepos.alphame.cutout;

import android.text.TextUtils;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.HttpRequestHelper;
import com.stepos.alphame.utils.NetworkHelper;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class CutImageRuleUpdater {
    public void update(String str, String str2) {
        if (!NetworkHelper.isWifiNetwork(ApplicationImpl.getApplication())) {
            AlphaMeLogger.dLog("CutImageRuleUpdater not wifi env");
            return;
        }
        try {
            AlphaMeLogger.wLog("CutImageRuleUpdater update szUrl = " + str2 + ", szVer = " + str + ", Property.getCutImageVersion() = " + Property.getCutImageVersion());
            boolean zEquals = TextUtils.equals(str, Property.getCutImageVersion());
            boolean zHasModelFile = CutImageHelper.getInstance().hasModelFile();
            boolean z4 = (zEquals && zHasModelFile) ? false : true;
            AlphaMeLogger.wLog("CutImageRuleUpdater update sameVersion: " + zEquals + " hasModelFile: " + zHasModelFile + " shouldDownload: " + z4);
            if (TextUtils.isEmpty(str2) || !z4) {
                return;
            }
            AlphaMeLogger.wLog("CutImageRuleUpdater update start download");
            if (HttpRequestHelper.downloadFile(str2, CutImageHelper.getInstance().getModelFilePath())) {
                AlphaMeLogger.wLog("CutImageRuleUpdater update download successful");
                Property.setCutImageVersion(str);
                CutImageHelper.getInstance().init("RuleUpdater");
            }
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("CutImageRuleUpdater error", e4);
        }
    }
}
