package aac;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.settings.v1.GetUserSettingRequest;
import com.bytedance.lark.pb.settings.v1.GetUserSettingResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aac.b f2389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2391c;

    public class a implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f2392a;

        public a(g r100) {
            this.f2392a = r100;
        }

        @Override // aac.f.b
        public final void a(UserSetting r100) {
            this.f2392a.f2389a.b(r100);
        }
    }

    public class b implements SdkSender.IParser<UserSetting> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f2393a;

        public b(g r100) {
            this.f2393a = r100;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final UserSetting parse(byte[] r100) throws IOException {
            UserSetting r101 = aac.c.b(GetUserSettingResponse.ADAPTER.decode(r100));
            this.f2393a.f2389a.b(r101);
            return r101;
        }
    }

    public class c implements SdkSender.IParser<UserSetting> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f2394a;

        public c(g r100) {
            this.f2394a = r100;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final UserSetting parse(byte[] r100) throws IOException {
            UserSetting r101 = aac.c.b(GetUserSettingResponse.ADAPTER.decode(r100));
            this.f2394a.f2389a.b(r101);
            return r101;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f2395a = null;

        static {
            f2395a = new g();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UserSetting a() {
        UserSetting r100 = this.f2389a.a();
        if (r100 == null) goto L5;
        return r100;
    L5:
        Log.i("GET_USER_SETTING", "get user setting v2 from local");
        GetUserSettingRequest.Builder r101 = new GetUserSettingRequest.Builder().is_from_server(Boolean.FALSE);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.setting.user_setting_opt") == false) goto L8;
        r101.sync_data_strategy(SyncDataStrategy.LOCAL);
    L8:
        SdkSender.d r102 = SdkSender.syncSendMayError(Command.GET_USER_SETTING, r101, new c(this));
        if (r102.f439868b == null) goto L13;
        Log.e("UserSettingService", "get user setting occurs error: " + r102.f439868b.getMessage());
        return null;
    L13:
        return (UserSetting) r102.f439867a;
    }

    public g() {
        this.f2391c = new a(this);
        this.f2389a = new aac.b();
        this.f2390b = new AtomicBoolean(false);
    }

    public final void b(IGetDataCallback<UserSetting> r100) {
        Log.i("GET_USER_SETTING", "get user setting v2 from net");
        GetUserSettingRequest.Builder r101 = new GetUserSettingRequest.Builder().is_from_server(Boolean.TRUE);
        SdkSender.asynSendRequestNonWrap(Command.GET_USER_SETTING, r101, r100, new b(this));
    }

    public final void c(aac.b.a r100) {
        Map<aac.b.a, Object> r101 = this.f2389a.f2381c;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100, aac.b.f2378d);
    }
}
