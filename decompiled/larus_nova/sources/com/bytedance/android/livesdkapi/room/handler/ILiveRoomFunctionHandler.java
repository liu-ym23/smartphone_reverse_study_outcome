package com.bytedance.android.livesdkapi.room.handler;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.commerce.param.IExternalRoomLogger;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import jc1.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H&J0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomFunctionHandler;", "Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;", "Lcom/bytedance/android/livesdkapi/commerce/param/IExternalRoomLogger;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "loggerClass", "getLogger", "(Ljava/lang/Class;)Lcom/bytedance/android/livesdkapi/commerce/param/IExternalRoomLogger;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdk/user/l;", "params", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "login", "", "userId", "secUserId", "", "roomId", "Lcom/bytedance/android/livesdkapi/depend/model/follow/FollowPair;", "follow", "unFollow", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRoomFunctionHandler extends IBaseLiveRoomFunctionHandler {
    public static final Companion Companion = null;
    public static final int DIALOG_STATE_CLOSE_TO_FULL = 6;
    public static final int DIALOG_STATE_CLOSE_TO_HALF = 1;
    public static final int DIALOG_STATE_FULL_TO_CLOSE = 5;
    public static final int DIALOG_STATE_FULL_TO_HALF = 3;
    public static final int DIALOG_STATE_HALF_TO_CLOSE = 4;
    public static final int DIALOG_STATE_HALF_TO_FULL = 2;
    public static final int PERMISSION_COMMERCE = 0;
    public static final int VBOOST_TYPE_OPEN_PRODUCT_LIST = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomFunctionHandler$Companion;", "", "()V", "DIALOG_STATE_CLOSE_TO_FULL", "", "DIALOG_STATE_CLOSE_TO_HALF", "DIALOG_STATE_FULL_TO_CLOSE", "DIALOG_STATE_FULL_TO_HALF", "DIALOG_STATE_HALF_TO_CLOSE", "DIALOG_STATE_HALF_TO_FULL", "PERMISSION_COMMERCE", "VBOOST_TYPE_OPEN_PRODUCT_LIST", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int DIALOG_STATE_CLOSE_TO_FULL = 6;
        public static final int DIALOG_STATE_CLOSE_TO_HALF = 1;
        public static final int DIALOG_STATE_FULL_TO_CLOSE = 5;
        public static final int DIALOG_STATE_FULL_TO_HALF = 3;
        public static final int DIALOG_STATE_HALF_TO_CLOSE = 4;
        public static final int DIALOG_STATE_HALF_TO_FULL = 2;
        public static final int PERMISSION_COMMERCE = 0;
        public static final int VBOOST_TYPE_OPEN_PRODUCT_LIST = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static <T extends IExternalRoomLogger> T getLogger(ILiveRoomFunctionHandler r100, Class<T> r101) {
            Intrinsics.checkNotNullParameter(r101, "loggerClass");
            return (T) j.a(new Object(), r101);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    Observable<FollowPair> follow(Context r100, String r101, String r102, long r103);

    <T extends IExternalRoomLogger> T getLogger(Class<T> r100);

    Observable<IBaseUser> login(Context r100, l r101);

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    Observable<FollowPair> unFollow(Context r100, String r101, String r102, long r103);
}
