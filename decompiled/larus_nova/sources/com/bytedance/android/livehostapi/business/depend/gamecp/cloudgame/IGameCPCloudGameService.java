package com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J~\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u001c\u0010\u000f\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011\u0018\u00010\u00102\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J-\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u001dJ,\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H&J\b\u0010 \u001a\u00020\u0016H&J4\u0010!\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H&J3\u0010#\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010$\u001a\u0002H\u0019H&¢\u0006\u0002\u0010%J4\u0010&\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H&¨\u0006'À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/IGameCPCloudGameService;", "", "closeAllGame", "", "closeGame", "gameId", "", "from", "status", "", "createStartParams", "", "gameName", "gameIcon", RemoteMessageConst.Notification.CHANNEL_ID, "extra2Game", "", "Lkotlin/Pair;", "extra2Sever", "", "gameOrientation", "restartGameWhenGameIsRunning", "", "getRtcLibraConfig", "getTrackParams", ExifInterface.GPS_DIRECTION_TRUE, "roomId", "", "key", "(JLjava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "initMonitor", "map", "isPluginReady", "monitorEvent", "extra", "setTrackValue", "value", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "trackEvent", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCPCloudGameService {
    void closeAllGame();

    void closeGame(String r100, String r101, int r102);

    Map<String, Object> createStartParams(String r100, String r101, String r102, String r103, List<? extends Pair<String, ? extends Object>> r104, Map<String, String> r105, int r106, boolean r107);

    String getRtcLibraConfig(String r100);

    <T> T getTrackParams(long r100, String r101, String r102);

    void initMonitor(long r100, String r101, Map<String, String> r102);

    boolean isPluginReady();

    void monitorEvent(long r100, String r101, String r102, Map<String, String> r103);

    <T> void setTrackValue(long r100, String r101, String r102, T r103);

    void trackEvent(long r100, String r101, String r102, Map<String, String> r103);
}
