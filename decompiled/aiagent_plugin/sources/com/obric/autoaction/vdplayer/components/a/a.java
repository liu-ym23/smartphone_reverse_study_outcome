package com.obric.autoaction.vdplayer.components.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.b;

/* JADX INFO: compiled from: IPanelContainerComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IPanelContainerComponent.kt */
    public static final enum EnumC0618a extends Enum<EnumC0618a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0618a f25351a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0618a f25352b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0618a f25353c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0618a[] f25354d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f25355e = null;

        private static final /* synthetic */ EnumC0618a[] a() {
            return new EnumC0618a[]{f25351a, f25352b, f25353c};
        }

        private EnumC0618a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25351a = new EnumC0618a("Bottom", 0);
            f25352b = new EnumC0618a("RightPeek", 1);
            f25353c = new EnumC0618a("RightSlideOut", 2);
            EnumC0618a[] r0 = a();
            f25354d = r0;
            f25355e = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0618a valueOf(String r2) {
            return (EnumC0618a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0618a.class, r2), EnumC0618a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0618a[] values() {
            return (EnumC0618a[]) ZeusTransformUtils.preCheckCast(f25354d.clone(), EnumC0618a[].class, "com.obric.aiagent.plugin");
        }
    }

    int a();

    boolean h_();

    boolean i_();
}
