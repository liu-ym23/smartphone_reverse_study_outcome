package com.bytedance.android.livehostapi.business.depend.gamecp;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&JJ\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&JQ\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0002\u0010\u001cJ8\u0010\u001d\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpGameService;", "", "openExternalBrowser", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "gameId", "openLiveMiniPlay", "ctx", "schema", "meta", "", "suc", "Lkotlin/Function0;", "failCheck", "openMiniApp", "enterFrom", "", "gameIdOrSchema", "isAnchor", "", "contentId", "promoterId", "promoteScene", "callback", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/OpenMiniAppCallback;", "(ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/livehostapi/business/depend/gamecp/OpenMiniAppCallback;)V", "preloadInteractGame", "appId", "preloadMiniGame", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCpGameService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void openMiniApp$default(IGameCpGameService r100, int r110, String r111, boolean r112, String r113, String r114, Integer r115, OpenMiniAppCallback r116, int r117, Object r118) {
            if (r118 != null) goto L10;
            if ((r117 & 64) == 0) goto L6;
            OpenMiniAppCallback r101 = null;
        L7:
            r100.openMiniApp(r110, r111, r112, r113, r114, r115, r101);
            return;
        L6:
            r101 = r116;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMiniApp");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void openMiniApp$default(IGameCpGameService r100, int r101, String r102, boolean r103, String r104, String r105, Integer r106, OpenMiniAppCallback r107, int r108, Object r109) {
            CC.openMiniApp$default(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
        }
    }

    void openExternalBrowser(Context r100, String r101, String r102);

    void openLiveMiniPlay(Context r100, String r101, Map<String, ? extends Object> r102, Function0<Unit> r103, Function0<Unit> r104);

    void openMiniApp(int r100, String r101, boolean r102, String r103, String r104, Integer r105, OpenMiniAppCallback r106);

    void preloadInteractGame(String r100, String r101, Function0<Unit> r102, Function0<Unit> r103);

    void preloadMiniGame(String r100);
}
