package com.bytedance.android.livesdkapi.room.state;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 !2\u00020\u0001:\u0001!B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/room/state/UserState;", "Lcom/bytedance/android/livesdkapi/room/state/IUserState;", "uid", "", "secUid", "isLoginFunc", "Lkotlin/Function0;", "", "streamType", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "reportParams", "", "extra", "Landroid/os/Bundle;", "userName", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;Ljava/util/Map;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getExtra", "()Landroid/os/Bundle;", Keys.API_RETURN_KEY_IS_LOGIN, "()Z", "()Lkotlin/jvm/functions/Function0;", "openId", "getOpenId", "getReportParams", "()Ljava/util/Map;", "getSecUid", "getStreamType", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "getUid", "getUserName", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserState implements IUserState {
    public static final Companion Companion = null;
    private static final String EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE = null;
    private static final String EXTRA_BOOL_HAS_LAST_ROOM = null;
    private final String avatarUrl;
    private final Bundle extra;
    private final Function0<Boolean> isLoginFunc;
    private final Map<String, String> reportParams;
    private final String secUid;
    private final LiveMode streamType;
    private final String uid;
    private final String userName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/state/UserState$Companion;", "", "()V", "EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE", "", "getEXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE", "()Ljava/lang/String;", "EXTRA_BOOL_HAS_LAST_ROOM", "getEXTRA_BOOL_HAS_LAST_ROOM", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final String getEXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE() {
            return UserState.access$getEXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE$cp();
        }

        public final String getEXTRA_BOOL_HAS_LAST_ROOM() {
            return UserState.access$getEXTRA_BOOL_HAS_LAST_ROOM$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE = "EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE";
        EXTRA_BOOL_HAS_LAST_ROOM = "EXTRA_BOOL_HAS_LAST_ROOM";
    }

    public final String getOpenId() {
        return getUid();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IUserState
    public /* bridge */ /* synthetic */ ILiveMode getStreamType() {
        return getStreamType();
    }

    public final boolean isLogin() {
        return isLoginFunc().invoke().booleanValue();
    }

    public static final /* synthetic */ String access$getEXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE$cp() {
        return EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE;
    }

    public static final /* synthetic */ String access$getEXTRA_BOOL_HAS_LAST_ROOM$cp() {
        return EXTRA_BOOL_HAS_LAST_ROOM;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IUserState
    public Bundle getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IUserState
    public Map<String, String> getReportParams() {
        return this.reportParams;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IUserState
    public String getSecUid() {
        return this.secUid;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IUserState
    public String getUid() {
        return this.uid;
    }

    public final String getUserName() {
        return this.userName;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IUserState
    public Function0<Boolean> isLoginFunc() {
        return this.isLoginFunc;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IUserState
    public LiveMode getStreamType() {
        return this.streamType;
    }

    public UserState(String r100, String r101, Function0<Boolean> r102, LiveMode r103, Map<String, String> r104, Bundle r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "secUid");
        Intrinsics.checkNotNullParameter(r102, "isLoginFunc");
        Intrinsics.checkNotNullParameter(r103, "streamType");
        Intrinsics.checkNotNullParameter(r104, "reportParams");
        Intrinsics.checkNotNullParameter(r105, "extra");
        this.uid = r100;
        this.secUid = r101;
        this.isLoginFunc = r102;
        this.streamType = r103;
        this.reportParams = r104;
        this.extra = r105;
        this.userName = r106;
        this.avatarUrl = r107;
    }

    public /* synthetic */ UserState(String r110, String r111, Function0 r112, LiveMode r113, Map r114, Bundle r115, String r116, String r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 64) == 0) goto L5;
        String r117 = null;
    L7:
        if ((r211 & 128) == 0) goto L9;
        String r118 = null;
    L10:
        this(r110, r111, r112, r113, r114, r115, r117, r118);
        return;
    L9:
        r118 = r210;
        goto L10
    L5:
        r117 = r116;
        goto L7
    }
}
