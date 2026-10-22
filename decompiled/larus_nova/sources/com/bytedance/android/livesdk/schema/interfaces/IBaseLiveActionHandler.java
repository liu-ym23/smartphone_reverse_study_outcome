package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J2\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\rH&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J:\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0014H&J&\u0010\u0015\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u001c\u0010\u0018\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J(\u0010\u0019\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&Jg\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010$\u001a\u0004\u0018\u00010%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00142\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014H&¢\u0006\u0002\u0010'J<\u0010(\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0014H&J\u0012\u0010*\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J<\u0010+\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H&¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/schema/interfaces/IBaseLiveActionHandler;", "Lcom/bytedance/android/live/base/IService;", "canHandle", "", "uri", "Landroid/net/Uri;", "getHandler", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "R", "callback", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler$SchemaCallback;", "uriString", "", "handleHttpSchema", "view", "Landroid/view/View;", "queryItems", "", "handleWithCallback", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "handleWithoutHost", "openRoom", "params", "Lcom/bytedance/android/livesdk/schema/interfaces/IRoomActionHandler$Params;", "schemaModel", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "openUserProfile", "", "targetUserId", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "hostNickName", "xiguaUid", "", "extra", "(Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)V", "pageFinished", "url", "predicateCanHandle", "showUserProfileExt", "userId", "type", "prams", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBaseLiveActionHandler extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean openRoom$default(IBaseLiveActionHandler r100, Context r101, IRoomActionHandler.Params r102, BaseSchemaModel r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.openRoom(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openRoom");
        }
    }

    boolean canHandle(Uri r100);

    IBaseSchemaHandler<?> getHandler(Uri r100);

    boolean handle(Context r100, Uri r101);

    <R> boolean handle(Context r100, Uri r101, IBaseCallbackSchemaHandler.SchemaCallback<R> r102);

    boolean handle(Context r100, String r101);

    boolean handleHttpSchema(Context r100, Uri r101, View r102, Map<String, String> r103);

    boolean handleWithCallback(Context r100, Uri r101, DialogInterface.OnDismissListener r102);

    boolean handleWithoutHost(Context r100, String r101);

    boolean openRoom(Context r100, IRoomActionHandler.Params r101, BaseSchemaModel r102);

    void openUserProfile(Context r100, String r101, IRoom r102, String r103, Long r104, Map<String, String> r105, Map<String, String> r106);

    void pageFinished(Context r100, String r101, View r102, Map<String, String> r103);

    boolean predicateCanHandle(Uri r100);

    boolean showUserProfileExt(Context r100, String r101, String r102, Map<String, String> r103);
}
