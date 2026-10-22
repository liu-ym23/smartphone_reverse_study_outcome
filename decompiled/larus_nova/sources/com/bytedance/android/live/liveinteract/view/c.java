package com.bytedance.android.live.liveinteract.view;

import com.bytedance.android.livesdk.chatroom.model.h3;
import com.bytedance.android.livesdk.message.model.ok;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f79986f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f79987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f79988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f79989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f79990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f79991e;

    public static final class a {
        public a() {
        }

        public static c a(ok r100) {
            Intrinsics.checkNotNullParameter(r100, "syncData");
            c r101 = new c();
            r101.f79987a = r100.getTitle();
            String r102 = r100.getDescription();
            if (r102 == null) goto L7;
            List r103 = StringsKt.split$default(r102, new String[]{"\n"}, false, 0, 6, null);
            if (r103 == null) goto L7;
            List r104 = r103;
        L8:
            ArrayList r105 = new ArrayList(r104);
            int r106 = 1;
        L10:
            if (r106 > 6) goto L12;
            r105.add("");
            r106 = r106 + 1;
            goto L10
        L12:
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r101.f79988b = r105;
            b r107 = b(r100.getTitleStyle());
            if (r107 != null) goto L15;
            r107 = new b(18, 29);
        L15:
            r101.f79989c = r107;
            b r108 = b(r100.getDescriptionStyle());
            if (r108 != null) goto L18;
            r108 = new b(0, 31);
        L18:
            r101.f79990d = r108;
            r101.f79991e = r100.getShowId();
            return r101;
        L7:
            r104 = new ArrayList();
            goto L8
        }

        public static b b(h3 r110) {
            if (r110 != null) goto L5;
            return null;
        L5:
            long r100 = r110.getAlgin();
            if (r100 != 0) goto L9;
            int r101 = 3;
        L16:
            if (r110.getScroll() != 1) goto L18;
            boolean r111 = true;
        L19:
            long r102 = r110.getFontSize();
            String r103 = r110.getFontColor();
            if (r103 != null) goto L23;
            r103 = CustomHeaderConfig.COLOR_LIGHT;
        L23:
            return new b(r101, r102, r103, r111, r110.getScrollSpeed());
        L18:
            r111 = false;
            goto L19
        L9:
            if (r100 != 1) goto L12;
        L14:
            r101 = 17;
            goto L16
        L12:
            if (r100 != 2) goto L14;
            r101 = 5;
            goto L16
        }
    }

    static {
        f79986f = new a();
    }

    public c() {
        this.f79988b = new ArrayList();
    }
}
