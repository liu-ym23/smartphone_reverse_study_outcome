package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mapapi.map.entity.BackgroundNaviEntity;

/* loaded from: classes.dex */
public abstract class AbsBackgroundDrawNaviLayer extends b<BackgroundNaviEntity> {

    public enum EraseEffect {
        NONE,
        ALREADY_PASSED_NOT_SHOW,
        ALREADY_PASSED_CHANGE_COLOR
    }

    public AbsBackgroundDrawNaviLayer(Context context) {
        super(context);
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer
    public /* bridge */ /* synthetic */ int getLife() {
        return super.getLife();
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public /* bridge */ /* synthetic */ void onSizeChanged(int i4, int i5) {
        super.onSizeChanged(i4, i5);
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public /* bridge */ /* synthetic */ void onUpdated() {
        super.onUpdated();
    }

    public abstract void setEraseColor(int i4);

    public abstract void setEraseEffect(EraseEffect eraseEffect);

    public abstract void setIsLocationDirectionFollowPhone(boolean z4);

    public abstract void setIsNeedShowStartAndEndMark(boolean z4);

    public abstract void setNaviEndMark(Bitmap bitmap);

    public abstract void setNaviLocationMark(Bitmap bitmap);

    public abstract void setNaviRouteColor(int i4);

    public abstract void setNaviRouteWidth(int i4);

    public abstract void setNaviStartMark(Bitmap bitmap);

    public AbsBackgroundDrawNaviLayer(Context context, int i4) {
        super(context, i4);
    }
}
