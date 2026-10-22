package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.util.NetworklibUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DelayTypedAction extends BaseDispatchAction {
    private static final String TAG = "DelayTypedAction";
    private static final String kProcessTagKey = "p";
    private static final String kStartUpTagKey = "s";
    private int mDelayTime;
    private int mRandomLeft;
    private int mRandomRight;
    private final Map<String, Set<String>> mTncTagMap;

    static {
    }

    public DelayTypedAction() {
        this.mDelayTime = 0;
        this.mRandomLeft = 0;
        this.mRandomRight = 0;
        this.mTncTagMap = new HashMap();
    }

    public BaseDispatchAction.DispatchResultEnum takeDelayAction(String r3, String r4, List<Integer> r5) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "take delay action");
    L6:
        if (isDelayActionEffective() == true) goto L8;
    L12:
        r5.set(0, 0);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L12;
        return findDelayResult(r3, r4, r5);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean initWithActionParam(JSONObject r6, String r7, long r8) {
        loadMatchRules(r6);
        String r9 = r6.optString(SimContactsConstants.STR_TAG);
        int r10 = 0;
        if (TextUtils.isEmpty(r9) == true) goto L17;
        String[] r11 = r9.split(";");
        int r12 = r11.length;
        int r0 = 0;
    L5:
        if (r0 >= r12) goto L17;
        String r1 = r11[r0];
        ArrayList r2 = new ArrayList();
        if (NetworklibUtils.splitStringIntoKeyValuePairs(r1, SimContactsConstants.EMAIL_SEP, "=", r2) == false) goto L16;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair r4 = (Pair) r3.next();
        Set<String> r5 = this.mTncTagMap.get(r4.first);
        if (r5 != null) goto L15;
        r5 = new HashSet();
    L15:
        r5.add((String) r4.second);
        this.mTncTagMap.put((String) r4.first, r5);
    L16:
        r0 = r0 + 1;
    L17:
        this.mDelayTime = r6.optInt("delay");
        JSONArray r13 = r6.optJSONArray("random");
        if (this.mDelayTime > 0) goto L37;
        if (r13 == null) goto L37;
        if (r13.length() == 2) goto L44;
        return false;
    L44:
        int r14 = r13.getInt(0);     // Catch: JSONException -> L28
        int r15 = r13.getInt(1);     // Catch: JSONException -> L26
    L31:
        if (r14 <= 0) goto L36;
        if (r15 <= 0) goto L36;
        if (r14 >= r15) goto L36;
        r10 = r14;
    L38:
        this.mRandomLeft = r10;
        this.mRandomRight = r15;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "initwithparam tnc tag map is " + this.mTncTagMap);
    L41:
        return true;
    L36:
        return false;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        r15 = 0;
    L28:
        e = e;
        r14 = 0;
    L37:
        r15 = 0;
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BaseDispatchAction.DispatchResultEnum findDelayResult(String r5, String r6, List<Integer> r7) {
        Uri r8 = Uri.parse(r5);
        if (r8.getHost() == null) goto L59;
        if (isMatchRules(r8) == false) goto L59;
        if (this.mTncTagMap.isEmpty() == false) goto L15;
        r7.set(0, Integer.valueOf(getDelayTimeForRequest()));
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "tnc tag map is empty, result delay time is " + r7.get(0));
    L13:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
    L15:
        if (TTDelayStateManager.getRequestTagDelayEnabled() == true) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "this action with tag is not enabled");
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if ("".equals(r6) == false) goto L24;
        r6 = "s=0;p=0";
    L24:
        HashMap r9 = new HashMap();
        ArrayList r1 = new ArrayList();
        if (NetworklibUtils.splitStringIntoKeyValuePairs(r6, ";", "=", r1) == false) goto L27;
        Iterator r2 = r1.iterator();
    L30:
        if (r2.hasNext() == false) goto L32;
        Pair r3 = (Pair) r2.next();
        r9.put((String) r3.first, (String) r3.second);
        goto L30
    L32:
        String r4 = Integer.toString(TTDelayStateManager.AppStartState.NormalStart.getValue());
        if (TTDelayStateManager.getAppStartUpState() == TTDelayStateManager.AppStartState.NormalStart) goto L35;
        r4 = Integer.toString(TTDelayStateManager.getCurrentStartUpState().getValue());
    L35:
        r9.put(kStartUpTagKey, r4);
        Context r10 = URLDispatcher.inst().getContext();
        if (r10 == null) goto L38;
        boolean r11 = ProcessUtils.isMainProcessByProcessFlag(r10);
    L39:
        r9.put(kProcessTagKey, Integer.toString(!r11));
        if (Logger.debug() == false) goto L42;
        Logger.d(TAG, "request tag string is " + r6);
    L42:
        BaseDispatchAction.DispatchResultEnum r12 = BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
        Iterator<Map.Entry<String, Set<String>>> r13 = this.mTncTagMap.entrySet().iterator();
    L44:
        if (r13.hasNext() == false) goto L52;
        Map.Entry<String, Set<String>> r14 = r13.next();
        String r15 = (String) r9.get(r14.getKey());
        if (r15 == null) goto L47;
        if (r14.getValue().contains(r15) == true) goto L44;
        r12 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        goto L52
    L47:
        r12 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L52:
        if (r12 != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L55;
        r7.set(0, Integer.valueOf(getDelayTimeForRequest()));
    L55:
        if (Logger.debug() == false) goto L57;
        String r16 = TAG;
        Logger.d(r16, "match tag result is " + r12);
        Logger.d(r16, "will delay time is " + r7.get(0));
        Logger.d(r16, "request tag map is " + r9);
        Logger.d(r16, "tnc tag map is " + this.mTncTagMap);
    L57:
        return r12;
    L38:
        r11 = 1;
        goto L39
    L27:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L59:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    }

    private int getDelayTimeForRequest() {
        int r0 = this.mDelayTime;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (this.mRandomLeft < this.mRandomRight) goto L8;
        return 0;
    L8:
        return new Random().nextInt(this.mRandomRight - this.mRandomLeft) + this.mRandomLeft;
    }
}
