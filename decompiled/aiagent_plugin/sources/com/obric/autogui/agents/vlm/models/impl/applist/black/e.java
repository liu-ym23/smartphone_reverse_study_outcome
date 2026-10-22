package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppBlackListItem.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface e {

    /* JADX INFO: compiled from: AppBlackListItem.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f27353a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f27354b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f27355c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f27356d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f27357e = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f27353a, f27354b, f27355c};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f27353a = new a("Hard", 0);
            f27354b = new a("Soft", 1);
            f27355c = new a("UserDefined", 2);
            a[] r0 = a();
            f27356d = r0;
            f27357e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f27356d.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    boolean a(c r1);

    a getType();
}
