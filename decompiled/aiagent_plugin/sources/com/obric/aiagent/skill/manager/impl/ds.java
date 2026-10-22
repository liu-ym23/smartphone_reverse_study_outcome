package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ds extends Enum<ds> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ds f19766b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ds f19767c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ds f19768d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ds f19769e = null;
    public static final ds f = null;
    public static final ds g = null;
    private static final /* synthetic */ ds[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final String h;

    /* JADX INFO: compiled from: SkillTrackingSchema.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final ds a(String r4) {
            d.h.b.o.e(r4, "value");
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(ds.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (d.h.b.o.a(((ds) ZeusTransformUtils.preCheckCast(r0, ds.class, "com.obric.aiagent.plugin")).a(), r4) == false) goto L4;
        L10:
            return (ds) ZeusTransformUtils.preCheckCast(r0, ds.class, "com.obric.aiagent.plugin");
        L8:
            r0 = null;
            goto L10
        }
    }

    public static d.d.a<ds> b() {
        return j;
    }

    private static final /* synthetic */ ds[] c() {
        return new ds[]{f19766b, f19767c, f19768d, f19769e, f, g};
    }

    private ds(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final String a() {
        return this.h;
    }

    static {
        f19766b = new ds("ALL_SKILLS", 0, "obric_omni_click_all_skill");
        f19767c = new ds("STORE_LIST", 1, "obric_omni_click_skill_store_list");
        f19768d = new ds("STORE_ICON", 2, "obric_omni_click_skill_store_icon");
        f19769e = new ds("MANAGEMENT_LIST_ITEM", 3, "obric_omni_click_skill_list_item");
        f = new ds("AFTER_CREATE_OR_IMPORT", 4, "obric_omni_jump_skill_detail_after_import");
        g = new ds("SKILL_LINK_DETAIL", 5, "obric_omni_click_skill_link_detail");
        ds[] r0 = c();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f19765a = new a(null);
    }

    public static ds valueOf(String r2) {
        return (ds) ZeusTransformUtils.preCheckCast(Enum.valueOf(ds.class, r2), ds.class, "com.obric.aiagent.plugin");
    }

    public static ds[] values() {
        return (ds[]) ZeusTransformUtils.preCheckCast(i.clone(), ds[].class, "com.obric.aiagent.plugin");
    }
}
