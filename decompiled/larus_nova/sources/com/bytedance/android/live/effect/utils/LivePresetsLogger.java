package com.bytedance.android.live.effect.utils;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.lynx.serval.svg.SVGRenderEngine;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LivePresetsLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f68864a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/effect/utils/LivePresetsLogger$BtnType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SAVE", "DELETE", "SELECT", "EDIT", "RESET", "CONFIRM", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BtnType extends Enum<BtnType> {
        public static final BtnType CONFIRM = null;
        public static final BtnType DELETE = null;
        public static final BtnType EDIT = null;
        public static final BtnType RESET = null;
        public static final BtnType SAVE = null;
        public static final BtnType SELECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BtnType[] f68865a = null;
        private final String value;

        static {
            BtnType r100 = new BtnType("SAVE", 0, SVGRenderEngine.SAVE);
            SAVE = r100;
            BtnType r101 = new BtnType("DELETE", 1, "delete");
            DELETE = r101;
            BtnType r102 = new BtnType("SELECT", 2, "select");
            SELECT = r102;
            BtnType r103 = new BtnType("EDIT", 3, "edit");
            EDIT = r103;
            BtnType r104 = new BtnType("RESET", 4, BasicTestActionHandler.TEST_ACTION_RESET);
            RESET = r104;
            BtnType r105 = new BtnType("CONFIRM", 5, "confirm");
            CONFIRM = r105;
            f68865a = new BtnType[]{r100, r101, r102, r103, r104, r105};
        }

        public static BtnType valueOf(String r100) {
            return (BtnType) r27.a.a(BtnType.class, r100);
        }

        public static BtnType[] values() {
            return (BtnType[]) f68865a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public BtnType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public LivePresetsLogger() {
    }

    static {
    }

    public static void c(int r100) {
        Long r101 = f68864a;
        if (r101 == null) goto L6;
        long r102 = r101.longValue();
        int r103 = (int) ((System.currentTimeMillis() - r102) / ((long) 1000));
        HashMap r104 = new HashMap();
        r104.put("title_num", String.valueOf(r100));
        r104.put("duration", String.valueOf(r103));
        c.a("livesdk_anchor_presets_leave", r104, "");
        f68864a = null;
        return;
    }

    public static void b(String r100, BtnType r101) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        Intrinsics.checkNotNullParameter(r101, "btnType");
        HashMap r102 = new HashMap();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r100);
        r102.put("btn_type", r101.getValue());
        c.a("livesdk_anchor_beautify_detail_reset_click", r102, "");
    }

    public static void a(String r100, String r101, BtnType r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = "0";
    L8:
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r103, "isDefaultValue");
        HashMap r105 = new HashMap();
        r105.put("is_default_value", r103);
        r105.put("title", r100);
        r105.put(SocialConstants.PARAM_APP_DESC, r101);
        if (r102 == null) goto L12;
        String r106 = r102.getValue();
        if (r106 == null) goto L12;
    L13:
        r105.put("btn_type", r106);
        c.a("livesdk_anchor_presets_select", r105, "");
        return;
    L12:
        r106 = "";
        goto L13
    }
}
