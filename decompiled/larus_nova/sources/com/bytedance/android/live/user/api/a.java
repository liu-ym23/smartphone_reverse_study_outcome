package com.bytedance.android.live.user.api;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.live.user.api.event.UpdateUserReason;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends IAbility {
    public static final C1550a J0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.user.api.a$a, reason: collision with other inner class name */
    public static final class C1550a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f102503a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C1550a f102504b = null;

        public C1550a() {
        }

        static {
            f102504b = new C1550a();
            User r100 = new User();
            int r101 = c.f102506c;
            UpdateUserReason r102 = UpdateUserReason.USER_CONTEXT_CREATE_DEFAULT;
            Intrinsics.checkNotNullParameter(r100, "user");
            Intrinsics.checkNotNullParameter(r102, "updateUserReason");
            f102503a = new c(r100, r102);
        }
    }

    static {
        J0 = C1550a.f102504b;
    }

    Observable<cc1.a> currentUserChange();

    d<List<LiveRoomPermission>> getCurrentPermissions();

    Observable<List<ec1.a>> getOnPermissionChangeDelete();

    d<User> getUser();

    d<Boolean> isAdmin();

    Observable<List<ec1.a>> onPermissionChangeType(LiveRoomPermission... r100);

    void updateUserForRev(String r100);
}
