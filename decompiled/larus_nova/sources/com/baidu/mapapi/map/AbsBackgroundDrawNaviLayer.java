package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mapapi.map.entity.BackgroundNaviEntity;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AbsBackgroundDrawNaviLayer extends b<BackgroundNaviEntity> {

    public static final enum EraseEffect extends Enum<EraseEffect> {
        private static final /* synthetic */ EraseEffect[] $VALUES = null;
        public static final EraseEffect ALREADY_PASSED_CHANGE_COLOR = null;
        public static final EraseEffect ALREADY_PASSED_NOT_SHOW = null;
        public static final EraseEffect NONE = null;

        static {
            EraseEffect r100 = new EraseEffect(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            EraseEffect r101 = new EraseEffect("ALREADY_PASSED_NOT_SHOW", 1);
            ALREADY_PASSED_NOT_SHOW = r101;
            EraseEffect r102 = new EraseEffect("ALREADY_PASSED_CHANGE_COLOR", 2);
            ALREADY_PASSED_CHANGE_COLOR = r102;
            $VALUES = new EraseEffect[]{r100, r101, r102};
        }

        public static EraseEffect[] values() {
            return (EraseEffect[]) $VALUES.clone();
        }

        public static EraseEffect valueOf(String r100) {
            return (EraseEffect) r27.a.a(EraseEffect.class, r100);
        }

        private EraseEffect(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void setEraseColor(int r100);

    public abstract void setEraseEffect(EraseEffect r100);

    public abstract void setIsLocationDirectionFollowPhone(boolean r100);

    public abstract void setIsNeedShowStartAndEndMark(boolean r100);

    public abstract void setNaviEndMark(Bitmap r100);

    public abstract void setNaviLocationMark(Bitmap r100);

    public abstract void setNaviRouteColor(int r100);

    public abstract void setNaviRouteWidth(int r100);

    public abstract void setNaviStartMark(Bitmap r100);

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
    public /* bridge */ /* synthetic */ void onUpdated() {
        super.onUpdated();
    }

    public AbsBackgroundDrawNaviLayer(Context r100) {
        super(r100);
    }

    public AbsBackgroundDrawNaviLayer(Context r100, int r101) {
        super(r100, r101);
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public /* bridge */ /* synthetic */ void onSizeChanged(int r100, int r101) {
        super.onSizeChanged(r100, r101);
    }
}
