package com.obric.oui.swipeaction.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Attributes.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Attributes.java */
    public static final enum EnumC0996a extends Enum<EnumC0996a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0996a f36294a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0996a f36295b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ EnumC0996a[] f36296c = null;

        private EnumC0996a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0996a valueOf(String r2) {
            return (EnumC0996a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0996a.class, r2), EnumC0996a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0996a[] values() {
            return (EnumC0996a[]) ZeusTransformUtils.preCheckCast(f36296c.clone(), EnumC0996a[].class, "com.obric.aiagent.plugin");
        }

        static {
            EnumC0996a r0 = new EnumC0996a("Single", 0);
            f36294a = r0;
            EnumC0996a r1 = new EnumC0996a("Multiple", 1);
            f36295b = r1;
            f36296c = new EnumC0996a[]{r0, r1};
        }
    }
}
