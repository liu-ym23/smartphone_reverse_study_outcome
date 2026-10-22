package com.bytedance.android.live.user;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.Single;
import j70.h;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b/\u00100J$\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J.\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002JJ\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042.\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u00010\fj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\rH\u0002JJ\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042.\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u00010\fj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\rH\u0002J^\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042.\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u00010\fj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0016H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001fH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020\u0002H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010(\u001a\u00020'H\u0016R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/live/user/UserServiceV2;", "Lcom/bytedance/android/live/user/api/IUserServiceV2;", "", "id", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/UserExtra;", "queryUserWithId", "queryUserWithIdExt", "secUid", "queryUserWithSecUid", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "queryUserWithParamsMap", "queryUserWithParamsMapExt", "", "headers", "queryUserWithParamsMapWithHeaders", "userId", "getSecUserId", "Lio/reactivex/Observable;", "observeUser", "observeCurrentUser", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/live/datacontext/DataContext;", "roomContext", "Lcom/bytedance/android/live/user/api/a;", "createUserContext", "Lj70/h;", "Lh70/b;", "getUserServiceWidgetDescriptor", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoomFromStaticRoomContext", "callFrom", "updateCurrentUser", "getUserContext", "", "roomId", "Lhc1/a;", "userCacheHolder", "Lhc1/a;", "Ldc1/b;", "userRequester", "Ldc1/b;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveuser-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class UserServiceV2 implements IUserServiceV2 {
    public static final a Companion = null;
    private static final String TAG = "UserServiceV2";
    private final hc1.a userCacheHolder;
    private final dc1.b userRequester;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final Observable<? extends IBaseUser> observeCurrentUser() {
        return this.userCacheHolder.p();
    }

    @Override // com.bytedance.android.live.user.api.IUserServiceV2
    public IRoom getRoomFromStaticRoomContext() {
        IRoomContextService r100 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r100 == null) goto L5;
        o r101 = IRoomContextService.a.a(r100, null, 0, 3);
    L6:
        if (r101 == null) goto L11;
        m<IRoom> r102 = r101.getRoom();
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.getValue();
    L11:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.user.api.IUserServiceV2
    public h<? extends h70.b> getUserServiceWidgetDescriptor() {
        ALogger.i(TAG, "call getUserServiceWidgetDescriptor");
        return new c();
    }

    public UserServiceV2() {
        ic1.a r100 = new ic1.a();
        this.userCacheHolder = r100;
        this.userRequester = new ic1.b(r100);
        ALogger.i(TAG, "UserServiceV2 register");
        k.l(IUserServiceV2.class, this);
    }

    private final String getSecUserId(String r100) {
        return this.userCacheHolder.a(r100);
    }

    private final Observable<? extends IBaseUser> observeUser(String r100) {
        return this.userCacheHolder.b(r100);
    }

    private final Single<BaseResponse<IBaseUser, UserExtra>> queryUserWithId(String r100) {
        return this.userRequester.r(r100);
    }

    private final Single<BaseResponse<IBaseUser, UserExtra>> queryUserWithIdExt(String r100) {
        return this.userRequester.k(r100);
    }

    private final Single<BaseResponse<IBaseUser, UserExtra>> queryUserWithParamsMap(HashMap<String, ? extends String> r100) {
        return this.userRequester.d(r100);
    }

    private final Single<BaseResponse<IBaseUser, UserExtra>> queryUserWithParamsMapExt(HashMap<String, ? extends String> r100) {
        return this.userRequester.o(r100);
    }

    @Override // com.bytedance.android.live.user.api.IUserServiceV2
    public com.bytedance.android.live.user.api.a getUserContext(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        MiddlewareRoomContext r101 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r100, 0, 2);
        if (r101 == null) goto L7;
        j<com.bytedance.android.live.user.api.a> r102 = r101.getUserContext();
        if (r102 == null) goto L7;
        return r102.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.user.api.IUserServiceV2
    public com.bytedance.android.live.user.api.a getUserContext(long r100) {
        MiddlewareRoomContext.Companion.getClass();
        MiddlewareRoomContext r101 = MiddlewareRoomContext.a.a(null, r100);
        if (r101 == null) goto L8;
        j<com.bytedance.android.live.user.api.a> r102 = r101.getUserContext();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getValue();
    L8:
        return null;
    }

    private final Single<BaseResponse<IBaseUser, UserExtra>> queryUserWithParamsMapWithHeaders(HashMap<String, ? extends String> r100, Map<String, String> r101) {
        return this.userRequester.a(r100, r101);
    }

    private final Single<BaseResponse<IBaseUser, UserExtra>> queryUserWithSecUid(String r100, String r101) {
        return this.userRequester.l(r100, r101);
    }

    @Override // com.bytedance.android.live.user.api.IUserServiceV2
    public com.bytedance.android.live.user.api.a createUserContext(DataCenter r100, DataContext r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        ALogger.i(TAG, "call createUserContext ");
        UserContext.b r102 = UserContext.Companion;
        dc1.b r103 = this.userRequester;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "dataContext");
        Intrinsics.checkNotNullParameter(r103, "userRequester");
        return new UserContext(r100, (MiddlewareRoomContext) r101, r103, null);
    }

    @Override // com.bytedance.android.live.user.api.IUserServiceV2
    public Single<? extends IBaseUser> updateCurrentUser(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "callFrom");
        if (r100 == null) goto L5;
        com.bytedance.android.live.user.api.a r102 = com.bytedance.android.live.user.api.b.a(r100);
    L13:
        if (r102 == null) goto L19;
        UserContext.Companion.getClass();
        UserContext r103 = UserContext.b.a(r102);
        if (r103 == null) goto L28;
        Single<? extends IBaseUser> r104 = r103.requestAndUpdateUser(r101);
        if (r104 == null) goto L28;
        return r104;
    L28:
        return Single.error(new Exception("UserContext is null"));
    L19:
        IMiddlewareUserService r105 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r105 == null) goto L26;
        e r106 = r105.user();
        if (r106 == null) goto L26;
        Single<? extends IBaseUser> r107 = r106.j();
        if (r107 == null) goto L26;
        return r107;
    L26:
        return Single.error(new Exception("userService is null"));
    L5:
        int r108 = com.bytedance.android.live.user.api.b.f102505a;
        Object r109 = d.d(com.bytedance.android.live.user.api.a.class);
        if ((r109 instanceof com.bytedance.android.live.user.api.a) == true) goto L8;
        r109 = null;
    L8:
        r102 = (com.bytedance.android.live.user.api.a) r109;
        StringBuilder r110 = new StringBuilder("get IUserContext, Static, isNull = ");
        if (r102 != null) goto L11;
        boolean r111 = true;
    L12:
        r110.append(r111);
        ALogger.i("UserCtx", r110.toString());
        goto L13
    L11:
        r111 = false;
        goto L12
    }
}
