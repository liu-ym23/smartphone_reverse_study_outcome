package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.customize.IInternalFollowTool;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.HostFollowParams;
import com.bytedance.android.livehostapi.platform.depend.user.IFollowCallback;
import com.bytedance.android.livesdk.config.u30;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "userAction")
public final class e5 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f142115a;

    public class a implements IFollowCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e5 f142116a;

        public a(e5 r100) {
            this.f142116a = r100;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.user.IFollowCallback
        public final void onCancel(Throwable r100) {
            this.f142116a.finishWithFailure(r100);
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.user.IFollowCallback
        public final void onSuccess(int r100) {
            this.f142116a.finishWithSuccess();
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f142115a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public e5() {
    }

    public static void j(e5 r100, Throwable r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();
        r102.put("code", 0);     // Catch: JSONException -> L16
        if ((r101 instanceof ApiException) == false) goto L12;
        r102.put("error_code", ((ApiException) r101).getErrorCode());     // Catch: JSONException -> L16
        if ((r101 instanceof ApiServerException) == false) goto L9;
        r102.put("message", ((ApiServerException) r101).getErrorMsg());     // Catch: JSONException -> L16
        r102.put("prompts", ((ApiServerException) r101).getPrompt());     // Catch: JSONException -> L16
    L9:
        if (u30.f121343a.getValue().booleanValue() == false) goto L12;
        r100.finishWithResult(r102);     // Catch: JSONException -> L16
        return;
    L12:
        if (u30.f121343a.getValue().booleanValue() == false) goto L14;
        r100.finishWithFailure();     // Catch: JSONException -> L16
        return;
    L14:
        r100.finishWithResult(r102);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.bytedance.android.livesdk.jsbridge.methods.w4] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.bytedance.android.livesdk.jsbridge.methods.v4] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r210, CallContext r211) throws Exception {
        String r100 = r210.optString("type");
        JSONObject r101 = r210.optJSONObject("args");
        if (r101 == null) goto L77;
    L5:
        com.bytedance.apm.util.j.b(r101, new JSONObject(r210.optString("dsl_extra_params")));     // Catch: Throwable -> L7
    L8:
        final JSONObject r102 = r101;
        if (r102 != null) goto L12;
        finishWithFailure();
        return;
    L12:
        Boolean r103 = Boolean.valueOf(r210.optBoolean("through_aweme", true));
        long r110 = 0;
        if (TextUtils.equals("follow", r100) == false) goto L41;
        if (r103.booleanValue() == false) goto L38;
        Context r104 = r211.getContext();
        String r105 = r211.f249267b;
        int r106 = com.bytedance.android.live.base.model.user.n0.f58945a;
        String r107 = com.bytedance.android.live.base.model.user.o0.a.e(com.bytedance.android.live.base.model.user.o0.f58946a, r102, "user_id");
        r110 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r102, "room_id"));     // Catch: Exception -> L19
    L21:
        long r212 = r110;
        String r108 = r102.optString("enter_from", "search_result");
        String r109 = r102.optString("source", "recommend");
        String r111 = r102.optString("from_label");
        String r112 = r102.optString("url");
        String r113 = r102.optString("sec_user_id");
        HashMap<String, String> r114 = new HashMap();
        Iterator<String> r115 = r102.keys();
    L23:
        if (r115.hasNext() == false) goto L27;
        String r116 = r115.next();
        if (r116 == null) goto L23;
        r114.put(r116, r102.optString(r116));
        r115 = r115;
        goto L23
    L27:
        if (r105 == null) goto L29;
        r114.put("web_page_source", r105);
    L29:
        String r117 = r102.optString("follow_scene", "");
        if (TextUtils.isEmpty(r117) == false) goto L71;
    L37:
        FollowPair r118 = new FollowPair();
        r118.setType(IFollowPair.Type.FromWeb);
        r118.setUserId(r107);
        r118.setSecUserId(r113);
        r118.setRoomId(r212);
        r118.setUrl(r112);
        r118.setFromLabel(r111);
        r118.setFollow(true);
        r118.setExtraParams(r114);
        k(r118, r104, r108, r109);
    L89:
        return;
    L71:
        HashMap<String, String> r119 = com.bytedance.android.livesdk.user.j.a(CastIntegerProtector.parseInt(r117));     // Catch: Exception -> L35
        if (r119 == null) goto L37;
        r114.putAll(r119);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        SafetyGuard.a(null, e, null);
    L19:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r120 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r121 = e.getStackTrace();
        r120.getClass();
        com.bytedance.android.live.core.log.g.m(5, r121);
        goto L21
    L38:
        l(r102, r211.getContext(), 1);
        goto L89
    L41:
        if (TextUtils.equals("unfollow", r100) == true) goto L43;
        finishWithFailure();
        return;
    L43:
        if (r103.booleanValue() == false) goto L66;
        final Context r213 = r211.getContext();
        String r122 = r211.f249267b;
        final String r123 = r102.optString("enter_from", "search_result");
        final String r124 = r102.optString("enter_from", "recommend");
        int r125 = com.bytedance.android.live.base.model.user.n0.f58945a;
        final String r214 = com.bytedance.android.live.base.model.user.o0.a.e(com.bytedance.android.live.base.model.user.o0.f58946a, r102, "user_id");
        final long r126 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r102, "room_id"));     // Catch: Exception -> L47
    L49:
        final String r215 = r102.optString("from_label", "");
        final String r127 = r102.optString("url", "");
        final String r128 = r102.optString("sec_user_id");
        final HashMap r129 = new HashMap();
        Iterator<String> r130 = r102.keys();
    L51:
        if (r130.hasNext() == false) goto L55;
        String r131 = r130.next();
        if (r131 == null) goto L51;
        r129.put(r131, r102.optString(r131));
        goto L51
    L55:
        if (r122 == null) goto L57;
        r129.put("web_page_source", r122);
    L57:
        String r132 = r102.optString("follow_scene", "");
        if (TextUtils.isEmpty(r132) == false) goto L69;
    L65:
        com.bytedance.android.livesdk.user.f r133 = ((IUserService) jc1.k.f(IUserService.class)).user();
        com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_dlg_unfollow);
        r133.C(new v4(this, r102, r214, r126, r128, r127, r215, r129, r213, r123, r124), r213, r215, r214, new w4(this));
        return;
    L69:
        HashMap<String, String> r134 = com.bytedance.android.livesdk.user.j.a(CastIntegerProtector.parseInt(r132));     // Catch: Exception -> L63
        if (r134 == null) goto L65;
        r129.putAll(r134);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        SafetyGuard.a(null, e, null);
    L47:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r135 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r136 = e.getStackTrace();
        r135.getClass();
        com.bytedance.android.live.core.log.g.m(5, r136);
        r126 = 0;
        goto L49
    L66:
        l(r102, r211.getContext(), 0);
        return;
    L7:
        ALogger.i("JSB-userAction", "parse args error.");
        goto L8
    L77:
        r101 = new JSONObject(r210.optString("args"));     // Catch: Throwable -> L7
        goto L5
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final /* bridge */ /* synthetic */ void invoke(JSONObject r100, CallContext r101) throws Exception {
        invoke2(r100, r101);
    }

    public final void l(JSONObject r100, Context r101, int r102) {
        if ((r101 instanceof FragmentActivity) == false) goto L6;
        FragmentActivity r103 = (FragmentActivity) r101;
    L10:
        HostFollowParams r104 = new HostFollowParams();
        r104.followStatus = r102;
        r104.targetUid = r100.optString("user_id");
        r104.fromLabel = r100.optString("from_label");
        TTLiveSDK.hostService().user().hostUserFollow(r103, r104, new a(this));
        return;
    L6:
        if ((r101 instanceof ContextWrapper) == false) goto L13;
        ContextWrapper r105 = (ContextWrapper) r101;
        if ((r105.getBaseContext() instanceof FragmentActivity) == false) goto L13;
        r103 = (FragmentActivity) r105.getBaseContext();
    L13:
        throw new IllegalArgumentException("Argument \"context\" cannot be transformed to FragmentActivity in UserCenter.login() method. ");
    }

    public final void k(final FollowPair r100, final Context r110, final String r111, final String r112) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((IUserService) jc1.k.f(IUserService.class)).user().isLogin() == true) goto L10;
        if ((r110 instanceof FragmentActivity) == false) goto L17;
        com.bytedance.android.livesdk.user.f r101 = ((IUserService) jc1.k.f(IUserService.class)).user();
        com.bytedance.android.livesdk.user.l.a r102 = new com.bytedance.android.livesdk.user.l.a();
        r102.f158685a = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_login_dialog_message);
        r102.f158687c = -1;
        r102.f158689e = r111;
        r102.f158688d = r112;
        r102.f158691g = "follow";
        this.f142115a = r101.login((FragmentActivity) r110, new com.bytedance.android.livesdk.user.l(r102)).subscribe(new x4(this, r100, r110, r111, r112), new y4(this));
        return;
    L17:
        return;
    L10:
        if (r100.isFollow() == false) goto L13;
        this.f142115a = ((IInternalFollowTool) jc1.k.f(IInternalFollowTool.class)).makeFollowByRoom(r110, ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom(), new z4(r100)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a5(this), new b5(this));
        return;
    L13:
        if ((r110 instanceof Activity) == true) goto L15;
        return;
    L15:
        Activity r103 = (Activity) r110;
        this.f142115a = ((IInternalFollowTool) jc1.k.f(IInternalFollowTool.class)).makeUnFollowByRoom(r103, ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom(), new c5(r100, r110)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d5(this), new b5(this));
    }
}
