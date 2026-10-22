package com.stepos.ailauncher.migu.play;

import Z8.C1173v;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import h9.InterfaceC4149a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0080\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguPlayError;", "", "", "code", "", "toast", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "I", "getCode", "()I", "Ljava/lang/String;", "getToast", "()Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "PARAM_ID_EMPTY", "PARAM_TYPE_INVALID", "TEEN_MODE_BLOCKED", "NO_COPYRIGHT", "LOCAL_FILE_INVALID", "EMPTY_DATA", "BLACKLISTED", "ALREADY_PLAYING", "NEED_LOGIN", "NETWORK_ERROR", "FETCH_URL_FAILED", "ILLEGAL_CONTENT", "PAID_OR_REGION_LIMITED", "PLAYER_ERROR", "CACHE_ERROR", "URL_EXPIRED", "FORMAT_UNSUPPORTED", "PARSE_ERROR", "PERMISSION_ERROR", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MiguPlayError {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MiguPlayError[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final List<String> REGION_KEYWORDS;
    private final int code;
    private final String toast;
    public static final MiguPlayError PARAM_ID_EMPTY = new MiguPlayError("PARAM_ID_EMPTY", 0, 1001, "歌曲信息有误，无法播放");
    public static final MiguPlayError PARAM_TYPE_INVALID = new MiguPlayError("PARAM_TYPE_INVALID", 1, 1002, "歌曲信息有误，无法播放");
    public static final MiguPlayError TEEN_MODE_BLOCKED = new MiguPlayError("TEEN_MODE_BLOCKED", 2, 1003, "青少年模式下不可播放");
    public static final MiguPlayError NO_COPYRIGHT = new MiguPlayError("NO_COPYRIGHT", 3, 1004, "该歌曲暂无版权");
    public static final MiguPlayError LOCAL_FILE_INVALID = new MiguPlayError("LOCAL_FILE_INVALID", 4, 1005, "本地文件已失效");
    public static final MiguPlayError EMPTY_DATA = new MiguPlayError("EMPTY_DATA", 5, 1006, "没有可播放的歌曲");
    public static final MiguPlayError BLACKLISTED = new MiguPlayError("BLACKLISTED", 6, AMapException.CODE_AMAP_INVALID_USER_SCODE, "该歌曲暂不可播放");
    public static final MiguPlayError ALREADY_PLAYING = new MiguPlayError("ALREADY_PLAYING", 7, AMapException.CODE_AMAP_USERKEY_PLAT_NOMATCH, null);
    public static final MiguPlayError NEED_LOGIN = new MiguPlayError("NEED_LOGIN", 8, AMapException.CODE_AMAP_IP_QUERY_OVER_LIMIT, null);
    public static final MiguPlayError NETWORK_ERROR = new MiguPlayError("NETWORK_ERROR", 9, AMapException.CODE_AMAP_ID_NOT_EXIST, "网络异常，请检查网络后重试");
    public static final MiguPlayError FETCH_URL_FAILED = new MiguPlayError("FETCH_URL_FAILED", 10, AMapException.CODE_AMAP_SERVICE_MAINTENANCE, "获取播放地址失败，请重试");
    public static final MiguPlayError ILLEGAL_CONTENT = new MiguPlayError("ILLEGAL_CONTENT", 11, 2006, "该内容不可播放");
    public static final MiguPlayError PAID_OR_REGION_LIMITED = new MiguPlayError("PAID_OR_REGION_LIMITED", 12, 2007, "该歌曲在你所在地区暂不可用");
    public static final MiguPlayError PLAYER_ERROR = new MiguPlayError("PLAYER_ERROR", 13, AMapException.CODE_AMAP_ROUTE_NO_ROADS_NEARBY, "播放器异常，请重试");
    public static final MiguPlayError CACHE_ERROR = new MiguPlayError("CACHE_ERROR", 14, AMapException.CODE_AMAP_ROUTE_FAIL, "缓存异常，请重试");
    public static final MiguPlayError URL_EXPIRED = new MiguPlayError("URL_EXPIRED", 15, AMapException.CODE_AMAP_OVER_DIRECTION_RANGE, "播放地址已过期，请重试");
    public static final MiguPlayError FORMAT_UNSUPPORTED = new MiguPlayError("FORMAT_UNSUPPORTED", 16, 3006, "该音频格式不支持");
    public static final MiguPlayError PARSE_ERROR = new MiguPlayError("PARSE_ERROR", 17, 3007, "文件解析失败");
    public static final MiguPlayError PERMISSION_ERROR = new MiguPlayError("PERMISSION_ERROR", 18, 3008, "播放权限不足");

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguPlayError$a;", "", "<init>", "()V", "", "code", "Lcom/stepos/ailauncher/migu/play/MiguPlayError;", Const.INTENT_KEY_PKGNAME, "(I)Lcom/stepos/ailauncher/migu/play/MiguPlayError;", "", "hostMessage", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "", "REGION_KEYWORDS", "Ljava/util/List;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.migu.play.MiguPlayError$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(String hostMessage) {
            if (hostMessage == null) {
                return false;
            }
            List list = MiguPlayError.REGION_KEYWORDS;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (La.H.e0(hostMessage, (String) it.next(), true)) {
                    return true;
                }
            }
            return false;
        }

        public final MiguPlayError b(int code) {
            MiguPlayError next;
            Iterator<MiguPlayError> it = MiguPlayError.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getCode() == code) {
                    break;
                }
            }
            return next;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ MiguPlayError[] $values() {
        return new MiguPlayError[]{PARAM_ID_EMPTY, PARAM_TYPE_INVALID, TEEN_MODE_BLOCKED, NO_COPYRIGHT, LOCAL_FILE_INVALID, EMPTY_DATA, BLACKLISTED, ALREADY_PLAYING, NEED_LOGIN, NETWORK_ERROR, FETCH_URL_FAILED, ILLEGAL_CONTENT, PAID_OR_REGION_LIMITED, PLAYER_ERROR, CACHE_ERROR, URL_EXPIRED, FORMAT_UNSUPPORTED, PARSE_ERROR, PERMISSION_ERROR};
    }

    static {
        MiguPlayError[] miguPlayErrorArr$values = $values();
        $VALUES = miguPlayErrorArr$values;
        $ENTRIES = kotlin.enums.a.a(miguPlayErrorArr$values);
        INSTANCE = new Companion(null);
        REGION_KEYWORDS = C1173v.p("地区", "区域", "地域", WeatherCardProvider.KEY_REGION);
    }

    private MiguPlayError(String str, int i10, int i11, String str2) {
        this.code = i11;
        this.toast = str2;
    }

    public static InterfaceC4149a<MiguPlayError> getEntries() {
        return $ENTRIES;
    }

    public static MiguPlayError valueOf(String str) {
        return (MiguPlayError) Enum.valueOf(MiguPlayError.class, str);
    }

    public static MiguPlayError[] values() {
        return (MiguPlayError[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getToast() {
        return this.toast;
    }
}
