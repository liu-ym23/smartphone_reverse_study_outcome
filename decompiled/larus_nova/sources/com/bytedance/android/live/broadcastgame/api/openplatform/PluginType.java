package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/openplatform/PluginType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LYNX", "MINI_APP", "SONIC_GAME", "UNKNOWN_TYPE", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PluginType extends Enum<PluginType> {
    public static final a Companion = null;
    public static final PluginType LYNX = null;
    public static final PluginType MINI_APP = null;
    public static final PluginType SONIC_GAME = null;
    public static final PluginType UNKNOWN_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginType[] f59391a = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static PluginType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
            String r103 = UriProtector.getQueryParameter(UriProtector.parse(r100), BdpAppEventConstant.PARAMS_TECH_TYPE);     // Catch: Throwable -> L9
            if (r103 == null) goto L6;
            Integer r104 = Integer.valueOf(CastIntegerProtector.parseInt(r103));     // Catch: Throwable -> L9
        L7:
            Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
        L12:
            if (Result.m9455isFailureimpl(r105) == false) goto L14;
            r105 = null;
        L14:
            Integer r106 = (Integer) r105;
            Object r107 = Result.m9449constructorimpl(UriProtector.parse(r100).getHost());     // Catch: Throwable -> L17
        L20:
            if (Result.m9455isFailureimpl(r107) == true) goto L23;
            r101 = r107;
        L23:
            String r108 = (String) r101;
            PluginType r109 = b(r106);
            if (r109 == null) goto L26;
        L33:
            return r109;
        L26:
            if (StringsKt.equals(AppbrandHostConstants.Micro_Host.HOST_APPBRAND, r108, true) == false) goto L30;
            return PluginType.MINI_APP;
        L30:
            if (k.a(r100) == false) goto L33;
            return PluginType.LYNX;
        L17:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        L6:
            r104 = null;
        L9:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        public static PluginType b(Integer r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            PluginType[] r101 = PluginType.values();
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L17;
            PluginType r104 = r101[r103];
            if (r104.getValue() != r100.intValue()) goto L10;
            boolean r105 = true;
        L11:
            if (r105 == true) goto L14;
            r103 = r103 + 1;
            goto L6
        L14:
            return r104;
        L10:
            r105 = false;
            goto L11
        L17:
            return null;
        }

        public static String c(PluginType r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$getNameLowerCase");
            String r101 = r100.name();
            Locale r102 = Locale.ROOT;
            if (r101 == null) goto L7;
            return r101.toLowerCase(r102);
        L7:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    static {
        PluginType r100 = new PluginType("LYNX", 0, 13);
        LYNX = r100;
        PluginType r101 = new PluginType("MINI_APP", 1, 1);
        MINI_APP = r101;
        PluginType r102 = new PluginType("SONIC_GAME", 2, 16);
        SONIC_GAME = r102;
        PluginType r103 = new PluginType("UNKNOWN_TYPE", 3, 0);
        UNKNOWN_TYPE = r103;
        f59391a = new PluginType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static PluginType valueOf(String r100) {
        return (PluginType) r27.a.a(PluginType.class, r100);
    }

    public static PluginType[] values() {
        return (PluginType[]) f59391a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PluginType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
