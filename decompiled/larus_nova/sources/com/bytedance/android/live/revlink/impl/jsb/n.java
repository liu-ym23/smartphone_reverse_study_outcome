package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes47.dex */
public final class n extends wy0.b<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f92609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f92610b;

    @JsonAdapter(InvitePkMethod_ParamsSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/n$a;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.j<a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.jsb.n$a$a, reason: collision with other inner class name */
        @JsonAdapter(InvitePkMethod_ParamsSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C1439a {
        }

        @FieldName(name = "sec_to_user_id")
        String L2();

        @FieldName(name = "battle_config_setting")
        String getBattleConfigSetting();

        @FieldName(name = "duration")
        int getDuration();

        @FieldName(name = "extra")
        JsonObject getExtra();

        @FieldName(name = "invite_type")
        Integer getInviteType();

        @FieldName(name = "sign_extra")
        String getSignExtra();

        @FieldName(name = "to_room_id")
        long getToRoomId();

        @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
        String getToUserId();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/n$b;", "", "", "code", "I", "getCode", "()I", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("code")
        private final int code;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.code == ((b) r100).code) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.code;
        }

        public final String toString() {
            return "Result(code=" + this.code + ")";
        }

        public b(int r100) {
            this.code = r100;
        }
    }

    @Override // wy0.b
    public final Type k() {
        return this.f92609a;
    }

    public n(com.bytedance.android.live.revlink.impl.global.c r100) {
        this.f92610b = r100;
        this.f92609a = TypesJVMKt.getJavaType(Reflection.typeOf(a.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r110, CallContext r111) {
        a r112 = (a) r110;
        Intrinsics.checkNotNullParameter(r112, "param");
        Intrinsics.checkNotNullParameter(r111, "callContext");
    L21:
        finishWithFailure();
        return;
    L4:
        if (r112.L2() != null) goto L6;
        finishWithResult(new b(0));     // Catch: Throwable -> L21
        return;
    L6:
        com.bytedance.android.live.revlink.impl.global.c r113 = this.f92610b;     // Catch: Throwable -> L21
        if (r113 == null) goto L9;
        com.bytedance.android.live.revlink.impl.pk.service.b r114 = r113.Ud();     // Catch: Throwable -> L21
    L10:
        com.bytedance.android.live.revlink.impl.pk.service.b r100 = r114;
        if (r100 == null) goto L25;
        long r101 = r112.getToRoomId();     // Catch: Throwable -> L21
        String r102 = r112.L2();     // Catch: Throwable -> L21
        String r103 = r112.getToUserId();     // Catch: Throwable -> L21
        int r104 = r112.getDuration();     // Catch: Throwable -> L21
        Integer r105 = r112.getInviteType();     // Catch: Throwable -> L21
        String r115 = r112.getSignExtra();     // Catch: Throwable -> L21
        if (r115 != null) goto L16;
        r115 = "";
    L16:
        String r106 = r112.getBattleConfigSetting();     // Catch: Throwable -> L21
        if (r106 != null) goto L19;
        r106 = "";
    L19:
        String r107 = r115;
        r100.invitePkByJsb(r101, r102, r103, r104, r105, r107, r106, InvitePkMethodKt.a(r112), new o(this));     // Catch: Throwable -> L21
        return;
    L25:
        return;
    L9:
        r114 = null;
        goto L10
    }
}
