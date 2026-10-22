package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.gamestickerv2.config.SizeMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerSetting;", "", "enable", "", "enableLandscape", "type", "", "enableRefactor", "enableStickerType", "getSizeMode", "Lcom/bytedance/android/livesdkapi/gamestickerv2/config/SizeMode;", "info", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerInfo;", "isInvisibleCode", "Lcom/bytedance/android/livesdkapi/gamestickerv2/config/InvisibleCode;", "code", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerSetting {
    boolean enable();

    boolean enableLandscape(int r100);

    boolean enableRefactor();

    boolean enableStickerType(int r100);

    SizeMode getSizeMode(GameStickerInfo r100);

    InvisibleCode isInvisibleCode(int r100);
}
