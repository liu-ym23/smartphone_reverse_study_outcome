package com.obric.autoaction;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.CommonExpandedTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.obric.livecard.api.island.IslandApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.a;
import d.h.b.o;
import d.h.b.z;
import d.x;

/* JADX INFO: compiled from: IslandDebugActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IslandDebugActivity extends AppCompatActivity {
    private final void addOnViewClickCallback(String r1, a<x> r2) {
        a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ x lambda$0_99eEqUwP0vPSagUmwhH_NDHM0() {
        return onCreate$lambda$7$lambda$6$lambda$5();
    }

    public static /* synthetic */ void lambda$GlH6xBiTZKvqRWpsP44y49x7g50(z.f r0, View r1) {
        onCreate$lambda$9(r0, r1);
    }

    public static /* synthetic */ void lambda$Nh4qNDf57RiBMmOCcrmxXQAfytQ(z.f r0) {
        onCreate$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$ZRF8GLV2RiiTJUMQrTDLcZPWt3o(z.f r0, View r1) {
        onCreate$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$hbxug1-1UrmnOiAbgdHoV94ikEY, reason: not valid java name */
    public static /* synthetic */ void m441lambda$hbxug11UrmnOiAbgdHoV94ikEY(IslandDebugActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    public static /* synthetic */ void lambda$utu34PXWDRNE3uAydar9xGB0GBg(z.f r0, IslandDebugActivity r1, View r2) {
        onCreate$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$xtBFLkXdyyLZvJ_2W0Ttuz0afn8(com.obric.autoaction.b.a r0, z.f r1, View r2) {
        onCreate$lambda$2(r0, r1, r2);
    }

    public IslandDebugActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        final com.obric.autoaction.b.a r5 = com.obric.autoaction.b.a.a(getLayoutInflater());
        o.c(r5, "inflate(...)");
        setContentView((View) ZeusTransformUtils.preCheckCast(r5.b(), View.class, "com.obric.aiagent.plugin"));
        final z.f r0 = new z.f();
        r5.f24583a.setOnClickListener(new $$Lambda$IslandDebugActivity$hbxug11UrmnOiAbgdHoV94ikEY(this));
        r5.f24586d.setOnClickListener(new $$Lambda$IslandDebugActivity$xtBFLkXdyyLZvJ_2W0Ttuz0afn8(r5, r0));
        r5.f24584b.setOnClickListener(new $$Lambda$IslandDebugActivity$ZRF8GLV2RiiTJUMQrTDLcZPWt3o(r0));
        r5.f24587e.setOnClickListener(new $$Lambda$IslandDebugActivity$utu34PXWDRNE3uAydar9xGB0GBg(r0, this));
        r5.f24585c.setOnClickListener(new $$Lambda$IslandDebugActivity$GlH6xBiTZKvqRWpsP44y49x7g50(r0));
    }

    private static final void onCreate$lambda$0(IslandDebugActivity r29, View r30) {
        IslandDebugActivity r0 = (IslandDebugActivity) ZeusTransformUtils.wrapperContextForParams(r29, IslandDebugActivity.class, "com.obric.aiagent.plugin");
        IslandApi r2 = ILiveCard.Companion.getInst().getIslandService();
        if (r2 == null) goto L6;
        r2.createSession(new IslandSession(null, new IslandWidget("com.obric.island_applet:action_expand_island", "{\n  \"title\": {\n    \"icon\": {\n      \"icon\": \"svg:hand_left_ai\",\n      \"width\": 20,\n      \"height\": 20\n    },\n    \"text\": {\n      \"text\": \"期待你的答复\",\n      \"textSize\": 14,\n      \"textColor\": \"#ffffffff\"\n    }\n  },\n  \"describeText\": {\n    \"text\": \"“这里是一行任务描述，如果超过，那就打个点吧”\",\n    \"textSize\": 12,\n    \"textColor\": \"#A8ffffff\"\n  },\n  \"contentText\": {\n    \"text\": \"我想问一下，就是说，你说的每天帮你剪视频是每天几点剪啊？不说具体点你叫我干活？\\n以及，这个地方，只要不超过岛的最大高度，都不要打我的点！\\n你知道吗？剪视频有多累你难道不知道吗？请你不要告诉我要每隔一个小时就要剪一个，那是会出 AI 命的你知道吗？真的请你谨慎回答我，到底是怎么个重复剪视频法，不要搞那些有的没的好吗？\",\n    \"textSize\": 16,\n    \"textColor\": \"var:ai-gradient-a3\"\n  },\n  \"actionBtn\": {\n    \"id\": \"actionBtn\",\n    \"icon\": {\n      \"icon\": \"svg:hand\",\n      \"width\": 18,\n      \"height\": 18\n    },\n    \"text\": {\n      \"text\": \"去输入\",\n      \"textSize\": 14,\n      \"textColor\": \"var:ai-gradient-a3\"\n    }\n  }\n}", true, null, null, null, null, null, null, 504, null), null, null, null, 0, null, null, null, null, 0, null, 0, 8189, null), (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void onCreate$lambda$2(com.obric.autoaction.b.a r2, final z.f r3, View r4) {
        r2.f24586d.postDelayed(new $$Lambda$IslandDebugActivity$Nh4qNDf57RiBMmOCcrmxXQAfytQ(r3), 500);
    }

    private static final void onCreate$lambda$2$lambda$1(z.f r3) {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        T r4 = r3.f38504a;
        o.a(r4);
        r0.tryExpand((IslandSession) ZeusTransformUtils.preCheckCast(r4, IslandSession.class, "com.obric.aiagent.plugin"), true);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.obric.livecard.api.entity.IslandSession] */
    private static final void onCreate$lambda$3(z.f r27, View r28) {
        Icon r11 = new Icon(24, 24, "svg:button_hand", null, null, null, null, 120, null);
        r27.f38504a = new IslandSession(CommonCollapseTemplate.create$default(new CommonCollapseTemplate(new Icon(24, 24, "svg:button_hand", null, null, null, null, 120, null), null, r11, null, 10, null), null, 1, null), null, null, null, null, 0, null, null, true, null, 0, null, 0, 7934, null);
        IslandApi r1 = ILiveCard.Companion.getInst().getIslandService();
        if (r1 == null) goto L6;
        T r0 = r27.f38504a;
        o.a(r0);
        IslandSession r2 = (IslandSession) ZeusTransformUtils.preCheckCast(r0, IslandSession.class, "com.obric.aiagent.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r1.createSession(r2, r3);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [T, com.obric.livecard.api.entity.IslandSession] */
    private static final void onCreate$lambda$7(z.f r31, IslandDebugActivity r32, View r33) {
        IslandDebugActivity r3 = (IslandDebugActivity) ZeusTransformUtils.wrapperContextForParams(r32, IslandDebugActivity.class, "com.obric.aiagent.plugin");
        IslandSession r4 = (IslandSession) ZeusTransformUtils.preCheckCast(r31.f38504a, IslandSession.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        IslandApi r5 = ILiveCard.Companion.getInst().getIslandService();
        if (r5 == null) goto L7;
        r5.destroySession(r4);
    L7:
        PendingIntent r10 = PendingIntent.getActivity((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), 0, new Intent((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), IslandDebugActivity.class), 67108864);
        IslandWidget r8 = CommonCollapseTemplate.create$default(new CommonCollapseTemplate(new Icon(24, 24, "content://com.island.local.file?pkg=com.ss.android.ugc.aweme&type=app_icon", null, null, null, null, 120, null), null, new Icon(24, 24, "svg:button_hand", null, null, null, null, 120, null), null, 10, null), null, 1, null);
        Icon r1 = new Icon(40, 40, "svg:button_hand", null, null, null, null, 120, null);
        Text r15 = new Text("任务执行中", 14, '#' + Integer.toHexString(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_3, "color", "oui_on_accent_text_3"))));
        IslandWidget r2 = new CommonExpandedTemplate(p.a(new Button(40, 40, "content://com.island.local.file?pkg=com.ss.android.ugc.aweme&type=app_icon", "app_icon", null, null, null, 112, null)), new Text("打开浏览器搜你好", 14, '#' + Integer.toHexString(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, "color", "oui_on_accent_text_1")))), r1, r15, null, 16, null).create(true);
        r2.addOnViewClickCallback("app_icon", $$Lambda$IslandDebugActivity$0_99eEqUwP0vPSagUmwhH_NDHM0.INSTANCE);
        r31.f38504a = new IslandSession(r8, r2, r10, null, null, 0, null, null, true, null, 0, null, 0, 7928, null);
        IslandApi r6 = ILiveCard.Companion.getInst().getIslandService();
        if (r6 == null) goto L11;
        T r0 = r31.f38504a;
        o.a(r0);
        IslandSession r7 = (IslandSession) ZeusTransformUtils.preCheckCast(r0, IslandSession.class, "com.obric.aiagent.plugin");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r9);
        r6.createSession(r7, r9);
        return;
    }

    private static final x onCreate$lambda$7$lambda$6$lambda$5() {
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("app_icon on click", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return x.f38692a;
    }

    private static final void onCreate$lambda$9(z.f r1, View r2) {
        IslandSession r3 = (IslandSession) ZeusTransformUtils.preCheckCast(r1.f38504a, IslandSession.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        IslandApi r4 = ILiveCard.Companion.getInst().getIslandService();
        if (r4 == null) goto L9;
        r4.destroySession(r3);
        return;
    L9:
        return;
    }
}
