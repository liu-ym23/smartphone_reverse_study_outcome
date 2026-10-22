package com.obric.autoaction.presentation.island.template;

import android.content.Context;
import android.content.res.Configuration;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.CommonExpandedTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;

/* JADX INFO: compiled from: IslandTemplateUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Context f25102b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Context f25103c = null;

    private a() {
    }

    static {
        f25101a = new a();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        f25102b = r0;
        Configuration r2 = new Configuration(ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getConfiguration());
        r2.uiMode = 32;
        f25103c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.createConfigurationContext(r2), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ String a(a r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.a(r1, r2);
    }

    public final String a(int r2, boolean r3) {
        if (r3 == false) goto L4;
        Context r1 = f25103c;
    L6:
        return '#' + Integer.toHexString(r1.getColor(r2));
    L4:
        r1 = f25102b;
        goto L6
    }

    public final String a(int r1) {
        String r0 = f25102b.getString(r1);
        o.c(r0, "getString(...)");
        return r0;
    }

    public static /* synthetic */ CommonExpandedTemplate a(a r6, String r7, String r8, String r9, String r10, Boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.a(r7, r8, r9, r10, r11);
    }

    public final CommonExpandedTemplate a(String r17, String r18, String r19, String r20, Boolean r21) {
        o.e(r17, "iconLeft");
        o.e(r18, "iconRight");
        o.e(r19, DBDefinition.TITLE);
        o.e(r20, "content");
        Icon r3 = new Icon(40, 40, r17, null, null, null, null, 120, null);
        Text r15 = new Text(r19, 16, a(this, ZeusTransformUtils.mapRes(R.color.oui_ai_a_color3_6, "color", "oui_ai_a_color3_6"), false, 2, null));
        Text r1 = new Text(r20, 14, a(this, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_2, "color", "oui_on_accent_text_2"), false, 2, null));
        return new CommonExpandedTemplate(p.a(new Button(40, 40, r18, "btn_default", r21, null, null, 96, null)), r1, r3, r15, null, 16, null);
    }

    public static /* synthetic */ CommonCollapseTemplate a(a r1, String r2, String r3, String r4, String r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = null;
    L12:
        return r1.a(r2, r3, r4, r5);
    }

    public final CommonCollapseTemplate a(String r12, String r13, String r14, String r15) {
        o.e(r12, "iconLeft");
        Icon r11 = new Icon(20, 20, r12, null, null, null, null, 120, null);
        if (r13 == null) goto L5;
        Icon r1 = new Icon(20, 20, r13, null, null, null, r15, 56, null);
    L6:
        if (r14 == null) goto L8;
        Text r2 = new Text(r14, 14, a(f25101a, ZeusTransformUtils.mapRes(R.color.oui_ai_a_color3_6, "color", "oui_ai_a_color3_6"), false, 2, null));
    L10:
        return new CommonCollapseTemplate(r1, r2, r11, null, 8, null);
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
