package com.bytedance.ai.widget;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<C0719a> f37934a = null;

    /* JADX INFO: renamed from: com.bytedance.ai.widget.a$a, reason: collision with other inner class name */
    public static final class C0719a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37937c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0719a) == true) goto L8;
            return false;
        L8:
            C0719a r101 = (C0719a) r100;
            if (Intrinsics.areEqual(this.f37935a, r101.f37935a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37936b, r101.f37936b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37937c, r101.f37937c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f37935a.hashCode() * 31) + this.f37936b.hashCode()) * 31) + this.f37937c.hashCode();
        }

        public final String toString() {
            return "WidgetDegradeSetting(appletId=" + this.f37935a + ", originalWidgetId=" + this.f37936b + ", degradeWidgetId=" + this.f37937c + ')';
        }

        public C0719a(String r100, String r101) {
            Intrinsics.checkNotNullParameter("com.flow.music.auth", IFlowAppIntentIDL.PARAM_APPLET_ID);
            Intrinsics.checkNotNullParameter(r100, "originalWidgetId");
            Intrinsics.checkNotNullParameter(r101, "degradeWidgetId");
            this.f37935a = "com.flow.music.auth";
            this.f37936b = r100;
            this.f37937c = r101;
        }
    }

    static {
        f37934a = CollectionsKt.listOf(new C0719a[]{new C0719a("widget__playlist_rx", "widget__playlist"), new C0719a("widget__single_music_rx", "widget__single_music"), new C0719a("widget__album_rx", "widget__album"), new C0719a("widget__artist_album_rx", "widget__artist_album"), new C0719a("widget__collected_music_rx", "widget__collected_music"), new C0719a("widget__collect_mix_rx", "widget__collect_mix"), new C0719a("widget__auth_card_rx", "widget__auth_card"), new C0719a("widget__auth_card_onboarding_rx", "widget__auth_card_onboarding"), new C0719a("widget__card_onboarding_tb_rx", "widget__card_onboarding_tb")});
    }

    public static String a(String r100, String r101) {
        if (r100 == null) goto L24;
        if (r101 == null) goto L24;
        Iterator<T> r102 = f37934a.iterator();
    L8:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        C0719a r104 = (C0719a) r103;
        if (Intrinsics.areEqual(r104.f37935a, r100) == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L8;
    L18:
        C0719a r106 = (C0719a) r103;
        if (r106 == null) goto L31;
        String r107 = r106.f37937c;
        if (r107 == null) goto L32;
        com.bytedance.ai.utils.g.f37637a.i("WidgetDegradeMapping", "getDegradeWidgetId: " + r101 + " -> " + r107);
        return r107;
    L32:
        return null;
    L31:
        return null;
    L12:
        if (Intrinsics.areEqual(r104.f37936b, r101) == false) goto L14;
        r105 = true;
        goto L15
    L17:
        r103 = null;
    L24:
        com.bytedance.ai.utils.g.f37637a.e("WidgetDegradeMapping", "getDegradeWidgetId: appletId or widgetId is null");
        return null;
    }
}
