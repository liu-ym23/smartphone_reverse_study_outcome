package com.bytedance.android.live.user.api.event;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/user/api/event/UpdateUserType;", "", "", "toString", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "IN_ROOM", HTTP.HOST, "liveuser-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UpdateUserType extends Enum<UpdateUserType> {
    public static final UpdateUserType HOST = null;
    public static final UpdateUserType IN_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateUserType[] f102510a = null;
    private final String type;

    static {
        UpdateUserType r100 = new UpdateUserType("IN_ROOM", 0, "in_room");
        IN_ROOM = r100;
        UpdateUserType r101 = new UpdateUserType(HTTP.HOST, 1, "host");
        HOST = r101;
        f102510a = new UpdateUserType[]{r100, r101};
    }

    public static UpdateUserType valueOf(String r100) {
        return (UpdateUserType) a.a(UpdateUserType.class, r100);
    }

    public static UpdateUserType[] values() {
        return (UpdateUserType[]) f102510a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UpdateUserType(type=" + this.type + ')';
    }

    public final String getType() {
        return this.type;
    }

    public UpdateUserType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
