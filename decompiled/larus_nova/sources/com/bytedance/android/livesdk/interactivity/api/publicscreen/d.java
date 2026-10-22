package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.graphics.Color;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface d {
    public static final a O0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f133399a = null;

        public a() {
        }

        static {
            f133399a = new a();
        }

        @JvmStatic
        public static d a(com.bytedance.android.live.base.model.message.t r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            if ((r100 instanceof q5) == false) goto L6;
            return new d0((q5) r100);
        L6:
            if ((r100 instanceof k0) == false) goto L15;
            k0 r101 = (k0) r100;
            if (r101.getRichDisplayText() != null) goto L32;
            if (r101.getSelfFakeRichContent() != null) goto L32;
            return new z(r101);
        L32:
            return new b0(r101);
        L15:
            if ((r100 instanceof h4) == false) goto L18;
            return new c0((h4) r100);
        L18:
            if ((r100 instanceof com.bytedance.android.live.base.model.message.r) == false) goto L21;
            return new y((com.bytedance.android.live.base.model.message.r) r100);
        L21:
            if ((r100 instanceof v0) == false) goto L24;
            return new a0((v0) r100);
        L24:
            if ((r100 instanceof c4) == false) goto L28;
            c4 r102 = (c4) r100;
            if (r102.getRoomMessageType() != 4) goto L28;
            return new e0(r102);
        L28:
            return null;
        }
    }

    public static final class b {
        public static String a(d r100) {
            if (r100.h() == false) goto L6;
            return "welcome";
        L6:
            if (r100.a() == false) goto L9;
            return "official";
        L9:
            if (r100.getMedal() == null) goto L11;
            return "medal";
        L11:
            o1 r101 = r100.getLandscapeAreaCommon();
            if (r101 != null) goto L14;
        L16:
            return "normal";
        L14:
            if (r101.isStarMessage() != true) goto L16;
            return ScoreTags.SCORE_TYPE_STAR;
        }

        public static int b(d r100) {
            List<String> r101 = r100.b();
            if (r101 == null) goto L20;
            String r102 = (String) CollectionsKt.firstOrNull(r101);
            if (r102 == null) goto L21;
            if (r102.length() != 0) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == true) goto L22;
            int r104 = Color.parseColor("#".concat(r102));     // Catch: Exception -> L17
            if (r104 != 0) goto L16;
            return -1;
        L16:
            return r104;
        L22:
            return -1;
        L9:
            r103 = false;
        L24:
            return -1;
        L21:
            return -1;
        L20:
            return -1;
        }

        public static boolean c(d r100) {
            if (r100.g() == false) goto L5;
        L8:
            return true;
        L5:
            if (r100.k() != (-1)) goto L8;
            return false;
        }

        public static boolean d(d r100) {
            o1 r101 = r100.getLandscapeAreaCommon();
            if (r101 != null) goto L5;
            return false;
        L5:
            if (r101.getShowFontColor() != true) goto L14;
            List<String> r102 = r100.b();
            if (r102 == null) goto L9;
            int r103 = r102.size();
        L10:
            if (r103 <= 1) goto L15;
            return true;
        L15:
            return false;
        L9:
            r103 = 0;
            goto L10
        L14:
            return false;
        }
    }

    static {
        O0 = a.f133399a;
    }

    boolean a();

    List<String> b();

    String d();

    String e();

    boolean f();

    boolean g();

    CharSequence getChatContent();

    com.bytedance.android.live.base.model.data.k getContentExt();

    o1 getLandscapeAreaCommon();

    j0 getMedal();

    com.bytedance.android.live.base.model.message.t getMessage();

    long getMessageId();

    int getScore();

    IBaseUser getUserInfo();

    boolean h();

    boolean i();

    boolean isSelfSendFake();

    int k();
}
