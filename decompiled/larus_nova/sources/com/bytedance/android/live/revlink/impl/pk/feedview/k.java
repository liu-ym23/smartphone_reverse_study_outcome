package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f96487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b f96488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f96489c;

    public k(MediatorLiveData r100, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r101, Function0 r102) {
        this.f96487a = r100;
        this.f96488b = r101;
        this.f96489c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r101 = (com.bytedance.android.live.revlink.impl.pk.feedview.machine.l) r100;
        JSONObject r102 = new JSONObject();
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r103 = this.f96488b.f96657e;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.f96579b;
    L6:
        r102.put("state", r105);
        IBaseBattleSetting r106 = this.f96488b.b();
        if (r106 == null) goto L11;
        IBattleConfigSetting r107 = r106.getBattleConfigSetting();
        if (r107 == null) goto L11;
        int r108 = r107.getModType();
    L12:
        r102.put(FastStartLiveConfig.PLAY_MODE, r108);
        r102.put("skin_type", this.f96488b.d());
        IBaseBattleSetting r109 = this.f96488b.b();
        String r110 = null;
        if (r109 == null) goto L15;
        String r111 = String.valueOf(r109.getBattleId());
    L16:
        r102.put("battle_id", r111);
        IBaseBattleSetting r112 = this.f96488b.b();
        if (r112 == null) goto L19;
        r110 = String.valueOf(r112.getBattleId());
    L19:
        r102.put("battle_id_str", r110);
        r102.put("channel_id_str", this.f96489c.invoke());
        IBaseBattleSetting r113 = this.f96488b.b();
        if (r113 == null) goto L23;
        String r114 = r113.getLynxData();
        if (r114 == null) goto L23;
    L24:
        r102.put("lynx_data", r114);
        q11.a r115 = this.f96488b.f96664l;
        if (r115 == null) goto L29;
        RevPkResult r116 = r115.a();
        if (r116 == null) goto L29;
        r104 = r116.ordinal();
    L29:
        r102.put("pk_result", r104);
        this.f96487a.setValue(r102.toString());
        return;
    L23:
        r114 = "";
        goto L24
    L15:
        r111 = null;
    L11:
        r108 = 0;
        goto L12
    L5:
        r105 = 0;
        goto L6
    }
}
