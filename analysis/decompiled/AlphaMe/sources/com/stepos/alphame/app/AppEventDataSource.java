package com.stepos.alphame.app;

import com.stepos.alphame.data.Cache;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.common.alphame.Args;

/* loaded from: classes.dex */
public class AppEventDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {6, 6};
    private static final byte[] ARGS_TYPE_NEW_1 = {6, 6, 6, 6};
    private static final byte[] ARGS_TYPE_NEW_2 = {6, 6, 6, 6, 6};

    public AppEventDataSource(String str) {
        super(str);
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        return null;
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return AppEventDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getMoreFillArgsType(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return DataSource.NULL_BYTES;
        }
        if (bArr.length == 4) {
            byte[] bArr2 = ARGS_TYPE_NEW_1;
            if (Args.g(bArr2, bArr)) {
                return bArr2;
            }
        }
        if (bArr.length == 5) {
            byte[] bArr3 = ARGS_TYPE_NEW_2;
            if (Args.g(bArr3, bArr)) {
                return bArr3;
            }
        }
        return DataSource.NULL_BYTES;
    }

    @Override // com.stepos.alphame.data.DataSource
    public void process(DataItem dataItem) {
        synchronized (this.mSyncObject) {
            AppEventDataItem appEventDataItem = (AppEventDataItem) dataItem;
            String[] appInfo = {"-1", "-1"};
            try {
                appInfo = SceneDetectorEngine.getInstance().getAppInfo(appEventDataItem.getPkgName());
            } catch (Exception e4) {
                AlphaMeLogger.exceptionLog("collect app event error", e4);
            }
            ActionManager.getInstance().broadcast("APP_EVENT", new String[]{appEventDataItem.getPkgName(), appEventDataItem.getEvent(), appEventDataItem.getActivityName(), appEventDataItem.getUserId(), appInfo[0], appInfo[1], String.valueOf(appEventDataItem.mIsMultiWindowMode), appEventDataItem.mPid, String.valueOf(appEventDataItem.isSpecActivity)});
            itemCache().put((Cache<DataItem>) appEventDataItem);
        }
    }
}
