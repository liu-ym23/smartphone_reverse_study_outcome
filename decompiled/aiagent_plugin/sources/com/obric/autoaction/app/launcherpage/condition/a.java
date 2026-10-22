package com.obric.autoaction.app.launcherpage.condition;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.b;

/* JADX INFO: compiled from: ConditionConstants.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f22911b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f22912c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f22913d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f22914e = null;
    private static final String f = null;
    private static final String g = null;
    private static final String h = null;
    private static final String i = null;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionConstants.kt */
    public static final enum EnumC0493a extends Enum<EnumC0493a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0493a f22915a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0493a f22916b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0493a f22917c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0493a f22918d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0493a f22919e = null;
        public static final EnumC0493a f = null;
        public static final EnumC0493a g = null;
        private static final /* synthetic */ EnumC0493a[] i = null;
        private static final /* synthetic */ d.d.a j = null;
        private final String h;

        private static final /* synthetic */ EnumC0493a[] b() {
            return new EnumC0493a[]{f22915a, f22916b, f22917c, f22918d, f22919e, f, g};
        }

        private EnumC0493a(String r1, int r2, String r3) {
            super(r1, r2);
            this.h = r3;
        }

        public final String a() {
            return this.h;
        }

        static {
            f22915a = new EnumC0493a("EVERY_DAY", 0, a.f22910a.a());
            f22916b = new EnumC0493a("EVERY_WEEK", 1, a.f22910a.b());
            f22917c = new EnumC0493a("EVERY_MONTH", 2, a.f22910a.c());
            f22918d = new EnumC0493a("EVERY_YEAR", 3, a.f22910a.d());
            f22919e = new EnumC0493a("EVERY_OFF_DAY", 4, a.f22910a.f());
            f = new EnumC0493a("EVERY_WORKDAY", 5, a.f22910a.h());
            g = new EnumC0493a("EVERY_NO", 6, a.f22910a.e());
            EnumC0493a[] r0 = b();
            i = r0;
            j = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0493a valueOf(String r2) {
            return (EnumC0493a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0493a.class, r2), EnumC0493a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0493a[] values() {
            return (EnumC0493a[]) ZeusTransformUtils.preCheckCast(i.clone(), EnumC0493a[].class, "com.obric.aiagent.plugin");
        }
    }

    private a() {
    }

    static {
        f22910a = new a();
        f22911b = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_day, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_day"), null, 1, null);
        f22912c = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_week, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_week"), null, 1, null);
        f22913d = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_month, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_month"), null, 1, null);
        f22914e = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_year, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_year"), null, 1, null);
        f = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_no, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_no"), null, 1, null);
        g = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_off_day, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_off_day"), null, 1, null);
        h = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_off_day_detail, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_off_day_detail"), null, 1, null);
        i = p.a(ZeusTransformUtils.mapRes(R.string.condition_event_every_workday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_workday"), null, 1, null);
    }

    public final String a() {
        return f22911b;
    }

    public final String b() {
        return f22912c;
    }

    public final String c() {
        return f22913d;
    }

    public final String d() {
        return f22914e;
    }

    public final String e() {
        return f;
    }

    public final String f() {
        return g;
    }

    public final String g() {
        return h;
    }

    public final String h() {
        return i;
    }
}
