package com.bytedance.android.livesdkapi.roomplayer;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001Jt\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerFunctionHandler;", "", "createLivePlayerView", "Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "keepSurface", "", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "defStyle", "", "roomId", "", "userId", "", "isBackgroundPlay", "useSurface", "sharePlayer", "pseudoLiving", "isLiveRoomPlayerView", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerFunctionHandler {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ AbsLivePlayerView createLivePlayerView$default(ILivePlayerFunctionHandler r110, Context r111, boolean r112, AttributeSet r113, int r114, long r210, String r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, int r217, Object r218) {
            if (r218 != null) goto L43;
            if ((r217 & 4) == 0) goto L7;
            AttributeSet r100 = null;
        L9:
            if ((r217 & 8) == 0) goto L11;
            int r101 = 0;
        L13:
            if ((r217 & 16) == 0) goto L15;
            long r102 = 0;
        L17:
            if ((r217 & 32) == 0) goto L19;
            String r103 = String.valueOf(0);
        L21:
            if ((r217 & 64) == 0) goto L23;
            boolean r115 = false;
        L25:
            if ((r217 & 128) == 0) goto L27;
            boolean r116 = false;
        L29:
            if ((r217 & 256) == 0) goto L31;
            boolean r117 = false;
        L33:
            if ((r217 & 512) == 0) goto L35;
            boolean r118 = false;
        L37:
            if ((r217 & 1024) == 0) goto L39;
            boolean r119 = false;
        L41:
            return r110.createLivePlayerView(r111, r112, r100, r101, r102, r103, r115, r116, r117, r118, r119);
        L39:
            r119 = r216;
            goto L41
        L35:
            r118 = r215;
            goto L37
        L31:
            r117 = r214;
            goto L33
        L27:
            r116 = r213;
            goto L29
        L23:
            r115 = r212;
            goto L25
        L19:
            r103 = r211;
            goto L21
        L15:
            r102 = r210;
            goto L17
        L11:
            r101 = r114;
            goto L13
        L7:
            r100 = r113;
            goto L9
        L43:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLivePlayerView");
        }
    }

    AbsLivePlayerView createLivePlayerView(Context r100, boolean r101, AttributeSet r102, int r103, long r104, String r105, boolean r106, boolean r107, boolean r110, boolean r111, boolean r112);
}
