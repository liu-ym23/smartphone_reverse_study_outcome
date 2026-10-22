package c77;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import org.json.JSONObject;
import v67.f;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends BaseJson implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22656a;

    public c() {
        this.f22656a = new a();
    }

    public final void b(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        String r102 = String.valueOf(CastLongProtector.parseLong(r100.optString(Constants.Keys.KEY_CLIENT_TIME)) / 1000);     // Catch: NumberFormatException -> L5
    L6:
        add(r101, Constants.Keys.KEY_CLIENT_TIME, r102);
        add(r101, "rid", r100.optString("rule_id"));
        add(r101, "rid64", r100.optString("rule_id64"));
        add(r101, "group_id", r100.optString("ttpush_group_id"));
        add(r101, "sender", r100.optString("sender"));
        ThreadPlus.submitRunnable(new b("show", r101));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void c(JSONObject r110) {
        String r100 = r110.optString("rule_id64");
        String r101 = r110.optString("sender");
        a r102 = this.f22656a;
        r102.getClass();
        long r103 = SystemClock.elapsedRealtime();
        if (TextUtils.equals(r102.f22653c, r101) == true) goto L5;
    L9:
        r102.f22652b = r100;
        r102.f22653c = r101;
        r102.f22651a = r103;
        boolean r104 = false;
    L11:
        if (r104 == false) goto L14;
        com.bytedance.push.utils.f.b("MessageCallbackServiceImpl", "not callback message click because mClickHelper.isDoubleClick,rid64:" + r100 + " sender:" + r101);
        return;
    L14:
        JSONObject r105 = new JSONObject();
        String r106 = String.valueOf(CastLongProtector.parseLong(r110.optString(Constants.Keys.KEY_CLIENT_TIME)) / 1000);     // Catch: NumberFormatException -> L17
    L18:
        add(r105, Constants.Keys.KEY_CLIENT_TIME, r106);
        add(r105, "rid", r110.optString("rule_id"));
        add(r105, BdpAppEventConstant.PARAMS_CLICK_POSITION, r110.optString(BdpAppEventConstant.PARAMS_CLICK_POSITION));
        add(r105, "group_id", r110.optString("ttpush_group_id"));
        add(r105, "rid64", CastLongProtector.parseLong(r100));     // Catch: NumberFormatException -> L21
        add(r105, "sender", CastIntegerProtector.parseInt(r101));     // Catch: NumberFormatException -> L21
    L22:
        ThreadPlus.submitRunnable(new b("click", r105));
        return;
    L21:
        com.bytedance.push.utils.f.e("MessageCallbackServiceImpl", "error when parse rid64 and sender to int,rid64:" + r100 + " sender:" + r101);
    L17:
        r106 = null;
        goto L18
    L5:
        if ((r103 - r102.f22651a) > 1000) goto L9;
        if (TextUtils.equals(r102.f22652b, r100) == false) goto L9;
        r104 = true;
        goto L11
    }

    public final void d(boolean r100, JSONObject r101) {
        if (r100 == false) goto L6;
        com.bytedance.push.utils.f.b("MessageCallbackServiceImpl", "callback message click because body.callbackClick is true,param is " + r101);
        c(r101);
        return;
    L6:
        com.ss.android.pushmanager.setting.b.b().getClass();
        if (com.ss.android.pushmanager.setting.b.d().a0().f544902b == false) goto L10;
        com.bytedance.push.utils.f.b("MessageCallbackServiceImpl", "callback message click because MsgCallbackSettings.callbackMsgClick is true, param is " + r101);
        c(r101);
        return;
    L10:
        com.bytedance.push.utils.f.b("MessageCallbackServiceImpl", "not callback message click");
    }
}
