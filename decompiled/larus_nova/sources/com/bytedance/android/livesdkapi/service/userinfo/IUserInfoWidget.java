package com.bytedance.android.livesdkapi.service.userinfo;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import kotlin.Metadata;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/userinfo/IUserInfoWidget;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalWidget;", "getTargetView", "Landroid/view/View;", "scene", "Lcom/bytedance/android/livesdkapi/service/userinfo/IUserInfoWidget$Target;", "onEvent", "", "eventName", "", "eventParams", "Lorg/json/JSONObject;", "Target", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserInfoWidget extends IExternalWidget {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/userinfo/IUserInfoWidget$Target;", "", "(Ljava/lang/String;I)V", "ENTRANCE_CONTAINER", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Target extends Enum<Target> {
        private static final /* synthetic */ Target[] $VALUES = null;
        public static final Target ENTRANCE_CONTAINER = null;

        static {
            Target r100 = new Target("ENTRANCE_CONTAINER", 0);
            ENTRANCE_CONTAINER = r100;
            $VALUES = new Target[]{r100};
        }

        public static Target valueOf(String r100) {
            return (Target) a.a(Target.class, r100);
        }

        public static Target[] values() {
            return (Target[]) $VALUES.clone();
        }

        private Target(String r100, int r101) {
            super(r100, r101);
        }
    }

    View getTargetView(Target r100);

    void onEvent(String r100, JSONObject r101);
}
