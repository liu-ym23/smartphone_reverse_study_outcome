package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum hb extends Enum<hb> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20068a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final hb f20069b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final hb f20070c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ hb[] f20071e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f20072d;

    /* JADX INFO: compiled from: SkillTrackingSchema.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final hb a(boolean r1) {
            if (r1 == false) goto L5;
            return hb.f20069b;
        L5:
            return hb.f20070c;
        }
    }

    private static final /* synthetic */ hb[] b() {
        return new hb[]{f20069b, f20070c};
    }

    private hb(String r1, int r2, String r3) {
        super(r1, r2);
        this.f20072d = r3;
    }

    public final String a() {
        return this.f20072d;
    }

    static {
        f20069b = new hb("ON", 0, "on");
        f20070c = new hb("OFF", 1, "off");
        hb[] r0 = b();
        f20071e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f20068a = new a(null);
    }

    public static hb valueOf(String r2) {
        return (hb) ZeusTransformUtils.preCheckCast(Enum.valueOf(hb.class, r2), hb.class, "com.obric.aiagent.plugin");
    }

    public static hb[] values() {
        return (hb[]) ZeusTransformUtils.preCheckCast(f20071e.clone(), hb[].class, "com.obric.aiagent.plugin");
    }
}
