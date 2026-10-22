package f3;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements CommonEventConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile l2.a f19445a;

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    public class C0249a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19446a;

        public C0249a(a r10) {
            this.f19446a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            a.a(this.f19446a, r10, r11);
        }
    }

    public a() {
        g3.a.g().h();
        g3.a.g().k(new C0249a(this));
    }

    public static /* synthetic */ void a(a r10, JSONObject r11, boolean r12) {
        r10.b(r11, r12);
    }

    public final void b(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("custom_event_settings");
        if (r12 == null) goto L29;
        JSONObject r13 = r12.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
        HashSet r14 = new HashSet();
        if (r13 == null) goto L10;
        Iterator<String> r15 = r13.keys();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14.add(r15.next());
    L10:
        HashSet r16 = new HashSet();
        JSONObject r17 = r12.optJSONObject("allow_log_type");
        if (r17 == null) goto L18;
        Iterator<String> r18 = r17.keys();
    L14:
        if (r18.hasNext() == false) goto L18;
        String r19 = r18.next();
        if (r17.optInt(r19) != 1) goto L14;
        r16.add(r19);
    L18:
        this.f19445a = new l2.a(r14, r16);
        if (r3.a.c() == false) goto L21;
        s3.a.a(ConfigConstants.LOG_TAG, "received customEventSettings=" + r12);
        s3.a.a(ConfigConstants.LOG_TAG, "parsed CommonEventConfig=" + this.f19445a);
    L21:
        k2.a.updateConfig(getConfig());
        return;
    }

    @Override // com.bytedance.apm6.commonevent.config.CommonEventConfigService
    public l2.a getConfig() {
        return this.f19445a;
    }
}
