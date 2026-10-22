package com.bytedance.android.livesdkapi.util;

import android.content.Context;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.AnchorModeParseSeiData;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J<\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H&JD\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H&J\\\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010 H&J:\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H&Jx\u0010!\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H&JN\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u001e\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H&J2\u0010)\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0005H&J<\u0010+\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H&J4\u0010-\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H&J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0003H&J\"\u00103\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0007H&J\u0012\u00106\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "", "getFeedViewDesiredTopSpaceHeight", "", "getParseSeiDataBySei", "Lcom/bytedance/android/livesdkapi/model/ParseSeiData;", "sei", "", "seiJson", "Lorg/json/JSONObject;", "appDataJson", "getPreviewClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "renderView", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "roomId", "", "resetSeiVersion", "", "resizeLinkPlayView", "ver", "canvas", "livePlayerView", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "showFrom", "resizePlayView", "uiLayout", "playModeParams", "", "resizePlayViewForCommonFeedView", "containerWidth", "containerHeight", "clientUIInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "resizePlayViewForNewLinkFeedView", "seiData", "Lcom/bytedance/android/livesdkapi/model/AnchorModeParseSeiData;", "resizeRenderViewBeforeFirstFrame", "parseSeiData", "resizeRenderViewByLastSei", "seiVersion", "savePreviewPlayerRenderViewLayoutParams", "key", "previewClient", "seiVer", "setFeedViewDesiredTopSpaceHeight", "topSpaceHeight", "updateRenderViewLPGravityIfNeed", GXTemplateKey.GAIAX_LAYER_GRAVITY, "source", "updateRoom", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractPlayView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ ParseSeiData getParseSeiDataBySei$default(IInteractPlayView r100, String r101, JSONObject r102, JSONObject r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L10;
            r103 = null;
        L10:
            return r100.getParseSeiDataBySei(r101, r102, r103);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getParseSeiDataBySei");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void resizePlayView$default(IInteractPlayView r110, int r111, int r112, JSONObject r113, LivePlayerView r114, Context r115, IRoom r116, int r117, Map r118, int r119, Object r210) {
            if (r210 != null) goto L10;
            if ((r119 & 128) == 0) goto L6;
            Map r100 = null;
        L7:
            r110.resizePlayView(r111, r112, r113, r114, r115, r116, r117, r100);
            return;
        L6:
            r100 = r118;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resizePlayView");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void resizePlayViewForCommonFeedView$default(IInteractPlayView r110, int r111, int r112, JSONObject r113, LivePlayerView r114, Context r210, IRoom r211, int r212, int r213, int r214, Map r215, ClientUIInfo r216, int r217, Object r218) {
            if (r218 != null) goto L15;
            if ((r217 & 512) == 0) goto L7;
            Map r115 = null;
        L9:
            if ((r217 & 1024) == 0) goto L11;
            ClientUIInfo r116 = null;
        L12:
            r110.resizePlayViewForCommonFeedView(r111, r112, r113, r114, r210, r211, r212, r213, r214, r115, r116);
            return;
        L11:
            r116 = r216;
            goto L12
        L7:
            r115 = r215;
            goto L9
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resizePlayViewForCommonFeedView");
        }
    }

    int getFeedViewDesiredTopSpaceHeight();

    ParseSeiData getParseSeiDataBySei(String r100, JSONObject r101, JSONObject r102);

    ILivePlayerClient getPreviewClient(IRenderView r100, long r101);

    void resetSeiVersion();

    void resizeLinkPlayView(int r100, JSONObject r101, LivePlayerView r102, Context r103, IRoom r104, int r105);

    void resizePlayView(int r100, int r101, JSONObject r102, LivePlayerView r103, Context r104, IRoom r105, int r106);

    void resizePlayView(int r100, int r101, JSONObject r102, LivePlayerView r103, Context r104, IRoom r105, int r106, Map<String, ? extends Object> r107);

    void resizePlayView(int r100, JSONObject r101, IRenderView r102, Context r103, IRoom r104, int r105);

    void resizePlayViewForCommonFeedView(int r100, int r101, JSONObject r102, LivePlayerView r103, Context r104, IRoom r105, int r106, int r107, int r108, Map<String, ? extends Object> r110, ClientUIInfo r111);

    void resizePlayViewForNewLinkFeedView(AnchorModeParseSeiData r100, int r101, LivePlayerView r102, Context r103, IRoom r104, int r105, int r106, int r107);

    void resizeRenderViewBeforeFirstFrame(String r100, LivePlayerView r101, IRoom r102, int r103, ParseSeiData r104);

    void resizeRenderViewByLastSei(JSONObject r100, IRenderView r101, IRoom r102, int r103, int r104, int r105);

    void savePreviewPlayerRenderViewLayoutParams(IRenderView r100, String r101, ILivePlayerClient r102, int r103, int r104);

    void setFeedViewDesiredTopSpaceHeight(int r100);

    void updateRenderViewLPGravityIfNeed(IRenderView r100, int r101, String r102);

    void updateRoom(IRoom r100);
}
